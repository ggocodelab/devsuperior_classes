package services;

import employee.Employee;

public class SalaryService {
	
	//Wrong way
			TaxService taxService = new TaxService();
			PensionService pensionService = new PensionService();
	
	public double netSalary(Employee employee) {		
		return employee.getGrossSalary() - taxService.tax(employee.getGrossSalary())
				- pensionService.discount(employee.getGrossSalary());		
	}
}
