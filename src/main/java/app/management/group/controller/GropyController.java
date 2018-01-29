package app.management.group.controller;

import app.base.Result;
import app.comn.PageModel;
import app.comn.ResponseCode;
import app.comn.ServiceException;
import app.management.group.model.Group;
import app.management.group.service.GroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Api(description = "组管理接口")
@RestController
@RequestMapping("management/group")
public class GropyController {

    @Resource
    private GroupService groupService;


    @ApiOperation(value = "获取所有组信息",
            notes = "获取所有组信息,返回List",
            responseContainer = "List",
            response = Group.class)
    @RequestMapping(path = "getGroups", method = GET)
    public Result<List<Group>> getGroups() {
        return new Result<>(ResponseCode.Success, groupService.getItems());
    }

    @ApiOperation(value = "分页获取所有组信息",
            notes = "分页获取所有组信息,返回List",
            responseContainer = "List",
            response = Group.class)
    @RequestMapping(path = "getGroupsByPage", method = GET)
    public PageModel<Group> getGroupsByPage(@RequestParam int pageNum, @RequestParam int pageSize) {
        PageModel<Group> itemsByPage = groupService.getItemsByPage(pageNum, pageSize);
        return itemsByPage;
    }

    @ApiOperation(value = "按id查找组信息",
            notes = "按id查找组信息")
    @RequestMapping(path = "getGroup", method = GET)
    public Result<Group> getGroup(@RequestParam String groupId) {
        return new Result<>(ResponseCode.Success, groupService.getItem(groupId));
    }

    @ApiOperation(value = "新增组信息", notes = "新增组信息")
    @RequestMapping(path = "addGroup", method = POST)
    public Result<Integer> addGroup(@RequestBody Group group) {
        try {
            groupService.addItem(group);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }


    @ApiOperation(value = "批量新增组信息", notes = "批量新增组信息")
    @RequestMapping(path = "addGroups", method = POST)
    public Result<Integer> addGroups(@RequestBody List<Group> list) {
        try {
            groupService.addItems(list);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }


    @ApiOperation(value = "按id删除组信息", notes = "删除组信息")
    @RequestMapping(path = "delGroup", method = DELETE)
    public Result<Integer> delGroup(@RequestParam String groupId) {
        try {
            groupService.delItem(groupId);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }


    @ApiOperation(value = "批量删除组信息", notes = "批量删除组信息")
    @RequestMapping(path = "delGroups", method = DELETE)
    public Result<Integer> delGroups(@RequestParam List<String> groupIds) {
        try {
            groupService.delItems(groupIds);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }


    @ApiOperation(value = "修改组信息", notes = "修改组信息")
    @RequestMapping(path = "updateGroup", method = PUT)
    public Result<Integer> updateGroup(@RequestBody Group group) {
        try {
            groupService.updateItem(group);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }

    @ApiOperation(value = "批量修改组信息", notes = "批量修改组信息")
    @RequestMapping(path = "updateGroups", method = PUT)
    public Result<Integer> updateGroups(@RequestBody List<Group> dlist) {
        try {
            groupService.updateItems(dlist);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }

}
