package com.elcom.catalog.dataservice.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elcom.catalog.dataservice.repository.SubstituteItemRepository;
import com.elcom.catalog.dataservice.root.SubstituteItem;
import com.elcom.catalog.dataservice.service.SubstituteItemService;
@Service
public class SubstituteItemServiceImpl implements SubstituteItemService {
	
	@Autowired
	SubstituteItemRepository substituteItemRepository ;

	@Override
	public Optional<SubstituteItem> getSubstituteItem(SubstituteItem substituteItem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<SubstituteItem> getSubstituteItemById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveSubstituteItemAttrbute(SubstituteItem substituteItem) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<SubstituteItem> searchSubstituteItem(String searchCriteria) {
		// TODO Auto-generated method stub
		return null;
	}

}
