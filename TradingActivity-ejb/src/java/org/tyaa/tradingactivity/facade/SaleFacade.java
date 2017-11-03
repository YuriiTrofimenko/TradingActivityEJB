/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.tradingactivity.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.tyaa.tradingactivity.entity.Sale;

/**
 *
 * @author student
 */
@Stateless
public class SaleFacade extends AbstractFacade<Sale> {

    @PersistenceContext(unitName = "TradingActivity-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SaleFacade() {
        super(Sale.class);
    }
    
}
