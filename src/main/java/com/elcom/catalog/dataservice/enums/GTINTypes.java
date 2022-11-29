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

public enum GTINTypes {
	EAN_8("EAN-8"),
	UCC_12("UCC-12"),
	EAN_13("EAN-13"),
	EAN_UCC_14("EAN / UCC-14");

	private GTINTypes(String type) {
		m_type = type;
	}

	public String getGTINType() {
		return m_type;
	}

	private String m_type;
	
	public static boolean isValidGTINType(String type) {
		GTINTypes[] gtinTypes = GTINTypes.values();
		for(int index = 0; index < gtinTypes.length;index++) {
			if(type != null && type != "") {
				if(type.equalsIgnoreCase(gtinTypes[index].name())) {
					return true;
				}
			} else {
				return false;
			}
		}
		return false;
	}
}
