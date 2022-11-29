package com.elcom.catalog.dataservice.root;

public interface TriageDTO {

	Integer getTransmissionAttempts();
	String getOriginDocumentNo();
	 	
	// buyer info
	String getBuyerName();
		
	// supplier info
	String getSupplierName();
	
	// document info
	Long getDocumentId();
	String getDocumentDate();
	String getDateReceived();
	String getDocumentType();
	String getDocumentName();
	String getDocumentNumber();
	String getDocumentLocation();
	String getStandardType();
	
	// fail code
	String getFailCode();
	
	// transaction statusId
	String getStatus();
}

