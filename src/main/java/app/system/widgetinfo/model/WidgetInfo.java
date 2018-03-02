package app.system.widgetinfo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by real on 2018/2/6.
 */
@ApiModel("控件组信息-二层菜单")
public class WidgetInfo {

    @ApiModelProperty("组ID")
    private String groupId;
    @ApiModelProperty("组名称")
    private String groupName;
    @ApiModelProperty("组图标")
    private String img;
    @ApiModelProperty("排序号")
    private BigDecimal orderNum;
    @ApiModelProperty("状态")
    private String status;
    @ApiModelProperty("控件列表")
    List<Widgets> widgets;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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

    public List<Widgets> getWidgets() {
        return widgets;
    }

    public void setWidgets(List<Widgets> widgets) {
        this.widgets = widgets;
    }
}
