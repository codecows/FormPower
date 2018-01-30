package app.management.relation.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;


/**
 * Created by Fan on 2018/1/30.
 */

@ApiModel("用户与组关系实体")
public class UserGroupRel {

    @ApiModelProperty("id")
    private String guid;

    @ApiModelProperty("用户ID")
    private String userId;

    @ApiModelProperty("组ID")
    private String groupId;

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

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
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
