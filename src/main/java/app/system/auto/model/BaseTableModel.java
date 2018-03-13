package app.system.auto.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by Fan on 2018/2/27.
 */
@ApiModel("数据表模型")
public class BaseTableModel {

    @ApiModelProperty("表名")
    private String tableName;
    @ApiModelProperty("列模型列表")
    private List<BaseColumnModel> columnBodyList;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<BaseColumnModel> getColumnBodyList() {
        return columnBodyList;
    }

    public void setColumnBodyList(List<BaseColumnModel> columnBodyList) {
        this.columnBodyList = columnBodyList;
    }
}
