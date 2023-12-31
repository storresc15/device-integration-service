package com.smda.deviceint.deviceintegration;

import com.smda.deviceint.deviceintegration.dao.DeviceRepository;
import com.smda.deviceint.deviceintegration.entity.Device;
import com.smda.deviceint.deviceintegration.service.DeviceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class DeviceServiceTest {

    @Autowired
    private DeviceService deviceService;

    @MockBean
    private DeviceRepository deviceRepository;

    @Test
    void testGetDeviceById() {
        Long deviceId = 1L;
        Device device = new Device(2L, "Device1", "Type1", "Active", null);
        device.setDeviceId(deviceId);
        when(deviceRepository.findById(deviceId)).thenReturn(Optional.of(device));

        Optional<Device> retrievedDevice = deviceService.getDeviceById(deviceId);
        assertTrue(retrievedDevice.isPresent());
        assertEquals(device.getDeviceId(), retrievedDevice.get().getDeviceId());
    }

    @Test
    void testGetAllDevices() {
        Long deviceId = 1L;
        Device device = new Device(2L, "Device1", "Type1", "Active", null);
        device.setDeviceId(deviceId);
        List<Device> devices = new ArrayList<>();
        devices.add(device);
        when(deviceRepository.findAll()).thenReturn(devices);

        List<Device> retrievedDevices = deviceService.getAllDevices();
        assertFalse(retrievedDevices.isEmpty());
        assertEquals(device.getDeviceId(), retrievedDevices.get(0).getDeviceId());
    }

    @Test
    void testCreateDevice() {
        Device deviceToCreate = new Device(2L, "Device1", "Type1", "Active", null);
        Device deviceCreated = new Device(2L, "Device1", "Type1", "Active", null);
        when(deviceRepository.save(deviceToCreate)).thenReturn(deviceCreated);

        Device savedDevice = deviceService.createDevice(deviceToCreate);

        assertEquals(savedDevice.getDeviceId(), deviceCreated.getDeviceId());
        assertEquals(savedDevice.getName(), deviceCreated.getName());
    }

    @Test
    void testUpdateDevice() throws ChangeSetPersister.NotFoundException{
        Long deviceId = 1L;
        Device deviceToUpdate = new Device(2L, "Device1", "Type1", "Active", null);
        deviceToUpdate.setDeviceId(deviceId);
        Device deviceUpdated = new Device(2L, "Device2", "Type1", "Active", null);
        deviceUpdated.setDeviceId(deviceId);

        when(deviceRepository.existsById(deviceId)).thenReturn(Boolean.TRUE);
        when(deviceRepository.save(deviceUpdated)).thenReturn(deviceUpdated);

        Device theDevice = deviceService.updateDevice(deviceId, deviceUpdated);

        assertEquals(deviceUpdated.getName(), theDevice.getName());
        verify(deviceRepository).save(deviceUpdated);
    }

    @Test
    void testDeleteDevice() throws ChangeSetPersister.NotFoundException{
        Long deviceId = 1L;

        when(deviceRepository.existsById(deviceId)).thenReturn(Boolean.TRUE);

        deviceService.deleteDevice(deviceId);

        verify(deviceRepository).deleteById(deviceId);
    }
}
