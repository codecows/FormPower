package app.dao.entities;

import java.util.List;

/**
 * Created by real on 2018/1/27.
 */
public class UserInformation {

    private String userId;

    private String userName;

    private List<SysRole> sysRoles;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<SysRole> getSysRoles() {
        return sysRoles;
    }

    public void setSysRoles(List<SysRole> sysRoles) {
        this.sysRoles = sysRoles;
    }
}
