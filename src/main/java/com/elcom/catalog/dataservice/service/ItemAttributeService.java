package com.elcom.catalog.dataservice.service;

import java.util.List;
import java.util.Optional;

import com.elcom.catalog.dataservice.root.ItemAttribute;
import com.elcom.catalog.dataservice.root.dto.ItemAttributeDTO;
import com.elcom.catalog.dataservice.root.dto.ItemAttributeDetachedDTO;

public interface ItemAttributeService {
	
	public Optional<ItemAttribute> getItemAttribute(ItemAttribute itemAttribute);
	public ItemAttributeDTO getItemAttributeById(Long id);
	public ItemAttributeDTO saveItemAttribute(ItemAttributeDTO itemAttribute);	
	public ItemAttributeDTO saveDetachedItemAttribute(ItemAttributeDetachedDTO itemAttribute);
	
	public void deleteItemAttribute(Long id);
	
}
