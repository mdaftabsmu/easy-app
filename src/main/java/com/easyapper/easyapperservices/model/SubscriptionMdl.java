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
	@Field("monitorId")
	private String monitorId;
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

	public SubscriptionMdl(String id, String monitorId, String email, String appId, String subscriptionKey) {
		this.id = id;
		this.monitorId = monitorId;
		this.email = email;
		this.appId = appId;
		this.subscriptionKey = subscriptionKey;
	}

	public SubscriptionMdl(Subscription subscription) {
		this.monitorId = subscription.getMonitorId();
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
