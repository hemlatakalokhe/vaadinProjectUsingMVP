package com.example.vaadinlogin;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

@SuppressWarnings("serial")
@Theme("vaadinlogin")
public class VaadinloginUI extends UI {

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = VaadinloginUI.class)
	public static class Servlet extends VaadinServlet {
	}

	protected static Authentication AUTH = null;

	@Override
	protected void init(VaadinRequest request) {
	
		 AUTH = new Authentication(); 
		    new Navigator(this, this); 

	}

}