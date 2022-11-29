package com.elcom.catalog.dataservice.service;

import java.util.List;
import java.util.Optional;

import com.elcom.catalog.dataservice.root.GTIN;

public interface GTINService {
	Iterable<GTIN> getAllGTIN();
	GTIN saveGTIN(GTIN gtin);
	List<GTIN> getAllGTINList();
	Optional<GTIN> getGTINByName(String GTINNme);
}