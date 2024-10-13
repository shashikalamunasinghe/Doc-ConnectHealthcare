
import java.util.ArrayList;
import java.util.Date;

public class Doctor {

    public int doctorId ;
    public String name;
    public String birthday;
    public String specialization;
    public String contactNo;
    public ArrayList<Date> availabilities;

    public Doctor(int id,String name,String birthday,String specialization,String contact){
        this.name = name;
        this.doctorId = id;
        this.birthday = birthday;
        this.specialization =specialization;
        this.contactNo = contact;
    }

    public boolean isPhysician(){

        return (this.specialization.endsWith("physician"));
    }

    public void addAvailability( Date availableDate) {
        
        availabilities.add(availableDate);
        
    }

}
