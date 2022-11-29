package com.elcom.catalog.dataservice.root.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;

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
public abstract class ItemTaxonomyBaseDTO {

	protected Long id;
	@NotBlank(message="Item taxonomy \"assetType\" is a required field")
	protected String assetType;
	@NotBlank(message="Item taxonomy \"resourceLocation\" is a required field")
	protected String resourceLocation;
	protected String activeFlag = "Y";
	@JsonIgnore
	protected Date dateRowAdded;
	@JsonIgnore
	protected Date dateRowUpdated;	
}
