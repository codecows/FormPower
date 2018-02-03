package app.management.menuinfo.converter;

import app.base.converter.ConverterBase;
import app.management.menuinfo.entities.MenuPojoEntity;
import app.management.menuinfo.model.MenuPojo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class MenuPojoConverter extends ConverterBase<MenuPojo, MenuPojoEntity> {

    @Override
    public MenuPojo convert2Model(MenuPojoEntity menuPojoEntity) {
        MenuPojo menuPojo = new MenuPojo();
        BeanUtils.copyProperties(menuPojoEntity, menuPojo);
        return menuPojo;
    }

    @Override
    public MenuPojoEntity convert2Entity(MenuPojo menuPojo) {
        MenuPojoEntity menuPojoEntity = new MenuPojoEntity();
        BeanUtils.copyProperties(menuPojo, menuPojoEntity);
        return menuPojoEntity;
    }
}
