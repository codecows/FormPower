package app.management.relation.converter;

import app.base.converter.ConverterBase;
import app.dao.entities.SysCompanyDeptRel;
import app.management.relation.model.CompanyDeptRel;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class CompanyDeptRelConverter extends ConverterBase<CompanyDeptRel, SysCompanyDeptRel> {

    @Override
    public CompanyDeptRel convert2Model(SysCompanyDeptRel sysCompanyDeptRel) {
        CompanyDeptRel companyDeptRel = new CompanyDeptRel();
        BeanUtils.copyProperties(sysCompanyDeptRel, companyDeptRel);
        return companyDeptRel;
    }

    @Override
    public SysCompanyDeptRel convert2Entity(CompanyDeptRel companyDeptRel) {
        SysCompanyDeptRel sysCompanyDeptRel = new SysCompanyDeptRel();
        BeanUtils.copyProperties(companyDeptRel, sysCompanyDeptRel);
        return sysCompanyDeptRel;
    }
}
