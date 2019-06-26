package com.easyapper.easyapperservices.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.easyapper.easyapperservices.request.NotifyEvent;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@Document(collection = "notify_event")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NotifyEventMdl {
	private String id;
	private String subscriptionKey;
	private String appId;
	private String moniterId;
	private List<String> events;
	
	public NotifyEventMdl() {
		// TODO Auto-generated constructor stub
	}

	public NotifyEventMdl(String id, String subscriptionKey, String appId, String moniterId, List<String> events) {
		this.id = id;
		this.subscriptionKey = subscriptionKey;
		this.appId = appId;
		this.moniterId = moniterId;
		this.events = events;
	}

	public NotifyEventMdl(NotifyEvent notifyEvent) {
		this.subscriptionKey = notifyEvent.getSubscriptionKey();
		this.appId = notifyEvent.getAppId();
		this.moniterId = notifyEvent.getMoniterId();
		this.events = notifyEvent.getEvents();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "NotifyEventMdl [id=" + id+ "]";
	}
	
	
	
	

}
