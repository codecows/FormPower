package app.management.userinfo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("三层结构菜单所属系统")
public class MenuSystemPojo {

    @ApiModelProperty("所属系统ID")
    private String systemId;

    @ApiModelProperty("所属系统名称")
    private String systemName;

    @ApiModelProperty("状态")
    private String status;

    @ApiModelProperty("菜单组列表")
    private List<MenuGroupPojo> menuGroups;

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<MenuGroupPojo> getMenuGroups() {
        return menuGroups;
    }

    public void setMenuGroups(List<MenuGroupPojo> menuGroups) {
        this.menuGroups = menuGroups;
    }
}
