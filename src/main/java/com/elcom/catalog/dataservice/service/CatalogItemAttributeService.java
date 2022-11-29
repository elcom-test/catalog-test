package com.elcom.catalog.dataservice.service;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.elcom.catalog.dataservice.root.CatalogItemAttribute;
import com.elcom.catalog.dataservice.root.dto.CatalogItemAttributeDTO;
import com.elcom.catalog.dataservice.root.dto.CatalogItemAttributeDetachedDTO;

public interface CatalogItemAttributeService {
	
	public Optional<CatalogItemAttribute> getCatalogItemAttribute(CatalogItemAttribute catalogItemAttrib);
	public Optional<CatalogItemAttribute> getICatalogItemAttributeById(Long id);
	public void saveCatalogItemAttrbute(CatalogItemAttribute catalogItemAttrib);
	public void deleteCatalogItemAttribute(Long id);
	public List<CatalogItemAttribute> getAllCatalogItemAttributes();
	public CatalogItemAttributeDTO saveDetachedCatalogItemAttribute(
			CatalogItemAttributeDetachedDTO catalogItemAttribute);
	
}

