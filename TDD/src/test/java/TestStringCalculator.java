import org.junit.Assert;
import org.junit.Test;

public class TestStringCalculator {

	@Test
	public void testStringCalculatorWithEmptyString() {
		StringCalculator obj = new StringCalculator();
		Assert.assertEquals(0, obj.calculation(""));
	}

	@Test
	public void testStringCalculatorWithOneDigit() {
		StringCalculator obj = new StringCalculator();
		Assert.assertEquals(1, obj.calculation("1"));
	}

	@Test
	public void testStringCalculatorWithUnknownNumberOfDigits() {
		StringCalculator obj = new StringCalculator();
		Assert.assertEquals(10, obj.calculation("1,2,3,4"));
	}

	@Test
	public void testStringCalculatorWithNewLineCharacter() {
		StringCalculator obj = new StringCalculator();
		Assert.assertEquals(6,obj.calculation("1\n2,3"));
	}

	@Test
	public void testStringCalculatorWithDifferentDelimiter() {
		StringCalculator obj = new StringCalculator();
		Assert.assertEquals(3, obj.calculation("//;\n1;2"));
	}

	@Test
	public void testStringCalculatorWithDifferentDelimiter2() {
		StringCalculator obj = new StringCalculator();
		Assert.assertEquals(4, obj.calculation("//*\n1*2*2"));
	}

	@Test
	public void testStringCalculatorWithAddNegativeNumbers() {
		StringCalculator obj = new StringCalculator();
		Exception exception = Assert
						.assertThrows(IllegalArgumentException.class,
										() -> { obj.calculation("1,-2,3,-4");});
		Assert.assertEquals("Negatives not allowed: -2, -4", exception.getMessage());
	}
}
