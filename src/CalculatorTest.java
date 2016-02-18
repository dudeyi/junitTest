
import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;


public class CalculatorTest {
	private static Calculator calculator = new Calculator();
	
	@Test
	public void testAdd() {
		assertEquals(3, calculator.add(1, 2));
		
	}

	@Test
	public void testSubstract() {
		assertEquals(-1, calculator.substract(1, 2));
	}

	
	@Test
	public void testMultiply() {
		assertEquals(2, calculator.multiply(1, 2));
	}
	@Ignore
	@Test
	public void testDivide() {
		assertEquals(2, calculator.divide(1, 2));
	}

}
