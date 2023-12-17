package com.smda.deviceint.deviceintegration;

import com.smda.deviceint.deviceintegration.dao.UserRepository;
import com.smda.deviceint.deviceintegration.entity.User;
import com.smda.deviceint.deviceintegration.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    void testGetUserById() {
        Long userId = 1L;
        User user = new User("JohnDoe", "JohnDoe@test.com");
        user.setUserId(userId);
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        Optional<User> retrievedUser = userService.getUserById(userId);
        assertTrue(retrievedUser.isPresent());
        assertEquals(user.getUsername(), retrievedUser.get().getUsername());
    }
    @Test
    void testGetAllUsers() {
        Long userId = 1L;
        User user = new User("JohnDoe", "JohnDoe@test.com");
        user.setUserId(userId);
        List<User> users = new ArrayList<User>();
        users.add(user);
        when(userRepository.findAll()).thenReturn(users);

        List<User> retrievedUsers = userService.getAllUsers();
        assertFalse(retrievedUsers.isEmpty());
        assertEquals(user.getUsername(), retrievedUsers.get(0).getUsername());
    }

    @Test
    void testCreateUser() {
        // Given
        User userToCreate = new User("JohnDoe", "JohnDoe@test.com");
        User createdUser = new User("JohnDoe", "JohnDoe@test.com");

        // Mocking the repository behavior
        when(userRepository.save(userToCreate)).thenReturn(createdUser);

        // When
        User savedUser = userService.createUser(userToCreate);

        // Then
        assertEquals(createdUser.getUserId(), savedUser.getUserId());
        assertEquals(userToCreate.getUsername(), savedUser.getUsername());
    }

    @Test
    void testUpdateUser() throws ChangeSetPersister.NotFoundException {
        // Given
        Long userId = 1L;
        User existingUser = new User("JohnDoe", "JohnDoe@test.com");
        existingUser.setUserId(userId);
        User updatedUser = new User("JohnDoe1", "JohnDoe@test.com");
        updatedUser.setUserId(userId);

        // Mocking the repository behavior
        when(userRepository.existsById(userId)).thenReturn(Boolean.TRUE);
        when(userRepository.save(updatedUser)).thenReturn(updatedUser);

        // When
        User result = userService.updateUser(userId, updatedUser);

        // Then
        assertEquals(updatedUser.getUsername(), result.getUsername());
        verify(userRepository).save(updatedUser);
    }

    @Test
    void testDeleteUser() throws ChangeSetPersister.NotFoundException {
        // Given
        Long userId = 1L;

        // Mocking the repository behavior
        when(userRepository.existsById(userId)).thenReturn(true);

        // When
        userService.deleteUser(userId);

        // Then
        //assertTrue(deleted);
        verify(userRepository).deleteById(userId);
    }

}
