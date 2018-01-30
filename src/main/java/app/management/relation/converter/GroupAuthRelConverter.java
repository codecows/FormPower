package app.management.relation.converter;

import app.base.converter.ConverterBase;
import app.dao.entities.SysGroupAuthRel;
import app.management.relation.model.GroupAuthRel;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class GroupAuthRelConverter extends ConverterBase<GroupAuthRel, SysGroupAuthRel> {

    @Override
    public GroupAuthRel convert2Model(SysGroupAuthRel sysGroupAuthRel) {
        GroupAuthRel groupAuthRel = new GroupAuthRel();
        BeanUtils.copyProperties(sysGroupAuthRel, groupAuthRel);
        return groupAuthRel;
    }

    @Override
    public SysGroupAuthRel convert2Entity(GroupAuthRel groupAuthRel) {
        SysGroupAuthRel sysGroupAuthRel = new SysGroupAuthRel();
        BeanUtils.copyProperties(groupAuthRel, sysGroupAuthRel);
        return sysGroupAuthRel;
    }
}
