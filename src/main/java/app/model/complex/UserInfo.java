package app.model.complex;

import app.model.Authority;
import app.model.Department;
import app.model.Menu;
import app.model.User;

import java.util.List;

public class UserInfo extends User {
    private Department department;
    private Authority authority;
    private List<Menu> menus;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }
}
