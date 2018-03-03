package app.system.auto.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * Created by real on 2018/2/28.
 */
@ApiModel("函数信息表模型")
public class ExecFunc extends BaseFunctionModel {
    @ApiModelProperty("id")
    private String id;

    @ApiModelProperty("关联对象id")
    private String objectId;

    @ApiModelProperty("关联对象类型")
    private String objectType;

    @ApiModelProperty("触发条件")
    private String onAction;

    @ApiModelProperty("状态")
    private String status;

    @ApiModelProperty("创建时间")
    private Date createDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getOnAction() {
        return onAction;
    }

    public void setOnAction(String onAction) {
        this.onAction = onAction;
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
}
