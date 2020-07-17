package calculator.util;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringCalculator {

    private String delimiter;
    private String numbers;

    private StringCalculator(String delimiter, String numbers) {
        this.delimiter = delimiter;
        this.numbers = numbers;
    }

    public static int sum(String input) {
        return parseNumbersInput(input).getSum();
    }

    private int getSum() {

        checkNegatives();

        return getInputNumbers().sum();
    }

    private IntStream getInputNumbers() {
        if(numbers.isEmpty())
            return IntStream.empty();

        return Arrays.stream(numbers.split(delimiter))
                    .filter((n) -> !n.isEmpty())
                    .map(String::trim)
                    .mapToInt(Integer::parseInt)
                    .filter(n -> n < 1000);
    }

    private static StringCalculator parseNumbersInput(String input) {
        if (input.startsWith("//")) {
            String[] splitWithDemil = input.split("\n", 2);
            return new StringCalculator(splitWithDemil[0].substring(2), splitWithDemil[1]);
        } else {
            return new StringCalculator(",|\n", input);
        }
    }

    private void checkNegatives() {
        String negativeNumbers = getInputNumbers().filter(n -> n < 0)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(","));

        if(!negativeNumbers.isEmpty())
            throw new IllegalArgumentException("Negative numbers: " + negativeNumbers);
    }
}
