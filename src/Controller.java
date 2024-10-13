import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Date;

public class Controller {

    public static ArrayList<Doctor> allDoctors = new ArrayList<>();
    public static ArrayList<Patient> allPatients = new ArrayList<>();

    static Scanner scanner = new Scanner(System.in);
    public static void addDoctors(){

        System.out.println("Enter the name:");
        String name = scanner.nextLine();
        System.out.println("Enter the birthday:");
        String birthday = scanner.nextLine();
        System.out.println("Enter the specialization:");
        String specialization = scanner.nextLine();
        System.out.println("Enter the contact number:");
        String contact = scanner.nextLine();

        Random random = new Random();
        Doctor newDoctor = new Doctor(random.nextInt(), name,birthday,specialization,contact);
        allDoctors.add(newDoctor);
    }

    public static void addAvailabilityForDoctors(){

        System.out.println("Enter the doctor id you want to add availability");
        int selectedDocId = scanner.nextInt();

        //fetch the doctor from the allDoctors ArrayList
        Doctor selectedDoctor = null;

        for (Doctor doc : allDoctors) {
            if(doc.doctorId == selectedDocId) {
                selectedDoctor = doc;
            }
        }
        //need to check wether the doctor is existing or not
        if(selectedDoctor == null) {
            System.out.println("no doctor found");
            return;
        }
        //if the doctor is existing,take the date
        System.out.println("Enter the year:");
        int year = scanner.nextInt();
        System.out.println("Enter the month:");
        int month = scanner.nextInt();
        System.out.println("Enter the day:");
        int day = scanner.nextInt();
        Date bookDate = new Date(year, month, day);
                    
        //add the availability for the doctor
        selectedDoctor.addAvailability(bookDate);
                   
    }
    
    public static void viewDoctors() {

        for (Doctor doctor : allDoctors) {
            System.out.println(doctor.name + ": " + doctor.specialization);
        }
    }

    public static void registerPatient() {

        System.out.println("Enter the name:");
        String name = scanner.nextLine();
        System.out.println("Enter the birth date:");
        String birthday = scanner.nextLine();
        System.out.println("Enter the patient's ID number:");
        String id = scanner.nextLine();
        System.out.println("Enter the contact number:");
        String contact = scanner.nextLine();

        //create a patient object and store patient in the ArrayList
        Patient newPatient = new Patient(id, name, birthday, contact);
        allPatients.add(newPatient);
        System.out.println(allPatients.toString());
    }

}
