package com.easyapper.easyapperservices.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.easyapper.easyapperservices.model.UserMoniterMdl;


@Repository
public interface MoniterRepository extends  MongoRepository<UserMoniterMdl, String >{

}
