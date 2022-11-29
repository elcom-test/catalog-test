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
public class CatalogItemDetachedDTO extends CatalogItemBaseDTO{
	
	private Long itemId;
	private Long substituteItemId;
	private Long catalogId;
	

}
