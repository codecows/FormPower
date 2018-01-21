package app.controllers;

import app.comn.ResponseCode;
import app.comn.ServiceException;
import app.model.Department;
import app.model.Result;
import app.model.User;
import app.services.DepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Api(description = "用户接口")
@RestController
@RequestMapping("dept")
public class DepartmentController {
    @Resource
    private DepartmentService departmentService;


    @ApiOperation(value = "获取所有用户",
            notes = "获取所有用户,返回List",
            responseContainer = "List",
            response = User.class)
    @RequestMapping(path = "getDepts", method = GET)
    public Result<List<User>> getDepts() {
        departmentService.getDepts();

        return null;
    }

    @ApiOperation(value = "新增用户", notes = "新增用户")
    @RequestMapping(path = "addUser", method = POST)
    public Result<Integer> addDept(@RequestBody User user) {
//        try {
//            userService.addUser(user);
//        } catch (ServiceException e) {
//            return new Result<>(e.getResponseCode());
//        }
        return new Result<>(ResponseCode.Success);
    }
}
