
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Doctor {

    public int doctorId ;
    public String name;
    public String birthday;
    public String specialization;
    public String contactNo;
    public ArrayList<Date> availabilities;
    public HashMap<Date, ArrayList<Appointment>> allAppointments = new HashMap<>();  //empty hashmap is created

    public Doctor(int id,String name,String birthday,String specialization,String contact){
        this.name = name;
        this.doctorId = id;
        this.birthday = birthday;
        this.specialization =specialization;
        this.contactNo = contact;
        availabilities = new ArrayList<>();

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
        currentAppointments.add(appointment);
        this.allAppointments.put(date, currentAppointments);
    }

}
