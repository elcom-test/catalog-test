package com.elcom.catalog.dataservice.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elcom.catalog.dataservice.repository.ItemAttributeRepository;
import com.elcom.catalog.dataservice.repository.ItemRepository;
import com.elcom.catalog.dataservice.root.Item;
import com.elcom.catalog.dataservice.root.ItemAttribute;
import com.elcom.catalog.dataservice.root.dto.ItemAttributeDTO;
import com.elcom.catalog.dataservice.root.dto.ItemAttributeDetachedDTO;
import com.elcom.catalog.dataservice.service.ItemAttributeService;
@Service
public class ItemAttributeServiceImpl extends BaseServiceImpl implements ItemAttributeService {

	@Autowired
	private ItemAttributeRepository itemAttributeRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Override
	public Optional<ItemAttribute> getItemAttribute(ItemAttribute itemAttribute) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemAttributeDTO getItemAttributeById(Long id) {
		Optional<ItemAttribute> itemAttribute = itemAttributeRepository.findById(id);
		
		if (itemAttribute.isPresent()) {
			return (ItemAttributeDTO) mapObject(itemAttribute.get(), ItemAttributeDTO.class);
		}
		return null;
	}

	@Override
	public ItemAttributeDTO saveItemAttribute(ItemAttributeDTO itemAttributeDTO) {
		
		ItemAttribute itemAttribute = (ItemAttribute) mapObject(itemAttributeDTO, ItemAttribute.class);
		itemAttribute = itemAttributeRepository.saveAndFlush(itemAttribute);
		
		return (ItemAttributeDTO) mapObject(itemAttribute, ItemAttributeDTO.class);
		
	}

	@Override
	public ItemAttributeDTO saveDetachedItemAttribute(ItemAttributeDetachedDTO itemAttributeDTO) {
		
		ItemAttribute itemAttribute = (ItemAttribute) mapObject(itemAttributeDTO, ItemAttribute.class);
		
		// set the item id
		Optional<Item> item = itemRepository.findById(itemAttributeDTO.getItemId());
		if(item.isPresent()) {
			itemAttribute.setItem(item.get());
		}
		else {
			return null; // controller will handle this with a bad request
		}
		
		itemAttribute = itemAttributeRepository.saveAndFlush(itemAttribute);
		
		return (ItemAttributeDTO) mapObject(itemAttribute, ItemAttributeDTO.class);
		
	}
	
	@Override
	public void deleteItemAttribute(Long id) {
		itemAttributeRepository.deleteById(id);
		
	}
}
