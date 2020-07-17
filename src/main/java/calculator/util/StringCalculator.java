package calculator.util;

import java.util.Arrays;

public class StringCalculator {

    public static int sum(String number) {
        if(number.isEmpty())
            return 0;
        else if(number.contains(",")){
            return Arrays.stream(number.split(","))
                    .filter((n) -> !n.isEmpty())
                    .map(String::trim)
                    .mapToInt(Integer::parseInt)
                    .sum();
        } else {
            return Integer.parseInt(number);
        }
    }
}
