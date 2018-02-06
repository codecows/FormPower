package app.management.widgetinfo.entities;

import java.util.List;

/**
 * Created by real on 2018/2/6.
 */
public class WidgetInfoEntity {

    List<WidgetsEntity> widgets;
    private String groupId;
    private String groupName;
    private String status;

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
