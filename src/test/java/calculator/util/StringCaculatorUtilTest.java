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
}
