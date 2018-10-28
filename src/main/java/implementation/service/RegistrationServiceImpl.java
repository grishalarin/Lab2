package implementation.service;

import implementation.repository.UserDaoImpl;
import intefaceDao.UserDao;
import interfaceService.RegistrationService;
import pojo.User;
import utils.UtilMD5;

import java.sql.SQLException;

public class RegistrationServiceImpl implements RegistrationService {

    User user;
    private UserDao userDaoNew = new UserDaoImpl();

   /* @Override
    public int setRole(int role) {
        User user;
        if (role != 0) {
            try {
                user = userDaoNew.addUserRole(role);
                if (user == null) {
                    return -1;
                }
                return user.getRoles();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return -1;
    }*/

    @Override
    public User addNewUser(String login, String password, String name, String surname) {
        String userPassword = UtilMD5.md5Custom(password);

        user = new User(null, null, login, userPassword, name, surname);
        try {
            if (userDaoNew.getUserByLogin(login) == null) {
                userDaoNew.addUser(user);
                return user;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
