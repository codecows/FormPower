package app.services.impl;

import app.comn.ServiceException;
import app.dao.entities.SysMenus;
import app.dao.mappers.SysMenusMapper;
import app.services.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MenuServiceImpl<Menu>  implements MenuService<Menu> {
    private final static Logger logger = LoggerFactory.getLogger(MenuServiceImpl.class);
    @Resource
    private SysMenusMapper menusMapper;

    @Override
    public Menu getItem(String key) {
        return null;
    }

    @Override
    public List<Menu> getItems() {
        return null;
    }

    @Override
    public List<Menu> getItemsByPage(int pageSize, int pageNum) {
        return null;
    }

    @Override
    public void addItem(Menu item) throws ServiceException {

        for (int i = 0; i < 10; i++) {
            SysMenus menu = new SysMenus();

            menu.setMenuid("M" + i);
            menu.setMenuname("M" + i);
            if (i == 5) {
                menu.setMenuname("爱的沙发上地方啊速度发放啊速度发啊速度发啊速度发是哒是哒发撒旦法");
            }
            try {
                menusMapper.insert(menu);
            } catch (Exception e) {
                logger.error(e.getMessage());
            }

        }

    }

    @Override
    public void delItem(String key) throws ServiceException {

    }

    @Override
    public void updateItem(Menu item) throws ServiceException {

    }

    @Override
    public void addItems(List<Menu> items) throws ServiceException {

    }

    @Override
    public void delItems(List<String> keys) throws ServiceException {

    }

    @Override
    public void updateItems(List<Menu> items) throws ServiceException {

    }

    @Override
    public boolean exist(String key) {
        return false;
    }

}
