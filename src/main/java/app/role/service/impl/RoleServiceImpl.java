package app.role.service.impl;

import app.comn.ConstantPage;
import app.comn.PageModel;
import app.comn.ResponseCode;
import app.comn.ServiceException;
import app.dao.entities.SysRole;
import app.dao.entities.SysRoleExample;
import app.dao.mappers.SysRoleMapper;
import app.role.converter.RoleConverter;
import app.role.model.Role;
import app.role.service.RoleService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by real on 2018/1/27.
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Resource
    private RoleConverter roleConverter;

    @Override
    public Role getItem(String key) {
        SysRole sysRole = sysRoleMapper.selectByPrimaryKey(key);
        Role role = roleConverter.convert2Model(sysRole);
        return role;
    }

    @Override
    public List<Role> getItems() {
        List<SysRole> sysRoles = sysRoleMapper.selectByExample(null);
        List<Role> roles = roleConverter.convert2ModelList(sysRoles);
        return roles;
    }

    @Override
    public PageModel<Role> getItemsByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        SysRoleExample sysRoleExample = new SysRoleExample();

        //查询条件

        //执行查询
        Page<SysRole> sysRoles = (Page<SysRole>) sysRoleMapper.selectByExample(sysRoleExample);
        List<Role> roles = roleConverter.convert2ModelList(sysRoles);
        PageModel<Role> pageModel = new PageModel<>(roles, ConstantPage.NAVIGATE_SIZE,
                sysRoles.getPageNum(),
                sysRoles.getPageSize(),
                sysRoles.getPages(),
                sysRoles.size(),
                sysRoles.getTotal(),
                sysRoles.getStartRow()
        );
        return pageModel;
    }

    @Override
    public void addItem(Role item) throws ServiceException {
        if (recordCount(item.getRoleId()) > 0) {
            throw new ServiceException(ResponseCode.InformationExist);
        }
        SysRole sysRole = roleConverter.convert2Entity(item);

        try {
            sysRoleMapper.insertSelective(sysRole);
        } catch (DataAccessException e) {
            throw new ServiceException(ResponseCode.UnknowSqlException);
        }

    }

    @Override
    public void delItem(String key) throws ServiceException {
        if (recordCount(key) == 0) {
            throw new ServiceException(ResponseCode.InformationUnexist);
        }
        SysRoleExample sysRoleExample = new SysRoleExample();
        sysRoleExample.createCriteria().andRoleIdEqualTo(key);
        try {
            sysRoleMapper.deleteByExample(sysRoleExample);
        } catch (DataAccessException e) {
            throw new ServiceException(ResponseCode.UnknowSqlException);
        }

    }

    @Override
    public void updateItem(Role item) throws ServiceException {
        if (recordCount(item.getRoleId()) == 0) {
            throw new ServiceException(ResponseCode.InformationUnexist);
        }
        SysRole sysRole = roleConverter.convert2Entity(item);

        try {
            sysRoleMapper.updateByPrimaryKeySelective(sysRole);
        } catch (DataAccessException e) {
            throw new ServiceException(ResponseCode.UnknowSqlException);
        }

    }

    @Override
    public void addItems(List<Role> items) throws ServiceException {

        for (Role role : items) {
            addItem(role);
        }
    }

    @Override
    public void delItems(List<String> keys) throws ServiceException {

        for (String str : keys) {
            delItem(str);
        }
    }

    @Override
    public void updateItems(List<Role> items) throws ServiceException {

        for (Role role : items) {
            updateItem(role);
        }
    }

    @Override
    public long recordCount(String key) {
        SysRoleExample sysRoleExample = new SysRoleExample();
        sysRoleExample.createCriteria().andRoleIdEqualTo(key);
        long l = sysRoleMapper.countByExample(sysRoleExample);
        return l;
    }
}
