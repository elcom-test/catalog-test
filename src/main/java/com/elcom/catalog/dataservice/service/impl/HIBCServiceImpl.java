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
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elcom.catalog.dataservice.repository.HIBCRepository;
import com.elcom.catalog.dataservice.root.HIBC;
import com.elcom.catalog.dataservice.service.HIBCService;

@Service
public class HIBCServiceImpl implements HIBCService {

	@Autowired
	HIBCRepository hibcRepository;
	
	@Override
	public Iterable<HIBC> getAllHIBC() {
		return hibcRepository.findAll();
	}

	@Override
	public HIBC saveHIBC(HIBC hibc) {
		return hibcRepository.saveAndFlush(hibc);
	}

	@Override
	public List<HIBC> getAllHIBCList() {
		List<HIBC> hibcList = new ArrayList<>();		
		hibcRepository.findAll().forEach(hibcList :: add);
		return hibcList;
	}

	@Override
	public Optional<HIBC> getHIBCByName(String hibcText) {
		return hibcRepository.getHIBCByName(hibcText);
	}

}
