package app.comn;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ResponseCode {

    Success(200,"成功"),
    Unauthorized(300,"没有权限"),
    UserExist(1000, "用户已经存在"),
    Etc(9999,"其它原因"),;

    // 成员变量
    private String message;
    private int code;

    public String getMessage() {
        return message;
    }

    @JsonValue
    public int getCode() {
        return code;
    }

    // 构造方法
    ResponseCode(int code, String message) {
        this.message = message;
        this.code = code;
    }

    // 普通方法
    public static String getMessage(int value) {
        for (ResponseCode p : ResponseCode.values()) {
            if (p.getCode() == value) {
                return p.message;
            }
        }
        return null;
    }
}
