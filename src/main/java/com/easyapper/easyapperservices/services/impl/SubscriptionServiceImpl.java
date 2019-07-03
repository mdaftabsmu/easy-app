package com.easyapper.easyapperservices.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easyapper.easyapperservices.exception.UserAlreadyExistException;
import com.easyapper.easyapperservices.model.SubscriptionMdl;
import com.easyapper.easyapperservices.model.UserMoniterMdl;
import com.easyapper.easyapperservices.repository.MoniterRepository;
import com.easyapper.easyapperservices.repository.SubscriptionRepository;
import com.easyapper.easyapperservices.request.Subscription;
import com.easyapper.easyapperservices.services.SubscriptionService;
import com.easyapper.easyapperservices.utils.MailSenderService;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
	
	@Autowired
	private SubscriptionRepository subscriptionRepository;
	
	@Autowired
	private MoniterRepository moniterRepository; 
	
	@Autowired
	private MailSenderService mailSenderService;

	@Override
	public void save(Subscription subscription) throws Exception {
		SubscriptionMdl obj = subscriptionRepository.findByEmailAndMonitor(subscription.getAppId(),subscription.getMonitor());
		if(obj!=null) {
			throw new UserAlreadyExistException("User already exist!");
		}
		obj  = new SubscriptionMdl(subscription);
		subscriptionRepository.save(obj);
		// todo need discussion  
		UserMoniterMdl moniterMdl = moniterRepository.findByAppId(obj.getAppId());
		if(moniterMdl!=null) {
			mailSenderService.sendMessage(subscription.getEmail(),moniterMdl.getReciverMailId());
			// todo need discussion 
		}
		
		
		
		
	}

	@Override
	public boolean removeSub(String subscriptionKey) throws Exception {
		SubscriptionMdl mdl = subscriptionRepository.findBySubscriptionKey(subscriptionKey);
		if(mdl!=null) {
			mdl.setStatus(false);
			subscriptionRepository.save(mdl);
			return true;
		}
		return false;
	}

	

}
