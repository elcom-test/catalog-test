package com.elcom.catalog.dataservice.service;

import java.util.List;

import com.elcom.catalog.dataservice.root.UOMCodesLookup;

public interface UOMCodesLookupService {
	Iterable<UOMCodesLookup> getAllUOMCodesLookups();
	UOMCodesLookup saveUOMCodesLookup(UOMCodesLookup uom);
	List<UOMCodesLookup> getAllUOMCodesLookupsList();
	UOMCodesLookup getUOMCodesLookupByName(String uomCode);
}