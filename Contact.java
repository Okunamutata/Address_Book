public class Contact{

    //fields
    private String name;
    private int zipCode;
    private String email;
    private int phoneNumber;

    public Contact(String name, int zipcode, String email, int phoneNumber) {
        this.name = name;
        this.zipCode = zipcode;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getName(){
        return name;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String newEmail){
        this.email = newEmail;
    }


    public int getZip(){
        return zipCode;
    }

    public void setZip(int newZip){
        this.zipCode = newZip;
    }


    public int getPhone(){
        return phoneNumber;
    }

    public void setPhone(int newPhone){
        this.phoneNumber = newPhone;
    }

    public static void main (String[] args){

    }
}