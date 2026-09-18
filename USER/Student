public class User {

    protected String name;
    protected String userId;
    protected String email;
    protected String password;

    public User(String name, String userId, String email, String password) {
        this.name = name;
        this.userId = userId;
        this.email = email;
        this.password = password;
    }

    public boolean login(String enteredEmail, String enteredPassword) {
        return email.equals(enteredEmail) &&
                password.equals(enteredPassword);
    }

    public void displayUserDetails() {
        System.out.println("Name: " + name);
        System.out.println("User ID: " + userId);
        System.out.println("Email: " + email);
    }

    public String getName() {
        return name;
    }

    public String getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }
}
