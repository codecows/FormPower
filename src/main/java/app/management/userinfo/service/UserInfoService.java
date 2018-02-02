package app.management.userinfo.service;

import app.management.userinfo.model.UserInfo;

/**
 * Created by Fan on 2018/2/2.
 */
public interface UserInfoService {

    UserInfo getItem(String userId);
}
