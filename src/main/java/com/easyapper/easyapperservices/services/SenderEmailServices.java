package com.easyapper.easyapperservices.services;

import java.util.List;

import com.easyapper.easyapperservices.exception.CommonException;
import com.easyapper.easyapperservices.exception.EmailAlreadyExistException;
import com.easyapper.easyapperservices.request.CreateSenderEmail;
import com.easyapper.easyapperservices.request.ReceiverValidate;

public interface SenderEmailServices {
	
	public String createSenderEmail(CreateSenderEmail createSenderEmail)throws EmailAlreadyExistException;

	public String senderEmailVarification(String verificationCode);

	public String updateSenderVerification(CreateSenderEmail createSenderEmail);

	public String getReceiverEmailId(String appId, String monitorId) throws CommonException;

	public String receiverValidate(String appId, String monitorId, ReceiverValidate receiverValidate);

	public String deleteBySenderId(String appId, String senderId) throws CommonException;

	public List<String> getSenderList(String appId) throws CommonException;

	public String updateSenderDetails(String appId, String senderId) throws CommonException;

}


