package app.auto.entities;

import java.util.Date;

public class SysExecFunc {
    private String id;

    private String objectId;

    private String objectType;

    private String funcName;

    private String funcPara;

    private String funcReturnPara;

    private String funcBody;

    private String onAction;

    private String status;

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