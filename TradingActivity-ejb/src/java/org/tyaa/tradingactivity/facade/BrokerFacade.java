/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.tradingactivity.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.tyaa.tradingactivity.entity.Broker;

/**
 *
 * @author student
 */
@Stateless
public class BrokerFacade extends AbstractFacade<Broker> {

    @PersistenceContext(unitName = "TradingActivity-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BrokerFacade() {
        super(Broker.class);
    }
    
}
