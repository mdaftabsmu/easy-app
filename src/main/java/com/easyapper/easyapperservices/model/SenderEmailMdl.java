package com.easyapper.easyapperservices.model;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.easyapper.easyapperservices.request.CreateSenderEmail;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@Document(collection = "sender_email")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SenderEmailMdl {

	@Id
	private String id;
	@Field("email_id")
	private String emailId;
	@Field("ser_Key")
	private String serKey;
	@Field("user_id")
	private String userId;
	@Field("app_id")
	private String appId;
	@Field("registered_at")
	private Date registeredAt;
	@Field("is_verified")
	private boolean isVerified;

	public SenderEmailMdl() {
		// TODO Auto-generated constructor stub
	}

	public SenderEmailMdl(String id, String emailId, String serKey, String userId, String appId,
			Date registeredAt, boolean isVerified) {
		this.id = id;
		this.emailId = emailId;
		this.serKey = serKey;
		this.userId = userId;
		this.appId = appId;
		this.registeredAt = registeredAt;
		this.isVerified = isVerified;
	}

	public SenderEmailMdl(CreateSenderEmail createSenderEmail) {
		this.emailId = createSenderEmail.getEmailId();
		this.serKey = createSenderEmail.getSerKey();
		this.userId = createSenderEmail.getUserId();
		this.appId = createSenderEmail.getAppId();
		this.registeredAt = new Date();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
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

	public Date getRegisteredAt() {
		return registeredAt;
	}

	public void setRegisteredAt(Date registeredAt) {
		this.registeredAt = registeredAt;
	}

	public boolean getIsVerified() {
		return isVerified;
	}

	public void setIsVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((appId == null) ? 0 : appId.hashCode());
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (isVerified ? 1231 : 1237);
		result = prime * result + ((registeredAt == null) ? 0 : registeredAt.hashCode());
		result = prime * result + ((serKey == null) ? 0 : serKey.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SenderEmailMdl other = (SenderEmailMdl) obj;
		if (appId == null) {
			if (other.appId != null)
				return false;
		} else if (!appId.equals(other.appId))
			return false;
		if (emailId == null) {
			if (other.emailId != null)
				return false;
		} else if (!emailId.equals(other.emailId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isVerified != other.isVerified)
			return false;
		if (registeredAt == null) {
			if (other.registeredAt != null)
				return false;
		} else if (!registeredAt.equals(other.registeredAt))
			return false;
		if (serKey == null) {
			if (other.serKey != null)
				return false;
		} else if (!serKey.equals(other.serKey))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CreateSenderEmailMdl [id=" + id + ", emailId=" + emailId + "]";
	}

}
