package com.lucio.santoro.sales.taxes;

import com.lucio.santoro.sales.taxes.beans.Basket;
import com.lucio.santoro.sales.taxes.beans.Purchased;

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
