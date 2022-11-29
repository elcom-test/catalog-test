package com.elcom.catalog.dataservice.root.dto;

import java.util.Date;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Validated
public abstract class CatalogItemAttributeBaseDTO {
	
	protected Long id;
	
	protected String key;

	protected String value;

	protected String activeFlag;

	@JsonIgnore
	protected Date dateRowAdded;
	@JsonIgnore
	protected Date dateRowUpdated;

}
