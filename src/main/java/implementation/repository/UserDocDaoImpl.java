package implementation.repository;

import connection.ConnectionManager;
import connection.ConnectionManagerJdbcImpl;
import intefaceDao.UserDocDao;
import pojo.UserDoc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDocDaoImpl implements UserDocDao {

    ConnectionManager connectionManager = ConnectionManagerJdbcImpl.getInstance();


    @Override
    public boolean deleteUserDoc(Integer id) {
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM user_doc WHERE id_user=?");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public UserDoc getUserDoc(Integer id) {
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM user_doc WHERE id_user = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                UserDoc userDoc = new pojo.UserDoc(
                        resultSet.getInt(1),
                        resultSet.getInt(2));
                return userDoc;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateUserDoc(UserDoc userDoc) {
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE user_doc SET id_user=?, id_doc=? " +
                            "WHERE id_user=?");
            preparedStatement.setInt(1, userDoc.getIdUser());
            preparedStatement.setInt(2, userDoc.getIdDoc());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
