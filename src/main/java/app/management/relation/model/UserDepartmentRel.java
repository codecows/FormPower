package app.management.relation.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;


/**
 * Created by Fan on 2018/1/30.
 */

@ApiModel("用户部门关系实体")
public class UserDepartmentRel {

    @ApiModelProperty("id")
    private String guid;

    @ApiModelProperty("用户ID")
    private String userId;

    @ApiModelProperty("部门ID")
    private String departmentId;

    @ApiModelProperty("状态")
    private String status;

    @ApiModelProperty("操作时间")
    private Date operationDate;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
    }
}
