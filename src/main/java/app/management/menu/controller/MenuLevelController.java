package app.management.menu.controller;

import app.base.Result;
import app.comn.ResponseCode;
import app.management.menu.model.MenuLevel;
import app.management.menu.service.MenuLevelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Api(description = "层级菜单接口")
@RestController
@RequestMapping("management/menulevel")
public class MenuLevelController {

    @Resource
    private MenuLevelService menuLevelService;


    @ApiOperation(value = "获取所有菜单信息",
            notes = "获取所有菜单信息,返回List",
            responseContainer = "List",
            response = MenuLevel.class)
    @RequestMapping(path = "getMenuLevels", method = GET)
    public Result<List<MenuLevel>> getMenus() {
        return new Result<>(ResponseCode.Success, menuLevelService.getItems());
    }

//    @ApiOperation(value = "分页获取所有菜单信息",
//            notes = "分页获取所有菜单信息,返回List",
//            responseContainer = "List",
//            response = Menu.class)
//    @RequestMapping(path = "getMenusByPage", method = GET)
//    public PageModel<Menu> getMenusByPage(@RequestParam int pageNum, @RequestParam int pageSize) {
//        PageModel<Menu> itemsByPage = menuService.getItemsByPage(pageNum, pageSize);
//        return itemsByPage;
//    }
//
//    @ApiOperation(value = "按id查找菜单信息",
//            notes = "按id查找菜单信息")
//    @RequestMapping(path = "getMenu", method = GET)
//    public Result<Menu> getMenu(@RequestParam String menuId) {
//        return new Result<>(ResponseCode.Success, menuService.getItem(menuId));
//    }
//
//    @ApiOperation(value = "新增菜单信息", notes = "新增菜单信息")
//    @RequestMapping(path = "addMenu", method = POST)
//    public Result<Integer> addMenu(@RequestBody Menu menu) {
//        try {
//            menuService.addItem(menu);
//        } catch (ServiceException e) {
//            return new Result<>(e.getResponseCode());
//        }
//        return new Result<>(ResponseCode.Success);
//    }
//
//
//    @ApiOperation(value = "批量新增菜单信息", notes = "批量新增菜单信息")
//    @RequestMapping(path = "addMenus", method = POST)
//    public Result<Integer> addMenus(@RequestBody List<Menu> list) {
//        try {
//            menuService.addItems(list);
//        } catch (ServiceException e) {
//            return new Result<>(e.getResponseCode());
//        }
//        return new Result<>(ResponseCode.Success);
//    }
//
//
//    @ApiOperation(value = "按id删除菜单信息", notes = "删除菜单信息")
//    @RequestMapping(path = "delMenu", method = DELETE)
//    public Result<Integer> delMenu(@RequestParam String depaId) {
//        try {
//            menuService.delItem(depaId);
//        } catch (ServiceException e) {
//            return new Result<>(e.getResponseCode());
//        }
//        return new Result<>(ResponseCode.Success);
//    }
//
//
//    @ApiOperation(value = "批量删除菜单信息", notes = "批量删除菜单信息")
//    @RequestMapping(path = "delMenus", method = DELETE)
//    public Result<Integer> delMenus(@RequestParam List<String> depaIds) {
//        try {
//            menuService.delItems(depaIds);
//        } catch (ServiceException e) {
//            return new Result<>(e.getResponseCode());
//        }
//        return new Result<>(ResponseCode.Success);
//    }
//
//
//    @ApiOperation(value = "修改菜单信息", notes = "修改菜单信息")
//    @RequestMapping(path = "updateMenu", method = PUT)
//    public Result<Integer> updateMenu(@RequestBody Menu menu) {
//        try {
//            menuService.updateItem(menu);
//        } catch (ServiceException e) {
//            return new Result<>(e.getResponseCode());
//        }
//        return new Result<>(ResponseCode.Success);
//    }
//
//    @ApiOperation(value = "批量修改菜单信息", notes = "批量修改菜单信息")
//    @RequestMapping(path = "updateMenus", method = PUT)
//    public Result<Integer> updateMenus(@RequestBody List<Menu> dlist) {
//        try {
//            menuService.updateItems(dlist);
//        } catch (ServiceException e) {
//            return new Result<>(e.getResponseCode());
//        }
//        return new Result<>(ResponseCode.Success);
//    }

}
