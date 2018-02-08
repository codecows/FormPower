package app.management.departmentinfo.controller;

import app.base.Result;
import app.comn.ResponseCode;
import app.management.departmentinfo.model.DepartmentInfo;
import app.management.departmentinfo.service.DepartmentInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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




    @ApiOperation(value = "查找用户所在部门信息",
            notes = "查找用户所在部门信息")
    @RequestMapping(path = "getDeptInfo/{userId}", method = GET)
    public Result<List<DepartmentInfo>> getDept(@PathVariable String userId) {
        return new Result<>(ResponseCode.Success, departmentInfoService.getItem(userId));
    }


}
