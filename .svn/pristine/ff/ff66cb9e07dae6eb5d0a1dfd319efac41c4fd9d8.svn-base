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

import com.elcom.catalog.dataservice.repository.EClassCodesLookupRepository;
import com.elcom.catalog.dataservice.root.EClassCodesLookup;
import com.elcom.catalog.dataservice.service.EClassCodesLookupService;

/**
 * @author elcdev002
 *
 * Date: Jul 23, 2019 1:10:21 PM
 * 
 */
@Service
public class EClassCodesLookupServiceImpl implements EClassCodesLookupService {

	@Autowired
	private EClassCodesLookupRepository eClassLookupRepository;

	@Override
	public Iterable<EClassCodesLookup> getAllEClassCodesLookups() {
		return eClassLookupRepository.findAll();
	}

	@Override
	public EClassCodesLookup saveEClassCodesLookup(EClassCodesLookup eClassLookup) {
		return eClassLookupRepository.saveAndFlush(eClassLookup);
	}

	@Override
	public List<EClassCodesLookup> getAllEClassCodesLookupsList() {
		List<EClassCodesLookup> eClassLookupList = new ArrayList<>();		
		eClassLookupRepository.findAll().forEach(eClassLookupList :: add);
		return eClassLookupList;
	}

	@Override
	public EClassCodesLookup getEClassCodesLookupByName(String EClassCodesLookupNme) {
		List<EClassCodesLookup> types = getAllEClassCodesLookupsList();
		
		EClassCodesLookup eClassType = types.stream()
				  .filter(eClassLookup -> EClassCodesLookupNme.equals(eClassLookup.getCode()))
				  .findAny()
				  .orElse(null);
		return eClassType;
	}
}