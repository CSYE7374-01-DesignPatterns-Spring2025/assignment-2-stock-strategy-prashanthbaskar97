package edu.neu.csye7374;

public class AutoStockStrategy implements PriceCalculationStrategy {
    @Override
    public double calculatePrice(double currentPrice, double bid) {

        return currentPrice * 0.99 + bid * 0.04; // 1% decrease plus 4% of bid
    }
}