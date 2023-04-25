import org.junit.Assert;
import org.junit.Test;

public class TestStringCalculator {

	@Test
	public void testStringCalculatorWithEmptyString() {
		StringCalculator obj = new StringCalculator();
		Assert.assertEquals(0, obj.add(""));
	}

	@Test
	public void testStringCalculatorWithOneDigit() {
		StringCalculator obj = new StringCalculator();
		Assert.assertEquals(1, obj.add("1"));
	}

	@Test
	public void testStringCalculatorWithUnknownNumberOfDigits() {
		StringCalculator obj = new StringCalculator();
		Assert.assertEquals(10, obj.add("1,2,3,4"));
	}
}
