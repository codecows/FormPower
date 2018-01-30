package app.management.relation.converter;

import app.base.converter.ConverterBase;
import app.dao.entities.SysUserRoleRel;
import app.management.relation.model.UserRoleRel;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class UserRoleRelConverter extends ConverterBase<UserRoleRel, SysUserRoleRel> {

    @Override
    public UserRoleRel convert2Model(SysUserRoleRel sysUserRoleRel) {
        UserRoleRel userRoleRel = new UserRoleRel();
        BeanUtils.copyProperties(sysUserRoleRel, userRoleRel);
        return userRoleRel;
    }

    @Override
    public SysUserRoleRel convert2Entity(UserRoleRel userRoleRel) {
        SysUserRoleRel sysUserRoleRel = new SysUserRoleRel();
        BeanUtils.copyProperties(userRoleRel, sysUserRoleRel);
        return sysUserRoleRel;
    }
}
