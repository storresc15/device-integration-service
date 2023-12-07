package com.smda.deviceint.deviceintegration.dao;

import com.smda.deviceint.deviceintegration.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {
}
