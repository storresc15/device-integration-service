package com.smda.deviceint.deviceintegration.dao;

import com.smda.deviceint.deviceintegration.entity.DeviceData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceDataRepository extends MongoRepository<DeviceData, Long> {
}
