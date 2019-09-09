package com.easyapper.easyapperservices.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.easyapper.easyapperservices.model.SenderEmailMdl;

@Repository
public interface SenderEmailRepository extends MongoRepository<SenderEmailMdl, String >  {

	SenderEmailMdl findByEmailId(String emailId);
	
	SenderEmailMdl findByEmailIdAndAppId(String emailId,String AppId);
	
	List<SenderEmailMdl> findAllByIsVerified(boolean isVerified);

	List<SenderEmailMdl> findByAppId(String appId);
	
	

}
