package org.hiber.dao;


import org.hiber.model.Car;
import org.hiber.model.User;

import java.util.List;

public interface UserDao {

    void addCarToUser(Long userId, Car car);

    void addUser(User user);

    void removeCarFromUser(Long userId, Long carId);

    List<User> getAllUsers();

    User getUserById(Long id);

    List<Car> getCarsByUserId(Long userId);

    Car getCarById(Long id);
}
