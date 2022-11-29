package com.elcom.catalog.dataservice.enums;

public enum DestinationTypes {
	PECOS("pecos"),
	FOLDER("folder"),
	SFTP("sftp");

	private DestinationTypes(String type) {
		m_type = type;
	}

	public String getDestinationType() {
		return m_type;
	}

	private String m_type;
	
	public static boolean isValidDestinationType(String type) {
		DestinationTypes[] destinationTypes = DestinationTypes.values();
		for(int index = 0; index < destinationTypes.length;index++) {
			if(type != null && type != "") {
				if(type.equalsIgnoreCase(destinationTypes[index].name())) {
					return true;
				}
			} else {
				return false;
			}
		}
		return false;
	}
}
