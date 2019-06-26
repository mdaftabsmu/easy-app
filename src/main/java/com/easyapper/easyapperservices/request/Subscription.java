package com.easyapper.easyapperservices.request;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Subscription {
	
	@JsonProperty("monitor")
	private Map<String,Object> monitor;
	@JsonProperty("email")
	private String email;
	@JsonProperty("appId")
	private String appId;
	@JsonProperty("subscription_key")
	private String subscriptionKey;
	
	public Subscription() {
		// TODO Auto-generated constructor stub
	}

	public Subscription(Map<String, Object> monitor, String email, String appId) {
		this.monitor = monitor;
		this.email = email;
		this.appId = appId;
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

	public void setSubscriptionKey(String subscription) {
		this.subscriptionKey = subscription;
	}
	
	

}
