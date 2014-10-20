package com.williansmartins.erro;

import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

@ManagedBean(name="languageBean")
public class Language {
 
	
    public Language() {
    }

    public void es(){
    	UIViewRoot viewRoot = FacesContext.getCurrentInstance().getViewRoot();
    	viewRoot.setLocale(new Locale("es"));
    }
    public void en(){
    	UIViewRoot viewRoot = FacesContext.getCurrentInstance().getViewRoot();
    	viewRoot.setLocale(new Locale("en"));
    }
}
