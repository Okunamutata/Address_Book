import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class HomePage {

	public static void add(String name, String zipCode, String email, String phoneNumber ,ArrayList<Contact> userContacts)
	{
	System.out.println("test 6 " + name + " " + zipCode + "\n");
	    Contact newCon = new Contact(name, zipCode, email, phoneNumber);
	    userContacts.add(newCon);
	}
	
	public static void delete(String name, ArrayList<Contact> userContacts )
	{
	    for(int i = 0; i < userContacts.size(); i++){
	        if(userContacts.get(i).name.equals(name)){
	        	userContacts.remove(i);
	        }
	        else{
	            System.out.println("Contact not found");
	        }
	    }
	   
	}
	
	public static void set( String name, String zipCode, String email, String phoneNumber , ArrayList<Contact> userContacts)
	{
	    for(Contact e : userContacts)
	    {
	        if(e.name.equals(name)) 
	        {
	            e.setName(name); 
	            e.setZipCode(zipCode);  
	            e.setEmail(email);
	            e.setEmail(email);      
	        }
	        else{
	            System.out.println("Contact not found");
	        }
	    }
	}
	
	public static void get(String name,  ArrayList<Contact> userContacts) // another par arrayList and then get the items inside!!
	{
	System.out.println("test 6 " + name + "\n");
	    for(Contact e : userContacts){
	        if(e.name.equals(name))
	        {
			System.out.println("test 4");				
	        	System.out.println(e.toString());
	        }
	        else
	        {
	            System.out.println("Contact not found");
	        }
	    }
	}
    // WHY WE NEED THEM TO BE STATIC ??
    public static ArrayList<Contact> runAB(ArrayList<Contact> userContacts, String uID){

	File f = new File(uID + ".ser");
	DataBase db = new DataBase();
     	
	String tempStr = null;
     	String name;
	 String zipCode;
	 String email;
	 String phoneNumber;
	 ArrayList<Contact> temp = userContacts; // user contacts that is passed when logged in (the current contact list that the user have)
        Boolean runAgain = true; // keeps looping until LOGOUT
        String in = null;
        Scanner input = new Scanner(System.in);
	System.out.println("*********************\n" + 
				"Welcome to your Address Book\n" +
			   "*********************");
	if(f.exists()){
		temp = db.deserialzeAddress(uID);	
}       

                           
        do{ // LOGED IN loop
            
	        try // we might not need try unless the data base requires it
	        {
	            
	            in = input.nextLine(); // command input
	            String[] comds = in.split(" "); 
	            tempStr = comds[0];
	            switch (tempStr)  			// ADD LIST COMMAND ! List command lists all the entries of the contacts list
	            { 
	                case "ADD": // when need to check if name is exist or not in !!
	                    name =  comds[1]; 
	                    zipCode =  comds[2];
	                    email =  comds[3];
	                    phoneNumber =  comds[4]; 
			    System.out.println("test 2");				
	                    add(name,zipCode,email,phoneNumber, userContacts);
						System.out.println("test 3");				
	                    System.out.println("New contact is Added!");
	                break;
	
	                case "DELETE": 
	                    name =  comds[1];
	                    delete(name, userContacts); 
	                    break;
	                
	                case "GET":
	                    name =  comds[1];
	                    get(name, userContacts);
	                    break;
	                
	                case "SET":
	                    name =  comds[1];
	                    zipCode =  comds[2];
	                    email =  comds[3];
	                    phoneNumber = comds[4];    
	                    set(name,zipCode,email,phoneNumber,userContacts);
			    break;
	                case "LOGOUT":
	                	runAgain = false;
	                    break;
	                default:
	                	if(tempStr == "LOGIN")
	                	{
	                		System.out.println("You are already logged in. If you want to login in a different account please LOGOUT.");
	                	}
	                	System.out.println("Please enter a valid command");
	                    break;
	            }
			db.serializeAddress(uID);
			System.out.println("Do you want to do something else? yes/no\n");
			in = input.nextLine();
			if(in.equalsIgnoreCase("yes")){runAgain = true;}
			else{runAgain = false; break;}
	               // db.serializeAddress(temp, uID);// save to a file under the name of user
	               
	         }            
	         catch (Exception e)
	         {
	                System.out.println("Exception: something is wrong!");
			runAgain = true;
	         }
            
          }while(runAgain == true); // it loops until LOGOUT
        
         return temp; // returns a new contacts list to set the old contact list in the NewAccount object to a new edited contacts list
      
    }
	public static void main(String[] args) 
	{
		
		String tempStr = null;
		String input;
		ArrayList<NewAccount> signedUpAccs = new ArrayList<>(); // the list of accounts
		String iD, pass1, pass2;
		NewAccount newAcc;
		Scanner cScanner = new Scanner(System.in);
		NewAccount temp = null;
	
		do { // The loop (the program) keeps running without termination 
			try
			{
		System.out.println("Welcome to AddressBook\n");	
				
				input = cScanner.nextLine();
				String[] comds = input.split(" ");
				tempStr = comds[0];
				
				switch (tempStr) 
				{
				
					case "NEWUSER":
						iD = comds[1];
						pass1 = comds[2];
						pass2 = comds[3];
	
						if (pass1.equals(pass2) && pass1.length() >= 8 && pass1.length() <= 30 && iD.length() <= 30) 
						{
							newAcc = new NewAccount(iD, pass1); // create a new account
							signedUpAccs.add(newAcc);
							System.out.println("Account is created! ");
							//db.serializeUser_Pass(signedUpAccs);
		
						}
						else
						{
						 System.out.println("Please try again. User input is invalid!");
						 break;
						}
					break;
			 
			 
					case "LOGIN": 
						String password,userID;
						userID = comds[1];
						password = comds[2];
						for(int i = 0 ; i< signedUpAccs.size() ; i++) // This loop loops through list and check if the id match, holds the Acc in temp
						{
							System.out.println("test1");
							
							if(userID == signedUpAccs.get(i).getiD())
								temp = signedUpAccs.get(i);
						}
						for (int i = 0; i < signedUpAccs.size(); i++) // This loop checks if the account info entered is correct or not
						 
						{
							 
								if((temp.getPassword().equals(password) )&& (temp.getiD().equals(userID)) || temp == null)
								{
									
									// I'm not sure if we are setting the contacts in the actual ArrayList signedUpAccounts or we
									// just setting an object we copied from the signedUpAccount
									// if we are not changing the actual object in signedUpAccount list then all the modification below doesn't matter!
									
									temp.setContacts(runAB(temp.getContacts(), temp.getiD())); // if inside here means account is logged in
									System.out.println("You Loged out!");
								}
								else
								{
									System.out.println("Account or Password is wrong! ");
								}
								// runAB should return the new addressBook edited then sets the addressBook object in the user object
						}
				 		break;
					default: 
	
						if(tempStr.equals("ADD") || 
							tempStr.equals("DEL") || 
							 tempStr.equals("GET") ||  
							 tempStr.equals("LIST"))
						{
								System.out.println("Please log in or create a new ID to use the entered command.");
		
						}
						else
						{
							System.out.println("Please enter a valid command.");
						}
						break;
	
				} //switch
			}	// try
			catch (Exception e)
			{
                System.out.println(e);
                break;
            }
	 		
			
		}while(true);
		
		 System.exit(0);
	}

}
