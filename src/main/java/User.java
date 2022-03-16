public class User {

    private String login;
    private String password;
    private String email;
    private int age;

    public User (String login, String password, String email, int age){
        this.login = login;
        this.password = password;
        this.email = email;
        this.age = age;
    }

    protected String getLogin() {
        return login;
    }

    protected String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }



}
