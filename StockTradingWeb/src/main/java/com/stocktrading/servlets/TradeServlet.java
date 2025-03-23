package com.stocktrading.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.example.stocktrading.StockTransactionBean;
import com.example.stocktrading.TradingSessionBean;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/trading")
public class TradeServlet extends HttpServlet {

    @EJB
    private TradingSessionBean tradingSession;

    @EJB
    private StockTransactionBean stockTransaction;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if ("viewHistory".equals(action)) {
            List<String> history = tradingSession.getOrderHistory();
            request.setAttribute("history", history);
            request.getRequestDispatcher("history.jsp").forward(request, response);
        } else if ("getPrice".equals(action)) {
            String symbol = request.getParameter("symbol");
            double price = stockTransaction.getStockPrice(symbol);
            out.println("<h3>Stock Price for " + symbol + ": $" + price + "</h3>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String stockSymbol = request.getParameter("stockSymbol");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String orderType = request.getParameter("orderType");

        tradingSession.placeOrder(stockSymbol, quantity, orderType);
        stockTransaction.executeTrade(stockSymbol, quantity, orderType);

        request.getRequestDispatcher("notification.jsp").forward(request, response);
    }
}