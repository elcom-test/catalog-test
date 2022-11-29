/*******************************************************************************
 * Copyright (c) 2016-2017 Elcom International Inc.
 * 50 Braintree Hill Office Park, Suite 309, Braintree, MA 02184, U.S.A.
 * All rights reserved.
 * 
 * This software is the confidential and proprietary information of
 * Elcom International Inc. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Elcom.
 * 
 ******************************************************************************/
package com.elcom.catalog.dataservice.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elcom.catalog.dataservice.repository.UOMCodesLookupRepository;
import com.elcom.catalog.dataservice.root.UOMCodesLookup;
import com.elcom.catalog.dataservice.service.UOMCodesLookupService;

/**
 * @author elcdev002
 *
 * Date: Jul 23, 2019 1:10:21 PM
 * 
 */
@Service
public class UOMCodesLookupServiceImpl implements UOMCodesLookupService {

	@Autowired
	private UOMCodesLookupRepository uomLookupRepository;

	@Override
	public Iterable<UOMCodesLookup> getAllUOMCodesLookups() {
		return uomLookupRepository.findAll();
	}

	@Override
	public UOMCodesLookup saveUOMCodesLookup(UOMCodesLookup uomLookup) {
		return uomLookupRepository.saveAndFlush(uomLookup);
	}

	@Override
	public List<UOMCodesLookup> getAllUOMCodesLookupsList() {
		List<UOMCodesLookup> uomLookupList = new ArrayList<>();		
		uomLookupRepository.findAll().forEach(uomLookupList :: add);
		return uomLookupList;
	}

	@Override
	public UOMCodesLookup getUOMCodesLookupByName(String UOMCodesLookupNme) {
		List<UOMCodesLookup> types = getAllUOMCodesLookupsList();
		
		UOMCodesLookup uomType = types.stream()
				  .filter(uomLookup -> UOMCodesLookupNme.equals(uomLookup.getLabel()))
				  .findAny()
				  .orElse(null);
		return uomType;
	}
}