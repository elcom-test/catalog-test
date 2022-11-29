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

import com.elcom.catalog.dataservice.repository.GTINRepository;
import com.elcom.catalog.dataservice.root.GTIN;
import com.elcom.catalog.dataservice.service.GTINService;

@Service
public class GTINServiceImpl implements GTINService {

	@Autowired
	GTINRepository gtinRepository;
	
	@Override
	public Iterable<GTIN> getAllGTIN() {
		return gtinRepository.findAll();
	}

	@Override
	public GTIN saveGTIN(GTIN gtin) {
		return gtinRepository.saveAndFlush(gtin);
	}

	@Override
	public List<GTIN> getAllGTINList() {
		List<GTIN> gtinList = new ArrayList<>();		
		gtinRepository.findAll().forEach(gtinList :: add);
		return gtinList;
	}

	@Override
	public Optional<GTIN> getGTINByName(String GTINName) {
		return gtinRepository.getGTINByName(GTINName);
	}

}
