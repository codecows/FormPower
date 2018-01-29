package app.user.converter;

import app.base.converter.ConverterBase;
import app.dao.entities.SysUser;
import app.user.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class UserConverter extends ConverterBase<User, SysUser> {
    @Override
    public User convert2Model(SysUser sysUser) {
        User user = new User();
        BeanUtils.copyProperties(sysUser, user);
        return user;
    }

    @Override
    public SysUser convert2Entity(User user) {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(user, sysUser);
        return sysUser;
    }

}
