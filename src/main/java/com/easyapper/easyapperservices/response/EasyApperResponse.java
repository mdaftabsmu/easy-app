package com.easyapper.easyapperservices.response;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EasyApperResponse {
    @JsonProperty("code")
    private int status;
    @JsonProperty("msg")
    private String msg;

    public EasyApperResponse() {
    }

    public EasyApperResponse(int status) {
        this.status = status;
    }

    public EasyApperResponse(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
