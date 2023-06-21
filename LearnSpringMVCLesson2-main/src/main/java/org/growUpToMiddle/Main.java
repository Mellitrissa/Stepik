package org.growUpToMiddle;

import org.growUpToMiddle.dao.UserDaoImpl;
import org.growUpToMiddle.service.UserService;
import org.growUpToMiddle.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserDaoImpl userDaoIpl = new UserDaoImpl();
        UserService userService = new UserServiceImpl(userDaoIpl);

    }
}