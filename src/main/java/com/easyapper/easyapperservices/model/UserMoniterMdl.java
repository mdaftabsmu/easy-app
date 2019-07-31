package com.easyapper.easyapperservices.model;

import java.util.Date;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.easyapper.easyapperservices.request.UserMoniter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@Document(collection = "user_moniter")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserMoniterMdl {
	
	@Id
	private String id;
	@Field("moniterId")
	private String moniterId;
	@Field("receiver_mail_id")
	private String reciverMailId;
	@Field("srv_key")
	private String serKey;
	@Field("user_id")
	private String userId;
	@Field("app_id")
	private String appId;
	@Field("status")
	private boolean status;
	@Field("registered_at")
	private Date registerdAt;
	
	public UserMoniterMdl() {
		// TODO Auto-generated constructor stub
	}

	public UserMoniterMdl(String id,String moniterId, String reciverMailId, String serKey,
			String userId, String appId, boolean status, Date registerdAt) {
		this.id = id;
		this.moniterId = moniterId;
		this.reciverMailId = reciverMailId;
		this.serKey = serKey;
		this.userId = userId;
		this.appId = appId;
		this.status = status;
		this.registerdAt = registerdAt;
	}

	public UserMoniterMdl(UserMoniter userMoniter) {
		this.moniterId = userMoniter.getMoniterId();
		this.reciverMailId = userMoniter.getReciverMailId();
		this.serKey = userMoniter.getSerKey();
		this.appId = userMoniter.getAppId();
		this.userId = userMoniter.getUserId();
		this.status = true;
		this.registerdAt = new Date();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Date getRegisterdAt() {
		return registerdAt;
	}

	public void setRegisterdAt(Date registerdAt) {
		this.registerdAt = registerdAt;
	}


	public String getMoniterId() {
		return moniterId;
	}

	public void setMoniterId(String moniterId) {
		this.moniterId = moniterId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((appId == null) ? 0 : appId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((moniterId == null) ? 0 : moniterId.hashCode());
		result = prime * result + ((reciverMailId == null) ? 0 : reciverMailId.hashCode());
		result = prime * result + ((registerdAt == null) ? 0 : registerdAt.hashCode());
		result = prime * result + ((serKey == null) ? 0 : serKey.hashCode());
		result = prime * result + (status ? 1231 : 1237);
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
		UserMoniterMdl other = (UserMoniterMdl) obj;
		if (appId == null) {
			if (other.appId != null)
				return false;
		} else if (!appId.equals(other.appId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (moniterId == null) {
			if (other.moniterId != null)
				return false;
		} else if (!moniterId.equals(other.moniterId))
			return false;
		if (reciverMailId == null) {
			if (other.reciverMailId != null)
				return false;
		} else if (!reciverMailId.equals(other.reciverMailId))
			return false;
		if (registerdAt == null) {
			if (other.registerdAt != null)
				return false;
		} else if (!registerdAt.equals(other.registerdAt))
			return false;
		if (serKey == null) {
			if (other.serKey != null)
				return false;
		} else if (!serKey.equals(other.serKey))
			return false;
		if (status != other.status)
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
		return "CreateMoniterMdl [id=" + id + "]";
	}

}
