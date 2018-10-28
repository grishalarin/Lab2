package intefaceDao;

import pojo.User;

import java.sql.SQLException;

public interface UserDao {
    User addUser(User user);

    User addUserRole(int userRole) throws SQLException;

    boolean deleteUser(User user);

    User getUserByLogin(String login) throws SQLException;

    User getUserById(Integer id) throws SQLException;
}
