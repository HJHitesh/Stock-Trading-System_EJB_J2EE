package com.stocktrading.servlets;

import java.io.IOException;

import com.example.stocktrading.TradingSessionBean;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
    @EJB
    private TradingSessionBean tradingSession;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        tradingSession.setUsername(username);

        HttpSession session = request.getSession();
        session.setAttribute("username", username);

        response.sendRedirect("dashboard.jsp");
    }
}

