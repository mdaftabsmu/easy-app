package com.easyapper.easyapperservices.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easyapper.easyapperservices.exception.CommonException;
import com.easyapper.easyapperservices.model.NotifyEventMdl;
import com.easyapper.easyapperservices.model.SenderNotifyMdl;
import com.easyapper.easyapperservices.repository.NotifyEventRepository;
import com.easyapper.easyapperservices.repository.SenderNotifyRepository;
import com.easyapper.easyapperservices.request.EmailContent;
import com.easyapper.easyapperservices.request.NotifyEvent;
import com.easyapper.easyapperservices.request.SenderNotify;
import com.easyapper.easyapperservices.services.SenderNotifyService;
import com.easyapper.easyapperservices.utils.MailSenderService;

@Service
public class SenderNotifyServiceImpl implements SenderNotifyService {
	
	@Autowired
	private SenderNotifyRepository senderNotifyRepository;
	
	@Autowired
	private NotifyEventRepository notifyEventRepository;
	
	@Autowired
	private MailSenderService mailSenderService;
	

	@Override
	public void senderNotify(SenderNotify senderNotify) throws Exception {
		senderNotifyRepository.save(new SenderNotifyMdl(senderNotify));
		List<String> receivers = senderNotify.getReceivers();
		if(receivers!=null && !receivers.isEmpty()) {
			for (String emailId : receivers) {
				mailSenderService.sendMessage(emailId,senderNotify.getSubject(),senderNotify.getContent(),senderNotify.getSenderEmail());
			}
		}
	}

	@Override
	public String senderNotify(NotifyEvent notifyEvent) throws Exception {
		notifyEventRepository.save(new NotifyEventMdl(notifyEvent));
		return " All list event has been saved!";
	}

	@Override
	public String sendEmailByMoniterId(String appId, String monitorId, EmailContent emailContent) throws CommonException {
		SenderNotifyMdl mdl = senderNotifyRepository.findByAppId(appId);
		if(mdl == null) {
			throw new CommonException("Invalid App id");
		}
		List<String> receivers = mdl.getReceivers();
		if(receivers == null || receivers.isEmpty()) {
			throw new CommonException("Receivers not found");
		}
		for(String str : receivers){
			mailSenderService.sendMessage(str, emailContent.getSubject(), emailContent.getContent(), mdl.getSenderEmail());
		}
		
		return "Mail has been sent to all receives";
	}

}
