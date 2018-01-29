package app.temp.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class UserPojo {
    @ApiModelProperty("用户ID")
    private String userId;

    @ApiModelProperty("用户名称")
    private String userName;

    @ApiModelProperty("昵称")
    private String nickName;

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

    private DeptPojo deptPojo;
    private List<RolePojo> rolePojos;
    private List<CoWorkerPojo> coWorkers;

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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
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

    public DeptPojo getDeptPojo() {
        return deptPojo;
    }

    public void setDeptPojo(DeptPojo deptPojo) {
        this.deptPojo = deptPojo;
    }

    public List<RolePojo> getRolePojos() {
        return rolePojos;
    }

    public void setRolePojos(List<RolePojo> rolePojos) {
        this.rolePojos = rolePojos;
    }

    public List<CoWorkerPojo> getCoWorkers() {
        return coWorkers;
    }

    public void setCoWorkers(List<CoWorkerPojo> coWorkers) {
        this.coWorkers = coWorkers;
    }
}
