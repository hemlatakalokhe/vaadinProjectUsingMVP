package com.example.SpringVaadinDemo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

@SpringView(name=MainView.NAME)
public class MainView extends VerticalLayout implements View {

	protected static final String NAME = "Main";

	@Autowired
	private TestAnnotationClass testAnnotationClass;

	private Label label;

	

	
	  @PostConstruct public void init()
	  {
		 // System.out.println(testAnnotationClass.message());
		  label = new Label("Welcome to " + testAnnotationClass.message());
			addComponent(label);
	  }

	@Override
	public void enter(ViewChangeEvent event) {

		// addComponent(new Label("Welcome to "+testAnnotationClass.message()));
	}

}
