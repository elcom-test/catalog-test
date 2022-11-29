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

import com.elcom.catalog.dataservice.repository.UNSPSCCodesLookupRepository;
import com.elcom.catalog.dataservice.root.UNSPSCCode;
import com.elcom.catalog.dataservice.service.UNSPSCCodesLookupService;

/**
 * @author elcdev002
 *
 * Date: Jul 23, 2019 1:10:21 PM
 * 
 */
@Service
public class UNSPSCCodesLookupServiceImpl implements UNSPSCCodesLookupService {

	@Autowired
	private UNSPSCCodesLookupRepository unspscLookupRepository;

	@Override
	public Iterable<UNSPSCCode> getAllUNSPSCCodesLookups() {
		return unspscLookupRepository.findAll();
	}

	@Override
	public UNSPSCCode saveUNSPSCCodesLookup(UNSPSCCode unspscLookup) {
		return unspscLookupRepository.saveAndFlush(unspscLookup);
	}

	@Override
	public List<UNSPSCCode> getAllUNSPSCCodesLookupsList() {
		List<UNSPSCCode> unspscLookupList = new ArrayList<>();		
		unspscLookupRepository.findAll().forEach(unspscLookupList :: add);
		return unspscLookupList;
	}

	@Override
	public UNSPSCCode getUNSPSCCodesLookupByName(String UNSPSCCodesLookupNme) {
		List<UNSPSCCode> types = getAllUNSPSCCodesLookupsList();
		
		UNSPSCCode unspscType = types.stream()
				  .filter(unspscLookup -> UNSPSCCodesLookupNme.equals(unspscLookup.getTitle()))
				  .findAny()
				  .orElse(null);
		return unspscType;
	}
}