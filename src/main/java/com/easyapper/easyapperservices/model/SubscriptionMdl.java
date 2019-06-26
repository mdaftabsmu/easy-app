package com.easyapper.easyapperservices.model;

import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;

import com.easyapper.easyapperservices.request.Subscription;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@Document(collection = "subscription_user")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class 
SubscriptionMdl {

	private String id;
	private Map<String,Object> monitor;
	private String email;
	private String appId;
	private String subscriptionKey;
	
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

	@Override
	public String toString() {
		return "SubscriptionMdl [id=" + id+ "]";
	}
	
	
	
	
	
	
	

}
