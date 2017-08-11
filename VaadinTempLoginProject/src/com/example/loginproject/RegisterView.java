package com.example.loginproject;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.VerticalLayout;

public class RegisterView extends VerticalLayout implements View{

	private static final long serialVersionUID = 1L;
	public static final String NAME = "Register";

	private FormLayout form;
	private TextField userName;
	private PasswordField password;
	private PasswordField cpassword;
	private Button submit;
	
	@Override
	public void enter(ViewChangeEvent event) 
	{
		System.out.println("Hemlata");
		form=new FormLayout();
		userName=new TextField("User Name");
		password=new PasswordField("Enter Password");
		cpassword=new PasswordField("Confirm Password");
		submit=new Button("SUBMIT");
		
		submit.addClickListener(new ClickListener() {
			
			public void buttonClick(ClickEvent event) {
				if(password.getValue().equals(cpassword.getValue()))
				{
					UI.getCurrent().getNavigator().navigateTo("Main");
				}
				else
				{
					Notification.show("Invalid Password", Type.ERROR_MESSAGE);
				}
			}
		});
		
		form.addComponents(userName,password,cpassword,submit);
		addComponent(form);
		
	}

}
