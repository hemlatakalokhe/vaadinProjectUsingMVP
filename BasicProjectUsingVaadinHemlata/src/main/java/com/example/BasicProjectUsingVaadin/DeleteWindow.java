package com.example.BasicProjectUsingVaadin;

import java.util.Set;
import com.example.BasicProjectUsingVaadin.model.StyleEntity;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.BasicProjectUsingVaadin.impl.SpringDataServiceImpl;
import com.vaadin.server.VaadinSession;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

@SpringComponent
public class DeleteWindow extends Window
{
	private static final long serialVersionUID = 1L;
	public static final String NAME = "Delete";
	@Autowired
	private SpringDataServiceImpl serviceImpl;
	
	private int id=0;
	private Label label;
	private Button yes;
	private Button no;

	public DeleteWindow() {
		center();
		
		VerticalLayout layout=new VerticalLayout();
		HorizontalLayout horizontalLayout=new HorizontalLayout();
		label=new Label("Do you want to continue..");
		
		yes=new Button("Yes");
		no=new Button("No");
		
		yes.addClickListener(e->{
			@SuppressWarnings("unchecked")
			Set<StyleEntity> style=(Set<StyleEntity>) VaadinSession.getCurrent().getAttribute("styleData");
			for (StyleEntity styleEntity : style) {
				id=styleEntity.getId();
				serviceImpl.deleteStyle(id);
			}
			close();
		});
		
		no.addClickListener(e1->{
			close();
		});
		
		horizontalLayout.addComponents(yes,no);
		layout.addComponents(label,horizontalLayout);
		setContent(layout);
		
		
	}

	
}
