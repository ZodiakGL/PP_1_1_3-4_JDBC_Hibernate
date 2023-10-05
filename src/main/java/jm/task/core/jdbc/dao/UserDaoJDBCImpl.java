package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    Util util = new Util();

    public UserDaoJDBCImpl() {

    }
    public void createUsersTable() {
        try (Connection connection = util.getConnection();
                Statement statement = connection.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS users (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "name VARCHAR(50) NOT NULL," +
                    "lastName VARCHAR(50) NOT NULL," +
                    "age SMALLINT NOT NULL)";
            statement.executeUpdate(sql);
        } catch (SQLException e) {

        }
    }

    public void dropUsersTable() {
        try (Connection connection = util.getConnection();
                Statement statement = connection.createStatement()) {
            String sql = "DROP TABLE IF EXISTS users";
            statement.executeUpdate(sql);
        } catch (SQLException e) {

        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try (Connection connection = util.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users(name, lastName, age) VALUES (?, ?, ?)" )){
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {

        }
    }

    public void removeUserById(long id) {
        try (Connection connection = util.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM users WHERE id = ?" )){
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {

        }

    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try(Connection connection = util.getConnection();
                Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));
                users.add(user);
            }
        } catch (SQLException e) {

        }
        return users;
    }

    public void cleanUsersTable() {
        try (Connection connection = util.getConnection();
                Statement statement = connection.createStatement()) {
            String sql = "DELETE FROM users";
            statement.executeUpdate(sql);

        } catch (SQLException e) {

        }
    }
}
