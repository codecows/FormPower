package app.management.menu.mappers;

import app.management.menu.entities.MenuLevelEntity;

import java.util.List;

/**
 * Created by real on 2018/2/1.
 */
public interface MenuLevelMapper {

    List<MenuLevelEntity> selectAllRecord();

    MenuLevelEntity selectByPrimaryKey(String roleId);

    List<MenuLevelEntity> selectByUserId(String userId);
}
