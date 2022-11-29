package com.elcom.catalog.dataservice.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elcom.catalog.dataservice.repository.CatalogItemAttributeRepository;
import com.elcom.catalog.dataservice.repository.CatalogItemRepository;
import com.elcom.catalog.dataservice.root.CatalogItem;
import com.elcom.catalog.dataservice.root.CatalogItemAttribute;
import com.elcom.catalog.dataservice.root.dto.CatalogItemAttributeDTO;
import com.elcom.catalog.dataservice.root.dto.CatalogItemAttributeDetachedDTO;
import com.elcom.catalog.dataservice.service.CatalogItemAttributeService;
@Service
public class CatalogItemAttributeServiceImpl extends BaseServiceImpl implements CatalogItemAttributeService {
	
	@Autowired
	CatalogItemAttributeRepository catalogItemAttributeRepository;
	@Autowired
	CatalogItemRepository catalogItemRepository;

	@Override
	public Optional<CatalogItemAttribute> getCatalogItemAttribute(CatalogItemAttribute catalogItemAttrib) {
		// TODO Work out what to implement here
		
		return null;
	}

	@Override
	public Optional<CatalogItemAttribute> getICatalogItemAttributeById(Long id) {
		return catalogItemAttributeRepository.findById(id);
	}

	@Override
	public void saveCatalogItemAttrbute(CatalogItemAttribute catalogItemAttrib) {
		catalogItemAttributeRepository.saveAndFlush(catalogItemAttrib);
	}


	@Override
	public void deleteCatalogItemAttribute(Long id) {
		catalogItemAttributeRepository.deleteById(id);	
	}

	@Override
	public List<CatalogItemAttribute> getAllCatalogItemAttributes() {
		// TODO Auto-generated method stub
		return catalogItemAttributeRepository.findAll();
	}

	@Override
	public CatalogItemAttributeDTO saveDetachedCatalogItemAttribute(
			CatalogItemAttributeDetachedDTO catalogItemAttributeDTO) {
		// TODO Auto-generated method stub

		CatalogItemAttribute catalogItemAttribute = (CatalogItemAttribute) mapObject(catalogItemAttributeDTO, CatalogItemAttribute.class);
		CatalogItem catItem = catalogItemRepository.getById( catalogItemAttributeDTO.getCatalogItemID());
		if (catItem!=null)
		catalogItemAttribute.setCatalogItem(catItem);
		else return null;
		catalogItemAttribute = catalogItemAttributeRepository.saveAndFlush(catalogItemAttribute);
		
		return (CatalogItemAttributeDTO) mapObject(catalogItemAttribute, CatalogItemAttributeDTO.class);			
		
		
	}

}
