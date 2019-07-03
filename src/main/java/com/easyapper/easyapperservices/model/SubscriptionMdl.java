package com.easyapper.easyapperservices.model;

import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.easyapper.easyapperservices.request.Subscription;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@Document(collection = "subscription_user")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubscriptionMdl {

	@Id
	private String id;
	@Field("moniter")
	private Map<String,Object> monitor;
	@Field("email")
	private String email;
	@Field("appId")
	private String appId;
	@Field("subscriptionKey")
	private String subscriptionKey;
	@Field("status")
	private boolean status;
	
	public SubscriptionMdl() {
		// TODO Auto-generated constructor stub
	}

	public SubscriptionMdl(String id, Map<String, Object> monitor, String email, String appId, String subscriptionKey) {
		this.id = id;
		this.monitor = monitor;
		this.email = email;
		this.appId = appId;
		this.subscriptionKey = subscriptionKey;
	}

	public SubscriptionMdl(Subscription subscription) {
		this.monitor = subscription.getMonitor();
		this.email = subscription.getEmail();
		this.appId = subscription.getAppId();
		this.subscriptionKey = subscription.getSubscriptionKey();
		this.status = true;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Map<String, Object> getMonitor() {
		return monitor;
	}

	public void setMonitor(Map<String, Object> monitor) {
		this.monitor = monitor;
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
	
	

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "SubscriptionMdl [id=" + id+ "]";
	}
	
	
	
	
	
	
	

}
