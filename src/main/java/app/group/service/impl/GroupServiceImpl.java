package app.group.service.impl;

import app.comn.ConstantPage;
import app.comn.PageModel;
import app.comn.ResponseCode;
import app.comn.ServiceException;
import app.dao.entities.SysGroup;
import app.dao.entities.SysGroupExample;
import app.dao.mappers.SysGroupMapper;
import app.group.converter.GroupConverter;
import app.group.model.Group;
import app.group.service.GroupService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {
    private final static Logger logger = LoggerFactory.getLogger(GroupServiceImpl.class);
    @Resource
    private SysGroupMapper sysGroupMapper;
    @Resource
    private GroupConverter groupConverter;


    @Override
    public Group getItem(String key) {
        SysGroup sysGroup = sysGroupMapper.selectByPrimaryKey(key);
        Group menu = groupConverter.convert2Model(sysGroup);
        return menu;
    }

    @Override
    public List<Group> getItems() {

        List<SysGroup> sysGroups = sysGroupMapper.selectByExample(null);
        List<Group> menus = groupConverter.convert2ModelList(sysGroups);
        return menus;

    }

    @Override
    public PageModel<Group> getItemsByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        SysGroupExample sysGroupExample = new SysGroupExample();
        //查询条件

        //执行查询
        Page<SysGroup> page = (Page<SysGroup>) sysGroupMapper.selectByExample(sysGroupExample);
        List<Group> groups = groupConverter.convert2ModelList(page);
        PageModel<Group> pageModel = new PageModel<>(groups, ConstantPage.NAVIGATE_SIZE,
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
    public void addItem(Group item) throws ServiceException {
        if (recordCount(item.getGroupId()) > 0) {
            throw new ServiceException(ResponseCode.InformationExist);
        }
        SysGroup sysGroup = groupConverter.convert2Entity(item);

        try {
            sysGroupMapper.insertSelective(sysGroup);
        } catch (DataAccessException e) {
            throw new ServiceException(ResponseCode.UnknowSqlException);
        }

    }

    @Override
    public void delItem(String key) throws ServiceException {
        if (recordCount(key) == 0) {
            throw new ServiceException(ResponseCode.InformationUnexist);
        }
        SysGroupExample sysGroupExample = new SysGroupExample();
        sysGroupExample.createCriteria().andGroupIdEqualTo(key);
        try {
            sysGroupMapper.deleteByExample(sysGroupExample);
        } catch (DataAccessException e) {
            throw new ServiceException(ResponseCode.UnknowSqlException);
        }

    }

    @Override
    public void updateItem(Group item) throws ServiceException {
        if (recordCount(item.getGroupId()) == 0) {
            throw new ServiceException(ResponseCode.InformationUnexist);
        }
        SysGroup sysGroup = groupConverter.convert2Entity(item);

        try {
            sysGroupMapper.updateByPrimaryKeySelective(sysGroup);
        } catch (DataAccessException e) {
            throw new ServiceException(ResponseCode.UnknowSqlException);
        }

    }

    @Override
    public void addItems(List<Group> items) throws ServiceException {

        for (Group menu : items) {
            addItem(menu);
        }
    }

    @Override
    public void delItems(List<String> keys) throws ServiceException {

        for (String str : keys) {
            delItem(str);
        }
    }

    @Override
    public void updateItems(List<Group> items) throws ServiceException {

        for (Group menu : items) {
            updateItem(menu);
        }
    }

    @Override
    public long recordCount(String key) {
        SysGroupExample sysGroupExample = new SysGroupExample();
        sysGroupExample.createCriteria().andGroupIdEqualTo(key);
        long l = sysGroupMapper.countByExample(sysGroupExample);
        return l;
    }

}
