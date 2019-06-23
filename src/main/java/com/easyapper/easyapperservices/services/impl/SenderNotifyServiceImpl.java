package com.easyapper.easyapperservices.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easyapper.easyapperservices.model.SenderNotifyMdl;
import com.easyapper.easyapperservices.repository.SenderNotifyRepository;
import com.easyapper.easyapperservices.request.SenderNotify;
import com.easyapper.easyapperservices.services.SenderNotifyService;

@Service
public class SenderNotifyServiceImpl implements SenderNotifyService {
	
	@Autowired
	private SenderNotifyRepository senderNotifyRepository;

	@Override
	public void senderNotify(SenderNotify senderNotify) throws Exception {
		senderNotifyRepository.save(new SenderNotifyMdl(senderNotify));
	}

}
