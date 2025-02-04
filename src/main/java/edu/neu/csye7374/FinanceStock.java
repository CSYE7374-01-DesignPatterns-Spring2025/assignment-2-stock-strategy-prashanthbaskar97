package edu.neu.csye7374;


class FinanceStock extends Stock {
    public FinanceStock(String name, double price, String description) {
        super(name, price, description);
    }

//    @Override
//    protected double calculateNewPrice(double bid) {
//        return price * 0.88 + bid * 0.06;
//    }

    @Override
    public String getMetric() {
        return String.format("%.2f",price * Math.log(bids.size() + 1));
    }
}
