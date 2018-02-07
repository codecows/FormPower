package app.management.userinfo.model;

import app.management.department.model.Department;
import app.management.menuinfo.model.MenuLevel;
import app.management.roleinfo.model.RolePojo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("用户连表查询业务实体")
public class UserInfo {

    @ApiModelProperty("用户ID")
    private String userId;

    @ApiModelProperty("用户名称")
    private String userName;


    @ApiModelProperty("姓名")
    private String persionName;

    @ApiModelProperty("性别")
    private String persionSex;

    @ApiModelProperty("电话")
    private String mobile;

    @ApiModelProperty("办公电话")
    private String telephone;

    @ApiModelProperty("电子邮箱")
    private String email;

    @ApiModelProperty("职位名称")
    private String userPosition;

    @ApiModelProperty("头像")
    private String imgUrl;
    @ApiModelProperty("备注")
    private String remark;
    @ApiModelProperty("状态")
    private String status;

    @ApiModelProperty("集团")
    private Department group;

    @ApiModelProperty("公司")
    private Department company;

    @ApiModelProperty("部门")
    private Department department;

    @ApiModelProperty("权限列表")
    private List<RolePojo> rolePojos;

    @ApiModelProperty("三层菜单列表")
    private List<MenuLevel> menuLevels;

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

    public String getPersionName() {
        return persionName;
    }

    public void setPersionName(String persionName) {
        this.persionName = persionName;
    }

    public String getPersionSex() {
        return persionSex;
    }

    public void setPersionSex(String persionSex) {
        this.persionSex = persionSex;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserPosition() {
        return userPosition;
    }

    public void setUserPosition(String userPosition) {
        this.userPosition = userPosition;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
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

    public Department getGroup() {
        return group;
    }

    public void setGroup(Department group) {
        this.group = group;
    }

    public Department getCompany() {
        return company;
    }

    public void setCompany(Department company) {
        this.company = company;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<RolePojo> getRolePojos() {
        return rolePojos;
    }

    public void setRolePojos(List<RolePojo> rolePojos) {
        this.rolePojos = rolePojos;
    }

    public List<MenuLevel> getMenuLevels() {
        return menuLevels;
    }

    public void setMenuLevels(List<MenuLevel> menuLevels) {
        this.menuLevels = menuLevels;
    }
}
