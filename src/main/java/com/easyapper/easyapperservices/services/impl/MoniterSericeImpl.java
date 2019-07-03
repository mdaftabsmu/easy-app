package com.easyapper.easyapperservices.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easyapper.easyapperservices.model.UserMoniterMdl;
import com.easyapper.easyapperservices.repository.MoniterRepository;
import com.easyapper.easyapperservices.request.UserMoniter;
import com.easyapper.easyapperservices.services.MoniterService;
import com.easyapper.easyapperservices.utils.MailSenderService;

@Service
public class MoniterSericeImpl implements MoniterService{
	
	private Logger logger = LoggerFactory.getLogger(MoniterSericeImpl.class);
	

	@Autowired
	private MoniterRepository moniterRepository;
	
	@Autowired
	private MailSenderService mailSenderService;
	
	
	@Override
	public String createMoniter(UserMoniter userMoniter) {
			
		UserMoniterMdl moniterMdl = moniterRepository.findByReciverMailIdAndAppId(userMoniter.getReciverMailId(),userMoniter.getAppId());
		if(moniterMdl == null) {
			moniterMdl = moniterRepository.save(new UserMoniterMdl(userMoniter));
			mailSenderService.sendMessage(moniterMdl.getReciverMailId());
		}
		 
		return moniterMdl.getId();
	}

}
