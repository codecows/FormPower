package app.group.converter;

import app.base.converter.ConverterBase;
import app.dao.entities.SysGroup;
import app.group.model.Group;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class GroupConverter extends ConverterBase<Group, SysGroup> {

    @Override
    public Group convert2Model(SysGroup sysGroup) {
        Group group = new Group();
        BeanUtils.copyProperties(sysGroup, group);
        return group;
    }

    @Override
    public SysGroup convert2Entity(Group menu) {
        SysGroup sysGroup = new SysGroup();
        BeanUtils.copyProperties(menu, sysGroup);
        return sysGroup;
    }
}
