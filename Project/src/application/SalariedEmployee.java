package application;

/*This class for only which are salaried employee.*/

public class SalariedEmployee extends Employee {
	
	private double weeklySalary;
	
	public SalariedEmployee (double weeklySalary, String firstName, String lastName, String socialSecurityNumber) {
		super (firstName, lastName, socialSecurityNumber);
		
		if (weeklySalary >= 0) {
					this.weeklySalary = weeklySalary;
		}
	}

	@Override
	public double getPaymentAmount() {
		return weeklySalary;
	}
	
	@Override
	public String toString () {
		return "SalariedEmployee," + weeklySalary + "," + getFirstName() + "," + getLastName() + "," + getSocialSecurityNumber() + ","  + getPaymentAmount();
	}

	public double getWeeklySalary() {
		return weeklySalary;
	}

	public void setWeeklySalary(double weeklySalary) {
		this.weeklySalary = weeklySalary;
	}
}
