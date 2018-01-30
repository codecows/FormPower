package app.management.relation.controller;

import app.base.Result;
import app.comn.PageModel;
import app.comn.ResponseCode;
import app.comn.ServiceException;
import app.management.relation.model.*;
import app.management.relation.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Api(description = "关系表管理接口")
@RestController
@RequestMapping("management/relation")
public class RelationController {
    /***********************************************
     * 用户角色关系表
     * **********************************************/
    @Resource
    private UserRoleRelService userRoleRelService;

    @ApiOperation(value = "分页获取所有用户角色关系信息",
            notes = "分页获取所有用户角色关系信息,返回List",
            responseContainer = "List",
            response = UserRoleRel.class)
    @RequestMapping(path = "getUserRoleRelByPage", method = GET)
    public PageModel<UserRoleRel> getUserRoleRelByPage(@RequestParam int pageNum, @RequestParam int pageSize) {
        PageModel<UserRoleRel> itemsByPage = userRoleRelService.getItemsByPage(pageNum, pageSize);
        return itemsByPage;
    }


    @ApiOperation(value = "新增用户角色关系", notes = "新增用户角色关系")
    @RequestMapping(path = "addUserRoleRel", method = POST)
    public Result<Integer> addUserRoleRel(@RequestBody UserRoleRel userRoleRel) {
        try {
            userRoleRelService.addItem(userRoleRel);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }


    @ApiOperation(value = "批量新增用户角色关系", notes = "批量新增用户角色关系")
    @RequestMapping(path = "addUserRoleRels", method = POST)
    public Result<Integer> addUserRoleRels(@RequestBody List<UserRoleRel> list) {
        try {
            userRoleRelService.addItems(list);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }


    @ApiOperation(value = "按id删除用户角色关系", notes = "删除用户角色关系")
    @RequestMapping(path = "delUserRoleRel", method = DELETE)
    public Result<Integer> delUserRoleRel(@RequestParam String urIds) {
        try {
            userRoleRelService.delItem(urIds);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }


    @ApiOperation(value = "批量删除用户角色关系", notes = "批量删除用户角色关系")
    @RequestMapping(path = "delUserRoleRels", method = DELETE)
    public Result<Integer> delUserRoleRels(@RequestParam List<String> urIds) {
        try {
            userRoleRelService.delItems(urIds);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }


    @ApiOperation(value = "修改用户角色关系", notes = "修改用户角色关系")
    @RequestMapping(path = "updateUserRoleRel", method = PUT)
    public Result<Integer> updateUserRoleRel(@RequestBody UserRoleRel userRoleRel) {
        try {
            userRoleRelService.updateItem(userRoleRel);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }

    @ApiOperation(value = "批量修改用户角色关系", notes = "批量修改用户角色关系")
    @RequestMapping(path = "updateUserRoleRels", method = PUT)
    public Result<Integer> updateUserRoleRels(@RequestBody List<UserRoleRel> dlist) {
        try {
            userRoleRelService.updateItems(dlist);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }


    /********************************************
     *用户部门关系表
     * *******************************************/

    @Resource
    private UserDepartmentRelService userDepartmentRelService;

    @ApiOperation(value = "分页获取所有用户部门关系信息",
            notes = "分页获取所有用户部门关系信息,返回List",
            responseContainer = "List",
            response = UserDepartmentRel.class)
    @RequestMapping(path = "getUserDepartmentRelByPage", method = GET)
    public PageModel<UserDepartmentRel> getUserDepartmentRelByPage(@RequestParam int pageNum, @RequestParam int pageSize) {
        PageModel<UserDepartmentRel> itemsByPage = userDepartmentRelService.getItemsByPage(pageNum, pageSize);
        return itemsByPage;
    }


    @ApiOperation(value = "新增用户部门关系", notes = "新增用户部门关系")
    @RequestMapping(path = "addUserDepartmentRel", method = POST)
    public Result<Integer> addUserDepartmentRel(@RequestBody UserDepartmentRel userDepartmentRel) {
        try {
            userDepartmentRelService.addItem(userDepartmentRel);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }


    @ApiOperation(value = "批量新增用户部门关系", notes = "批量新增用户部门关系")
    @RequestMapping(path = "addUserDepartmentRels", method = POST)
    public Result<Integer> addUserDepartmentRels(@RequestBody List<UserDepartmentRel> list) {
        try {
            userDepartmentRelService.addItems(list);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }


    @ApiOperation(value = "按id删除用户部门关系", notes = "删除用户部门关系")
    @RequestMapping(path = "delUserDepartmentRel", method = DELETE)
    public Result<Integer> delUserDepartmentRel(@RequestParam String urIds) {
        try {
            userDepartmentRelService.delItem(urIds);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }


    @ApiOperation(value = "批量删除用户部门关系", notes = "批量删除用户部门关系")
    @RequestMapping(path = "delUserDepartmentRels", method = DELETE)
    public Result<Integer> delUserDepartmentRels(@RequestParam List<String> urIds) {
        try {
            userDepartmentRelService.delItems(urIds);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }


    @ApiOperation(value = "修改用户部门关系", notes = "修改用户部门关系")
    @RequestMapping(path = "updateUserDepartmentRel", method = PUT)
    public Result<Integer> updateUserDepartmentRel(@RequestBody UserDepartmentRel userDepartmentRel) {
        try {
            userDepartmentRelService.updateItem(userDepartmentRel);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }

    @ApiOperation(value = "批量修改用户部门关系", notes = "批量修改用户部门关系")
    @RequestMapping(path = "updateUserDepartmentRels", method = PUT)
    public Result<Integer> updateUserDepartmentRels(@RequestBody List<UserDepartmentRel> dlist) {
        try {
            userDepartmentRelService.updateItems(dlist);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }


    /********************************************
     *用户与组关系表
     * *******************************************/

    @Resource
    private UserGroupRelService userGroupRelService;

    @ApiOperation(value = "分页获取所有用户与组关系信息",
            notes = "分页获取所有用户与组关系信息,返回List",
            responseContainer = "List",
            response = UserGroupRel.class)
    @RequestMapping(path = "getUserGroupRelByPage", method = GET)
    public PageModel<UserGroupRel> getUserGroupRelByPage(@RequestParam int pageNum, @RequestParam int pageSize) {
        PageModel<UserGroupRel> itemsByPage = userGroupRelService.getItemsByPage(pageNum, pageSize);
        return itemsByPage;
    }


    @ApiOperation(value = "新增用户与组关系", notes = "新增用户与组关系")
    @RequestMapping(path = "addUserGroupRel", method = POST)
    public Result<Integer> addUserGroupRel(@RequestBody UserGroupRel userGroupRel) {
        try {
            userGroupRelService.addItem(userGroupRel);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }


    @ApiOperation(value = "批量新增用户与组关系", notes = "批量新增用户与组关系")
    @RequestMapping(path = "addUserGroupRels", method = POST)
    public Result<Integer> addUserGroupRels(@RequestBody List<UserGroupRel> list) {
        try {
            userGroupRelService.addItems(list);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }


    @ApiOperation(value = "按id删除用户与组关系", notes = "删除用户与组关系")
    @RequestMapping(path = "delUserGroupRel", method = DELETE)
    public Result<Integer> delUserGroupRel(@RequestParam String urIds) {
        try {
            userGroupRelService.delItem(urIds);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }


    @ApiOperation(value = "批量删除用户与组关系", notes = "批量删除用户与组关系")
    @RequestMapping(path = "delUserGroupRels", method = DELETE)
    public Result<Integer> delUserGroupRels(@RequestParam List<String> urIds) {
        try {
            userGroupRelService.delItems(urIds);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }


    @ApiOperation(value = "修改用户与组关系", notes = "修改用户与组关系")
    @RequestMapping(path = "updateUserGroupRel", method = PUT)
    public Result<Integer> updateUserGroupRel(@RequestBody UserGroupRel userGroupRel) {
        try {
            userGroupRelService.updateItem(userGroupRel);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }

    @ApiOperation(value = "批量修改用户与组关系", notes = "批量修改用户与组关系")
    @RequestMapping(path = "updateUserGroupRels", method = PUT)
    public Result<Integer> updateUserGroupRels(@RequestBody List<UserGroupRel> dlist) {
        try {
            userGroupRelService.updateItems(dlist);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }


    /********************************************
     *用户权限关系表
     * *******************************************/

    @Resource
    private UserAuthRelService userAuthRelService;

    @ApiOperation(value = "分页获取所有用户权限关系信息",
            notes = "分页获取所有用户权限关系信息,返回List",
            responseContainer = "List",
            response = UserAuthRel.class)
    @RequestMapping(path = "getUserAuthRelByPage", method = GET)
    public PageModel<UserAuthRel> getUserAuthRelByPage(@RequestParam int pageNum, @RequestParam int pageSize) {
        PageModel<UserAuthRel> itemsByPage = userAuthRelService.getItemsByPage(pageNum, pageSize);
        return itemsByPage;
    }


    @ApiOperation(value = "新增用户权限关系", notes = "新增用户权限关系")
    @RequestMapping(path = "addUserAuthRel", method = POST)
    public Result<Integer> addUserAuthRel(@RequestBody UserAuthRel userAuthRel) {
        try {
            userAuthRelService.addItem(userAuthRel);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }


    @ApiOperation(value = "批量新增用户权限关系", notes = "批量新增用户权限关系")
    @RequestMapping(path = "addUserAuthRels", method = POST)
    public Result<Integer> addUserAuthRels(@RequestBody List<UserAuthRel> list) {
        try {
            userAuthRelService.addItems(list);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }


    @ApiOperation(value = "按id删除用户权限关系", notes = "删除用户权限关系")
    @RequestMapping(path = "delUserAuthRel", method = DELETE)
    public Result<Integer> delUserAuthRel(@RequestParam String urIds) {
        try {
            userAuthRelService.delItem(urIds);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }


    @ApiOperation(value = "批量删除用户权限关系", notes = "批量删除用户权限关系")
    @RequestMapping(path = "delUserAuthRels", method = DELETE)
    public Result<Integer> delUserAuthRels(@RequestParam List<String> urIds) {
        try {
            userAuthRelService.delItems(urIds);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }


    @ApiOperation(value = "修改用户权限关系", notes = "修改用户权限关系")
    @RequestMapping(path = "updateUserAuthRel", method = PUT)
    public Result<Integer> updateUserAuthRel(@RequestBody UserAuthRel userAuthRel) {
        try {
            userAuthRelService.updateItem(userAuthRel);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }

    @ApiOperation(value = "批量修改用户权限关系", notes = "批量修改用户权限关系")
    @RequestMapping(path = "updateUserAuthRels", method = PUT)
    public Result<Integer> updateUserAuthRels(@RequestBody List<UserAuthRel> dlist) {
        try {
            userAuthRelService.updateItems(dlist);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }


    /********************************************
     *角色权限关系表
     * *******************************************/

    @Resource
    private RoleAuthRelService roleAuthRelService;

    @ApiOperation(value = "分页获取所有角色权限关系信息",
            notes = "分页获取所有角色权限关系信息,返回List",
            responseContainer = "List",
            response = RoleAuthRel.class)
    @RequestMapping(path = "getRoleAuthRelByPage", method = GET)
    public PageModel<RoleAuthRel> getRoleAuthRelByPage(@RequestParam int pageNum, @RequestParam int pageSize) {
        PageModel<RoleAuthRel> itemsByPage = roleAuthRelService.getItemsByPage(pageNum, pageSize);
        return itemsByPage;
    }


    @ApiOperation(value = "新增角色权限关系", notes = "新增角色权限关系")
    @RequestMapping(path = "addRoleAuthRel", method = POST)
    public Result<Integer> addRoleAuthRel(@RequestBody RoleAuthRel RoleAuthRel) {
        try {
            roleAuthRelService.addItem(RoleAuthRel);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }


    @ApiOperation(value = "批量新增角色权限关系", notes = "批量新增角色权限关系")
    @RequestMapping(path = "addRoleAuthRels", method = POST)
    public Result<Integer> addRoleAuthRels(@RequestBody List<RoleAuthRel> list) {
        try {
            roleAuthRelService.addItems(list);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }


    @ApiOperation(value = "按id删除角色权限关系", notes = "删除角色权限关系")
    @RequestMapping(path = "delRoleAuthRel", method = DELETE)
    public Result<Integer> delRoleAuthRel(@RequestParam String urIds) {
        try {
            roleAuthRelService.delItem(urIds);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }


    @ApiOperation(value = "批量删除角色权限关系", notes = "批量删除角色权限关系")
    @RequestMapping(path = "delRoleAuthRels", method = DELETE)
    public Result<Integer> delRoleAuthRels(@RequestParam List<String> urIds) {
        try {
            roleAuthRelService.delItems(urIds);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }


    @ApiOperation(value = "修改角色权限关系", notes = "修改角色权限关系")
    @RequestMapping(path = "updateRoleAuthRel", method = PUT)
    public Result<Integer> updateRoleAuthRel(@RequestBody RoleAuthRel RoleAuthRel) {
        try {
            roleAuthRelService.updateItem(RoleAuthRel);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }

    @ApiOperation(value = "批量修改角色权限关系", notes = "批量修改角色权限关系")
    @RequestMapping(path = "updateRoleAuthRels", method = PUT)
    public Result<Integer> updateRoleAuthRels(@RequestBody List<RoleAuthRel> dlist) {
        try {
            roleAuthRelService.updateItems(dlist);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }

    /********************************************
     *组角色关系表
     * *******************************************/

    @Resource
    private GroupRoleRelService groupRoleRelService;

    @ApiOperation(value = "分页获取所有组角色关系信息",
            notes = "分页获取所有组角色关系信息,返回List",
            responseContainer = "List",
            response = GroupRoleRel.class)
    @RequestMapping(path = "getGroupRoleRelByPage", method = GET)
    public PageModel<GroupRoleRel> getGroupRoleRelByPage(@RequestParam int pageNum, @RequestParam int pageSize) {
        PageModel<GroupRoleRel> itemsByPage = groupRoleRelService.getItemsByPage(pageNum, pageSize);
        return itemsByPage;
    }


    @ApiOperation(value = "新增组角色关系", notes = "新增组角色关系")
    @RequestMapping(path = "addGroupRoleRel", method = POST)
    public Result<Integer> addGroupRoleRel(@RequestBody GroupRoleRel groupRoleRel) {
        try {
            groupRoleRelService.addItem(groupRoleRel);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }


    @ApiOperation(value = "批量新增组角色关系", notes = "批量新增组角色关系")
    @RequestMapping(path = "addGroupRoleRels", method = POST)
    public Result<Integer> addGroupRoleRels(@RequestBody List<GroupRoleRel> list) {
        try {
            groupRoleRelService.addItems(list);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }


    @ApiOperation(value = "按id删除组角色关系", notes = "删除组角色关系")
    @RequestMapping(path = "delGroupRoleRel", method = DELETE)
    public Result<Integer> delGroupRoleRel(@RequestParam String urIds) {
        try {
            groupRoleRelService.delItem(urIds);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }


    @ApiOperation(value = "批量删除组角色关系", notes = "批量删除组角色关系")
    @RequestMapping(path = "delGroupRoleRels", method = DELETE)
    public Result<Integer> delGroupRoleRels(@RequestParam List<String> urIds) {
        try {
            groupRoleRelService.delItems(urIds);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }


    @ApiOperation(value = "修改组角色关系", notes = "修改组角色关系")
    @RequestMapping(path = "updateGroupRoleRel", method = PUT)
    public Result<Integer> updateGroupRoleRel(@RequestBody GroupRoleRel groupRoleRel) {
        try {
            groupRoleRelService.updateItem(groupRoleRel);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }

    @ApiOperation(value = "批量修改组角色关系", notes = "批量修改组角色关系")
    @RequestMapping(path = "updateGroupRoleRels", method = PUT)
    public Result<Integer> updateGroupRoleRels(@RequestBody List<GroupRoleRel> dlist) {
        try {
            groupRoleRelService.updateItems(dlist);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }


    /********************************************
     *组权限关系表
     * *******************************************/

    @Resource
    private GroupAuthRelService GroupAuthRelService;

    @ApiOperation(value = "分页获取所有组权限关系信息",
            notes = "分页获取所有组权限关系信息,返回List",
            responseContainer = "List",
            response = GroupAuthRel.class)
    @RequestMapping(path = "getGroupAuthRelByPage", method = GET)
    public PageModel<GroupAuthRel> getGroupAuthRelByPage(@RequestParam int pageNum, @RequestParam int pageSize) {
        PageModel<GroupAuthRel> itemsByPage = GroupAuthRelService.getItemsByPage(pageNum, pageSize);
        return itemsByPage;
    }


    @ApiOperation(value = "新增组权限关系", notes = "新增组权限关系")
    @RequestMapping(path = "addGroupAuthRel", method = POST)
    public Result<Integer> addGroupAuthRel(@RequestBody GroupAuthRel GroupAuthRel) {
        try {
            GroupAuthRelService.addItem(GroupAuthRel);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }


    @ApiOperation(value = "批量新增组权限关系", notes = "批量新增组权限关系")
    @RequestMapping(path = "addGroupAuthRels", method = POST)
    public Result<Integer> addGroupAuthRels(@RequestBody List<GroupAuthRel> list) {
        try {
            GroupAuthRelService.addItems(list);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }


    @ApiOperation(value = "按id删除组权限关系", notes = "删除组权限关系")
    @RequestMapping(path = "delGroupAuthRel", method = DELETE)
    public Result<Integer> delGroupAuthRel(@RequestParam String urIds) {
        try {
            GroupAuthRelService.delItem(urIds);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }


    @ApiOperation(value = "批量删除组权限关系", notes = "批量删除组权限关系")
    @RequestMapping(path = "delGroupAuthRels", method = DELETE)
    public Result<Integer> delGroupAuthRels(@RequestParam List<String> urIds) {
        try {
            GroupAuthRelService.delItems(urIds);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }


    @ApiOperation(value = "修改组权限关系", notes = "修改组权限关系")
    @RequestMapping(path = "updateGroupAuthRel", method = PUT)
    public Result<Integer> updateGroupAuthRel(@RequestBody GroupAuthRel GroupAuthRel) {
        try {
            GroupAuthRelService.updateItem(GroupAuthRel);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }

    @ApiOperation(value = "批量修改组权限关系", notes = "批量修改组权限关系")
    @RequestMapping(path = "updateGroupAuthRels", method = PUT)
    public Result<Integer> updateGroupAuthRels(@RequestBody List<GroupAuthRel> dlist) {
        try {
            GroupAuthRelService.updateItems(dlist);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }

    /********************************************
     *公司部门关系表
     * *******************************************/

    @Resource
    private CompanyDeptRelService companyDeptRelService;

    @ApiOperation(value = "分页获取所有公司部门关系信息",
            notes = "分页获取所有公司部门关系信息,返回List",
            responseContainer = "List",
            response = CompanyDeptRel.class)
    @RequestMapping(path = "getCompanyDeptRelByPage", method = GET)
    public PageModel<CompanyDeptRel> getCompanyDeptRelByPage(@RequestParam int pageNum, @RequestParam int pageSize) {
        PageModel<CompanyDeptRel> itemsByPage = companyDeptRelService.getItemsByPage(pageNum, pageSize);
        return itemsByPage;
    }


    @ApiOperation(value = "新增公司部门关系", notes = "新增公司部门关系")
    @RequestMapping(path = "addCompanyDeptRel", method = POST)
    public Result<Integer> addCompanyDeptRel(@RequestBody CompanyDeptRel companyDeptRel) {
        try {
            companyDeptRelService.addItem(companyDeptRel);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }


    @ApiOperation(value = "批量新增公司部门关系", notes = "批量新增公司部门关系")
    @RequestMapping(path = "addCompanyDeptRels", method = POST)
    public Result<Integer> addCompanyDeptRels(@RequestBody List<CompanyDeptRel> list) {
        try {
            companyDeptRelService.addItems(list);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }


    @ApiOperation(value = "按id删除公司部门关系", notes = "删除公司部门关系")
    @RequestMapping(path = "delCompanyDeptRel", method = DELETE)
    public Result<Integer> delCompanyDeptRel(@RequestParam String urIds) {
        try {
            companyDeptRelService.delItem(urIds);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }


    @ApiOperation(value = "批量删除公司部门关系", notes = "批量删除公司部门关系")
    @RequestMapping(path = "delCompanyDeptRels", method = DELETE)
    public Result<Integer> delCompanyDeptRels(@RequestParam List<String> urIds) {
        try {
            companyDeptRelService.delItems(urIds);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }


    @ApiOperation(value = "修改公司部门关系", notes = "修改公司部门关系")
    @RequestMapping(path = "updateCompanyDeptRel", method = PUT)
    public Result<Integer> updateCompanyDeptRel(@RequestBody CompanyDeptRel companyDeptRel) {
        try {
            companyDeptRelService.updateItem(companyDeptRel);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }

    @ApiOperation(value = "批量修改公司部门关系", notes = "批量修改公司部门关系")
    @RequestMapping(path = "updateCompanyDeptRels", method = PUT)
    public Result<Integer> updateCompanyDeptRels(@RequestBody List<CompanyDeptRel> dlist) {
        try {
            companyDeptRelService.updateItems(dlist);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }

    /********************************************
     *权限菜单关系表
     * *******************************************/

    @Resource
    private AuthMenuRelService authMenuRelService;

    @ApiOperation(value = "分页获取所有权限菜单关系信息",
            notes = "分页获取所有权限菜单关系信息,返回List",
            responseContainer = "List",
            response = AuthMenuRel.class)
    @RequestMapping(path = "getAuthMenuRelByPage", method = GET)
    public PageModel<AuthMenuRel> getAuthMenuRelByPage(@RequestParam int pageNum, @RequestParam int pageSize) {
        PageModel<AuthMenuRel> itemsByPage = authMenuRelService.getItemsByPage(pageNum, pageSize);
        return itemsByPage;
    }


    @ApiOperation(value = "新增权限菜单关系", notes = "新增权限菜单关系")
    @RequestMapping(path = "addAuthMenuRel", method = POST)
    public Result<Integer> addAuthMenuRel(@RequestBody AuthMenuRel authMenuRel) {
        try {
            authMenuRelService.addItem(authMenuRel);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }


    @ApiOperation(value = "批量新增权限菜单关系", notes = "批量新增权限菜单关系")
    @RequestMapping(path = "addAuthMenuRels", method = POST)
    public Result<Integer> addAuthMenuRels(@RequestBody List<AuthMenuRel> list) {
        try {
            authMenuRelService.addItems(list);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }


    @ApiOperation(value = "按id删除权限菜单关系", notes = "删除权限菜单关系")
    @RequestMapping(path = "delAuthMenuRel", method = DELETE)
    public Result<Integer> delAuthMenuRel(@RequestParam String urIds) {
        try {
            authMenuRelService.delItem(urIds);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }


    @ApiOperation(value = "批量删除权限菜单关系", notes = "批量删除权限菜单关系")
    @RequestMapping(path = "delAuthMenuRels", method = DELETE)
    public Result<Integer> delAuthMenuRels(@RequestParam List<String> urIds) {
        try {
            authMenuRelService.delItems(urIds);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }


    @ApiOperation(value = "修改权限菜单关系", notes = "修改权限菜单关系")
    @RequestMapping(path = "updateAuthMenuRel", method = PUT)
    public Result<Integer> updateAuthMenuRel(@RequestBody AuthMenuRel authMenuRel) {
        try {
            authMenuRelService.updateItem(authMenuRel);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }

    @ApiOperation(value = "批量修改权限菜单关系", notes = "批量修改权限菜单关系")
    @RequestMapping(path = "updateAuthMenuRels", method = PUT)
    public Result<Integer> updateAuthMenuRels(@RequestBody List<AuthMenuRel> dlist) {
        try {
            authMenuRelService.updateItems(dlist);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }
}
