package app.company.controller;


import app.base.Result;
import app.comn.PageModel;
import app.comn.ResponseCode;
import app.comn.ServiceException;
import app.company.model.Company;
import app.company.service.CompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Api(description = "公司信息管理接口")
@RestController
@RequestMapping("management/comp")
public class CompanyController {

    @Resource
    private CompanyService companyService;


    @ApiOperation(value = "获取所有公司信息",
            notes = "获取所有公司信息,返回List",
            responseContainer = "List",
            response = Company.class)
    @RequestMapping(path = "getComps", method = GET)
    public Result<List<Company>> getComps() {
        return new Result<>(ResponseCode.Success, companyService.getItems());
    }

    @ApiOperation(value = "分页获取所有公司信息",
            notes = "分页获取所有公司信息,返回List",
            responseContainer = "List",
            response = Company.class)
    @RequestMapping(path = "getCompsByPage", method = GET)
    public PageModel<Company> getCompsByPage(@RequestParam int pageNum, @RequestParam int pageSize) {
        PageModel<Company> itemsByPage = companyService.getItemsByPage(pageNum, pageSize);
        return itemsByPage;
    }

    @ApiOperation(value = "按id查找公司信息",
            notes = "按id查找公司信息")
    @RequestMapping(path = "getComp", method = GET)
    public Result<Company> getComp(@RequestParam String depaId) {
        return new Result<>(ResponseCode.Success, companyService.getItem(depaId));
    }

    @ApiOperation(value = "新增公司信息", notes = "新增公司信息")
    @RequestMapping(path = "addComp", method = POST)
    public Result<Integer> addComp(@RequestBody Company company) {
        try {
            companyService.addItem(company);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }


    @ApiOperation(value = "批量新增公司信息", notes = "批量新增公司信息")
    @RequestMapping(path = "addComps", method = POST)
    public Result<Integer> addComps(@RequestBody List<Company> list) {
        try {
            companyService.addItems(list);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }


    @ApiOperation(value = "按id删除公司信息", notes = "按id删除公司信息")
    @RequestMapping(path = "delComp", method = DELETE)
    public Result<Integer> delComp(@RequestParam String authId) {
        try {
            companyService.delItem(authId);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }


    @ApiOperation(value = "批量删除公司信息", notes = "批量删除公司信息")
    @RequestMapping(path = "delComps", method = DELETE)
    public Result<Integer> delComps(@RequestParam List<String> authIds) {
        try {
            companyService.delItems(authIds);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }


    @ApiOperation(value = "修改公司信息", notes = "修改公司信息")
    @RequestMapping(path = "updateComp", method = PUT)
    public Result<Integer> updateComp(@RequestBody Company company) {
        try {
            companyService.updateItem(company);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }

    @ApiOperation(value = "批量修改公司信息", notes = "批量修改公司信息")
    @RequestMapping(path = "updateComps", method = PUT)
    public Result<Integer> updateComps(@RequestBody List<Company> alist) {
        try {
            companyService.updateItems(alist);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        return new Result<>(ResponseCode.Success);
    }

}
