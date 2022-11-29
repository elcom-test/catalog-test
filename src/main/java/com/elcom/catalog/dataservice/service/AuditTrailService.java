package com.elcom.catalog.dataservice.service;

import com.elcom.catalog.dataservice.root.AuditTrail;

public interface AuditTrailService {
	Iterable<AuditTrail> getAllAuditTrails();
	AuditTrail saveAuditTrail(AuditTrail auditTrail);
	void deleteAuditTrail(AuditTrail auditTrail);
}