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
    private String controlId;

    @ApiModelProperty("控件名称")
    private String controlName;

    @ApiModelProperty("控件图标")
    private String img;

    @ApiModelProperty("状态")
    private String status;

    @ApiModelProperty("排序号")
    private BigDecimal orderNum;

    @ApiModelProperty("所属控件组")
    private String groupId;

    @ApiModelProperty("控件属性列表")
    private List<ControlAttribute> controlAttributeList;

    public String getControlId() {
        return controlId;
    }

    public void setControlId(String controlId) {
        this.controlId = controlId;
    }

    public String getControlName() {
        return controlName;
    }

    public void setControlName(String controlName) {
        this.controlName = controlName;
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

    public List<ControlAttribute> getControlAttributeList() {
        return controlAttributeList;
    }

    public void setControlAttributeList(List<ControlAttribute> controlAttributeList) {
        this.controlAttributeList = controlAttributeList;
    }
}
