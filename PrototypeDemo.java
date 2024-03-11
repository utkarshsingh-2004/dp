import java.util.Scanner;
// Define the Prototype interface
interface Prototype {
    Prototype getClone();
}





public class PrototypeDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input for creating the original EmployeeRecord
        System.out.println("Enter Employee ID:");
        int id = scanner.nextInt();

        System.out.println("Enter Employee Name:");
        String name = scanner.next();

        System.out.println("Enter Employee Designation:");
        String designation = scanner.next();

        System.out.println("Enter Employee Salary:");
        double salary = scanner.nextDouble();

        System.out.println("Enter Employee Address:");
        String address = scanner.next();

        // Create an original EmployeeRecord with user input
        EmployeeRecord originalRecord = new EmployeeRecord(id, name, designation, salary, address);
        originalRecord.displayRecord();

        try {
            // Clone the original record to create a new copy
            EmployeeRecord clonedRecord = (EmployeeRecord) originalRecord.getClone();
            clonedRecord.displayRecord();
        } catch (Exception e) {
            e.printStackTrace();
        }

        scanner.close();
    }
}








class EmployeeRecord implements Prototype {
    private int employeeId;
    private String employeeName;
    private String designation;
    private double salary;
    private String address;

    // Parameterized constructor
    public EmployeeRecord(int id, String name, String designation, double salary, String address) {
        this.employeeId = id;
        this.employeeName = name;
        this.designation = designation;
        this.salary = salary;
        this.address = address;
    }

    // Copy constructor for cloning
    public EmployeeRecord(EmployeeRecord record) {
        this.employeeId = record.employeeId;
        this.employeeName = record.employeeName;
        this.designation = record.designation;
        this.salary = record.salary;
        this.address = record.address;
    }

    // Getter methods

    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getDesignation() {
        return designation;
    }

    public double getSalary() {
        return salary;
    }

    public String getAddress() {
        return address;
    }

    // Method to display employee record
    public void displayRecord() {
        System.out.println("Employee Record  ID: " + employeeId + ", Name: " + employeeName +
                ", Designation: " + designation + ", Salary: " + salary + ", Address: " + address);
    }

    // Implement the getClone method for cloning
    @Override
    public Prototype getClone() {
        return new EmployeeRecord(this);
    }
}



