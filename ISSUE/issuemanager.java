import java.util.ArrayList;

public class IssueManager {
    private ArrayList<Issue> issues;
    private int nextIssueId;
    public IssueManager() {
        issues = new ArrayList<>();
        nextIssueId = 1;
    }

    // Add a new issue
    public void addIssue(String title, String category, String location, String description, String reportedBy) {
        Issue newIssue = new Issue(nextIssueId, title, category, location, description, reportedBy);

        // Check duplicate
        for (Issue issue : issues) {

            if (newIssue.isDuplicate(issue)) {

                System.out.println("\n⚠ Possible duplicate issue found!");
                System.out.println("Existing Issue ID: "
                        + issue.getIssueId());

                return;
            }
        }

        issues.add(newIssue);
        nextIssueId++;
        System.out.println("\n✓ Issue reported successfully!");
        System.out.println("Issue ID: " + newIssue.getIssueId());
        System.out.println("Priority: " + newIssue.getPriority());
    }

    // Display all issues
    public void displayAllIssues() {
        if (issues.isEmpty()) {
            System.out.println("\nNo issues reported yet.");
            return;
        }

        for (Issue issue : issues) {
            issue.displayIssue();
        }
    }

    // Search issues
    public void searchIssue(String keyword) {
        boolean found = false;

        for (Issue issue : issues) {
            if (issue.matches(keyword)) {
                issue.displayIssue();
                found = true;
            }
        }
        if (!found) {
            System.out.println("\nNo matching issue found.");
        }
    }

    // Display issues reported by a student
    public void displayStudentIssues(String userId) {

        boolean found = false;
        for (Issue issue : issues) {
            if (issue.getReportedBy().equals(userId)) {
                issue.displayIssue();
                found = true;
            }
        }
        if (!found) {
            System.out.println("\nYou have not reported any issues.");
        }
    }

    // Upvote an issue
    public void upvoteIssue(int issueId) {

        for (Issue issue : issues) {
            if (issue.getIssueId() == issueId) {
                issue.upvote();
                System.out.println("\n✓ Issue upvoted!");
                return;
            }
        }

        System.out.println("\nIssue not found.");
    }

    // Update issue status
    public void updateIssueStatus(int issueId, String status) {

        for (Issue issue : issues) {
            if (issue.getIssueId() == issueId) {
                issue.updateStatus(status);
                System.out.println("\n✓ Status updated successfully!");
                return;
            }
        }
        System.out.println("\nIssue not found.");
    }

    // Statistics
    public void displayStatistics() {
        int total = issues.size();
        int reported = 0;
        int resolved = 0;
        int highPriority = 0;

        for (Issue issue : issues) {
            if (issue.getStatus().equalsIgnoreCase("Reported")) {
                reported++;
            }
            if (issue.getStatus().equalsIgnoreCase("Resolved")) {
                resolved++;
            }
            if (issue.getPriority().equalsIgnoreCase("High") ||
                    issue.getPriority().equalsIgnoreCase("Critical")) {

                highPriority++;
            }
        }

        System.out.println("\n===== UNIFIX STATISTICS =====");
        System.out.println("Total Issues: " + total);
        System.out.println("Reported: " + reported);
        System.out.println("Resolved: " + resolved);
        System.out.println("High/Critical Priority: " + highPriority);
    }
}
