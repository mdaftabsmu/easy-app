package com.easyapper.easyapperservices.request;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserMoniter {
	@JsonProperty("param")
	private Map<String,Object> filterMap;
	@JsonProperty("reciver_mailid")
	private String reciverMailId;
	@JsonProperty("ser_key")
	private String serKey;
	@JsonProperty("user_id")
	private String userId;
	@JsonProperty("app_id")
	private String appId;
	
	public UserMoniter() {
		// TODO Auto-generated constructor stub
	}

	public UserMoniter(Map<String, Object> filterMap, String reciverMailId, String serKey, String userId,
			String appId) {
		this.filterMap = filterMap;
		this.reciverMailId = reciverMailId;
		this.serKey = serKey;
		this.userId = userId;
		this.appId = appId;
	}

	public Map<String, Object> getFilterMap() {
		return filterMap;
	}

	public void setFilterMap(Map<String, Object> filterMap) {
		this.filterMap = filterMap;
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
		return "UserMoniter [filterMap=" + filterMap + ", reciverMailId=" + reciverMailId + ", serKey=" + serKey
				+ ", userId=" + userId + ", appId=" + appId + "]";
	}
	
	

}
