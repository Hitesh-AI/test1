package calculator.util;

import java.util.Arrays;

public class StringCalculator {

    public static int sum(String number) {
        if(number.isEmpty())
            return 0;

        String delimiter = ",|\n";

        if(number.startsWith("//")) {
            String[] splitWithDemil = number.split("\n", 2);
            delimiter = splitWithDemil[0].substring(2);
            number = splitWithDemil[1];
        }

        return Arrays.stream(number.split(delimiter))
                    .filter((n) -> !n.isEmpty())
                    .map(String::trim)
                    .mapToInt(Integer::parseInt)
                    .sum();
    }
}
