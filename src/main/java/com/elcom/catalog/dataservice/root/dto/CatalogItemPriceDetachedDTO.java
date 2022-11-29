package com.elcom.catalog.dataservice.root.dto;

import org.springframework.validation.annotation.Validated;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Validated
public class CatalogItemPriceDetachedDTO extends CatalogItemPriceBaseDTO{
	
	private Long catalogItemID;

}
