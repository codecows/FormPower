package app.form.controller;

import app.base.Result;
import app.comn.PageModel;
import app.comn.ResponseCode;
import app.form.model.DataTableRequest;
import app.form.model.DataTableResponse;
import app.form.model.Form;
import app.form.service.FormService;
import app.utils.JsonUtil;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("form")
public class FormController {

    @Resource
    private FormService formService;

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
}
