package app.management.menu.service.impl;

import app.comn.ConstantPage;
import app.comn.PageModel;
import app.comn.ResponseCode;
import app.comn.ServiceException;
import app.dao.entities.SysMenu;
import app.dao.entities.SysMenuExample;
import app.dao.mappers.SysMenuMapper;
import app.management.menu.converter.MenuConverter;
import app.management.menu.model.Menu;
import app.management.menu.service.MenuService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    private final static Logger logger = LoggerFactory.getLogger(MenuServiceImpl.class);
    @Resource
    private SysMenuMapper menusMapper;
    @Resource
    private MenuConverter menuConverter;


    @Override
    public Menu getItem(String key) {
        SysMenu sysMenu = menusMapper.selectByPrimaryKey(key);
        Menu menu = menuConverter.convert2Model(sysMenu);
        return menu;
    }

    @Override
    public List<Menu> getItems() {

        List<SysMenu> sysMenus = menusMapper.selectByExample(null);
        List<Menu> menus = menuConverter.convert2ModelList(sysMenus);
        return menus;

    }

    @Override
    public PageModel<Menu> getItemsByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        SysMenuExample exam = new SysMenuExample();
        //查询条件

        //执行查询
        Page<SysMenu> page = (Page<SysMenu>) menusMapper.selectByExample(exam);
        List<Menu> menus = menuConverter.convert2ModelList(page);
        PageModel<Menu> pageModel = new PageModel<>(menus, ConstantPage.NAVIGATE_SIZE,
                page.getPageNum(),
                page.getPageSize(),
                page.getPages(),
                page.size(),
                page.getTotal(),
                page.getStartRow()
        );
        return pageModel;
    }

    @Override
    public void addItem(Menu item) throws ServiceException {
        if (recordCount(item.getMenuId()) > 0) {
            throw new ServiceException(ResponseCode.InformationExist);
        }
        SysMenu sysMenu = menuConverter.convert2Entity(item);

        try {
            menusMapper.insertSelective(sysMenu);
        } catch (DataAccessException e) {
            throw new ServiceException(ResponseCode.UnknowSqlException);
        }

    }

    @Override
    public void delItem(String key) throws ServiceException {
        if (recordCount(key) == 0) {
            throw new ServiceException(ResponseCode.InformationUnexist);
        }
        SysMenuExample sysMenuExample = new SysMenuExample();
        sysMenuExample.createCriteria().andMenuIdEqualTo(key);
        try {
            menusMapper.deleteByExample(sysMenuExample);
        } catch (DataAccessException e) {
            throw new ServiceException(ResponseCode.UnknowSqlException);
        }

    }

    @Override
    public void updateItem(Menu item) throws ServiceException {
        if (recordCount(item.getMenuId()) == 0) {
            throw new ServiceException(ResponseCode.InformationUnexist);
        }
        SysMenu sysMenu = menuConverter.convert2Entity(item);

        try {
            menusMapper.updateByPrimaryKeySelective(sysMenu);
        } catch (DataAccessException e) {
            throw new ServiceException(ResponseCode.UnknowSqlException);
        }

    }

    @Override
    public void addItems(List<Menu> items) throws ServiceException {

        for (Menu menu : items) {
            addItem(menu);
        }
    }

    @Override
    public void delItems(List<String> keys) throws ServiceException {

        for (String str : keys) {
            delItem(str);
        }
    }

    @Override
    public void updateItems(List<Menu> items) throws ServiceException {

        for (Menu menu : items) {
            updateItem(menu);
        }
    }

    @Override
    public long recordCount(String key) {
        SysMenuExample sysMenuExample = new SysMenuExample();
        sysMenuExample.createCriteria().andMenuIdEqualTo(key);
        long l = menusMapper.countByExample(sysMenuExample);
        return l;
    }

}
