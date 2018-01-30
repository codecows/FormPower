package app.management.relation.service.impl;

import app.comn.ConstantPage;
import app.comn.PageModel;
import app.comn.ResponseCode;
import app.comn.ServiceException;
import app.dao.entities.SysUserAuthRel;
import app.dao.entities.SysUserAuthRelExample;
import app.dao.mappers.SysUserAuthRelMapper;
import app.management.relation.converter.UserAuthRelConverter;
import app.management.relation.model.UserAuthRel;
import app.management.relation.service.UserAuthRelService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserAuthRelServiceImpl implements UserAuthRelService {
    private final static Logger logger = LoggerFactory.getLogger(UserAuthRelServiceImpl.class);
    @Resource
    private SysUserAuthRelMapper sysUserAuthRelMapper;
    @Resource
    private UserAuthRelConverter userAuthRelConverter;


    @Override
    public UserAuthRel getItem(String key) {
        SysUserAuthRel sysUserAuthRel = sysUserAuthRelMapper.selectByPrimaryKey(key);
        UserAuthRel userAuthRel = userAuthRelConverter.convert2Model(sysUserAuthRel);
        return userAuthRel;
    }

    @Override
    public List<UserAuthRel> getItems() {

        List<SysUserAuthRel> sysUserAuthRels = sysUserAuthRelMapper.selectByExample(null);
        List<UserAuthRel> userAuthRels = userAuthRelConverter.convert2ModelList(sysUserAuthRels);
        return userAuthRels;

    }

    @Override
    public PageModel<UserAuthRel> getItemsByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        SysUserAuthRelExample sysUserAuthRelExample = new SysUserAuthRelExample();
        //查询条件

        //执行查询
        Page<SysUserAuthRel> page = (Page<SysUserAuthRel>) sysUserAuthRelMapper.selectByExample(sysUserAuthRelExample);
        List<UserAuthRel> userAuthRels = userAuthRelConverter.convert2ModelList(page);
        PageModel<UserAuthRel> pageModel = new PageModel<>(userAuthRels, ConstantPage.NAVIGATE_SIZE,
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
    public void addItem(UserAuthRel item) throws ServiceException {
        if (recordCount(item.getGuid()) > 0) {
            throw new ServiceException(ResponseCode.InformationExist);
        }
        SysUserAuthRel sysUserAuthRel = userAuthRelConverter.convert2Entity(item);

        try {
            sysUserAuthRelMapper.insertSelective(sysUserAuthRel);
        } catch (DataAccessException e) {
            throw new ServiceException(ResponseCode.UnknowSqlException);
        }

    }

    @Override
    public void delItem(String key) throws ServiceException {
        if (recordCount(key) == 0) {
            throw new ServiceException(ResponseCode.InformationUnexist);
        }
        SysUserAuthRelExample sysUserAuthRelExample = new SysUserAuthRelExample();
        sysUserAuthRelExample.createCriteria().andGuidEqualTo(key);
        try {
            sysUserAuthRelMapper.deleteByExample(sysUserAuthRelExample);
        } catch (DataAccessException e) {
            throw new ServiceException(ResponseCode.UnknowSqlException);
        }

    }

    @Override
    public void updateItem(UserAuthRel item) throws ServiceException {
        if (recordCount(item.getGuid()) == 0) {
            throw new ServiceException(ResponseCode.InformationUnexist);
        }
        SysUserAuthRel sysUserAuthRel = userAuthRelConverter.convert2Entity(item);

        try {
            sysUserAuthRelMapper.updateByPrimaryKeySelective(sysUserAuthRel);
        } catch (DataAccessException e) {
            throw new ServiceException(ResponseCode.UnknowSqlException);
        }

    }

    @Override
    public void addItems(List<UserAuthRel> items) throws ServiceException {

        for (UserAuthRel userAuthRel : items) {
            addItem(userAuthRel);
        }
    }

    @Override
    public void delItems(List<String> keys) throws ServiceException {

        for (String str : keys) {
            delItem(str);
        }
    }

    @Override
    public void updateItems(List<UserAuthRel> items) throws ServiceException {

        for (UserAuthRel userAuthRel : items) {
            updateItem(userAuthRel);
        }
    }

    @Override
    public long recordCount(String key) {
        SysUserAuthRelExample sysUserAuthRelExample = new SysUserAuthRelExample();
        sysUserAuthRelExample.createCriteria().andGuidEqualTo(key);
        long l = sysUserAuthRelMapper.countByExample(sysUserAuthRelExample);
        return l;
    }

}
