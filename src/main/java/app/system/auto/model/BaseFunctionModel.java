package app.system.auto.model;

/**
 * Created by Fan on 2018/2/27.
 */
public class BaseFunctionModel {

    private String funcName;
    private String funcPara;
    private String funcReturnPara;
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
