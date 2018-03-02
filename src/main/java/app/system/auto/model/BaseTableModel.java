package app.system.auto.model;

import app.system.auto.entities.SysBaseTabEntity;

import java.util.List;

/**
 * Created by Fan on 2018/2/27.
 */
public class BaseTableModel {

    private String tableName;
    private List<SysBaseTabEntity> columnBodyList;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<SysBaseTabEntity> getColumnBodyList() {
        return columnBodyList;
    }

    public void setColumnBodyList(List<SysBaseTabEntity> columnBodyList) {
        this.columnBodyList = columnBodyList;
    }
}
