package com.example.loginproject;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;


@SuppressWarnings("serial")
@Theme("mytheme")
public class LoginprojectUI extends UI {

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = LoginprojectUI.class)
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		
	
			new Navigator(this, this);

			getNavigator().addView(MainView.NAME, MainView.class);
			getNavigator().addView(LoginView.NAME, LoginView.class);
			getNavigator().addView(RegisterView.NAME, RegisterView.class);
			getNavigator().addView(SuccessView.NAME, SuccessView.class);
			
			getNavigator().navigateTo(MainView.NAME);
		

	}

}