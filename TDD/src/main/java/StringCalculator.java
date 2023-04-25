
public class StringCalculator {

	int add(String numbers) {
		if (numbers.isEmpty()) {
			return 0;
		}

		// If we are assuming only "," as a delimiters.
		String[] str = numbers.split(",");
		int sum = 0;

		for (String s: str) {
			sum += Integer.parseInt(s);
		}

		return sum;
	}
}

