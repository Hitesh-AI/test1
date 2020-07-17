package calculator.util;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

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

    @Test
    public void shouldAcceptCustomeDelimiterSyntax() {
        assertThat(StringCalculator.sum("//;\n4;3"), is(7));
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldRaiseExceptionOnNegativeNumber() {

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Negative numbers: -2,-3,-5");

        StringCalculator.sum("1,-2,-3,4,-5,7");
    }

    @Test
    public void shouldBeIgnoredWhenNoIsGreaterThanThousand() {
        assertThat(StringCalculator.sum("7,1007"), is(7));
    }

    @Test
    public void shouldAcceptDelimitersOfArbitaroryLength() {
        assertThat(StringCalculator.sum("//[***]\n1***3***3"), is(7));
    }

}
