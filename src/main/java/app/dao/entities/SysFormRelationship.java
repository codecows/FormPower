package app.dao.entities;

import java.util.Date;

public class SysFormRelationship {
    private String rId;

    private String parentId;

    private String childId;

    private String relationshipType;

    private String relationshipValue;

    private Date operationDate;

    private String operationPersion;

    public String getrId() {
        return rId;
    }

    public void setrId(String rId) {
        this.rId = rId == null ? null : rId.trim();
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public String getChildId() {
        return childId;
    }

    public void setChildId(String childId) {
        this.childId = childId == null ? null : childId.trim();
    }

    public String getRelationshipType() {
        return relationshipType;
    }

    public void setRelationshipType(String relationshipType) {
        this.relationshipType = relationshipType == null ? null : relationshipType.trim();
    }

    public String getRelationshipValue() {
        return relationshipValue;
    }

    public void setRelationshipValue(String relationshipValue) {
        this.relationshipValue = relationshipValue == null ? null : relationshipValue.trim();
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