package edu.neu.csye7374;

public class AutoBullStrategy implements  PriceCalculationStrategy{
    @Override
    public double calculatePrice(double current_Price, double bid) {
        return current_Price * 0.98 + bid * 0.02;
    }
}
