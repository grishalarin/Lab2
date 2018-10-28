package interfaceService;

import pojo.User;

public interface LoginService {
    int getRole(String login);

    User checkAuth(String login, String password);
}
