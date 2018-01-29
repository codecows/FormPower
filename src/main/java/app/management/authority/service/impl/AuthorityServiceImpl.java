package app.management.authority.service.impl;

import app.management.authority.converter.AuthorityConverter;
import app.management.authority.model.Authority;
import app.management.authority.service.AuthorityService;
import app.comn.ConstantPage;
import app.comn.PageModel;
import app.comn.ResponseCode;
import app.comn.ServiceException;
import app.dao.entities.SysAuthority;
import app.dao.entities.SysAuthorityExample;
import app.dao.mappers.SysAuthorityMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by real on 2018/1/25.
 */
@Service
public class AuthorityServiceImpl implements AuthorityService {
    private final static Logger logger = LoggerFactory.getLogger(AuthorityServiceImpl.class);

    @Resource
    private SysAuthorityMapper sysAuthorityMapper;

    @Resource
    private AuthorityConverter authorityConverter;

    @Override
    public Authority getItem(String key) {
        SysAuthority sysAuthority = sysAuthorityMapper.selectByPrimaryKey(key);
        Authority authority = authorityConverter.convert2Model(sysAuthority);
        return authority;
    }

    @Override
    public List<Authority> getItems() {
        List<SysAuthority> sysAuthorities = sysAuthorityMapper.selectByExample(null);
        List<Authority> authorities = authorityConverter.convert2ModelList(sysAuthorities);
        return authorities;
    }

    @Override
    public PageModel<Authority> getItemsByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        SysAuthorityExample sysAuthorityExample = new SysAuthorityExample();

        //执行查询
        Page<SysAuthority> sysAuthorities = (Page<SysAuthority>) sysAuthorityMapper.selectByExample(sysAuthorityExample);

        List<Authority> authorities = authorityConverter.convert2ModelList(sysAuthorities);

        PageModel<Authority> authorityPageModel = new PageModel<>(authorities, ConstantPage.NAVIGATE_SIZE,
                sysAuthorities.getPageNum(),
                sysAuthorities.getPageSize(),
                sysAuthorities.getPages(),
                sysAuthorities.size(),
                sysAuthorities.getTotal(),
                sysAuthorities.getStartRow());

        return authorityPageModel;
    }

    @Override
    public void addItem(Authority item) throws ServiceException {

        if (recordCount(item.getAuthId()) > 0) {
            throw new ServiceException(ResponseCode.InformationExist);
        }
        SysAuthority sysAuthority = authorityConverter.convert2Entity(item);
        try {
            sysAuthorityMapper.insertSelective(sysAuthority);
        } catch (DataAccessException e) {
            throw new ServiceException(ResponseCode.UnknowSqlException);
        }
    }

    @Override
    public void delItem(String key) throws ServiceException {

        if (recordCount(key) == 0) {
            throw new ServiceException(ResponseCode.InformationUnexist);
        }
        SysAuthorityExample sysAuthorityExample = new SysAuthorityExample();
        sysAuthorityExample.createCriteria().andAuthIdEqualTo(key);

        try {
            sysAuthorityMapper.deleteByExample(sysAuthorityExample);
        } catch (DataAccessException e) {
            throw new ServiceException(ResponseCode.UnknowSqlException);
        }
    }

    @Override
    public void updateItem(Authority item) throws ServiceException {

        if (recordCount(item.getAuthId()) == 0) {
            throw new ServiceException(ResponseCode.InformationUnexist);
        }
        SysAuthority sysAuthority = authorityConverter.convert2Entity(item);

        try {
            sysAuthorityMapper.updateByPrimaryKeySelective(sysAuthority);
        } catch (DataAccessException e) {
            throw new ServiceException(ResponseCode.UnknowSqlException);
        }
    }

    @Override
    public void addItems(List<Authority> items) throws ServiceException {

        for (Authority authority : items) {
            addItem(authority);
        }
    }

    @Override
    public void delItems(List<String> keys) throws ServiceException {

        for (String s : keys) {
            delItem(s);
        }
    }

    @Override
    public void updateItems(List<Authority> items) throws ServiceException {

        for (Authority authority : items) {
            updateItem(authority);
        }
    }

    @Override
    public long recordCount(String key) {
        SysAuthorityExample sysAuthorityExample = new SysAuthorityExample();
        sysAuthorityExample.createCriteria().andAuthIdEqualTo(key);
        long l = sysAuthorityMapper.countByExample(sysAuthorityExample);
        return l;
    }
}
