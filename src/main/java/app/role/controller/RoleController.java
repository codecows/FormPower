package app.role.controller;

import app.base.Result;
import app.comn.PageModel;
import app.comn.ResponseCode;
import app.comn.ServiceException;
import app.role.model.Role;
import app.role.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Api(description = "角色管理接口")
@RestController
@RequestMapping("management/role")
public class RoleController {

    @Resource
    private RoleService roleService;


    @ApiOperation(value = "获取所有角色信息",
            notes = "获取所有角色信息,返回List",
            responseContainer = "List",
            response = Role.class)
    @RequestMapping(path = "getRoles", method = GET)
    public Result<List<Role>> getRoles() {
        return new Result<>(ResponseCode.Success, roleService.getItems());
    }

    @ApiOperation(value = "分页获取所有角色信息",
            notes = "分页获取所有角色信息,返回List",
            responseContainer = "List",
            response = Role.class)
    @RequestMapping(path = "getRolesByPage", method = GET)
    public PageModel<Role> getRolesByPage(@RequestParam int pageNum, @RequestParam int pageSize) {
        PageModel<Role> itemsByPage = roleService.getItemsByPage(pageNum, pageSize);
        return itemsByPage;
    }

    @ApiOperation(value = "按id查找角色信息",
            notes = "按id查找角色信息")
    @RequestMapping(path = "getRole", method = GET)
    public Result<Role> getRole(@RequestParam String menuId) {
        return new Result<>(ResponseCode.Success, roleService.getItem(menuId));
    }

    @ApiOperation(value = "新增角色信息", notes = "新增角色信息")
    @RequestMapping(path = "addRole", method = POST)
    public Result<Integer> addRole(@RequestBody Role role) {
        try {
            roleService.addItem(role);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }


    @ApiOperation(value = "批量新增角色信息", notes = "批量新增角色信息")
    @RequestMapping(path = "addRoles", method = POST)
    public Result<Integer> addRoles(@RequestBody List<Role> list) {
        try {
            roleService.addItems(list);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }


    @ApiOperation(value = "按id删除角色信息", notes = "删除角色信息")
    @RequestMapping(path = "delRole", method = DELETE)
    public Result<Integer> delRole(@RequestParam String depaId) {
        try {
            roleService.delItem(depaId);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }


    @ApiOperation(value = "批量删除角色信息", notes = "批量删除角色信息")
    @RequestMapping(path = "delRoles", method = DELETE)
    public Result<Integer> delRoles(@RequestParam List<String> depaIds) {
        try {
            roleService.delItems(depaIds);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }


    @ApiOperation(value = "修改角色信息", notes = "修改角色信息")
    @RequestMapping(path = "updateRole", method = PUT)
    public Result<Integer> updateRole(@RequestBody Role role) {
        try {
            roleService.updateItem(role);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }

    @ApiOperation(value = "批量修改角色信息", notes = "批量修改角色信息")
    @RequestMapping(path = "updateRoles", method = PUT)
    public Result<Integer> updateRoles(@RequestBody List<Role> dlist) {
        try {
            roleService.updateItems(dlist);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }

}
