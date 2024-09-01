
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static ArrayList<Doctor> allDoctors = new ArrayList<>();

    public static void hospitalAdministratorMenu() {
        boolean runAdmin = true;
        while (runAdmin) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Press 1 to add a doctor,press 2 to add a doctor availability,and press 3 to exit");
            int userObjective = scanner.nextInt();

            if (userObjective == 1) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter the name:");
                String name = sc.nextLine();
                System.out.println("Enter the birthday:");
                String birthday = sc.nextLine();
                System.out.println("Enter the specialization:");
                String specialization = sc.nextLine();
                System.out.println("Enter the contact number:");
                String contact = sc.nextLine();

                Random random = new Random();
                Doctor newDoctor = new Doctor(random.nextInt(), name,birthday,specialization,contact);
                allDoctors.add(newDoctor);

            } else if (userObjective == 2) {
                System.out.println("added doctor availability");
            } else if (userObjective == 3) {
                runAdmin = false;
            } else {
                System.out.println("Invalid input");
            }
        }
    }

    public static void patientMenu(){

        boolean runPatient = true;
        while (runPatient) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Press 1 to view doctors,press 2 to book an appointment, press 3 to view a selected doctor's bookings,press 4 to register patient and press 5 to exit");
            int userObjective = scanner.nextInt();

            if (userObjective == 1) {
                for(Doctor doctor : allDoctors){
                    System.out.println(doctor.name +": " + doctor.specialization);
                }
            } else if (userObjective == 2) {
                System.out.println("booked an appointment");
            } else if (userObjective == 3) {
                System.out.println("selected doctor's bookings");
            } else if (userObjective == 4) {
                System.out.println("register patient");
            } else if (userObjective == 5) {
                runPatient = false;
            } else {
                System.out.println("Invalid input");
            }
        }
    }

    public static void run() {

        boolean runMenu = true;
        while (runMenu) {
            System.out.println("If you are a hospital administrator please press 1,If you are a patient please press 2,Press 3 to exit");
            Scanner scanner = new Scanner(System.in);
            int userInput = scanner.nextInt();

            if (userInput == 1) {
                hospitalAdministratorMenu();
            } else if (userInput == 2) {
                patientMenu();
            } else if (userInput == 3) {
                runMenu = false;
                System.out.println("finished");
            } else {
                System.out.println("Invalid input");
            }
        }
    }

    public static void main(String[] args) {

        run();
        // Sample Doctor objects
        //Doctor doctor1 = new Doctor(101, "John Smith", "1970-01-01", "Neuro-physician", "123-456-7890");
        //Doctor doctor2 = new Doctor(102, "Jane Doe", "1980-02-02", "Cardiologist", "987-654-3210");

        // Test doctor methods
        //System.out.println("Doctor 1:");
        //System.out.println("Is Physician?: " + doctor1.isPhysician());

        //System.out.println("\nDoctor 2:");
        //System.out.println("Is Physician: " + doctor2.isPhysician());

        // Sample Patient objects
        //Patient patient1 = new Patient("T-1234", "Alice Johnson", "2000-03-03", "555-123-4567");
        //Patient patient2 = new Patient("D-5678", "Bob Williams", "1990-04-04", "888-789-0123");

        // Test patient methods
        //System.out.println("\nPatient 1:");
        //System.out.println("Patient Type: " + patient1.getPatientType());

        //System.out.println("\nPatient 2:");
        //System.out.println("Patient Type: " + patient2.getPatientType());

    }
}