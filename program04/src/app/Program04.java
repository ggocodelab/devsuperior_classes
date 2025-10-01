package app;

import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import services.BrazilTaxService;
import services.PensionService;
import services.SalaryService;
import services.TaxService;

public class Program04 {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Name: ");
		String name = sc.nextLine();
		System.out.println("Gross Salary: ");
		double grossSalary = sc.nextDouble();
		
		Employee employee = new Employee(name, grossSalary);
		
		TaxService taxService = new BrazilTaxService();
		PensionService pensionService = new PensionService();
		SalaryService salaryService = new SalaryService(taxService, pensionService);
		
		double netSalary = salaryService.netSalary(employee);
		System.out.printf("Salário líquido = %.2f%n", netSalary);
		
		sc.close();

	}

}
