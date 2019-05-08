import java.io.Serializable;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.*;
public class DataBase implements java.io.Serializable {
    private static final long serialversionUID = 
                                 129348938L; 

    public void serializeAddress(ArrayList<Contact> userContacts , String user) {
        String filename = user;
		FileOutputStream fout = null;
		ObjectOutputStream oos = null;

		try {
            File f = new File(filename + ".ser");
            boolean ifOpen = f.createNewFile(); 
            if(ifOpen == false){
                System.out.println("Storage file opened");
            }
            else{
                System.out.println("New Storgae file created");
            }

            //nuber of contacts
             int size = userContacts.size();

			fout = new FileOutputStream(f);
            oos = new ObjectOutputStream(fout);
            //write the nuber of obejects being saved
            oos.writeObject(size);
            //save all of the contacts
            for(int i = 0; i < size; i++){
                oos.writeObject(userContacts.get(i));
            }
            
			System.out.println("Updated Contacts");
            
		} catch (IOException e){
            System.out.println("Storage file not found or created"); 
        }catch (Exception ex) {

            //ex.printStackTrace();
            System.out.println("Something went wrong!");

       
        } finally {

			if (fout != null) {
				try {
					fout.close();
				} catch (IOException e) {
                    //e.printStackTrace();
                    System.out.println("Something went wrong!");
				}
			}

			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
                    //e.printStackTrace();
                    System.out.println("Something went wrong!");
				}
			}

		}
    }
    public void serializeUsers(ArrayList signedUp) {
        File uf = new File( "USER.ser");
        FileOutputStream fout = null;
        ObjectOutputStream oos = null;
		try{ 
            boolean ifOpen = uf.createNewFile(); 
            if(ifOpen == false){
                System.out.println(" Admin Storage file opened");
            }
            else{
                System.out.println("New Admin Storgae file created");
            }
            fout = new FileOutputStream(uf);
            oos = new ObjectOutputStream(fout);
            oos.writeObject(signedUp.size());
            for(int i = 0; i < signedUp.size(); i++){
                oos.writeObject(signedUp.get(i));
            }
           
            
			System.out.println("Saved all users acc info");
            oos.close();
            fout.close();
		} catch (Exception ex) {
            //ex.printStackTrace();
            System.out.println("Something went wrong");
        }

    }
    public ArrayList<NewAccount> deserialzeUsers() {

		ArrayList<NewAccount>  users = new ArrayList<>();
        File uf = new File("USER.ser");
       
		try{ 
            //uf.createNewFile();
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(uf)); 
                int numAccs = (int) ois.readObject();
                for(int i = 0; i < numAccs; i ++){
                    NewAccount tempACC = (NewAccount) ois.readObject();
                    users.add(tempACC);
                    
                }
                System.out.println("Active accounts opened");
                
                ois.close();
 
			
		} catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Something is wrong!");

        }
        
		return users;
	}
    

	public void serializeUser_Pass(NewAccount user) {
        File uf = new File( user.iD + "Acc.ser");
        FileOutputStream fout = null;
        ObjectOutputStream oos = null;
		try{ 
            boolean ifOpen = uf.createNewFile(); 
            if(ifOpen == false){
                System.out.println("Storage file opened");
            }
            else{
                System.out.println("New Storgae file created");
            }
            fout = new FileOutputStream(uf);
            oos = new ObjectOutputStream(fout);
             oos.writeObject(user);
            
			System.out.println("Saved user account");
            oos.close();
            fout.close();
		} catch (Exception ex) {
            //ex.printStackTrace();
            System.out.println("Something went wrong");
        }

    }
    public NewAccount deserialzeUser_Pass(ArrayList userList, String username) {

		NewAccount user = null;
        File uf = new File(username + "Acc.ser");

		try{ 
            //uf.createNewFile();
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(uf)); 
                while(ois != null){
                    userList.add((NewAccount) ois.readObject());
                }
                for(int i =0; i < userList.size(); i++){
                    NewAccount temp = (NewAccount) userList.get(i);
                    if(temp.iD == username){ 
                        return temp;
                    }
                }
                ois.close();
			
		} catch (Exception ex) {
            //ex.printStackTrace();
            System.out.println("Something went wrong!");

		}
		return user;
	}

   
    


	public ArrayList<Contact>  deserialzeAddress(String user) {
        String filename = user;
		ArrayList<Contact> contacts = new ArrayList<Contact>();

		FileInputStream fout = null;
		ObjectInputStream ois = null;
        int size = 0;
		try {
            File f = new File(filename + ".ser");
            boolean ifOpen = f.createNewFile(); 
            if(ifOpen == false){
                System.out.println("Storage file opened");
            }
            else{
                System.out.println("New Storgae file created");
            }

            if(f.exists()){
              

            //fout = new FileInputStream(f);
            try{
                ois = new ObjectInputStream(new FileInputStream(f));
                size = (int)ois.readObject();
            } catch(EOFException e){
            }
            
            
        
            for(int i = 0; i < size; i++){
                //for(int j = 0; j < size; i++){
                    Contact temp = (Contact) ois.readObject();
    
                    contacts.add(temp);
                //}
                
            }
            //ois.close();
            
        }else{ System.out.println("No Records found");} 
			
		} catch (Exception ex) {
            ex.printStackTrace();
            //System.out.println("Something went wrong!");

		} finally {

			if (fout != null) {
				try {
					fout.close();
				} catch (IOException e) {
                    e.printStackTrace();
                    //System.out.println("Something went wrong!");

				}
			}

			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
                    //e.printStackTrace();
                    System.out.println("Something went wrong!");

				}
			}
		}
		return contacts;
	}

    
}
