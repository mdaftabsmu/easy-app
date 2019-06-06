package com.easyapper.easyapperservices.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easyapper.easyapperservices.exception.EmailAlreadyExistException;
import com.easyapper.easyapperservices.response.EasyApperResponse;
import com.easyapper.easyapperservices.services.SenderEmailServices;

@RestController
public class NotifyController {
	
	private Logger logger = LoggerFactory.getLogger(NotifyController.class);
	
	@Autowired
	private SenderEmailServices moniterServices;
	
	@PostMapping(path = "/emailSrv/apps/{appId}/monitors/{monitorId}/notify", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<EasyApperResponse> createNotify(){
		try {
			return ResponseEntity.ok(new EasyApperResponse(HttpStatus.CREATED.value(), ""));
		} catch (EmailAlreadyExistException e) {
			e.printStackTrace();
			return ResponseEntity.ok(new EasyApperResponse(HttpStatus.CONFLICT.value(), e.getMessage()));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok(new EasyApperResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
		}
	}

}
