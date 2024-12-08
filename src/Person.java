
public abstract class Person {

    public String name;
    private String contactNumber;
    private String birthday;

    public Person(String name, String contactNumber, String bod) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.birthday = bod;
    }

    public abstract void greeting();
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

}

