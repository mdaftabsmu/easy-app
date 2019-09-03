package com.easyapper.easyapperservices.services;

import java.util.List;

import com.easyapper.easyapperservices.exception.EmailAlreadyExistException;
import com.easyapper.easyapperservices.request.CreateSenderEmail;
import com.easyapper.easyapperservices.request.ReceiverValidate;

public interface SenderEmailServices {
	
	public String createSenderEmail(CreateSenderEmail createSenderEmail)throws EmailAlreadyExistException;

	public String senderEmailVarification(String verificationCode);

	public String updateSenderVerification(CreateSenderEmail createSenderEmail);

	public List<String> getReceiverEmailId(String appId, String monitorId);

	public String receiverValidate(String appId, String monitorId, ReceiverValidate receiverValidate);

	public String deleteBySenderId(String appId, String senderId);

	public String getSenderList(String appId);

	public String updateSenderDetails(String appId, String senderId);

}


