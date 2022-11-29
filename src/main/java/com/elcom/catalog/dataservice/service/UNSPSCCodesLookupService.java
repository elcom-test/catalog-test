package com.elcom.catalog.dataservice.service;

import java.util.List;

import com.elcom.catalog.dataservice.root.UNSPSCCode;

public interface UNSPSCCodesLookupService {
	Iterable<UNSPSCCode> getAllUNSPSCCodesLookups();
	UNSPSCCode saveUNSPSCCodesLookup(UNSPSCCode standardType);
	List<UNSPSCCode> getAllUNSPSCCodesLookupsList();
	UNSPSCCode getUNSPSCCodesLookupByName(String UNSPSCCodesLookupNme);
}