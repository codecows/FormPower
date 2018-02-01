package app.management.roleinfo.entities;

import app.dao.entities.SysMenu;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

/**
 * Created by real on 2018/2/1.
 */
public class AuthInfoEntity {


    private String authId;

    private String parentId;

    private String authorityName;

    private String descripthon;

    private String remark;

    private String status;

    private Date createDate;

    private List<SysMenu> menu;

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

    public List<SysMenu> getMenu() {
        return menu;
    }

    public void setMenu(List<SysMenu> menu) {
        this.menu = menu;
    }
}
