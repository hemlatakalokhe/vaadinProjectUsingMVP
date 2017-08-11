package com.example.vaadinlogin;


import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

public class LoginPage extends VerticalLayout implements View
{


	private static final long serialVersionUID = 1L;

	@Override
	public void enter(ViewChangeEvent event) {
		//LOGIN PANEL
		Panel panel=new Panel("Login");
		panel.setSizeUndefined();
		addComponent(panel);
		
		//FORM
		FormLayout content=new FormLayout();
		TextField userName=new TextField();
		userName.setInputPrompt("User Name");
		content.addComponent(userName);
		TextField password=new TextField();
		password.setInputPrompt("Password");
		content.addComponent(password);
		
		Button send=new Button("Send");
		send.addClickListener(new ClickListener() {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void buttonClick(ClickEvent event) {
				if(VaadinloginUI.AUTH.authenticate(userName.getValue(),password.getValue()))
				{
					VaadinSession.getCurrent().setAttribute("user", userName.getValue());
					getUI().getNavigator().addView(SecurePage.NAME, SecurePage.class);
					Page.getCurrent().setUriFragment("!"+SecurePage.NAME);
				}
				else
				{
					Notification.show("Invalid Credentials");
				}
			}
		});
		
		content.addComponent(send);
		content.setSizeUndefined();
		content.setMargin(true);
		panel.setContent(content);
		setComponentAlignment(panel	, Alignment.MIDDLE_CENTER);
		
	}
	
}