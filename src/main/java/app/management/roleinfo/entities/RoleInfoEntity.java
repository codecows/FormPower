package app.management.roleinfo.entities;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by real on 2018/2/1.
 */
public class RoleInfoEntity {


    private String roleId;

    private String parentId;

    private String roleName;

    private String description;

    private String remark;

    private BigDecimal orderNum;

    private String status;

    private Date createDate;

    private List<AuthInfoEntity> authInfo;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<AuthInfoEntity> getAuthInfo() {
        return authInfo;
    }

    public void setAuthInfo(List<AuthInfoEntity> authInfo) {
        this.authInfo = authInfo;
    }
}
