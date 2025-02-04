package edu.neu.csye7374;

public class PharmaStockFactory implements StockFactory {
    @Override
    public Stock createStock(String name, double price, String description) {
        return new PharmaStock(name, price, description);
    }
}