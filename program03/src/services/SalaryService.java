package services;

import entities.Employee;

public class SalaryService {
	
	//Wrong way
	//TaxService taxService = new TaxService();
	//PensionService pensionService = new PensionService();
	
	private TaxService taxService;
	
	private PensionService pensionService;
	
	public SalaryService(TaxService taxService, PensionService pensionService) {
		this.taxService = taxService;
		this.pensionService = pensionService;
	}
	
	public double netSalary(Employee employee) {
		return employee.getGrossSalary() - taxService.tax(employee.getGrossSalary()) 
				- pensionService.discount(employee.getGrossSalary()); 
	}
}
