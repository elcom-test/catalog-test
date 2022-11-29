package com.elcom.catalog.dataservice.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elcom.catalog.dataservice.repository.ItemRepository;
import com.elcom.catalog.dataservice.repository.ItemTaxonomyRepository;
import com.elcom.catalog.dataservice.root.Item;
import com.elcom.catalog.dataservice.root.ItemTaxonomy;
import com.elcom.catalog.dataservice.root.dto.ItemTaxonomyDTO;
import com.elcom.catalog.dataservice.root.dto.ItemTaxonomyDetachedDTO;
import com.elcom.catalog.dataservice.service.ItemTaxonomyService;
@Service
public class ItemTaxonomyServiceImpl extends BaseServiceImpl implements ItemTaxonomyService {
	
	@Autowired
	private ItemTaxonomyRepository itemTaxonomyRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Override
	public ItemTaxonomyDTO getItemTaxonomyById(Long id) {
		Optional<ItemTaxonomy> itemTaxonomy = itemTaxonomyRepository.findById(id);
		
		if (itemTaxonomy.isPresent()) {
			return (ItemTaxonomyDTO) mapObject(itemTaxonomy.get(), ItemTaxonomyDTO.class);
		}
		return null;	}

	@Override
	public ItemTaxonomyDTO saveItemTaxonomy(ItemTaxonomyDTO itemTaxonomyDTO) {
		ItemTaxonomy itemTaxonomy = (ItemTaxonomy) mapObject(itemTaxonomyDTO, ItemTaxonomy.class);
		itemTaxonomy = itemTaxonomyRepository.saveAndFlush(itemTaxonomy);
		
		return (ItemTaxonomyDTO) mapObject(itemTaxonomy, ItemTaxonomyDTO.class);
	}
	
	@Override
	public ItemTaxonomyDTO saveDetachedItemTaxonomy(ItemTaxonomyDetachedDTO itemTaxonomyDTO) {
		ItemTaxonomy itemTaxonomy = (ItemTaxonomy) mapObject(itemTaxonomyDTO, ItemTaxonomy.class);
		
		// set the item id
		Optional<Item> item = itemRepository.findById(itemTaxonomyDTO.getItemId());
		if(item.isPresent()) {
			itemTaxonomy.setItem(item.get());
		}
		else {
			return null; // controller will handle this with a bad request
		}
		
		itemTaxonomy = itemTaxonomyRepository.saveAndFlush(itemTaxonomy);
		return (ItemTaxonomyDTO) mapObject(itemTaxonomy, ItemTaxonomyDTO.class);
	}

	
	@Override
	public void deleteItemTaxonomy(Long id) {
		 itemTaxonomyRepository.deleteById(id);
	}
	
}
