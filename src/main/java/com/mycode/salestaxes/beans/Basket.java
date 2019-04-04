package com.mycode.salestaxes.beans;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Basket {

	private List<Purchased> productslist;
	private BigDecimal salesTaxes;
	private BigDecimal total;
	public Basket( List<Purchased> productslist){
		this.productslist = productslist;
		
	}
	public List<Purchased> getProductslist() {
		return productslist;
	}

	public void setProductslist(List<Purchased> productslist) {
		this.productslist = productslist;
	}

	public BigDecimal getSalesTaxes() {
		return salesTaxes;
	}

	public void setSalesTaxes(BigDecimal salesTaxes) {
		this.salesTaxes = salesTaxes;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public void addToSalexTaxes(BigDecimal valueToAdd) {

		if (salesTaxes == null) {
			salesTaxes = valueToAdd;
		} else {

			salesTaxes=salesTaxes.add(valueToAdd);
		}
	}

	public void addToTotal(BigDecimal valueToAdd) {

		if (total == null) {
			total = valueToAdd;
		} else {

			total=total.add(valueToAdd);
		}

	}





}
