package app.management.departmentinfo.converter;

import app.base.converter.ConverterBase;
import app.management.departmentinfo.entities.DepartmentInfoEntity;
import app.management.departmentinfo.model.DepartmentInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * Created by Fan on 2018/1/23.
 */
@Component
public class DepartmentInfoConverter extends ConverterBase<DepartmentInfo, DepartmentInfoEntity> {

    @Override
    public DepartmentInfo convert2Model(DepartmentInfoEntity departmentInfoEntity) {
        DepartmentInfo departmentInfo = new DepartmentInfo();
        BeanUtils.copyProperties(departmentInfoEntity, departmentInfo);
        return departmentInfo;
    }

    @Override
    public DepartmentInfoEntity convert2Entity(DepartmentInfo departmentInfo) {
        DepartmentInfoEntity departmentInfoEntity = new DepartmentInfoEntity();
        BeanUtils.copyProperties(departmentInfo, departmentInfoEntity);
        return departmentInfoEntity;
    }
}
