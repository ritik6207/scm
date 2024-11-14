package com.scm.services;

import java.util.List;
import java.util.Optional;

import com.scm.entities.User;

public interface UserService {

    User saveUser(User user);

    Optional<User> getUserById(String UserId);

    Optional<User> updateUser(User user);

    void deleteUser(String id);

    boolean isUserExists(String userId);

    boolean isUserExistsByEmail(String email);

    List<User> getAllUsers();

    // add more methods here as needed services (logic)
}
