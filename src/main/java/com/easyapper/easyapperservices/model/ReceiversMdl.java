package com.easyapper.easyapperservices.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.easyapper.easyapperservices.request.Receivers;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "receivers_user")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReceiversMdl {
	@Id
	private String id;
	@Field("email")
	private String email;
	@Field("appId")
	private String appId;
	@Field("subscriptionKey")
	private String subscriptionKey;
	@Field("moniterId")
	private String moniterId;
	@Field("createdAt")
	private Long createdAt;
	@Field("validTill")
	private Long validTill;
	@Field("isValid")
	private Boolean isValid =true;
	
	public ReceiversMdl() {
		// TODO Auto-generated constructor stub
	}

	public ReceiversMdl(String email, String appId, String subscriptionKey) {
		this.email = email;
		this.appId = appId;
		this.subscriptionKey = subscriptionKey;
	}

	public ReceiversMdl(Receivers request) {
		this.email =request.getEmail();
		this.appId = request.getAppId();
		this.subscriptionKey= request.getSubscriptionKey();
		this.moniterId = request.getMoniterId();
	}
	

	public ReceiversMdl(String id, String email, String appId, String subscriptionKey, String moniterId, Long createdAt,
			Long validTill, Boolean isValid) {
		super();
		this.id = id;
		this.email = email;
		this.appId = appId;
		this.subscriptionKey = subscriptionKey;
		this.moniterId = moniterId;
		this.createdAt = createdAt;
		this.validTill = validTill;
		this.isValid = isValid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getSubscriptionKey() {
		return subscriptionKey;
	}

	public void setSubscriptionKey(String subscriptionKey) {
		this.subscriptionKey = subscriptionKey;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	

	public String getMoniterId() {
		return moniterId;
	}

	public void setMoniterId(String moniterId) {
		this.moniterId = moniterId;
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
		return "ReceiversMdl [email=" + email + "]";
	}
	
	
	
	
	

}
