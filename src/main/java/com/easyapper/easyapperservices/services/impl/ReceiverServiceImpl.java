package com.easyapper.easyapperservices.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easyapper.easyapperservices.exception.UserAlreadyExistException;
import com.easyapper.easyapperservices.model.ReceiversMdl;
import com.easyapper.easyapperservices.repository.ReceiverRepository;
import com.easyapper.easyapperservices.request.Receivers;
import com.easyapper.easyapperservices.services.ReceiverService;
import com.easyapper.easyapperservices.utils.MailSenderService;

@Service
public class ReceiverServiceImpl implements ReceiverService{
	
	@Autowired
	private ReceiverRepository receiverRepository;
	
	@Autowired
	private MailSenderService mailSenderService;

	@Override
	public void receiverSave(Receivers request) throws Exception {
		ReceiversMdl obj = receiverRepository.findByEmailIdAndAppId(request.getEmail(),request.getAppId());
		if(obj !=null) {
			throw new UserAlreadyExistException("User already added in app");
		}
		receiverRepository.save(new ReceiversMdl(request));
		mailSenderService.sendMessage(request.getEmail(), "no-reply@noddys.club");
		
		
	}

	

} 
