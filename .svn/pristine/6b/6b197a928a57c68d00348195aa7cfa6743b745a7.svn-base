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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elcom.catalog.dataservice.repository.AuditTrailRepository;
import com.elcom.catalog.dataservice.root.AuditTrail;
import com.elcom.catalog.dataservice.service.AuditTrailService;

/**
 * @author elcdev002
 *
 * Date: Jul 23, 2019 1:10:21 PM
 * 
 */
@Service
public class AuditTrailServiceImpl implements AuditTrailService {

	@Autowired
	private AuditTrailRepository auditTrailRepository;
	
	@Override
	public Iterable<AuditTrail> getAllAuditTrails() {
		return auditTrailRepository.findAll();
	}

	@Override
	public AuditTrail saveAuditTrail(AuditTrail auditTrail) {
		return auditTrailRepository.saveAndFlush(auditTrail);
	}
	
	@Override
	public void deleteAuditTrail(AuditTrail auditTrail) {
		auditTrailRepository.delete(auditTrail);
	}
}
