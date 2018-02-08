package app.management.roleinfo.controller;

import app.base.Result;
import app.comn.ResponseCode;
import app.management.roleinfo.model.RoleInfo;
import app.management.roleinfo.service.RoleInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Api(description = "角色权限菜单接口")
@RestController
@RequestMapping("management/roleinfo")
public class RoleInfoController {

    @Resource
    private RoleInfoService roleInfoService;


    @ApiOperation(value = "获取所有信息",
            notes = "获取所有角信息,返回List",
            responseContainer = "List",
            response = RoleInfo.class)
    @RequestMapping(path = "getRoleInfos", method = GET)
    public Result<List<RoleInfo>> getRoleInfos() {
        List<RoleInfo> items = roleInfoService.getItems();

        return new Result<>(ResponseCode.Success, items);
    }



}
