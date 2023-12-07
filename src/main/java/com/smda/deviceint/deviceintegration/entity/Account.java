package com.smda.deviceint.deviceintegration.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("account")
public class Account {
    @Transient
    public static final String SEQUENCE_NAME = "accounts_sequence";
    @Id
    private Long accountId;
    private Long userId; // Foreign key referencing UserModel
    private String accountName;
    @DBRef
    private List<Device> devices;

    public Account(Long userId, String accountName, List<Device> devices) {
        this.userId = userId;
        this.accountName = accountName;
        this.devices = devices;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", userId=" + userId +
                ", accountName='" + accountName + '\'' +
                ", devices=" + devices +
                '}';
    }
}
