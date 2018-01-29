package app.temp.pojo;

import java.util.List;

public class RolePojo {
    private String roleId;
    private String roleName;
    private String parId;
    private String status;
    private List<MenuScenePojo> menuScenePojos;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getParId() {
        return parId;
    }

    public void setParId(String parId) {
        this.parId = parId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<MenuScenePojo> getMenuScenePojos() {
        return menuScenePojos;
    }

    public void setMenuScenePojos(List<MenuScenePojo> menuScenePojos) {
        this.menuScenePojos = menuScenePojos;
    }
}
