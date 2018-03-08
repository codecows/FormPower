package app.system.form.model;


import java.math.BigDecimal;
import java.util.Date;

public class Form {
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
        this.formId = formId;
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public String getFormGroup() {
        return formGroup;
    }

    public void setFormGroup(String formGroup) {
        this.formGroup = formGroup;
    }

    public String getFormImg() {
        return formImg;
    }

    public void setFormImg(String formImg) {
        this.formImg = formImg;
    }

    public String getfType() {
        return fType;
    }

    public void setfType(String fType) {
        this.fType = fType;
    }

    public String getIsSingle() {
        return isSingle;
    }

    public void setIsSingle(String isSingle) {
        this.isSingle = isSingle;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
        this.status = status;
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
        this.operationPersion = operationPersion;
    }
}
