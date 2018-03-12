package app.system.form.service.impl;

import app.dao.entities.SysAttributeInformation;
import app.system.form.entities.FieldInfoEntity;
import app.system.form.mappers.FieldInfoMapper;
import app.system.form.model.AttributeModel;
import app.system.form.model.FieldInfo;
import app.system.form.model.FieldModel;
import app.system.form.service.FieldInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by real on 2018/3/12.
 */
@Service
public class FieldInfoServiceImpl implements FieldInfoService {

    @Resource
    private FieldInfoMapper fieldInfoMapper;

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
}
