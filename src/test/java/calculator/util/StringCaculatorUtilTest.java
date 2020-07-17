package calculator.util;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class StringCaculatorUtilTest {

    @Test
    public void shouldReturnZeroOnEmptyString() {
        assertThat(StringCalculator.sum(""), is(0));
    }

    @Test
    public void shouldReturnNumberOnNumber() {
        assertThat(StringCalculator.sum("7"), is(7));
    }

    @Test
    public void shouldReturnSumOfTwoNumbersDelimitedByCommas() {
        assertThat(StringCalculator.sum("3,4"), is(7));
    }

    @Test
    public void shouldReturnsSumOnMultipleNUmbers() {
        assertThat(StringCalculator.sum("1,2,4"), is(7));
    }

    @Test
    public void shouldAcceptNewLineAsValidDelimeter() {
        assertThat(StringCalculator.sum("1,2\n4"), is(7));
    }
}
