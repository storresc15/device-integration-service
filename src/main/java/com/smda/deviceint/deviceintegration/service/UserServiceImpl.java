package com.smda.deviceint.deviceintegration.service;

import com.smda.deviceint.deviceintegration.dao.UserRepository;
import com.smda.deviceint.deviceintegration.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User createUser(User user) {
        user.setUserId(sequenceGeneratorService.generateSequence(User.SEQUENCE_NAME));
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User user) throws ChangeSetPersister.NotFoundException {
        if (userRepository.existsById(id)) {
            user.setUserId(id);
            return userRepository.save(user);
        }
        throw new ChangeSetPersister.NotFoundException();
    }

    @Override
    public void deleteUser(Long id) throws ChangeSetPersister.NotFoundException {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new ChangeSetPersister.NotFoundException();
        }
    }
}