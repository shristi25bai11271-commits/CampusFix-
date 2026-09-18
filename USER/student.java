public class Student extends User {

    private String branch;
    private int year;

    public Student(String name, String userId, String email, String password, String branch, int year) {
        super(name, userId, email, password);
        this.branch = branch;
        this.year = year;
    }

    public void displayStudentDetails() {
        System.out.println("\n===== STUDENT DETAILS =====");
        System.out.println("Name: " + name);
        System.out.println("Student ID: " + userId);
        System.out.println("Email: " + email);
        System.out.println("Branch: " + branch);
        System.out.println("Year: " + year);
    }
    public String getBranch() {
        return branch;
    }
    public int getYear() {
        return year;
    }
}
