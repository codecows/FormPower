package app.management.relation.service.impl;

import app.comn.ConstantPage;
import app.comn.PageModel;
import app.comn.ResponseCode;
import app.comn.ServiceException;
import app.dao.entities.SysGroupAuthRel;
import app.dao.entities.SysGroupAuthRelExample;
import app.dao.mappers.SysGroupAuthRelMapper;
import app.management.relation.converter.GroupAuthRelConverter;
import app.management.relation.model.GroupAuthRel;
import app.management.relation.service.GroupAuthRelService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GroupAuthRelServiceImpl implements GroupAuthRelService {
    private final static Logger logger = LoggerFactory.getLogger(GroupAuthRelServiceImpl.class);
    @Resource
    private SysGroupAuthRelMapper sysGroupAuthRelMapper;
    @Resource
    private GroupAuthRelConverter groupAuthRelConverter;


    @Override
    public GroupAuthRel getItem(String key) {
        SysGroupAuthRel sysGroupAuthRel = sysGroupAuthRelMapper.selectByPrimaryKey(key);
        GroupAuthRel groupAuthRel = groupAuthRelConverter.convert2Model(sysGroupAuthRel);
        return groupAuthRel;
    }

    @Override
    public List<GroupAuthRel> getItems() {

        List<SysGroupAuthRel> sysGroupAuthRels = sysGroupAuthRelMapper.selectByExample(null);
        List<GroupAuthRel> groupAuthRel = groupAuthRelConverter.convert2ModelList(sysGroupAuthRels);
        return groupAuthRel;

    }

    @Override
    public PageModel<GroupAuthRel> getItemsByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        SysGroupAuthRelExample sysGroupAuthRelExample = new SysGroupAuthRelExample();
        //查询条件

        //执行查询
        Page<SysGroupAuthRel> page = (Page<SysGroupAuthRel>) sysGroupAuthRelMapper.selectByExample(sysGroupAuthRelExample);
        List<GroupAuthRel> groupAuthRel = groupAuthRelConverter.convert2ModelList(page);
        PageModel<GroupAuthRel> pageModel = new PageModel<>(groupAuthRel, ConstantPage.NAVIGATE_SIZE,
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
    public void addItem(GroupAuthRel item) throws ServiceException {
        if (recordCount(item.getGuid()) > 0) {
            throw new ServiceException(ResponseCode.InformationExist);
        }
        SysGroupAuthRel sysGroupAuthRel = groupAuthRelConverter.convert2Entity(item);

        try {
            sysGroupAuthRelMapper.insertSelective(sysGroupAuthRel);
        } catch (DataAccessException e) {
            throw new ServiceException(ResponseCode.UnknowSqlException);
        }

    }

    @Override
    public void delItem(String key) throws ServiceException {
        if (recordCount(key) == 0) {
            throw new ServiceException(ResponseCode.InformationUnexist);
        }
        SysGroupAuthRelExample sysGroupAuthRelExample = new SysGroupAuthRelExample();
        sysGroupAuthRelExample.createCriteria().andGuidEqualTo(key);
        try {
            sysGroupAuthRelMapper.deleteByExample(sysGroupAuthRelExample);
        } catch (DataAccessException e) {
            throw new ServiceException(ResponseCode.UnknowSqlException);
        }

    }

    @Override
    public void updateItem(GroupAuthRel item) throws ServiceException {
        if (recordCount(item.getGuid()) == 0) {
            throw new ServiceException(ResponseCode.InformationUnexist);
        }
        SysGroupAuthRel sysGroupAuthRel = groupAuthRelConverter.convert2Entity(item);

        try {
            sysGroupAuthRelMapper.updateByPrimaryKeySelective(sysGroupAuthRel);
        } catch (DataAccessException e) {
            throw new ServiceException(ResponseCode.UnknowSqlException);
        }

    }

    @Override
    public void addItems(List<GroupAuthRel> items) throws ServiceException {

        for (GroupAuthRel groupAuthRel : items) {
            addItem(groupAuthRel);
        }
    }

    @Override
    public void delItems(List<String> keys) throws ServiceException {

        for (String str : keys) {
            delItem(str);
        }
    }

    @Override
    public void updateItems(List<GroupAuthRel> items) throws ServiceException {

        for (GroupAuthRel groupAuthRel : items) {
            updateItem(groupAuthRel);
        }
    }

    @Override
    public long recordCount(String key) {
        SysGroupAuthRelExample sysGroupAuthRelExample = new SysGroupAuthRelExample();
        sysGroupAuthRelExample.createCriteria().andGuidEqualTo(key);
        long l = sysGroupAuthRelMapper.countByExample(sysGroupAuthRelExample);
        return l;
    }

}
