package com.easyapper.easyapperservices.configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;

@Configuration
public class EasyApperAutoConfiguration {

	 @Bean
	   public AmazonSimpleEmailService amazonSimpleEmailService() {
		 AmazonSimpleEmailService client = AmazonSimpleEmailServiceClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials("", "")))
		            .withRegion(Regions.US_EAST_1).build();
	        return client;
	    }
}