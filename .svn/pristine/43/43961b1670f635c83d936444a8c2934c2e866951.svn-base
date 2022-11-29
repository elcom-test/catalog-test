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

public enum DelimiterTypes {
	TILDE("~~"),
	UNDERSCORE("_"),
	HYPHEN("-");

	private DelimiterTypes(String type) {
		m_type = type;
	}

	public String getDelimiterType() {
		return m_type;
	}

	private String m_type;
	
	public static boolean isValidDelimiterType(String type) {
		DelimiterTypes[] delimiterTypes = DelimiterTypes.values();
		for(int index = 0; index < delimiterTypes.length;index++) {
			if(type != null && type != "") {
				if(type.equalsIgnoreCase(delimiterTypes[index].getDelimiterType())) {
					return true;
				}
			} else {
				return false;
			}
		}
		return false;
	}
}