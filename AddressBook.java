import java.util.ArrayList;
import java.util.Scanner;


public class AddressBook {
    protected ArrayList<Contact> contactList;
    public AddressBook(){
        contactList = new ArrayList<>();
    }

public void add(String name, int zipCode, String email, int phoneNumber ){
    Contact newCon = new Contact(name, zipCode, email, phoneNumber);
    contactList.add(newCon);
}

public void delete(String name){
    for(Contact e : contactList){
        if(e.name == name){
            contactList.remove(e);
        }
        else{
            System.out.println("Contact not found");
        }
    }
   
}
	
public void set( String name, int zipCode, String email, int phoneNumber )
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

public void get(String name)
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
    /*
    *   Method to verify command/ parameter input 
    *
    */
    public static String verInput(String command){
        String temp = null;
        char start ='<', end = '>';

        if(command.charAt(0) == start && command.charAt(command.length()-1) == end){
            for(int i = 0; i < command.length(); i++){
                if(command.charAt(i) != start || command.charAt(i) != end){
                    temp += command.charAt(i);
                }
            }
        }
        else{
            throw new IllegalArgumentException("Invalid command");        
        }
        if(temp.length() > 6){  throw new IllegalArgumentException("Invalid command"); }
        return temp;
    }
    /*
    public static int verNum(int num){
        String temp = null;
        char start ='<', end = '>';
        if(num == start && num.charAt(num.length()-1) == end ){
            for(int i = 0; i < num.length(); i++){
                if(num.charAt(i) != start || num.charAt(i) != end){
                    temp += num.charAt(i);
                }
            }
        }
        else{
            throw new IllegalArgumentException("Invalid command");        
    
        }
        if(temp.length() > 14){  throw new IllegalArgumentException("Invalid command"); }
        return temp;
    }
    */
    

    public AddressBook runAB(AddressBook userBook){
     String name;
	 int zipCode;
	 String email;
	 int phoneNumber;
	 AddressBook temp = userBook;
        Boolean runAgain = true;
        String in = null;
        Scanner input = new Scanner(System.in);// remember to close scanner
        System.out.println("*******************************\n" +
                            "Welcome to your Address Book\n" + 
       
                            "****************************");
        do{
        try {
            System.out.println("PLease input operation in the following format\n" + 
                                " <command>     <parameter>");
            System.out.println("Enter the operation you wish to run\n" + 
                                " <ADD>, <DELETE>, <GET>");
            in = verInput(input.nextLine()); // command input
            switch (in) {
                case "ADD":
                    System.out.println("Enter the following parameter\n" + 
                                    " <name>");
                    name =  verInput(input.nextLine());
                    System.out.println("Enter the following parameter\n" + 
                                    " <zip_code>");
                    zipCode =  (input.nextInt());
                    System.out.println("Enter the following parameter\n" + 
                                    " <email_address>");
                    email =  verInput(input.nextLine());
                    System.out.println("Enter the following parameter\n" + 
                                    " <phone_number>");
                    phoneNumber =  input.nextInt();  
                    Contact newC = new Contact(name,zipCode,email,phoneNumber);
                    temp.contactList.add(newC);
                break;

                case "DELETE":
                    System.out.println("Enter your password to proceed");
                    in = input.nextLine(); //should be passwords entry
                    //verPassword, if true process, else throw mismatch error

                    System.out.println("Enter the foillowing parameter\n" + 
                    "<name>");
                    name =  verInput(input.nextLine());
                    temp.delete(name);
                    break;
                
                case "GET":
                    System.out.println("Enter the foillowing parameter\n" + 
                    "<name>");
                    name =  verInput(input.nextLine());
                    temp.get(name);
                    break;
                
                case "SET":
                     System.out.println("Enter your password to proceed");
                    in = input.nextLine(); //should be passwrds entry
                      //verPassword, if true process, else throw mismatch error

                    System.out.println("Enter the following parameter\n" + 
                                    " <name>");
                    name =  verInput(input.nextLine());
                    System.out.println("Enter the following parameter\n" + 
                                    " <zip_code>");
                    zipCode =  input.nextInt();
                    System.out.println("Enter the following parameter\n" + 
                                    " <email_address>");
                    email =  verInput(input.nextLine());  
                    System.out.println("Enter the following parameter\n" + 
                                    " <phone_number>");
                    phoneNumber =  input.nextInt();     
                    temp.set(name,zipCode,email,phoneNumber);

                default:
                    break;
                }
                System.out.println("Do you want to do something else?, Enter yes or no.");
                in = input.nextLine();
                if(in.equalsIgnoreCase("yes")){runAgain = true; break;}
                else{ runAgain = false; break;}
            }            
            catch (Exception e) {
                System.out.println("Incorrect input.");
                break;
            }
          }while(runAgain == true);
          input.close();
         return temp;
            

    }
}
