package app.management.role.converter;

import app.base.converter.ConverterBase;
import app.dao.entities.SysRole;
import app.management.role.model.Role;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * Created by real on 2018/1/27.
 */
@Component
public class RoleConverter extends ConverterBase<Role,SysRole> {
    @Override
    public Role convert2Model(SysRole sysRole) {
        Role role = new Role();
        BeanUtils.copyProperties(sysRole,role);
        return role;
    }

    @Override
    public SysRole convert2Entity(Role role) {
        SysRole sysRole = new SysRole();
        BeanUtils.copyProperties(role,sysRole);
        return sysRole;
    }
}
