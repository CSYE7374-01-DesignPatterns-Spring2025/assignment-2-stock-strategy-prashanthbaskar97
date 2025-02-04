package edu.neu.csye7374;

public class EnergyStockStrategy implements PriceCalculationStrategy {
    @Override
    public double calculatePrice(double currentPrice, double bid) {

        return currentPrice * 0.95 + bid * 0.02; // 5 % percent decrease + 2% bid
    }
}
