package app.converter;

import app.dao.entities.SysUser;
import app.dao.entities.UserInformation;
import app.model.User;
import app.model.UserInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class UserInformationConverter extends ConverterBase<UserInfo, UserInformation> {
    @Override
    public UserInfo convert2Model(UserInformation userInformation) {
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(userInformation, userInfo);
        return userInfo;
    }

    @Override
    public UserInformation convert2Entity(UserInfo userInfo) {
        UserInformation userInformation = new UserInformation();
        BeanUtils.copyProperties(userInfo, userInformation);
        return userInformation;
    }

}
