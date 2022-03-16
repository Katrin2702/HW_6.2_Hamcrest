import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void getUsers() {
        User [] users = {new User("kat333", "pass123", "kat333@gmail.com", 24),
                         new User("safer", "55gk06", "safer@gmail.com", 18),
                         new User("usermod666", "njg556hg", "usermod@gmail.com", 32),
                         new User("star13", "64wddx5", "star13@gmail.com", 14)};

        assertThat(users, samePropertyValuesAs(Main.getUsers()));
    }

    @Test
    void getUserByLoginAndPassword() throws UserNotFoundException {
        String login = "kat333", password = "pass123";
        String login1 = "kat333", password1 = "0000";
        User expected = new User("kat333", "pass123", "kat333@gmail.com", 24);

        assertThat(expected, samePropertyValuesAs(Main.getUserByLoginAndPassword(login, password)));


        Throwable thrown = assertThrows(UserNotFoundException.class, () -> {
            Main.getUserByLoginAndPassword(login1, password1);
        });
        assertNotNull(thrown.getMessage());

    }

    @Test
    void validateUser() throws AccessDeniedException {
        User user = new User("safer", "55gk06", "safer@gmail.com", 18);
        String expected = "Доступ предоставлен";

        assertThat(expected, equalTo(Main.validateUser(user)));

        assertThat(user, Matchers.<User> hasProperty("age"));
    }


}