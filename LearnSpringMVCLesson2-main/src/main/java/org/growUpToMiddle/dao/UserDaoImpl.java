package org.growUpToMiddle.dao;

import org.growUpToMiddle.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class UserDaoImpl implements UserDao {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        entityManager.getTransaction().begin();
        List<User> users =  entityManager.createNativeQuery("SELECT * FROM users", User.class).getResultList();
        entityManager.getTransaction().commit();
        return users;
    }

    @Override
    public void saveUser(User user) {
        entityManager.getTransaction().begin();

        entityManager.getTransaction().commit();
    }

    @Override
    public User getUserById(Long id) {
        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class,id);
        entityManager.detach(user);
        entityManager.getTransaction().commit();
        return user;
    }

    @Override
    public void addUser(User user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteUser(Long id) {
        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class,id);
        entityManager.remove(user);
        entityManager.getTransaction().commit();
    }


}
