/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.tradingactivity.rmi;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.tyaa.tradingactivity.facade.SaleFacade;

/**
 *
 * @author student
 */
@Stateless
public class RMISessionBean implements RMISessionBeanRemote {
    
    @EJB
    SaleFacade saleFacade;

    @Override
    public List getAllSales() {
        return saleFacade.findAll();
    }
}
