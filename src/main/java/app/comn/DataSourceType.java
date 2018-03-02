package app.comn;

import com.fasterxml.jackson.annotation.JsonValue;

public enum DataSourceType {
    StrArr(10, "固定字符序列"),
    Dict(20, "字典表"),
    UserForm(30, "用户定义表单");
    // 成员变量
    private String name;
    private int code;

    public String getMessage() {
        return name;
    }

    @JsonValue
    public int getCode() {
        return code;
    }

    // 构造方法
    DataSourceType(int code, String name) {
        this.name = name;
        this.code = code;
    }

    // 普通方法
    public static String getName(int value) {
        for (DataSourceType p : DataSourceType.values()) {
            if (p.getCode() == value) {
                return p.name;
            }
        }
        return null;
    }
}
