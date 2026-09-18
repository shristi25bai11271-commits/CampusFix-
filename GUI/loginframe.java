import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    private JTextField emailField;
    private JPasswordField passwordField;
    private JComboBox<String> roleBox;

    public LoginFrame() {

        setTitle("CampusFix - Login");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(245, 247, 250));

        // ---------------- HEADER ----------------

        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(40, 100, 70));
        headerPanel.setLayout(new GridLayout(2, 1));

        JLabel titleLabel = new JLabel("CampusFix", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
        titleLabel.setForeground(Color.WHITE);

        JLabel subtitleLabel = new JLabel(
                "Report. Track. Resolve.",
                SwingConstants.CENTER
        );
        subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        subtitleLabel.setForeground(Color.WHITE);

        headerPanel.add(titleLabel);
        headerPanel.add(subtitleLabel);

        // ---------------- FORM ----------------

        JPanel formPanel = new JPanel();
        formPanel.setBackground(Color.WHITE);
        formPanel.setBorder(
                BorderFactory.createEmptyBorder(30, 50, 30, 50)
        );

        formPanel.setLayout(new GridLayout(7, 1, 10, 5));

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setFont(new Font("Arial", Font.BOLD, 14));

        emailField = new JTextField();

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 14));

        passwordField = new JPasswordField();

        JLabel roleLabel = new JLabel("Login As");
        roleLabel.setFont(new Font("Arial", Font.BOLD, 14));

        roleBox = new JComboBox<>(
                new String[]{"Student", "Admin"}
        );

        JButton loginButton = new JButton("LOGIN");
        loginButton.setFont(new Font("Arial", Font.BOLD, 14));

        formPanel.add(emailLabel);
        formPanel.add(emailField);

        formPanel.add(passwordLabel);
        formPanel.add(passwordField);

        formPanel.add(roleLabel);
        formPanel.add(roleBox);

        formPanel.add(loginButton);

        // ---------------- LOGIN ACTION ----------------

        loginButton.addActionListener(e -> login());

        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(formPanel, BorderLayout.CENTER);

        add(mainPanel);

        setVisible(true);
    }

    private void login() {

        String email = emailField.getText();
        String password = new String(passwordField.getPassword());
        String role = (String) roleBox.getSelectedItem();

        if (email.isEmpty() || password.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter email and password.",
                    "Login Error",
                    JOptionPane.ERROR_MESSAGE
            );

            return;
        }

        // Admin login
        if (role.equals("Admin")) {

            if (email.equals("admin@unifix.com")
                    && password.equals("admin123")) {

                JOptionPane.showMessageDialog(
                        this,
                        "Admin login successful!"
                );

                dispose();

                // Later we will create this
                new AdminDashboard();

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Invalid admin email or password.",
                        "Login Failed",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }

        // Student login
        else {

            if (email.equals("rahul@gmail.com")
                    && password.equals("12345")) {

                JOptionPane.showMessageDialog(
                        this,
                        "Student login successful!"
                );

                dispose();

                // Later we will create this
                new StudentDashboard("Rahul");

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Invalid student email or password.",
                        "Login Failed",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }

    public static void main(String[] args) {
        new LoginFrame();
    }
}
