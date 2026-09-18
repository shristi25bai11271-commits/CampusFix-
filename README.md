CampusFix
A JAVA Based System For Students to Report Campus Issues And For Admins To Track And Resolve Them.

🔰Project Overview
Students can report campus issues such as :
-Electrical
-Water leakage
-Internet/Wi-Fi
-Broken furniture
-Classroom problems
-Hostel issues
-Cleanliness
-Security
Other campus related problems
Each reported issue will be given an Issue ID, priority level and status to track the progress from reporting to resolving.

🔰Objectives
The main objectives of CampusFix are:
To provide an easy way for students to report campus problems
To maintain all reported issues in one system
To assign priority to issues based on their category
To allow students to track their reported issues
To help administrators manage and update issue status
To identify duplicate complaints
To provide basic statistics about campus issues
To demonstrate Object-Oriented Programming concepts using Java

🔰Features
Student Features
Student registration
Student login
Report a new issue
Select issue category
Select campus location
Add issue description
View personally reported issues
View all reported issues
Search for issues
Upvote existing issues
Track issue status
Logout

Admin Features
Admin login
View all reported issues
Search issues
Update issue status
View issue statistics
Identify high-priority issues
Save issue information
Issue Status

🔰Priority System
CampusFix assigns priority based on the type of issue.
Category Priority
Security Critical
Water Leakage Critical
Electrical High
Internet/Wi-Fi High
Furniture Medium
Cleanliness Medium
This helps administrators address urgent issues immediately.

🔰Project Structure
CampusFix
│
├── User.java
├── Student.java
├── Admin.java
├── Issue.java
├── IssueManager.java
├── FileManager.java
├── Main.java
│
├── LoginFrame.java
├── StudentDashboard.java
├── AdminDashboard.java

Main Classes
User.java
Contains user's information such as
Name
User ID
Email
Password
It also allows the student to login.

Student.java
Extends the User class
Additional student information includes
Branch
Year
Students can report and view their previous campus issues.

Admin.java
Extends the User class
The admin is responsible for
Viewing issues
Updating issue status
Searching issues
Viewing statistics

Issue.java
Represents a single campus issue
It stores information such as
Issue ID
Title
Category
Location
Description
Reported by
Priority
Status
Upvotes

IssueManager.java
Manages all the reported issues
It handles operations such as
Adding issues
Displaying issues
Searching issues
Updating status
Upvoting issues
Calculating statistics
Checking duplicate issues
FileManager.java
Handles saving issue information to a file so that issue data can be stored outside the program.

LoginFrame.java
Provides the graphical login interface so that the students and admins can login.

StudentDashboard.java
Provides the main graphical interface for students
Students can access features such as
Report Issue
My Issues
Search Issues
Logout

AdminDashboard.java
Provides the graphical interface for administrators.

Administrators can access
All Issues
Update Status
Search Issues
Statistics
Logout

🔰User Interface
CampusFix uses Java Swing to create its graphical user interface.
The application contains two dashboards for students and administrators.

//Student Flow//
Login
Student Dashboard
┌─────────────────────────┐
│ Report Issue      │
│ My Issues        │
│ Search Issues      │
│ Upvote Issue      │
│ Logout         │
└─────────────────────────┘

//Admin Flow//
Login
Admin Dashboard
┌─────────────────────────┐
│ View All Issues     │
│ Search Issues      │
│ Update Status      │
│ View Statistics     │
│ Logout         │
└─────────────────────────┘

🔰Technologies Used:
Technology Purpose
Java Main programming language
Java Swing Graphical User Interface
OOP Application structure
ArrayList Storing issues
File Handling Saving issue data
IntelliJ IDEA / VS Code Development environment
Git & GitHub Version control and project hosting

🔰Java Concepts Used:
This project demonstrates several Java concepts:
Classes and Objects
Encapsulation
Inheritance
Constructors
Method Overriding
Method Overloading
ArrayList
Exception Handling
File Handling
Conditional Statements
Loops
String Handling
Java Swing
Event Handling

Default Login Credentials
Student
Email: eva@gmail.com
Password: 12345
Admin
Email: admin@campusfix.com
Password: admin123

🔰Future Improvements
The project can be expanded with:
Database integration using MySQL
Student profile management
Image upload for issue evidence
Email notifications
Real-time notifications
Better duplicate issue detection
Staff/department accounts
Interactive charts and analytics
Issue comments
Location-based issue reporting
Mobile application
Cloud-based storage
Password encryption

Conclusion

CampusFix offers a centralized approach to reporting and managing campus problems.
The project combines Java Object-Oriented Programming with a graphical user interface to create a practical system that can be
expanded into a larger campus management platform.

The main idea is simple:
Report. Track. Resolve.
