package com.mycode.salestaxes.beans;

import java.math.BigDecimal;

public class Product implements ProductToTax {

	private String name;
	private BigDecimal price;
	private boolean imported;

	private CategoryProduct category;

	public Product(String name, BigDecimal price, boolean imported, CategoryProduct category) {
		this.price = price;
		this.name = name;
		this.imported = imported;
		this.category = category;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public boolean isImported() {
		return imported;
	}

	public void setImported(boolean imported) {
		this.imported = imported;
	}

	public CategoryProduct getCategory() {
		return category;
	}

	public void setCategory(CategoryProduct category) {
		this.category = category;
	}

	@Override
	public BigDecimal total(BigDecimal salesTaxes) {

		return price.add(salesTaxes);
	}



	@Override
	public BigDecimal salesTaxes(BigDecimal percentage) {
		BigDecimal returnedValue = price.divide(new BigDecimal("100")).multiply(percentage);
		

		return returnedValue;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj == null) {
			return false;
		}

		else if (obj == this) {
			return true;

		}

		Product prod = (Product) obj;
		if (name.equals(prod.name) && price.equals(prod.price) && imported == prod.imported
				&& category.equals(prod.category)) {
			return true;
		} else
			return false;

	}

	@Override
	public String toString() {
		String toStringVal = this.name +" at " + this.price;
		if(imported) return "imported "+toStringVal;
		return toStringVal;
	}
	
	@Override
	public CategoryProduct ownCategory() {
		return category;
	}

	@Override
	public String name() {
		return name;
	}




}
