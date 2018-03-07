package app.dao.entities;

import java.math.BigDecimal;
import java.util.Date;

public class SysAttributeInformation {
    private String id;

    private String objectId;

    private String attributeId;

    private String attributeName;

    private String attributeValue;

    private String attributeType;

    private String remark;

    private BigDecimal orderNum;

    private Date operationDate;

    private String operationPersion;

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

    public String getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(String attributeId) {
        this.attributeId = attributeId == null ? null : attributeId.trim();
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName == null ? null : attributeName.trim();
    }

    public String getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue == null ? null : attributeValue.trim();
    }

    public String getAttributeType() {
        return attributeType;
    }

    public void setAttributeType(String attributeType) {
        this.attributeType = attributeType == null ? null : attributeType.trim();
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