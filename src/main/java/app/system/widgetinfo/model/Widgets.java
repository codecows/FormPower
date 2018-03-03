package app.system.widgetinfo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by real on 2018/2/6.
 */
@ApiModel("控件实体")
public class Widgets {

    @ApiModelProperty("控件ID")
    private String fieldId;

    @ApiModelProperty("控件名称")
    private String fieldName;

    @ApiModelProperty("列类型")
    private String columnType;

    @ApiModelProperty("控件图标")
    private String img;

    @ApiModelProperty("状态")
    private String status;

    @ApiModelProperty("排序号")
    private BigDecimal orderNum;

    @ApiModelProperty("所属控件组")
    private String groupId;

    @ApiModelProperty("控件属性列表")
    private List<FieldAttribute> fieldAttributeList;

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

    public List<FieldAttribute> getFieldAttributeList() {
        return fieldAttributeList;
    }

    public void setFieldAttributeList(List<FieldAttribute> fieldAttributeList) {
        this.fieldAttributeList = fieldAttributeList;
    }
}
