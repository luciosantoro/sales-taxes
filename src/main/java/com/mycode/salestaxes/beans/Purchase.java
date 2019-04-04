package com.mycode.salestaxes.beans;

import java.math.BigDecimal;

public interface Purchase {


	public BigDecimal total();
	public String productName();
	public Integer quantity();

}
