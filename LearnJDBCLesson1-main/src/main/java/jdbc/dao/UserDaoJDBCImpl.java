package jdbc.dao;

import jdbc.model.User;
import jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;


public class UserDaoJDBCImpl implements UserDao {
    //private Util util = new Util();

    public UserDaoJDBCImpl() {

    }
    private static final Function<ResultSet, User> userRowMapper = row -> {
        try {
            return User.builder()
                    .id(row.getLong("id"))
                    .firstName(row.getString("firstName"))
                    .lastName(row.getString("lastName"))
                    .age(row.getByte("age"))
                    .build();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    };


    public void createUsersTable()  {
        try (Statement statement= Util.getConnection().createStatement()){
            String sql = "CREATE TABLE  Users " +
                    "(id SERIAL, " +
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
        String sql = "INSERT INTO Users (firstName,lastName,age)" + " VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement= Util.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            User user = new User();
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setByte(3, user.getAge());
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows != 1) {
                throw new SQLException("Can't insert user");
            }
            try (ResultSet generatedId = preparedStatement.getGeneratedKeys()) {
                if (generatedId.next()) {
                    user.setId(generatedId.getLong("id"));
                } else {
                    throw new SQLException("Can't obtain generated id");
                }
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /*В тесте всегда значение один
     * в реальной базе значения всегда передаются разные,
     * ведь удалить мы хотим определенного персонажа*/
    public void removeUserById(long id) {
        try (Statement statement= Util.getConnection().createStatement()){
            String sql = "DELETE FROM  Users " + "WHERE (id=(?))";
            statement.executeUpdate(sql);
        }catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() {
        List <User> users = new ArrayList <>();
        try (Statement statement= Util.getConnection().createStatement()){
            String sql = "SELECT FROM Users ";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
               User user = userRowMapper.apply(resultSet);
                users.add(user);
            }
        }catch (SQLException e) {
            e.printStackTrace();
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
