package app.dao.mappers;

import app.dao.entities.UserInformation;

import java.util.List;

/**
 * Created by real on 2018/1/27.
 */
public interface UserInformationMapper {

    UserInformation selectByPrimaryKey(String userId);

    List<UserInformation> selectByPrimaryKey1(String userId);
}
