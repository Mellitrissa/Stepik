package org.growUpToMiddle.service;

import org.growUpToMiddle.dao.UserDao;
import org.growUpToMiddle.dao.UserDaoImpl;
import org.growUpToMiddle.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void updateUser(Long userId,User user) {
        userDao.updateUser(userId, user);
    }

    @Override
    public User getUserById(Long id) {
        return  userDao.getUserById(id);
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }
}
