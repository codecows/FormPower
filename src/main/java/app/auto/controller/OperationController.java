package app.auto.controller;

import app.auto.entities.SysBaseTabEntity;
import app.auto.model.BaseFunctionModel;
import app.auto.service.BaseOperationService;
import app.auto.service.BaseTableTmplService;
import net.sf.json.JSONObject;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("operation")
public class OperationController {

    @Resource
    private BaseTableTmplService baseTableTmplService;

    @Resource
    private BaseOperationService baseOperationService;

    @RequestMapping(path = "createTable/{tablename}/{tmplname}", method = GET)
    public void createTable(@PathVariable String tablename, @PathVariable String tmplname) {

        List<SysBaseTabEntity> tableBody = baseTableTmplService.getTableBody(tmplname);

        baseOperationService.createTable(tablename, tableBody);
    }

    @RequestMapping(path = "addColumn/{tablename}", method = POST)
    public void addColumn(@PathVariable String tablename, @RequestBody SysBaseTabEntity sysBaseTabEntity) {

        //todo 测试addColumn
        //todo SysBaseTabEntity为表列模型

        ArrayList<Object> objects = new ArrayList<>();
        objects.add(sysBaseTabEntity);

        baseOperationService.addColumn(tablename, objects);

    }

    @RequestMapping(path = "createFunction/{base64Param}", method = GET)
    public void createFunction(@PathVariable String base64Param) {


        byte[] bytes = Base64Utils.decodeFromString(base64Param);
        String param = new String(bytes);


        JSONObject jsonObject = JSONObject.fromObject(param);
        BaseFunctionModel baseFunctionModel = (BaseFunctionModel) JSONObject.toBean(jsonObject, BaseFunctionModel.class);


        baseOperationService.createFunction(baseFunctionModel);

    }
}
