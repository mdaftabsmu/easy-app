package com.easyapper.easyapperservices.response;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EasyApperResponse {
    @JsonProperty("code")
    private int status;
    @JsonProperty("msg")
    private String msg;
    @JsonProperty("ids")
    private List<String> ids;

    public EasyApperResponse() {
    }

    public EasyApperResponse(int status) {
        this.status = status;
    }

    public EasyApperResponse(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }
    
    

    public EasyApperResponse(int status, List<String> ids) {
		super();
		this.status = status;
		this.ids = ids;
	}

	public EasyApperResponse(int status, String msg, List<String> ids) {
		super();
		this.status = status;
		this.msg = msg;
		this.ids = ids;
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

	public List<String> getIds() {
		return ids;
	}

	public void setIds(List<String> ids) {
		this.ids = ids;
	}
    
    
}
