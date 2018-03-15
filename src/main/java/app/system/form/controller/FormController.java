package app.system.form.controller;

import app.base.Result;
import app.comn.ResponseCode;
import app.comn.ServiceException;
import app.system.form.model.DataTableRequest;
import app.system.form.model.DataTableResponse;
import app.system.form.model.FieldInfo;
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

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Api(description = "表单信息管理接口")
@RestController
@RequestMapping("system/form")
public class FormController {
    @Resource
    private FormService formService;



    @ApiOperation(value = "获取表单定义列表",
            notes = "分页获取表单列表")
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
    @RequestMapping(path = "createForm", method = POST)
    public Result<Integer> createForm(@RequestBody Form form) {
        //向表单定义表中增加数据
        try {
            formService.createForm(form);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }

        return new Result<>(ResponseCode.Success);
    }

    @ApiOperation(value = "删除表单定义",
            notes = "删除表单，同时删除基础表")
    @RequestMapping(path = "dropForm/{formId}", method = DELETE)
    public Result<Integer> dropForm(@PathVariable String formId) {
        //删除表单定义表中数据
        try {
            formService.dropForm(formId);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }

        return new Result<>(ResponseCode.Success);
    }

    @ApiOperation(value = "设计表单",
            notes = "设计表单，插入表单信息表数据，并修改其基础表")
    @RequestMapping(path = "designForm", method = POST)
    public Result<Integer> designForm(@RequestBody List<FieldInfo> fieldInfo) {
        /**
         * //todo FieldInfo对象为复合对象由fieldmodel加一个attributemodel类型的列表组成
         * fieldmodel为添加的一个控件，attributemodel是这个控件的属性。
         * 每一个控件必须至少包含5个属性，这5个属性表一旦创建不可修改。
         * attribute_code:fieldname,attribute_name:控件名称,attribute_value:"控件的名称比如：部门名称"
         * attribute_code:fieldcode,attribute_name:控件编码,attribute_value:"列名比如：f0001"
         * attribute_code:fieldtype,attribute_name:类型,attribute_value:"列类型比如：VARCHAR"
         * attribute_code:length,attribute_name:长度,attribute_value:"列长度比如：255"
         * attribute_code:smalllength,attribute_name:小数长度,attribute_value:"小数长度比如：0"
         **/


        try {
            formService.designForm(fieldInfo);
        } catch (ServiceException e) {
            return new Result<>(e.getResponseCode());
        }

        return new Result<>(ResponseCode.Success);
    }

    @ApiOperation(value = "获取表单设计信息",
            notes = "根据formid获取表单设计信息")
    @RequestMapping(path = "fatchFormDesignInformation/{formId}", method = GET)
    public Result<List<FieldInfo>> fatchFormDesignInformation(@PathVariable String formId) {
        return new Result<>(ResponseCode.Success, formService.fatchFormDesignInformation(formId));
    }
}
