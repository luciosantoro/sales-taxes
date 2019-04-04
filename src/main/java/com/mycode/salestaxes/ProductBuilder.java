package com.mycode.salestaxes;

import java.math.BigDecimal;

import com.mycode.salestaxes.beans.CategoryProduct;
import com.mycode.salestaxes.beans.Product;

public class ProductBuilder {
	
	 private String name = new String("");
	    private BigDecimal price = new BigDecimal(0);
	    private boolean imported = false;
	    private CategoryProduct category = new CategoryProduct();
	    
	    public ProductBuilder category(String type, boolean exception){
	        this.category = new CategoryProduct(type, exception);

	        return this;
	    }
	    
	    
	    public ProductBuilder name(String name){
	        this.name = name;
	        return this;
	    }
	    public ProductBuilder price(BigDecimal price){
	        this.price = price;
	        return this;
	    }
	    
	    public ProductBuilder imported(){
	        this.imported = true;
	        return this;
	    }
	    public ProductBuilder notImported(){
	        this.imported = false;
	        return this;
	    }
	    public Product build(){
	        return new Product(name, price, imported,category);
	    }
}
