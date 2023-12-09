package com.smda.deviceint.deviceintegration.service;

import com.smda.deviceint.deviceintegration.entity.DeviceData;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;
import java.util.Optional;

public interface DeviceDataService {
    List<DeviceData> getAllDevicesData();
    Optional<DeviceData> getDeviceDataById(Long id);
    DeviceData createDeviceData(DeviceData deviceData);
    DeviceData updateDeviceData(Long id, DeviceData deviceData) throws ChangeSetPersister.NotFoundException;
    void deleteDeviceData(Long id) throws ChangeSetPersister.NotFoundException;
}
