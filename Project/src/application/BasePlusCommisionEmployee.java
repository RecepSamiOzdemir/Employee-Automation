package application;

/*This class for which is have base salary and their salary improves when employee sell something.*/


public class BasePlusCommisionEmployee extends CommisionEmployee {
	
	private double baseSalary;
	
	public BasePlusCommisionEmployee (double commisionRate, double grossSales, double baseSalary, String firstName, String lastName, String socialSecurityNumber) {
		super (commisionRate, grossSales, firstName, lastName, socialSecurityNumber);
		
		if (baseSalary >= 0) {
			this.baseSalary = baseSalary;
		}
	}
	
	@Override
	public double getPaymentAmount () {
		return ( getGrossSales() * getCommisionRate() ) + getBaseSalary();
	}
	
	@Override
	public String toString() {
		return "BaseSalariedCommisionEmployee," + getCommisionRate() + "," + getGrossSales() + "," + getBaseSalary() + "," + getFirstName() + "," + getLastName()  + "," + getSocialSecurityNumber() + "," + getPaymentAmount();
				
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}
	
	
}
