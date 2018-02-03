package app.management.menuinfo.service;


import app.management.menuinfo.model.MenuLevel;
import app.management.menuinfo.model.MenuPojo;

import java.util.List;

/**
 * Created by Fan on 2018/2/2.
 */
public interface MenuLevelService {

    /*查询菜单，返回三级菜单*/
    List<MenuLevel> getItems();

    /*按菜单类型查找菜单信息*/
    List<MenuPojo> getItemsByMenuType(String menuType);


}
