
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Doctor extends Person{

    private int doctorId ;
    private String specialization;
    private ArrayList<Date> availabilities;
    private HashMap<Date, ArrayList<Appointment>> allAppointments = new HashMap<>();  //empty hashmap is created

    public Doctor(int id,String name,String specialization,String contact,String birthday){
        super(name,contact,birthday);
        this.doctorId = id;
        this.specialization =specialization;
        availabilities = new ArrayList<>();

    }

    public Doctor(int doctorId, String name, String contactNumber, String birthday){
        super(name,contactNumber, birthday);
        this.doctorId = doctorId;
        this.specialization = "General Doctor";
        availabilities = new ArrayList<>();
    }

    public void greeting(){
        System.out.println("Hello Doctor +" + this.getName());
    }

    public boolean isPhysician(){

        return (this.specialization.endsWith("physician"));
    }

    public void addAvailability( Date availableDate) {
        
        this.availabilities.add(availableDate);
    }

    public void setAppointment(Appointment appointment, Date date){
        ArrayList<Appointment> currentAppointments = this.allAppointments.get(date);
        if(currentAppointments == null){
            ArrayList<Appointment> tempArrayList = new ArrayList<>();
            tempArrayList.add(appointment);
            this.allAppointments.put(date, tempArrayList);
        }
        else{
            currentAppointments.add(appointment);
            this.allAppointments.put(date, currentAppointments);
        }
    }

    public int getDoctorId() {
        return doctorId;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public ArrayList<Date> getAvailabilities() {
        return availabilities;
    }

    public void setAvailabilities(ArrayList<Date> availabilities) {
        this.availabilities = availabilities;
    }

    public HashMap<Date, ArrayList<Appointment>> getAllAppointments() {
        return allAppointments;
    }

    public void setAllAppointments(HashMap<Date, ArrayList<Appointment>> allAppointments) {
        this.allAppointments = allAppointments;
    }


}
