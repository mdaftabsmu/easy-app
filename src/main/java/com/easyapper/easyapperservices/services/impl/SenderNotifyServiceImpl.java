package com.easyapper.easyapperservices.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public String sendEmailByMoniterId(String appId, String monitorId, EmailContent emailContent) {
		// TODO Auto-generated method stub
		return null;
	}

}
