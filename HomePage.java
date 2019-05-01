import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class HomePage {
	public static void main(String[] args) {
		boolean loggedIn;
		int input;
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
			input = cScanner.nextInt();
			switch (input) {
			// REVISE TO REFLECT SPECIFICATIONS IN A SINGLE LINE WHEN CREATING NEW ACCOUNT
			case 1:
				System.out.println("Please enter your new iD:");
				iD = cScanner.next();
				System.out.println("Please enter your new password: (Has to be more than 8 characters)");
				pass1 = cScanner.next();
				System.out.println("Please confirm your new password: ");
				pass2 = cScanner.next();

				if (pass1.equals(pass2) && pass1.length() >= 8 && pass1.length() <= 30 && iD.length() <= 30) {
					newAcc = new NewAccount(iD, pass1); // create a new account
					signedUpAccs.add(newAcc);
					System.out.println("Account is created! ");
					db.serializeUser_Pass(signedUpAccs);

			 }
			 else
			 {
				 System.out.println("Please try again. User input is invalid!");
			 }
		 break;
		 
		 
		 case 2: 
			// This a log In page
			 // ask for their id & pass and then look up the accounts in data base if existed 
			 // check if user existed 
			 // every user have only access to their addrdess book which they can edit delete add 
			 // here call the addressBook class with their unique id
			 String password,userID;
			 System.out.println("*******************************\n" +
          						"LOG IN PAGE\n" + 

          						"*******************************");
			 
			 System.out.println("Please enter your iD \n");
			 userID = cScanner.next();
			 System.out.println("Please enter your password \n");
			 password = cScanner.next();

			 for(int i =0; i < signedUpAccs.size(); i++){
				NewAccount temp = (NewAccount) signedUpAccs.get(i);
				if(temp.iD == userID){
					db.deserialzeUser_Pass(signedUpAccs, userID);
				}
			}
			loggedIn = true;
			 
			
				 for (int i = 0; i < signedUpAccs.size(); i++)
				 
				{
					 
						if((signedUpAccs.get(i).getPassword().equals(password) )&& (signedUpAccs.get(i).getiD().equals(userID)) )
						{
							
							
							signedUpAccs.get(i).setContacts(signedUpAccs.get(i).getContacts().runAB(signedUpAccs.get(i).getContacts(), signedUpAccs.get(i).getiD()));
							
						}
						else
						{
							System.out.println("Account not found! ");
						}
						// runAB should return the new addressBook edited then sets the addressBook object in the user object
				}
			 
			 
		 break;
		 default: 
		 	break;

			}
			}catch (Exception e) {
                System.out.println("incorrect input");
                //runAgian = true;
                break;
            }
		 
		 }while(input >= 1 && input <= 2);
		 System.exit(0);
	}

}