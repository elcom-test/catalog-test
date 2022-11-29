package com.elcom.catalog.dataservice.search.dao;

import com.elcom.catalog.dataservice.search.model.SearchCriteria;
import com.elcom.catalog.dataservice.search.model.SearchResponse;

public interface SearchDao {
	public SearchResponse search(SearchCriteria searchCriteria);
	public Integer findTotal();
}
