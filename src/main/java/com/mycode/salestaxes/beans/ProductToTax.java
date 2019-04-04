package com.mycode.salestaxes.beans;

import java.math.BigDecimal;

public interface ProductToTax {


	    public BigDecimal salesTaxes(BigDecimal  salesTaxes);
	    public CategoryProduct ownCategory();
	    public boolean isImported();
	    public String name();
	    public	BigDecimal total(BigDecimal percentage);

	
}
