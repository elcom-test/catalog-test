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
public abstract class CatalogItemBaseDTO {
	
	protected Long id;
	
	protected String type;
	protected String name;
	protected String supplierPartNo;
	protected String description;
	protected String activeFlag = "Y";// default val, can add validation instead later?
	
	protected long uomQty;	
	protected String preferredItemOrder;
	protected String itemBand;
	protected String validated;
	protected String expenseCode;
	protected String pendingFrom;
	protected String hcted;
	
	@JsonIgnore
	protected Date dateRowAdded;
	@JsonIgnore
	protected Date dateRowUpdated;
	

}
