package app.management.userinfo.converter;

import app.base.converter.ConverterBase;
import app.management.userinfo.entities.UserPojoEntity;
import app.management.userinfo.model.UserPojo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class UserPojoConverter extends ConverterBase<UserPojo, UserPojoEntity> {
    @Override
    public UserPojo convert2Model(UserPojoEntity userPojoEntity) {
        UserPojo userPojo = new UserPojo();
        BeanUtils.copyProperties(userPojoEntity, userPojo);
        return userPojo;
    }

    @Override
    public UserPojoEntity convert2Entity(UserPojo userPojo) {
        UserPojoEntity userPojoEntity = new UserPojoEntity();
        BeanUtils.copyProperties(userPojo, userPojoEntity);
        return userPojoEntity;
    }

}
