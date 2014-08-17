package value_objects;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EuroTest {

    @Before
    public void setUp() throws Exception {
        CurrencyConverter.initialize();
    }

    @Test
    public void shouldEquateEurosOfSameValue() {
        assertEquals(new Euro(10), new Euro(10));
    }

    @Test
    public void shouldNotEquateEurosWithDifferentValues() {
        assertNotEquals(new Euro(10), new Euro(5));
    }

    @Test
    public void shouldNotEquateEuroToNull() {
        assertFalse(new Euro(10).equals(null));
    }

    @Test
    public void shouldEquateEuroOnlyToOtherEuros() {
        assertNotEquals(new Euro(10), new Object());
    }

    @Test
    public void shouldAddTwoEuros() {
        assertEquals(new Euro(10), new Euro(7).add(new Euro(3)));
        assertNotEquals(new Euro(10), new Euro(3).add(new Euro(4)));
    }

    @Test
    public void shouldConvertAnotherCurrencyToEuro() {
        assertEquals(7.4, new Euro(10).getConversionAmount(new Dollar()), 0.01);
    }

    @Test
    public void shouldBeAbleToCompareWithDifferentCurrencyBasedOnConversionRate() {
        assertTrue(new Euro(10).equals(new Dollar(13.5)));
    }
}
