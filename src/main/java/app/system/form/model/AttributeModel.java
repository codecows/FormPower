package app.system.form.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by real on 2018/3/12.
 */
@ApiModel("属性模型")
public class AttributeModel {

    @ApiModelProperty("属性ID")
    private String id;

    @ApiModelProperty("对象ID")
    private String objectId;

    @ApiModelProperty("属性编码")
    private String attributeCode;

    @ApiModelProperty("属性名称")
    private String attributeName;

    @ApiModelProperty("属性值")
    private String attributeValue;

    @ApiModelProperty("属性类型")
    private String attributeType;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("排序号")
    private BigDecimal orderNum;

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

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getAttributeCode() {
        return attributeCode;
    }

    public void setAttributeCode(String attributeCode) {
        this.attributeCode = attributeCode;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue;
    }

    public String getAttributeType() {
        return attributeType;
    }

    public void setAttributeType(String attributeType) {
        this.attributeType = attributeType;
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
