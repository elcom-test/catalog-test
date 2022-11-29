package com.elcom.catalog.dataservice.service;

import com.elcom.catalog.dataservice.root.dto.ItemAssetDTO;
import com.elcom.catalog.dataservice.root.dto.ItemAssetDetachedDTO;

public interface ItemAssetService {
	
	public ItemAssetDTO getItemAsset(ItemAssetDTO itemAsset);
	public ItemAssetDTO getItemAssetById(Long id);
	public ItemAssetDTO saveItemAsset(ItemAssetDTO itemAsset);
	public ItemAssetDTO saveDetachedItemAsset(ItemAssetDetachedDTO itemAsset);
	public void deleteItemAsset(Long id);
	
}
