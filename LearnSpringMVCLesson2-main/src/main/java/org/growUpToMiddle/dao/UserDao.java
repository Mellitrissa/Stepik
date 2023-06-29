package org.growUpToMiddle.dao;

import org.growUpToMiddle.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    void updateUser(Long userId,User user);

    User getUserById(Long id);

    void addUser(User user);

    void deleteUser(Long id);
}
