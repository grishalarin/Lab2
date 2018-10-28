package interfaceService;

import pojo.User;

public interface RegistrationService {
    // int setRole(int role);
    User addNewUser(String login, String password, String name, String surname);
}
