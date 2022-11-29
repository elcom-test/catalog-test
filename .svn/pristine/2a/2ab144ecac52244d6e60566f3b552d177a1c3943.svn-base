package com.elcom.catalog.dataservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.elcom.catalog.dataservice.root.Company;
@Repository
@Transactional
public interface CompanyRepository extends JpaRepository<Company, Long> {
	public Optional<Company> findByDunsNo(String dunsNo);
	public Optional<Company> findByCompaniesHouseNo(String companiesHouseNo);
	public Optional<Company> findByCompanyNameIgnoreCase(String companyName);
	public Optional<Company> findByCompanyKey1IgnoreCase(String companyKey);
	public Optional<Company> findByCompanyKey2IgnoreCase(String companyKey);
}
