package com.elcom.catalog.dataservice.root.dto;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CatalogDTO {

	private Long id;
	private String key;
	private String name;
	private String description;
	private String type;
	private Integer version;
	private String site;
	
	@Default
	@JsonManagedReference(value="catalogItems")
	Set<CatalogItemDTO> catalogItems = new HashSet<>();
	private String activeFlag;
	

}
