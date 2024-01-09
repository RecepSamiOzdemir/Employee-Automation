package application;

/*This class for only hourly workers.*/

public class HourlyEmployee extends Employee {
	
	private double hours;
	private double wage = 1;
	
	public HourlyEmployee (double hours, double wage, String firstName, String lastName, String socialSecurityNumber) {
		super (firstName, lastName, socialSecurityNumber);
		
		if (wage >= 0 && (hours >= 0 && hours <168)) {
			this.hours = hours;
			this.wage = wage;
		}
	}

	@Override
	public double getPaymentAmount() {
		double salary = 0;
		
		if (hours <= 40) {
			salary = wage * hours;
		} else {
			salary = 40 * wage + (hours - 40) * wage * 1.5;
		}
		return salary;
	}
	
	@Override
	public String toString () {
		return "HourlyEmployee," + wage + "," + hours + ","+ getFirstName() + "," + getLastName() +  "," + getSocialSecurityNumber() + "," +getPaymentAmount();
	}

	public double getHours() {
		return hours;
	}

	public void setHours(double hours) {
		this.hours = hours;
	}

	public double getWage() {
		return wage;
	}

	public void setWage(double wage) {
		this.wage = wage;
	}
}
