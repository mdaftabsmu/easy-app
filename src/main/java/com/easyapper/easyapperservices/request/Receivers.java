package com.easyapper.easyapperservices.request;

public class Receivers {
	private String email;
	private String appId;
	private String subscriptionKey;
	
	public Receivers() {
		// TODO Auto-generated constructor stub
	}

	public Receivers(String email, String appId, String subscriptionKey) {
		this.email = email;
		this.appId = appId;
		this.subscriptionKey = subscriptionKey;
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
	
	
	
	

}
