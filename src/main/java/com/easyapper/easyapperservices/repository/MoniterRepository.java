package com.easyapper.easyapperservices.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.easyapper.easyapperservices.model.UserMoniterMdl;


@Repository
public interface MoniterRepository extends  MongoRepository<UserMoniterMdl, String >{

	UserMoniterMdl findByReciverMailIdAndAppId(String reciverMailId, String appId);

	UserMoniterMdl findByAppId(String appId);
	

}
