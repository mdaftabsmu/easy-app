package com.easyapper.easyapperservices.controller;

import java.io.IOException;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClient;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.services.simpleemail.model.GetIdentityVerificationAttributesRequest;
import com.amazonaws.services.simpleemail.model.GetIdentityVerificationAttributesResult;
import com.amazonaws.services.simpleemail.model.ListVerifiedEmailAddressesResult;

@RestController
public class SNSController {
	
	@Autowired
	private AmazonSimpleEmailService amazonSimpleEmailService;

    @PostMapping(path = "sns")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String messagetype = request.getHeader("x-amz-sns-message-type");
        if (messagetype == null) {
            return;
        }

        Scanner scan = new Scanner(request.getInputStream());
        StringBuilder builder = new StringBuilder();
        while (scan.hasNextLine()) {
            builder.append(scan.nextLine());
        }

        System.out.println(builder.toString());
    }
    
    @GetMapping(path = "test")
    public void getResponse() {
    	 ListVerifiedEmailAddressesResult verifiedEmails = amazonSimpleEmailService.listVerifiedEmailAddresses();
    	 if (verifiedEmails.getVerifiedEmailAddresses().contains("mdaftabalam196@gmail.com")) {
    		 System.out.println("verified");
    	 }{
    		 System.out.println("Pending");
    	 }
    }

}
