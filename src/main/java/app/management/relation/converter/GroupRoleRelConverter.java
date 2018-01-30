package app.management.relation.converter;

import app.base.converter.ConverterBase;
import app.dao.entities.SysGroupRoleRel;
import app.management.relation.model.GroupRoleRel;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class GroupRoleRelConverter extends ConverterBase<GroupRoleRel, SysGroupRoleRel> {

    @Override
    public GroupRoleRel convert2Model(SysGroupRoleRel sysGroupRoleRel) {
        GroupRoleRel groupRoleRel = new GroupRoleRel();
        BeanUtils.copyProperties(sysGroupRoleRel, groupRoleRel);
        return groupRoleRel;
    }

    @Override
    public SysGroupRoleRel convert2Entity(GroupRoleRel groupRoleRel) {
        SysGroupRoleRel sysGroupRoleRel = new SysGroupRoleRel();
        BeanUtils.copyProperties(groupRoleRel, sysGroupRoleRel);
        return sysGroupRoleRel;
    }
}
