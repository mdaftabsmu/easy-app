package com.easyapper.easyapperservices.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.easyapper.easyapperservices.model.SenderEmailMdl;

@Repository
public interface SenderEmailRepository extends MongoRepository<SenderEmailMdl, String >  {

	SenderEmailMdl findByEmailId(String emailId);

}
