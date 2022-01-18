package assignment;

import java.util.Scanner;

public class SalaryCalculator {

	
	public static double empGrossSalary(int numberOfHours, int ratePerHour, int noOfLeaves ) {
		
		if(numberOfHours < 0) {
			return -1;
		}
		
		if(ratePerHour < 0) {
			return -1;
		}
		
		int unpaidTime = noOfLeaves * ratePerHour;
		double grossSalary = numberOfHours * ratePerHour;
		return (grossSalary * 52) - unpaidTime;
	}
	
		
	
	
	public static void main(String[] args) {
		System.out.println("Please provide your number of hours: ");
		Scanner input = new Scanner(System.in);
		int numberOfHours = input.nextInt();
		System.out.println("Please provide rate per hour: ");
		int ratePerHr = input.nextInt();
		System.out.println("Enter numner of days taken for leaves: ");
		int noOfLeaves = input.nextInt();
		
		double fullGrossSalary = empGrossSalary(numberOfHours, ratePerHr, noOfLeaves);
		System.out.println(fullGrossSalary);
		
		
		
		
		
		
	}

}
