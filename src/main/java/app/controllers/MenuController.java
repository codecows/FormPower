package app.controllers;

import app.comn.ServiceException;
import app.dao.entities.SysMenus;
import app.dao.entities.SysMenusExample;
import app.dao.mappers.SysMenusMapper;
import app.model.Menu;
import app.model.User;
import app.services.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Api(description = "菜单接口")
@RestController
@RequestMapping("menu")
public class MenuController {
    @Resource
    private SysMenusMapper sysMenusMapper;

    @ApiOperation(value = "获取所有用户",
            notes = "获取所有用户,返回List",
            responseContainer = "List",
            response = User.class)
    @RequestMapping(path = "getMenus", method = GET)
    public List<SysMenus> getMenus() {

        List<SysMenus> sysMenus = sysMenusMapper.selectByExample(new SysMenusExample());
        return sysMenus;
    }

    @Resource
    private MenuService<Menu> menuService;

    //TODO 测试事务处理i
    @RequestMapping(path = "addMenus", method = GET)
    public int addMenuTest() {

        int i = 0;
        try {
            menuService.addItem(null);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return i;
    }
}
