package com.easyapper.easyapperservices.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.easyapper.easyapperservices.model.NotifyEventMdl;

@Repository
public interface NotifyEventRepository extends MongoRepository<NotifyEventMdl, String> {

}
