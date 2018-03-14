package app.system.form.service.impl;

import app.comn.ResponseCode;
import app.comn.ServiceException;
import app.dao.entities.SysAttributeInformation;
import app.dao.entities.SysFormDef;
import app.dao.entities.SysFormDefExample;
import app.dao.entities.SysFormInformation;
import app.dao.mappers.SysAttributeInformationMapper;
import app.dao.mappers.SysFormInformationMapper;
import app.system.auto.entities.SysBaseTabEntity;
import app.system.auto.model.BaseColumnModel;
import app.system.auto.service.BaseOperationService;
import app.system.auto.service.BaseTableTmplService;
import app.system.form.converter.FormConverter;
import app.system.form.entities.FieldInfoEntity;
import app.system.form.mappers.FieldInfoMapper;
import app.system.form.mappers.FormDefMapper;
import app.system.form.model.AttributeModel;
import app.system.form.model.FieldInfo;
import app.system.form.model.Form;
import app.system.form.service.FormService;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by real on 2018/2/24.
 */
@Service
public class FormServiceImpl implements FormService {

    @Resource
    private FormDefMapper formDefMapper;

    @Resource
    private FormConverter formConverter;

    @Resource
    private FieldInfoMapper fieldInfoMapper;

    @Resource
    private SysFormInformationMapper sysFormInformationMapper;

    @Resource
    private SysAttributeInformationMapper sysAttributeInformationMapper;

    @Resource
    private BaseTableTmplService baseTableTmplService;

    @Resource
    private BaseOperationService baseOperationService;



    @Override
    public List<Form> getItems() {
        List<SysFormDef> formDefEntities = formDefMapper.selectAll();
        List<Form> forms = formConverter.convert2ModelList(formDefEntities);
        return forms;
    }

    @Override
    public List<Form> getItemsByPage(int start, int length) {

        List<SysFormDef> formDefEntities = formDefMapper.selectByPage(start, length);
        List<Form> forms = formConverter.convert2ModelList(formDefEntities);
        return forms;
    }

    @Override
    public void createForm(Form form) throws ServiceException {

        /**
         * 在formdef表中增加数据
         * */
        SysFormDefExample sysFormDefExample = new SysFormDefExample();
        sysFormDefExample.createCriteria().andFormIdEqualTo(form.getFormId());

        if (formDefMapper.countByExample(sysFormDefExample) > 0) {
            throw new ServiceException(ResponseCode.InformationExist);
        }
        SysFormDef sysFormDef = formConverter.convert2Entity(form);

        try {
            formDefMapper.insertSelective(sysFormDef);
        } catch (DataAccessException e) {
            throw new ServiceException(ResponseCode.UnknowSqlException);
        }

        /**
         * 创建基础表
         * */
        String tablename = "auto_t_" + form.getFormId();
        String comment = form.getFormName();
        List<SysBaseTabEntity> base_tab = baseTableTmplService.getTableBody("base_tab");

        ArrayList<BaseColumnModel> baseColumnModels = new ArrayList<>();
        for (SysBaseTabEntity sysBaseTabEntity : base_tab) {
            BaseColumnModel baseColumnModel = new BaseColumnModel();
            BeanUtils.copyProperties(sysBaseTabEntity, baseColumnModel);
            baseColumnModels.add(baseColumnModel);
        }

        baseOperationService.createTable(tablename, comment, baseColumnModels);
    }

    @Override
    public void dropForm(String formId) throws ServiceException {

        /**
         * 删除formdef表中的信息
         * */
        SysFormDefExample sysFormDefExample = new SysFormDefExample();
        sysFormDefExample.createCriteria().andFormIdEqualTo(formId);

        if (formDefMapper.countByExample(sysFormDefExample) == 0) {
            throw new ServiceException(ResponseCode.InformationUnexist);
        }

        try {
            formDefMapper.deleteByPrimaryKey(formId);
        } catch (DataAccessException e) {
            throw new ServiceException(ResponseCode.UnknowSqlException);
        }

        /**
         * 删除数据表
         * */
        String tablename = "auto_t_" + formId;

        baseOperationService.dropTable(tablename);
    }

    @Override
    public List<FieldInfo> selectFieldByFormId(String formId) {
        List<FieldInfoEntity> itemsByFormId = fieldInfoMapper.getItemsByFormId(formId);

//        将物理实体转换为业务实体
        ArrayList<FieldInfo> fieldInfos = new ArrayList<>();
        for (FieldInfoEntity fieldInfoEntity : itemsByFormId) {
            ArrayList<AttributeModel> attributeModels = new ArrayList<>();
            FieldInfo fieldInfo = new FieldInfo();
            BeanUtils.copyProperties(fieldInfoEntity, fieldInfo);
            for (SysAttributeInformation sysAttributeInformation : fieldInfoEntity.getSysAttributeInformations()) {
                AttributeModel attributeModel = new AttributeModel();
                BeanUtils.copyProperties(sysAttributeInformation, attributeModel);
                attributeModels.add(attributeModel);
            }
            fieldInfo.setAttributeModels(attributeModels);
            fieldInfos.add(fieldInfo);
        }
        return fieldInfos;
    }

    @Override
    public void designForm(List<FieldInfo> fieldInfo) throws ServiceException {

        /**
         * 循环把FieldInfo对象Copy到SysFormInformation对象，然后insertSelective
         * 循环把AttributeModel对象Copy到SysAttributeInformation对象，然后insertSelective
         *修改基础表，增加新字段
         *  */
        String tableName = null;

        ArrayList<BaseColumnModel> baseColumnModels = new ArrayList<>();
        for (FieldInfo f : fieldInfo) {
            SysFormInformation sysFormInformation = new SysFormInformation();
            BeanUtils.copyProperties(f, sysFormInformation);
            /**
             * 提取表名
             * **/
            if (tableName == null) {
                tableName = "auto_t_" + f.getFormId();
            }
            BaseColumnModel baseColumnModel = new BaseColumnModel();

            for (AttributeModel a : f.getAttributeModels()) {
                SysAttributeInformation sysAttributeInformation = new SysAttributeInformation();
                BeanUtils.copyProperties(a, sysAttributeInformation);
                try {
                    sysAttributeInformationMapper.insertSelective(sysAttributeInformation);
                } catch (DataAccessException e) {
                    throw new ServiceException(ResponseCode.UnknowSqlException);
                }

                switch (a.getAttributeCode()) {
                    case "fieldcode":
                        baseColumnModel.setTabColumn(a.getAttributeValue());
                        break;
                    case "fieldtype":
                        baseColumnModel.setTabColType(a.getAttributeValue());
                        break;
                    case "length":
                        baseColumnModel.setTabColLength(Integer.valueOf(a.getAttributeValue()));
                        break;
                    case "smalllength":
                        baseColumnModel.setTabColSmall(Integer.valueOf(a.getAttributeValue()));
                        break;
                    case "fieldname":
                        baseColumnModel.setComment(a.getAttributeValue());
                        break;
                }
            }
            try {
                sysFormInformationMapper.insertSelective(sysFormInformation);
            } catch (DataAccessException e) {
                throw new ServiceException(ResponseCode.UnknowSqlException);
            }
            baseColumnModels.add(baseColumnModel);
        }

        baseOperationService.addColumn(tableName, baseColumnModels);
    }

    @Override
    public List<FieldInfo> fatchFormDesignInformation(String formId) {
        List<FieldInfoEntity> itemsByFormId = fieldInfoMapper.getItemsByFormId(formId);

        ArrayList<FieldInfo> fieldInfos = new ArrayList<>();
        for (FieldInfoEntity f : itemsByFormId) {
            FieldInfo fieldInfo = new FieldInfo();
            BeanUtils.copyProperties(f, fieldInfo);
            ArrayList<AttributeModel> attributeModels = new ArrayList<>();
            for (SysAttributeInformation a : f.getSysAttributeInformations()) {
                AttributeModel attributeModel = new AttributeModel();
                BeanUtils.copyProperties(a, attributeModel);
                attributeModels.add(attributeModel);
            }
            fieldInfo.setAttributeModels(attributeModels);
            fieldInfos.add(fieldInfo);
        }
        return fieldInfos;
    }

}
