package com.smda.deviceint.deviceintegration.service;

import com.smda.deviceint.deviceintegration.entity.Device;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;
import java.util.Optional;

public interface DeviceService {
    List<Device> getAllDevices();
    Optional<Device> getDeviceById(Long id);
    Device createDevice(Device device);
    Device updateDevice(Long id, Device device) throws ChangeSetPersister.NotFoundException;
    void deleteDevice(Long id) throws ChangeSetPersister.NotFoundException;
}
