package com.elcom.catalog.dataservice.search.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Validated
public class SearchCriteria {

	
	@NotNull
	@Size(min = 3, message = "Search string must be at least 3 characters")
	@Size(max = 200, message = "Search string must be less than 200 characters")
	private String searchString;
	
	@NotNull
	@Min(value=0, message = "First record must be greater than zero")
	private Integer indexStart;
	
	@NotNull
	@Max(value=200, message = "Maximum number of records is limited to 200")
	private Integer numRecords;
	
	@JsonIgnore
	private String fieldToSearch;
	
	@JsonIgnore
	@Default
	private String[] additionalFieldsToSearch=new String[] {};
	
	@JsonIgnore
	private String[] searchFacets;
	
	@JsonIgnore
	private Class<?> objectToReturn;
	
	@JsonIgnore
	private Class<?> objectToSearch;
	
}
