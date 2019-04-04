package com.lucio.santoro.sales.taxes;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.lucio.santoro.sales.taxes.beans.Basket;
import org.junit.Test;

import com.lucio.santoro.sales.taxes.beans.ProductToTax;
import com.lucio.santoro.sales.taxes.beans.Purchased;

public class BasketPrinterTest {
	ProductBuilder productBuilder = new ProductBuilder();

	@Test
	public void invoice1() {

		String inputStringToCompare = 
				  "Input 1:\n" + 
		          "2 book at 12.49\n" +
				  "1 music CD at 14.99\n"
				+ "1 chocolate bar at 0.85\n";
		
		String outputStringToCompare = "Output 1:\n"+
			"2 book 24.98\n"+
			"1 music CD 16.49\n"+
			"1 chocolate bar 0.85\n"+
			"Sales Taxes: 1.50\n"+
			"Total:  29.83\n";
		
		ProductToTax book = productBuilder.name("book").price(new BigDecimal("12.49")).category("book", true).notImported().build();

		ProductToTax musciCD = productBuilder.name("music CD").price(new BigDecimal("14.99")).category("music", false).notImported()
				.build();

		ProductToTax chocolateBar = productBuilder.name("chocolate bar").price(new BigDecimal("0.85"))
				.category("food", true).notImported().build();
		CalculateTaxFacade calculateTaxFacade = new CalculateTaxFacade();
		List<Purchased> productsPurchasedlist = new ArrayList<Purchased>();
		Purchased arg0 = new Purchased(book,2);
		Purchased arg1 = new Purchased(musciCD,1);
		Purchased arg2 = new Purchased(chocolateBar,1);
		productsPurchasedlist.add(arg0);
		productsPurchasedlist.add(arg1);
		productsPurchasedlist.add(arg2);
		Basket invoice = calculateTaxFacade.compute(productsPurchasedlist);

		BasketPrinter printer = new BasketPrinter();
		System.out.println("Input 1:\n" + printer.printInputInvoice(invoice) + "\n");
		System.out.println("Output 1:\n" + printer.printOutputInvoice(invoice) + "\n");
      /*  assertEquals(inputStringToCompare, "Input 1:\n" + printer.printInputInvoice(invoice) );
        assertEquals(outputStringToCompare, "Output 1:\n" + printer.printOutputInvoice(invoice)  );*/
    	
	}
	

	@Test
	public void invoice2() {
		
		String inputStringToCompare = 
				  "Input 2:\n" + 
		          "1 imported bottle of perfume at 47.50\n" +
				  "1 imported box of chocolate at 10.00\n";
		
		String outputStringToCompare = "Output 2:\n"+
			"1 bottle of perfume 54.65\n"+
			"1 box of chocolate 10.50\n"+
			"Sales Taxes: 7.65\n"+
			"Total:  65.15\n";
		
		ProductToTax chocolate = productBuilder.name("box of chocolate").price(new BigDecimal("10.00"))
				.category("food", true).imported().build();

		ProductToTax perfume = productBuilder.name("bottle of perfume").price(new BigDecimal("47.50"))
				.category("perfume", false).imported().build();

		CalculateTaxFacade calculateTaxFacade = new CalculateTaxFacade();
		List<Purchased> productsPurchasedlist = new ArrayList<Purchased>();
		Purchased arg0 = new Purchased(perfume,1);
		Purchased arg1 = new Purchased(chocolate,1);
		productsPurchasedlist.add(arg0);
		productsPurchasedlist.add(arg1);
		Basket invoice = calculateTaxFacade.compute(productsPurchasedlist);

		BasketPrinter printer = new BasketPrinter();
		System.out.println("Input 2:\n" + printer.printInputInvoice(invoice) + "\n");
		System.out.println("Output 2:\n" + printer.printOutputInvoice(invoice) + "\n");
		assertEquals(inputStringToCompare, "Input 2:\n" + printer.printInputInvoice(invoice) );
        assertEquals(outputStringToCompare, "Output 2:\n" + printer.printOutputInvoice(invoice)  );


	}

	@Test
	public void invoice3() {
		
		String inputStringToCompare = 
				  "Input 3:\n" + 
		          "1 imported bottle of perfume at 27.99\n" +
				  "1 bottle of perfume at 18.99\n"+
				  "1 packet of headache pills at 9.75\n" +
				  "3 imported box of chocolates at 11.25\n"
				  ;
		
		String outputStringToCompare = "Output 3:\n"+
			"1 bottle of perfume 32.19\n"+
			"1 bottle of perfume 20.89\n"+
			"1 packet of headache pills 9.75\n"+
			"3 box of chocolates 35.55\n"+
			"Sales Taxes: 6.70\n"+
		    "Total:  98.38\n";
		
		ProductToTax perfumeImported = productBuilder.name("bottle of perfume").price(new BigDecimal("27.99"))
				.category("cosmetic", false).imported().build();

		ProductToTax perfume = productBuilder.name("bottle of perfume").price(new BigDecimal("18.99"))
				.category("cosmetic", false).notImported().build();
		
		ProductToTax pills = productBuilder.name("packet of headache pills").price(new BigDecimal("9.75"))
				.category("medical", true).notImported().build();
		
		ProductToTax chocolateImported = productBuilder.name("box of chocolates").price(new BigDecimal("11.25"))
				.category("food", true).imported().build();


		CalculateTaxFacade calculateTaxFacade = new CalculateTaxFacade();
		List<Purchased> productsPurchasedlist = new ArrayList<Purchased>();
		Purchased arg0 = new Purchased(perfumeImported,1);
		Purchased arg1 = new Purchased(perfume,1);
		Purchased arg2 = new Purchased(pills,1);
		Purchased arg3 = new Purchased(chocolateImported,3);
		productsPurchasedlist.add(arg0);
		productsPurchasedlist.add(arg1);
		productsPurchasedlist.add(arg2);
		productsPurchasedlist.add(arg3);
		Basket invoice = calculateTaxFacade.compute(productsPurchasedlist);

		BasketPrinter printer = new BasketPrinter();
		System.out.println("Input 3:\n" + printer.printInputInvoice(invoice) + "\n");
		System.out.println("Output 3:\n" + printer.printOutputInvoice(invoice) + "\n");
		assertEquals(inputStringToCompare, "Input 3:\n" + printer.printInputInvoice(invoice) );
        assertEquals(outputStringToCompare, "Output 3:\n" + printer.printOutputInvoice(invoice)  );
    	
	}

}