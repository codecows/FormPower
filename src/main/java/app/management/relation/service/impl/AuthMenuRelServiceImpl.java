package app.management.relation.service.impl;

import app.comn.ConstantPage;
import app.comn.PageModel;
import app.comn.ResponseCode;
import app.comn.ServiceException;
import app.dao.entities.SysAuthMenuRel;
import app.dao.entities.SysAuthMenuRelExample;
import app.dao.mappers.SysAuthMenuRelMapper;
import app.management.relation.converter.AuthMenuRelConverter;
import app.management.relation.model.AuthMenuRel;
import app.management.relation.service.AuthMenuRelService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AuthMenuRelServiceImpl implements AuthMenuRelService {
    private final static Logger logger = LoggerFactory.getLogger(AuthMenuRelServiceImpl.class);
    @Resource
    private SysAuthMenuRelMapper sysAuthMenuRelMapper;
    @Resource
    private AuthMenuRelConverter authMenuRelConverter;


    @Override
    public AuthMenuRel getItem(String key) {
        SysAuthMenuRel sysAuthMenuRel = sysAuthMenuRelMapper.selectByPrimaryKey(key);
        AuthMenuRel authMenuRel = authMenuRelConverter.convert2Model(sysAuthMenuRel);
        return authMenuRel;
    }

    @Override
    public List<AuthMenuRel> getItems() {

        List<SysAuthMenuRel> sysAuthMenuRels = sysAuthMenuRelMapper.selectByExample(null);
        List<AuthMenuRel> authMenuRel = authMenuRelConverter.convert2ModelList(sysAuthMenuRels);
        return authMenuRel;

    }

    @Override
    public PageModel<AuthMenuRel> getItemsByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        SysAuthMenuRelExample sysAuthMenuRelExample = new SysAuthMenuRelExample();
        //查询条件

        //执行查询
        Page<SysAuthMenuRel> page = (Page<SysAuthMenuRel>) sysAuthMenuRelMapper.selectByExample(sysAuthMenuRelExample);
        List<AuthMenuRel> authMenuRel = authMenuRelConverter.convert2ModelList(page);
        PageModel<AuthMenuRel> pageModel = new PageModel<>(authMenuRel, ConstantPage.NAVIGATE_SIZE,
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
    public void addItem(AuthMenuRel item) throws ServiceException {
        if (recordCount(item.getGuid()) > 0) {
            throw new ServiceException(ResponseCode.InformationExist);
        }
        SysAuthMenuRel sysAuthMenuRel = authMenuRelConverter.convert2Entity(item);

        try {
            sysAuthMenuRelMapper.insertSelective(sysAuthMenuRel);
        } catch (DataAccessException e) {
            throw new ServiceException(ResponseCode.UnknowSqlException);
        }

    }

    @Override
    public void delItem(String key) throws ServiceException {
        if (recordCount(key) == 0) {
            throw new ServiceException(ResponseCode.InformationUnexist);
        }
        SysAuthMenuRelExample sysAuthMenuRelExample = new SysAuthMenuRelExample();
        sysAuthMenuRelExample.createCriteria().andGuidEqualTo(key);
        try {
            sysAuthMenuRelMapper.deleteByExample(sysAuthMenuRelExample);
        } catch (DataAccessException e) {
            throw new ServiceException(ResponseCode.UnknowSqlException);
        }

    }

    @Override
    public void updateItem(AuthMenuRel item) throws ServiceException {
        if (recordCount(item.getGuid()) == 0) {
            throw new ServiceException(ResponseCode.InformationUnexist);
        }
        SysAuthMenuRel sysAuthMenuRel = authMenuRelConverter.convert2Entity(item);

        try {
            sysAuthMenuRelMapper.updateByPrimaryKeySelective(sysAuthMenuRel);
        } catch (DataAccessException e) {
            throw new ServiceException(ResponseCode.UnknowSqlException);
        }

    }

    @Override
    public void addItems(List<AuthMenuRel> items) throws ServiceException {

        for (AuthMenuRel authMenuRel : items) {
            addItem(authMenuRel);
        }
    }

    @Override
    public void delItems(List<String> keys) throws ServiceException {

        for (String str : keys) {
            delItem(str);
        }
    }

    @Override
    public void updateItems(List<AuthMenuRel> items) throws ServiceException {

        for (AuthMenuRel authMenuRel : items) {
            updateItem(authMenuRel);
        }
    }

    @Override
    public long recordCount(String key) {
        SysAuthMenuRelExample sysAuthMenuRelExample = new SysAuthMenuRelExample();
        sysAuthMenuRelExample.createCriteria().andGuidEqualTo(key);
        long l = sysAuthMenuRelMapper.countByExample(sysAuthMenuRelExample);
        return l;
    }

}
