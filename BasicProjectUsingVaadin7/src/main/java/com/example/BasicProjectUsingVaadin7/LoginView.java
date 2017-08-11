package com.example.BasicProjectUsingVaadin7;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.BasicProjectUsingVaadin7.impl.SpringDataServiceImpl;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Page;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class LoginView extends VerticalLayout implements View{

	private static final long serialVersionUID = 1L;
	public static final String NAME = "Login";
	private TextField username;
	private PasswordField password;
	private Button submit;
	
	@Autowired
	private SpringDataServiceImpl serviceImpl;

	@Override
	public void enter(ViewChangeEvent event) {
		
		FormLayout loginForm=new FormLayout();
		username=new TextField("Enter User Name");
		
		password=new PasswordField("Enter Password");
		
		submit=new Button("LogIn");
		
		System.out.println(username.getValue());
		submit.addClickListener(e->{
			if(serviceImpl.validateUser(username.getValue(), password.getValue()))
			{
				getUI().getNavigator().addView(StyleView.NAME, StyleView.class);
				getUI().getNavigator().navigateTo(
						StyleView.NAME);
			}
			else
			{
				new Notification("Invalid User name/password","",
					    Notification.Type.ERROR_MESSAGE, true)
					    .show(Page.getCurrent());
			}
		});
		
		submit.setStyleName(ValoTheme.BUTTON_PRIMARY);
		
		loginForm.addComponents(username,password,submit);
		loginForm.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
		addComponent(loginForm);
		
	}
	

}
