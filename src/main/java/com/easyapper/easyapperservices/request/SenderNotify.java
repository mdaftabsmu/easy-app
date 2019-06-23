package com.easyapper.easyapperservices.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SenderNotify {
	@JsonProperty("subject")
	private String subject;
	@JsonProperty("receivers")
	private List<String> receivers;
	@JsonProperty("content")
	private String content;
	@JsonProperty("signedBy")
	private String signedBy;
	private String appId;
	private String senderEmail;
	
	public SenderNotify() {
		// TODO Auto-generated constructor stub
	}

	public SenderNotify(String subject, List<String> receivers, String content, String signedBy) {
		super();
		this.subject = subject;
		this.receivers = receivers;
		this.content = content;
		this.signedBy = signedBy;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public List<String> getReceivers() {
		return receivers;
	}

	public void setReceivers(List<String> receivers) {
		this.receivers = receivers;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSignedBy() {
		return signedBy;
	}

	public void setSignedBy(String signedBy) {
		this.signedBy = signedBy;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getSenderEmail() {
		return senderEmail;
	}

	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}
	

}

