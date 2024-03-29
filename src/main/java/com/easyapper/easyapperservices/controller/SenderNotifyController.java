package com.easyapper.easyapperservices.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.easyapper.easyapperservices.request.EmailContent;
import com.easyapper.easyapperservices.request.NotifyEvent;
import com.easyapper.easyapperservices.request.SenderNotify;
import com.easyapper.easyapperservices.response.EasyApperResponse;
import com.easyapper.easyapperservices.services.SenderNotifyService;

@RestController
public class SenderNotifyController {

	private Logger logger = LoggerFactory.getLogger(SenderNotifyController.class);
	
	@Autowired
	private SenderNotifyService senderNotifyService;

	@PostMapping(path = "/mailer/apps/{appId}/senders/{sender-email}/notify", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity senderNotify(@RequestHeader(value="SubscriptionKey") String subscriptionKey,@RequestBody SenderNotify senderNotify,
															@PathVariable("appId") String appId,@PathVariable("sender-email") String emailId){
		try {
			senderNotify.setAppId(appId);
			senderNotify.setSenderEmail(emailId);
			senderNotifyService.senderNotify(senderNotify);
			return ResponseEntity.ok("Mail sent this email : "+senderNotify.getReceivers());
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@PostMapping(path = "/mailer/apps/{appId}/monitors/{monitorId}/notify", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity notifyEvents(@RequestHeader(value="SubscriptionKey") String subscriptionKey,@PathVariable("appId") String appId,@PathVariable("monitorId") String moniterId,@RequestBody NotifyEvent notifyEvent){
		try {
			notifyEvent.setAppId(appId);
			notifyEvent.setSubscriptionKey(subscriptionKey);
			notifyEvent.setMoniterId(moniterId);
			return ResponseEntity.ok(senderNotifyService.senderNotify(notifyEvent));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.notFound().build();
		}	
		
	}
	
	// todo need to discuss
	@PostMapping(path = "/mailer/apps/{appId}/monitors/{monitorId}/notify/check",consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<EasyApperResponse> receiverCreation(@RequestHeader(value="subscriptionKey") String subscriptionKey,@PathVariable("appId") String appId,
			@PathVariable("monitorId") String monitorId, @RequestBody EmailContent emailContent) {
		try {
			return ResponseEntity.ok(new EasyApperResponse(HttpStatus.OK.value(),senderNotifyService.sendEmailByMoniterId(appId,monitorId,emailContent)));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok(new EasyApperResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
		}
	}


}	

