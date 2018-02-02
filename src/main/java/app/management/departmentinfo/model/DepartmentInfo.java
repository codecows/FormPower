package app.management.departmentinfo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

@ApiModel("部门综合查询业务实体")
public class DepartmentInfo {

    @ApiModelProperty("部门ID")
    private String departmentId;

    @ApiModelProperty("上级部门ID")
    private String parentId;

    @ApiModelProperty("部门名称")
    private String departmentName;

    @ApiModelProperty("部门简称")
    private String shortName;

    @ApiModelProperty("部门编码")
    private String departmentCode;

    @ApiModelProperty("部门级别")
    private String departmentLevel;

    @ApiModelProperty("部门类型")
    private String departmentType;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("创建时间")
    private Date createDate;

    @ApiModelProperty("状态")
    private String status;

    @ApiModelProperty("下级部门列表")
    private List<DepartmentInfo> departments;

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getDepartmentLevel() {
        return departmentLevel;
    }

    public void setDepartmentLevel(String departmentLevel) {
        this.departmentLevel = departmentLevel;
    }

    public String getDepartmentType() {
        return departmentType;
    }

    public void setDepartmentType(String departmentType) {
        this.departmentType = departmentType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<DepartmentInfo> getDepartments() {
        return departments;
    }

    public void setDepartments(List<DepartmentInfo> departments) {
        this.departments = departments;
    }
}
