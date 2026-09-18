
import javax.swing.*;
import java.awt.*;

public class AdminDashboard extends JFrame {

    public AdminDashboard() {

        setTitle("CampusFix - Admin Dashboard");
        setSize(1000, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // ================= MAIN PANEL =================

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(245, 247, 250));

        // ================= SIDEBAR =================

        JPanel sidebar = new JPanel();

        sidebar.setPreferredSize(
                new Dimension(210, 650)
        );

        sidebar.setBackground(
                new Color(35, 90, 65)
        );

        sidebar.setLayout(
                new BoxLayout(
                        sidebar,
                        BoxLayout.Y_AXIS
                )
        );

        JLabel logo = new JLabel("UniFix");

        logo.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        28
                )
        );

        logo.setForeground(Color.WHITE);
        logo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitle = new JLabel(
                "ADMIN PANEL"
        );

        subtitle.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        12
                )
        );

        subtitle.setForeground(Color.WHITE);
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        sidebar.add(Box.createVerticalStrut(30));
        sidebar.add(logo);
        sidebar.add(subtitle);

        sidebar.add(Box.createVerticalStrut(50));

        JButton dashboardButton =
                createSidebarButton("Dashboard");

        JButton issuesButton =
                createSidebarButton("All Issues");

        JButton updateButton =
                createSidebarButton("Update Status");

        JButton searchButton =
                createSidebarButton("Search Issues");

        JButton statisticsButton =
                createSidebarButton("Statistics");

        JButton logoutButton =
                createSidebarButton("Logout");

        sidebar.add(dashboardButton);
        sidebar.add(issuesButton);
        sidebar.add(updateButton);
        sidebar.add(searchButton);
        sidebar.add(statisticsButton);

        sidebar.add(Box.createVerticalGlue());

        sidebar.add(logoutButton);

        sidebar.add(Box.createVerticalStrut(30));

        // ================= CONTENT =================

        JPanel contentPanel =
                new JPanel(new BorderLayout());

        contentPanel.setBackground(
                new Color(245, 247, 250)
        );

        // ================= TOP BAR =================

        JPanel topPanel =
                new JPanel(new BorderLayout());

        topPanel.setBackground(Color.WHITE);

        topPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        20,
                        25,
                        20,
                        25
                )
        );

        JLabel title =
                new JLabel("Admin Dashboard");

        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        24
                )
        );

        JLabel adminName =
                new JLabel("CampusFix Administrator");

        adminName.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        14
                )
        );

        topPanel.add(
                title,
                BorderLayout.WEST
        );

        topPanel.add(
                adminName,
                BorderLayout.EAST
        );

        contentPanel.add(
                topPanel,
                BorderLayout.NORTH
        );

        // ================= STAT CARDS =================

        JPanel cards =
                new JPanel(
                        new GridLayout(
                                2,
                                2,
                                20,
                                20
                        )
                );

        cards.setBackground(
                new Color(245, 247, 250)
        );

        cards.setBorder(
                BorderFactory.createEmptyBorder(
                        30,
                        30,
                        30,
                        30
                )
        );

        JPanel totalCard =
                createCard(
                        "Total Issues",
                        "25"
                );

        JPanel pendingCard =
                createCard(
                        "Pending",
                        "8"
                );

        JPanel progressCard =
                createCard(
                        "In Progress",
                        "5"
                );

        JPanel resolvedCard =
                createCard(
                        "Resolved",
                        "12"
                );

        cards.add(totalCard);
        cards.add(pendingCard);
        cards.add(progressCard);
        cards.add(resolvedCard);

        contentPanel.add(
                cards,
                BorderLayout.CENTER
        );

        // ================= ACTION BUTTONS =================

        JPanel actionPanel =
                new JPanel(
                        new GridLayout(
                                1,
                                3,
                                15,
                                15
                        )
                );

        actionPanel.setBackground(
                new Color(245, 247, 250)
        );

        actionPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        0,
                        30,
                        30,
                        30
                )
        );

        JButton viewIssues =
                new JButton("View All Issues");

        JButton updateStatus =
                new JButton("Update Status");

        JButton statistics =
                new JButton("View Statistics");

        viewIssues.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        updateStatus.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        statistics.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        actionPanel.add(viewIssues);
        actionPanel.add(updateStatus);
        actionPanel.add(statistics);

        contentPanel.add(
                actionPanel,
                BorderLayout.SOUTH
        );

        // ================= BUTTON ACTIONS =================

        issuesButton.addActionListener(e -> {

            JOptionPane.showMessageDialog(
                    this,
                    "All Issues screen will open here."
            );

        });

        viewIssues.addActionListener(e -> {

            JOptionPane.showMessageDialog(
                    this,
                    "All Issues screen will open here."
            );

        });

        updateButton.addActionListener(e -> {

            JOptionPane.showMessageDialog(
                    this,
                    "Update Status screen will open here."
            );

        });

        updateStatus.addActionListener(e -> {

            JOptionPane.showMessageDialog(
                    this,
                    "Update Status screen will open here."
            );

        });

        searchButton.addActionListener(e -> {

            JOptionPane.showMessageDialog(
                    this,
                    "Search Issues screen will open here."
            );

        });

        statisticsButton.addActionListener(e -> {

            JOptionPane.showMessageDialog(
                    this,
                    "Statistics screen will open here."
            );

        });

        statistics.addActionListener(e -> {

            JOptionPane.showMessageDialog(
                    this,
                    "Statistics screen will open here."
            );

        });

        logoutButton.addActionListener(e -> {

            int choice =
                    JOptionPane.showConfirmDialog(
                            this,
                            "Are you sure you want to logout?",
                            "Logout",
                            JOptionPane.YES_NO_OPTION
                    );

            if (choice ==
                    JOptionPane.YES_OPTION) {

                dispose();

                new LoginFrame();
            }

        });

        // ================= ADD PANELS =================

        mainPanel.add(
                sidebar,
                BorderLayout.WEST
        );

        mainPanel.add(
                contentPanel,
                BorderLayout.CENTER
        );

        add(mainPanel);

        setVisible(true);
    }

    // ================= SIDEBAR BUTTON =================

    private JButton createSidebarButton(
            String text
    ) {

        JButton button =
                new JButton(text);

        button.setMaximumSize(
                new Dimension(
                        190,
                        45
                )
        );

        button.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        button.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        14
                )
        );

        button.setForeground(Color.WHITE);

        button.setBackground(
                new Color(35, 90, 65)
        );

        button.setFocusPainted(false);
        button.setBorderPainted(false);

        return button;
    }

    // ================= CARD =================

    private JPanel createCard(
            String title,
            String value
    ) {

        JPanel card =
                new JPanel(
                        new GridLayout(
                                2,
                                1
                        )
                );

        card.setBackground(Color.WHITE);

        JLabel titleLabel =
                new JLabel(
                        "   " + title
                );

        titleLabel.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        14
                )
        );

        JLabel valueLabel =
                new JLabel(
                        "   " + value
                );

        valueLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        30
                )
        );

        card.add(titleLabel);
        card.add(valueLabel);

        return card;
    }

    // ================= MAIN =================

    public static void main(String[] args) {

        new AdminDashboard();

    }
}
