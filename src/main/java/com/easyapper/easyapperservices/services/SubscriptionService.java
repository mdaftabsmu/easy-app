package com.easyapper.easyapperservices.services;

import com.easyapper.easyapperservices.request.NotifyEvent;
import com.easyapper.easyapperservices.request.Subscription;

public interface SubscriptionService {

	String save(Subscription subscription)throws Exception;
	boolean removeSub(String moniterId)throws Exception;
	
	

}
