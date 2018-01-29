package app.company.service.impl;

import app.comn.PageModel;
import app.comn.ServiceException;
import app.company.converter.CompanyConverter;
import app.company.model.Company;
import app.company.service.CompanyService;
import app.dao.mappers.SysCodeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Fan on 2018/1/29.
 */
@Service
public class CompanyServiceImpl implements CompanyService {

    @Resource
    private SysCodeMapper sysCodeMapper;

    @Resource
    private CompanyConverter companyConverter;

    //todo companyservice 待实现
    @Override
    public Company getItem(String key) {
        return null;
    }

    @Override
    public List<Company> getItems() {
        return null;
    }

    @Override
    public PageModel<Company> getItemsByPage(int pageNum, int pageSize) {
        return null;
    }

    @Override
    public void addItem(Company item) throws ServiceException {

    }

    @Override
    public void delItem(String key) throws ServiceException {

    }

    @Override
    public void updateItem(Company item) throws ServiceException {

    }

    @Override
    public void addItems(List<Company> items) throws ServiceException {

    }

    @Override
    public void delItems(List<String> keys) throws ServiceException {

    }

    @Override
    public void updateItems(List<Company> items) throws ServiceException {

    }

    @Override
    public long recordCount(String key) {
        return 0;
    }
}
