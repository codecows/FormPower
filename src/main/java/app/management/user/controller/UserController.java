package app.management.user.controller;

import app.base.Result;
import app.comn.PageModel;
import app.comn.ResponseCode;
import app.comn.ServiceException;
import app.management.user.model.User;
import app.management.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Api(description = "用户管理接口")
@RestController
@RequestMapping("management/user")
public class UserController {
    @Resource
    private UserService userService;

    @ApiOperation(value = "按ID查找用户信息",
            notes = "按ID查找用户信息")
    @RequestMapping(path = "getUser/{userId}", method = GET)
    public Result<User> getUser(@PathVariable String userId) {
        return new Result<>(ResponseCode.Success, userService.getItem(userId));
    }

    @ApiOperation(value = "获取所有用户信息",
            notes = "获取所有用户,返回List",
            responseContainer = "List",
            response = User.class)
    @RequestMapping(path = "getUsers", method = GET)
    public Result<List<User>> getUsers() {
        return new Result<>(ResponseCode.Success, userService.getItems());
    }

    @ApiOperation(value = "分页获取用户信息",
            notes = "分页获取用户信息,返回List",
            responseContainer = "List",
            response = User.class)
    @RequestMapping(path = "getUsersByPage/{pageNum}/{pageSize}", method = GET)
    public PageModel<User> getDeptsByPage(@PathVariable int pageNum, @PathVariable int pageSize) {
        PageModel<User> itemsByPage = userService.getItemsByPage(pageNum, pageSize);
        return itemsByPage;
    }


    @ApiOperation(value = "新增用户", notes = "新增用户")
    @RequestMapping(path = "addUser", method = POST)
    public Result<Integer> addUser(@RequestBody User user) {
        try {
            userService.addItem(user);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }

    @ApiOperation(value = "批量新增用户", notes = "批量新增用户")
    @RequestMapping(path = "addUsers", method = POST)
    public Result<Integer> addUser(@RequestBody List<User> luser) {
        try {
            userService.addItems(luser);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }

    @ApiOperation(value = "修改用户信息", notes = "修改用户信息")
    @RequestMapping(path = "updateUser", method = PUT)
    public Result<Integer> updateUser(@RequestBody User user) {

        try {
            userService.updateItem(user);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }

    @ApiOperation(value = "批量修改用户信息", notes = "批量修改用户信息")
    @RequestMapping(path = "updateUsers", method = PUT)
    public Result<Integer> updateUser(@RequestBody List<User> luser) {

        try {
            userService.updateItems(luser);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }

    @ApiOperation(value = "删除用户", notes = "删除用户")
    @RequestMapping(path = "delUser", method = DELETE)
    public Result<Integer> delUser(@RequestBody String userId) {
        try {
            userService.delItem(userId);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }

    @ApiOperation(value = "批量删除用户", notes = "批量删除用户")
    @RequestMapping(path = "delUsers", method = DELETE)
    public Result<Integer> delUser(@RequestBody List<String> luserId) {
        try {
            userService.delItems(luserId);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }
}
