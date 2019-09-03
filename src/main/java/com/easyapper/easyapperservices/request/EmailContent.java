package com.easyapper.easyapperservices.request;

public class EmailContent {
	private String subject;
	private String content;
	private String signedBy;
	
	public EmailContent() {
		// TODO Auto-generated constructor stub
	}

	public EmailContent(String subject, String content, String signedBy) {
		super();
		this.subject = subject;
		this.content = content;
		this.signedBy = signedBy;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
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

	@Override
	public String toString() {
		return "EmailContent [subject=" + subject + ", content=" + content + ", signedBy=" + signedBy + "]";
	}

}
