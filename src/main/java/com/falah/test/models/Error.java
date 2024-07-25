package com.falah.test.models;

public class Error {
    /*
    {"type":"https://tools.ietf.org/html/rfc9110#section-15.5.5","title":"Not Found","status":404,"detail":"Queue is empty.","traceId":"00-eecce20dff7d60c4e1f7300b3e1c829e-92a4ba4851bb0193-00","errorCodes":["Queues.QueueIsEmpty"]}
    */

    private String type;
    private String title;
    private int status;
    private String detail;
    private String traceId;
    private String[] errorCodes;

    public Error() {
    }

    public Error(String message) {
        this.detail = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public String[] getErrorCodes() {
        return errorCodes;
    }

    public void setErrorCodes(String[] errorCodes) {
        this.errorCodes = errorCodes;
    }
}
