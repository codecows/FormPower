package app.system.widgetinfo.entities;


import java.math.BigDecimal;
import java.util.List;

/**
 * Created by real on 2018/2/6.
 */

public class WidgetsEntity {


    private String fieldId;

    private String fieldName;

    private String columnType;

    private String img;

    private String status;

    private BigDecimal orderNum;

    private String groupId;

    private List<FieldAttributeEntity> controlAttributeList;

    public String getFieldId() {
        return fieldId;
    }

    public void setFieldId(String fieldId) {
        this.fieldId = fieldId;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(BigDecimal orderNum) {
        this.orderNum = orderNum;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public List<FieldAttributeEntity> getControlAttributeList() {
        return controlAttributeList;
    }

    public void setControlAttributeList(List<FieldAttributeEntity> controlAttributeList) {
        this.controlAttributeList = controlAttributeList;
    }
}
