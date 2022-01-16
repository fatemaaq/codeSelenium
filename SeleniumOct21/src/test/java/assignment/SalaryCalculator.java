package assignment;

import java.util.Scanner;

public class SalaryCalculator {

	
	public static void empGrossSalary(int numberOfHours, int ratePerHour ) {
		
		
		int grossSalary = numberOfHours * ratePerHour;
		
		System.out.println(grossSalary);
	}
	
	
	public static void main(String[] args) {
		System.out.println("Please provide your number of hours");
		Scanner input = new Scanner(System.in);
		int empNumberOfHours = input.nextInt();
		System.out.println("Please provide rate per hour");
		int ratePerHr = input.nextInt();
		
		empGrossSalary(empNumberOfHours, ratePerHr);
		
		
		
		
	}

}
