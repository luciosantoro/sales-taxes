package com.lucio.santoro.sales.taxes.beans;

import java.math.BigDecimal;

public class Purchased implements Purchase {

	private BigDecimal total;

	private ProductToTax product;

	private Integer quantity;
	
	public Purchased(ProductToTax product, Integer quantity) {

		this.product = product;
		this.quantity= quantity;

	}


	@Override
	public BigDecimal total() {
		return total;
	}


	public BigDecimal getTotal() {
		return total;
	}


	public void setTotal(BigDecimal total) {
		this.total = total;
	}


	public ProductToTax getProduct() {
		return product;
	}


	public void setProduct(ProductToTax product) {
		this.product = product;
	}


	@Override
	public String productName() {
		return this.product.name();
	}

	@Override
	public Integer quantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}



}
