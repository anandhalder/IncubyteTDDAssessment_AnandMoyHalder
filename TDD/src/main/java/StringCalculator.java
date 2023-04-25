import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {

	int add(String numbers) {

		String delimiter = getDelimiter(numbers);
		numbers =  removeDelimiterSpecifier(numbers);

		if (numbers.isEmpty()) {
			return 0;
		}

		List<Integer> parsedNumbers = Arrays.stream(numbers.split(delimiter)).map(Integer::parseInt).collect(Collectors.toList());

		// Checking of Negative Numbers.
		checkForNegativeNumbers(parsedNumbers);

		int sum = 0;
		for (String s: numbers.split("[,\n" + delimiter + "]")) {
			sum += Integer.parseInt(s);
		}

		return sum;
	}

	private String getDelimiter(String numbers) {
		String delimiter = ",";
		if (numbers.startsWith("//")) {
			delimiter = numbers.substring(2, 3);
		}
		return delimiter;
	}

	private String removeDelimiterSpecifier(String numbers) {
		if (numbers.startsWith("//")) {
			return numbers.substring(4);
		}
		return numbers;
	}

	private void checkForNegativeNumbers(List<Integer> numbers) {
		List<Integer> negativeNumbers = new ArrayList<>();
		for (int number : numbers) {
			if (number < 0) {
				negativeNumbers.add(number);
			}
		}
		if (!negativeNumbers.isEmpty()) {
			String msg = "Negatives not allowed: " + negativeNumbers.stream().map(Object::toString).collect(Collectors.joining(", "));
			throw new IllegalArgumentException(msg);
		}
	}
}

