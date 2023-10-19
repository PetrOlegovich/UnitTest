package seminar;

import java.util.*;

public class UserRepository {

    public List<User> data = new ArrayList<>();

    public boolean addUser(User user) {
        if (user.isAuth()) {
            data.add(user);
            return true;
        }
        return false;
    }

    public void logoutNonAdminUsers() {
        for (User user : data) {
            if (!user.isAdmin()) {
                logoutUser(user);
            } else {
                user.setAuth(true);
            }
        }
    }


    public void logoutUser(User user) {
        user.setAuth(false);
    }
}