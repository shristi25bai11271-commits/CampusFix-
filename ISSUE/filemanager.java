import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {

    public static void saveIssues(ArrayList<Issue> issues) {

        try {

            FileWriter writer = new FileWriter("issues.txt");

            for (Issue issue : issues) {

                writer.write(
                        "Issue ID: " + issue.getIssueId() + "\n"
                                + "Title: " + issue.getTitle() + "\n"
                                + "Category: " + issue.getCategory() + "\n"
                                + "Location: " + issue.getLocation() + "\n"
                                + "Priority: " + issue.getPriority() + "\n"
                                + "Status: " + issue.getStatus() + "\n"
                                + "Reported By: " + issue.getReportedBy() + "\n"
                                + "--------------------------\n"
                );
            }

            writer.close();
            System.out.println("\n✓ Issues saved successfully.");

        } catch (IOException e) {

            System.out.println("Error while saving issues.");
        }
    }
}
