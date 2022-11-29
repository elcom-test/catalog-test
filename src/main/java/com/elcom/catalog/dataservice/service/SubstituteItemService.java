package com.elcom.catalog.dataservice.service;

import java.util.List;
import java.util.Optional;

import com.elcom.catalog.dataservice.root.SubstituteItem;

public interface SubstituteItemService {
	

	public Optional<SubstituteItem> getSubstituteItem(SubstituteItem substituteItem);
	public Optional<SubstituteItem> getSubstituteItemById(Long id);
	public void saveSubstituteItemAttrbute(SubstituteItem substituteItem);	
	// hibernate search methods
	public List<SubstituteItem> searchSubstituteItem(String searchCriteria);
	

}
