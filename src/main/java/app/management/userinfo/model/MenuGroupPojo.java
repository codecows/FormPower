package app.management.userinfo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("三层结构菜单组")
public class MenuGroupPojo {

    @ApiModelProperty("组ID")
    private String groupId;

    @ApiModelProperty("组名称")
    private String groupName;

    @ApiModelProperty("状态")
    private String status;

    @ApiModelProperty("菜单列表")
    private List<MenuItemPojo> menus;

    public List<MenuItemPojo> getMenus() {
        return menus;
    }

    public void setMenus(List<MenuItemPojo> menus) {
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
