package app.management.menu.controller;

import app.base.Result;
import app.comn.PageModel;
import app.comn.ResponseCode;
import app.comn.ServiceException;
import app.management.menu.model.Menu;
import app.management.menu.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Api(description = "菜单管理接口")
@RestController
@RequestMapping("management/menu")
public class MenuController {

    @Resource
    private MenuService menuService;


    @ApiOperation(value = "获取所有菜单信息",
            notes = "获取所有菜单信息,返回List",
            responseContainer = "List",
            response = Menu.class)
    @RequestMapping(path = "getMenus", method = GET)
    public Result<List<Menu>> getMenus() {
        return new Result<>(ResponseCode.Success, menuService.getItems());
    }

    @ApiOperation(value = "分页获取所有菜单信息",
            notes = "分页获取所有菜单信息,返回List",
            responseContainer = "List",
            response = Menu.class)
    @RequestMapping(path = "getMenusByPage/{pageNum}/{pageSize}", method = GET)
    public PageModel<Menu> getMenusByPage(@PathVariable int pageNum, @PathVariable int pageSize) {
        PageModel<Menu> itemsByPage = menuService.getItemsByPage(pageNum, pageSize);
        return itemsByPage;
    }

    @ApiOperation(value = "按id查找菜单信息",
            notes = "按id查找菜单信息")
    @RequestMapping(path = "getMenu/{menuId}", method = GET)
    public Result<Menu> getMenu(@PathVariable String menuId) {
        return new Result<>(ResponseCode.Success, menuService.getItem(menuId));
    }

    @ApiOperation(value = "新增菜单信息", notes = "新增菜单信息")
    @RequestMapping(path = "addMenu", method = POST)
    public Result<Integer> addMenu(@RequestBody Menu menu) {
        try {
            menuService.addItem(menu);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }


    @ApiOperation(value = "批量新增菜单信息", notes = "批量新增菜单信息")
    @RequestMapping(path = "addMenus", method = POST)
    public Result<Integer> addMenus(@RequestBody List<Menu> list) {
        try {
            menuService.addItems(list);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }


    @ApiOperation(value = "按id删除菜单信息", notes = "删除菜单信息")
    @RequestMapping(path = "delMenu/{depaId}", method = DELETE)
    public Result<Integer> delMenu(@PathVariable String depaId) {
        try {
            menuService.delItem(depaId);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }


    @ApiOperation(value = "批量删除菜单信息", notes = "批量删除菜单信息")
    @RequestMapping(path = "delMenus/{depaIds}", method = DELETE)
    public Result<Integer> delMenus(@PathVariable List<String> depaIds) {
        try {
            menuService.delItems(depaIds);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }


    @ApiOperation(value = "修改菜单信息", notes = "修改菜单信息")
    @RequestMapping(path = "updateMenu", method = PUT)
    public Result<Integer> updateMenu(@RequestBody Menu menu) {
        try {
            menuService.updateItem(menu);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }

    @ApiOperation(value = "批量修改菜单信息", notes = "批量修改菜单信息")
    @RequestMapping(path = "updateMenus", method = PUT)
    public Result<Integer> updateMenus(@RequestBody List<Menu> dlist) {
        try {
            menuService.updateItems(dlist);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }

}
