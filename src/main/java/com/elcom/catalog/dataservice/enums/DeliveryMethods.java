package com.elcom.catalog.dataservice.enums;

public enum DeliveryMethods {
	EMAIL("email"),
	HTTPSPOST("httpspost"),
	REST("rest"),
	SFTP("sftp"),
	INTERNAL_PECOS("internal_pecos"),
	INTERNAL_ADB("internal_adb"),
	INTERNAL_AP("internal_ap");

	private DeliveryMethods(String type) {
		m_type = type;
	}

	public String getDeliveryMethods() {
		return m_type;
	}

	private String m_type;
	
	public static boolean isValidDeliveryMethod(String type) {
		DeliveryMethods[] deliveryMethods = DeliveryMethods.values();
		for(int index = 0; index < deliveryMethods.length;index++) {
			if(type != null && type != "") {
				if(type.equalsIgnoreCase(deliveryMethods[index].name())) {
					return true;
				}
			} else {
				return false;
			}
		}
		return false;
	}
}
