package app.management.userinfo.service;

import app.comn.ServiceException;
import app.management.userinfo.model.UserInfo;
import app.management.userinfo.model.UserPojo;

import java.util.List;

/**
 * Created by Fan on 2018/2/2.
 */
public interface UserInfoService {

    UserInfo getItem(String userId) throws ServiceException;

    List<UserPojo> getItemsByDepartmentId(String deptId);

    List<UserPojo> getItemByRoleId(String roleId);
}
