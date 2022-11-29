package com.elcom.catalog.dataservice.search.model;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchResponse {
	
	private Integer numMatches;
	private List<?> matchedRecords;
	private Map<String,List<SearchFacet>> facets;
	
}
