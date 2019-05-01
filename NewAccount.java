
public class NewAccount {
	protected String iD;
	protected String password;
	protected AddressBook contacts;
	
	public NewAccount(String iD, String password) {
		super();
		this.iD = iD;
		this.password = password;
		this.contacts = new AddressBook();;
	}
	

	protected AddressBook getContacts() {
		return contacts;
	}


	protected void setContacts(AddressBook contacts) {
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

	protected void setPassword(String password) {
		this.password = password;
	}
	
}
