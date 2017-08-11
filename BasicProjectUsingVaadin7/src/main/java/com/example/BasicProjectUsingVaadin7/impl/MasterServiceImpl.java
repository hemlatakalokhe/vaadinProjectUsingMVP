package com.example.BasicProjectUsingVaadin7.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.BasicProjectUsingVaadin7.model.ClientEntity;
import com.example.BasicProjectUsingVaadin7.model.CountryEntity;
import com.example.BasicProjectUsingVaadin7.model.SeasonEntity;
import com.example.BasicProjectUsingVaadin7.model.SizeEntity;
import com.example.BasicProjectUsingVaadin7.repository.ClientRepository;
import com.example.BasicProjectUsingVaadin7.repository.CountryRepository;
import com.example.BasicProjectUsingVaadin7.repository.SeasonRepository;
import com.example.BasicProjectUsingVaadin7.repository.SizeRepository;
import com.example.BasicProjectUsingVaadin7.service.MasterService;
import com.vaadin.spring.annotation.SpringComponent;

@SpringComponent
public class MasterServiceImpl implements MasterService {
	@Autowired
	private SeasonRepository seasonRepository;

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private SizeRepository sizeRepository;

	@SuppressWarnings("unused")
	@Autowired
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public Iterable<SeasonEntity> findAllSeason() {
		// TODO Auto-generated method stub
		return seasonRepository.findAll();
	}

	@Override
	public Iterable<CountryEntity> findAllCountry() {
		// TODO Auto-generated method stub
		return countryRepository.findAll();
	}

	@Override
	public Iterable<ClientEntity> findAllClient() {
		// TODO Auto-generated method stub
		return clientRepository.findAll();
	}

	@Override
	public SeasonEntity findSeasonById(Integer id) {
		// TODO Auto-generated method stub
		return seasonRepository.findOne(id);
	}

	@Override
	public CountryEntity findCountryById(Integer id) {
		// TODO Auto-generated method stub
		return countryRepository.findOne(id);
	}

	@Override
	public ClientEntity findClientById(Integer id) {
		// TODO Auto-generated method stub
		return clientRepository.findOne(id);
	}

	@Override
	public Iterable<SizeEntity> findAllSize() {
		// TODO Auto-generated method stub
		return sizeRepository.findAll();
	}

	@Override
	public SizeEntity findSizeById(Integer id) {
		// TODO Auto-generated method stub
		return sizeRepository.findOne(id);
	}
	
	
}
