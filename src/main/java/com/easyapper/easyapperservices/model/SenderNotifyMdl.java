package com.easyapper.easyapperservices.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.easyapper.easyapperservices.request.SenderNotify;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@Document(collection = "sender_notify")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SenderNotifyMdl {
	
	@Id
	private String id;
	@Field("subject")
	private String subject;
	@Field("receivers")
	private List<String> receivers;
	@Field("content")
	private String content;
	@Field("signed_by")
	private String signedBy;
	@Field("app_id")
	private String appId;
	@Field("sender_email")
	private String senderEmail;
	
	public SenderNotifyMdl() {
		// TODO Auto-generated constructor stub
	}
	
	public SenderNotifyMdl(String id, String subject, List<String> receivers, String content, String signedBy,
			String appId, String senderEmail) {
		super();
		this.id = id;
		this.subject = subject;
		this.receivers = receivers;
		this.content = content;
		this.signedBy = signedBy;
		this.appId = appId;
		this.senderEmail = senderEmail;
	}

	public SenderNotifyMdl(SenderNotify senderNotify) {
		this.subject = senderNotify.getSubject();
		this.receivers = senderNotify.getReceivers();
		this.content = senderNotify.getContent();
		this.signedBy = senderNotify.getSignedBy();
		this.appId = senderNotify.getAppId();
		this.senderEmail = senderNotify.getSenderEmail();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
