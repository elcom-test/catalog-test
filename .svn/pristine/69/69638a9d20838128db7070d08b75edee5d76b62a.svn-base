package com.elcom.catalog.dataservice.service;

import java.util.List;
import java.util.Optional;

import com.elcom.catalog.dataservice.root.CatalogItemAttribute;
import com.elcom.catalog.dataservice.root.CatalogItemPrice;
import com.elcom.catalog.dataservice.root.dto.CatalogItemPriceDTO;
import com.elcom.catalog.dataservice.root.dto.CatalogItemPriceDetachedDTO;

public interface CatalogItemPriceService {

	public Optional<CatalogItemPrice> getCatalogItemPrice(CatalogItemPrice catalogItemPrice);
	public Optional<CatalogItemPrice> getCatalogItemPriceById(Long id);
	public void saveCatalogItemPrice(CatalogItemPrice catalogItemPrice);		
	public void deleteCatalogItemPrice(Long id);
	public List<CatalogItemPrice> getAllCatalogItemPrices();


	public CatalogItemPriceDTO saveDetachedCatalogItemPrice( CatalogItemPriceDetachedDTO catalogItemPrice);
	



}
