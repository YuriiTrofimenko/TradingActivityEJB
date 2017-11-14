/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.tradingactivity.controller.common;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author student
 */
@MessageDriven(
        mappedName="jmsTradingActivityWebTopic",
        name = "IndexMDB")
public class IndexMessageDrivenBean implements MessageListener {
    
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
        } catch (JMSException ex) {
            ex.printStackTrace();
        }
    }
    
}
