package com.easyapper.easyapperservices.request;

public class Receivers {
	private String email;
	private String appId;
	private String subscriptionKey;
	private String moniterId;
	
	public Receivers() {
		// TODO Auto-generated constructor stub
	}

	

	public Receivers(String email, String appId, String subscriptionKey, String moniterId) {
		super();
		this.email = email;
		this.appId = appId;
		this.subscriptionKey = subscriptionKey;
		this.moniterId = moniterId;
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

	public String getMoniterId() {
		return moniterId;
	}

	public void setMoniterId(String moniterId) {
		this.moniterId = moniterId;
	}
	

}
