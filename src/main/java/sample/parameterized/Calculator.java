package sample.parameterized;

import java.math.BigDecimal;

/**
 * Sample class that implements logic to calculate tax
 * 
 * @author gyanu
 * **/

public class Calculator {
    public BigDecimal calculateTax(BigDecimal income) {
	BigDecimal rate = new BigDecimal(0.10);
	return income.multiply(rate);
    }
}
