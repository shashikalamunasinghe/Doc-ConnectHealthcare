public class Patient {

    public String pId ;
    public String name;
    public String birthday;
    public String contactNo;

    public Patient(String id,String name,String birthday,String contact){
        this.name = name;
        this.pId = id;
        this.birthday = birthday;
        this.contactNo = contact;
    }

    public char getPatientType(){

        char patientType = this.pId.charAt(0);
        return patientType;
    }
}
