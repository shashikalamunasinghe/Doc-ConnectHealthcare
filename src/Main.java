import java.util.Scanner;

public class Main {

    public static void hospitalAdministratorMenu() {

        boolean runAdmin = true;
        while (runAdmin) {
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.println("Press 1 to add a doctor,press 2 to add a doctor availability,and press 3 to exit");
                int userObjective = scanner.nextInt();

                if (userObjective == 1) {
                    //add the doctor in to the ArrayList
                    Controller.addDoctors();
                    System.out.println("Doctor is added successfully");

                } else if (userObjective == 2) {
                    //add doctor availability
                    Controller.addAvailabilityForDoctors();
                    System.out.println("Doctor availability is added successfully");

                } else if (userObjective == 3) {
                    runAdmin = false;
                } else {
                    System.out.println("Invalid input");
                }
            }
        }
    }

    public static void patientMenu() {

        boolean runPatient = true;
        while (runPatient) {
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.println("Press 1 to view doctors, press 2 to book an appointment, press 3 to view a selected doctor's bookings, press 4 to add a patient, and press 5 to exit");
                int userObjective = scanner.nextInt();

                if (userObjective == 1) {
                    //view all doctors
                    Controller.viewDoctors();
                } else if (userObjective == 2) {
                    Controller.bookAppointment();
                    System.out.println("Booked an appointment");
                } else if (userObjective == 3) {
                    System.out.println("Selected doctor's bookings");
                } else if (userObjective == 4) {
                    //register patient
                    Controller.addPatient();
                    System.out.println("patient is registered successfully");
                } else if (userObjective == 5) {
                    runPatient = false;
                } else {
                    System.out.println("Invalid input");
                }
            }
        }
    }

    public static void run() {
        boolean runMenu = true;
        while (runMenu) {
            System.out.println("If you are a hospital administrator please press 1, if you are a patient please press 2, press 3 to exit");
            try (Scanner scanner = new Scanner(System.in)) {
                int userInput = scanner.nextInt();

                if (userInput == 1) {
                    hospitalAdministratorMenu();
                } else if (userInput == 2) {
                    patientMenu();
                } else if (userInput == 3) {
                    runMenu = false;
                    System.out.println("Finished");
                } else {
                    System.out.println("Invalid input");
                }
            }
        }
    }

    public static void main(String[] args) {

        Doctor sampleDoc = new Doctor(223,"Saman Kumara","22.05.1987","Gynocologist","077-333-9900");
        Patient samplePatient = new Patient("T-12", "Alice Johnson","2012-10-15" , "555-123-4567");
        Controller.allDoctors.add(sampleDoc);
        Controller.allPatients.add(samplePatient);
        run();
        // Sample Doctor objects
        // Doctor doctor1 = new Doctor(101, "John Smith", "1970-01-01", "Neuro-physician", "123-456-7890");
        // Doctor doctor2 = new Doctor(102, "Jane Doe", "1980-02-02", "Cardiologist", "987-654-3210");

        // Test doctor methods
        // System.out.println("Doctor 1:");
        // System.out.println("Is Physician?: " + doctor1.isPhysician());

        // System.out.println("\nDoctor 2:");
        // System.out.println("Is Physician: " + doctor2.isPhysician());

        // Sample Patient objects
        // Patient patient1 = new Patient("T-1234", "Alice Johnson", "2000-03-03", "555-123-4567");
        // Patient patient2 = new Patient("D-5678", "Bob Williams", "1990-04-04", "888-789-0123");

        // Test patient methods
        // System.out.println("\nPatient 1:");
        // System.out.println("Patient Type: " + patient1.getPatientType());

        // System.out.println("\nPatient 2:");
        // System.out.println("Patient Type: " + patient2.getPatientType());
    }
}
