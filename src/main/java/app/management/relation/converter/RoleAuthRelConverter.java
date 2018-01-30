package app.management.relation.converter;

import app.base.converter.ConverterBase;
import app.dao.entities.SysRoleAuthRel;
import app.management.relation.model.RoleAuthRel;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class RoleAuthRelConverter extends ConverterBase<RoleAuthRel, SysRoleAuthRel> {

    @Override
    public RoleAuthRel convert2Model(SysRoleAuthRel sysRoleAuthRel) {
        RoleAuthRel roleAuthRel = new RoleAuthRel();
        BeanUtils.copyProperties(sysRoleAuthRel, roleAuthRel);
        return roleAuthRel;
    }

    @Override
    public SysRoleAuthRel convert2Entity(RoleAuthRel roleAuthRel) {
        SysRoleAuthRel sysRoleAuthRel = new SysRoleAuthRel();
        BeanUtils.copyProperties(roleAuthRel, sysRoleAuthRel);
        return sysRoleAuthRel;
    }
}
