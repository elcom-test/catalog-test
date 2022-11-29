package com.elcom.catalog.dataservice.root.dto;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Validated
public class ItemBarcodeDTO  extends ItemBarcodeBaseDTO {
	
	@JsonBackReference(value="itemBarCode")
	private ItemDTO item;
	
}
