package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

abstract class Stock implements Tradable {
    protected String name;
    protected double price;
    protected String description;
    protected List<Double> bids;
    protected PriceCalculationStrategy pricingStrategy;

    public Stock(String name, double price, String description){
        this.name = name;
        this.price = price;
        this.description = description;
        this.bids = new ArrayList<>();
        this.pricingStrategy = new BullMarketStrategy();

    }

    public void setPricingStrategy(PriceCalculationStrategy strategy) {
        this.pricingStrategy = strategy;
    }

    @Override
    public void setBid(String bid) {
        try {
            double bidValue = Double.parseDouble(bid);
            bids.add(bidValue);
            price = pricingStrategy.calculatePrice(price, bidValue);
        } catch (NumberFormatException e) {
            System.out.println("Invalid bid: " + bid);
        }
    }


    //protected abstract double calculatePrice(double bid);

    @Override
    public abstract String getMetric();

    @Override
    public String toString() {
        return String.format("Stock{name='%s', price=%.2f, description='%s', metric='%s'}", name, price, description, getMetric());
    }
}