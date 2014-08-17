package value_objects;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DollarTest {
    @Before
    public void setUp() throws Exception {
        CurrencyConverter.initialize();
    }

    @Test
    public void shouldEquateToDifferentCurrencyBasedOnConversionRate() {
        Euro euro = new Euro(10);
        Dollar dollar = new Dollar(13.5);

        assertEquals(dollar, euro);
    }

    @Test
    public void shouldConvertAnotherCurrencyToDollar() {
        assertEquals(13.5,new Dollar(10).getConversionAmount(new Euro()), 0.01);
    }
}
