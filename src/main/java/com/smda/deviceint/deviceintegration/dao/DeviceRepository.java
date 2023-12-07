package com.smda.deviceint.deviceintegration.dao;

import com.smda.deviceint.deviceintegration.entity.Device;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends MongoRepository<Device, Long> {
}
