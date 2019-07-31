package com.easyapper.easyapperservices.request;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserMoniter {
	@JsonProperty("moniterId")
	private String moniterId;
	@JsonProperty("email")
	private String reciverMailId;
	@JsonProperty("ser_key")
	private String serKey;
	@JsonProperty("user_id")
	private String userId;
	@JsonProperty("appId")
	private String appId;
	
	public UserMoniter() {
		// TODO Auto-generated constructor stub
	}

	public UserMoniter(String moniterId, String reciverMailId, String serKey, String userId, String appId) {
		this.moniterId = moniterId;
		this.reciverMailId = reciverMailId;
		this.serKey = serKey;
		this.userId = userId;
		this.appId = appId;
	}

	public String getMoniterId() {
		return moniterId;
	}

	public void setMoniterId(String moniterId) {
		this.moniterId = moniterId;
	}

	public String getReciverMailId() {
		return reciverMailId;
	}

	public void setReciverMailId(String reciverMailId) {
		this.reciverMailId = reciverMailId;
	}

	public String getSerKey() {
		return serKey;
	}

	public void setSerKey(String serKey) {
		this.serKey = serKey;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	@Override
	public String toString() {
		return "UserMoniter [moniterId=" + moniterId + ", reciverMailId=" + reciverMailId + ", serKey=" + serKey
				+ ", userId=" + userId + ", appId=" + appId + "]";
	}
	
	

}
