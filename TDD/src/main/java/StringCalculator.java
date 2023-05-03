import java.util.ArrayList;
import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {

	int calculation(String numbers) {

		String delimiter = getDelimiter(numbers);
		numbers =  removeDelimiterSpecifier(numbers);

		// Removing the new Line.
		numbers = numbers.replace('\n', ',');

		// Whatever the Delimiter will, it will always be converted into ",".
		if (!delimiter.equals(",")) {
			numbers = numbers.replaceAll("\\".concat(delimiter), ",");
		}

		if (numbers.isEmpty()) {
			return 0;
		}

		// delimiter in the string must be ",".
		List<Integer> parsedNumbers = Arrays.stream(numbers.split(",")).map(Integer::parseInt).collect(Collectors.toList());

		// Checking of Negative Numbers.
		checkForNegativeNumbers(parsedNumbers);


		// Operation Logic
		if (delimiter.equals("*")) {
			return Multiple(numbers, delimiter);
		} else {
			return Add(numbers, delimiter);
		}
	}

	static int Add(String numbers, String delimiter) {

		int sum = 0;

		for (String s: numbers.split("[,\n" + delimiter + "]")) {
			sum += Integer.parseInt(s);
		}

		return sum;
	}

	static int Multiple(String numbers, String delimiter) {

		int mul = 1;

		for (String s: numbers.split("[,\n" + delimiter + "]")) {
			mul *= Integer.parseInt(s);
		}

		return mul;
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

