package com.elcom.catalog.dataservice.service;

import java.util.Optional;

import com.elcom.catalog.dataservice.root.Item;
import com.elcom.catalog.dataservice.root.dto.ItemDTO;
import com.elcom.catalog.dataservice.search.model.SearchCriteria;
import com.elcom.catalog.dataservice.search.model.SearchResponse;

public interface ItemService {

	public Optional<ItemDTO> getItem(Item item);
	public ItemDTO getItemById(Long itemId);
	public ItemDTO saveItem(ItemDTO item);
	public void deleteItem(ItemDTO item);
	public ItemDTO toggleItemActiveStatus(Long itemId);
	
	// hibernate search methods
	public SearchResponse searchItems(SearchCriteria searchCriteria);
	public Item getDomainItemById(Long itemId);
}
