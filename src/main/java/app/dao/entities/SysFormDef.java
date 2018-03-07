package app.dao.entities;

import java.math.BigDecimal;
import java.util.Date;

public class SysFormDef {
    private String formId;

    private String formName;

    private String formGroup;

    private String formImg;

    private String fType;

    private String isSingle;

    private String remark;

    private BigDecimal orderNum;

    private String status;

    private Date operationTime;

    private String operationPersion;

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId == null ? null : formId.trim();
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName == null ? null : formName.trim();
    }

    public String getFormGroup() {
        return formGroup;
    }

    public void setFormGroup(String formGroup) {
        this.formGroup = formGroup == null ? null : formGroup.trim();
    }

    public String getFormImg() {
        return formImg;
    }

    public void setFormImg(String formImg) {
        this.formImg = formImg == null ? null : formImg.trim();
    }

    public String getfType() {
        return fType;
    }

    public void setfType(String fType) {
        this.fType = fType == null ? null : fType.trim();
    }

    public String getIsSingle() {
        return isSingle;
    }

    public void setIsSingle(String isSingle) {
        this.isSingle = isSingle == null ? null : isSingle.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public BigDecimal getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(BigDecimal orderNum) {
        this.orderNum = orderNum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }

    public String getOperationPersion() {
        return operationPersion;
    }

    public void setOperationPersion(String operationPersion) {
        this.operationPersion = operationPersion == null ? null : operationPersion.trim();
    }
}