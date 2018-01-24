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

    //@Resource todo 没有 @Component 注解的 不能 用自动注入标签 需要new
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
        if (deptCount(department.getDepartmentId())>0){
            throw new ServiceException(ResponseCode.InformationExist);
        }
        SysDepartment sysDepartment = departmentConverter.convert2Entity(department);
        sysDepartmentMapper.insert(sysDepartment);
    }

    @Override
    public void delDept(String departmentId) {
        SysDepartmentExample sysDepartmentExample = new SysDepartmentExample();
        SysDepartmentExample.Criteria criteria = sysDepartmentExample.createCriteria();
        criteria.andDepartmentIdEqualTo(departmentId);
        sysDepartmentMapper.deleteByExample(sysDepartmentExample);
    }

    @Override
    public void updateDept(Department department)  throws ServiceException{
        if (deptCount(department.getDepartmentId())==0){
            throw new ServiceException(ResponseCode.InformationUnexist);
        }
        SysDepartment sysDepartment = departmentConverter.convert2Entity(department);
        sysDepartmentMapper.updateByPrimaryKey(sysDepartment);

    }

    @Override
    public long deptCount(String departmentId) {
        SysDepartmentExample sysDepartmentExample = new SysDepartmentExample();
        SysDepartmentExample.Criteria criteria = sysDepartmentExample.createCriteria();
        criteria.andDepartmentIdEqualTo(departmentId);
        long l = sysDepartmentMapper.countByExample(sysDepartmentExample);
        return l;
    }

}
