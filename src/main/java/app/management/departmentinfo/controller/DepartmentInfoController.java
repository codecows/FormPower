package app.management.departmentinfo.controller;

import app.base.Result;
import app.comn.ResponseCode;
import app.management.departmentinfo.model.DepartmentInfo;
import app.management.departmentinfo.service.DepartmentInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Api(description = "部门综合查询接口")
@RestController
@RequestMapping("management/deptinfo")
public class DepartmentInfoController {
    @Resource
    private DepartmentInfoService departmentInfoService;


//    @ApiOperation(value = "获取所有部门信息",
//            notes = "获取所有部门信息,返回List",
//            responseContainer = "List",
//            response = Department.class)
//    @RequestMapping(path = "getDepts", method = GET)
//    public Result<List<Department>> getDepts() {
//        return new Result<>(ResponseCode.Success,departmentService.getItems());
//    }
//
//    @ApiOperation(value = "分页获取所有部门信息",
//            notes = "分页获取所有部门信息,返回List",
//            responseContainer = "List",
//            response = Department.class)
//    @RequestMapping(path = "getDeptsByPage", method = GET)
//    public PageModel<Department> getDeptsByPage(@RequestParam int pageNum, @RequestParam int pageSize) {
//        PageModel<Department> itemsByPage = departmentService.getItemsByPage(pageNum, pageSize);
//        return itemsByPage;
//    }

    @ApiOperation(value = "查找用户所在部门信息",
            notes = "查找用户所在部门信息")
    @RequestMapping(path = "getDeptInfo", method = GET)
    public Result<List<DepartmentInfo>> getDept(@RequestParam String userId) {
        return new Result<>(ResponseCode.Success, departmentInfoService.getItem(userId));
    }

//    @ApiOperation(value = "新增部门信息", notes = "新增部门信息")
//    @RequestMapping(path = "addDept", method = POST)
//    public Result<Integer> addDept(@RequestBody Department department) {
//        try {
//            departmentService.addItem(department);
//        } catch (ServiceException e) {
//            return new Result<>(e.getResponseCode());
//        }
//        return new Result<>(ResponseCode.Success);
//    }
//
//
//    @ApiOperation(value = "批量新增部门信息", notes = "批量新增部门信息")
//    @RequestMapping(path = "addDepts", method = POST)
//    public Result<Integer> addDepts(@RequestBody List<Department> list) {
//        try {
//            departmentService.addItems(list);
//        } catch (ServiceException e) {
//            return new Result<>(e.getResponseCode());
//        }
//        return new Result<>(ResponseCode.Success);
//    }
//
//
//
//    @ApiOperation(value = "按departmentid删除部门信息",notes = "删除部门信息")
//    @RequestMapping(path = "delDept", method = DELETE)
//    public Result<Integer> delDept(@RequestParam String depaId){
//        try {
//            departmentService.delItem(depaId);
//        } catch (ServiceException e) {
//            return new Result<>(e.getResponseCode());
//        }
//        return new Result<>(ResponseCode.Success);
//    }
//
//
//    @ApiOperation(value = "批量删除部门信息",notes = "批量删除部门信息")
//    @RequestMapping(path = "delDepts", method = DELETE)
//    public Result<Integer> delDepts(@RequestParam List<String> depaIds){
//        try {
//            departmentService.delItems(depaIds);
//        } catch (ServiceException e) {
//            return new Result<>(e.getResponseCode());
//        }
//        return new Result<>(ResponseCode.Success);
//    }
//
//
//    @ApiOperation(value = "修改部门信息", notes = "修改部门信息")
//    @RequestMapping(path = "updateDept", method = PUT)
//    public Result<Integer> updateDept(@RequestBody Department department) {
//        try {
//            departmentService.updateItem(department);
//        } catch (ServiceException e) {
//            return new Result<>(e.getResponseCode());
//        }
//        return new Result<>(ResponseCode.Success);
//    }
//
//    @ApiOperation(value = "批量修改部门信息", notes = "批量修改部门信息")
//    @RequestMapping(path = "updateDepts", method = PUT)
//    public Result<Integer> updateDepts(@RequestBody List<Department> dlist) {
//        try {
//            departmentService.updateItems(dlist);
//        } catch (ServiceException e) {
//            return new Result<>(e.getResponseCode());
//        }
//        return new Result<>(ResponseCode.Success);
//    }

}
