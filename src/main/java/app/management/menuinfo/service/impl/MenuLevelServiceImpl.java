package app.management.menuinfo.service.impl;


import app.management.menuinfo.converter.MenuLevelConverter;
import app.management.menuinfo.converter.MenuPojoConverter;
import app.management.menuinfo.entities.MenuLevelEntity;
import app.management.menuinfo.entities.MenuPojoEntity;
import app.management.menuinfo.mappers.MenuLevelMapper;
import app.management.menuinfo.model.MenuLevel;
import app.management.menuinfo.model.MenuPojo;
import app.management.menuinfo.service.MenuLevelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Fan on 2018/2/2.
 */
@Service
public class MenuLevelServiceImpl implements MenuLevelService {

    @Resource
    private MenuLevelMapper menuLevelMapper;

    @Resource
    private MenuLevelConverter menuLevelConverter;

    @Resource
    private MenuPojoConverter menuPojoConverter;

    @Override
    public List<MenuLevel> getItems() {
        List<MenuLevelEntity> menuLevelEntities = menuLevelMapper.selectAllRecord();
        List<MenuLevel> menuLevels = menuLevelConverter.convert2ModelList(menuLevelEntities);
        return menuLevels;
    }

    @Override
    public List<MenuPojo> getItemsByMenuType(String menuType) {

        List<MenuPojoEntity> menuPojoEntities = menuLevelMapper.selectByMenuTpye(menuType);

        List<MenuPojo> menuPojos = menuPojoConverter.convert2ModelList(menuPojoEntities);


        return menuPojos;
    }


}
