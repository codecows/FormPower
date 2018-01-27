package app.dao.mappers;

import app.dao.entities.UserInformation;

/**
 * Created by real on 2018/1/27.
 */
public interface UserInformationMapper {

    UserInformation selectByPrimaryKey(String authId);
}
