package com.smda.deviceint.deviceintegration;

import com.smda.deviceint.deviceintegration.dao.DeviceRepository;
import com.smda.deviceint.deviceintegration.entity.Device;
import com.smda.deviceint.deviceintegration.service.DeviceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
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

    // Add more tests as needed
}
