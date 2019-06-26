package com.easyapper.easyapperservices.services;

import com.easyapper.easyapperservices.request.NotifyEvent;
import com.easyapper.easyapperservices.request.SenderNotify;

public interface SenderNotifyService {
	
	public void senderNotify(SenderNotify senderNotify) throws Exception;
	
	public void senderNotify(NotifyEvent notifyEvent) throws Exception;

}
