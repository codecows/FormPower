package app.management.relation.converter;

import app.base.converter.ConverterBase;
import app.dao.entities.SysUserDepartmentRel;
import app.management.relation.model.UserDepartmentRel;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class UserDepartmentRelConverter extends ConverterBase<UserDepartmentRel, SysUserDepartmentRel> {

    @Override
    public UserDepartmentRel convert2Model(SysUserDepartmentRel sysUserDepartmentRel) {
        UserDepartmentRel userDepartmentRel = new UserDepartmentRel();
        BeanUtils.copyProperties(sysUserDepartmentRel, userDepartmentRel);
        return userDepartmentRel;
    }

    @Override
    public SysUserDepartmentRel convert2Entity(UserDepartmentRel userDepartmentRel) {
        SysUserDepartmentRel sysUserDepartmentRel = new SysUserDepartmentRel();
        BeanUtils.copyProperties(userDepartmentRel, sysUserDepartmentRel);
        return sysUserDepartmentRel;
    }
}
