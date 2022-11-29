package com.elcom.catalog.dataservice.root.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class ItemAssetBaseDTO {
	
	protected Long id;
	
	protected String assetType;
	protected String resourceLocation;
	
	protected String activeFlag = "Y";
	@JsonIgnore
	protected Date dateRowAdded;
	@JsonIgnore
	protected Date dateRowUpdated;
}
