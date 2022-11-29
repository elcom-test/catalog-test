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

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ComponentTypes {
	purchaseOrderNumber("Purchase Order Number","purchaseOrderNumber"),
	invoiceNumber("Invoice Number", "invoiceNumber"),
	supplierID("Supplier ID","supplierID"),
	supplierNumber("Supplier Number", "supplierNumber"),
	invoiceDate("Invoice Date", "invoiceDate"),
	dateReceived("Date Received", "dateReceived"),
	customerName ("Customer Name", "customerName"),
	supplierName("Supplier Name", "supplierName");

	private ComponentTypes(String name, String value) {
		this.name = name;
		this.value = value;
	}

	@JsonIgnore
	public String getComponentType() {
		return value;
	}

	private String name;

	private String value;

	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}


	public static boolean isValidComponentType(long noOfComponents, Map<Integer, String> componentsMap) {
		boolean isValid = true;
		if(componentsMap.size() == noOfComponents) {
			ComponentTypes[] componentTypes = ComponentTypes.values();
			for(int i = 1; i <= noOfComponents; i++) {
				String component = componentsMap.get(i);
				if(component != null && component != "") {
					for(int j =0 ;j < componentTypes.length;j++) {
						if(component.equalsIgnoreCase(componentTypes[j].getComponentType())) {
							isValid = true; break;
						}
					}
				} else {
					return isValid;
				}
			}
		} else {
			return isValid;
		}
		return isValid;
	}
}