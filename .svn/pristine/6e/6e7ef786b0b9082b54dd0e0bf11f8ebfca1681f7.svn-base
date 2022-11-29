package com.elcom.catalog.dataservice.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elcom.catalog.dataservice.repository.CompanyRepository;
import com.elcom.catalog.dataservice.repository.ItemBarcodeRepository;
import com.elcom.catalog.dataservice.repository.ItemRepository;
import com.elcom.catalog.dataservice.root.Company;
import com.elcom.catalog.dataservice.root.Item;
import com.elcom.catalog.dataservice.root.dto.ItemDTO;
import com.elcom.catalog.dataservice.search.dao.SearchDao;
import com.elcom.catalog.dataservice.search.model.SearchCriteria;
import com.elcom.catalog.dataservice.search.model.SearchResponse;
import com.elcom.catalog.dataservice.service.CompanyService;
import com.elcom.catalog.dataservice.service.ItemService;

@Service
@Transactional
public class ItemServiceImpl extends BaseServiceImpl implements ItemService {

	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	ItemBarcodeRepository itemBarcodeRepository;
	
	@Autowired
	CompanyService companyService;
	
	@Autowired
	CompanyRepository companyRepository;
	
	@Autowired
	SearchDao searchDao;
	
	@Override
	public Optional<ItemDTO> getItem(Item item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemDTO getItemById(Long itemId) {
		
		Optional<Item> item = itemRepository.findById(itemId);
		
		if (item.isPresent()) {
			return (ItemDTO) mapObject(item.get(), ItemDTO.class);
		}
		return null;
		
	}

	@Override
	public ItemDTO saveItem(ItemDTO itemDTO) {
		
		Item item = (Item) mapObject(itemDTO, Item.class);
		
		// find and attach a company
		Optional<Company> companyOpt = companyService.matchCompanyByCriteria(itemDTO.getCompanyInfo());
		if (companyOpt.isPresent()) {
			item.setCompany(companyOpt.get());
		}
		item = itemRepository.saveAndFlush(item);
		
		return (ItemDTO) mapObject(item, ItemDTO.class);
	}

	@Override
	public void deleteItem(ItemDTO itemDTO) {
		itemRepository.deleteById(itemDTO.getId());
	}
	
	@Override
	public SearchResponse searchItems(SearchCriteria searchCriteria) {
		searchCriteria.setFieldToSearch("item.combined");
		searchCriteria.setAdditionalFieldsToSearch(new String[] {"company.companyName"});
		searchCriteria.setSearchFacets(new String[] {"company.cname_facet", "brand_facet"});
		searchCriteria.setObjectToSearch(Item.class);
		searchCriteria.setObjectToReturn(ItemDTO.class);
		
		return searchDao.search(searchCriteria);
	}

	@Override
	public Item getDomainItemById(Long itemId) {
		// TODO Auto-generated method stub
		return itemRepository.findItem(itemId);
	}
	
	@Override
	public ItemDTO toggleItemActiveStatus(Long itemId) {
		
		Optional<Item> itemOpt = itemRepository.findById(itemId);
		
		if (itemOpt.isPresent()) {
			Item item = itemOpt.get();
			String activeStatus = item.getActiveFlag();
			item.setActiveFlag("Y".equals(activeStatus) ? "N" : "Y");
			item = itemRepository.saveAndFlush(item);
			
			return (ItemDTO) mapObject(item, ItemDTO.class);
		}
		return null;
		
	}

	
	
}
