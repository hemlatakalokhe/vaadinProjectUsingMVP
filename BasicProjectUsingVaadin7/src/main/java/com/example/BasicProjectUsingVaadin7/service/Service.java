package com.example.BasicProjectUsingVaadin7.service;

import java.util.List;

import com.example.BasicProjectUsingVaadin7.model.ClientEntity;
import com.example.BasicProjectUsingVaadin7.model.CountryEntity;
import com.example.BasicProjectUsingVaadin7.model.ItemEntity;
import com.example.BasicProjectUsingVaadin7.model.ItemSizeEntity;
import com.example.BasicProjectUsingVaadin7.model.SeasonEntity;
import com.example.BasicProjectUsingVaadin7.model.StyleEntity;

public interface Service {

	public void saveStyle(StyleEntity styleEntity);

	public Iterable<StyleEntity> findAllStyles();

	public StyleEntity findByStyleId(Integer id);
	
	public void deleteStyle(Integer id);

	public void saveItemSize(ItemSizeEntity itemSizeEntity);

	public Iterable<ItemSizeEntity> findAllItemSize();

	public ItemSizeEntity findByItemSizeId(Integer id);

	public void saveItem(ItemEntity itemEntity);

	public Iterable<ItemEntity> findAllItems();
	
	StyleEntity findByStyleIdWithItems(Integer styleid);

	public ItemEntity findByItemId(Integer id);
	
	public boolean isStyleExist(StyleEntity styleEntity, CountryEntity countryEntity);
	
	public boolean validateUser(String username,String password);
	
	public List<ItemEntity> findByItemNumber(String itemNo);
}
