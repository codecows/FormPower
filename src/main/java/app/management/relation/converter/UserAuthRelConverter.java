package app.management.relation.converter;

import app.base.converter.ConverterBase;
import app.dao.entities.SysUserAuthRel;
import app.management.relation.model.UserAuthRel;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class UserAuthRelConverter extends ConverterBase<UserAuthRel, SysUserAuthRel> {

    @Override
    public UserAuthRel convert2Model(SysUserAuthRel sysUserAuthRel) {
        UserAuthRel userAuthRel = new UserAuthRel();
        BeanUtils.copyProperties(sysUserAuthRel, userAuthRel);
        return userAuthRel;
    }

    @Override
    public SysUserAuthRel convert2Entity(UserAuthRel userAuthRel) {
        SysUserAuthRel sysUserAuthRel = new SysUserAuthRel();
        BeanUtils.copyProperties(userAuthRel, sysUserAuthRel);
        return sysUserAuthRel;
    }
}
