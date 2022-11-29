package com.elcom.catalog.dataservice.service;

import java.util.List;

import com.elcom.catalog.dataservice.root.FailCode;

public interface FailCodeService {
	Iterable<FailCode> getAllFailCodes();
	FailCode saveFailCode(FailCode failCode);
	FailCode getFailCodeByName(String failCde);
	FailCode findById(long id);
	List<FailCode> getAllFailCodesList();
}