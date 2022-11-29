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

public enum RuleTypes {
	
	general("general"),
	buyer("buyer"),
	parsing("parsing");
	
	private final String type;

	private RuleTypes(String type) {
		this.type = type;
	}
	public String getRuleType(){
		return this.type;
	}

	public static boolean isValidRuleType(String type) {
		RuleTypes[] ruleTypes = RuleTypes.values();
		for(int index = 0; index < ruleTypes.length;index++) {
			if(type != null && type != "") {
				if(type.equalsIgnoreCase(ruleTypes[index].name())) {
					return true;
				}
			} else {
				return false;
			}
		}
		return false;
	}
}