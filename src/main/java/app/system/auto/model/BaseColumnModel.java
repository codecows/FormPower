package app.system.auto.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by real on 2018/3/13.
 */
@ApiModel("列模型")
public class BaseColumnModel {

    @ApiModelProperty("列名")
    private String tabColumn;

    @ApiModelProperty("列类型")
    private String tabColType;

    @ApiModelProperty("长度")
    private int tabColLength;

    @ApiModelProperty("小数长度")
    private int tabColSmall;

    @ApiModelProperty("是否为空")
    private String isNull;

    @ApiModelProperty("是否主键")
    private String isKey;

    @ApiModelProperty("注释")
    private String comment;

    @ApiModelProperty("默认值")
    private String defaultValue;

    public String getTabColumn() {
        return tabColumn;
    }

    public void setTabColumn(String tabColumn) {
        this.tabColumn = tabColumn;
    }

    public String getTabColType() {
        return tabColType;
    }

    public void setTabColType(String tabColType) {
        this.tabColType = tabColType;
    }

    public int getTabColLength() {
        return tabColLength;
    }

    public void setTabColLength(int tabColLength) {
        this.tabColLength = tabColLength;
    }

    public int getTabColSmall() {
        return tabColSmall;
    }

    public void setTabColSmall(int tabColSmall) {
        this.tabColSmall = tabColSmall;
    }

    public String getIsNull() {
        return isNull;
    }

    public void setIsNull(String isNull) {
        this.isNull = isNull;
    }

    public String getIsKey() {
        return isKey;
    }

    public void setIsKey(String isKey) {
        this.isKey = isKey;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }
}
