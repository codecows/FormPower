package app.system.form.service.impl;

import app.comn.ResponseCode;
import app.comn.ServiceException;
import app.dao.entities.SysAttributeInformation;
import app.dao.entities.SysFormDef;
import app.dao.entities.SysFormDefExample;
import app.dao.entities.SysFormInformation;
import app.dao.mappers.SysAttributeInformationMapper;
import app.dao.mappers.SysFormInformationMapper;
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
    public void addItem(Form form) throws ServiceException {
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
    }

    @Override
    public void delItem(String formId) throws ServiceException {
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
    public void designForm(List<FieldInfo> fieldInfo) {

        /*
        * 循环把FieldInfo对象Copy到SysFormInformation对象，然后insertSelective
        * 循环把AttributeModel对象Copy到SysAttributeInformation对象，然后insertSelective
        * */
        for (FieldInfo f : fieldInfo) {
            SysFormInformation sysFormInformation = new SysFormInformation();
            BeanUtils.copyProperties(f, sysFormInformation);
            sysFormInformationMapper.insertSelective(sysFormInformation);
            for (AttributeModel a : f.getAttributeModels()) {
                SysAttributeInformation sysAttributeInformation = new SysAttributeInformation();
                BeanUtils.copyProperties(a, sysAttributeInformation);
                sysAttributeInformationMapper.insertSelective(sysAttributeInformation);
            }
        }
    }


}
