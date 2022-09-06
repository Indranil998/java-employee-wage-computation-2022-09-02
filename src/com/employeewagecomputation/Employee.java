package com.employeewagecomputation;

import java.util.HashMap;

public class Employee {
	final static int IS_PRESENT = 1;
	final static int IS_PART_TIME = 2;
	double FULL_DAY_HOUR = 8;
	double PART_TIME_HOUR = 4;
	
	public String name;
	double monthWages;
	double monthHours;
	HashMap<String, HashMap<String, Double>> dailyWages = new HashMap<String, HashMap<String, Double>>();
	
	Employee(String name) {
		this.name = name;
		monthWages = 0;
		monthHours = 0;
	}
	
	/**
	 * check employee attendance according to attendance calculate and display daily wage 
	 * then increments month wage and month hours by daily wage and day hours respectively
	 * and store todays wage into daily wages
	 * @param wagePerHour
	 * @param day
	 */
	public void attendance(double wagePerHour, int day) {
		// for store todays wages in key value pair (i.e. todays wage and total wages till today)
		HashMap<String, Double> todaysWage = new HashMap<String, Double>();
		double wage = 0;
		switch ((int) Math.floor(Math.random() * 10) % 3) {
		case IS_PRESENT:
			System.out.println(name+" is present.");
			// calculate todays wage according to full day hours
			wage = FULL_DAY_HOUR * wagePerHour;
			// add up todays full day hours to month hours
			monthHours += FULL_DAY_HOUR;
			break;
		case IS_PART_TIME:
			System.out.println(name+" is part time.");
			// calculate todays wage according to part time hours
			wage = PART_TIME_HOUR * wagePerHour;
			// add up todays part time hours to month hours
			monthHours += PART_TIME_HOUR;
			break;
		default:
			System.out.println(name+" is absenet.");
		}
		System.out.println(name+" daily wage is "+wage);
		// add up todays wage to month wage
		monthWages += wage;
		// store todays wage to daily wages
		todaysWage.put("today", wage);
		todaysWage.put("total", monthWages);
		dailyWages.put("day "+day, todaysWage);
	}
	
	/**
	 * calculates whole months wage
	 * @param wagePerHour
	 * @param workingDays
	 * @param monthlyHourLimit
	 * @return monthWages
	 */
	public double monthlyWage(double wagePerHour, int workingDays, double monthlyHourLimit) {
		int day = 1;
		while (day <= workingDays && monthHours < monthlyHourLimit) {
			attendance(wagePerHour, day);
			day++;
		}
		return monthWages;
	}
	
	public void showDailyWages() {
		System.out.println("Day Number \t Day Wage \t Total Wage");
		for (int day = 1; day <= 32; day++)
			if (dailyWages.containsKey("day "+day)) {
				HashMap<String, Double> todaysWage = dailyWages.get("day "+day);
				System.out.println( "day "+day+" \t "+todaysWage.get("today")+" \t "+todaysWage.get("total"));
			}
			else break;
	}
	
}