package app.system.form.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

/**
 * Created by real on 2018/3/12.
 */
@ApiModel("控件模型")
public class FieldModel {

    @ApiModelProperty("控件ID")
    private String id;

    @ApiModelProperty("formID")
    private String formId;

    @ApiModelProperty("基础控件ID")
    private String fieldId;

    @ApiModelProperty("控件名称")
    private String itemTitle;

    @ApiModelProperty("提示")
    private String itemPrompt;

    @ApiModelProperty("控件码")
    private String itemCode;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("操作时间")
    private Date operationDate;

    @ApiModelProperty("操作人")
    private String operationPersion;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public String getFieldId() {
        return fieldId;
    }

    public void setFieldId(String fieldId) {
        this.fieldId = fieldId;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public String getItemPrompt() {
        return itemPrompt;
    }

    public void setItemPrompt(String itemPrompt) {
        this.itemPrompt = itemPrompt;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
        this.operationPersion = operationPersion;
    }

}
