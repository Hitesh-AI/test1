package calculator.util;

import java.util.Arrays;

public class StringCalculator {

    private String delimiter;
    private String numbers;

    private StringCalculator(String delimiter, String numbers) {
        this.delimiter = delimiter;
        this.numbers = numbers;
    }

    public static int sum(String input) {
        if(input.isEmpty())
            return 0;

        return parseNumbersInput(input).getSum();
    }

    private int getSum() {
        return Arrays.stream(numbers.split(delimiter))
                    .filter((n) -> !n.isEmpty())
                    .map(String::trim)
                    .mapToInt(Integer::parseInt)
                    .sum();
    }

    private static StringCalculator parseNumbersInput(String input) {
        if (input.startsWith("//")) {
            String[] splitWithDemil = input.split("\n", 2);
            return new StringCalculator(splitWithDemil[0].substring(2), splitWithDemil[1]);
        } else {
            return new StringCalculator(",|\n", input);
        }
    }
}
