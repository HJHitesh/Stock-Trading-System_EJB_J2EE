package com.example.stocktrading;


import jakarta.ejb.ActivationConfigProperty;
import jakarta.ejb.MessageDriven;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import jakarta.jms.TextMessage;
import jakarta.jms.JMSException;

@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "jakarta.jms.Queue"),
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:/jms/queue/TradeQueue")
})
public class TradeNotificationMDB implements MessageListener {

    @Override
    public void onMessage(Message message) {
        try {
            if (message instanceof TextMessage) {
                String tradeNotification = ((TextMessage) message).getText();
                System.out.println("Trade Notification Received: " + tradeNotification);
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
