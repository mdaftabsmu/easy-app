package com.easyapper.easyapperservices.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.easyapper.easyapperservices.request.NotifyEvent;
import com.easyapper.easyapperservices.request.Subscription;
import com.easyapper.easyapperservices.services.SubscriptionService;

@RestController
public class SubscriptionController {
	
	private Logger logger = LoggerFactory.getLogger(SubscriptionController.class);
	
	@Autowired
	private SubscriptionService subscriptionService; 
	
	@PostMapping(path = "mailer/subscriptions", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> notifyEvents(@RequestHeader(value="SubscriptionKey") String subscriptionKey,
			@RequestBody Subscription subscription){
		try {
			subscription.setSubscriptionKey(subscriptionKey);
			return ResponseEntity.ok(subscriptionService.save(subscription));
		} catch (Exception e) {
			return ResponseEntity.status(404).body(e.getMessage());
		}	
		
	}
	
	
	@GetMapping(path = "mailer/subscriptions", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> removeSubscription(@RequestHeader(value="SubscriptionKey") String subscriptionKey){
		try {
			subscriptionService.removeSub(subscriptionKey);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.notFound().build();
		}	
		
	}

}
