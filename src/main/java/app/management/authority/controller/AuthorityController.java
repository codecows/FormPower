package app.management.authority.controller;

import app.management.authority.model.Authority;
import app.management.authority.service.AuthorityService;
import app.base.Result;
import app.comn.PageModel;
import app.comn.ResponseCode;
import app.comn.ServiceException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Api(description = "权限管理接口")
@RestController
@RequestMapping("management/auth")
public class AuthorityController {
    @Resource
    private AuthorityService authorityService;


    @ApiOperation(value = "获取所有权限信息",
            notes = "获取所有权限信息,返回List",
            responseContainer = "List",
            response = Authority.class)
    @RequestMapping(path = "getAuths", method = GET)
    public Result<List<Authority>> getAuths() {
        return new Result<>(ResponseCode.Success,authorityService.getItems());
    }

    @ApiOperation(value = "分页获取所有权限信息",
            notes = "分页获取所有权限信息,返回List",
            responseContainer = "List",
            response = Authority.class)
    @RequestMapping(path = "getAuthsByPage", method = GET)
    public PageModel<Authority> getAuthsByPage(@RequestParam int pageNum, @RequestParam int pageSize) {
        PageModel<Authority> itemsByPage = authorityService.getItemsByPage(pageNum, pageSize);
        return itemsByPage;
    }

    @ApiOperation(value = "按id查找权限信息",
            notes = "按id查找权限信息")
    @RequestMapping(path = "getAuth", method = GET)
    public Result<Authority> getAuth(@RequestParam String authId) {
        return new Result<>(ResponseCode.Success, authorityService.getItem(authId));
    }

    @ApiOperation(value = "新增权限信息", notes = "新增权限信息")
    @RequestMapping(path = "addAuth", method = POST)
    public Result<Integer> addAuth(@RequestBody Authority authority) {
        try {
            authorityService.addItem(authority);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }


    @ApiOperation(value = "批量新增权限信息", notes = "批量新增权限信息")
    @RequestMapping(path = "addAuths", method = POST)
    public Result<Integer> addAuths(@RequestBody List<Authority> list) {
        try {
            authorityService.addItems(list);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }



    @ApiOperation(value = "按id删除权限信息",notes = "按id删除权限信息")
    @RequestMapping(path = "delAuth", method = DELETE)
    public Result<Integer> delAuth(@RequestParam String authId){
        try {
            authorityService.delItem(authId);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }


    @ApiOperation(value = "批量删除权限信息",notes = "批量删除权限信息")
    @RequestMapping(path = "delAuths", method = DELETE)
    public Result<Integer> delAuths(@RequestParam List<String> authIds){
        try {
            authorityService.delItems(authIds);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }


    @ApiOperation(value = "修改权限信息", notes = "修改权限信息")
    @RequestMapping(path = "updateAuth", method = PUT)
    public Result<Integer> updateAuth(@RequestBody Authority authority) {
        try {
            authorityService.updateItem(authority);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }

    @ApiOperation(value = "批量修改权限信息", notes = "批量修改权限信息")
    @RequestMapping(path = "updateAuths", method = PUT)
    public Result<Integer> updateAuths(@RequestBody List<Authority> alist) {
        try {
            authorityService.updateItems(alist);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }

}
