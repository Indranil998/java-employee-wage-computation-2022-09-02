package com.employeewagecomputation;

import java.util.ArrayList;

public class CompanyEmpWage implements EmpWageBuilder{
	// Array List Collection for storing companies
	ArrayList<Company> companies = new ArrayList<Company>();
	
	public void addCompany(String comapnyName, double wagePerHour, int workingDays, double monthlyHourLimit) {
		// Adding company to companies array list
		companies.add(new Company(comapnyName, wagePerHour, workingDays, monthlyHourLimit)); 
	}
	
	public void addEmployee(String employeeName, String companyName) {
		for (Company company : companies) if (company.name.equals(companyName)) {
			company.addEmployee(employeeName);
			break;
		}
	}
	
	/*
	 * store total of month wage of all employees in company in specific month
	 */
	public void empWageBuilder() {
		for (Company company : companies) {
			System.out.println("Monthly wage for "+company.name+" employees is : ");
			company.setTotalWage(company.employeesMonthlyWage());
		}
	}
	
	/**
	 * Check company of specified names occurs or not if occurs then return its total wages otherwise return 0
	 * @param companyName
	 * @return company's total wages 
	 */
	public double companyTotalWage(String companyName) {
		for (Company company : companies) if (company.name == companyName) return company.getTotalWage();
		return 0;
	}
	
	public void showCompaniesEmployeesDailyWages() {
		companies.forEach((company) -> {
			System.out.println("\n"+company.name+" wages list : ");
			company.showEmployeesDailyWages();	
		});
	}
}