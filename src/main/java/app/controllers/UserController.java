package app.controllers;

import app.model.Result;
import app.model.User;
import app.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Api(description = "用户接口")
@RestController
@RequestMapping("user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping(path = "getUser/{userId}", method = GET)
    public List<User> push(@PathVariable String userId) {
        return userService.getUsers();
    }

    @ApiOperation(value = "获取所有用户",
            notes = "获取所有用户,返回List",
            responseContainer = "List",
            response = User.class)
    @RequestMapping(path = "getUsers", method = GET)
    public Result<List<User>> push() {
        Result<List<User>> result = new Result<>();
        result.setData(userService.getUsers());
        return result;
    }
}
