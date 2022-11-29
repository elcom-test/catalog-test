package com.elcom.catalog.dataservice.root.dto;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Validated
public class ItemAssetDTO extends ItemAssetBaseDTO {
	
	@JsonBackReference(value="itemAsset")
	private ItemDTO item;
	
}
