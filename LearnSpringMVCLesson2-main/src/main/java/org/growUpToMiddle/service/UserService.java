package org.growUpToMiddle.service;

import org.growUpToMiddle.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void saveUser(Long userId,User user);

    User getUserById(Long id);

    void addUser(User user);

    void deleteUser(Long id);
}
