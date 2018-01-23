package app.services.impl;

import app.comn.ResponseCode;
import app.comn.ServiceException;
import app.converter.DepartmentConverter;
import app.dao.entities.SysDepartment;
import app.dao.entities.SysDepartmentExample;
import app.dao.mappers.SysDepartmentMapper;
import app.model.Department;
import app.services.DepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Resource
    private SysDepartmentMapper sysDepartmentMapper;

    @Resource
    private DepartmentConverter departmentConverter;

    @Resource
    private SysDepartmentExample sysDepartmentExample;

    @Override
    public List<Department> getDepts() {
        List<SysDepartment> sysDepartments = sysDepartmentMapper.selectByExample(null);
        List<Department> departments = departmentConverter.convert2ModelList(sysDepartments);
        return departments;
    }

    @Override
    public Department getDept(String departmentId) {
        SysDepartment sysDepartment = sysDepartmentMapper.selectByPrimaryKey(departmentId);
        Department department = departmentConverter.convert2Model(sysDepartment);
        return department;
    }

    @Override
    public void addDept(Department department) throws ServiceException {
        if (exist(department.getDepartmentId())){
            throw new ServiceException(ResponseCode.DertExist);
        }
        SysDepartment sysDepartment = departmentConverter.convert2Entity(department);
        sysDepartmentMapper.insert(sysDepartment);
    }

    @Override
    public void delDept(String departmentId) {

    }

    @Override
    public void updateDept(Department department) {

    }

    @Override
    public boolean exist(String departmentId) {
        //todo 未完成，需要学习example传参
        sysDepartmentMapper.countByExample(sysDepartmentExample);
        return false;
    }
}
