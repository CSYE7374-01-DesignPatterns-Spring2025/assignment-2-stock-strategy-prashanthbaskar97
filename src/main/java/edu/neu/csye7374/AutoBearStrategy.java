package edu.neu.csye7374;

public class AutoBearStrategy implements PriceCalculationStrategy{

    @Override
    public double calculatePrice(double current_Price, double bid) {
        return current_Price * 0.95 + bid * 0.05;
    }
}
