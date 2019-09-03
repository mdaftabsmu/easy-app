package com.easyapper.easyapperservices.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReceiverValidate {
	
	@JsonProperty("receiver_email")
	private String receiverEmail;
	@JsonProperty("createdAt")
	private Long createdAt;
	@JsonProperty("validTill")
	private Long validTill;
	@JsonProperty("isValid")
	private Boolean isValid;

	public ReceiverValidate() {
		// TODO Auto-generated constructor stub
	}

	public ReceiverValidate(String receiverEmail, Long createdAt, Long validTill, Boolean isValid) {
		super();
		this.receiverEmail = receiverEmail;
		this.createdAt = createdAt;
		this.validTill = validTill;
		this.isValid = isValid;
	}

	public String getReceiverEmail() {
		return receiverEmail;
	}

	public void setReceiverEmail(String receiverEmail) {
		this.receiverEmail = receiverEmail;
	}

	public Long getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Long createdAt) {
		this.createdAt = createdAt;
	}

	public Long getValidTill() {
		return validTill;
	}

	public void setValidTill(Long validTill) {
		this.validTill = validTill;
	}

	public Boolean getIsValid() {
		return isValid;
	}

	public void setIsValid(Boolean isValid) {
		this.isValid = isValid;
	}

	@Override
	public String toString() {
		return "ReceiverValidate [receiverEmail=" + receiverEmail + ", createdAt=" + createdAt + ", validTill="
				+ validTill + ", isValid=" + isValid + "]";
	}
}
