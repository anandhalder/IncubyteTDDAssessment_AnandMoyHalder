import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {

	private static final String default_delimiter = ",";

	int add(String numbers) {
		if (numbers.isEmpty()) {
			return 0;
		}

		String delimiter = default_delimiter;
		if (numbers.startsWith("//")) {
			delimiter = numbers.substring(2, 3);
			numbers = numbers.substring(4);
		}

		String[] tokens = numbers.split("[,\n" + delimiter + "]");
		int sum = 0;
		List<Integer> negatives = new ArrayList<>();

		for (String token : tokens) {
			int num = Integer.parseInt(token);
			if (num < 0) {
				negatives.add(num);
			}
			sum += num;
		}

		if (!negatives.isEmpty()) {
			String msg = "negatives not allowed: " + negatives.stream().map(Object::toString).collect(Collectors.joining(", "));
			throw new IllegalArgumentException(msg);
		}

		return sum;
	}
}

