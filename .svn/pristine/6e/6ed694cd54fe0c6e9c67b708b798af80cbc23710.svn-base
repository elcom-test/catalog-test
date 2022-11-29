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
public abstract class ItemAttributeBaseDTO {

	protected Long id;
	
	@NotBlank(message="An item attribute type is required")
	protected String type;
	@NotBlank(message="An item attribute key is required")
	protected String key;
	@NotBlank(message="An item attribute value is required")
	protected String value;
	protected String activeFlag = "Y";
	@JsonIgnore
	protected Date dateRowAdded;
	@JsonIgnore
	protected Date dateRowUpdated;
	
}
