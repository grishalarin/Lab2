package implementation.repository;

import connection.ConnectionManager;
import connection.ConnectionManagerJdbcImpl;
import intefaceDao.UserDao;
import pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    private static final int ROLE_ADMIN = 1;
    private static final int ROLE_USER = 2;
    ConnectionManager connectionManager = ConnectionManagerJdbcImpl.getInstance();

    @Override
    public User addUser(User user) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO \"user\" values (default,?,?,?,?,?)")) {
            preparedStatement.setInt(1, ROLE_USER);
            preparedStatement.setString(2, user.getLogin());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getName());
            preparedStatement.setString(5, user.getSurname());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }


    @Override
    public User addUserRole(int userRole) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO \"user\"(roles)  values (?)")) {
            preparedStatement.setInt(1, userRole);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;
    }


    @Override
    public boolean deleteUser(User user) {
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM \"user\" WHERE id=?");
            preparedStatement.setInt(1, user.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public User getUserByLogin(String login) throws SQLException {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM \"user\" WHERE \"user\".login = ?")) {
            preparedStatement.setString(1, login);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new pojo.User(resultSet.getInt(1),
                            resultSet.getInt(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public User getUserById(Integer id) throws SQLException {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM \"user\" WHERE \"user\".id = ?")) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new pojo.User(resultSet.getInt(1),
                            resultSet.getInt(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }


}
