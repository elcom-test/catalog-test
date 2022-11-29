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

import com.elcom.catalog.dataservice.repository.SICCodesLookupRepository;
import com.elcom.catalog.dataservice.root.SICCode;
import com.elcom.catalog.dataservice.root.dto.SICCodeDTO;
import com.elcom.catalog.dataservice.search.dao.impl.SearchDaoImpl;
import com.elcom.catalog.dataservice.search.model.SearchCriteria;
import com.elcom.catalog.dataservice.search.model.SearchResponse;
import com.elcom.catalog.dataservice.service.SICCodeService;

/**
 * @author elcdev002
 *
 * Date: Jul 23, 2019 1:10:21 PM
 * 
 */
@Service
public class SICCodeServiceImpl implements SICCodeService {

	@Autowired
	private SICCodesLookupRepository sicLookupRepository;

	@Autowired
	private SearchDaoImpl searchDao;
	
	@Override
	public Iterable<SICCode> getAllSICCodesLookups() {
		return sicLookupRepository.findAll();
	}

	@Override
	public SICCode saveSICCodesLookup(SICCode sicLookup) {
		return sicLookupRepository.saveAndFlush(sicLookup);
	}

	@Override
	public List<SICCode> getAllSICCodesLookupsList() {
		List<SICCode> sicLookupList = new ArrayList<>();		
		sicLookupRepository.findAll().forEach(sicLookupList :: add);
		return sicLookupList;
	}

	@Override
	public SICCode getSICCodesLookupByName(String SICCodesLookupNme) {
		List<SICCode> types = getAllSICCodesLookupsList();
		
		SICCode sicType = types.stream()
				  .filter(sicLookup -> SICCodesLookupNme.equals(sicLookup.getSicCode()))
				  .findAny()
				  .orElse(null);
		return sicType;
	}

	@Override
	public SearchResponse searchSICCode(SearchCriteria searchCriteria) {
		
		searchCriteria.setFieldToSearch("sic_code.combined");
		searchCriteria.setObjectToSearch(SICCode.class);
		searchCriteria.setObjectToReturn(SICCodeDTO.class);
		
		return searchDao.search(searchCriteria);
	}
}