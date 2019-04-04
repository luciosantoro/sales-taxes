package com.lucio.santoro.sales.taxes;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import com.lucio.santoro.sales.taxes.beans.Basket;
import com.lucio.santoro.sales.taxes.beans.MathUtils;
import com.lucio.santoro.sales.taxes.beans.ProductToTax;
import com.lucio.santoro.sales.taxes.beans.Purchased;

public class CalculateTaxFacade {

	private final Double nearestVal = new Double("0.05");

	private MathUtils mathUtils = new MathUtils();

	public Basket compute(List<Purchased> productsPurchasedlist) {
		Basket invoice = new Basket(productsPurchasedlist);
		if (productsPurchasedlist != null) {
			for (Purchased purchased : productsPurchasedlist) {

				ProductToTax product = purchased.getProduct();
				// add salesTaxes of each product
				BigDecimal saleTaxes = calculateAllSalesTaxes(product);
				invoice.addToSalexTaxes(saleTaxes);
				// add taxesPrice of each product to total
				BigDecimal total = product.total(saleTaxes);
				invoice.addToTotal(total.multiply(new BigDecimal(purchased.quantity())));
                //set total to purchased
				purchased.setTotal(total);
				purchased.setProduct(product);
				
			}
		}
		return invoice;

	}

	//Calculate all salesTaxes of the product
	private BigDecimal calculateAllSalesTaxes(ProductToTax product) {
		BigDecimal totalSalesTaxes= new BigDecimal("0");

		if (product.isImported()) {
			totalSalesTaxes = totalSalesTaxes.add(calculateSalesTaxes(product,Constants.PRODUCT_IMPORTED_PERC));
		}
		if (product != null && !product.ownCategory().isExcemption()) {
			totalSalesTaxes = totalSalesTaxes.add(calculateSalesTaxes(product,Constants.BASIC_SALES_TAXES_PERC));
			
		}

		return totalSalesTaxes;
	}

    //calculate salesTaxes 
	private BigDecimal calculateSalesTaxes(ProductToTax product, BigDecimal percentage){
		
		return mathUtils.roundingValue(product.salesTaxes(percentage), nearestVal).setScale(2, RoundingMode.DOWN);
	}

}
