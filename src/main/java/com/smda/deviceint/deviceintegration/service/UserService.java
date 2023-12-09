package com.smda.deviceint.deviceintegration.service;

import com.smda.deviceint.deviceintegration.entity.User;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();
    Optional<User> getUserById(Long id);
    User createUser(User user);
    User updateUser(Long id, User user) throws ChangeSetPersister.NotFoundException;
    void deleteUser(Long id) throws ChangeSetPersister.NotFoundException;
}
