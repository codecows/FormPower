package app.temp.pojo;

import io.swagger.annotations.ApiModel;

import java.util.List;

@ApiModel("菜单组")
public class MenuGroupPojo {
    private String groupId;
    private String groupName;
    private String status;
    private List<MenuPojo> menus;

    public List<MenuPojo> getMenus() {
        return menus;
    }

    public void setMenus(List<MenuPojo> menus) {
        this.menus = menus;
    }

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
}
