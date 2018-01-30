package app.management.relation.converter;

import app.base.converter.ConverterBase;
import app.dao.entities.SysAuthMenuRel;
import app.management.relation.model.AuthMenuRel;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AuthMenuRelConverter extends ConverterBase<AuthMenuRel, SysAuthMenuRel> {

    @Override
    public AuthMenuRel convert2Model(SysAuthMenuRel sysAuthMenuRel) {
        AuthMenuRel authMenuRel = new AuthMenuRel();
        BeanUtils.copyProperties(sysAuthMenuRel, authMenuRel);
        return authMenuRel;
    }

    @Override
    public SysAuthMenuRel convert2Entity(AuthMenuRel authMenuRel) {
        SysAuthMenuRel sysAuthMenuRel = new SysAuthMenuRel();
        BeanUtils.copyProperties(authMenuRel, sysAuthMenuRel);
        return sysAuthMenuRel;
    }
}
