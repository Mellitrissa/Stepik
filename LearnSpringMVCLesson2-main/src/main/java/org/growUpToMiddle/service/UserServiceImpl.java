package org.growUpToMiddle.service;

import org.growUpToMiddle.dao.UserDao;
import org.growUpToMiddle.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }
    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void saveUser(Long userId,User user) {
    }

    @Override
    public User getUserById(Long id) {
        return  userDao.getUserById(id);
    }

    @Override
    public void addUser(User user) {
    }

    @Override
    public void deleteUser(Long id) {
    }
}
