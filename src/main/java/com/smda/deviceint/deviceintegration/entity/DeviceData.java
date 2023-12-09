package com.smda.deviceint.deviceintegration.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("device_data")
public class DeviceData {

    @Transient
    public static final String SEQUENCE_NAME = "device_data_sequence";
    @Id
    private Long dataId;
    private Long deviceId; // Foreign key referencing DeviceModel
    private LocalDateTime timestamp;
    private String payload;

    public DeviceData(Long deviceId, LocalDateTime timestamp, String payload) {
        this.deviceId = deviceId;
        this.timestamp = timestamp;
        this.payload = payload;
    }

    public Long getDataId() {
        return dataId;
    }

    public void setDataId(Long dataId) {
        this.dataId = dataId;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "DeviceData{" +
                "dataId=" + dataId +
                ", deviceId=" + deviceId +
                ", timestamp=" + timestamp +
                ", payload='" + payload + '\'' +
                '}';
    }
}
