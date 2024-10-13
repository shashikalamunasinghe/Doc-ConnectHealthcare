public class Patient {

    public String patientId ;
    public String name;
    public String birthday;
    public String contactNo;

    public Patient(String id,String name,String birthday,String contact){
        this.name = name;
        this.patientId = id;
        this.birthday = birthday;
        this.contactNo = contact;
    }

    public char getPatientType(){

        char patientType = this.patientId.charAt(0);
        return patientType;
    }
}
