package com.elcom.catalog.dataservice.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elcom.catalog.dataservice.repository.CatalogItemRepository;
import com.elcom.catalog.dataservice.repository.CatalogRepository;
import com.elcom.catalog.dataservice.repository.ItemRepository;
import com.elcom.catalog.dataservice.repository.SubstituteItemRepository;
import com.elcom.catalog.dataservice.root.Catalog;
import com.elcom.catalog.dataservice.root.CatalogItem;
import com.elcom.catalog.dataservice.root.Item;
import com.elcom.catalog.dataservice.root.dto.CatalogItemDTO;
import com.elcom.catalog.dataservice.root.dto.CatalogItemDetachedDTO;
import com.elcom.catalog.dataservice.root.dto.ItemAttributeDTO;
import com.elcom.catalog.dataservice.service.CatalogItemService;
@Service
public class CatalogItemServiceImpl extends BaseServiceImpl implements CatalogItemService {

	@Autowired
	private CatalogItemRepository catalogItemRepository;

	@Autowired
	private SubstituteItemRepository subItemRepository;

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private CatalogRepository catalogRepository;

	@Override
	public Optional<CatalogItem> getCatalogItem(CatalogItem catalogItem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<CatalogItem> getCatalogItemById(Long id) {	
		return catalogItemRepository.findById(id);
	}

	@Override
	public void saveCatalogItem(CatalogItem catalogItem) {
		catalogItemRepository.saveAndFlush(catalogItem);
	}

	@Override
	public void deleteCatalogItem(Long id) {
		catalogItemRepository.deleteById(id);
	}

	@Override
	public List<CatalogItem> getAllCatalogItems() {
		return catalogItemRepository.findAll();
	}

	@Override
	public CatalogItemDTO saveDetachedCatalogItem(CatalogItemDetachedDTO catalogItemDTO) {


		CatalogItem catalogItem = (CatalogItem) mapObject(catalogItemDTO, CatalogItem.class);
		// set default substitute item ..... use sub item repo
		catalogItem.setSubstituteItem(null);
		//set item
		Optional<Item> item = itemRepository.findById(catalogItemDTO.getItemId());
		if(item.isPresent()) {
			Item it = item.get();
			catalogItem.setItem(it);
		}

		//set catalog
		Optional<Catalog> catalog =catalogRepository.findById(catalogItemDTO.getCatalogId());
		if(catalog.isPresent()) {
			catalogItem.setCatalog(catalog.get());
		}

		catalogItem = catalogItemRepository.saveAndFlush(catalogItem);
		System.out.println(catalogItem);

		return (CatalogItemDTO) mapObject(catalogItem, CatalogItemDTO.class);


	}

}
