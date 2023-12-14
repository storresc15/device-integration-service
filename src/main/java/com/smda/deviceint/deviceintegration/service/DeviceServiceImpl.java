package com.smda.deviceint.deviceintegration.service;

import com.smda.deviceint.deviceintegration.dao.DeviceRepository;
import com.smda.deviceint.deviceintegration.entity.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceServiceImpl implements DeviceService{

    @Autowired
    private DeviceRepository deviceRepository;
    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Override
    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    @Override
    public Optional<Device> getDeviceById(Long id) {
        return deviceRepository.findById(id);
    }

    @Override
    public Device createDevice(Device device) {
        device.setDeviceId(sequenceGeneratorService.generateSequence(Device.SEQUENCE_NAME));
        return deviceRepository.save(device);
    }

    @Override
    public Device updateDevice(Long id, Device device) throws ChangeSetPersister.NotFoundException {
        if (deviceRepository.existsById(id)) {
            device.setDeviceId(id);
            return deviceRepository.save(device);
        }
        throw new ChangeSetPersister.NotFoundException();
    }

    @Override
    public void deleteDevice(Long id) throws ChangeSetPersister.NotFoundException {
        if (deviceRepository.existsById(id)) {
            deviceRepository.deleteById(id);
        } else {
            throw new ChangeSetPersister.NotFoundException();
        }
    }
}
