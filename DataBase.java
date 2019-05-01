import java.io.Serializable;
import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DataBase {
 

    public void serializeAddress(AddressBook contacts, String uId) {
        String filename = uId;
		FileOutputStream fout = null;
		ObjectOutputStream oos = null;

		try {
            File f = new File(filename + ".ser");
            if(!f.exists()){
                f.createNewFile();
              }else{
                
              

			fout = new FileOutputStream(f);
            oos = new ObjectOutputStream(fout);
            for(int i  = 0; i < contacts.contactList.size(); i++ ){
                oos.writeObject(contacts.contactList.get(i));
            }
			

			System.out.println("Done");
            }
		} catch (Exception ex) {

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

	public void serializeUser_Pass(ArrayList signed) {
        File uf = new File("user.ser");

		try{ 
            uf.createNewFile();
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(uf, false)); 
            for(int i  = 0; i < signed.size(); i++ ){
                        oos.writeObject(signed.get(i));
            }
			System.out.println("Done");

		} catch (Exception ex) {
            //ex.printStackTrace();
            System.out.println("Something went wrong");
		}

    }

    public NewAccount deserialzeUser_Pass(ArrayList userList, String username) {

		NewAccount user = null;
        File uf = new File("user.ser");

		try{ 
            uf.createNewFile();
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
			

		} catch (Exception ex) {
            //ex.printStackTrace();
            System.out.println("Something went wrong!");

		}

		return user;

	}
    


	public AddressBook deserialzeAddress(String uId) {
        String filename = uId;
		AddressBook contacts = null;

		FileInputStream fin = null;
		ObjectInputStream ois = null;

		try {
            File f = new File(filename + ".ser");
            if(f.exists()){
              

			fin = new FileInputStream(f);
            ois = new ObjectInputStream(fin);
            while(fin != null){
                contacts.contactList.add((Contact) ois.readObject());
            }
        }else{ System.out.println("No Records found");} 
			
		} catch (Exception ex) {
            ex.printStackTrace();
            //System.out.println("Something went wrong!");

		} finally {

			if (fin != null) {
				try {
					fin.close();
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


   


    public static void main(String[] args){

    }
}