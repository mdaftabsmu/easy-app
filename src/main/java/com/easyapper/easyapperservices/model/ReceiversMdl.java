package com.easyapper.easyapperservices.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.easyapper.easyapperservices.request.Receivers;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

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

	@Override
	public String toString() {
		return "ReceiversMdl [email=" + email + "]";
	}
	
	
	
	
	

}
