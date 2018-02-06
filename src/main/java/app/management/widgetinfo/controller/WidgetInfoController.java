package app.management.widgetinfo.controller;

import app.base.Result;
import app.comn.ResponseCode;
import app.management.widgetinfo.model.WidgetInfo;
import app.management.widgetinfo.service.WidgetInfoSercice;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Api(description = "控件信息列表接口")
@RestController
@RequestMapping("management/widgetInfo")
public class WidgetInfoController {
    @Resource
    private WidgetInfoSercice widgetInfoSercice;

    @ApiOperation(value = "查找所有状态为y的控件",
            notes = "查找所有状态为y的控件")
    @RequestMapping(path = "getWidgetInfo", method = GET)
    public Result<List<WidgetInfo>> getWidgetInfo() {
        return new Result<>(ResponseCode.Success, widgetInfoSercice.getItems());
    }


}
