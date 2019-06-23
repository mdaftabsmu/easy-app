package com.easyapper.easyapperservices.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.easyapper.easyapperservices.model.SenderNotifyMdl;

@Repository
public interface SenderNotifyRepository extends MongoRepository<SenderNotifyMdl, String>  {

}
