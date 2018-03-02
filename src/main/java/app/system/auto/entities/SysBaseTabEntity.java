package app.system.auto.entities;

/**
 * Created by Fan on 2018/2/27.
 */
public class SysBaseTabEntity {

    private String tabColumn;
    private String tabColType;
    private int tabColLength;
    private int tabColSmall;
    private String isNull;
    private String isKey;
    private String comment;
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
