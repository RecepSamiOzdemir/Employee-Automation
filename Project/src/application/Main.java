package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class Main extends Application {

	private File myEmployeeFile = new File("employee.txt");

	private int index = 0; //This is employeArray's index and employee's social security number.
		
	public Employee[] employeeArray = new Employee[100]; //This is an array for employees

	
	//Define UI elements.
	private BorderPane borderpane = new BorderPane();
	private GridPane gridpane = new GridPane();
	private HBox hBoxButton = new HBox(5);
	private HBox hBoxChoice = new HBox(2);

	private Scene scene = new Scene(borderpane,800,400);

	private TextField firstNameTF = new TextField();
	private TextField lastNameTF = new TextField();
	private TextField ssnTF = new TextField();
	private TextField operationSsnTF = new TextField();
	private TextField grossSalesTF = new TextField();
	private TextField commisionRateTF = new TextField();
	private TextField baseSalaryTF = new TextField();
	private TextField weeklySalaryTF = new TextField();
	private TextField wageTF = new TextField();
	private TextField hoursTF = new TextField();

	private	Text firstName = new Text("First Name");
	private	Text lastName = new Text("Last Name");
	private	Text ssn = new Text("SSN");
	private	Text operationSsn = new Text("Search/Update SSN");
	private	Text salary = new Text("Salary");
	private	Text grossSales = new Text("Gross Sales");
	private	Text commisionRate = new Text("Commision Rate");
	private	Text baseSalary = new Text("Base Salary");
	private	Text weeklySalary = new Text("Weekly Salary");
	private	Text wage = new Text("Wage");
	private	Text hours = new Text("Hours");
	private	Text employee = new Text("Choose Employee Type");
	private	Text calculatedSalary = new Text("");

	private	Button buttonAdd = new Button("Add");
	private	Button buttonSearchSsn = new Button("Search by SSN");
	private	Button buttonUpdateSsn = new Button("Update by SSN");
	private	Button buttonClean = new Button("Clean Text Fields");


	@SuppressWarnings("rawtypes")
	private ChoiceBox choiceEmployee = new ChoiceBox();

	private void cleanTextFields() {
		firstNameTF.clear();
		lastNameTF.clear();
		ssnTF.clear();
		operationSsnTF.clear();
		grossSalesTF.clear();
		commisionRateTF.clear();
		baseSalaryTF.clear();
		weeklySalaryTF.clear();
		wageTF.clear();
		hoursTF.clear();
		calculatedSalary.setText("");
		choiceEmployee.getSelectionModel().clearSelection();
		on();

	}

	private void on() {
		grossSalesTF.setDisable(false);
		commisionRateTF.setDisable(false);
		baseSalaryTF.setDisable(false);
		wageTF.setDisable(false);
		hoursTF.setDisable(false);
		firstNameTF.setDisable(false);
		lastNameTF.setDisable(false);
		ssnTF.setDisable(false);
		operationSsnTF.setDisable(false);
		weeklySalaryTF.setDisable(false);
		choiceEmployee.setDisable(false);
	}

	private void off() {
		grossSalesTF.setDisable(true);
		commisionRateTF.setDisable(true);
		baseSalaryTF.setDisable(true);
		wageTF.setDisable(true);
		hoursTF.setDisable(true);
		firstNameTF.setDisable(true);
		lastNameTF.setDisable(true);
		ssnTF.setDisable(true);
		operationSsnTF.setDisable(true);
		weeklySalaryTF.setDisable(true);
	}

	private void choice () {

		int selectedIndex = choiceEmployee.getSelectionModel().getSelectedIndex();

		switch (selectedIndex) {
		case 0:
			off();
			firstNameTF.setDisable(false);
			lastNameTF.setDisable(false);
			wageTF.setDisable(false);
			hoursTF.setDisable(false);
			operationSsnTF.setDisable(false);
			break;
		case 1:
			off();
			firstNameTF.setDisable(false);
			lastNameTF.setDisable(false);
			weeklySalaryTF.setDisable(false);
			operationSsnTF.setDisable(false);
			break;
		case 2:
			off();
			firstNameTF.setDisable(false);
			lastNameTF.setDisable(false);
			operationSsnTF.setDisable(false);
			baseSalaryTF.setDisable(false);
			grossSalesTF.setDisable(false);
			commisionRateTF.setDisable(false);
			break;
		case 3:
			off();
			firstNameTF.setDisable(false);
			lastNameTF.setDisable(false);	
			operationSsnTF.setDisable(false);
			grossSalesTF.setDisable(false);
			commisionRateTF.setDisable(false);
			break;
		case 4:
			off();
			break;
		}
	}

	private void addAndCalculateSalary () throws FileNotFoundException {

		int selectedIndex = choiceEmployee.getSelectionModel().getSelectedIndex();
		index = existEmployeeCount();
		int ssn = index;

		String firstName = firstNameTF.getText();
		String lastName = lastNameTF.getText();
		String ssnString = String.valueOf(ssn);
		String wage = wageTF.getText();
		String grossSales = grossSalesTF.getText();
		String commisionRate = commisionRateTF.getText();
		String baseSalary = baseSalaryTF.getText();
		String weeklySalary = weeklySalaryTF.getText();
		String hours = hoursTF.getText();


		try {
			switch(selectedIndex) {
			case 0:
				double waged = Double.valueOf(wage);
				double hoursd = Double.valueOf(hours);

				HourlyEmployee hourlyEmployee = new HourlyEmployee(waged, hoursd, firstName, lastName, ssnString);

				employeeArray[index] = hourlyEmployee;

				double hourlySalary = hourlyEmployee.getPaymentAmount();
				String salaryString = Double.toString(hourlySalary);

				calculatedSalary.setText(salaryString);
				ssnTF.setText(ssnString);
				index++;
				break;
			case 1:
				double weeklySalaryd = Double.valueOf(weeklySalary);
				SalariedEmployee salariedEmployee = new SalariedEmployee(weeklySalaryd, firstName, lastName, ssnString);

				double salariedSalary = salariedEmployee.getPaymentAmount();
				String salariedSalaryString = Double.toString(salariedSalary);

				calculatedSalary.setText(salariedSalaryString);
				employeeArray[index] = salariedEmployee;
				ssnTF.setText(ssnString);
				index++;
				break;
			case 2:
				double baseSalaryd = Double.valueOf(baseSalary);
				double grossSalesd = Double.valueOf(grossSales);
				double commisionRated = Double.valueOf(commisionRate);

				BasePlusCommisionEmployee basePlusCommisionEmployee = new BasePlusCommisionEmployee(commisionRated, grossSalesd, baseSalaryd,firstName, lastName, ssnString);
				double baseCommisionSalary = basePlusCommisionEmployee.getPaymentAmount();
				String baseCommisionSalaryString = Double.toString(baseCommisionSalary);

				calculatedSalary.setText(baseCommisionSalaryString);
				employeeArray[index] = basePlusCommisionEmployee;
				ssnTF.setText(ssnString);
				index++;
				break;
			case 3:
				double grossSalesd2 = Double.valueOf(grossSales);
				double commisionRated2 = Double.valueOf(commisionRate);

				CommisionEmployee commisionEmployee = new CommisionEmployee(commisionRated2, grossSalesd2,firstName, lastName, ssnString);
				double commisionSalary = commisionEmployee.getPaymentAmount();
				String commisionSalaryString = Double.toString(commisionSalary);

				calculatedSalary.setText(commisionSalaryString);
				employeeArray[index] = commisionEmployee;
				ssnTF.setText(ssnString);
				index++;
				break;
			default:
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void searchBySsn() {
	    String enteredSsn = operationSsnTF.getText();

	    Employee foundEmployee = findEmployeeBySsn(enteredSsn);

	    if (foundEmployee != null) {
	        updateUIWithEmployeeInfo(foundEmployee);
	        choiceEmployee.setDisable(true);
	    } else {
	        // Handle case when employee with entered SSN is not found
	        // You can display a message or perform other actions as needed
	    }
	}

	private Employee findEmployeeBySsn(String ssn) {
	    for (int counter = 0; counter < index; counter++) {
	        Employee currentEmployee = employeeArray[counter];
	        if (currentEmployee != null && currentEmployee.getSocialSecurityNumber().equals(ssn)) {
	            return currentEmployee;
	        }
	    }
	    return null; // Employee with the given SSN not found
	}

	private void updateUIWithEmployeeInfo(Employee employee) {
	    firstNameTF.setText(employee.getFirstName());
	    lastNameTF.setText(employee.getLastName());
	    ssnTF.setText(employee.getSocialSecurityNumber());

	    if (employee instanceof HourlyEmployee) {
	        HourlyEmployee hourlyEmployee = (HourlyEmployee) employee;
	        wageTF.setText(Double.toString(hourlyEmployee.getWage()));
	        hoursTF.setText(Double.toString(hourlyEmployee.getHours()));
	        calculatedSalary.setText(Double.toString(hourlyEmployee.getPaymentAmount()));
	        choiceEmployee.getSelectionModel().select(0);
	    } else if (employee instanceof SalariedEmployee) {
	        SalariedEmployee salariedEmployee = (SalariedEmployee) employee;
	        weeklySalaryTF.setText(Double.toString(salariedEmployee.getPaymentAmount()));
	        calculatedSalary.setText(Double.toString(salariedEmployee.getPaymentAmount()));
	        choiceEmployee.getSelectionModel().select(1);
	    } else if (employee instanceof BasePlusCommisionEmployee) {
	        BasePlusCommisionEmployee basePlusCommisionEmployee = (BasePlusCommisionEmployee) employee;
	        baseSalaryTF.setText(Double.toString(basePlusCommisionEmployee.getBaseSalary()));
	        grossSalesTF.setText(Double.toString(basePlusCommisionEmployee.getGrossSales()));
	        commisionRateTF.setText(Double.toString(basePlusCommisionEmployee.getCommisionRate()));
	        calculatedSalary.setText(Double.toString(basePlusCommisionEmployee.getPaymentAmount()));
	        choiceEmployee.getSelectionModel().select(2);
	    } else if (employee instanceof CommisionEmployee) {
	        CommisionEmployee commisionEmployee = (CommisionEmployee) employee;
	        grossSalesTF.setText(Double.toString(commisionEmployee.getGrossSales()));
	        commisionRateTF.setText(Double.toString(commisionEmployee.getCommisionRate()));
	        calculatedSalary.setText(Double.toString(commisionEmployee.getPaymentAmount()));
	        choiceEmployee.getSelectionModel().select(3);
	    }
	}


	private void update() {

		String enteredSsn = operationSsnTF.getText();
		int enteredSsnInteger = Integer.valueOf(enteredSsn);

		int selectedIndex = choiceEmployee.getSelectionModel().getSelectedIndex();

		String firstName = firstNameTF.getText();
		String lastName = lastNameTF.getText();
		String ssnString = enteredSsn;
		String wage = wageTF.getText();
		String grossSales = grossSalesTF.getText();
		String commisionRate = commisionRateTF.getText();
		String baseSalary = baseSalaryTF.getText();
		String weeklySalary = weeklySalaryTF.getText();
		String hours = hoursTF.getText();


		try {
			switch(selectedIndex) {
			case 0:
				double waged = Double.valueOf(wage);
				double hoursd = Double.valueOf(hours);

				HourlyEmployee hourlyEmployee = new HourlyEmployee(waged, hoursd, firstName, lastName, ssnString);

				employeeArray[enteredSsnInteger] = hourlyEmployee;

				double hourlySalary = hourlyEmployee.getPaymentAmount();
				String salaryString = Double.toString(hourlySalary);

				calculatedSalary.setText(salaryString);
				ssnTF.setText(ssnString);
				break;
			case 1:
				double weeklySalaryd = Double.valueOf(weeklySalary);

				SalariedEmployee salariedEmployee = new SalariedEmployee(weeklySalaryd, firstName, lastName, ssnString);

				double salariedSalary = salariedEmployee.getPaymentAmount();
				String salariedSalaryString = Double.toString(salariedSalary);

				calculatedSalary.setText(salariedSalaryString);
				employeeArray[enteredSsnInteger] = salariedEmployee;
				ssnTF.setText(ssnString);
				break;
			case 2:
				double baseSalaryd = Double.valueOf(baseSalary);
				double grossSalesd = Double.valueOf(grossSales);
				double commisionRated = Double.valueOf(commisionRate);

				BasePlusCommisionEmployee basePlusCommisionEmployee = new BasePlusCommisionEmployee(baseSalaryd, grossSalesd, commisionRated,firstName, lastName, ssnString);

				double baseCommisionSalary = basePlusCommisionEmployee.getPaymentAmount();
				String baseCommisionSalaryString = Double.toString(baseCommisionSalary);

				calculatedSalary.setText(baseCommisionSalaryString);
				employeeArray[enteredSsnInteger] = basePlusCommisionEmployee;
				ssnTF.setText(ssnString);
				break;
			case 3:
				double grossSalesd2 = Double.valueOf(grossSales);
				double commisionRated2 = Double.valueOf(commisionRate);

				CommisionEmployee commisionEmployee = new CommisionEmployee(grossSalesd2, commisionRated2,firstName, lastName, ssnString);

				double commisionSalary = commisionEmployee.getPaymentAmount();
				String commisionSalaryString = Double.toString(commisionSalary);

				calculatedSalary.setText(commisionSalaryString);
				employeeArray[enteredSsnInteger] = commisionEmployee;
				ssnTF.setText(ssnString);
				break;
			default:
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (myEmployeeFile.delete()) {
			@SuppressWarnings("unused")
			File myEmployeeFile = new File("employee.txt");
			printArrayToFile();
		}	
	}

	private void printArrayToFile() {
		try {
			FileWriter writer = new FileWriter("employee.txt",true);
			for (int counter = existEmployeeCount(); counter < index ; counter++) {
				writer.write(employeeArray[counter] + "\n" );
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private int existEmployeeCount() {
		int lineCount = 0;
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader("employee.txt"))) {
		    while (bufferedReader.readLine() != null) {
		        lineCount++;
		    }
		} catch (IOException e) {
		    System.err.println("Dosya okunamadı: " + e.getMessage());
		}
		return lineCount;
	}
	
	public void loadExistEmployee() {
	    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(myEmployeeFile))) {
	        String line;
	        while ((line = bufferedReader.readLine()) != null) {
	            String[] words = line.split(",");
	            if (words[0].equals("Hourly Employee")) {
	                HourlyEmployee hourlyEmployee = new HourlyEmployee(
	                        Double.parseDouble(words[1]),
	                        Double.parseDouble(words[2]),
	                        words[3],
	                        words[4],
	                        words[5]
	                );
	                employeeArray[Integer.parseInt(words[5])] = hourlyEmployee;
	            } else if (words[0].equals("Salaried Employee")) {
	                SalariedEmployee salariedEmployee = new SalariedEmployee(
	                        Double.parseDouble(words[1]),
	                        words[2],
	                        words[3],
	                        words[4]
	                );
	                employeeArray[Integer.parseInt(words[4])] = salariedEmployee;
	            } else if (words[0].equals("Base Plus Commission Employee")) {
	                BasePlusCommisionEmployee basePlusCommisionEmployee = new BasePlusCommisionEmployee(
	                        Double.parseDouble(words[1]),
	                        Double.parseDouble(words[2]),
	                        Double.parseDouble(words[3]),
	                        words[4],
	                        words[5],
	                        words[6]
	                );
	                employeeArray[Integer.parseInt(words[6])] = basePlusCommisionEmployee;
	            } else if (words[0].equals("Commission Employee")) {
	                CommisionEmployee commisionEmployee = new CommisionEmployee(
	                        Double.parseDouble(words[1]),
	                        Double.parseDouble(words[2]),
	                        words[3],
	                        words[4],
	                        words[5]
	                );
	                employeeArray[Integer.parseInt(words[5])] = commisionEmployee;
	            }
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	

	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage primaryStage) {
		
		try {
			loadExistEmployee();  
			buttonClean.setOnAction(e -> cleanTextFields());
			choiceEmployee.setOnAction(e -> choice());
			buttonSearchSsn.setOnAction(e -> searchBySsn());
			buttonUpdateSsn.setOnAction(e -> update());
			buttonAdd.setOnAction(e -> {
				try {
					addAndCalculateSalary();
					printArrayToFile();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}

			});

			choiceEmployee.getItems().add(0, "Hourly Employee");
			choiceEmployee.getItems().add(1, "Salaried Employee");
			choiceEmployee.getItems().add(2, "Base Plus Commision Employee");
			choiceEmployee.getItems().add(3, "Commision Employee");
			choiceEmployee.getItems().add(4, "None");
			choiceEmployee.setPrefWidth(150);

			gridpane.setGridLinesVisible(false);

			gridpane.setAlignment(Pos.CENTER);
			gridpane.setVgap(20);
			gridpane.setHgap(20);
			gridpane.addColumn(0, firstName, lastName ,ssn ,operationSsn,salary  );
			gridpane.addColumn(1, firstNameTF, lastNameTF,ssnTF, operationSsnTF, calculatedSalary );
			gridpane.addColumn(2, grossSales, commisionRate, baseSalary, weeklySalary,wage,hours  );
			gridpane.addColumn(3, grossSalesTF, commisionRateTF, baseSalaryTF, weeklySalaryTF, wageTF, hoursTF);
			
			hBoxButton.getChildren().addAll(buttonAdd, buttonSearchSsn, buttonUpdateSsn, buttonClean);
			hBoxButton.setAlignment(Pos.CENTER);
			
			hBoxChoice.getChildren().addAll(employee,choiceEmployee);
			hBoxChoice.setAlignment(Pos.CENTER);

			borderpane.setCenter(gridpane);
			borderpane.setBottom(hBoxButton);
			borderpane.setTop(hBoxChoice);

			primaryStage.setTitle("Employee Automation");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
