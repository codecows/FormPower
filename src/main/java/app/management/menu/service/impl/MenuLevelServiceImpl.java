package app.management.menu.service.impl;

import app.management.menu.converter.MenuLevelConverter;
import app.management.menu.entities.MenuLevelEntity;
import app.management.menu.mappers.MenuLevelMapper;
import app.management.menu.model.MenuLevel;
import app.management.menu.service.MenuLevelService;
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

    @Override
    public List<MenuLevel> getItems() {
        List<MenuLevelEntity> menuLevelEntities = menuLevelMapper.selectAllRecord();
        List<MenuLevel> menuLevels = menuLevelConverter.convert2ModelList(menuLevelEntities);
        return menuLevels;
    }
}
