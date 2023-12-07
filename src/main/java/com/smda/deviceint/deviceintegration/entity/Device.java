package com.smda.deviceint.deviceintegration.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("device")
public class Device {
    @Transient
    public static final String SEQUENCE_NAME = "devices_sequence";
    @Id
    private Long deviceId;
    private Long accountId;
    private String name;
    private String type;
    private String status;
    @DBRef
    private List<DeviceData> deviceData;

    public Device(Long accountId, String name, String type, String status, List<DeviceData> deviceData) {
        this.accountId = accountId;
        this.name = name;
        this.type = type;
        this.status = status;
        this.deviceData = deviceData;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<DeviceData> getDeviceData() {
        return deviceData;
    }

    public void setDeviceData(List<DeviceData> deviceData) {
        this.deviceData = deviceData;
    }

    @Override
    public String toString() {
        return "Device{" +
                "deviceId=" + deviceId +
                ", accountId=" + accountId +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                ", deviceData=" + deviceData +
                '}';
    }
}
