package edu.neu.csye7374;

public class BearMarketStrategy implements PriceCalculationStrategy {
    @Override
    public double calculatePrice(double currentPrice, double bid) {
        return currentPrice * 0.91 + bid * 0.03; // Example: 9% decrease + 3% of bid
    }
}
