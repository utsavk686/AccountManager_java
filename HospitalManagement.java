/*Problem Statement: Hospital Management System
You are tasked with developing a Hospital Management System that manages Doctors, Patients, and Administrative Staff. The system should:
Allow Patients to:
Book appointments with available doctors.
View their medical history securely.
Make payments for consultations and treatments.
Allow Doctors to:
View and manage their daily appointments.
Access patient medical records (restricted access based on their specialization).
Enable Admins to:
Manage user data (Doctors, Patients).
Oversee system-wide functionalities like generating reports or managing schedules.
Key Requirements (Applying OOP Principles):
Abstraction:
Provide simple methods to interact with the system, hiding complex backend operations like appointment scheduling, record retrieval, and payment processing.
        Encapsulation:
Ensure sensitive data such as patient medical records and doctor salaries are secure and accessible only through controlled methods.
        Inheritance:
Create a base class for shared properties (e.g., name, email, phone number) and extend it for specific roles like Doctors, Patients, and Admins.
        Polymorphism:
Implement role-specific actions such as:
Patients viewing prescriptions.
Doctors accessing appointments.
Admins managing all system records.
These actions should exhibit different behaviors based on the user type.
The goal is to design a modular and secure system where different users interact seamlessly while maintaining proper data access and functionality separation.*/



package hospitalManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class User {
    private String name;
    private String email;
    private String phoneNumber;

    public User(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Abstract method for role-specific actions
    public abstract void performRoleAction();
}

class Patient extends User {
    private List<String> medicalHistory = new ArrayList<>();
    private double balanceDue;

    public Patient(String name, String email, String phoneNumber) {
        super(name, email, phoneNumber);
    }

    public void bookAppointment(Doctor doctor) {
        System.out.println("Appointment booked with Dr. " + doctor.getName());
    }

    public void viewMedicalHistory() {
        System.out.println("Medical History of " + getName() + ": " + medicalHistory);
    }

    public void makePayment(double amount) {
        balanceDue -= amount;
        System.out.println("Payment of $" + amount + " made. Remaining balance: $" + balanceDue);
    }

    @Override
    public void performRoleAction() {
        System.out.println(getName() + " is viewing prescriptions.");
    }
}

class Doctor extends User {
    private String specialization;
    private List<String> appointments = new ArrayList<>();

    public Doctor(String name, String email, String phoneNumber, String specialization) {
        super(name, email, phoneNumber);
        this.specialization = specialization;
    }

    public void viewAppointments() {
        System.out.println("Appointments for Dr. " + getName() + ": " + appointments);
    }

    public void accessPatientRecords(Patient patient) {
        System.out.println("Accessing medical records of " + patient.getName() + " (Specialization: " + specialization + ")");
        patient.viewMedicalHistory();
    }

    @Override
    public void performRoleAction() {
        System.out.println("Dr. " + getName() + " is managing appointments.");
    }
}

class Admin extends User {
    private List<User> users = new ArrayList<>();

    public Admin(String name, String email, String phoneNumber) {
        super(name, email, phoneNumber);
    }

    public void manageUsers(User user) {
        users.add(user);
        System.out.println(user.getName() + " has been added to the system.");
    }

    public void generateReport() {
        System.out.println("Generating system-wide report...");
        for (User user : users) {
            System.out.println("User: " + user.getName() + ", Role: " + user.getClass().getSimpleName());
        }
    }

    @Override
    public void performRoleAction() {
        System.out.println(getName() + " is managing system records.");
    }
}

public class Management {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Patient Details
        System.out.print("Enter patient name: ");
        String patientName = scanner.nextLine();
        System.out.print("Enter patient email: ");
        String patientEmail = scanner.nextLine();
        System.out.print("Enter patient phone number: ");
        String patientPhone = scanner.nextLine();
        Patient patient1 = new Patient(patientName, patientEmail, patientPhone);

        // Doctor Details
        System.out.print("Enter doctor name: ");
        String doctorName = scanner.nextLine();
        System.out.print("Enter doctor email: ");
        String doctorEmail = scanner.nextLine();
        System.out.print("Enter doctor phone number: ");
        String doctorPhone = scanner.nextLine();
        System.out.print("Enter doctor specialization: ");
        String doctorSpecialization = scanner.nextLine();
        Doctor doctor1 = new Doctor(doctorName, doctorEmail, doctorPhone, doctorSpecialization);

        // Admin Details
        System.out.print("Enter admin name: ");
        String adminName = scanner.nextLine();
        System.out.print("Enter admin email: ");
        String adminEmail = scanner.nextLine();
        System.out.print("Enter admin phone number: ");
        String adminPhone = scanner.nextLine();
        Admin admin1 = new Admin(adminName, adminEmail, adminPhone);

        boolean exit = false;

        // Menu for user actions
        while (!exit) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Patient Actions");
            System.out.println("2. Doctor Actions");
            System.out.println("3. Admin Actions");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    // Patient Actions
                    System.out.println("Patient Actions:");
                    System.out.println("1. Book Appointment");
                    System.out.println("2. Make Payment");
                    System.out.println("3. View Medical History");

                    int patientAction = scanner.nextInt();
                    scanner.nextLine();  // Consume newline

                    switch (patientAction) {
                        case 1:
                            patient1.bookAppointment(doctor1);
                            break;
                        case 2:
                            System.out.print("Enter amount to make payment: ");
                            double paymentAmount = scanner.nextDouble();
                            patient1.makePayment(paymentAmount);
                            break;
                        case 3:
                            patient1.viewMedicalHistory();
                            break;
                        default:
                            System.out.println("Invalid option for Patient.");
                    }
                    break;

                case 2:
                    // Doctor Actions
                    System.out.println("Doctor Actions:");
                    System.out.println("1. View Appointments");
                    System.out.println("2. Access Patient Records");

                    int doctorAction = scanner.nextInt();
                    scanner.nextLine();  // Consume newline

                    switch (doctorAction) {
                        case 1:
                            doctor1.viewAppointments();
                            break;
                        case 2:
                            doctor1.accessPatientRecords(patient1);
                            break;
                        default:
                            System.out.println("Invalid option for Doctor.");
                    }
                    break;

                case 3:
                    // Admin Actions
                    System.out.println("Admin Actions:");
                    System.out.println("1. Manage Users");
                    System.out.println("2. Generate Report");

                    int adminAction = scanner.nextInt();
                    scanner.nextLine();  // Consume newline

                    switch (adminAction) {
                        case 1:
                            admin1.manageUsers(patient1);
                            admin1.manageUsers(doctor1);
                            break;
                        case 2:
                            admin1.generateReport();
                            break;
                        default:
                            System.out.println("Invalid option for Admin.");
                    }
                    break;

                case 4:
                    // Exit
                    exit = true;
                    System.out.println("Exiting the system.");
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }

        scanner.close(); // Close the scanner to prevent memory leak
    }
}
