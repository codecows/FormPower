package app.management.relation.service.impl;

import app.comn.ConstantPage;
import app.comn.PageModel;
import app.comn.ResponseCode;
import app.comn.ServiceException;
import app.dao.entities.SysCompanyDeptRel;
import app.dao.entities.SysCompanyDeptRelExample;
import app.dao.mappers.SysCompanyDeptRelMapper;
import app.management.relation.converter.CompanyDeptRelConverter;
import app.management.relation.model.CompanyDeptRel;
import app.management.relation.service.CompanyDeptRelService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CompanyDeptRelServiceImpl implements CompanyDeptRelService {
    private final static Logger logger = LoggerFactory.getLogger(CompanyDeptRelServiceImpl.class);
    @Resource
    private SysCompanyDeptRelMapper sysCompanyDeptRelMapper;
    @Resource
    private CompanyDeptRelConverter companyDeptRelConverter;


    @Override
    public CompanyDeptRel getItem(String key) {
        SysCompanyDeptRel sysCompanyDeptRel = sysCompanyDeptRelMapper.selectByPrimaryKey(key);
        CompanyDeptRel companyDeptRel = companyDeptRelConverter.convert2Model(sysCompanyDeptRel);
        return companyDeptRel;
    }

    @Override
    public List<CompanyDeptRel> getItems() {

        List<SysCompanyDeptRel> sysCompanyDeptRels = sysCompanyDeptRelMapper.selectByExample(null);
        List<CompanyDeptRel> companyDeptRel = companyDeptRelConverter.convert2ModelList(sysCompanyDeptRels);
        return companyDeptRel;

    }

    @Override
    public PageModel<CompanyDeptRel> getItemsByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        SysCompanyDeptRelExample sysCompanyDeptRelExample = new SysCompanyDeptRelExample();
        //查询条件

        //执行查询
        Page<SysCompanyDeptRel> page = (Page<SysCompanyDeptRel>) sysCompanyDeptRelMapper.selectByExample(sysCompanyDeptRelExample);
        List<CompanyDeptRel> companyDeptRel = companyDeptRelConverter.convert2ModelList(page);
        PageModel<CompanyDeptRel> pageModel = new PageModel<>(companyDeptRel, ConstantPage.NAVIGATE_SIZE,
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
    public void addItem(CompanyDeptRel item) throws ServiceException {
        if (recordCount(item.getGuid()) > 0) {
            throw new ServiceException(ResponseCode.InformationExist);
        }
        SysCompanyDeptRel sysCompanyDeptRel = companyDeptRelConverter.convert2Entity(item);

        try {
            sysCompanyDeptRelMapper.insertSelective(sysCompanyDeptRel);
        } catch (DataAccessException e) {
            throw new ServiceException(ResponseCode.UnknowSqlException);
        }

    }

    @Override
    public void delItem(String key) throws ServiceException {
        if (recordCount(key) == 0) {
            throw new ServiceException(ResponseCode.InformationUnexist);
        }
        SysCompanyDeptRelExample sysCompanyDeptRelExample = new SysCompanyDeptRelExample();
        sysCompanyDeptRelExample.createCriteria().andGuidEqualTo(key);
        try {
            sysCompanyDeptRelMapper.deleteByExample(sysCompanyDeptRelExample);
        } catch (DataAccessException e) {
            throw new ServiceException(ResponseCode.UnknowSqlException);
        }

    }

    @Override
    public void updateItem(CompanyDeptRel item) throws ServiceException {
        if (recordCount(item.getGuid()) == 0) {
            throw new ServiceException(ResponseCode.InformationUnexist);
        }
        SysCompanyDeptRel sysCompanyDeptRel = companyDeptRelConverter.convert2Entity(item);

        try {
            sysCompanyDeptRelMapper.updateByPrimaryKeySelective(sysCompanyDeptRel);
        } catch (DataAccessException e) {
            throw new ServiceException(ResponseCode.UnknowSqlException);
        }

    }

    @Override
    public void addItems(List<CompanyDeptRel> items) throws ServiceException {

        for (CompanyDeptRel companyDeptRel : items) {
            addItem(companyDeptRel);
        }
    }

    @Override
    public void delItems(List<String> keys) throws ServiceException {

        for (String str : keys) {
            delItem(str);
        }
    }

    @Override
    public void updateItems(List<CompanyDeptRel> items) throws ServiceException {

        for (CompanyDeptRel companyDeptRel : items) {
            updateItem(companyDeptRel);
        }
    }

    @Override
    public long recordCount(String key) {
        SysCompanyDeptRelExample sysCompanyDeptRelExample = new SysCompanyDeptRelExample();
        sysCompanyDeptRelExample.createCriteria().andGuidEqualTo(key);
        long l = sysCompanyDeptRelMapper.countByExample(sysCompanyDeptRelExample);
        return l;
    }

}
