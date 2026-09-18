import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<>();
    static Admin admin = new Admin("CampusFix Admin", "ADMIN01", "admin@unifix.com", "admin123");

    static IssueManager issueManager = new IssueManager();
    public static void main(String[] args) {

        // Sample student
        students.add(new Student("Rahul", "STU101", "rahul@gmail.com", "12345", "CSE AIML", 2));
        System.out.println("================================");
        System.out.println("   WELCOME TO CAMPUSFIX");
        System.out.println("   Report. Track. Resolve.");
        System.out.println("================================");

        while (true) {
            System.out.println("\n===== MAIN MENU =====");
            System.out.println("1. Student Login");
            System.out.println("2. Admin Login");
            System.out.println("3. Register Student");
            System.out.println("4. Exit");
            System.out.print("Enter your choice:(Student=1,Admin=2)");

            int choice = getInt();
            switch (choice) {
                case 1:
                    studentLogin();
                    break;
                case 2:
                    adminLogin();
                    break;
                case 3:
                    registerStudent();
                    break;
                case 4:
                    System.out.println("\nThank you for using UniFix!");
                    System.exit(0);
                default:
                    System.out.println("\nInvalid choice.");
            }
        }
    }

    // ================= STUDENT LOGIN =================

    static void studentLogin() {
        System.out.print("\nEnter Email: ");
        String email = sc.nextLine();
        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        for (Student student : students) {
            if (student.login(email, password)) {
                System.out.println("\n✓ Login Successful!");
                studentMenu(student);
                return;
            }
        }
        System.out.println("\n✗ Invalid email or password.");
    }

    // ================= STUDENT MENU =================

    static void studentMenu(Student student) {

        while (true) {

            System.out.println("\n===== STUDENT DASHBOARD =====");
            System.out.println("Welcome, " + student.getName());

            System.out.println("\n1. Report Issue");
            System.out.println("2. View My Issues");
            System.out.println("3. View All Issues");
            System.out.println("4. Search Issue");
            System.out.println("5. Upvote Issue");
            System.out.println("6. Logout");
            System.out.print("Enter choice: ");

            int choice = getInt();
            switch (choice) {
                case 1:
                    reportIssue(student);
                    break;
                case 2:
                    issueManager.displayStudentIssues(student.getUserId());
                    break;
                case 3:
                    issueManager.displayAllIssues();
                    break;
                case 4:
                    searchIssue();
                    break;
                case 5:
                    upvoteIssue();
                    break;
                case 6:
                    System.out.println("\nLogged out.");
                    return;
                default:
                    System.out.println("\nInvalid choice.");
            }
        }
    }

    // ================= REPORT ISSUE =================

    static void reportIssue(Student student) {
        System.out.println("\n===== REPORT AN ISSUE =====");
        System.out.print("Issue Title: ");
        String title = sc.nextLine();
        System.out.println("\nCategories:");
        System.out.println("1. Electrical");
        System.out.println("2. Internet/Wi-Fi");
        System.out.println("3. Furniture");
        System.out.println("4. Cleanliness");
        System.out.println("5. Security");
        System.out.println("6. Water Leakage");
        System.out.println("7. Other");
        System.out.print("Select category: ");

        int categoryChoice = getInt();
        String category;
        switch (categoryChoice) {
            case 1:
                category = "Electrical";
                break;
            case 2:
                category = "Internet/Wi-Fi";
                break;
            case 3:
                category = "Furniture";
                break;
            case 4:
                category = "Cleanliness";
                break;
            case 5:
                category = "Security";
                break;
            case 6:
                category = "Water Leakage";
                break;
            default:
                category = "Other";
        }

        System.out.print("Location: ");
        String location = sc.nextLine();
        System.out.print("Description: ");
        String description = sc.nextLine();

        issueManager.addIssue(
                title,
                category,
                location,
                description,
                student.getUserId()
        );
    }

    // ================= SEARCH =================

    static void searchIssue() {

        System.out.print("\nEnter keyword: ");
        String keyword = sc.nextLine();
        issueManager.searchIssue(keyword);
    }

    // ================= UPVOTE =================

    static void upvoteIssue() {
        System.out.print("\nEnter Issue ID: ");
        int id = getInt();
        issueManager.upvoteIssue(id);
    }

    // ================= ADMIN LOGIN =================

    static void adminLogin() {

        System.out.print("\nAdmin Email: ");
        String email = sc.nextLine();
        System.out.print("Admin Password: ");
        String password = sc.nextLine();

        if (admin.login(email, password)) {
            System.out.println("\n✓ Admin Login Successful!");
            adminMenu();
        } else {
            System.out.println("\n✗ Invalid admin credentials.");
        }
    }

    // ================= ADMIN MENU =================

    static void adminMenu() {
        while (true) {
            System.out.println("\n===== ADMIN DASHBOARD =====");
            System.out.println("1. View All Issues");
            System.out.println("2. Search Issue");
            System.out.println("3. Update Issue Status");
            System.out.println("4. View Statistics");
            System.out.println("5. Save Issues");
            System.out.println("6. Logout");
            System.out.print("Enter choice: ");

            int choice = getInt();
            switch (choice) {
                case 1:
                    issueManager.displayAllIssues();
                    break;
                case 2:
                    searchIssue();
                    break;
                case 3:
                    System.out.print("Enter Issue ID: ");

                    int id = getInt();
                    System.out.println("\n1. Verified");
                    System.out.println("2. Assigned");
                    System.out.println("3. In Progress");
                    System.out.println("4. Resolved");
                    System.out.print("Select status: ");

                    int statusChoice = getInt();
                    String status;
                    switch (statusChoice) {
                        case 1:
                            status = "Verified";
                            break;
                        case 2:
                            status = "Assigned";
                            break;
                        case 3:
                            status = "In Progress";
                            break;
                        case 4:
                            status = "Resolved";
                            break;
                        default:
                            status = "Reported";
                    }

                    issueManager.updateIssueStatus(id, status);
                    break;
                case 4:
                    issueManager.displayStatistics();
                    break;
                case 5:

                    // At the moment IssueManager keeps its own list.
                    // File saving can be expanded when database/file
                    // loading is added.

                    System.out.println("\nFile saving feature is ready for integration.");
                    break;
                case 6:
                    System.out.println("\nAdmin logged out.");
                    return;
                default:
                    System.out.println("\nInvalid choice.");
            }
        }
    }

    // ================= REGISTER =================

    static void registerStudent() {
        System.out.println("\n===== STUDENT REGISTRATION =====");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Student ID: ");
        String userId = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();
        System.out.print("Branch: ");
        String branch = sc.nextLine();
        System.out.print("Year: ");
        int year = getInt();

        Student student = new Student(name, userId, email, password, branch, year);

        students.add(student);
        System.out.println("\n✓ Registration successful!");
    }

    // ================= INTEGER INPUT =================

    static int getInt() {
        while (true) {
            try {
                int value = Integer.parseInt(sc.nextLine());
                return value;
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid number: ");
            }
        }
    }
}
