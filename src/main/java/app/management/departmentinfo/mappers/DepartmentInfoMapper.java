package app.management.departmentinfo.mappers;

import app.management.departmentinfo.entities.DepartmentInfoEntity;

import java.util.List;

/**
 * Created by real on 2018/2/1.
 */
public interface DepartmentInfoMapper {

    List<DepartmentInfoEntity> selectAllRecord();

    DepartmentInfoEntity selectByUserId(String userId);
}
