package calculator.util;

public class StringCalculator {

    public static int sum(String number) {
        if(number.isEmpty())
            return 0;

        return Integer.parseInt(number);
    }
}
