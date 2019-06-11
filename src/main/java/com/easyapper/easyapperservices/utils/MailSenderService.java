package com.easyapper.easyapperservices.utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;
import com.amazonaws.services.simpleemail.model.VerifyEmailIdentityRequest;

@Service
public class MailSenderService {

	private static final String UTF_8 = "UTF-8";
	private static final String SUBJECT = "Easy-App Signup | Verification";
	//private static final String EASY_MSG = "Your account has been made, <br /> please verify it by clicking the activation link that has been send to your email.";
	//private static final String EASY_MSG = "Thanks for subscription! Your email has been subscribed, You have activated your account by pressing the url below <br/><br/> Please click this link to activate your account:";
	//private static final String EASY_URl ="http://localhost:8080/";

	@Autowired
    private AmazonSimpleEmailService amazonSimpleEmailService;
	

    public void sendMessage(String emailId,String sources) {
    	SendEmailRequest request = new SendEmailRequest()
    	          .withDestination(
    	              new Destination().withToAddresses(emailId))
    	          .withMessage(new Message()
    	              .withBody(new Body()
    	                  .withHtml(new Content()
    	                      .withCharset(UTF_8).withData(emailId)))
    	              .withSubject(new Content()
    	                  .withCharset(UTF_8).withData(SUBJECT)))
    	          .withSource(sources);
    	 this.amazonSimpleEmailService.sendEmail(request);
    }
    
    public void sendMessage(String emailId) {
    	 VerifyEmailIdentityRequest request = new VerifyEmailIdentityRequest().withEmailAddress(emailId);
    	 this.amazonSimpleEmailService.verifyEmailIdentity(request);

    }

}