import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


	public class AddressBook implements java.io.Serializable{
        private static final long serialversionUID = 
                                 129348938L; 
	    protected ArrayList<Contact> contactList;
	    public AddressBook(){
            contactList = new ArrayList<>();
         
	
	    }
	
	public void add(String name, String zipCode, String email, String phoneNumber ){
	    Contact newCon = new Contact(name, zipCode, email, phoneNumber);
	    contactList.add(newCon);
	}
	
	public  void delete(String name ){
	    for(Contact e : contactList){
	        if(e.name == name){
	            contactList.remove(e);
	        }
	        else{
	            System.out.println("Contact not found");
	        }
	    }
	   
	}
	
	public void set( String name, String zipCode, String email, String phoneNumber )
	{
	    for(Contact e : contactList)
	    {
	        if(e.name == name){
	           e.name  = name;
	            e.zipCode  = zipCode;
	            e.email  = email;
	            e.phoneNumber = phoneNumber;           //contactList.remove(e);
	        }
	        else{
	            System.out.println("Contact not found");
	        }
	    }
	}
	
	public Contact get(String name) // another par arrayList and then get the items inside!!
	{
	    for(Contact e : contactList){
	        if(e.name == name)
	        {
	           return e;           //contactList.remove(e);
	        }
	        else{
	            System.out.println("Contact not found");
	        }
	    }
        return null;
	}
    
    public AddressBook runAB(AddressBook userBook, String uID){
    File userData = new File(uID + ".ser");
     DataBase db = new DataBase();
     String tempStr = null;
     String name;
	 String zipCode;
	 String email;
	 String phoneNumber;
	 AddressBook temp = userBook;
        Boolean runAgian = true;
        String in = null;
        Scanner input = new Scanner(System.in);// remember to close scanner
    
    
    do{
        try {
            in = input.nextLine(); // command input
            String[] comds = in.split(" ");
            tempStr = comds[0];
            switch (tempStr) {
                case "ADD": 
                System.out.println(comds[0] + comds[1] + comds[2]);
                    name =  comds[1]; //name
                    zipCode =  comds[2];//zipcode
                    email =  comds[3];//email
                    phoneNumber =  comds[4];  //phone

                    Contact newC = new Contact(name,zipCode,email,phoneNumber);
                    temp.contactList.add(newC);
                break;

                case "DELETE":
                    name =  comds[1];
                    temp.delete(name);
                    break;
                
                case "GET":
                temp = db.deserialzeAddress(uID);
                    Contact tempC = null;
                    name =  comds[1];
                    for(int i =0; i <  temp.contactList.size(); i++){
                        if(temp.contactList.get(i).name == name){
                             tempC = userBook.contactList.get(i);
                        }
                    }
                    
                    System.out.println(tempC.name  +
                                        tempC.zipCode +
                                        tempC.email  +
                                        tempC.phoneNumber);
                    
                    break;
                
                case "SET":
                    name =  comds[1];
                    zipCode =  comds[2];
                    email =  comds[3];
                    phoneNumber = comds[4];    
                    temp.set(name,zipCode,email,phoneNumber);
                case "LOGOUT":
                    break;
                default:
                    System.out.println("Please enter a valid command.");
                    break;
                }
                db.serializeAddress(temp, uID);// save to a file under the name of user
                
                
            
            }            
            catch (Exception e) {
                System.out.println("incorrect input");
                runAgian = true;
            }   
          input.close();
         return temp;
        }while(runAgian == true);      

    }
}