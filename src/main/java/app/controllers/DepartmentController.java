package app.controllers;

import app.comn.PageModel;
import app.comn.ResponseCode;
import app.comn.ServiceException;
import app.model.Department;
import app.model.Result;
import app.services.DepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Api(description = "部门管理接口")
@RestController
@RequestMapping("management/dept")
public class DepartmentController {
    @Resource
    private DepartmentService departmentService;


    @ApiOperation(value = "获取所有部门信息",
            notes = "获取所有部门信息,返回List",
            responseContainer = "List",
            response = Department.class)
    @RequestMapping(path = "getDepts", method = GET)
    public Result<List<Department>> getDepts() {
        return new Result<>(ResponseCode.Success,departmentService.getItems());
    }

    @ApiOperation(value = "分页获取所有部门信息",
            notes = "分页获取所有部门信息,返回List",
            responseContainer = "List",
            response = Department.class)
    @RequestMapping(path = "getDeptsByPage", method = GET)
    public PageModel<Department> getDeptsByPage(@RequestParam int pageNum, @RequestParam int pageSize) {
        PageModel<Department> itemsByPage = departmentService.getItemsByPage(pageNum, pageSize);
        return itemsByPage;
    }

    @ApiOperation(value = "按departmentid查找部门信息",
            notes = "按departmentid查找部门信息")
    @RequestMapping(path = "getDept}", method = GET)
    public Result<Department> getDept(@RequestParam String depaId) {
        return new Result<>(ResponseCode.Success, departmentService.getItem(depaId));
    }

    @ApiOperation(value = "新增部门信息", notes = "新增部门信息")
    @RequestMapping(path = "addDept", method = POST)
    public Result<Integer> addDept(@RequestBody Department department) {
        try {
            departmentService.addItem(department);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }

    @ApiOperation(value = "按departmentid删除部门信息",notes = "删除部门信息")
    @RequestMapping(path = "delDept", method = DELETE)
    public Result<Integer> delDept(@RequestParam String depaId){
        try {
            departmentService.delItem(depaId);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }

    @ApiOperation(value = "修改部门信息", notes = "修改部门信息")
    @RequestMapping(path = "updateDept", method = PUT)
    public Result<Integer> updateDept(@RequestBody Department department) {
        try {
            departmentService.updateItem(department);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }
}
