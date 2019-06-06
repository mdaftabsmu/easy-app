package com.easyapper.easyapperservices.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateSenderEmail {

	@JsonProperty("email_id")
	private String emailId;
	@JsonProperty("user_id")
	private String userId;
	@JsonProperty("ser_key")
	private String serKey;
	private String appId;

	public CreateSenderEmail() {
		// TODO Auto-generated constructor stub
	}

	public CreateSenderEmail(String emailId, String userId, String serKey, String appId) {
		super();
		this.emailId = emailId;
		this.userId = userId;
		this.serKey = serKey;
		this.appId = appId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	

	public String getSerKey() {
		return serKey;
	}

	public void setSerKey(String serKey) {
		this.serKey = serKey;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	@Override
	public String toString() {
		return "CreateSenderEmail [emailId=" + emailId + ", userId=" + userId + "]";
	}

}
