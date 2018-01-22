package app.services.impl;

import app.dao.entities.SysMenus;
import app.dao.mappers.SysMenusMapper;
import app.services.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.SQLException;

@Service
public class MenuServiceImpl implements MenuService {
    private final static Logger logger = LoggerFactory.getLogger(MenuServiceImpl.class);
    @Resource
    private SysMenusMapper menusMapper;

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    @Override
    public int addMenu() {
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

        return 1;
    }
}
