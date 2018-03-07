package app.dao.entities;

import java.util.Date;

public class SysFormInformation {
    private String id;

    private String formId;

    private String fieldId;

    private String itemTitle;

    private String itemPrompt;

    private String itemCode;

    private String remark;

    private Date operationDate;

    private String operationPersion;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId == null ? null : formId.trim();
    }

    public String getFieldId() {
        return fieldId;
    }

    public void setFieldId(String fieldId) {
        this.fieldId = fieldId == null ? null : fieldId.trim();
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle == null ? null : itemTitle.trim();
    }

    public String getItemPrompt() {
        return itemPrompt;
    }

    public void setItemPrompt(String itemPrompt) {
        this.itemPrompt = itemPrompt == null ? null : itemPrompt.trim();
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode == null ? null : itemCode.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
    }

    public String getOperationPersion() {
        return operationPersion;
    }

    public void setOperationPersion(String operationPersion) {
        this.operationPersion = operationPersion == null ? null : operationPersion.trim();
    }
}