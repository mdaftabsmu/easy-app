package com.easyapper.easyapperservices.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.easyapper.easyapperservices.model.ReceiversMdl;

@Repository
public interface ReceiverRepository extends MongoRepository<ReceiversMdl, String> {

	ReceiversMdl findByEmailAndAppId(String email,String appId);
	 @Query("SELECT rm.email from ReceiversMdl rm where rm.appId=:appId and rm.moniterId=:moniterId")   
	 Optional<String> getEmailByAppIdAndMoniterId(String appId, String monitorId);

}
