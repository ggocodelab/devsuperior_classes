package app;

import java.util.Locale;
import java.util.Scanner;

import services.PensionService;
import services.TaxService;

public class Program02 {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		TaxService taxService = new TaxService();
		PensionService pensionService = new PensionService();
		
		System.out.println(taxService.tax(4000.00));
		System.out.println(pensionService.discount(4000.00));
		
		sc.close();

	}

}
