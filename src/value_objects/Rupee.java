package value_objects;

public class Rupee extends Currency {

    private final double amount;

    public Rupee(double amount) {
        this.amount = amount;
    }

    public Rupee() {
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
            double conversionRate = CurrencyConverter.getConversionRate(Rupee.class.getSimpleName(), o.getClass().getSimpleName());
            o = new Rupee(((Currency) o).getAmount() * conversionRate);
        }
        if (getClass() != o.getClass()) return false;


        Rupee rupee = (Rupee) o;

        if (Double.compare(rupee.amount, amount) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(amount);
        return (int) (temp ^ (temp >>> 32));
    }
}
