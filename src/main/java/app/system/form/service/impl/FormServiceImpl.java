package app.system.form.service.impl;

import app.comn.ResponseCode;
import app.comn.ServiceException;
import app.dao.entities.*;
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
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 60, rollbackFor = ServiceException.class)
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
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 60, rollbackFor = ServiceException.class)
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
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 60, rollbackFor = ServiceException.class)
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
                /**
                 * 判断记录是否存在，如果存在则更新，不存在，则插入新信息。
                 * **/
                SysAttributeInformationExample sysAttributeInformationExample = new SysAttributeInformationExample();
                sysAttributeInformationExample.createCriteria().andIdEqualTo(sysAttributeInformation.getId());
                if (sysAttributeInformationMapper.countByExample(sysAttributeInformationExample) > 0) {
                    try {
                        sysAttributeInformationMapper.updateByPrimaryKeySelective(sysAttributeInformation);
                    } catch (DataAccessException e) {
                        throw new ServiceException(ResponseCode.UnknowSqlException);
                    }
                } else {
                    try {
                        sysAttributeInformationMapper.insertSelective(sysAttributeInformation);
                    } catch (DataAccessException e) {
                        throw new ServiceException(ResponseCode.UnknowSqlException);
                    }
                }

                /**
                 * 筛选出属性中，关于建表的属性值，set到columnmodel中
                 * **/
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
            /**
             * 如果列存在则更新，否者新增。
             * **/
            SysFormInformationExample sysFormInformationExample = new SysFormInformationExample();
            sysFormInformationExample.createCriteria().andIdEqualTo(sysFormInformation.getId());
            if (sysFormInformationMapper.countByExample(sysFormInformationExample) > 0) {
                try {
                    sysFormInformationMapper.updateByPrimaryKeySelective(sysFormInformation);
                } catch (DataAccessException e) {
                    throw new ServiceException(ResponseCode.UnknowSqlException);
                }
            } else {
                try {
                    sysFormInformationMapper.insertSelective(sysFormInformation);
                } catch (DataAccessException e) {
                    throw new ServiceException(ResponseCode.UnknowSqlException);
                }
                /**
                 * 将列对象插入列表中
                 * **/
                baseColumnModels.add(baseColumnModel);
            }
        }

        /**
         * 列列表不为空使执行插入字段操作
         * **/
        if (!baseColumnModels.isEmpty()) {
            baseOperationService.addColumn(tableName, baseColumnModels);
        }

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
