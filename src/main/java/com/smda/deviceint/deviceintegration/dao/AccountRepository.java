package com.smda.deviceint.deviceintegration.dao;

import com.smda.deviceint.deviceintegration.entity.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends MongoRepository<Account, Long> {
}
