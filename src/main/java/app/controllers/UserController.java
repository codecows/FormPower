package app.controllers;

import app.comn.ResponseCode;
import app.model.Result;
import app.model.User;
import app.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Api(description = "用户接口")
@RestController
@RequestMapping("user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping(path = "getUser/{userId}", method = GET)
    public List<User> getUser(@PathVariable String userId) {
        return userService.getUsers();
    }

    @ApiOperation(value = "获取所有用户",
            notes = "获取所有用户,返回List",
            responseContainer = "List",
            response = User.class)
    @RequestMapping(path = "getUsers", method = GET)
    public Result<List<User>> getUsers() {
        Result<List<User>> result = new Result<>(ResponseCode.Success);
        result.setData(userService.getUsers());
        return result;
    }

    @ApiOperation(value = "新增用户", notes = "新增用户")
    @RequestMapping(path = "addUser", method = POST)
    public Result<Integer> addUser(@RequestBody User user) {
        Result<Integer> result = new Result<>(ResponseCode.Success);
        result.setMessage(ResponseCode.Success.getMessage());
        userService.AddUser(user);
        return result;
    }

    @ApiOperation(value = "修改用户信息", notes = "修改用户信息")
    @RequestMapping(path = "updateUser", method = PUT)
    public Result<Integer> updateUser(@RequestBody User user) {
        Result<Integer> result = new Result<>(ResponseCode.Success);
        result.setMessage(ResponseCode.Success.getMessage());
        //TODO 未完
        return result;
    }

    @ApiOperation(value = "删除用户", notes = "删除用户")
    @RequestMapping(path = "delUser", method = DELETE)
    public Result<Integer> delUser(@RequestBody String userId) {
        Result<Integer> result = new Result<>(ResponseCode.Success);
        result.setMessage(ResponseCode.Success.getMessage());
        return result;
    }
}
