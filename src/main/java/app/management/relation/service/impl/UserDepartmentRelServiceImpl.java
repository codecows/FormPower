package app.management.relation.service.impl;

import app.comn.ConstantPage;
import app.comn.PageModel;
import app.comn.ResponseCode;
import app.comn.ServiceException;
import app.dao.entities.SysUserDepartmentRel;
import app.dao.entities.SysUserDepartmentRelExample;
import app.dao.mappers.SysUserDepartmentRelMapper;
import app.management.relation.converter.UserDepartmentRelConverter;
import app.management.relation.model.UserDepartmentRel;
import app.management.relation.service.UserDepartmentRelService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserDepartmentRelServiceImpl implements UserDepartmentRelService {
    private final static Logger logger = LoggerFactory.getLogger(UserDepartmentRelServiceImpl.class);
    @Resource
    private SysUserDepartmentRelMapper sysUserDepartmentRelMapper;
    @Resource
    private UserDepartmentRelConverter userDepartmentRelConverter;


    @Override
    public UserDepartmentRel getItem(String key) {
        SysUserDepartmentRel sysUserDepartmentRel = sysUserDepartmentRelMapper.selectByPrimaryKey(key);
        UserDepartmentRel userDepartmentRel = userDepartmentRelConverter.convert2Model(sysUserDepartmentRel);
        return userDepartmentRel;
    }

    @Override
    public List<UserDepartmentRel> getItems() {

        List<SysUserDepartmentRel> sysUserDepartmentRels = sysUserDepartmentRelMapper.selectByExample(null);
        List<UserDepartmentRel> userDepartmentRels = userDepartmentRelConverter.convert2ModelList(sysUserDepartmentRels);
        return userDepartmentRels;

    }

    @Override
    public PageModel<UserDepartmentRel> getItemsByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        SysUserDepartmentRelExample sysUserDepartmentRelExample = new SysUserDepartmentRelExample();
        //查询条件

        //执行查询
        Page<SysUserDepartmentRel> page = (Page<SysUserDepartmentRel>) sysUserDepartmentRelMapper.selectByExample(sysUserDepartmentRelExample);
        List<UserDepartmentRel> userDepartmentRels = userDepartmentRelConverter.convert2ModelList(page);
        PageModel<UserDepartmentRel> pageModel = new PageModel<>(userDepartmentRels, ConstantPage.NAVIGATE_SIZE,
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
    public void addItem(UserDepartmentRel item) throws ServiceException {
        if (recordCount(item.getGuid()) > 0) {
            throw new ServiceException(ResponseCode.InformationExist);
        }
        SysUserDepartmentRel sysUserDepartmentRel = userDepartmentRelConverter.convert2Entity(item);

        try {
            sysUserDepartmentRelMapper.insertSelective(sysUserDepartmentRel);
        } catch (DataAccessException e) {
            throw new ServiceException(ResponseCode.UnknowSqlException);
        }

    }

    @Override
    public void delItem(String key) throws ServiceException {
        if (recordCount(key) == 0) {
            throw new ServiceException(ResponseCode.InformationUnexist);
        }
        SysUserDepartmentRelExample sysUserDepartmentRelExample = new SysUserDepartmentRelExample();
        sysUserDepartmentRelExample.createCriteria().andGuidEqualTo(key);
        try {
            sysUserDepartmentRelMapper.deleteByExample(sysUserDepartmentRelExample);
        } catch (DataAccessException e) {
            throw new ServiceException(ResponseCode.UnknowSqlException);
        }

    }

    @Override
    public void updateItem(UserDepartmentRel item) throws ServiceException {
        if (recordCount(item.getGuid()) == 0) {
            throw new ServiceException(ResponseCode.InformationUnexist);
        }
        SysUserDepartmentRel sysUserDepartmentRel = userDepartmentRelConverter.convert2Entity(item);

        try {
            sysUserDepartmentRelMapper.updateByPrimaryKeySelective(sysUserDepartmentRel);
        } catch (DataAccessException e) {
            throw new ServiceException(ResponseCode.UnknowSqlException);
        }

    }

    @Override
    public void addItems(List<UserDepartmentRel> items) throws ServiceException {

        for (UserDepartmentRel userDepartmentRel : items) {
            addItem(userDepartmentRel);
        }
    }

    @Override
    public void delItems(List<String> keys) throws ServiceException {

        for (String str : keys) {
            delItem(str);
        }
    }

    @Override
    public void updateItems(List<UserDepartmentRel> items) throws ServiceException {

        for (UserDepartmentRel userDepartmentRel : items) {
            updateItem(userDepartmentRel);
        }
    }

    @Override
    public long recordCount(String key) {
        SysUserDepartmentRelExample sysUserDepartmentRelExample = new SysUserDepartmentRelExample();
        sysUserDepartmentRelExample.createCriteria().andGuidEqualTo(key);
        long l = sysUserDepartmentRelMapper.countByExample(sysUserDepartmentRelExample);
        return l;
    }

}
