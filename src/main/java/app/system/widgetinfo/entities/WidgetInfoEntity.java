package app.system.widgetinfo.entities;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by real on 2018/2/6.
 */
public class WidgetInfoEntity {

    private String groupId;
    private String groupName;
    private String img;
    private BigDecimal orderNum;
    private String status;
    List<WidgetsEntity> widgets;

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

    public List<WidgetsEntity> getWidgets() {
        return widgets;
    }

    public void setWidgets(List<WidgetsEntity> widgets) {
        this.widgets = widgets;
    }


}
