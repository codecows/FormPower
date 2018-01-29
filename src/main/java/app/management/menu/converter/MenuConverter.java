package app.management.menu.converter;

import app.base.converter.ConverterBase;
import app.dao.entities.SysMenu;
import app.management.menu.model.Menu;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class MenuConverter extends ConverterBase<Menu, SysMenu> {

    @Override
    public Menu convert2Model(SysMenu sysMenu) {
        Menu menu = new Menu();
        BeanUtils.copyProperties(sysMenu, menu);
        return menu;
    }

    @Override
    public SysMenu convert2Entity(Menu menu) {
        SysMenu sysMenu = new SysMenu();
        BeanUtils.copyProperties(menu, sysMenu);
        return sysMenu;
    }
}
