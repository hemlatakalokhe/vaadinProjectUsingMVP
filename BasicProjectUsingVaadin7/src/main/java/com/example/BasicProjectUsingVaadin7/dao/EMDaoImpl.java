package com.example.BasicProjectUsingVaadin7.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.example.BasicProjectUsingVaadin7.model.CountryEntity;
import com.example.BasicProjectUsingVaadin7.model.StyleEntity;
import com.vaadin.spring.annotation.SpringComponent;

@SpringComponent
public class EMDaoImpl implements EMDao {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<StyleEntity> checkByStyleNo(StyleEntity styleEntity, CountryEntity countryEntity) {
		Query query = entityManager.createQuery(
				"SELECT s FROM StyleEntity s WHERE 1 = 1 AND s.styleNo=:styleNumber AND s.country=:countryId");
		query.setParameter("styleNumber", styleEntity.getStyleNo());
		query.setParameter("countryId", countryEntity);

		@SuppressWarnings("unchecked")
		List<StyleEntity> styleEntities = query.getResultList();
		return styleEntities;
	}

	@Override
	public List<StyleEntity> filterByStyleNoAndCountry(String styleNo, CountryEntity country) {

		
		
		
		StringBuffer sb = new StringBuffer();
		Query query = null;
		sb.append("SELECT s  FROM StyleEntity s WHERE  1 = 1 ");
		
		if(styleNo.equals("")){
		}
		else
		{
			sb.append(" AND s.styleNo=:styleNumber");
			
		}
		
		if (country != null) {
			sb.append(" AND s.country=:country  ");
			
		} 
		query = entityManager.createQuery(sb.toString());
	
		if(styleNo.equals("")){
			
		}
		else
		{
			query.setParameter("styleNumber", styleNo);
			
		}
		if (country != null) {
		query.setParameter("country", country);
		}
		
		
		@SuppressWarnings("unchecked")
		List<StyleEntity> styles = query.getResultList();
		return styles;
	}

}
