package com.elcom.catalog.dataservice.service;

import java.util.List;
import java.util.Optional;

import com.elcom.catalog.dataservice.root.CompanyAddress;

public interface CompanyAddressService {
	
	public Optional<CompanyAddress> getCompanyAddress(CompanyAddress CompanyAddress);
	public Optional<CompanyAddress> getCompanyAddressById(Long id);
	public void saveCompanyAddress(CompanyAddress CompanyAddress);	
	public void saveDetachedCompanyAddress(CompanyAddress CompanyAddress);
	
	// hibernate search methods
	public List<CompanyAddress> searchCompanyAddress(String searchCriteria);



}
