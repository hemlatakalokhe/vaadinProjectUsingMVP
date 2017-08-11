package com.example.BasicProjectUsingVaadin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.BasicProjectUsingVaadin.impl.MasterServiceImpl;
import com.example.BasicProjectUsingVaadin.impl.SpringDataServiceImpl;
import com.example.BasicProjectUsingVaadin.model.CountryEntity;
import com.example.BasicProjectUsingVaadin.model.ItemSizeEntity;
import com.vaadin.data.provider.DataProvider;
import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.VaadinSession;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

@SpringView(name=StyleView.NAME)
public class StyleView extends VerticalLayout implements View
{

	private static final long serialVersionUID = 1L;
	public static final String NAME = "Style";
	private Label label;
	
	@Autowired
	private MasterServiceImpl masterServiceImpl;
	
	@Autowired
	private SpringDataServiceImpl serviceImpl;
	
	
	@Override
	public void enter(ViewChangeEvent event) 
	{	
		TextField filter=new TextField();
			
			Iterable<ItemSizeEntity>people = serviceImpl.findAllItemSize();
	
			String id=(String) VaadinSession.getCurrent().getSession().getAttribute("username");
			
			System.out.println(id);
			
		/*Grid<ItemSizeEntity> grid=new Grid<ItemSizeEntity>(ItemSizeEntity.class);
		
        ListDataProvider<ItemSizeEntity> dataProvider = DataProvider.ofCollection((Collection<ItemSizeEntity>) people);
        grid.setDataProvider(dataProvider);
        
        filter.addValueChangeListener(e -> {
            dataProvider.setFilter(ItemSizeEntity::getQuantity, quantity -> {
                if (quantity == null) {
                    return false;
                }
                String a =quantity.toString();
                String filterLower = e.getValue();
                return  a.equals(filterLower);
            });
        });
        grid.setSizeFull();*/
		//addComponents(filter,grid);
	}
	
}


