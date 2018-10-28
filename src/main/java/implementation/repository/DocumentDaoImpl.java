package implementation.repository;

import connection.ConnectionManager;
import connection.ConnectionManagerJdbcImpl;
import intefaceDao.DocumentDao;
import pojo.Document;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DocumentDaoImpl implements DocumentDao {

    ConnectionManager connectionManager = ConnectionManagerJdbcImpl.getInstance();

    @Override
    public Document addDocument(Document document) {
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO document values (default ,?, ?,?);"
                    //  PreparedStatement preparedStatement2 = connection.prepareStatement(
            );
            preparedStatement.setInt(1, document.getDocType());
            preparedStatement.setString(2, document.getData());
            preparedStatement.setString(3, document.getUserLogin());
            // preparedStatement2.setInt(1,userDoc.getIdDoc());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return document;
    }

    @Override
    public boolean deleteDocument(Integer id) {
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM document WHERE id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Document getDocumentByLogin(String login) {
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM document inner join \"user\" on document.user_login = \"user\".login WHERE id= ?");
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Document(
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getString(3),
                        resultSet.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Document getDocumentByType(Integer idType) {
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM document WHERE doc_type= ?");
            preparedStatement.setInt(1, idType);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Document(
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getString(3),
                        resultSet.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Document addDocumentType(Integer docType) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO document  values (doc_type=?)")) {
            preparedStatement.setInt(1, docType);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;
    }

    @Override
    public boolean updateDocument(pojo.Document document) {
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE document SET id=?, doc_type=?, data=? " +
                            "WHERE id=?");
            preparedStatement.setInt(1, document.getId());
            preparedStatement.setInt(2, document.getDocType());
            preparedStatement.setString(3, document.getData());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
