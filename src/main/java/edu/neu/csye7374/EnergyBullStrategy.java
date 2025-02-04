package edu.neu.csye7374;

public class EnergyBullStrategy implements PriceCalculationStrategy{
    @Override
    public double calculatePrice(double current_Price, double bid) {
        return current_Price * 0.84 + bid * 0.03;
    }
}
