package edu.neu.csye7374;

public class EnergyBearStrategy implements PriceCalculationStrategy{
    @Override
    public double calculatePrice(double current_Price, double bid) {
        return current_Price * 0.80 + bid * 0.05;
    }
}
