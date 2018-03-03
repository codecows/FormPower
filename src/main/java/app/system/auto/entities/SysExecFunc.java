package app.system.auto.entities;

import java.util.Date;

public class SysExecFunc {

    /*
    * 数据表sys_exec_func实体，用来存储函数信息
    * */
    private String id;

    /*关联的对象id，比如，formid，columnid*/
    private String objectId;

    /*对象类型，比如，表单，列等等*/
    private String objectType;

    /*函数名称*/
    private String funcName;

    /*参数列表：'para1 type,para2 type' 类型的字符串*/
    private String funcPara;

    /*返回值类型*/
    private String funcReturnPara;

    /*函数体*/
    private String funcBody;

    /*触发条件，比如，新增数据时等等*/
    private String onAction;

    /*记录状态，有效，失效等*/
    private String status;

    /*创建时间*/
    private Date createDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId == null ? null : objectId.trim();
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType == null ? null : objectType.trim();
    }

    public String getFuncName() {
        return funcName;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName == null ? null : funcName.trim();
    }

    public String getFuncPara() {
        return funcPara;
    }

    public void setFuncPara(String funcPara) {
        this.funcPara = funcPara == null ? null : funcPara.trim();
    }

    public String getFuncReturnPara() {
        return funcReturnPara;
    }

    public void setFuncReturnPara(String funcReturnPara) {
        this.funcReturnPara = funcReturnPara == null ? null : funcReturnPara.trim();
    }

    public String getFuncBody() {
        return funcBody;
    }

    public void setFuncBody(String funcBody) {
        this.funcBody = funcBody == null ? null : funcBody.trim();
    }

    public String getOnAction() {
        return onAction;
    }

    public void setOnAction(String onAction) {
        this.onAction = onAction == null ? null : onAction.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}