/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.tradingactivity.controller;

import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.tyaa.tradingactivity.entity.Category;
import org.tyaa.tradingactivity.entity.Sale;
import org.tyaa.tradingactivity.facade.CategoryFacade;
import org.tyaa.tradingactivity.facade.SaleFacade;

/**
 *
 * @author student
 */
/*@Named(value = "indexJSFManagedBean")*/
@ManagedBean(name = "order_data", eager = false)
@ApplicationScoped
public class OrderJSFManagedBean {

    /**
     * Creates a new instance of IndexJSFManagedBean
     */
    public OrderJSFManagedBean() {
    }

    @EJB
    SaleFacade saleFacade;

    public Sale getSale() {
        
        Sale sale = null;
        Map<String, String> params
            = FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap();
        if (params.containsKey("sale_id")) {
            sale = saleFacade.find(Integer.valueOf(params.get("sale_id")));
        }
        return sale;
    }
}
