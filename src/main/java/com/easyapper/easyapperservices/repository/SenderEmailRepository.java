package com.easyapper.easyapperservices.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.easyapper.easyapperservices.model.SenderEmailMdl;

public interface SenderEmailRepository extends MongoRepository<SenderEmailMdl, String >  {

	SenderEmailMdl findByEmailId(String emailId);

}
