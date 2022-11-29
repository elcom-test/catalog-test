package com.elcom.catalog.dataservice.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elcom.catalog.dataservice.repository.ItemBarcodeRepository;
import com.elcom.catalog.dataservice.repository.ItemRepository;
import com.elcom.catalog.dataservice.root.Item;
import com.elcom.catalog.dataservice.root.ItemAsset;
import com.elcom.catalog.dataservice.root.ItemBarcode;
import com.elcom.catalog.dataservice.root.dto.ItemAssetDTO;
import com.elcom.catalog.dataservice.root.dto.ItemBarcodeDTO;
import com.elcom.catalog.dataservice.root.dto.ItemBarcodeDetachedDTO;
import com.elcom.catalog.dataservice.service.ItemBarcodeService;

@Service
public class ItemBarcodeServiceImpl extends BaseServiceImpl implements ItemBarcodeService {
	
	@Autowired
	ItemBarcodeRepository itemBarcodeRepository;

	@Autowired
	private ItemRepository itemRepository;

	@Override
	public ItemBarcodeDTO getItemBarcodeById(Long id) {
		Optional<ItemBarcode> itemBarcode = itemBarcodeRepository.findById(id);
		
		if (itemBarcode.isPresent()) {
			return (ItemBarcodeDTO) mapObject(itemBarcode.get(), ItemBarcodeDTO.class);
		}
		return null;
	}

	@Override
	public ItemBarcodeDTO saveItemBarcode(ItemBarcodeDTO itemBarcodeDTO) {
		ItemBarcode itemBarcode = (ItemBarcode) mapObject(itemBarcodeDTO, ItemBarcode.class);
		itemBarcode = itemBarcodeRepository.saveAndFlush(itemBarcode);
		
		return (ItemBarcodeDTO) mapObject(itemBarcode, ItemBarcodeDTO.class);
	}

	@Override
	public ItemBarcodeDTO saveDetachedItemBarcode(ItemBarcodeDetachedDTO itemBarcodeDTO) {
		ItemBarcode itemBarcode = (ItemBarcode) mapObject(itemBarcodeDTO, ItemBarcode.class);
		
		// set the item id
		Optional<Item> item = itemRepository.findById(itemBarcodeDTO.getItemId());
		if(item.isPresent()) {
			itemBarcode.setItem(item.get());
		}
		else {
			return null; // controller will handle this with a bad request
		}
		itemBarcode = itemBarcodeRepository.saveAndFlush(itemBarcode);
		
		return (ItemBarcodeDTO) mapObject(itemBarcode, ItemBarcodeDTO.class);
	}

	@Override
	public void deleteItemBarcode(Long id) {
		itemBarcodeRepository.deleteById(id);
		
	}
	
	

}