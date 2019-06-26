package com.easyapper.easyapperservices.model;

import org.springframework.data.mongodb.core.mapping.Document;

import com.easyapper.easyapperservices.request.Receivers;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@Document(collection = "receivers_user")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReceiversMdl {
	private String id;
	private String email;
	private String appId;
	private String subscriptionKey;  
	
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
