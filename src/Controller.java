import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Date;
import java.util.Map;

public class Controller {

    public static ArrayList<Doctor> allDoctors = new ArrayList<>();
    public static ArrayList<Patient> allPatients = new ArrayList<>();
    public static int NUMBER_OF_SLOTS = 5;

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
            if(doc.getDoctorId() == selectedDocId) {
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
            System.out.println(doctor.name + ": " + doctor.getSpecialization());
        }
    }

    public static void addPatient() {

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

    public static void bookAppointment() {
        
        System.out.println("Enter Doctor's Id you want to make an appointment: ");
        int docId = scanner.nextInt();
        System.out.println("Enter you patient's Id: ");
        String patientId = scanner.next();

        System.out.println("Enter the Day you want to add Appointment: ");
        String day = scanner.next();
        System.out.println("Enter the Month you want to add Appointment: ");
        String month = scanner.next();
        System.out.println("Enter the Year you want to add Appointment: ");
        String year = scanner.next();

        //get the patient and docter
        Patient selectedPatient = getPatientById(patientId);
        Doctor selectedDoc = getDoctorById(docId);

        if(selectedDoc == null || selectedPatient == null ){
            System.out.println("Invalid doctor or patient id");
            return;
        }

        //get appointment date
        Date appointmentDate = new Date(Integer.parseInt(year),Integer.parseInt(month),Integer.parseInt(day));

        //check the availability
        Boolean isAvailable = checkAvailability(selectedDoc,appointmentDate);
        if(isAvailable){
            //calculate appointment Time with available slots
            String appTime = getTimeForBooking(selectedDoc,appointmentDate);
            if(appTime!=null){
                //make the appointment
                Appointment appointment = new Appointment(selectedDoc, selectedPatient,"no notes", appointmentDate, appTime);
                //add it to allAppointments 
                selectedDoc.setAppointment(appointment, appointmentDate);
                System.out.println(selectedDoc.getAllAppointments().toString());
            }
            else{
                System.out.println("All the slots are filled");
            }
            
        }
        else{
            System.out.println("Doctor is not available on the selected Date");
        }
        
    }

    private static String getTimeForBooking(Doctor selectedDoctor, Date dateOfBooking){
        for(Map.Entry<Date,ArrayList<Appointment>> appointment : selectedDoctor.getAllAppointments().entrySet()){
            if(appointment.getKey().equals(dateOfBooking)){
                int numberOfSlots = appointment.getValue().size(); 
                if(numberOfSlots > NUMBER_OF_SLOTS-1){
                    return null;
                }
                System.out.println("We can make a booking");
                int time = 17 + appointment.getValue().size();
                String strTime = time + " : 00";
                return strTime;
            }
        }
        return "17:00";
    }


    private static Boolean checkAvailability(Doctor selecteDoctor, Date dayOfBooking){
        for (Date availableDate : selecteDoctor.getAvailabilities()) {
            if(availableDate.equals(dayOfBooking)){
                return true;
            }
        }
        return false;
    }
    
    public static Patient getPatientById(String id){
        for(Patient patient : allPatients){
            if(patient.getPatientId().equals(id)){
                    return patient;
            }
        }
        System.out.println("No Patient Found");
        return null;
    }

    public static Doctor getDoctorById(int id){
        for(Doctor doctor : allDoctors){
            if(doctor.getDoctorId() == id){
                return doctor;
            }
        }
        System.out.println("No doctor Found");
        return null;
    }
        
}


