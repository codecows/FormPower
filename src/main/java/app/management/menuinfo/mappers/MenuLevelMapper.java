package app.management.menuinfo.mappers;

import app.management.menuinfo.entities.MenuLevelEntity;
import app.management.menuinfo.entities.MenuPojoEntity;

import java.util.List;

/**
 * Created by real on 2018/2/1.
 */
public interface MenuLevelMapper {

    List<MenuLevelEntity> selectAllRecord();

    MenuLevelEntity selectByPrimaryKey(String roleId);

    List<MenuLevelEntity> selectByUserId(String userId);

    List<MenuPojoEntity> selectByMenuTpye(String menuType);
}
