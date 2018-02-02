package app.management.departmentinfo.service;

import app.management.departmentinfo.model.DepartmentInfo;

import java.util.List;

/**
 * Created by Fan on 2018/2/2.
 */
public interface DepartmentInfoService {

    List<DepartmentInfo> getItem(String userId);
}
