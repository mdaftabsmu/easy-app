package com.easyapper.easyapperservices.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NotifyEvent {
	private String subscriptionKey;
	private String appId;
	private String moniterId;
	@JsonProperty("events")
	private List<String> events;
	
	public NotifyEvent() {
		// TODO Auto-generated constructor stub
	}

	public NotifyEvent(String subscriptionKey, String appId, String moniterId, List<String> events) {
		this.subscriptionKey  = subscriptionKey;
		this.appId = appId;
		this.moniterId = moniterId;
		this.events = events;
	}

	public String getSubscriptionKey() {
		return subscriptionKey;
	}

	public void setSubscriptionKey(String subscriptionKey) {
		this.subscriptionKey = subscriptionKey;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getMoniterId() {
		return moniterId;
	}

	public void setMoniterId(String moniterId) {
		this.moniterId = moniterId;
	}

	public List<String> getEvents() {
		return events;
	}

	public void setEvents(List<String> events) {
		this.events = events;
	}
	
	

}
