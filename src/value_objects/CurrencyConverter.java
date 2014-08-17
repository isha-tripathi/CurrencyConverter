package value_objects;

import java.util.HashMap;

public class CurrencyConverter {

    static HashMap<String, Double> conversionRates;

    static void initialize() {
        conversionRates = new HashMap<String, Double>();
        conversionRates.put("Dollar:Euro", 1.35);
        conversionRates.put("Rupee:Euro", 90.0);
        conversionRates.put("Rupee:Dollar", 62.0);
    }

    public static double getConversionRate(String currency1, String currency2) {
        String keyOption1 = currency1 + ":" + currency2;
        String keyOption2 = currency2 + ":" + currency1;
        double conversionRate;
        if(currency1.equals(currency2)) return 1.0;
        if (conversionRates.containsKey(keyOption1)) {
            conversionRate = conversionRates.get(keyOption1);
        } else if (conversionRates.containsKey(keyOption2)) {
            conversionRate = 1 / conversionRates.get(keyOption2);
        } else {
            throw new IllegalArgumentException(
                    String.format("Conversion Rate not available for countries %s and %s", currency1, currency2));
        }
        return (double) Math.round(conversionRate * 1000) / 1000;
    }
}
