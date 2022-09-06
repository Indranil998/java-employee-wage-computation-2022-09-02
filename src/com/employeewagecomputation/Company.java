package com.employeewagecomputation;

import java.util.ArrayList;

public class Company {
	public String name;
	private double totalWage;
	// Array List Collection for storing employees
	ArrayList<Employee> employees = new ArrayList<Employee>();
	double wagePerHour;
	int workingDays;
	double monthlyHourLimit;
	
	Company(String name, double wagePerHour, int workingDays, double monthlyHourLimit){
		this.name = name;
		this.wagePerHour = wagePerHour;
		this.workingDays = workingDays;
		this.monthlyHourLimit = monthlyHourLimit;
		totalWage = 0;
	}
	
	public void addEmployee(String name) {
		// Adding employee to employees array list
		employees.add(new Employee(name));
	}
	
	/**
	 * calculate and display month wage of all employees in company in specific month
	 * @return total of month wage of all employees in company in specific month
	 */
	public double employeesMonthlyWage() {
		double monthWage = 0;
		for (int index = 0; index < employees.size(); index++) {
			Employee employee = employees.get(index);
			double employeeMonthWage = employee.monthlyWage(wagePerHour, workingDays, monthlyHourLimit);
			System.out.println(name+" Monthly wage for "+employee.name+" is "+employeeMonthWage);
			monthWage += employeeMonthWage;
		}
		return monthWage;
	}

	public double getTotalWage() {
		return totalWage;
	}

	public void setTotalWage(double totalWage) {
		this.totalWage += totalWage;
	}
	
	public void showEmployeesDailyWages() {
		employees.forEach((employee) -> {
			System.out.println("\n"+employee.name+" wages list : ");
			employee.showDailyWages();
		});
	}
}