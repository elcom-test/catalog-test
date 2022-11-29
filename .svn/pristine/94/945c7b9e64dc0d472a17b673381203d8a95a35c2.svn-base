package com.elcom.catalog.dataservice.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public class BaseServiceImpl {

	protected <T> Object mapObject(Object inObject, Class<?> outClass) {
		
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Object outObject = modelMapper.map(inObject, outClass);
		
		return outObject;
	}
	
	
	protected <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
		
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
	    return source
	      .stream()
	      .map(element -> modelMapper.map(element, targetClass))
	      .collect(Collectors.toList());
	}
	
}
