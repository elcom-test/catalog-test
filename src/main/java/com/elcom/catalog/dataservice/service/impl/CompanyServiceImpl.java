package com.elcom.catalog.dataservice.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elcom.catalog.dataservice.repository.CompanyRepository;
import com.elcom.catalog.dataservice.root.Company;
import com.elcom.catalog.dataservice.root.dto.CompanyDTO;
import com.elcom.catalog.dataservice.root.dto.CompanyDetachedDTO;
import com.elcom.catalog.dataservice.root.dto.CompanyInfoDTO;
import com.elcom.catalog.dataservice.search.dao.impl.SearchDaoImpl;
import com.elcom.catalog.dataservice.search.model.SearchCriteria;
import com.elcom.catalog.dataservice.search.model.SearchResponse;
import com.elcom.catalog.dataservice.service.CompanyService;

@Service
public class CompanyServiceImpl extends BaseServiceImpl implements CompanyService {
	
	@Autowired
	CompanyRepository companyRepository;

	@Autowired
	private SearchDaoImpl searchDao;
	
	@Override
	public Optional<Company> getCompany(Company company) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CompanyDTO getCompanyById(Long id) {
		Optional<Company> company = companyRepository.findById(id);
		
		if (company.isPresent()) {
			return (CompanyDTO) mapObject(company.get(), CompanyDTO.class);
		}
		return null;
	}

	@Override
	public CompanyDTO saveCompany(CompanyDTO companyDTO) {
		
		Company company = (Company) mapObject(companyDTO, Company.class);
		if (companyDTO.getId() == null) { 
			
			CompanyInfoDTO companyInfo = CompanyInfoDTO.builder().companyName(companyDTO.getCompanyName())
														.companiesHouseNo(companyDTO.getCompaniesHouseNo())
														.dunsNumber(companyDTO.getDunsNo())
														.postCode(companyDTO.getAddress().getPostalCode())
														.build();
			company.setCompanyKey1(generateCompanyKey1(companyInfo));
		}
		
		company = companyRepository.saveAndFlush(company);
			
		return (CompanyDTO) mapObject(company, CompanyDTO.class);
	}

	@Override
	public SearchResponse searchCompany(SearchCriteria searchCriteria) {

		searchCriteria.setFieldToSearch("company.combined");
		searchCriteria.setAdditionalFieldsToSearch(new String[] {"address.postalCode", "address.gln", "address.addressName", "address.city", "address.nutsCode"});
		searchCriteria.setObjectToSearch(Company.class);
		searchCriteria.setObjectToReturn(CompanyDTO.class);
		
		return searchDao.search(searchCriteria);
	}

	@Override
	public CompanyDTO saveDetachedCompany(CompanyDetachedDTO companyDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Company> matchCompanyByCriteria(CompanyInfoDTO companyInfo) {
		
		if (companyInfo==null) {
			return null;
		}
		
		Optional<Company> companyOpt;
		
		// get company by provided id 
		if (companyInfo.getCompanyId() != null) {
			companyOpt = companyRepository.findById(companyInfo.getCompanyId());
			if (companyOpt.isPresent()) {
				return companyOpt;
			}
		}
		
		// Exact match on DUNS number
		if (companyInfo.getDunsNumber() != null) {
			companyOpt = companyRepository.findByDunsNo(companyInfo.getDunsNumber());
			if (companyOpt.isPresent()) {
				return companyOpt;
			}
		}
		
		// Exact match on Companies House number
		if (companyInfo.getCompaniesHouseNo() != null) {
			companyOpt = companyRepository.findByCompaniesHouseNo(companyInfo.getDunsNumber());
			if (companyOpt.isPresent()) {
				return companyOpt;
			}
		}
		
		// Exact match on company name
		if (companyInfo.getCompanyName() != null) {
			companyOpt = companyRepository.findByCompanyNameIgnoreCase(companyInfo.getCompanyName().toLowerCase());
			if (companyOpt.isPresent()) {
				return companyOpt;
			}
		}
				
		// Generate company key and check
		if (companyInfo.getCompanyName() != null) {
			String companyKey = generateCompanyKey1(companyInfo);
			companyOpt = companyRepository.findByCompanyKey1IgnoreCase(companyKey);
			if (companyOpt.isPresent()) {
				return companyOpt;
			}
		}
		
		// Generate alternative company key and check
		//if (companyInfo.getCompanyName() != null) {
		//	String companyKey = generateCompanyKey(companyInfo);
		//}
		return null;
	}
	
	@Override
	public String generateCompanyKey1(CompanyInfoDTO companyInfo) {
		
		String companyName = companyInfo.getCompanyName();
		String postCode = companyInfo.getPostCode();
		
		String companyKey = companyName.toLowerCase();
		companyKey = removeCommonSuffixes(companyKey);
		companyKey = removeWhiteSpace(companyKey);
		
		if (postCode != null) {
			postCode = postCode.toLowerCase();
			postCode = removeWhiteSpace(postCode);
			companyKey = companyKey+postCode;
		}
		
		return companyKey;
	}
	
	private String removeCommonSuffixes(String companyKey) {
		companyKey = companyKey.replaceAll("\s(llc|inc|co|pvt|ltd|private|limited)$","");
		return companyKey;
	}
	
	private String removeWhiteSpace(String companyKey) {
		companyKey = companyKey.replaceAll("\\s","");
		return companyKey;
	}
}
