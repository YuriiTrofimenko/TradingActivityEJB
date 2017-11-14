/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.tradingactivity.rmi;

import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.tyaa.tradingactivity.entity.*;
import org.tyaa.tradingactivity.facade.BrokerFacade;
import org.tyaa.tradingactivity.facade.CategoryFacade;
import org.tyaa.tradingactivity.facade.SaleFacade;

/**
 *
 * @author student
 */
@Stateless
public class RMISessionBean implements RMISessionBeanRemote {
    
    @EJB
    SaleFacade saleFacade;
    @EJB
    BrokerFacade brokerFacade;
    @EJB
    CategoryFacade categoryFacade;
    
    @Resource(name="jms/TradingActivityFactory")
    private ConnectionFactory connectionFactory;
    
    @Resource(name="jmsTradingActivityWebTopic")
    private Destination destination;


    @Override
    public List getAllSales() {
        return saleFacade.findAll();
    }

    @Override
    public void addSale(Sale _sale, int _brokerId, int _categoryId) {
        
        sendActionString("New sale: " + _sale.getSecurityName());
        Broker broker = brokerFacade.find(_brokerId);
        Category category = categoryFacade.find(_categoryId);
        if(broker != null && category != null) {
            _sale.setBrokerId(broker);
            _sale.setCategoryId(category);
            saleFacade.create(_sale);
        }
    }
    
    public void sendActionString(String _actionString) {
        try {
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
            MessageProducer producer = session.createProducer(destination);
            TextMessage message = session.createTextMessage();
            message.setStringProperty("message_type", "action");
            message.setText(_actionString);
            producer.send(message);
            System.out.println("message sent");
            session.close();
            connection.close();
        } catch (JMSException ex) {
            System.err.println("Sending message error");
            ex.printStackTrace();
        } 
    }
}
