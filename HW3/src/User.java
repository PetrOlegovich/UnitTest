package seminar;

public class User {
    private String login;
    private String password;
    private String status;
    private boolean isAdmin;
    private boolean isAuth;

    public User(String login, String password, String status, boolean isAdmin) {
        this.login = login;
        this.password = password;
        this.status = status;
        this.isAdmin = isAdmin;
    }

    public String getLogin() {
        return login;
    }

    public String getStatus() {
        return status;
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

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public void setAuth(boolean auth) {
        isAuth = auth;
    }

    public boolean isAuth() {
        return isAuth;
    }

    public boolean authenticate(String login, String password) {
        boolean authResult = this.login.equals(login) && this.password.equals(password);
        isAuth = authResult;
        return authResult;
    }

    public boolean auth(String login, String password) {
        isAuth = this.login.equals(login) && this.password.equals(password);
        return isAuth;
    }

    public boolean isAdmin() {
        return isAdmin;
    }
}