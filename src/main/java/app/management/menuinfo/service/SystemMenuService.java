package app.management.menuinfo.service;

import app.management.menuinfo.model.SystemMenu;

import java.util.List;

/**
 * Created by real on 2018/2/7.
 */
public interface SystemMenuService {

    /*按UserId查询系统三级菜单*/
    List<SystemMenu> getItemByUserId(String userId, String status);
}
