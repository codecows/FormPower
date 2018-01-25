package app.services.impl;

import app.comn.ConstantPage;
import app.comn.PageModel;
import app.comn.ResponseCode;
import app.comn.ServiceException;
import app.converter.DepartmentConverter;
import app.dao.entities.SysDepartment;
import app.dao.entities.SysDepartmentExample;
import app.dao.mappers.SysDepartmentMapper;
import app.model.Department;
import app.services.DepartmentService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final static Logger logger = LoggerFactory.getLogger(DepartmentServiceImpl.class);
    @Resource
    private SysDepartmentMapper sysDepartmentMapper;

    @Resource
    private DepartmentConverter departmentConverter;


    @Override
    public Department getItem(String key) {
        SysDepartment sysDepartment = sysDepartmentMapper.selectByPrimaryKey(key);
        Department department = departmentConverter.convert2Model(sysDepartment);
        return department;
    }

    @Override
    public List<Department> getItems() {
        List<SysDepartment> sysDepartments = sysDepartmentMapper.selectByExample(null);
        List<Department> departments = departmentConverter.convert2ModelList(sysDepartments);
        return departments;
    }

    @Override
    public PageModel<Department> getItemsByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        SysDepartmentExample sysDepartmentExample = new SysDepartmentExample();

        //执行查询
        Page<SysDepartment> departments1 = (Page<SysDepartment>) sysDepartmentMapper.selectByExample(sysDepartmentExample);

        List<Department> departments = departmentConverter.convert2ModelList(departments1);

        PageModel<Department> departmentPageModel = new PageModel<>(departments, ConstantPage.NAVIGATE_SIZE,
                departments1.getPageNum(),
                departments1.getPageSize(),
                departments1.getPages(),
                departments1.size(),
                departments1.getTotal(),
                departments1.getStartRow());
        return departmentPageModel;
    }

    @Override
    public void addItem(Department item) throws ServiceException {
        if (recordCount(item.getDepartmentId()) > 0) {
            throw new ServiceException(ResponseCode.InformationExist);
        }
        SysDepartment sysDepartment = departmentConverter.convert2Entity(item);
        sysDepartmentMapper.insert(sysDepartment);
    }

    @Override
    public void delItem(String key) throws ServiceException {
        if (recordCount(key) == 0) {
            throw new ServiceException(ResponseCode.InformationUnexist);
        }
        SysDepartmentExample sysDepartmentExample = new SysDepartmentExample();
        SysDepartmentExample.Criteria criteria = sysDepartmentExample.createCriteria();
        criteria.andDepartmentIdEqualTo(key);
        sysDepartmentMapper.deleteByExample(sysDepartmentExample);
    }

    @Override
    public void updateItem(Department item) throws ServiceException {
        if (recordCount(item.getDepartmentId()) == 0) {
            throw new ServiceException(ResponseCode.InformationUnexist);
        }
        SysDepartment sysDepartment = departmentConverter.convert2Entity(item);
        sysDepartmentMapper.updateByPrimaryKey(sysDepartment);

    }

    @Override
    public void addItems(List<Department> items) throws ServiceException {

        for (Department dep : items) {
            addItem(dep);
        }
    }

    @Override
    public void delItems(List<String> keys) throws ServiceException {

        for (String k : keys) {
            delItem(k);
        }

    }

    @Override
    public void updateItems(List<Department> items) throws ServiceException {

        for (Department dept : items) {
            updateItem(dept);
        }

    }

    @Override
    public long recordCount(String key) {
        SysDepartmentExample sysDepartmentExample = new SysDepartmentExample();
        SysDepartmentExample.Criteria criteria = sysDepartmentExample.createCriteria();
        criteria.andDepartmentIdEqualTo(key);
        long l = sysDepartmentMapper.countByExample(sysDepartmentExample);
        return l;
    }

}
