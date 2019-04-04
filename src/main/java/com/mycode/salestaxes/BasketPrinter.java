package com.mycode.salestaxes;

import com.mycode.salestaxes.beans.Basket;
import com.mycode.salestaxes.beans.Purchased;

import java.math.BigDecimal;

public class BasketPrinter{

	
	public String printInputInvoice(Basket basketToprint){
		 StringBuffer basketPrinted = new StringBuffer("");
		if (basketToprint!=null && basketToprint.getProductslist()!=null){
			for (Purchased purchased : basketToprint.getProductslist()) {
				basketPrinted.append(purchased.quantity()+" "+purchased.getProduct().toString()+"\n");
			}
			
		}
		return basketPrinted.toString();
	}
	
	
	public String printOutputInvoice(Basket basketToprint){
		 StringBuffer basketPrinted = new StringBuffer("");
		if (basketToprint!=null && basketToprint.getProductslist()!=null){
			for (Purchased purchased : basketToprint.getProductslist()) {
				basketPrinted.append(purchased.quantity()+" "+ purchased.getProduct().name() +" "+ purchased.getTotal().multiply(new BigDecimal(purchased.quantity()))+"\n");
			}
			basketPrinted.append("Sales Taxes: "+basketToprint.getSalesTaxes()+"\n");
			basketPrinted.append("Total:  "+basketToprint.getTotal()+"\n");
		}
		return basketPrinted.toString();
	}
}
