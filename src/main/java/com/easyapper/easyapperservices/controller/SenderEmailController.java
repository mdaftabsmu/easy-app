package com.easyapper.easyapperservices.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import com.easyapper.easyapperservices.exception.EmailAlreadyExistException;
import com.easyapper.easyapperservices.request.CreateSenderEmail;
import com.easyapper.easyapperservices.request.ReceiverValidate;
import com.easyapper.easyapperservices.response.EasyApperResponse;
import com.easyapper.easyapperservices.services.SenderEmailServices;


@RestController
public class SenderEmailController {
	private Logger logger = LoggerFactory.getLogger(SenderEmailController.class);

	@Autowired
	private SenderEmailServices moniterServices;

	@PostMapping(path = "/apps/{appId}/senders", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<EasyApperResponse> createSenderEmail(@RequestHeader(value="subscriptionKey") String subscriptionKey,@RequestBody CreateSenderEmail createSenderEmail,@PathVariable("appId") String appId){
		try {
			createSenderEmail.setSerKey(subscriptionKey);
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


	@PostMapping(path = "/maller/senders", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public String senders(@RequestHeader(value="subscriptionKey") String subscriptionKey,@RequestBody CreateSenderEmail createSenderEmail) {
		return moniterServices.updateSenderVerification(createSenderEmail);
	}


	@GetMapping(path = "/mailer/apps/{appId}/monitors/{monitorId}/emails",consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public List<String> listEmail(@RequestHeader(value="subscriptionKey") String subscriptionKey,@PathVariable("appId") String appId,
			@PathVariable("monitorId") String monitorId) {
		return moniterServices.getReceiverEmailId(appId,monitorId);
	}

	@PostMapping(path = "/mailer/apps/{appId}/monitors/{monitorId}/emails",consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<EasyApperResponse> receiverCreation(@RequestHeader(value="subscriptionKey") String subscriptionKey,@PathVariable("appId") String appId,
			@PathVariable("monitorId") String monitorId, @RequestBody ReceiverValidate receiverValidate) {
		try {
			return ResponseEntity.ok(new EasyApperResponse(HttpStatus.OK.value(),moniterServices.receiverValidate(appId,monitorId,receiverValidate)));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok(new EasyApperResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
		}
	}
	@GetMapping(path = "/mailer/apps/{appId}/senders",consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<EasyApperResponse> senderList(@RequestHeader(value="subscriptionKey") String subscriptionKey,@PathVariable("appId") String appId) {
		try {
			return ResponseEntity.ok(new EasyApperResponse(HttpStatus.OK.value(),moniterServices.getSenderList(appId)));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok(new EasyApperResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
		}
	}
	
	// Need to discuss regarding request body data
	@PutMapping(path = "/mailer/apps/{appId}/senders/{senderId}",consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<EasyApperResponse> updateSender(@RequestHeader(value="subscriptionKey") String subscriptionKey,@PathVariable("appId") String appId,
			 @PathVariable("senderId") String senderId) {
		try {
			return ResponseEntity.ok(new EasyApperResponse(HttpStatus.OK.value(),moniterServices.updateSenderDetails(appId,senderId)));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok(new EasyApperResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
		}
	}
	
	@DeleteMapping(path = "/mailer/apps/{appId}/senders/{senderId}",consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<EasyApperResponse> deleteSender(@RequestHeader(value="subscriptionKey") String subscriptionKey,@PathVariable("appId") String appId,
			 @PathVariable("senderId") String senderId) {
		try {
			return ResponseEntity.ok(new EasyApperResponse(HttpStatus.OK.value(),moniterServices.deleteBySenderId(appId,senderId)));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok(new EasyApperResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
		}
	}
}
