package application;

/*This class for every employees.*/

public abstract class Employee implements Payable {

	private String firstName, lastName, socialSecurityNumber;
	
	public Employee (String firstName, String lastName, String socialSecurityNumber) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecurityNumber = socialSecurityNumber;
		
	}
	
	@Override
	public  String toString() {
		return getFirstName() + " " + getLastName() + " " + getSocialSecurityNumber();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}
	
	
	
}
