package app.comn;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ResponseCode {

    Success(200,"成功"),
    Unauthorized(300,"没有权限"),
    Etc(900,"其它原因"),;

    // 成员变量
    private String message;
    private int code;

    public String getName() {
        return message;
    }

    public void setName(String name) {
        this.message = name;
    }

    @JsonValue
    public int getValue() {
        return code;
    }

    public void setValue(int value) {
        this.code = value;
    }

    // 构造方法
    ResponseCode(int code, String message) {
        this.message = message;
        this.code = code;
    }

    // 普通方法
    public static String getName(int value) {
        for (ResponseCode p : ResponseCode.values()) {
            if (p.getValue() == value) {
                return p.message;
            }
        }
        return null;
    }
}
