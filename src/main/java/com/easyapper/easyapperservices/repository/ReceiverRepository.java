package com.easyapper.easyapperservices.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.easyapper.easyapperservices.model.ReceiversMdl;

@Repository
public interface ReceiverRepository extends MongoRepository<ReceiversMdl, String> {

	ReceiversMdl findByEmailAndAppId(String email,String appId);
	
	List<ReceiverProjection> getEmailByAppIdAndMoniterId(String appId, String monitorId);

}
