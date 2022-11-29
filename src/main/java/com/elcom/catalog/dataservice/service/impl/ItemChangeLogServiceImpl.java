package com.elcom.catalog.dataservice.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elcom.catalog.dataservice.repository.ItemChangeLogRepository;
import com.elcom.catalog.dataservice.root.ItemChangeLog;
import com.elcom.catalog.dataservice.service.ItemChangeLogService;
@Service
public class ItemChangeLogServiceImpl implements ItemChangeLogService {
	
	@Autowired
	ItemChangeLogRepository itemChangeLogRepository;

	@Override
	public Optional<ItemChangeLog> getItemChangeLog(ItemChangeLog itemChangeLog) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<ItemChangeLog> getItemChangeLogById(Long id) {
		
		return itemChangeLogRepository.findById(id);
	}

	@Override
	public void saveItemChangeLogAttrbute(ItemChangeLog itemChangeLog) {
		itemChangeLogRepository.saveAndFlush(itemChangeLog);
	}

	@Override
	public void deleteItemCangeLog(Long id) {
		itemChangeLogRepository.deleteById(id);		
	}

	@Override
	public List<ItemChangeLog> getAllItemChangeLogs() {
		
		return itemChangeLogRepository.findAll();
	}

	

}
