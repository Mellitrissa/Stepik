package jdbc.dao;

import jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    private SessionFactory sessionFactory;
    public UserDaoHibernateImpl () {
        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(User.class);
        sessionFactory = configuration.buildSessionFactory();
    }


    @Override
    public void createUsersTable() {
        Session session = sessionFactory.openSession();
        Transaction one = session.beginTransaction();
        String sql = "CREATE TABLE IF NOT EXISTS persons.Users " +
                "(id SERIAL PRIMARY KEY , " +
                " firstName VARCHAR(255), " +
                " lastName VARCHAR(255), " +
                " age SMALLINT NOT NULL)";
         session.createNativeQuery(sql).executeUpdate();
        one.commit();
        session.close();
    }

    @Override
    public void dropUsersTable() {
        Session session = sessionFactory.openSession();
        Transaction one = session.beginTransaction();
        String sql = "DROP TABLE IF EXISTS persons.Users";
        session.createNativeQuery(sql).executeUpdate();
        one.commit();
        session.close();
    }

    @Override
    public void saveUser(String firstName, String lastName, byte age) {
        Session session = sessionFactory.openSession();
        try{Transaction one = session.beginTransaction();
            User user = new User();
            user.setName(firstName);
            user.setLastName(lastName);
            user.setAge(age);
            session.persist(user);
        one.commit();}catch (HibernateException ex){
            ex.printStackTrace();
        }
        session.close();
    }

    @Override
    public void removeUserById(long id) {
        Session session = sessionFactory.openSession();
        Transaction one = session.beginTransaction();
        User f = session.get(User.class,id);
        session.delete(f);
        one.commit();
        session.close();
    }

    @Override
    public List<User> getAllUsers() {

        Session session = sessionFactory.openSession();
        Transaction one = session.beginTransaction();
        String sql = "SELECT * FROM users ";
        List<User> users = (List<User>) session.createNativeQuery(sql).list();
        one.commit();
        session.close();
        return users;

    }

    @Override
    public void cleanUsersTable() {

        Session session = sessionFactory.openSession();
        Transaction one = session.beginTransaction();
        String sql = "DELETE FROM Users ";
        session.createNativeQuery(sql).executeUpdate();
        one.commit();
        session.close();
    }
}
