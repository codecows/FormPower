package app.management.relation.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;


/**
 * Created by Fan on 2018/1/30.
 */

@ApiModel("组权限关系实体")
public class GroupAuthRel {

    @ApiModelProperty("id")
    private String guid;

    @ApiModelProperty("用户ID")
    private String groupId;

    @ApiModelProperty("角色ID")
    private String authId;

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

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getAuthId() {
        return authId;
    }

    public void setAuthId(String authId) {
        this.authId = authId;
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
