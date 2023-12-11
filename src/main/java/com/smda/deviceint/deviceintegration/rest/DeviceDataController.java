package com.smda.deviceint.deviceintegration.rest;

import com.smda.deviceint.deviceintegration.entity.Device;
import com.smda.deviceint.deviceintegration.entity.DeviceData;
import com.smda.deviceint.deviceintegration.service.DeviceDataService;
import com.smda.deviceint.deviceintegration.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices-data")
public class DeviceDataController {
    @Autowired
    private DeviceDataService deviceDataService;

    @GetMapping
    public List<DeviceData> getAllDevicesData() {
        return deviceDataService.getAllDevicesData();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeviceData> getDeviceDataById(@PathVariable Long id) {
        return deviceDataService.getDeviceDataById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<DeviceData> createDevice(@RequestBody DeviceData deviceData) {
        DeviceData savedDeviceData = deviceDataService.createDeviceData(deviceData);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDeviceData);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DeviceData> updateDevice(@PathVariable Long id, @RequestBody DeviceData deviceData) throws ChangeSetPersister.NotFoundException {
        DeviceData updatedDevice = deviceDataService.updateDeviceData(id, deviceData);
        return ResponseEntity.ok(updatedDevice);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDevice(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        try {
            deviceDataService.deleteDeviceData(id);
        } catch (ChangeSetPersister.NotFoundException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.noContent().build();
    }
}
