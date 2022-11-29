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

import com.elcom.catalog.dataservice.repository.FailCodeRepository;
import com.elcom.catalog.dataservice.root.FailCode;
import com.elcom.catalog.dataservice.service.FailCodeService;

/**
 * @author elcdev002
 *
 * Date: Jul 23, 2019 1:10:21 PM
 * 
 */
@Service
public class FailCodeServiceImpl implements FailCodeService {

	@Autowired
	private FailCodeRepository failCodeRepository;

	@Override
	public Iterable<FailCode> getAllFailCodes() {
		return failCodeRepository.findAll();
	}

	@Override
	public FailCode saveFailCode(FailCode failCode) {
		return failCodeRepository.saveAndFlush(failCode);
	}

	@Override
	public FailCode getFailCodeByName(String failCde) {
		List<FailCode> failCodes = getAllFailCodesList();
		
		FailCode failCode = failCodes.stream()
				  .filter(fc -> failCde.equals(fc.getName()))
				  .findAny()
				  .orElse(null);
		return failCode;	
	}

	@Override
	public FailCode findById(long id) {
		Optional<FailCode> failCodeOpt = failCodeRepository.findById(id);
		return failCodeOpt.orElse(null);
	}

	@Override
	public List<FailCode> getAllFailCodesList() {
		List<FailCode> failCodeList = new ArrayList<>();		
		failCodeRepository.findAll().forEach(failCodeList :: add);
		return failCodeList;
	}
}
