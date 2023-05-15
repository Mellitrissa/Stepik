package jdbc;

import jdbc.dao.UserDaoHibernateImpl;
import jdbc.dao.UserDaoJDBCImpl;
import jdbc.service.UserService;
import jdbc.service.UserServiceImpl;

import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) throws SQLException,
            ClassNotFoundException {
        UserDaoHibernateImpl userConnect = new UserDaoHibernateImpl();
        UserService userService = new UserServiceImpl(userConnect);
        //userService.saveUser("Петя", "Петров", (byte) 35);
        //userService.dropUsersTable();
        //userService.dropUsersTable();
        //userService.createUsersTable();
        //userService.cleanUsersTable();
        //userService.removeUserById(3);
        userService.getAllUsers();

    }
}
