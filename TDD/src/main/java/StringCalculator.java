import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {

	private static final String delimiter = ",";

	int add(String numbers) {
		if (numbers.isEmpty()) {
			return 0;
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

		return sum;
	}
}

