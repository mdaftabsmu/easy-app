package com.easyapper.easyapperservices.services.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easyapper.easyapperservices.exception.EmailAlreadyExistException;
import com.easyapper.easyapperservices.model.SenderEmailMdl;
import com.easyapper.easyapperservices.repository.ReceiverRepository;
import com.easyapper.easyapperservices.repository.SenderEmailRepository;
import com.easyapper.easyapperservices.request.CreateSenderEmail;
import com.easyapper.easyapperservices.request.ReceiverValidate;
import com.easyapper.easyapperservices.services.SenderEmailServices;
import com.easyapper.easyapperservices.utils.MailSenderService;

@Service
public class SenderEmailServicesImpl implements SenderEmailServices {
	
	private Logger logger = LoggerFactory.getLogger(SenderEmailServicesImpl.class);

	@Autowired
	private SenderEmailRepository moniterRepository;

	@Autowired
	private MailSenderService mailSenderService;
	
	@Autowired
	private ReceiverRepository receiverRepository;
	

	@Override
	public String createSenderEmail(CreateSenderEmail createSenderEmail) throws EmailAlreadyExistException {
		SenderEmailMdl model = moniterRepository.findByEmailIdAndAppId(createSenderEmail.getEmailId(),createSenderEmail.getAppId());
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
		else {
			throw new EmailAlreadyExistException("Use User differnt email id.");
		}
		return "The Validation mail has been sent to your email id,Please visit mail to click on link.";
		
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

	@Override
	public String updateSenderVerification(CreateSenderEmail createSenderEmail) {
		SenderEmailMdl model = moniterRepository.findByEmailIdAndAppId(createSenderEmail.getEmailId(),createSenderEmail.getAppId());
		if(model!=null) {
			model.setIsVerified(true);
			moniterRepository.save(model);
			return "Email id has been verified";
		}
		return "Emaild and App id not found in db!";
	}

	@Override
	public List<String> getReceiverEmailId(String appId, String monitorId) {
		return null;//receiverRepository.getEmailByAppIdAndMoniterId(appId,monitorId).map(obj);
	}

	@Override
	public String receiverValidate(String appId, String monitorId, ReceiverValidate receiverValidate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteBySenderId(String appId, String senderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSenderList(String appId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateSenderDetails(String appId, String senderId) {
		// TODO Auto-generated method stub
		return null;
	}

}
