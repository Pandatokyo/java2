package lesson7;


import java.util.ArrayList;
import java.util.List;

public class BaseAuthService implements Auth {
    private final List<User> users = new ArrayList<>();

    public BaseAuthService() {
        users.add(new User("Alex", "password", "Alexander"));
        users.add(new User("Nick", "password1", "Nick"));
    }


    public String authByLoginAndPassword(String login, String password) {
        for (User user : users) {
            if (login.equals(user.login())
                    && password.equals(user.password()))
                return user.nickname();
        }
        return null;
    }
}
