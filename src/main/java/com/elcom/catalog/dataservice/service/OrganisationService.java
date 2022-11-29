package com.elcom.catalog.dataservice.service;

import java.util.List;
import java.util.Optional;

import com.elcom.catalog.dataservice.root.Organisation;
import com.elcom.catalog.dataservice.root.dto.OrganisationDTO;

public interface OrganisationService {
	public OrganisationDTO getOrganisation(OrganisationDTO organisationDTO);
	public OrganisationDTO getOrganisationById(Long id);
	public void saveOrganisation(OrganisationDTO organisationDTO);	
	// hibernate search methods
	public List<OrganisationDTO> searchOrganisation(String searchCriteria);
	

}
