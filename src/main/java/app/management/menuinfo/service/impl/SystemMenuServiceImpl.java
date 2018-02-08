package app.management.menuinfo.service.impl;

import app.management.menuinfo.entities.GroupMenuEntity;
import app.management.menuinfo.entities.MenuPojoEntity;
import app.management.menuinfo.entities.SystemMenuEntity;
import app.management.menuinfo.mappers.SystemMenuMapper;
import app.management.menuinfo.model.GroupMenu;
import app.management.menuinfo.model.MenuPojo;
import app.management.menuinfo.model.SystemMenu;
import app.management.menuinfo.service.SystemMenuService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by real on 2018/2/7.
 */
@Service
public class SystemMenuServiceImpl implements SystemMenuService {

    @Resource
    private SystemMenuMapper systemMenuMapper;

    @Override
    public List<SystemMenu> getItemByUserId(String userId, String status) {

        List<SystemMenuEntity> systemMenuEntities = systemMenuMapper.selectByUserId(userId, status);

        ArrayList<SystemMenu> systemMenus = new ArrayList<>();

        for (SystemMenuEntity systemMenuEntity : systemMenuEntities) {
            SystemMenu systemMenu = new SystemMenu();
            BeanUtils.copyProperties(systemMenuEntity, systemMenu);
            ArrayList<GroupMenu> groupMenus = new ArrayList<>();
            for (GroupMenuEntity groupMenuEntity : systemMenuEntity.getGroupMenuEntityList()) {
                GroupMenu groupMenu = new GroupMenu();
                BeanUtils.copyProperties(groupMenuEntity, groupMenu);
                ArrayList<MenuPojo> menuPojos = new ArrayList<>();
                for (MenuPojoEntity menuPojoEntity : groupMenuEntity.getMenuEntityList()) {
                    MenuPojo menuPojo = new MenuPojo();
                    BeanUtils.copyProperties(menuPojoEntity, menuPojo);
                    menuPojos.add(menuPojo);
                }
                groupMenu.setMenuList(menuPojos);
                groupMenus.add(groupMenu);
            }
            systemMenu.setGroupMenuList(groupMenus);
            systemMenus.add(systemMenu);
        }


        return systemMenus;
    }
}
