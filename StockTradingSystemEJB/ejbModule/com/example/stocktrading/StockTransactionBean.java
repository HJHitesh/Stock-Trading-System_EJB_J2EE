package com.example.stocktrading;

import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.jms.JMSContext;
import jakarta.jms.Queue;

@Stateless
public class StockTransactionBean {

    @Resource(mappedName = "java:/jms/queue/TradeQueue")
    private Queue tradeQueue;

    @Inject
    private JMSContext jmsContext;

    public void executeTrade(String stockSymbol, int quantity, String orderType) {
        String message = "Trade executed: " + orderType + " " + quantity + " shares of " + stockSymbol;
        jmsContext.createProducer().send(tradeQueue, message);
        System.out.println("Trade executed and message sent to queue: " + message);
    }

    public double getStockPrice(String stockSymbol) {
        return Math.random() * 1000; // Simulated stock price
    }
}
