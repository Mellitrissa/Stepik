package org.hiber;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hiber.dao.UserDaoImpl;
import org.hiber.model.Car;
import org.hiber.model.User;
import org.hiber.service.UserService;
import org.hiber.service.UserServiceImpl;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args )
    {
        UserDaoImpl userDaoIpl = new UserDaoImpl();
        UserService userService = new UserServiceImpl(userDaoIpl);
        //userService.addUser(new User("Иван","Иванов","vannn"));
        //userService.getAllUsers();
        //userService.addCarToUser(3L,new Car("Honda"));
        //userService.getUserById(2l);
        userService.getCarsByUserId(3L);
        //userService.getCarById(5L);


        System.out.println( "Hello World!");

    }

}
