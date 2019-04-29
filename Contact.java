
public class Contact {
	protected String name;
	protected int zipCode;
	protected String email;
	protected int phoneNumber;
	
	public Contact(String name, int zipCode, String email, int phoneNumber) {
		super();
		this.name = name;
		this.zipCode = zipCode;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	protected String getName() {
		return name;
	}

	protected int getZipCode() {
		return zipCode;
	}

	protected String getEmail() {
		return email;
	}

	protected int getPhoneNumber() {
		return phoneNumber;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	protected void setEmail(String email) {
		this.email = email;
	}

	protected void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + phoneNumber;
		result = prime * result + zipCode;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phoneNumber != other.phoneNumber)
			return false;
		if (zipCode != other.zipCode)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", zipCode=" + zipCode + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ "]";
	}
	
}
