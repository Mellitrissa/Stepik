package org.hiber.dao;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.hiber.model.Car;
import org.hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

   // @Autowired
   private SessionFactory sessionFactory;

    public void addCarToUser(Long userId, Car car) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        User user = new User();
        user = entityManager.find(User.class,userId);
        car.setOwner(user);
        entityManager.persist(car);
        transaction.commit();
        entityManager.close();
    }

    public void addUser(User user) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(user);
        transaction.commit();
        entityManager.close();

    }

    public void removeCarFromUser(Long userId, Long carId) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Car car = entityManager.find(Car.class,userId);
        entityManager.remove(car);
        transaction.commit();
        entityManager.close();
    }

    public List<User> getAllUsers() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        List<User> users =  entityManager.createNativeQuery("SELECT * FROM users", User.class).getResultList();
        transaction.commit();
        entityManager.close();
        return users;
    }

    public User getUserById(Long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        User user = entityManager.find(User.class,id);
        entityManager.detach(user);
        transaction.commit();
        entityManager.close();
        return user;
    }

    public List<Car> getCarsByUserId(Long userId) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        List<Car> cars = Collections.singletonList(entityManager.find(Car.class, userId));  //createNativeQuery("SELECT * FROM cars WHERE userId = ? ").getResultList();
        transaction.commit();
        entityManager.close();
        return cars;
    }

    public Car getCarById(Long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Car car = entityManager.find(Car.class,id);
        entityManager.detach(car);
        transaction.commit();
        entityManager.close();
        return car;
    }
}
