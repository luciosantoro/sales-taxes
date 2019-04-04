package com.mycode.salestaxes;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.mycode.salestaxes.beans.Basket;
import com.mycode.salestaxes.beans.ProductToTax;
import com.mycode.salestaxes.beans.Purchased;

public class CalculateTaxFacadeTest {
	ProductBuilder productBuilder = new ProductBuilder();

	@Test
	public void invoiceFood() {

		ProductToTax product = productBuilder.name("chocolate bar").price(new BigDecimal("0.85"))
				.category("food", true).build();

		CalculateTaxFacade calculateTaxFacade = new CalculateTaxFacade();

		List<Purchased> productsPurchasedlist = new ArrayList<Purchased>();

		Purchased arg0 = new Purchased(product,1);
		productsPurchasedlist.add(arg0);
		Basket invoice = calculateTaxFacade.compute(productsPurchasedlist);
		assertTrue(invoice != null);
		assertTrue(invoice.getTotal().equals(new BigDecimal("0.85")));

	}

	@Test
	public void invoiceFoodImported() {

		ProductToTax product = productBuilder.name("box of chocolate").price(new BigDecimal("10.00"))
				.category("food", true).imported().build();

		CalculateTaxFacade calculateTaxFacade = new CalculateTaxFacade();
		List<Purchased> productsPurchasedlist = new ArrayList<Purchased>();
		Purchased arg0 = new Purchased(product,1);
		productsPurchasedlist.add(arg0);
		Basket invoice = calculateTaxFacade.compute(productsPurchasedlist);
		assertTrue(invoice.getTotal().equals(new BigDecimal("10.50")));

	}


	@Test
	public void invoicePurfumeImported() {

		ProductToTax product = productBuilder.name("bottle of perfume").price(new BigDecimal("47.50"))
				.category("perfume", false).imported().build();

		CalculateTaxFacade calculateTaxFacade = new CalculateTaxFacade();
		List<Purchased> productsPurchasedlist = new ArrayList<Purchased>();
		Purchased arg0 = new Purchased(product,1);
		productsPurchasedlist.add(arg0);
		Basket invoice = calculateTaxFacade.compute(productsPurchasedlist);
		assertTrue(invoice.getTotal().equals(new BigDecimal("54.65")));

	}
	@Test
	public void invoicePurfume() {

		ProductToTax product = productBuilder.name("bottle of perfume").price(new BigDecimal("47.50"))
				.category("perfume", false).build();

		CalculateTaxFacade calculateTaxFacade = new CalculateTaxFacade();
		List<Purchased> productsPurchasedlist = new ArrayList<Purchased>();
		Purchased arg0 = new Purchased(product,1);
		productsPurchasedlist.add(arg0);
		Basket invoice = calculateTaxFacade.compute(productsPurchasedlist);
		assertTrue(invoice.getTotal().equals(new BigDecimal("52.25")));

	}

}