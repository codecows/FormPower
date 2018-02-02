package app.management.userinfo.service.impl;

import app.dao.entities.SysUser;
import app.dao.mappers.SysUserMapper;
import app.management.departmentinfo.converter.DepartmentInfoConverter;
import app.management.departmentinfo.entities.DepartmentInfoEntity;
import app.management.departmentinfo.mappers.DepartmentInfoMapper;
import app.management.departmentinfo.model.DepartmentInfo;
import app.management.menu.converter.MenuLevelConverter;
import app.management.menu.entities.MenuLevelEntity;
import app.management.menu.mappers.MenuLevelMapper;
import app.management.menu.model.MenuLevel;
import app.management.roleinfo.converter.RolePojoConverter;
import app.management.roleinfo.entities.RolePojoEntity;
import app.management.roleinfo.mappers.RoleInfoMapper;
import app.management.roleinfo.model.RolePojo;
import app.management.userinfo.model.UserInfo;
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
    private MenuLevelMapper menuLevelMapper;

    @Resource
    private MenuLevelConverter menuLevelConverter;

    @Override
    public UserInfo getItem(String userId) {

        UserInfo userInfo = new UserInfo();

        SysUser sysUser = sysUserMapper.selectByPrimaryKey(userId);

        BeanUtils.copyProperties(sysUser, userInfo);

        List<DepartmentInfoEntity> departmentInfoEntities = departmentInfoMapper.selectByUserId(userId);

        List<DepartmentInfo> departmentInfos = departmentInfoConverter.convert2ModelList(departmentInfoEntities);

        userInfo.setDepartmentInfos(departmentInfos);

        List<RolePojoEntity> rolePojoEntities = roleInfoMapper.selectByUserId(userId);

        List<RolePojo> rolePojos = rolePojoConverter.convert2ModelList(rolePojoEntities);

        userInfo.setRolePojos(rolePojos);

        List<MenuLevelEntity> menuLevelEntities = menuLevelMapper.selectByUserId(userId);

        List<MenuLevel> menuLevels = menuLevelConverter.convert2ModelList(menuLevelEntities);

        userInfo.setMenuLevels(menuLevels);

        return userInfo;
    }
}
