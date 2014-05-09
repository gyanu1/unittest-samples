package sample.parameterized;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/***
 * sample on running Paraterized test
 * 
 * @author gyanu
 * **/

@RunWith(Parameterized.class)
public class ParameterizedTest {
    private BigDecimal income;
    private BigDecimal expectedTax;

    @Parameters
    public static Collection<Object[]> data() {
	return Arrays.asList(new Object[][] { { new BigDecimal(100), new BigDecimal(10) }, { new BigDecimal(200), new BigDecimal(20) },
		{ new BigDecimal(300), new BigDecimal(30) }, });
    }

    public ParameterizedTest(BigDecimal income, BigDecimal expectedTax) {
	super();
	this.income = income;
	this.expectedTax = expectedTax;
    }

    @Test
    public void shouldCalculateCorrectTax() {
	Calculator calculator = new Calculator();
	BigDecimal calculatedTax = calculator.calculateTax(income);
	assertEquals(expectedTax.doubleValue(), calculatedTax.doubleValue(), 0.0);
	assertThat(Double.valueOf(calculatedTax.doubleValue()), is(expectedTax.doubleValue()));
    }
}
