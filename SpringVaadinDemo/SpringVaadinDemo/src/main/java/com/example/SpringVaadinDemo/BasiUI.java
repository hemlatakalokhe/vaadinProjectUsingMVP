package com.example.SpringVaadinDemo;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@SpringUI
public class BasiUI extends UI {

	@Autowired
	private SpringViewProvider viewProvider;


	@Override
	protected void init(VaadinRequest vaadinRequest) {
		final VerticalLayout root = new VerticalLayout();
		root.setSizeFull();
		root.setMargin(true);
		root.setSpacing(true);
		setContent(root);

		final CssLayout navigationBar = new CssLayout();
		
		navigationBar.addComponent(createNavigationButton("Main",
				MainView.NAME));
		
		root.addComponent(navigationBar);


		Navigator navigator = new Navigator(this, this);
		navigator.addProvider(viewProvider);
	}

	private Button createNavigationButton(String caption, final String viewName) {
		Button button = new Button(caption);
		button.addStyleName(ValoTheme.BUTTON_SMALL);
		
		button.addClickListener(event -> getUI().getNavigator().navigateTo(
				viewName));
		
		return button;
	}

}
