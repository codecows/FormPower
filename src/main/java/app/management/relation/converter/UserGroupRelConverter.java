package app.management.relation.converter;

import app.base.converter.ConverterBase;
import app.dao.entities.SysUserGroupRel;
import app.management.relation.model.UserGroupRel;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class UserGroupRelConverter extends ConverterBase<UserGroupRel, SysUserGroupRel> {

    @Override
    public UserGroupRel convert2Model(SysUserGroupRel sysUserGroupRel) {
        UserGroupRel userGroupRel = new UserGroupRel();
        BeanUtils.copyProperties(sysUserGroupRel, userGroupRel);
        return userGroupRel;
    }

    @Override
    public SysUserGroupRel convert2Entity(UserGroupRel userGroupRel) {
        SysUserGroupRel sysUserGroupRel = new SysUserGroupRel();
        BeanUtils.copyProperties(userGroupRel, sysUserGroupRel);
        return sysUserGroupRel;
    }
}
