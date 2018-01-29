package app.department.converter;

import app.base.converter.ConverterBase;
import app.dao.entities.SysDepartment;
import app.department.model.Department;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * Created by Fan on 2018/1/23.
 */
@Component
public class DepartmentConverter extends ConverterBase<Department,SysDepartment> {

    @Override
    public Department convert2Model(SysDepartment sysDepartment) {
        Department department = new Department();
        BeanUtils.copyProperties(sysDepartment,department);
        return department;
    }

    @Override
    public SysDepartment convert2Entity(Department department) {
        SysDepartment sysDepartment = new SysDepartment();
        BeanUtils.copyProperties(department,sysDepartment);
        return sysDepartment;
    }
}
