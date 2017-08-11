package com.example.loginproject;


import java.util.Date;
import java.util.Locale;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class SuccessView extends VerticalLayout implements View {

	private static final long serialVersionUID = 1L;
	public static final String NAME = "Success";

	@Override
	public void enter(ViewChangeEvent event) 
	{
		Label textField = new Label(VaadinSession.getCurrent()
				.getAttribute("userName").toString());
		
		Grid grid=new Grid();
		grid.setColumns("UserName","Date");
		grid.setCaption("User's Data");
		DateField date=new DateField();
		date.setValue(new Date());
		date.setLocale(new Locale("es", "PE"));
		grid.addRow(VaadinSession.getCurrent().getAttribute("userName"),date.getValue().toString());
		grid.setSizeUndefined();
		
		Button logout=new Button("LogOut");
		logout.addClickListener(e->{
			UI.getCurrent().getNavigator().navigateTo("Main");
		});
		HorizontalLayout layout=new HorizontalLayout();
		layout.addComponents(grid,date);
		layout.setSpacing(true);
		
		setSpacing(true);
		setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
		addComponents(textField,layout,logout);
	}

}
