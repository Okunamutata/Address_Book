import java.util.ArrayList;
public class NewAccount implements java.io.Serializable {
	private static final long serialversionUID = 
                                 129348938L; 
	protected String iD;
	protected String password;
	protected ArrayList<Contact> contacts;
	
	public NewAccount(String iD, String password){
		super();
		this.iD = iD;
		this.password = password;
		this.contacts = new ArrayList<Contact>();
	}
	

	protected ArrayList<Contact> getContacts() {
		return contacts;
	}


	protected void setContacts(ArrayList<Contact> contacts) {
		this.contacts = contacts;
	}


	protected String getiD() {
		return iD;
	}

	protected String getPassword() {
		return password;
	}

	protected void setiD(String iD) {
		this.iD = iD;
	}

	protected int getNumContacts(){
		return contacts.size();
	}

	protected void setPassword(String password) {
		this.password = password;
	}
	
}
