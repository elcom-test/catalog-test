package com.elcom.catalog.dataservice.service;

import java.util.List;

import com.elcom.catalog.dataservice.root.SICCode;
import com.elcom.catalog.dataservice.search.model.SearchCriteria;
import com.elcom.catalog.dataservice.search.model.SearchResponse;

public interface SICCodeService {
	Iterable<SICCode> getAllSICCodesLookups();
	SICCode saveSICCodesLookup(SICCode standardType);
	List<SICCode> getAllSICCodesLookupsList();
	SICCode getSICCodesLookupByName(String SICCodesLookupNme);
	
	SearchResponse searchSICCode(SearchCriteria searchCriteria);
}