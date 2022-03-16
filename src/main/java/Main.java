import java.util.Scanner;

public class Main {

    public static User[] getUsers() {
        User user1 = new User("kat333", "pass123", "kat333@gmail.com", 24);
        User user2 = new User("safer", "55gk06", "safer@gmail.com", 18);
        User user3 = new User("usermod666", "njg556hg", "usermod@gmail.com", 32);
        User user4 = new User("star13", "64wddx5", "star13@gmail.com", 14);

        return new User[]{user1, user2, user3, user4};
    }


    public static void main(String[] args) throws UserNotFoundException, AccessDeniedException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите логин");
        String login = scanner.nextLine();
        System.out.println("Введите пароль");
        String password = scanner.nextLine();

        User user = getUserByLoginAndPassword(login, password);

        System.out.println(validateUser(user));

        scanner.close();
    }


    public static User getUserByLoginAndPassword(String login, String password) throws UserNotFoundException {
        User[] users = getUsers();
        for (User user : users) {
            if (login.equals(user.getLogin()) && password.equals(user.getPassword())) {
                return user;
            }
        }
        throw new UserNotFoundException("User not found");
    }


    public static String validateUser(User user) throws AccessDeniedException{
        if (user.getAge() >= 18) {
            return "Доступ предоставлен";
        }
        throw new AccessDeniedException("Ваш возраст менее 18 лет");
    }




}