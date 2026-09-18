import javax.swing.*;
import java.awt.*;

public class StudentDashboard extends JFrame {

    private String studentName;
    public StudentDashboard(String studentName) {
        this.studentName = studentName;
        setTitle("CampusFix - Student Dashboard");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(245, 247, 250));

        // ================= SIDEBAR =================
        JPanel sidebar = new JPanel();
        sidebar.setPreferredSize(new Dimension(200, 600));
        sidebar.setBackground(new Color(35, 90, 65));
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));

        JLabel logo = new JLabel("UniFix");
        logo.setFont(new Font("Arial", Font.BOLD, 28));
        logo.setForeground(Color.WHITE);
        logo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel tagline = new JLabel("Report. Track. Resolve.");
        tagline.setFont(new Font("Arial", Font.PLAIN, 11));
        tagline.setForeground(Color.WHITE);
        tagline.setAlignmentX(Component.CENTER_ALIGNMENT);

        sidebar.add(Box.createVerticalStrut(30));
        sidebar.add(logo);
        sidebar.add(tagline);
        sidebar.add(Box.createVerticalStrut(50));

        JButton dashboardButton = createSidebarButton("Dashboard");
        JButton reportButton = createSidebarButton("Report Issue");
        JButton myIssuesButton = createSidebarButton("My Issues");
        JButton searchButton = createSidebarButton("Search Issues");
        JButton logoutButton = createSidebarButton("Logout");

        sidebar.add(dashboardButton);
        sidebar.add(reportButton);
        sidebar.add(myIssuesButton);
        sidebar.add(searchButton);

        sidebar.add(Box.createVerticalGlue());

        sidebar.add(logoutButton);
        sidebar.add(Box.createVerticalStrut(30));

        // ================= CONTENT =================

        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(new Color(245, 247, 250));
        contentPanel.setLayout(new BorderLayout());

        // Top bar
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(Color.WHITE);
        topPanel.setBorder(
                BorderFactory.createEmptyBorder(20, 25, 20, 25)
        );

        JLabel welcome = new JLabel(
                "Welcome, " + studentName + "!"
        );

        welcome.setFont(new Font("Arial", Font.BOLD, 24));
        JLabel role = new JLabel("Student");
        role.setFont(new Font("Arial", Font.PLAIN, 14));

        topPanel.add(welcome, BorderLayout.WEST);
        topPanel.add(role, BorderLayout.EAST);
        contentPanel.add(topPanel, BorderLayout.NORTH);

        // ================= CARDS =================

        JPanel cardPanel = new JPanel(new GridLayout(1, 3, 20, 20));
        cardPanel.setBackground(new Color(245, 247, 250));
        cardPanel.setBorder(
                BorderFactory.createEmptyBorder(30, 30, 20, 30)
        );

        JPanel reportedCard = createCard(
                "Reported Issues",
                "0"
        );

        JPanel pendingCard = createCard(
                "Pending Issues",
                "0"
        );

        JPanel resolvedCard = createCard(
                "Resolved Issues",
                "0"
        );

        cardPanel.add(reportedCard);
        cardPanel.add(pendingCard);
        cardPanel.add(resolvedCard);

        contentPanel.add(cardPanel, BorderLayout.CENTER);

        // ================= QUICK ACTIONS =================

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(new Color(245, 247, 250));
        bottomPanel.setLayout(new GridLayout(1, 2, 20, 20));
        bottomPanel.setBorder(
                BorderFactory.createEmptyBorder(10, 30, 30, 30)
        );

        JButton reportIssue = new JButton("＋ Report New Issue");
        reportIssue.setFont(new Font("Arial", Font.BOLD, 16));

        JButton viewIssues = new JButton("View My Issues");
        viewIssues.setFont(new Font("Arial", Font.BOLD, 16));

        bottomPanel.add(reportIssue);
        bottomPanel.add(viewIssues);

        contentPanel.add(bottomPanel, BorderLayout.SOUTH);

        // ================= BUTTON ACTIONS =================

        reportButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(
                    this,
                    "Report Issue screen will open here."
            );
        });

        reportIssue.addActionListener(e -> {
            JOptionPane.showMessageDialog(
                    this,
                    "Report Issue screen will open here."
            );
        });

        myIssuesButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(
                    this,
                    "My Issues screen will open here."
            );
        });

        viewIssues.addActionListener(e -> {
            JOptionPane.showMessageDialog(
                    this,
                    "My Issues screen will open here."
            );
        });

        searchButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(
                    this,
                    "Search Issues screen will open here."
            );
        });

        logoutButton.addActionListener(e -> {

            int choice = JOptionPane.showConfirmDialog(
                    this,
                    "Are you sure you want to logout?",
                    "Logout",
                    JOptionPane.YES_NO_OPTION
            );

            if (choice == JOptionPane.YES_OPTION) {
                dispose();
                new LoginFrame();
            }
        });

        // Add everything
        mainPanel.add(sidebar, BorderLayout.WEST);
        mainPanel.add(contentPanel, BorderLayout.CENTER);

        add(mainPanel);

        setVisible(true);
    }

    // ================= SIDEBAR BUTTON =================

    private JButton createSidebarButton(String text) {

        JButton button = new JButton(text);

        button.setMaximumSize(
                new Dimension(180, 45)
        );

        button.setAlignmentX(Component.CENTER_ALIGNMENT);

        button.setFont(
                new Font("Arial", Font.PLAIN, 14)
        );

        button.setForeground(Color.WHITE);
        button.setBackground(new Color(35, 90, 65));

        button.setFocusPainted(false);
        button.setBorderPainted(false);

        return button;
    }

    // ================= CARD =================

    private JPanel createCard(
            String title,
            String value
    ) {

        JPanel card = new JPanel();
        card.setBackground(Color.WHITE);
        card.setLayout(new GridLayout(2, 1));

        JLabel titleLabel = new JLabel(
                "   " + title
        );

        titleLabel.setFont(
                new Font("Arial", Font.PLAIN, 14)
        );

        JLabel valueLabel = new JLabel(
                "   " + value
        );

        valueLabel.setFont(
                new Font("Arial", Font.BOLD, 30)
        );

        card.add(titleLabel);
        card.add(valueLabel);

        return card;
    }
}
