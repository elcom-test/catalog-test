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

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.elcom.catalog.dataservice.root.SICCode;
import com.elcom.catalog.dataservice.service.SICCodeService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author elcdev002
 *
 * Date: Sep 13, 2022 12:06:51 PM
 * 
 */
@ExtendWith(MockitoExtension.class)
@SpringBootTest
@TestPropertySource("classpath:application-test.properties")
@Slf4j
class SICCodeServiceImplTest {
	
	@Autowired
	private SICCodeService sicLookupService;

	@Before
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	/**
	 * Test method for {@link com.elcom.catalog.dataservice.service.impl.SICCodeServiceImpl#getAllSICCodesLookups()}.
	 */
	@Disabled
	@Test
	void testGetAllSICCodesLookups() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.elcom.catalog.dataservice.service.impl.SICCodeServiceImpl#saveSICCodesLookup(com.elcom.catalog.dataservice.root.SICCode)}.
	 */
	@Disabled
	@Test
	void testSaveSICCodesLookup() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.elcom.catalog.dataservice.service.impl.SICCodeServiceImpl#getAllSICCodesLookupsList()}.
	 */
	@Disabled
	@Test
	void testGetAllSICCodesLookupsList() {
		log.info("Testing testGetAllSICCodesLookupsList...");
		List<SICCode> sicList = sicLookupService.getAllSICCodesLookupsList();
		log.info("SIC List size---"+sicList.size());
		assertThat(sicList != null && sicList.size() > 0);
	}

	/**
	 * Test method for {@link com.elcom.catalog.dataservice.service.impl.SICCodeServiceImpl#getSICCodesLookupByName(java.lang.String)}.
	 */
	@Disabled
	@Test
	void testGetSICCodesLookupByName() {
		fail("Not yet implemented");
	}

}
