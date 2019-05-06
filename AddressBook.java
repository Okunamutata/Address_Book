import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


	public class AddressBook {
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
	
	public void get(String name) // another par arrayList and then get the items inside!!
	{
	    for(Contact e : contactList){
	        if(e.name == name)
	        {
	            System.out.println("Contact name: " + e.name + "\n"+
	                                "Zip Code: " + e.zipCode + "\n"+ 
	                                "Email: "   + e.email + "\n"+
	                                "Phone Number: " + e.phoneNumber);           //contactList.remove(e);
	        }
	        else{
	            System.out.println("Contact not found");
	        }
	    }
	}
    
    public AddressBook runAB(AddressBook userBook, String uID){
    File f = new File(uID + ".ser");
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
        System.out.println("*******************************\n" +
                            "Welcome to your Address Book\n" + 
       
                            "****************************");
                            if(f.exists()){
                                temp = db.deserialzeAddress(uID);
                            }
        do{
            
        try {
            System.out.println("PLease input operation in the following format\n" + 
                                " command    parameter");
            System.out.println("Enter the operation you wish to run\n" + 
                                " ADD, DELETE, GET");
            in = input.next(); // command input
            String[] comds = in.split("\\s");
            tempStr = comds[0];
            switch (tempStr) {
                case "ADD": 
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
                    name =  comds[1];
                    temp.get(name);
                    break;
                
                case "SET":
                    name =  comds[1];
                    zipCode =  comds[2];
                    email =  comds[3];
                    phoneNumber = comds[4];    
                    temp.set(name,zipCode,email,phoneNumber);
	            break;
                case "LOGOUT":
                    
                default:
                    break;
                }
                db.serializeAddress(temp, uID);// save to a file under the name of user
                System.out.println("Do you want to do something else?, enter yes or no");
                in = input.nextLine();
                if(in.equalsIgnoreCase("yes")){runAgian = true;}
                else{ runAgian = false; break;}
            }            
            catch (Exception e) {
                System.out.println("incorrect input");
                runAgian = true;
                break;
            }
            
          }while(runAgian == true);
          input.close();
         return temp;
            

    }
}
