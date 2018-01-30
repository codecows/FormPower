package app.management.relation.service.impl;

import app.comn.ConstantPage;
import app.comn.PageModel;
import app.comn.ResponseCode;
import app.comn.ServiceException;
import app.dao.entities.SysRoleAuthRel;
import app.dao.entities.SysRoleAuthRelExample;
import app.dao.mappers.SysRoleAuthRelMapper;
import app.management.relation.converter.RoleAuthRelConverter;
import app.management.relation.model.RoleAuthRel;
import app.management.relation.service.RoleAuthRelService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleAuthRelServiceImpl implements RoleAuthRelService {
    private final static Logger logger = LoggerFactory.getLogger(RoleAuthRelServiceImpl.class);
    @Resource
    private SysRoleAuthRelMapper sysRoleAuthRelMapper;
    @Resource
    private RoleAuthRelConverter roleAuthRelConverter;


    @Override
    public RoleAuthRel getItem(String key) {
        SysRoleAuthRel sysRoleAuthRel = sysRoleAuthRelMapper.selectByPrimaryKey(key);
        RoleAuthRel roleAuthRel = roleAuthRelConverter.convert2Model(sysRoleAuthRel);
        return roleAuthRel;
    }

    @Override
    public List<RoleAuthRel> getItems() {

        List<SysRoleAuthRel> sysRoleAuthRels = sysRoleAuthRelMapper.selectByExample(null);
        List<RoleAuthRel> roleAuthRel = roleAuthRelConverter.convert2ModelList(sysRoleAuthRels);
        return roleAuthRel;

    }

    @Override
    public PageModel<RoleAuthRel> getItemsByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        SysRoleAuthRelExample sysRoleAuthRelExample = new SysRoleAuthRelExample();
        //查询条件

        //执行查询
        Page<SysRoleAuthRel> page = (Page<SysRoleAuthRel>) sysRoleAuthRelMapper.selectByExample(sysRoleAuthRelExample);
        List<RoleAuthRel> roleAuthRel = roleAuthRelConverter.convert2ModelList(page);
        PageModel<RoleAuthRel> pageModel = new PageModel<>(roleAuthRel, ConstantPage.NAVIGATE_SIZE,
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
    public void addItem(RoleAuthRel item) throws ServiceException {
        if (recordCount(item.getGuid()) > 0) {
            throw new ServiceException(ResponseCode.InformationExist);
        }
        SysRoleAuthRel sysRoleAuthRel = roleAuthRelConverter.convert2Entity(item);

        try {
            sysRoleAuthRelMapper.insertSelective(sysRoleAuthRel);
        } catch (DataAccessException e) {
            throw new ServiceException(ResponseCode.UnknowSqlException);
        }

    }

    @Override
    public void delItem(String key) throws ServiceException {
        if (recordCount(key) == 0) {
            throw new ServiceException(ResponseCode.InformationUnexist);
        }
        SysRoleAuthRelExample sysRoleAuthRelExample = new SysRoleAuthRelExample();
        sysRoleAuthRelExample.createCriteria().andGuidEqualTo(key);
        try {
            sysRoleAuthRelMapper.deleteByExample(sysRoleAuthRelExample);
        } catch (DataAccessException e) {
            throw new ServiceException(ResponseCode.UnknowSqlException);
        }

    }

    @Override
    public void updateItem(RoleAuthRel item) throws ServiceException {
        if (recordCount(item.getGuid()) == 0) {
            throw new ServiceException(ResponseCode.InformationUnexist);
        }
        SysRoleAuthRel sysRoleAuthRel = roleAuthRelConverter.convert2Entity(item);

        try {
            sysRoleAuthRelMapper.updateByPrimaryKeySelective(sysRoleAuthRel);
        } catch (DataAccessException e) {
            throw new ServiceException(ResponseCode.UnknowSqlException);
        }

    }

    @Override
    public void addItems(List<RoleAuthRel> items) throws ServiceException {

        for (RoleAuthRel roleAuthRel : items) {
            addItem(roleAuthRel);
        }
    }

    @Override
    public void delItems(List<String> keys) throws ServiceException {

        for (String str : keys) {
            delItem(str);
        }
    }

    @Override
    public void updateItems(List<RoleAuthRel> items) throws ServiceException {

        for (RoleAuthRel roleAuthRel : items) {
            updateItem(roleAuthRel);
        }
    }

    @Override
    public long recordCount(String key) {
        SysRoleAuthRelExample sysRoleAuthRelExample = new SysRoleAuthRelExample();
        sysRoleAuthRelExample.createCriteria().andGuidEqualTo(key);
        long l = sysRoleAuthRelMapper.countByExample(sysRoleAuthRelExample);
        return l;
    }

}
