package com.elcom.catalog.dataservice.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elcom.catalog.dataservice.repository.ItemAssetRepository;
import com.elcom.catalog.dataservice.repository.ItemRepository;
import com.elcom.catalog.dataservice.root.Item;
import com.elcom.catalog.dataservice.root.ItemAsset;
import com.elcom.catalog.dataservice.root.dto.ItemAssetDTO;
import com.elcom.catalog.dataservice.root.dto.ItemAssetDetachedDTO;
import com.elcom.catalog.dataservice.service.ItemAssetService;
@Service
public class ItemAssetServiceImpl extends BaseServiceImpl implements ItemAssetService {
	
	@Autowired
	private ItemAssetRepository itemAssetRepository;

	@Autowired
	private ItemRepository itemRepository;

	@Override
	public ItemAssetDTO getItemAsset(ItemAssetDTO itemAsset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemAssetDTO getItemAssetById(Long id) {
		Optional<ItemAsset> itemAsset = itemAssetRepository.findById(id);
		
		if (itemAsset.isPresent()) {
			return (ItemAssetDTO) mapObject(itemAsset.get(), ItemAssetDTO.class);
		}
		return null;
	}

	@Override
	public ItemAssetDTO saveItemAsset(ItemAssetDTO itemAssetDTO) {
		ItemAsset itemAsset = (ItemAsset) mapObject(itemAssetDTO, ItemAsset.class);
		itemAsset = itemAssetRepository.saveAndFlush(itemAsset);
		
		return (ItemAssetDTO) mapObject(itemAsset, ItemAssetDTO.class);
	}

	@Override
	public ItemAssetDTO saveDetachedItemAsset(ItemAssetDetachedDTO itemAssetDTO) {
		ItemAsset itemAsset = (ItemAsset) mapObject(itemAssetDTO, ItemAsset.class);
		
		// set the item id
		Optional<Item> item = itemRepository.findById(itemAssetDTO.getItemId());
		if(item.isPresent()) {
			itemAsset.setItem(item.get());
		}
		else {
			return null; // controller will handle this with a bad request
		}
		
		itemAsset = itemAssetRepository.saveAndFlush(itemAsset);
		
		return (ItemAssetDTO) mapObject(itemAsset, ItemAssetDTO.class);	
	}

	@Override
	public void deleteItemAsset(Long id) {
		itemAssetRepository.deleteById(id);
		
	}
}
