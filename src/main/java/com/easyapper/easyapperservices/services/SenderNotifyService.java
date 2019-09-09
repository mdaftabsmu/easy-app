package com.easyapper.easyapperservices.services;

import com.easyapper.easyapperservices.exception.CommonException;
import com.easyapper.easyapperservices.request.EmailContent;
import com.easyapper.easyapperservices.request.NotifyEvent;
import com.easyapper.easyapperservices.request.SenderNotify;

public interface SenderNotifyService {
	
	public void senderNotify(SenderNotify senderNotify) throws Exception;
	
	public String senderNotify(NotifyEvent notifyEvent) throws Exception;

	public String sendEmailByMoniterId(String appId, String monitorId, EmailContent emailContent) throws CommonException;

}
