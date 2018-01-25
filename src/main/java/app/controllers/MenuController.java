package app.controllers;

import app.comn.PageModel;
import app.comn.ServiceException;
import app.dao.entities.SysMenus;
import app.dao.entities.SysMenusExample;
import app.dao.mappers.SysMenusMapper;
import app.model.Menu;
import app.model.User;
import app.services.MenuService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
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

    @Resource
    private MenuService menuService;


    @ApiOperation(value = "获取所有用户",
            notes = "获取所有用户,返回List",
            responseContainer = "List",
            response = User.class)
    @RequestMapping(path = "getMenus", method = GET)
    public List<Menu> getMenus() {

//        List<SysMenus> sysMenus = sysMenusMapper.selectByExample(new SysMenusExample());

//        List<Menu> itemsByPage = menuService.getItemsByPage(2, 10);
        return null;
    }

    @ApiOperation(value = "获取所有用户,分页",
            notes = "获取所有用户,分页",
            responseContainer = "List",
            response = User.class)
    @RequestMapping(path = "getMenusByPage/{pageNum}/{pageSize}", method = GET)
    public PageModel<Menu> getMenusByPage(@PathVariable int pageNum, @PathVariable int pageSize) {
        PageModel<Menu> itemsByPage = menuService.getItemsByPage(pageNum, pageSize);
        return itemsByPage;
    }

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
