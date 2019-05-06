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
    public void serializeAddress(AddressBook ab, String user) {
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
             int size = ab.contactList.size();

			fout = new FileOutputStream(f);
            oos = new ObjectOutputStream(fout);
            //write the nuber of obejects being saved
            oos.writeObject(size);
            //save all of the contacts
            for(int i = 0; i < size; i++){
                oos.writeObject(ab.contactList.get(i));
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

    public ArrayList<Contact> deserialzeUser_Pass(String username) {
        FileInputStream  fout = null;
		ObjectInputStream ois = null;
		NewAccount user = null;
        File uf = new File(username +"Acc.ser");

		try{ 
            
            fout = new FileInputStream(uf);
            ois = new ObjectInputStream(fout);
        
            user = (NewAccount) ois.readObject();
            System.out.println(user.toString());
            System.out.println("USER IS LOGGED IN");
			ois.close();
       

        }catch (FileNotFoundException ex) {
          
            System.out.println("User Account not found!");
        }catch (IOException ex) {
          
            System.out.println("Object being passed in is not a file!");
        }
         catch (Exception ex) {
          
            System.out.println("Something went wrong!");

        }
        if (fout != null) {
            try {
                fout.close();
            } catch (IOException e) {
                //e.printStackTrace();
                System.out.println("Something went wrong!");
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
		return user;
	}
    


	public ArrayList <Contact> deserialzeAddress(String user) {
        String filename = user;
		ArrayList<Contact> contacts = new AddressBook();;

		FileInputStream fout = null;
		ObjectInputStream ois = null;

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
              

			fout = new FileInputStream(f);
            ois = new ObjectInputStream(fout);
            int size = (int) ois.readObject();
        
            while(ois.readObject() != null){
                for(int i = 0; i < size; i++){
                    Contact temp = (Contact) ois.readObject();
    
                    contacts.add(temp.name, temp.zipCode, temp.email, temp.phoneNumber);
                }
                
            }
            if (fout != null) {
				try {
					fout.close();
				} catch (IOException e) {
                    e.printStackTrace();
                    //System.out.println("Something went wrong!");

				}
			}
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
