package com.easyapper.easyapperservices.job;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.ListVerifiedEmailAddressesResult;
import com.easyapper.easyapperservices.model.SenderEmailMdl;
import com.easyapper.easyapperservices.repository.SenderEmailRepository;

@Component
public class EmailVerificationJob {

	private Logger logger = LoggerFactory.getLogger(EmailVerificationJob.class);

	@Autowired
	private AmazonSimpleEmailService amazonSimpleEmailService;

	@Autowired
	private SenderEmailRepository senderEmailRepository;

	@Scheduled(fixedRate = 2000000)
	public void scheduleTaskWithFixedRate() {
		List<SenderEmailMdl> list = senderEmailRepository.findAllByIsVerified(false);
		if(list == null || list.isEmpty()) {
			logger.info("Email id list is empty");
			return;
		}

		ListVerifiedEmailAddressesResult verifiedEmails = amazonSimpleEmailService.listVerifiedEmailAddresses();
		
		if(verifiedEmails == null || verifiedEmails.getVerifiedEmailAddresses()==null ||  verifiedEmails.getVerifiedEmailAddresses().isEmpty()) {
			logger.info("Verified Emails list is empty");
			return;
		}
		
		for (SenderEmailMdl senderEmailMdl : list) {
			if (verifiedEmails.getVerifiedEmailAddresses().contains(senderEmailMdl.getEmailId())) {
				logger.info(" Status : "+senderEmailMdl.getEmailId() +" :  Verfied ");
				senderEmailMdl.setIsVerified(true);
				senderEmailRepository.save(senderEmailMdl);
				logger.info("Email id status has been updated in db");
			}else {
				logger.info(" ** Status : "+senderEmailMdl.getEmailId() +" : Pending ");
			}
			
		}
	}

}
