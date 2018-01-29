package app.base;

import app.comn.ResponseCode;

public class Result<T> {
    private ResponseCode code;

    private String message;

    private T data;

    public Result() {
    }

    public Result(ResponseCode code) {
        this(code, code.getMessage());
    }

    public Result(ResponseCode code, String message) {
        this(code, code.getMessage(), null);
    }

    public Result(ResponseCode code, T data) {
        this(code, code.getMessage(), data);
    }

    public Result(ResponseCode code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResponseCode getCode() {
        return code;
    }

    public void setCode(ResponseCode code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
