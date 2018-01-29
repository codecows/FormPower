package app.user.service;

import app.comn.ConstantPage;
import app.comn.PageModel;
import app.comn.ResponseCode;
import app.comn.ServiceException;
import app.user.converter.UserConverter;
import app.dao.entities.SysUser;
import app.dao.entities.SysUserExample;
import app.dao.mappers.SysUserMapper;
import app.user.model.User;
import app.user.service.impl.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private SysUserMapper sysUserMapper;
    @Resource
    private UserConverter userConverter;

    @Override
    public User getItem(String key) {
        SysUser sysUser = sysUserMapper.selectByPrimaryKey(key);
        User user = userConverter.convert2Model(sysUser);

        return user;
    }

    @Override
    public List<User> getItems() {
        List<SysUser> sysUsers = sysUserMapper.selectByExample(null);
        List<User> users = userConverter.convert2ModelList(sysUsers);
        return users;
    }

    @Override
    public PageModel<User> getItemsByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        SysUserExample sysUserExample = new SysUserExample();

        Page<SysUser> sysUsers = (Page<SysUser>) sysUserMapper.selectByExample(sysUserExample);
        List<User> users = userConverter.convert2ModelList(sysUsers);

        PageModel<User> userPageModel = new PageModel<>(users, ConstantPage.NAVIGATE_SIZE,
                sysUsers.getPageNum(),
                sysUsers.getPageSize(),
                sysUsers.getPages(),
                sysUsers.size(),
                sysUsers.getTotal(),
                sysUsers.getStartRow());

        return userPageModel;
    }

    @Override
    public void addItem(User item) throws ServiceException {
        if (recordCount(item.getUserId()) > 0) {
            throw new ServiceException(ResponseCode.InformationExist);
        }
        SysUser sysUser = userConverter.convert2Entity(item);
        try {
            sysUserMapper.insertSelective(sysUser);
        } catch (DataAccessException e) {
            throw new ServiceException(ResponseCode.UnknowSqlException);
        }

    }

    @Override
    public void delItem(String key) throws ServiceException {
        if (recordCount(key) == 0) {
            throw new ServiceException(ResponseCode.InformationUnexist);
        }
        SysUserExample sysUserExample = new SysUserExample();
        sysUserExample.createCriteria().andUserIdEqualTo(key);

        try {
            sysUserMapper.deleteByExample(sysUserExample);
        } catch (DataAccessException e) {
            throw new ServiceException(ResponseCode.UnknowSqlException);
        }

    }

    @Override
    public void updateItem(User item) throws ServiceException {
        if (recordCount(item.getUserId()) == 0) {
            throw new ServiceException(ResponseCode.InformationUnexist);
        }
        SysUser sysUser = userConverter.convert2Entity(item);

        try {
            sysUserMapper.updateByPrimaryKeySelective(sysUser);
        } catch (DataAccessException e) {
            throw new ServiceException(ResponseCode.UnknowSqlException);
        }

    }

    @Override
    public void addItems(List<User> items) throws ServiceException {
        for (User user : items) {
            addItem(user);
        }

    }

    @Override
    public void delItems(List<String> keys) throws ServiceException {
        for (String k : keys) {
            delItem(k);
        }

    }

    @Override
    public void updateItems(List<User> items) throws ServiceException {
        for (User user : items) {
            updateItem(user);
        }

    }

    @Override
    public long recordCount(String key) {
        SysUserExample sysUserExample = new SysUserExample();
        sysUserExample.createCriteria().andUserIdEqualTo(key);
        long l = sysUserMapper.countByExample(sysUserExample);
        return l;
    }
}
