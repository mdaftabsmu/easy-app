package com.easyapper.easyapperservices.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SenderUpdate {
	
	@JsonProperty("emailId")
	private String emailId;

	public SenderUpdate() {
		// TODO Auto-generated constructor stub
	}
	
	public SenderUpdate(String emailId) {
		this.emailId = emailId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "SenderUpdate [emailId=" + emailId + "]";
	}

}
