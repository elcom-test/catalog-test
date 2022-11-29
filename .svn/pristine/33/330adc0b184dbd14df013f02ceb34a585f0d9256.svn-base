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

import com.elcom.catalog.dataservice.repository.ImportTransactionsRepository;
import com.elcom.catalog.dataservice.root.ImportTransactions;
import com.elcom.catalog.dataservice.service.ImportTransactionsService;

public class ImportTransactionServiceImpl implements ImportTransactionsService {

	@Autowired
	ImportTransactionsRepository importTransactionsRepository;
	
	@Override
	public Iterable<ImportTransactions> getAllImportTransactions() {
		return importTransactionsRepository.findAll();
	}

	@Override
	public ImportTransactions saveImportTransaction(ImportTransactions importTransaction) {
		return importTransactionsRepository.saveAndFlush(importTransaction);
	}

	@Override
	public List<ImportTransactions> getAllImportTransactionsList() {
		List<ImportTransactions> importTransactionsList = new ArrayList<>();		
		importTransactionsRepository.findAll().forEach(importTransactionsList :: add);
		return importTransactionsList;
	}

}
