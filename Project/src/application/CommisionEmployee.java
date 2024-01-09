package application;

/*This class for their salaries' calculating when their sell something.*/

public class CommisionEmployee extends Employee {
	
	private double commisionRate;
	private double grossSales;
	
	public CommisionEmployee (double commisionRate, double grossSales, String firstName, String lastName, String socialSecurityNumber) {
		super (firstName, lastName, socialSecurityNumber);
		
		if (grossSales >= 0 && (commisionRate > 0 && commisionRate < 1)) {
			this.commisionRate = commisionRate;
			this.grossSales = grossSales;
		}
	}
	
	@Override
	public double getPaymentAmount() {
		return commisionRate * grossSales;
	}
	
	@Override
	public String toString() {
		return "CommisionEmployee," + getCommisionRate() + "," + getGrossSales() + "," + getFirstName() + "," + getLastName() + "," + getSocialSecurityNumber() + ","  + getPaymentAmount();
	}

	public double getCommisionRate() {
		return commisionRate;
	}

	public void setCommisionRate(double commisionRate) {
		this.commisionRate = commisionRate;
	}

	public double getGrossSales() {
		return grossSales;
	}

	public void setGrossSales(double grossSales) {
		this.grossSales = grossSales;
	}

	
	
}
