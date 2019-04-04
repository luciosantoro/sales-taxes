package com.lucio.santoro.sales.taxes.beans;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.lucio.santoro.sales.taxes.ProductBuilder;
import org.junit.Test;


public class ProductTest {
	ProductBuilder productBuilder = new ProductBuilder();
    @Test
    public void foodNotEqualToPerfume(){
    	
        Product prod1 = productBuilder.name("chocolate bar").price(new BigDecimal("10")).category("food", true).build();
        Product prod2 = productBuilder.name("perfume").price(new BigDecimal("11")).category("cosmetic", false).build();
        
        assertFalse(prod2.equals(prod1));
    }

    @Test
    public void foodEqualToFood(){
    	List<BigDecimal> listTaxes = new ArrayList<BigDecimal>();
    	listTaxes.add(new BigDecimal("10"));
    	ProductBuilder prdBld = productBuilder.name("chocolate bar").price(new BigDecimal("10")).category("food", true);
    	
    	
        Product prod1 = prdBld.build();
        Product prod2 = prdBld.build();
        assertTrue(prod2.equals(prod1));
    }
   
}