package com.example.loginproject;

import com.vaadin.client.widgets.Grid;
import com.vaadin.data.Validator;
import com.vaadin.data.Validator.InvalidValueException;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
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
		
		form=new FormLayout();
		form.setCaption("Registration Form");
		
		userName=new TextField("User Name");
		userName.setRequired(true);
		password=new PasswordField("Enter Password");
		password.setRequired(true);
		cpassword=new PasswordField("Confirm Password");
		cpassword.setRequired(true);
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
		setMargin(true);
		
		form.addComponents(userName,password,cpassword,submit);
		form.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
		setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
		addComponent(form);
		
		
	}

}
