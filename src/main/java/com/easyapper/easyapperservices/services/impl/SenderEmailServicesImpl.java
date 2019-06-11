package com.easyapper.easyapperservices.services.impl;

import java.util.Date;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easyapper.easyapperservices.exception.EmailAlreadyExistException;
import com.easyapper.easyapperservices.model.SenderEmailMdl;
import com.easyapper.easyapperservices.repository.SenderEmailRepository;
import com.easyapper.easyapperservices.request.CreateSenderEmail;
import com.easyapper.easyapperservices.services.SenderEmailServices;
import com.easyapper.easyapperservices.utils.MailSenderService;

@Service
public class SenderEmailServicesImpl implements SenderEmailServices {
	
	private Logger logger = LoggerFactory.getLogger(SenderEmailServicesImpl.class);

	@Autowired
	private SenderEmailRepository moniterRepository;

	@Autowired
	private MailSenderService mailSenderService;

	@Override
	public String createSenderEmail(CreateSenderEmail createSenderEmail) throws EmailAlreadyExistException {
		SenderEmailMdl model = moniterRepository.findByEmailId(createSenderEmail.getEmailId());
		if(model==null) {
			model = moniterRepository.save(new SenderEmailMdl(createSenderEmail));
			mailSenderService.sendMessage(model.getEmailId());
			return "The Validation mail has been sent to your email id,Please visit mail to click on link.";
		}
		if(model.getAppId().equals(createSenderEmail.getAppId())&&model.getIsVerified()) { // Todo about isVarified 
			return "Email id already subscribed";
		}
		
		if(model.getSerKey().equals(createSenderEmail.getSerKey())) {
			// I What validate here 
		}
		
		/*if((new Date().getTime() - model.getRegisteredAt().getTime())>=30*60*1000) {
			mailSenderService.sendMessage(model.getEmailId());
			return "The Validation mail has been sent to your email id,Please visit mail to click on link.";
		}*/
		
		else {
			throw new EmailAlreadyExistException("Use User differnt email id.");
		}
		return "";// Error msg
		
	}

	@Override
	public String senderEmailVarification(String verificationCode) {
		Optional<SenderEmailMdl> findById = moniterRepository.findById(verificationCode);
		if(findById == null) {
			return "Invalid URL";
		}
		SenderEmailMdl createSenderEmailMdl = findById.get();
		if(createSenderEmailMdl.getIsVerified()) {
			return "Already verified email";
		}
		createSenderEmailMdl.setIsVerified(true);
		moniterRepository.save(createSenderEmailMdl);
		return "Your subscription has been activated";
	}

}
