/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.tradingactivity.rmi;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
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

    @Override
    public List getAllSales() {
        return saleFacade.findAll();
    }

    @Override
    public void addSale(Sale _sale, int _brokerId, int _categoryId) {
        
        Broker broker = brokerFacade.find(_brokerId);
        Category category = categoryFacade.find(_categoryId);
        if(broker != null && category != null) {
            _sale.setBrokerId(broker);
            _sale.setCategoryId(category);
            saleFacade.create(_sale);
        }
    }
}
