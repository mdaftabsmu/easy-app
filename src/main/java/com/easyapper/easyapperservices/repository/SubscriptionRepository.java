package com.easyapper.easyapperservices.repository;

import java.util.Map;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.easyapper.easyapperservices.model.SubscriptionMdl;

@Repository
public interface SubscriptionRepository extends MongoRepository<SubscriptionMdl, String> {

	SubscriptionMdl findByEmailAndMonitor(String appId, Map<String, Object> monitor);
	SubscriptionMdl findBySubscriptionKey(String subscriptionKey);

}
