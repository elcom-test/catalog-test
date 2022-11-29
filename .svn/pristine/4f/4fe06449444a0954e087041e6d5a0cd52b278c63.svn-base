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

public enum StandardTypes {
	CXML("CXML"),
	PEPPOL("PEPPOL"),
	PDF("PDF"),
	CSV("CSV"),
	BASDA("BASDA"),
	XML("XML"),
	INTERNAL("INTERNAL");

	private final String type;

	private StandardTypes(String type) {
		this.type = type;
	}
	public String getStandardType(){
		return this.type;
	}

	public static boolean isValidStandardType(String type) {
		StandardTypes[] standardTypes = StandardTypes.values();
		for(int index = 0; index < standardTypes.length;index++) {
			if(type != null && type != "") {
				if(type.equalsIgnoreCase(standardTypes[index].name())) {
					return true;
				}
			} else {
				return false;
			}
		}
		return false;
	}
}