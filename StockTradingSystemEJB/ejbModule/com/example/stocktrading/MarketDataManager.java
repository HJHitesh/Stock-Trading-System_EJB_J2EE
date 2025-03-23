package com.example.stocktrading;

import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.ejb.Schedule;
import jakarta.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Singleton
@Startup
public class MarketDataManager {

    private Map<String, Double> stockPrices = new HashMap<>();

    @PostConstruct
    public void initializeStockData() {
        stockPrices.put("AAPL", 150.00);
        stockPrices.put("GOOGL", 2800.00);
        System.out.println("Initialized stock prices.");
    }

    @Schedule(hour = "*", minute = "*/1", persistent = false)
    public void updateStockPrices() {
        stockPrices.replaceAll((stock, price) -> price + (Math.random() - 0.5) * 10);  // Fluctuation
        System.out.println("Stock prices updated: " + stockPrices);
    }

    public double getPrice(String stockSymbol) {
        return stockPrices.getOrDefault(stockSymbol, 0.0);
    }
}
