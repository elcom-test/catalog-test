package com.elcom.catalog.dataservice.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elcom.catalog.dataservice.repository.CatalogItemPriceRepository;
import com.elcom.catalog.dataservice.repository.CatalogItemRepository;
import com.elcom.catalog.dataservice.root.CatalogItem;
import com.elcom.catalog.dataservice.root.CatalogItemPrice;
import com.elcom.catalog.dataservice.root.dto.CatalogItemPriceDTO;
import com.elcom.catalog.dataservice.root.dto.CatalogItemPriceDetachedDTO;
import com.elcom.catalog.dataservice.service.CatalogItemPriceService;


@Service
public class CatalogItemPriceServiceImpl extends BaseServiceImpl implements CatalogItemPriceService {
	
	@Autowired
	CatalogItemPriceRepository catalogItemPriceRepository;
	
	@Autowired
	CatalogItemRepository catalogItemRepository;

	@Override
	public Optional<CatalogItemPrice> getCatalogItemPrice(CatalogItemPrice catalogItemPrice) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<CatalogItemPrice> getCatalogItemPriceById(Long id) {
		return catalogItemPriceRepository.findById(id);
	}

	@Override
	public void saveCatalogItemPrice(CatalogItemPrice catalogItemPrice) {
		catalogItemPriceRepository.saveAndFlush(catalogItemPrice);
		
	}

	@Override
	public void deleteCatalogItemPrice(Long id) {
		catalogItemPriceRepository.deleteById(id);
		
	}

	@Override
	public List<CatalogItemPrice> getAllCatalogItemPrices() {
		return catalogItemPriceRepository.findAll();
	}

	@Override
	public CatalogItemPriceDTO saveDetachedCatalogItemPrice(CatalogItemPriceDetachedDTO catalogItemPriceDTO) {

		CatalogItemPrice catalogItemPrice = (CatalogItemPrice) mapObject(catalogItemPriceDTO, CatalogItemPrice.class);
		
		CatalogItem catItem = catalogItemRepository.getById( catalogItemPriceDTO.getCatalogItemID());
		if (catItem!=null)
		catalogItemPrice.setCatalogItem(catItem);
		else return null;
		
		catalogItemPrice = catalogItemPriceRepository.saveAndFlush(catalogItemPrice);
		
		return (CatalogItemPriceDTO) mapObject(catalogItemPrice, CatalogItemPriceDTO.class);	
		
	}


	
}
