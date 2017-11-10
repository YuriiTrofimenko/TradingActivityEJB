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
import org.tyaa.tradingactivity.facade.CategoryFacade;
import org.tyaa.tradingactivity.facade.SaleFacade;

/**
 *
 * @author student
 */
/*@Named(value = "indexJSFManagedBean")*/
@ManagedBean(name = "index_data", eager = true)
@ApplicationScoped
public class IndexJSFManagedBean {

    /**
     * Creates a new instance of IndexJSFManagedBean
     */
    public IndexJSFManagedBean() {
    }

    @EJB
    SaleFacade saleFacade;
    @EJB
    CategoryFacade categoryFacade;

    public List getAllSales() throws InterruptedException {
        
        Thread.sleep(1000);
        Map<String, String> params
            = FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap();
        if (params.containsKey("category_id")) {
            Category category
                = categoryFacade.find(Integer.valueOf(params.get("category_id")));
            return (List) category.getSaleCollection();
        }
        return saleFacade.findAll();
    }

    public List getAllCategories() {
        return categoryFacade.findAll();
    }
}
