package app.management.roleinfo.model;

import app.management.menu.model.Menu;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

/**
 * Created by real on 2018/2/1.
 */
@ApiModel("权限菜单查询实体")
public class AuthInfo {

    @ApiModelProperty("权限ID")
    private String authId;

    @ApiModelProperty("上级ID")
    private String parentId;

    @ApiModelProperty("权限名称")
    private String authorityName;

    @ApiModelProperty("描述")
    private String descripthon;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("状态")
    private String status;

    @ApiModelProperty("创建时间")
    private Date createDate;

    @ApiModelProperty("菜单列表")
    private List<Menu> menu;

    public String getAuthId() {
        return authId;
    }

    public void setAuthId(String authId) {
        this.authId = authId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getAuthorityName() {
        return authorityName;
    }

    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
    }

    public String getDescripthon() {
        return descripthon;
    }

    public void setDescripthon(String descripthon) {
        this.descripthon = descripthon;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<Menu> getMenu() {
        return menu;
    }

    public void setMenu(List<Menu> menu) {
        this.menu = menu;
    }
}
