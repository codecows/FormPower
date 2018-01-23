package app.converter;

import app.dao.entities.SysMenus;
import app.model.Menu;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class MenuConverter extends ConverterBase<Menu, SysMenus> {

    @Override
    public Menu convert2Model(SysMenus sysMenus) {
        Menu menu = new Menu();
        BeanUtils.copyProperties(sysMenus, menu);
        return menu;
    }

    @Override
    public SysMenus convert2Entity(Menu menu) {
        SysMenus sysMenu = new SysMenus();
        BeanUtils.copyProperties(menu, sysMenu);
        return sysMenu;
    }
}
