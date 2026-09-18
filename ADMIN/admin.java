public class Admin extends User {

    public Admin(String name, String userId, String email, String password) {
        super(name, userId, email, password);
    }

    public void displayAdminDetails() {

        System.out.println("\n===== ADMIN DETAILS =====");
        System.out.println("Name: " + name);
        System.out.println("Admin ID: " + userId);
        System.out.println("Email: " + email);
    }
}
