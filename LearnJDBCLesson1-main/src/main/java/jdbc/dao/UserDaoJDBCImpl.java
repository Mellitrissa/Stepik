package jdbc.dao;

import jdbc.model.User;
import jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class UserDaoJDBCImpl implements UserDao {

    public UserDaoJDBCImpl() {
    }

    public void createUsersTable()  {
        try (Statement statement= Util.getConnection().createStatement()){
            String sql = "CREATE TABLE  Users " +
                    "(id SERIAL PRIMARY KEY , " +
                    " firstName VARCHAR(255), " +
                    " lastName VARCHAR(255), " +
                    " age SMALLINT NOT NULL)";
            statement.executeUpdate(sql);

        }catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void dropUsersTable() {
        try (Statement statement= Util.getConnection().createStatement()){
            String sql = "DROP TABLE IF EXISTS Users ";
            statement.executeUpdate(sql);
        }catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveUser(String firstName, String lastName, byte age) {
        String sql = "INSERT INTO public.users (firstName,lastName,age)" + " VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement= Util.getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();
        }  catch (SQLException e) {
            throw new IllegalStateException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /*В тесте всегда значение один
     * в реальной базе значения всегда передаются разные,
     * ведь удалить мы хотим определенного персонажа*/
    public void removeUserById(long id) {
        String sql = "DELETE FROM Users WHERE id = ?";
        try (PreparedStatement preparedStatement= Util.getConnection().prepareStatement(sql)){
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() {
        List <User> users = new ArrayList <>();
        String sql = "SELECT * FROM users ";
        try (Statement statement= Util.getConnection().createStatement()){
            try (ResultSet resultSet = statement.executeQuery(sql)){
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong(1));
                user.setFirstName(resultSet.getString(2));
                user.setLastName(resultSet.getString(3));
                user.setAge(resultSet.getByte(4));
                users.add(user);
            }
            }
        }catch (SQLException e) {
            throw new IllegalStateException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    public void cleanUsersTable() {
        try (Statement statement= Util.getConnection().createStatement()){
        String sql = "DELETE FROM Users ";
        statement.executeUpdate(sql);
    }catch (SQLException e) {
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
        throw new RuntimeException(e);
    }
    }
}
