package value_objects;


public abstract class Currency {

    abstract double getAmount();

    public double getConversionAmount(Currency currency) {
        double conversionRate = CurrencyConverter.getConversionRate(this.getClass().getSimpleName(), currency.getClass().getSimpleName());
        return getAmount() * conversionRate;
    }
}
