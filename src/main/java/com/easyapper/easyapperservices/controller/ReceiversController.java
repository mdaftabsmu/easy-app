package com.easyapper.easyapperservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.easyapper.easyapperservices.request.Receivers;
import com.easyapper.easyapperservices.services.ReceiverService;

@RestController
public class ReceiversController {
	
	@Autowired
	private ReceiverService receiverService;
	
	@PostMapping(path = "mailer/receivers", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity receiversMailer(@RequestHeader(value="SubscriptionKey") String subscriptionKey,
			@RequestBody Receivers request){
		try {
			request.setSubscriptionKey(subscriptionKey);
			return ResponseEntity.ok(receiverService.receiverSave(request));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(404).body(e.getMessage());
		}	
		
	}

}
