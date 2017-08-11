package com.example.loginproject;

import java.util.HashSet;

import com.vaadin.data.Validator;
import com.vaadin.data.Validator.InvalidValueException;
import com.vaadin.data.validator.StringLengthValidator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

public class LoginView extends VerticalLayout implements View {

	private static final long serialVersionUID = 1L;
	protected static final String NAME = "Login";
	private TextField userName;
	private PasswordField password;
	private Label incorrect;
	private Button submit;

	@Override
	public void enter(ViewChangeEvent event) {
		// FormLayout form=new FormLayout();
		userName = new TextField("UserName");
		password = new PasswordField("Password");
		incorrect = new Label();
		submit = new Button("Submit");
		HashSet<String> usernames = new HashSet<String>();
		usernames.add("Hemlata");
		usernames.add("Ayesha");
		usernames.add("Priyanka");

		submit.addClickListener(new ClickListener() {

			
			private static final long serialVersionUID = 1L;

			public void buttonClick(ClickEvent event) {

				/*
				 * userName.addValidator(new
				 * StringLengthValidator("Invalid Username", 4, 10, false));
				 * password.addValidator(new
				 * StringLengthValidator("Incorrect password", 4, 10, false));
				 * getUI().getNavigator().navigateTo(MainView.NAME);
				 */

				userName.addValidator(new Validator() {

					public boolean isValid(Object value) {
						return usernames.contains(value);
					}

					@Override
					public void validate(Object value)
							throws InvalidValueException {
						if (isValid(value)) {
							VaadinSession.getCurrent().setAttribute("userName",
									value);
							VaadinSession.getCurrent().setAttribute("password",
									password.getValue());
							getUI().getNavigator().navigateTo(SuccessView.NAME);
						} else {
							throw new Validator.InvalidValueException(
									"Invalid data");
						}
					}
				});
			}

		});

		setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
		addComponents(userName, password, incorrect, submit);

	}

}
