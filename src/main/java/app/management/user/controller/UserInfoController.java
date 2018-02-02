package app.management.user.controller;

import app.base.Result;
import app.comn.ResponseCode;
import app.management.user.service.UserInformationService;
import app.management.userinfo.model.UserInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Api(description = "用户角色列表接口")
@RestController
@RequestMapping("management/userInfo")
public class UserInfoController {
    @Resource
    private UserInformationService userInformationService;

    @ApiOperation(value = "按ID查找用户角色列表",
            notes = "按ID查找用户角色列表")
    @RequestMapping(path = "getUserInfo", method = GET)
    public Result<UserInfo> getUserInfo(@RequestParam String userId) {
        return new Result<>(ResponseCode.Success, userInformationService.getItem(userId));
    }

//    @ApiOperation(value = "获取所有用户信息",
//            notes = "获取所有用户,返回List",
//            responseContainer = "List",
//            response = UserInfo.class)
//    @RequestMapping(path = "getUsers", method = GET)
//    public Result<List<UserInfo>> getUsers() {
//        return new Result<>(ResponseCode.Success, userInformationService.getItems());
//    }
//
//    @ApiOperation(value = "分页获取用户信息",
//            notes = "分页获取用户信息,返回List",
//            responseContainer = "List",
//            response = UserInfo.class)
//    @RequestMapping(path = "getUsersByPage", method = GET)
//    public PageModel<UserInfo> getDeptsByPage(@RequestParam int pageNum, @RequestParam int pageSize) {
//        PageModel<UserInfo> itemsByPage = userInformationService.getItemsByPage(pageNum, pageSize);
//        return itemsByPage;
//    }
//
//
//    @ApiOperation(value = "新增用户", notes = "新增用户")
//    @RequestMapping(path = "addUser", method = POST)
//    public Result<Integer> addUser(@RequestBody UserInfo userInfo) {
//        try {
//            userInformationService.addItem(userInfo);
//        } catch (ServiceException e) {
//            return new Result<>(e.getResponseCode());
//        }
//        return new Result<>(ResponseCode.Success);
//    }
//
//    @ApiOperation(value = "批量新增用户", notes = "批量新增用户")
//    @RequestMapping(path = "addUsers", method = POST)
//    public Result<Integer> addUser(@RequestBody List<UserInfo> luser) {
//        try {
//            userInformationService.addItems(luser);
//        } catch (ServiceException e) {
//            return new Result<>(e.getResponseCode());
//        }
//        return new Result<>(ResponseCode.Success);
//    }
//
//    @ApiOperation(value = "修改用户信息", notes = "修改用户信息")
//    @RequestMapping(path = "updateUser", method = PUT)
//    public Result<Integer> updateUser(@RequestBody UserInfo user) {
//
//        try {
//            userInformationService.updateItem(user);
//        } catch (ServiceException e) {
//            return new Result<>(e.getResponseCode());
//        }
//        return new Result<>(ResponseCode.Success);
//    }
//
//    @ApiOperation(value = "批量修改用户信息", notes = "批量修改用户信息")
//    @RequestMapping(path = "updateUsers", method = PUT)
//    public Result<Integer> updateUser(@RequestBody List<UserInfo> luser) {
//
//        try {
//            userInformationService.updateItems(luser);
//        } catch (ServiceException e) {
//            return new Result<>(e.getResponseCode());
//        }
//        return new Result<>(ResponseCode.Success);
//    }
//
//    @ApiOperation(value = "删除用户", notes = "删除用户")
//    @RequestMapping(path = "delUser", method = DELETE)
//    public Result<Integer> delUser(@RequestBody String userId) {
//        try {
//            userInformationService.delItem(userId);
//        } catch (ServiceException e) {
//            return new Result<>(e.getResponseCode());
//        }
//        return new Result<>(ResponseCode.Success);
//    }
//
//    @ApiOperation(value = "批量删除用户", notes = "批量删除用户")
//    @RequestMapping(path = "delUsers", method = DELETE)
//    public Result<Integer> delUser(@RequestBody List<String> luserId) {
//        try {
//            userInformationService.delItems(luserId);
//        } catch (ServiceException e) {
//            return new Result<>(e.getResponseCode());
//        }
//        return new Result<>(ResponseCode.Success);
//    }
}
