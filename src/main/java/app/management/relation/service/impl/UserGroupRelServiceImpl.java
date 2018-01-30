package app.management.relation.service.impl;

import app.comn.ConstantPage;
import app.comn.PageModel;
import app.comn.ResponseCode;
import app.comn.ServiceException;
import app.dao.entities.SysUserGroupRel;
import app.dao.entities.SysUserGroupRelExample;
import app.dao.mappers.SysUserGroupRelMapper;
import app.management.relation.converter.UserGroupRelConverter;
import app.management.relation.model.UserGroupRel;
import app.management.relation.service.UserGroupRelService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserGroupRelServiceImpl implements UserGroupRelService {
    private final static Logger logger = LoggerFactory.getLogger(UserGroupRelServiceImpl.class);
    @Resource
    private SysUserGroupRelMapper sysUserGroupRelMapper;
    @Resource
    private UserGroupRelConverter userGroupRelConverter;


    @Override
    public UserGroupRel getItem(String key) {
        SysUserGroupRel sysUserGroupRel = sysUserGroupRelMapper.selectByPrimaryKey(key);
        UserGroupRel userGroupRel = userGroupRelConverter.convert2Model(sysUserGroupRel);
        return userGroupRel;
    }

    @Override
    public List<UserGroupRel> getItems() {

        List<SysUserGroupRel> sysUserGroupRels = sysUserGroupRelMapper.selectByExample(null);
        List<UserGroupRel> userGroupRels = userGroupRelConverter.convert2ModelList(sysUserGroupRels);
        return userGroupRels;

    }

    @Override
    public PageModel<UserGroupRel> getItemsByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        SysUserGroupRelExample sysUserGroupRelExample = new SysUserGroupRelExample();
        //查询条件

        //执行查询
        Page<SysUserGroupRel> page = (Page<SysUserGroupRel>) sysUserGroupRelMapper.selectByExample(sysUserGroupRelExample);
        List<UserGroupRel> userGroupRels = userGroupRelConverter.convert2ModelList(page);
        PageModel<UserGroupRel> pageModel = new PageModel<>(userGroupRels, ConstantPage.NAVIGATE_SIZE,
                page.getPageNum(),
                page.getPageSize(),
                page.getPages(),
                page.size(),
                page.getTotal(),
                page.getStartRow()
        );
        return pageModel;
    }

    @Override
    public void addItem(UserGroupRel item) throws ServiceException {
        if (recordCount(item.getGuid()) > 0) {
            throw new ServiceException(ResponseCode.InformationExist);
        }
        SysUserGroupRel sysUserGroupRel = userGroupRelConverter.convert2Entity(item);

        try {
            sysUserGroupRelMapper.insertSelective(sysUserGroupRel);
        } catch (DataAccessException e) {
            throw new ServiceException(ResponseCode.UnknowSqlException);
        }

    }

    @Override
    public void delItem(String key) throws ServiceException {
        if (recordCount(key) == 0) {
            throw new ServiceException(ResponseCode.InformationUnexist);
        }
        SysUserGroupRelExample sysUserGroupRelExample = new SysUserGroupRelExample();
        sysUserGroupRelExample.createCriteria().andGuidEqualTo(key);
        try {
            sysUserGroupRelMapper.deleteByExample(sysUserGroupRelExample);
        } catch (DataAccessException e) {
            throw new ServiceException(ResponseCode.UnknowSqlException);
        }

    }

    @Override
    public void updateItem(UserGroupRel item) throws ServiceException {
        if (recordCount(item.getGuid()) == 0) {
            throw new ServiceException(ResponseCode.InformationUnexist);
        }
        SysUserGroupRel sysUserGroupRel = userGroupRelConverter.convert2Entity(item);

        try {
            sysUserGroupRelMapper.updateByPrimaryKeySelective(sysUserGroupRel);
        } catch (DataAccessException e) {
            throw new ServiceException(ResponseCode.UnknowSqlException);
        }

    }

    @Override
    public void addItems(List<UserGroupRel> items) throws ServiceException {

        for (UserGroupRel userGroupRel : items) {
            addItem(userGroupRel);
        }
    }

    @Override
    public void delItems(List<String> keys) throws ServiceException {

        for (String str : keys) {
            delItem(str);
        }
    }

    @Override
    public void updateItems(List<UserGroupRel> items) throws ServiceException {

        for (UserGroupRel userGroupRel : items) {
            updateItem(userGroupRel);
        }
    }

    @Override
    public long recordCount(String key) {
        SysUserGroupRelExample sysUserGroupRelExample = new SysUserGroupRelExample();
        sysUserGroupRelExample.createCriteria().andGuidEqualTo(key);
        long l = sysUserGroupRelMapper.countByExample(sysUserGroupRelExample);
        return l;
    }

}
