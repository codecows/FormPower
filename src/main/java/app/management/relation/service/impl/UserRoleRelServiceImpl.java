package app.management.relation.service.impl;

import app.comn.ConstantPage;
import app.comn.PageModel;
import app.comn.ResponseCode;
import app.comn.ServiceException;
import app.dao.entities.SysUserRoleRel;
import app.dao.entities.SysUserRoleRelExample;
import app.dao.mappers.SysUserRoleRelMapper;
import app.management.relation.converter.UserRoleRelConverter;
import app.management.relation.model.UserRoleRel;
import app.management.relation.service.UserRoleRelService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserRoleRelServiceImpl implements UserRoleRelService {
    private final static Logger logger = LoggerFactory.getLogger(UserRoleRelServiceImpl.class);
    @Resource
    private SysUserRoleRelMapper sysUserRoleRelMapper;
    @Resource
    private UserRoleRelConverter userRoleRelConverter;


    @Override
    public UserRoleRel getItem(String key) {
        SysUserRoleRel sysUserRoleRel = sysUserRoleRelMapper.selectByPrimaryKey(key);
        UserRoleRel userRoleRel = userRoleRelConverter.convert2Model(sysUserRoleRel);
        return userRoleRel;
    }

    @Override
    public List<UserRoleRel> getItems() {

        List<SysUserRoleRel> sysUserRoleRels = sysUserRoleRelMapper.selectByExample(null);
        List<UserRoleRel> userRoleRels = userRoleRelConverter.convert2ModelList(sysUserRoleRels);
        return userRoleRels;

    }

    @Override
    public PageModel<UserRoleRel> getItemsByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        SysUserRoleRelExample sysUserRoleRelExample = new SysUserRoleRelExample();
        //查询条件

        //执行查询
        Page<SysUserRoleRel> page = (Page<SysUserRoleRel>) sysUserRoleRelMapper.selectByExample(sysUserRoleRelExample);
        List<UserRoleRel> userRoleRels = userRoleRelConverter.convert2ModelList(page);
        PageModel<UserRoleRel> pageModel = new PageModel<>(userRoleRels, ConstantPage.NAVIGATE_SIZE,
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
    public void addItem(UserRoleRel item) throws ServiceException {
        if (recordCount(item.getGuid()) > 0) {
            throw new ServiceException(ResponseCode.InformationExist);
        }
        SysUserRoleRel sysUserRoleRel = userRoleRelConverter.convert2Entity(item);

        try {
            sysUserRoleRelMapper.insertSelective(sysUserRoleRel);
        } catch (DataAccessException e) {
            throw new ServiceException(ResponseCode.UnknowSqlException);
        }

    }

    @Override
    public void delItem(String key) throws ServiceException {
        if (recordCount(key) == 0) {
            throw new ServiceException(ResponseCode.InformationUnexist);
        }
        SysUserRoleRelExample sysUserRoleRelExample = new SysUserRoleRelExample();
        sysUserRoleRelExample.createCriteria().andGuidEqualTo(key);
        try {
            sysUserRoleRelMapper.deleteByExample(sysUserRoleRelExample);
        } catch (DataAccessException e) {
            throw new ServiceException(ResponseCode.UnknowSqlException);
        }

    }

    @Override
    public void updateItem(UserRoleRel item) throws ServiceException {
        if (recordCount(item.getGuid()) == 0) {
            throw new ServiceException(ResponseCode.InformationUnexist);
        }
        SysUserRoleRel sysUserRoleRel = userRoleRelConverter.convert2Entity(item);

        try {
            sysUserRoleRelMapper.updateByPrimaryKeySelective(sysUserRoleRel);
        } catch (DataAccessException e) {
            throw new ServiceException(ResponseCode.UnknowSqlException);
        }

    }

    @Override
    public void addItems(List<UserRoleRel> items) throws ServiceException {

        for (UserRoleRel userRoleRel : items) {
            addItem(userRoleRel);
        }
    }

    @Override
    public void delItems(List<String> keys) throws ServiceException {

        for (String str : keys) {
            delItem(str);
        }
    }

    @Override
    public void updateItems(List<UserRoleRel> items) throws ServiceException {

        for (UserRoleRel userRoleRel : items) {
            updateItem(userRoleRel);
        }
    }

    @Override
    public long recordCount(String key) {
        SysUserRoleRelExample sysUserRoleRelExample = new SysUserRoleRelExample();
        sysUserRoleRelExample.createCriteria().andGuidEqualTo(key);
        long l = sysUserRoleRelMapper.countByExample(sysUserRoleRelExample);
        return l;
    }

}
