package app.system.auto.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Fan on 2018/2/27.
 */

@ApiModel("函数模型")
public class BaseFunctionModel {

    @ApiModelProperty("函数名称")
    private String funcName;
    @ApiModelProperty("参数列表，p1 type,p2 type类型的字符串")
    private String funcPara;
    @ApiModelProperty("返回值类型，如果无返回值为 void")
    private String funcReturnPara;
    @ApiModelProperty("函数体")
    private String funcBody;

    public String getFuncName() {
        return funcName;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }

    public String getFuncPara() {
        return funcPara;
    }

    public void setFuncPara(String funcPara) {
        this.funcPara = funcPara;
    }

    public String getFuncReturnPara() {
        return funcReturnPara;
    }

    public void setFuncReturnPara(String funcReturnPara) {
        this.funcReturnPara = funcReturnPara;
    }

    public String getFuncBody() {
        return funcBody;
    }

    public void setFuncBody(String funcBody) {
        this.funcBody = funcBody;
    }
}
