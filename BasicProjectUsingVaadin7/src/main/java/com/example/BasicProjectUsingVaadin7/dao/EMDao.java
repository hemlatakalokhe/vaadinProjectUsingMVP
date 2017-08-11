package com.example.BasicProjectUsingVaadin7.dao;

import java.util.List;

import com.example.BasicProjectUsingVaadin7.model.CountryEntity;
import com.example.BasicProjectUsingVaadin7.model.StyleEntity;
import com.vaadin.spring.annotation.SpringComponent;


@SpringComponent
public interface EMDao 
{
	List<StyleEntity> checkByStyleNo(StyleEntity styleEntity, CountryEntity countryEntity);

	
	Iterable<StyleEntity> filterByStyleNoAndCountry(String styleNo, CountryEntity country);

}
