package com.elcom.catalog.dataservice.service;

import com.elcom.catalog.dataservice.root.dto.ItemBarcodeDTO;
import com.elcom.catalog.dataservice.root.dto.ItemBarcodeDetachedDTO;

public interface ItemBarcodeService {
	
	public ItemBarcodeDTO getItemBarcodeById(Long id);
	public ItemBarcodeDTO saveItemBarcode(ItemBarcodeDTO itemBarcode);	
	public ItemBarcodeDTO saveDetachedItemBarcode(ItemBarcodeDetachedDTO itemBarcode);
	public void deleteItemBarcode(Long id);
	
}
