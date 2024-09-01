public class Doctor {
    public int dId ;
    public String name;
    public String birthday;
    public String specialization;
    public String contactNo;

    public Doctor(int id,String name,String birthday,String specialization,String contact){
        this.name = name;
        this.dId = id;
        this.birthday = birthday;
        this.specialization =specialization;
        this.contactNo = contact;
    }

    public boolean isPhysician(){

        return (this.specialization.endsWith("physician"));
    }

}
