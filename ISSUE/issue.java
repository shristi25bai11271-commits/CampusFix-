public class Issue {
    private int issueId;
    private String title;
    private String category;
    private String location;
    private String description;
    private String reportedBy;
    private String priority;
    private String status;
    private int upvotes;

    public Issue(int issueId, String title, String category, String location, String description, String reportedBy) {
        this.issueId = issueId;
        this.title = title;
        this.category = category;
        this.location = location;
        this.description = description;
        this.reportedBy = reportedBy;
        this.priority = calculatePriority();
        this.status = "Reported";
        this.upvotes = 0;
    }

    // Automatic priority calculation
    private String calculatePriority() {
        if (category.equalsIgnoreCase("Security") ||
                category.equalsIgnoreCase("Water Leakage")) {
            return "Critical";

        } else if (category.equalsIgnoreCase("Electrical") ||
                category.equalsIgnoreCase("Internet/Wi-Fi")) {
            return "High";

        } else if (category.equalsIgnoreCase("Furniture") ||
                category.equalsIgnoreCase("Cleanliness")) {
            return "Medium";

        } else {
            return "Low";
        }
    }

    public void upvote() {
        upvotes++;
    }
    public void displayIssue() {

        System.out.println("\n-----------------------------");
        System.out.println("Issue ID: " + issueId);
        System.out.println("Title: " + title);
        System.out.println("Category: " + category);
        System.out.println("Location: " + location);
        System.out.println("Description: " + description);
        System.out.println("Reported By: " + reportedBy);
        System.out.println("Priority: " + priority);
        System.out.println("Status: " + status);
        System.out.println("Upvotes: " + upvotes);
        System.out.println("-----------------------------");
    }

    public boolean matches(String keyword) {
        keyword = keyword.toLowerCase();

        return title.toLowerCase().contains(keyword) ||
                category.toLowerCase().contains(keyword) ||
                location.toLowerCase().contains(keyword) ||
                description.toLowerCase().contains(keyword);
    }

    public boolean isDuplicate(Issue other) {
        return this.category.equalsIgnoreCase(other.category)
                && this.location.equalsIgnoreCase(other.location)
                && this.title.equalsIgnoreCase(other.title);
    }
    public void updateStatus(String status) {
        this.status = status;
    }
    public int getIssueId() {
        return issueId;
    }
    public String getTitle() {
        return title;
    }
    public String getCategory() {
        return category;
    }
    public String getLocation() {
        return location;
    }
    public String getStatus() {
        return status;
    }
    public String getPriority() {
        return priority;
    }
    public String getReportedBy() {
        return reportedBy;
    }
}
