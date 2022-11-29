package com.elcom.catalog.dataservice.enums;

import java.util.HashMap;
import java.util.Map;

public enum TransactionStatus {
	Unknown_Status("Unknown Status", 0),
	Unknown_failure("Unknown Failure", 1),
	Archiving_failure("Archiving Failure",2),
	Serializing_failure("Serializing Failure", 3),
	Partner_Pair_Validation_Failure("Partner Pair Validation Failure",4),
	Initialization_failure("Initialization Failure", 5),
	Document_Saving_Failure("Document Saving Failure",6),
	Validation_failure("Validation Failure",7),
	Authentication_failure("Authentication Failure",8),
	Parsing_failure("Parsing Failure",9),
	Transformation_failure("Transformation Failure",10),
	Response_failure("Response Failure",11),
	PROCESSED("Processed",12),
	Delivery_failure_no_supplier("Delivery Failure - no supplier",13),
	Delivery_failure_no_origin_doc("Delivery Failure - no origin document",14),
	Delivery_failure_duplicate_doc("Delivery Failure - duplicate document",15),
	Delivery_failure_other_rejection("Delivery Failure - other rejection",16),
	Delivery_failure("Delivery Failure",17),
	SUCCESS("Success", 18),
	Triage_Required("Triage Required", 19),
	Triage_Ready("Triage Ready", 20),
	Triage_Actioned("Triage Actioned", 21),
	Triage_Could_Not_Be_Actioned("Triage could not be Actioned", 22),
	Could_Not_Open_Document("Document could not be opened", 23),
	Automatic_Triage("Auotmatic Triage", 24),
	Could_Not_Auto_Triage("Could Not Auotmatically Triage Document", 25),
	Pdf_Is_Image("Pdf file is image.", 26),
	Document_Received("Document Received", 27),
	Triage_Parse_Attempts_Limit("Document could not be triaged - maximum limit for triage exceeded", 28);
	
	public static TransactionStatus getById(long id) {
		return BY_STATUSID.get(id);
	}
	
	public static TransactionStatus getByLabel(String label) {
		return BY_STATUSLABEL.get(label);
	}
	
	public static long getByStatus(TransactionStatus ts) {
		return ts.statusId;
	}
	
	private TransactionStatus(String label, long id) {
		statusLabel = label;
		statusId = id;
	}
	
	public long getStatusId() {
		return statusId;
	}
	
	public String getStatusLabel() {
		return statusLabel;
	}
	
	private static final Map<String, TransactionStatus> BY_STATUSLABEL = new HashMap<>();
    private static final Map<Long, TransactionStatus> BY_STATUSID = new HashMap<>();
    
    static {
        for (TransactionStatus e : values()) {
        	BY_STATUSLABEL.put(e.statusLabel, e);
        	BY_STATUSID.put(e.statusId, e);
        }
    }

	private String statusLabel;
	private long statusId;

}
