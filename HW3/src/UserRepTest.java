import seminar;

import org.junit.jupiter.api.Test;
import seminars.third.tdd.UserRepository;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


//    Задание 3.  (необязательное)
//    Добавьте функцию в класс UserRepository, которая разлогинивает всех пользователей, кроме администраторов.
//    Для этого, вам потребуется расширить класс User новым свойством, указывающим, обладает ли пользователь
//    админскими правами. Протестируйте данную функцию.
//*Формат сдачи: *воспользуйтесь одним из вариантов: Ссылка на репозиторий Git или Прикрепленный архив


public class UserRepositoryTest {

    @Test
    public void testAuthWithCorrectCredentials() {
        User user = new User("user1", "password1", "user", false);
        assertTrue(user.authenticate("user1", "password1"));
    }

    @Test
    public void testAuthWithIncorrectCredentials() {
        User user = new User("user1", "password1", "user", false);
        assertFalse(user.authenticate("user1", "wrong_password"));
    }

    @Test
    public void testIsAdminForAdminUser() {
        User adminUser = new User("admin", "adminpass", "admin", true);
        assertTrue(adminUser.isAdmin());
    }

    @Test
    public void testIsAdminForRegularUser() {
        User regularUser = new User("user1", "password1", "user", false);
        assertFalse(regularUser.isAdmin());
    }

    @Test
    public void testAuthenticateUserWithCorrectCredentials() {
        User user = new User("user1", "password1", "user", false);
        assertTrue(user.authenticate("user1", "password1"));
    }

    @Test
    public void testAuthenticateUserWithIncorrectCredentials() {
        User user = new User("user1", "password1", "user", false);
        UserRepository repository = new UserRepository();
        boolean authResult = user.authenticate("user1", "wrong_password");
        assertFalse(authResult);
        boolean addedToRepository = repository.addUser(user);
        assertFalse(user.isAuth());
        assertFalse(addedToRepository);
    }


    @Test
    public void testAddUserWithAdminUser() {
        User adminUser = new User("admin", "adminpass", "admin", true);
        UserRepository repository = new UserRepository();
        adminUser.setAuth(true);
        assertTrue(repository.addUser(adminUser));
    }

    @Test
    public void testAddUserWithAuthenticatedUser() {
        User user = new User("user1", "password1", "user", false);
        assertTrue(user.authenticate("user1", "password1"));
    }

    @Test
    public void testAddUserWithRegularUnauthenticatedUser() {
        User user = new User("user1", "password1", "user", false);
        UserRepository repository = new UserRepository();
        assertFalse(repository.addUser(user));
    }

    @Test
    public void testLogoutNonAdminUsers() {
        User adminUser = new User("admin", "adminpass", "admin", true);
        User regularUser1 = new User("user1", "user1pass", "user", false);
        User regularUser2 = new User("user2", "user2pass", "user", false);

        UserRepository repository = new UserRepository();
        assertTrue(adminUser.auth("admin", "adminpass"));
        assertTrue(regularUser1.auth("user1", "user1pass"));
        assertTrue(regularUser2.auth("user2", "user2pass"));
        repository.addUser(adminUser);
        repository.addUser(regularUser1);
        repository.addUser(regularUser2);

        assertTrue(adminUser.isAuth());
        assertTrue(regularUser1.isAuth());
        assertTrue(regularUser2.isAuth());
        assertTrue(adminUser.isAdmin());
        assertFalse(regularUser1.isAdmin());

        repository.logoutNonAdminUsers();

        assertTrue(adminUser.isAuth());
        assertFalse(regularUser1.isAuth());
        assertFalse(regularUser2.isAuth());
    }
}