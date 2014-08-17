package value_objects;

public class Dollar extends Currency {

    private final double amount;

    public Dollar(double amount) {
        this.amount = amount;
    }

    public Dollar() {
        this.amount = 0;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if(o instanceof Currency) {
            double conversionRate = CurrencyConverter.getConversionRate(Dollar.class.getSimpleName(), o.getClass().getSimpleName());
            o = new Dollar(((Currency) o).getAmount() * conversionRate);
        }
        if (getClass() != o.getClass()) return false;


        Dollar dollar = (Dollar) o;

        if (Double.compare(dollar.amount, amount) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(amount);
        return (int) (temp ^ (temp >>> 32));
    }
}
