package com.mycode.salestaxes.beans;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MathUtils{

    
    public BigDecimal roundingValue(BigDecimal value,Double nearestVal){
    	BigDecimal valueRet = value
            .divide(new BigDecimal(nearestVal), RoundingMode.CEILING)
            .setScale(0, RoundingMode.CEILING)
            .multiply(new BigDecimal(nearestVal));
    	
    	return valueRet;
    }
}

