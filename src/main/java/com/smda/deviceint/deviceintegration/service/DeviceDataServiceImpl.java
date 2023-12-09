package com.smda.deviceint.deviceintegration.service;

import com.smda.deviceint.deviceintegration.dao.DeviceDataRepository;
import com.smda.deviceint.deviceintegration.entity.DeviceData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;
import java.util.Optional;

public class DeviceDataServiceImpl implements DeviceDataService{
    @Autowired
    private DeviceDataRepository dataRepository;
    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Override
    public List<DeviceData> getAllDevicesData() {
        return dataRepository.findAll();
    }

    @Override
    public Optional<DeviceData> getDeviceDataById(Long id) {
        return dataRepository.findById(id);
    }

    @Override
    public DeviceData createDeviceData(DeviceData deviceData) {
        deviceData.setDataId(sequenceGeneratorService.generateSequence(DeviceData.SEQUENCE_NAME));
        return dataRepository.save(deviceData);
    }

    @Override
    public DeviceData updateDeviceData(Long id, DeviceData deviceData) throws ChangeSetPersister.NotFoundException {
        if (dataRepository.existsById(id)) {
            deviceData.setDataId(id);
            return dataRepository.save(deviceData);
        }
        throw new ChangeSetPersister.NotFoundException();
    }

    @Override
    public void deleteDeviceData(Long id) throws ChangeSetPersister.NotFoundException {
        if (dataRepository.existsById(id)) {
            dataRepository.deleteById(id);
        } else {
            throw new ChangeSetPersister.NotFoundException();
        }
    }
}
