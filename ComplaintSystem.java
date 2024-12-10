import java.util.Hashtable;
import java.util.Scanner;

public class ComplaintSystem {

    // Complaint Class
    public static class Complaint {
        private String complaintId;
        private String description;
        private String priority;
        private String status;

        // Constructor
        public Complaint(String complaintId, String description, String priority) {
            this.complaintId = complaintId;
            this.description = description;
            this.priority = priority;
            this.status = "Pending"; // Default status is Pending
        }

        // Getter and Setter methods
        public String getComplaintId() {
            return complaintId;
        }

        public String getDescription() {
            return description;
        }

        public String getPriority() {
            return priority;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        // Display complaint details
        public void displayComplaint() {
            System.out.println("Complaint ID: " + complaintId);
            System.out.println("Description: " + description);
            System.out.println("Priority: " + priority);
            System.out.println("Status: " + status);
            System.out.println();
        }
    }

    // ComplaintSystem Class
    private Hashtable<String, Complaint> complaints;

    // Constructor to initialize the hash table
    public ComplaintSystem() {
        complaints = new Hashtable<>();
    }

    // Method to add a complaint
    public void addComplaint(String complaintId, String description, String priority) {
        if (complaints.containsKey(complaintId)) {
            System.out.println("Complaint ID already exists! Please use a unique ID.\n");
        } else {
            Complaint newComplaint = new Complaint(complaintId, description, priority);
            complaints.put(complaintId, newComplaint);
            System.out.println("Complaint added successfully!\n");
        }
    }

    // Method to view a complaint
    public void viewComplaint(String complaintId) {
        Complaint complaint = complaints.get(complaintId);
        if (complaint != null) {
            complaint.displayComplaint();
        } else {
            System.out.println("Complaint with ID " + complaintId + " not found.\n");
        }
    }

    // Method to update complaint status
    public void updateStatus(String complaintId, String status) {
        Complaint complaint = complaints.get(complaintId);
        if (complaint != null) {
            complaint.setStatus(status);
            System.out.println("Complaint status updated to: " + status + "\n");
        } else {
            System.out.println("Complaint with ID " + complaintId + " not found.\n");
        }
    }

    // Method to delete a complaint
    public void deleteComplaint(String complaintId) {
        Complaint complaint = complaints.remove(complaintId);
        if (complaint != null) {
            System.out.println("Complaint with ID " + complaintId + " has been deleted.\n");
        } else {
            System.out.println("Complaint with ID " + complaintId + " not found.\n");
        }
    }

    // Display all complaints
    public void displayAllComplaints() {
        if (complaints.isEmpty()) {
            System.out.println("No complaints registered.\n");
        } else {
            for (Complaint complaint : complaints.values()) {
                complaint.displayComplaint();
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ComplaintSystem system = new ComplaintSystem();

        while (true) {
            System.out.println("Complaint Management System");
            System.out.println("1. Add Complaint");
            System.out.println("2. View Complaint");
            System.out.println("3. Update Complaint Status");
            System.out.println("4. Delete Complaint");
            System.out.println("5. Display All Complaints");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    // Add a new complaint
                    System.out.print("Enter Complaint ID: ");
                    String complaintId = scanner.nextLine();
                    System.out.print("Enter Complaint Description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter Priority (High/Medium/Low): ");
                    String priority = scanner.nextLine();
                    system.addComplaint(complaintId, description, priority);
                    break;

                case 2:
                    // View a specific complaint
                    System.out.print("Enter Complaint ID to view: ");
                    complaintId = scanner.nextLine();
                    system.viewComplaint(complaintId);
                    break;

                case 3:
                    // Update complaint status
                    System.out.print("Enter Complaint ID to update status: ");
                    complaintId = scanner.nextLine();
                    System.out.print("Enter new status (Pending/In Progress/Resolved/Closed): ");
                    String status = scanner.nextLine();
                    system.updateStatus(complaintId, status);
                    break;

                case 4:
                    // Delete a complaint
                    System.out.print("Enter Complaint ID to delete: ");
                    complaintId = scanner.nextLine();
                    system.deleteComplaint(complaintId);
                    break;

                case 5:
                    // Display all complaints
                    system.displayAllComplaints();
                    break;

                case 6:
                    // Exit
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
