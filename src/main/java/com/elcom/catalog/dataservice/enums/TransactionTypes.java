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
package com.elcom.catalog.dataservice.enums;

public enum TransactionTypes {
	invoice("invoice"),
	orderconfirmation("orderconfirmation"),
	relation_setup("relation_setup"),
	remittance("remittance"),
	supplier_setup("supplier_setup"),
	shipnotification("shipnotification"),
	order("order");

	private final String type;

	private TransactionTypes(String type) {
		this.type = type;
	}
	public String getTransactionType(){
		return this.type;
	}
	
	public static boolean isValidTransactionType(String type) {
		TransactionTypes[] transactionTypes = TransactionTypes.values();
		for(int index = 0; index < transactionTypes.length;index++) {
			if(type != null && type != "") {
				if(type.equalsIgnoreCase(transactionTypes[index].name())) {
					return true;
				}
			} else {
				return false;
			}
		}
		return false;
	}
}