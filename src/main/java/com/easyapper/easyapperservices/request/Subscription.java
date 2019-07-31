package com.easyapper.easyapperservices.request;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Subscription {
	
	@JsonProperty("monitorId")
	private String monitorId;
	@JsonProperty("email")
	private String email;
	@JsonProperty("appId")
	private String appId;
	@JsonProperty("subscription_key")
	private String subscriptionKey;
	
	public Subscription() {
		// TODO Auto-generated constructor stub
	}

	public Subscription( String monitorId, String email, String appId) {
		this.monitorId = monitorId;
		this.email = email;
		this.appId = appId;
	}

	public String getMonitorId() {
		return monitorId;
	}

	public void setMonitorId(String monitorId) {
		this.monitorId = monitorId;
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
