package app.management.relation.service.impl;

import app.comn.ConstantPage;
import app.comn.PageModel;
import app.comn.ResponseCode;
import app.comn.ServiceException;
import app.dao.entities.SysGroupRoleRel;
import app.dao.entities.SysGroupRoleRelExample;
import app.dao.mappers.SysGroupRoleRelMapper;
import app.management.relation.converter.GroupRoleRelConverter;
import app.management.relation.model.GroupRoleRel;
import app.management.relation.service.GroupRoleRelService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GroupRoleRelServiceImpl implements GroupRoleRelService {
    private final static Logger logger = LoggerFactory.getLogger(GroupRoleRelServiceImpl.class);
    @Resource
    private SysGroupRoleRelMapper sysGroupRoleRelMapper;
    @Resource
    private GroupRoleRelConverter groupRoleRelConverter;


    @Override
    public GroupRoleRel getItem(String key) {
        SysGroupRoleRel sysGroupRoleRel = sysGroupRoleRelMapper.selectByPrimaryKey(key);
        GroupRoleRel groupRoleRel = groupRoleRelConverter.convert2Model(sysGroupRoleRel);
        return groupRoleRel;
    }

    @Override
    public List<GroupRoleRel> getItems() {

        List<SysGroupRoleRel> sysGroupRoleRels = sysGroupRoleRelMapper.selectByExample(null);
        List<GroupRoleRel> groupRoleRel = groupRoleRelConverter.convert2ModelList(sysGroupRoleRels);
        return groupRoleRel;

    }

    @Override
    public PageModel<GroupRoleRel> getItemsByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        SysGroupRoleRelExample sysGroupRoleRelExample = new SysGroupRoleRelExample();
        //查询条件

        //执行查询
        Page<SysGroupRoleRel> page = (Page<SysGroupRoleRel>) sysGroupRoleRelMapper.selectByExample(sysGroupRoleRelExample);
        List<GroupRoleRel> groupRoleRel = groupRoleRelConverter.convert2ModelList(page);
        PageModel<GroupRoleRel> pageModel = new PageModel<>(groupRoleRel, ConstantPage.NAVIGATE_SIZE,
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
    public void addItem(GroupRoleRel item) throws ServiceException {
        if (recordCount(item.getGuid()) > 0) {
            throw new ServiceException(ResponseCode.InformationExist);
        }
        SysGroupRoleRel sysGroupRoleRel = groupRoleRelConverter.convert2Entity(item);

        try {
            sysGroupRoleRelMapper.insertSelective(sysGroupRoleRel);
        } catch (DataAccessException e) {
            throw new ServiceException(ResponseCode.UnknowSqlException);
        }

    }

    @Override
    public void delItem(String key) throws ServiceException {
        if (recordCount(key) == 0) {
            throw new ServiceException(ResponseCode.InformationUnexist);
        }
        SysGroupRoleRelExample sysGroupRoleRelExample = new SysGroupRoleRelExample();
        sysGroupRoleRelExample.createCriteria().andGuidEqualTo(key);
        try {
            sysGroupRoleRelMapper.deleteByExample(sysGroupRoleRelExample);
        } catch (DataAccessException e) {
            throw new ServiceException(ResponseCode.UnknowSqlException);
        }

    }

    @Override
    public void updateItem(GroupRoleRel item) throws ServiceException {
        if (recordCount(item.getGuid()) == 0) {
            throw new ServiceException(ResponseCode.InformationUnexist);
        }
        SysGroupRoleRel sysGroupRoleRel = groupRoleRelConverter.convert2Entity(item);

        try {
            sysGroupRoleRelMapper.updateByPrimaryKeySelective(sysGroupRoleRel);
        } catch (DataAccessException e) {
            throw new ServiceException(ResponseCode.UnknowSqlException);
        }

    }

    @Override
    public void addItems(List<GroupRoleRel> items) throws ServiceException {

        for (GroupRoleRel groupRoleRel : items) {
            addItem(groupRoleRel);
        }
    }

    @Override
    public void delItems(List<String> keys) throws ServiceException {

        for (String str : keys) {
            delItem(str);
        }
    }

    @Override
    public void updateItems(List<GroupRoleRel> items) throws ServiceException {

        for (GroupRoleRel groupRoleRel : items) {
            updateItem(groupRoleRel);
        }
    }

    @Override
    public long recordCount(String key) {
        SysGroupRoleRelExample sysGroupRoleRelExample = new SysGroupRoleRelExample();
        sysGroupRoleRelExample.createCriteria().andGuidEqualTo(key);
        long l = sysGroupRoleRelMapper.countByExample(sysGroupRoleRelExample);
        return l;
    }

}
