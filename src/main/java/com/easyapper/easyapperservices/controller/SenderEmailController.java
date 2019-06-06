package com.easyapper.easyapperservices.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.easyapper.easyapperservices.exception.EmailAlreadyExistException;
import com.easyapper.easyapperservices.request.CreateSenderEmail;
import com.easyapper.easyapperservices.response.EasyApperResponse;
import com.easyapper.easyapperservices.services.SenderEmailServices;


@RestController
public class SenderEmailController {
	private Logger logger = LoggerFactory.getLogger(SenderEmailController.class);

	@Autowired
	private SenderEmailServices moniterServices;

	@PostMapping(path = "/apps/{appId}/senders", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<EasyApperResponse> createSenderEmail(@RequestBody CreateSenderEmail createSenderEmail,@PathVariable("appId") String appId){
		try {
			createSenderEmail.setAppId(appId);
			logger.info(createSenderEmail+appId);
			return ResponseEntity.ok(new EasyApperResponse(HttpStatus.CREATED.value(), moniterServices.createSenderEmail(createSenderEmail)));
		} catch (EmailAlreadyExistException e) {
			e.printStackTrace();
			return ResponseEntity.ok(new EasyApperResponse(HttpStatus.CONFLICT.value(), e.getMessage()));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok(new EasyApperResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
		}
	}
	
	@GetMapping(path = "/apps/{appId}/senders/{verificationCode}")
	public String senderEmailVarification(@PathVariable("verificationCode") String verificationCode) {
		return moniterServices.senderEmailVarification(verificationCode);
	}



}
