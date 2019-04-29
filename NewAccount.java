
public class NewAccount {
	protected String iD;
	protected String password;
	
	public NewAccount(String iD, String password) {
		super();
		this.iD = iD;
		this.password = password;
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
