package com.smda.deviceint.deviceintegration;

import com.smda.deviceint.deviceintegration.dao.DeviceDataRepository;
import com.smda.deviceint.deviceintegration.dao.DeviceRepository;
import com.smda.deviceint.deviceintegration.entity.Device;
import com.smda.deviceint.deviceintegration.entity.DeviceData;
import com.smda.deviceint.deviceintegration.service.DeviceDataService;
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
class DeviceDataServiceTest {

    @Autowired
    private DeviceDataService deviceDataService;

    @MockBean
    private DeviceDataRepository deviceDataRepository;

    @Test
    void testGetDeviceDataById() {
        Long deviceDataId = 1L;
        DeviceData deviceData = new DeviceData(2L, null, "Payload");
        when(deviceDataRepository.findById(deviceDataId)).thenReturn(Optional.of(deviceData));

        Optional<DeviceData> retrievedDeviceData =  deviceDataService.getDeviceDataById(deviceDataId);
        assertTrue(retrievedDeviceData.isPresent());
        assertEquals(deviceData.getDataId(), retrievedDeviceData.get().getDataId());
    }

    // Add more tests as needed
}