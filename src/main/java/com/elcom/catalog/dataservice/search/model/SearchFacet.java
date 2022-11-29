package com.elcom.catalog.dataservice.search.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SearchFacet {

	private String key;
	private String description;
	private Integer count;
	
}