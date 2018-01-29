package app.management.company.converter;

import app.base.converter.ConverterBase;
import app.management.company.model.Company;
import app.dao.entities.SysCompany;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * Created by Fan on 2018/1/29.
 */
@Component
public class CompanyConverter extends ConverterBase<Company, SysCompany> {

    @Override
    public Company convert2Model(SysCompany sysCompany) {
        Company company = new Company();
        BeanUtils.copyProperties(sysCompany, company);
        return company;
    }

    @Override
    public SysCompany convert2Entity(Company company) {
        SysCompany sysCompany = new SysCompany();
        BeanUtils.copyProperties(company, sysCompany);
        return sysCompany;
    }
}
