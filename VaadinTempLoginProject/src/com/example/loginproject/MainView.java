package com.example.loginproject;

import java.io.File;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FileResource;
import com.vaadin.server.Resource;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Image;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.themes.ValoTheme;

@Theme("mytheme")
public class MainView extends VerticalLayout implements View {
	private static final long serialVersionUID = 1L;
	public static final String NAME = "Main";
	private Button login;
	private Button register;

	public void enter1(ViewChangeEvent event) {
	}

	public MainView() {
		/*
		 * String basepath = VaadinService.getCurrent()
		 * .getBaseDirectory().getAbsolutePath();
		 * 
		 * FileResource resource = new FileResource(new File(basepath +
		 * "/WEB-INF/images/welcome.png"));
		 * 
		 * 
		 * Image image = new Image(null, resource);
		 * 
		 * image.setWidth("20%"); image.setHeight("20%");
		 */
		System.out.println("In main view");
		/*
		 *  * String basepath = VaadinService.getCurrent()
		 * .getBaseDirectory().getAbsolutePath();
		 * 
		 * FileResource resource = new FileResource(new File(basepath +
		 * "/WEB-INF/images/welcome.png"));
		 * 
		 * 
		 * Image image = new Image(null, resource);
		 * 
		 * image.setWidth("20%"); image.setHeight("20%");
		
		  image.setWidth("20%"); image.setHeight("20%"); */
		System.out.println("login button");
		login = new Button("submit");

		login.addClickListener(new ClickListener() {

			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(LoginView.NAME);
			}
		});
		register = new Button("Register");

		register.addClickListener(new ClickListener() {

			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(RegisterView.NAME);
			}
		});
		register.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
		login.setStyleName("Login");
		setSpacing(true);
		// setSizeUndefined();
		setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
		// setStyleName("backColorGrey");
		addComponents(login, register);
	}

	@Override
	public void enter(ViewChangeEvent event) {
	}

}
