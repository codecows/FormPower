package app.system.form.controller;

import app.base.Result;
import app.comn.ResponseCode;
import app.comn.ServiceException;
import app.system.auto.entities.SysBaseTabEntity;
import app.system.auto.service.BaseOperationService;
import app.system.auto.service.BaseTableTmplService;
import app.system.form.model.DataTableRequest;
import app.system.form.model.DataTableResponse;
import app.system.form.model.Form;
import app.system.form.service.FormService;
import app.utils.JsonUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Api(description = "表单信息管理接口")
@RestController
@RequestMapping("system/form")
public class FormController {

    @Resource
    private FormService formService;

    @Resource
    private BaseOperationService baseOperationService;

    @Resource
    private BaseTableTmplService baseTableTmplService;

    @RequestMapping(path = "getFormList/{base64Param}", method = GET)
    public Result<DataTableResponse> getFormList(@PathVariable String base64Param) {
        DataTableRequest dataTableRequest;
        try {
            byte[] bytes = Base64Utils.decodeFromString(base64Param);
            String param = new String(bytes);
            dataTableRequest = JsonUtil.toJson(param, DataTableRequest.class);
        } catch (IOException e) {
            return new Result<>(ResponseCode.SerializeError);
        }

//        List<Form> formList = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            Form form = new Form();
//            form.setFormId("F00" + i);
//            form.setFormName("表单" + i);
//            form.setRemark("备注" + i);
//            form.setInUse(i);
//            formList.add(form);
//        }
        //todo pageNum,pageSize需要前端传值。
        List<Form> itemsByPage = formService.getItemsByPage(dataTableRequest.getStart(), dataTableRequest.getLength());
        DataTableResponse<Form> dr = new DataTableResponse<>(dataTableRequest.getDraw(),
                100, 100, itemsByPage);

        return new Result<>(ResponseCode.Success, dr);
    }

    @ApiOperation(value = "新增表单定义",
            notes = "新增表单，同时建立基础表")
    @RequestMapping(path = "addForm", method = POST)
    public Result<Integer> addForm(@RequestBody Form form) {
        //向表单定义表中增加数据
        try {
            formService.addItem(form);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        //新建基础表
        String tablename = "auto_t_" + form.getFormId();
        String comment = form.getFormName();
        List<SysBaseTabEntity> base_tab = baseTableTmplService.getTableBody("base_tab");

        baseOperationService.createTable(tablename, comment, base_tab);
        return new Result<>(ResponseCode.Success);
    }

    @ApiOperation(value = "删除表单定义",
            notes = "删除表单，同时删除基础表")
    @RequestMapping(path = "delForm/{formId}", method = POST)
    public Result<Integer> delForm(@PathVariable String formId) {
        //删除表单定义表中数据
        try {
            formService.delItem(formId);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }
        //删除基础表
        String tablename = "auto_t_" + formId;

        baseOperationService.dropTable(tablename);
        return new Result<>(ResponseCode.Success);
    }
}
