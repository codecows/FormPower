package app.services;

import app.comn.ServiceException;
import app.model.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> getDepts();

    Department getDept(String departmentId);

    void addDept(Department department) throws ServiceException;

    void delDept(String departmentId);

    void updateDept(Department department);

    boolean exist(String departmentId);
}
