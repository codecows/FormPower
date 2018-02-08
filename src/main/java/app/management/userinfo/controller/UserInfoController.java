package app.management.userinfo.controller;

import app.base.Result;
import app.comn.ResponseCode;
import app.comn.ServiceException;
import app.management.userinfo.model.UserInfo;
import app.management.userinfo.model.UserPojo;
import app.management.userinfo.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Api(description = "用户综合信息列表接口")
@RestController
@RequestMapping("management/userInfo")
public class UserInfoController {
    @Resource
    private UserInfoService userInfoService;

    @ApiOperation(value = "按ID查找用户,部门,角色,菜单列表信息列表",
            notes = "按ID查找用户,部门,角色,菜单列表信息列表")
    @RequestMapping(path = "getUserInfo/{userId}", method = GET)
    public Result<UserInfo> getUserInfo(@PathVariable String userId) {

        try {
            return new Result<>(ResponseCode.Success, userInfoService.getItem(userId));
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
    }

    @ApiOperation(value = "按部门查找部门下的所有用户",
            notes = "按部门查找部门下的所有用户")
    @RequestMapping(path = "getUserByDeptId", method = GET)
    public Result<List<UserPojo>> getUserByDeptId(@RequestParam String deptId) {
        return new Result<>(ResponseCode.Success, userInfoService.getItemsByDepartmentId(deptId));
    }

    @ApiOperation(value = "按角色查找拥有角色的用户",
            notes = "按角色查找拥有角色的用户")
    @RequestMapping(path = "getUserByRoleId", method = GET)
    public Result<List<UserPojo>> getUserByRoleId(@RequestParam String roleId) {
        return new Result<>(ResponseCode.Success, userInfoService.getItemByRoleId(roleId));
    }


}
