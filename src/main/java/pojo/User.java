package pojo;

public class User {
    private Integer id;
    private Integer roles;
    private String login;
    private String password;
    private String name;
    private String surname;


    public User(Integer id, Integer roles, String login, String password, String name, String surname) {
        this.id = id;
        this.roles = roles;
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

    public User(Integer id, Integer roles) {
        this.id = id;
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UserDao{" +
                "id=" + id +
                ", roles=" + roles +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoles() {
        return roles;
    }

    public void setRoles(Integer roles) {
        this.roles = roles;
    }
}
