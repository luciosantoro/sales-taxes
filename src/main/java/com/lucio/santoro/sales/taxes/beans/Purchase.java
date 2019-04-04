package com.lucio.santoro.sales.taxes.beans;

import java.math.BigDecimal;

public interface Purchase {


	public BigDecimal total();
	public String productName();
	public Integer quantity();

}
