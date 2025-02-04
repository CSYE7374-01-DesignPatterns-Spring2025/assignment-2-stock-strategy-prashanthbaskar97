package edu.neu.csye7374;

import java.util.HashMap;
import java.util.Map;

class StockMarket {
    private static StockMarket instance;
    private final Map<String, Stock> stocks;

    private StockMarket() {
        stocks = new HashMap<>();
    }

    public static StockMarket getInstance() {
        if (instance == null) {
            synchronized (StockMarket.class) {
                if (instance == null) {
                    instance = new StockMarket();
                }
            }
        }
        return instance;
    }

    public void addStock(Stock stock) {
        stocks.put(stock.name, stock);
    }

    public void removeStock(String name) {
        stocks.remove(name);
    }

    public void tradeStock(String name, String bid) {
        Stock stock = stocks.get(name);
        if (stock != null) {
            stock.setBid(bid);
        } else {
            System.out.println("Stock not found: " + name);
        }
    }

    public void showAllStocks() {
        stocks.values().forEach(System.out::println);

    }

    public static void demo() {
//        StockMarket market = StockMarket.getInstance();
//
////        StockFactory techFactory = new TechStockFactory();
////        StockFactory pharmaFactory = new PharmaStockFactory();
//        StockFactory autoFactory = AutoStockFactoryLazySingleton.getInstance();
//        StockFactory energyFactory = EnergyStockFactoryEagerSingleton.getInstance();
//
////        Stock techStock = techFactory.createStock("IBM", 131.15, "IBM Common Stock");
////        Stock pharmaStock = pharmaFactory.createStock("Pfizer", 50.75, "Pfizer Pharma Stock");
//        Stock autoStock = autoFactory.createStock("Tesla", 720.50, "Tesla Auto Stock");
//        Stock energyStock = energyFactory.createStock("NationalGrid", 290.50, "NationalGrid Energy Stock");
//
////        market.addStock(techStock);
////        market.addStock(pharmaStock);
//        market.addStock(autoStock);
//        market.addStock(energyStock);
//
//        String[] bids = {"10", "20", "30", "40", "50", "60"};
////
////        for (String bid : bids) {
////            System.out.println("Bid: " + bid);
//////            market.tradeStock("IBM", bid);
//////            market.tradeStock("Pfizer", bid);
////            market.tradeStock("Tesla", bid);
////            market.tradeStock("NationalGrid", bid);
////            market.showAllStocks();
////            System.out.println();
////        }
////        market.removeStock("IBM");
//        market.removeStock("Tesla");
//        System.out.println("After removing the stocks we are left with - ");
//        market.showAllStocks();
//    }
//


//        StockMarket market = StockMarket.getInstance();
//
//        StockFactory autoFactory = AutoStockFactoryLazySingleton.getInstance();
//        StockFactory energyFactory = EnergyStockFactoryEagerSingleton.getInstance();
//
//        System.out.println("Creating stocks with default strategies:");
//        Stock autoStock = autoFactory.createStock("Tesla", 700.50, "EV Manufacturer");
//        Stock energyStock = energyFactory.createStock("NationalGrid", 250.50, "Energy Provider");
//
//        System.out.println("\nInitial Strategies:");
//        market.addStock(autoStock);
//        market.addStock(energyStock);
//        market.showAllStocks();
//
//        System.out.println("\n=== Applying Bear Market Strategy to Auto Stock ===");
//        autoStock.setPricingStrategy(new AutoBearStrategy());
//        market.tradeStock("Tesla", "700");
//        market.showAllStocks();
//
//        System.out.println("\n=== Applying Bull Market Strategy to Energy Stock ===");
//        energyStock.setPricingStrategy(new EnergyBullStrategy());
//        market.tradeStock("NationalGrid", "300");
//        market.showAllStocks();
//
//        System.out.println("\n=== Mixed Strategy Trading Session ===");
//        String[] bids = {"710", "690", "730", "750"};
//        for (String bid : bids) {
//            System.out.println("\nProcessing bid: " + bid);
//            autoStock.setPricingStrategy(
//                    bid.contains("7") ? new AutoBullStrategy() : new AutoBearStrategy()
//            );
//            energyStock.setPricingStrategy(
//                    bid.contains("7") ? new EnergyBearStrategy() : new EnergyBullStrategy()
//            );
//
//            market.tradeStock("Tesla", bid);
//            market.tradeStock("NationalGrid", bid);
//            market.showAllStocks();
//        }



        StockMarket market = StockMarket.getInstance();

        StockFactory autoFactory = AutoStockFactoryLazySingleton.getInstance();
        StockFactory energyFactory = EnergyStockFactoryEagerSingleton.getInstance();

        // Create stocks with default strategies from factories
        Stock autoStock = autoFactory.createStock("Tesla", 700.50, "EV Manufacturer");
        Stock energyStock = energyFactory.createStock("Exxon", 85.0, "Oil & Gas");

        market.addStock(autoStock);
        market.addStock(energyStock);

        System.out.println("=== Initial Default Strategies ===");
        market.showAllStocks();


        PriceCalculationStrategy bullStrategy = new BullMarketStrategy();
        PriceCalculationStrategy bearStrategy = new BearMarketStrategy();
        PriceCalculationStrategy autoStrategy = new AutoStockStrategy();
        PriceCalculationStrategy energyStrategy = new EnergyStockStrategy();

        String[] bids = {"10", "20", "30", "40", "50", "60"};



        System.out.println("\n=== Default Strategy Simulation: ===");
        autoStock.setPricingStrategy(autoStrategy);
        energyStock.setPricingStrategy(energyStrategy);
        simulateMarket(market, bids);

        // Demonstrate strategy switching


        System.out.println("\n=== Bear Market Simulation: ===");
        autoStock.setPricingStrategy(bearStrategy);
        energyStock.setPricingStrategy(bearStrategy);
        simulateMarket(market, bids);




        System.out.println("\n=== Bull Market Simulation: ===");
        autoStock.setPricingStrategy(bullStrategy);
        energyStock.setPricingStrategy(bullStrategy);
        simulateMarket(market, bids);



        System.out.println("\n=== Energy Stock Strategy Switching ===");
        energyStock.setPricingStrategy(new EnergyBearStrategy());
        market.tradeStock("Exxon", "80");
        market.showAllStocks();


    }

    private static void simulateMarket(StockMarket market, String[] bids) {
        for (String bid : bids) {
            System.out.println("Bid: " + bid);
            market.tradeStock("Tesla", bid);
            market.tradeStock("Exxon", bid);
            market.showAllStocks();
            System.out.println();
        }
    }
}
