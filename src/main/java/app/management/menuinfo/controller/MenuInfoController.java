package app.management.menuinfo.controller;

import app.base.Result;
import app.comn.ResponseCode;
import app.management.menuinfo.model.MenuLevel;
import app.management.menuinfo.model.MenuPojo;
import app.management.menuinfo.service.MenuLevelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Api(description = "层级菜单接口")
@RestController
@RequestMapping("management/menulevel")
public class MenuInfoController {

    @Resource
    private MenuLevelService menuLevelService;


    @ApiOperation(value = "三次结构获取所有菜单信息",
            notes = "获取所有菜单信息,返回List",
            responseContainer = "List",
            response = MenuLevel.class)
    @RequestMapping(path = "getMenuLevels", method = GET)
    public Result<List<MenuLevel>> getMenus() {
        return new Result<>(ResponseCode.Success, menuLevelService.getItems());
    }

    @ApiOperation(value = "按菜单类型返回菜单信息",
            notes = "按菜单类型返回菜单信息",
            responseContainer = "List",
            response = MenuPojo.class)
    @RequestMapping(path = "getMenusByType/{menuType}", method = GET)
    public Result<List<MenuPojo>> getMenusByType(@PathVariable String menuType) {
        return new Result<>(ResponseCode.Success, menuLevelService.getItemsByMenuType(menuType));
    }


}
