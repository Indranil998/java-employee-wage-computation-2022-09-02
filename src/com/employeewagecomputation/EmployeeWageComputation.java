package com.employeewagecomputation;

public class EmployeeWageComputation {
	
	public static void main(String[] args) {
		System.out.println("Welcome to Employee Wage Computation Program");
		// create company employee wage object
		CompanyEmpWage companyEmpWage = new CompanyEmpWage();
		// add TCS company with 25 wage per hour, 18 working days per month and 80 working hours limit per month
		companyEmpWage.addCompany("TCS", 25, 18, 80);
		// add Wipro company with 10 wage per hour, 24 working days per month and 200 working hours limit per month
		companyEmpWage.addCompany("Wipro", 10, 24, 200);
		// add employee Raj to TCS company
		companyEmpWage.addEmployee("Raj", "TCS");
		// add emoployee Harsh to wipro company
		companyEmpWage.addEmployee("Harsh", "Wipro");
		// generate all companies all employees wages
		companyEmpWage.empWageBuilder();
		// show total wages distributed by TCS
		System.out.println("Total wage for TCS is "+companyEmpWage.companyTotalWage("TCS"));
		// show total wages distributed by Wipro
		System.out.println("Total wage for Wipro is "+companyEmpWage.companyTotalWage("Wipro"));
		// show all companies all employees wages information
		companyEmpWage.showCompaniesEmployeesDailyWages();
	}

}
