package implementation.service;

import implementation.repository.UserDaoImpl;
import interfaceService.LoginService;
import pojo.User;
import utils.UtilMD5;

import java.sql.SQLException;

public class LoginServiceImpl implements LoginService {

    UserDaoImpl userDaoImpl = new UserDaoImpl();

    @Override
    public int getRole(String login) {
        User user;
        if (login != null) {
            try {
                user = userDaoImpl.getUserByLogin(login);
                if (user == null) {
                    return -1;
                }
                return user.getRoles();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    @Override
    public User checkAuth(String login, String password) {
        User user;

        if (login != null) {
            try {
                user = userDaoImpl.getUserByLogin(login);
                if (user != null) {
                    if (user.getPassword().equals(UtilMD5.md5Custom(password)))
                        return user;
                } else {
                    return null;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
