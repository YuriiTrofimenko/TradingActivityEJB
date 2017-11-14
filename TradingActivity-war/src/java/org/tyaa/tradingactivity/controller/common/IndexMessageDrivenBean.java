/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.tradingactivity.controller.common;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import org.omnifaces.cdi.Push;
import org.omnifaces.cdi.PushContext;

/**
 *
 * @author student
 */
@MessageDriven(
        mappedName="jms/TradingActivityWebTopic",
        name = "IndexMDB")
public class IndexMessageDrivenBean implements MessageListener {
    
    @Inject @Push(channel="new_sale_channel")
    private PushContext newSalesChannel;

    public IndexMessageDrivenBean() {
    }
    
    @Override
    public void onMessage(Message _message) {
        try {
            TextMessage message = (TextMessage)_message;
            //считываем свойство из соответствующего поля, заданное вручную в consumer
            System.out.println("FROM MDB - message type IS " + message.getStringProperty("message_type"));
            //считываем  само сообщение
            System.out.println("FROM MDB - payload  IS " + message.getText());
            //send data to the WebSocket channel
            newSalesChannel.send(message.getText());
        } catch (JMSException ex) {
            ex.printStackTrace();
        }
    }
    
}
