public class Patient extends Person {

    private String patientId ;

    public Patient(String id,String name,String contact,String birthday){
        super(name,contact,birthday);
        this.patientId = id;
    }

    public String getPatientId() {
        return this.patientId;
    }

    public void greeting(){
        getName();
        System.out.println("Hello +" + this.getName());
    }

    @Override
    public String getName(){
        System.out.println("Returning Name");
        System.out.println(this.getName());
        return this.getName();
    }

    public char getPatientType(){

        char patientType = this.patientId.charAt(0);
        return patientType;
    }

}
