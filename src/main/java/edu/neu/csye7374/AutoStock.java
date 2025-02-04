package edu.neu.csye7374;


class AutoStock extends Stock {
    public AutoStock(String name, double price, String description) {
        super(name, price, description);
        this.pricingStrategy = new AutoStockStrategy();
    }

    @Override
    public String getMetric() {
        return String.format("%.2f",price * Math.log(bids.size() + 1));
    }
}
