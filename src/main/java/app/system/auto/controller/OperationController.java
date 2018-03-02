package app.system.auto.controller;

import app.base.Result;
import app.comn.ResponseCode;
import app.system.auto.entities.SysBaseTabEntity;
import app.system.auto.model.BaseFunctionModel;
import app.system.auto.model.ExecFunc;
import app.system.auto.service.BaseOperationService;
import app.system.auto.service.BaseTableTmplService;
import app.system.auto.service.SysExecFuncService;
import app.utils.JsonUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.BeanUtils;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Api(description = "系统自动化操作接口")
@RestController
@RequestMapping("system/operation")
public class OperationController {

    @Resource
    private BaseTableTmplService baseTableTmplService;

    @Resource
    private BaseOperationService baseOperationService;

    @Resource
    private SysExecFuncService sysExecFuncService;

    @RequestMapping(path = "createTable/{tablename}/{tablecomment}/{tmplname}", method = POST)
    public void createTable(@PathVariable String tablename, @PathVariable String tablecomment, @PathVariable String tmplname) {

        List<SysBaseTabEntity> tableBody = baseTableTmplService.getTableBody(tmplname);

        baseOperationService.createTable(tablename, tablecomment, tableBody);
    }

    @RequestMapping(path = "addColumn/{tablename}", method = POST)
    public void addColumn(@PathVariable String tablename, @RequestBody SysBaseTabEntity sysBaseTabEntity) {

        //todo 测试addColumn
        //todo SysBaseTabEntity为表列模型

        ArrayList<Object> objects = new ArrayList<>();
        objects.add(sysBaseTabEntity);

        baseOperationService.addColumn(tablename, objects);

    }

    @RequestMapping(path = "createFunction/{base64Param}", method = POST)
    public void createFunction(@PathVariable String base64Param) {

        BaseFunctionModel baseFunctionModel = null;
        try {
            byte[] bytes = Base64Utils.decodeFromString(base64Param);
            String param = new String(bytes);
            baseFunctionModel = JsonUtil.toJson(param, BaseFunctionModel.class);
        } catch (IOException e) {
            new Result<>(ResponseCode.SerializeError);
        }

        ExecFunc execFunc = new ExecFunc();

        BeanUtils.copyProperties(baseFunctionModel, execFunc);

        //todo 插入函数表需要考虑函数已存在的情况，待进一步处理
        sysExecFuncService.addItems(execFunc);

        baseOperationService.createFunction(baseFunctionModel);

    }

    @RequestMapping(path = "execFunction/{funcname}/{paralist}", method = POST)
    public Object execFunction(@PathVariable String funcname, @PathVariable String paralist) {

        Object o = baseOperationService.execFunction(funcname, paralist);
        return o;
    }
}
