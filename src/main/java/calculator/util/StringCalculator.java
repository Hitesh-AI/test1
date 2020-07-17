package calculator.util;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
            return new StringCalculator(parseDelimiter(splitWithDemil[0]), splitWithDemil[1]);
        } else {
            return new StringCalculator(",|\n", input);
        }
    }

    private static String parseDelimiter(String delim) {
        String delimiter  = delim.substring(2);

        if(delimiter.startsWith("[")) {
            delimiter = delimiter.substring(1, delimiter.length() -1);
        }

        return Stream.of(delimiter.split("]\\["))
                .map(Pattern::quote)
                .collect(Collectors.joining("|"));
    }

    private void checkNegatives() {
        String negativeNumbers = getInputNumbers().filter(n -> n < 0)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(","));

        if(!negativeNumbers.isEmpty())
            throw new IllegalArgumentException("Negative numbers: " + negativeNumbers);
    }
}
