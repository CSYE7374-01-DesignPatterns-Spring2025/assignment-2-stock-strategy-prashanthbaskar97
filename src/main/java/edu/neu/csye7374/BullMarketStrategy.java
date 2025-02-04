package edu.neu.csye7374;

public class BullMarketStrategy implements PriceCalculationStrategy {
    @Override
    public double calculatePrice(double currentPrice, double bid) {
        return currentPrice * 1.07 + bid * 0.04; // Example: 7% increase + 4% of bid
    }
}
