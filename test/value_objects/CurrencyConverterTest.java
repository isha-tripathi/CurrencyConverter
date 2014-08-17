package value_objects;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class CurrencyConverterTest {
    @Before
    public void setUp() throws Exception {
        CurrencyConverter.initialize();

    }

    @Test
    public void shouldConvertFromOneCurrencyToAnother() {
        assertThat(CurrencyConverter.getConversionRate("Dollar", "Euro"), is(1.350));
        assertThat(CurrencyConverter.getConversionRate("Euro", "Dollar"), is(0.741));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForNonExistentCountries() {
        CurrencyConverter.getConversionRate("Something", "Euro");
    }

}