package value_objects;

public class Euro extends Currency {

    private final double amount;

    public Euro(double amount) {
        this.amount = amount;
    }

    public Euro() {
        amount = 0;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if(o instanceof Currency) {
            double conversionRate = CurrencyConverter.getConversionRate(Euro.class.getSimpleName(), o.getClass().getSimpleName());
            o = new Euro(((Currency) o).getAmount() * conversionRate);
        }
        if (getClass() != o.getClass()) return false;

        Euro euro = (Euro) o;

        if (Double.compare(Math.round(euro.amount*100)/100, amount) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(amount);
        return (int) (temp ^ (temp >>> 32));
    }

    public Euro add(Euro euro) {
        return new Euro(this.amount + euro.amount);
    }
}
