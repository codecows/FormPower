package app.system.widgetinfo.entities;


import java.math.BigDecimal;
import java.util.List;

/**
 * Created by real on 2018/2/6.
 */

public class WidgetsEntity {


    private String controlId;

    private String controlName;

    private String img;

    private String status;

    private BigDecimal orderNum;

    private String groupId;

    private List<ControlAttributeEntity> controlAttributeList;

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

    public List<ControlAttributeEntity> getControlAttributeList() {
        return controlAttributeList;
    }

    public void setControlAttributeList(List<ControlAttributeEntity> controlAttributeList) {
        this.controlAttributeList = controlAttributeList;
    }
}
