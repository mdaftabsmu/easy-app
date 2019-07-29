package com.easyapper.easyapperservices.services;

import com.easyapper.easyapperservices.exception.EmailAlreadyExistException;
import com.easyapper.easyapperservices.request.CreateSenderEmail;

public interface SenderEmailServices {
	
	public String createSenderEmail(CreateSenderEmail createSenderEmail)throws EmailAlreadyExistException;

	public String senderEmailVarification(String verificationCode);

	public String updateSenderVerification(CreateSenderEmail createSenderEmail);

}
