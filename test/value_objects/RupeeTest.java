package value_objects;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RupeeTest {
    @Before
    public void setUp() throws Exception {
        CurrencyConverter.initialize();
    }

    @Test
    public void shouldEquateToDifferentCurrencyBasedOnConversionRate() {
        Rupee rupee = new Rupee(620);
        Dollar dollar = new Dollar(10);

        assertEquals(rupee, dollar);
    }

    @Test
    public void shouldConvertAnotherCurrencyToDollar() {
        assertEquals(900.0, new Rupee(10).getConversionAmount(new Euro()), 0.01);
    }
}
