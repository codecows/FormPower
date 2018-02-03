package app.management.userinfo.mappers;

import app.management.userinfo.entities.UserPojoEntity;


import java.util.List;

/**
 * Created by real on 2018/2/3.
 */
public interface UserPojoMapper {

    List<UserPojoEntity> selectByDeptId(String deptId);

    List<UserPojoEntity> selectByRoleId(String roleId);

}
