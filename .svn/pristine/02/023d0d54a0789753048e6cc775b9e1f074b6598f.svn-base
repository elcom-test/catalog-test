package com.elcom.catalog.dataservice.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elcom.catalog.dataservice.repository.TaxTypesRepository;
import com.elcom.catalog.dataservice.root.TaxTypes;
import com.elcom.catalog.dataservice.service.TaxTypesService;

@Service
public class TaxTypesServiceImpl implements TaxTypesService {

	@Autowired
	TaxTypesRepository taxTypesRepository;

	@Override
	public Set<TaxTypes> getDefaultTaxTypes() {
		return taxTypesRepository.getDefaultTaxTypes();
	}

	@Override
	public Optional<TaxTypes> getTaxTypeByPercentage(long percentage) {
		return taxTypesRepository.getTaxTypeByPercentage(percentage);
	}

	@Override
	public Optional<TaxTypes> getTaxTypeByTaxTypeKey(String taxTypeKey) {
		return taxTypesRepository.getTaxTypeByTaxTypeKey(taxTypeKey);
	}

	@Override
	public TaxTypes saveTaxType(TaxTypes taxType) {
		return taxTypesRepository.saveAndFlush(taxType);
	}

	@Override
	public Optional<TaxTypes> getTaxTypeByTaxTypeId(Long taxTypeId) {
		return taxTypesRepository.findById(taxTypeId);
	}

	@Override
	public List<TaxTypes> getAllTaxTypes() {
		return taxTypesRepository.findAll();
	}

	@Override
	public void deleteTaxType(TaxTypes taxType) {
		taxTypesRepository.delete(taxType);
	}
}
