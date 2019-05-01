import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class HomePage {
	public static void main(String[] args) {
		String tempStr = null;
		boolean loggedIn;
		String input;
		ArrayList<NewAccount> signedUpAccs = new ArrayList<>(); // the list of accounts
		String iD, pass1, pass2;
		NewAccount newAcc;
		AddressBook newAddress;
		Scanner cScanner = new Scanner(System.in);
		DataBase db = new DataBase();
		do {
			try{
			System.out.println("*******************************\n" + "Welcome to the Address Book\n" +

					"*******************************");

			System.out.println("If you want to sign up enter (1)\n" + "If you want to log in enter (2)\n");
			input = cScanner.next();
			//in = input.next(); // command input
			String[] comds = input.split("\\s");
			tempStr = comds[0];
			
			switch (tempStr) {
			// REVISE TO REFLECT SPECIFICATIONS IN A SINGLE LINE WHEN CREATING NEW ACCOUNT
			
			case "NEWUSER":
			
				//System.out.println("Please enter your new iD:");
				iD = comds[1];
				//System.out.println("Please enter your new password: (Has to be more than 8 characters)");
				pass1 = comds[2];
				//System.out.println("Please confirm your new password: ");
				pass2 = comds[3];

				if (pass1.equals(pass2) && pass1.length() >= 8 && pass1.length() <= 30 && iD.length() <= 30) {
					newAcc = new NewAccount(iD, pass1); // create a new account
					signedUpAccs.add(newAcc);
					System.out.println("Account is created! ");
					db.serializeUser_Pass(signedUpAccs);

			 }
			 else
			 {
				 System.out.println("Please try again. User input is invalid!");
				 break;
			 }
		 break;
		 
		 
		 case "LOGIN": 
			// This a log In page
			 // ask for their id & pass and then look up the accounts in data base if existed 
			 // check if user existed 
			 // every user have only access to their addrdess book which they can edit delete add 
			 // here call the addressBook class with their unique id
			 String password,userID;
			
			 //System.out.println("Please enter your iD \n");
			 userID = comds[1];
			 //System.out.println("Please enter your password \n");
			 password = comds[2];
			
			
				NewAccount temp = db.deserialzeUser_Pass(signedUpAccs, userID);
				
			
			loggedIn = true;
			 
			
				 for (int i = 0; i < signedUpAccs.size(); i++)
				 
				{
					 
						if((temp.getPassword().equals(password) )&& (temp.getiD().equals(userID)) )
						{
							
							
							temp.setContacts(runAB(temp.getContacts(), temp.getiD()));
							
						}
						else
						{
							System.out.println("Account not found! ");
						}
						// runAB should return the new addressBook edited then sets the addressBook object in the user object
				}
			 			break;
		 default: 

				if(tempStr.equalsIgnoreCase("ADD") || 
					tempStr.equalsIgnoreCase("DEL") || 
					 tempStr.equalsIgnoreCase("GET") ||  
					 tempStr.equalsIgnoreCase("LIST"))
				{
						System.out.println("Please log in or create a new ID to use the entered command.");

				}
				else
				{
					System.out.println("Please enter a valid command.");
				}
			break;

			}
			catch (Exception e)
			 	{
                System.out.println("incorrect input");
                //runAgian = true;
                break;
            	}
	 		}
		 }while(is);
		 System.exit(0);
	}

}