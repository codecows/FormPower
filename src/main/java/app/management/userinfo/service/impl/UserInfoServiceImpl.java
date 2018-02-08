package app.management.userinfo.service.impl;

import app.comn.ResponseCode;
import app.comn.ServiceException;
import app.dao.entities.SysUser;
import app.dao.mappers.SysUserMapper;
import app.management.department.model.Department;
import app.management.departmentinfo.converter.DepartmentInfoConverter;
import app.management.departmentinfo.entities.DepartmentInfoEntity;
import app.management.departmentinfo.mappers.DepartmentInfoMapper;
import app.management.departmentinfo.model.DepartmentInfo;
import app.management.menuinfo.model.SystemMenu;
import app.management.menuinfo.service.SystemMenuService;
import app.management.roleinfo.converter.RolePojoConverter;
import app.management.roleinfo.entities.RolePojoEntity;
import app.management.roleinfo.mappers.RoleInfoMapper;
import app.management.roleinfo.model.RolePojo;
import app.management.userinfo.converter.UserPojoConverter;
import app.management.userinfo.entities.UserPojoEntity;
import app.management.userinfo.mappers.UserPojoMapper;
import app.management.userinfo.model.UserInfo;
import app.management.userinfo.model.UserPojo;
import app.management.userinfo.service.UserInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Fan on 2018/2/2.
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private DepartmentInfoMapper departmentInfoMapper;

    @Resource
    private DepartmentInfoConverter departmentInfoConverter;

    @Resource
    private RoleInfoMapper roleInfoMapper;

    @Resource
    private RolePojoConverter rolePojoConverter;

    @Resource
    private SystemMenuService systemMenuService;

    @Resource
    private UserPojoMapper userPojoMapper;

    @Resource
    private UserPojoConverter userPojoConverter;

    @Override
    public UserInfo getItem(String userId) throws ServiceException {

        /*new UserInfo对象*/
        UserInfo userInfo = new UserInfo();

        /*分别新建集团、公司、部门对象*/
        Department group = new Department();

        Department company = new Department();

        Department department = new Department();

        /*根据用户ID查询用户信息，然后压进UserInfo对象*/

        SysUser sysUser = sysUserMapper.selectByPrimaryKey(userId);

        if (sysUser == null) {
            throw new ServiceException(ResponseCode.InformationUnexist);
        }

        BeanUtils.copyProperties(sysUser, userInfo);

        /*从departmentInfoMapper接口查出3层关系部门列表，分别压进集团、公司、部门对象*/

        List<DepartmentInfoEntity> departmentInfoEntities = departmentInfoMapper.selectByUserId(userId);


        DepartmentInfoEntity departmentInfoEntity = departmentInfoEntities.get(0);
        DepartmentInfo departmentInfo = departmentInfoConverter.convert2Model(departmentInfoEntity);

        BeanUtils.copyProperties(departmentInfo, group);

        userInfo.setGroup(group);

        DepartmentInfoEntity departmentInfoEntity1 = departmentInfoEntity.getDepartments().get(0);
        DepartmentInfo departmentInfo1 = departmentInfoConverter.convert2Model(departmentInfoEntity1);

        BeanUtils.copyProperties(departmentInfo1, company);

        userInfo.setCompany(company);

        DepartmentInfoEntity departmentInfoEntity2 = departmentInfoEntity1.getDepartments().get(0);
        DepartmentInfo departmentInfo2 = departmentInfoConverter.convert2Model(departmentInfoEntity2);

        BeanUtils.copyProperties(departmentInfo2, department);

        userInfo.setDepartment(department);

        /*从roleInfoMapper接口按UserId查出用户权限列表，压进UserInfo对象*/
        List<RolePojoEntity> rolePojoEntities = roleInfoMapper.selectByUserId(userId);

        List<RolePojo> rolePojos = rolePojoConverter.convert2ModelList(rolePojoEntities);

        userInfo.setRolePojos(rolePojos);

        /*从systemMenuService调用getItemByUserId方法，返回SystemMenu列表*/
        List<SystemMenu> itemByUserId = systemMenuService.getItemByUserId(userId, "y");

        userInfo.setSystemMenus(itemByUserId);


        return userInfo;
    }

    @Override
    public List<UserPojo> getItemsByDepartmentId(String deptId) {
        List<UserPojoEntity> userPojoEntities = userPojoMapper.selectByDeptId(deptId);

        List<UserPojo> userPojos = userPojoConverter.convert2ModelList(userPojoEntities);
        return userPojos;
    }

    @Override
    public List<UserPojo> getItemByRoleId(String roleId) {
        List<UserPojoEntity> userPojoEntities = userPojoMapper.selectByRoleId(roleId);
        List<UserPojo> userPojos = userPojoConverter.convert2ModelList(userPojoEntities);

        return userPojos;
    }
}
