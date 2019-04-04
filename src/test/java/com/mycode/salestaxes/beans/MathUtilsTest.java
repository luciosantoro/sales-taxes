package com.mycode.salestaxes.beans;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class MathUtilsTest {
	@Test
	public void roundingValue() {
		MathUtils mathUtils = new MathUtils();
		BigDecimal val = mathUtils.roundingValue(new BigDecimal("2.731"), new Double("0.05"));
		assertTrue(val.compareTo(new BigDecimal("2.75")) == 1 && val.compareTo(new BigDecimal("2.76")) == -1);
	}
}
