/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.tradingactivity.controller.common;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Locale;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author student
 */
@ManagedBean(name="locale_changer", eager = true)
@SessionScoped
public class LocaleChangerJSFManagedBean implements Serializable {

    private Locale currentLocale =
        FacesContext.getCurrentInstance().getViewRoot().getLocale();
    /**
     * Creates a new instance of LocaleChangerJSFManagedBean
     */
    public LocaleChangerJSFManagedBean() {
        
    }
        
    public void changeLocale(String localeCode) {
        currentLocale = Locale.forLanguageTag(localeCode);
    }
    public Locale getCurrentLocale() {
        return currentLocale;
    }

}
