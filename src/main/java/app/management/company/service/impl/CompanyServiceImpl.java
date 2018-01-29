package app.management.company.service.impl;

import app.comn.ConstantPage;
import app.comn.PageModel;
import app.comn.ResponseCode;
import app.comn.ServiceException;
import app.management.company.converter.CompanyConverter;
import app.management.company.model.Company;
import app.management.company.service.CompanyService;
import app.dao.entities.SysCompany;
import app.dao.entities.SysCompanyExample;
import app.dao.mappers.SysCompanyMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Fan on 2018/1/29.
 */
@Service
public class CompanyServiceImpl implements CompanyService {

    @Resource
    private SysCompanyMapper sysCompanyMapper;

    @Resource
    private CompanyConverter companyConverter;


    @Override
    public Company getItem(String key) {
        SysCompany sysCompany = sysCompanyMapper.selectByPrimaryKey(key);
        Company company = companyConverter.convert2Model(sysCompany);
        return company;
    }

    @Override
    public List<Company> getItems() {
        List<SysCompany> sysCompanies = sysCompanyMapper.selectByExample(null);
        List<Company> companies = companyConverter.convert2ModelList(sysCompanies);
        return companies;
    }

    @Override
    public PageModel<Company> getItemsByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        SysCompanyExample sysCompanyExample = new SysCompanyExample();

        //查询条件

        //执行查询
        Page<SysCompany> page = (Page<SysCompany>) sysCompanyMapper.selectByExample(sysCompanyExample);
        List<Company> companies = companyConverter.convert2ModelList(page);
        PageModel<Company> pageModel = new PageModel<>(companies, ConstantPage.NAVIGATE_SIZE,
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
    public void addItem(Company item) throws ServiceException {
        if (recordCount(item.getCompanyId()) > 0) {
            throw new ServiceException(ResponseCode.InformationExist);
        }
        SysCompany sysCompany = companyConverter.convert2Entity(item);

        try {
            sysCompanyMapper.insertSelective(sysCompany);
        } catch (DataAccessException e) {
            throw new ServiceException(ResponseCode.UnknowSqlException);
        }

    }

    @Override
    public void delItem(String key) throws ServiceException {

        if (recordCount(key) == 0) {
            throw new ServiceException(ResponseCode.InformationUnexist);
        }
        SysCompanyExample sysCompanyExample = new SysCompanyExample();
        sysCompanyExample.createCriteria().andCompanyIdEqualTo(key);
        try {
            sysCompanyMapper.deleteByExample(sysCompanyExample);
        } catch (DataAccessException e) {
            throw new ServiceException(ResponseCode.UnknowSqlException);
        }

    }

    @Override
    public void updateItem(Company item) throws ServiceException {
        if (recordCount(item.getCompanyId()) == 0) {
            throw new ServiceException(ResponseCode.InformationUnexist);
        }
        SysCompany sysCompany = companyConverter.convert2Entity(item);

        try {
            sysCompanyMapper.updateByPrimaryKeySelective(sysCompany);
        } catch (DataAccessException e) {
            throw new ServiceException(ResponseCode.UnknowSqlException);
        }

    }

    @Override
    public void addItems(List<Company> items) throws ServiceException {

        for (Company company : items) {
            addItem(company);
        }
    }

    @Override
    public void delItems(List<String> keys) throws ServiceException {
        for (String str : keys) {
            delItem(str);
        }

    }

    @Override
    public void updateItems(List<Company> items) throws ServiceException {

        for (Company company : items) {
            updateItem(company);
        }
    }

    @Override
    public long recordCount(String key) {
        SysCompanyExample sysCompanyExample = new SysCompanyExample();
        sysCompanyExample.createCriteria().andCompanyIdEqualTo(key);
        long l = sysCompanyMapper.countByExample(sysCompanyExample);
        return l;
    }

}
