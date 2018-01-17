package app.comn;

public class ServiceException extends Exception {

    public ServiceException() {
    }

    public ServiceException(ResponseCode responseCode) {
        this.responseCode = responseCode;
    }

    private ResponseCode responseCode;

    public ResponseCode getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(ResponseCode responseCode) {
        this.responseCode = responseCode;
    }
}
