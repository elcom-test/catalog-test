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
import static org.junit.Assert.fail;

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

import com.elcom.catalog.dataservice.root.HIBC;
import com.elcom.catalog.dataservice.service.HIBCService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author elcdev002
 *
 * Date: Sep 12, 2022 11:09:32 AM
 * 
 */
@ExtendWith(MockitoExtension.class)
@SpringBootTest
@TestPropertySource("classpath:application-test.properties")
@Slf4j
public class HIBCServiceImplTest {

	@Autowired
	private HIBCService hibcService;

	@Before
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	/**
	 * Test method for {@link com.elcom.catalog.dataservice.service.impl.HIBCServiceImpl#getAllHIBC()}.
	 */
	@Disabled
	@Test
	public void testGetAllHIBC() {
		log.info("Testing...");
		List<HIBC> hibcsList = hibcService.getAllHIBCList();
		assertThat(hibcsList != null && hibcsList.size() > 0);
	}

	/**
	 * Test method for {@link com.elcom.catalog.dataservice.service.impl.HIBCServiceImpl#saveHIBC(com.elcom.catalog.dataservice.root.HIBC)}.
	 */
	@Disabled
	@Test
	public void testSaveHIBC() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.elcom.catalog.dataservice.service.impl.HIBCServiceImpl#getAllHIBCList()}.
	 */
	@Disabled
	@Test
	public void testGetAllHIBCList() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.elcom.catalog.dataservice.service.impl.HIBCServiceImpl#getHIBCByName(java.lang.String)}.
	 */
	@Disabled
	@Test
	public void testGetHIBCByName() {
		fail("Not yet implemented");
	}

}
