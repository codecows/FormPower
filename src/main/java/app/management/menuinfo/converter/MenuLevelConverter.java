package app.management.menuinfo.converter;

import app.base.converter.ConverterBase;
import app.management.menuinfo.entities.MenuLevelEntity;
import app.management.menuinfo.model.MenuLevel;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class MenuLevelConverter extends ConverterBase<MenuLevel, MenuLevelEntity> {

    @Override
    public MenuLevel convert2Model(MenuLevelEntity menuLevelEntity) {
        MenuLevel menuLevel = new MenuLevel();
        BeanUtils.copyProperties(menuLevelEntity, menuLevel);
        return menuLevel;
    }

    @Override
    public MenuLevelEntity convert2Entity(MenuLevel menuLevel) {
        MenuLevelEntity menuLevelEntity = new MenuLevelEntity();
        BeanUtils.copyProperties(menuLevel, menuLevelEntity);
        return menuLevelEntity;
    }
}
