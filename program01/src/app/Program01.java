package app;

import java.util.Locale;
import java.util.Scanner;

public class Program01 {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Gross salary: ");
		double grossSalary = sc.nextDouble();
		
		double netSalary = grossSalary * 0.7;
		System.out.printf("Net Salary = %.2f%n", netSalary);
		
		sc.close();

	}

}
