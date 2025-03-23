package com.example.stocktrading;

import jakarta.ejb.Stateful;
import java.util.ArrayList;
import java.util.List;

@Stateful
public class TradingSessionBean {

    private String username;
    private List<String> watchlist = new ArrayList<>();
    private List<String> orderHistory = new ArrayList<>();
    
    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void addStockToWatchlist(String stockSymbol) {
        watchlist.add(stockSymbol);
    }

    public void placeOrder(String stockSymbol, int quantity, String orderType) {
        String order = "Order: " + orderType + " " + quantity + " shares of " + stockSymbol;
        orderHistory.add(order);
        System.out.println("Order placed: " + order);
    }

    public List<String> getOrderHistory() {
        return orderHistory;
    }

    public List<String> getWatchlist() {
        return watchlist;
    }
}
