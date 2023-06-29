package org.growUpToMiddle.dao;

import lombok.RequiredArgsConstructor;
import org.growUpToMiddle.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDaoImpl implements UserDao {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        List<User> users =  entityManager.createNativeQuery("SELECT * FROM users", User.class).getResultList();
        transaction.commit();
        return users;
    }

    @Override
    public void updateUser(Long userId,User user) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        user = entityManager.find(User.class,userId);
        entityManager.persist(user);
        transaction.commit();
    }

    @Override
    public User getUserById(Long id) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        User user = entityManager.find(User.class,id);
        transaction.commit();
        return user;
    }

    @Override
    public void addUser(User user) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(user);
        transaction.commit();
    }

    @Override
    public void deleteUser(Long userId) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        User user = entityManager.find(User.class,userId);
        entityManager.remove(user);
        transaction.commit();
    }


}
