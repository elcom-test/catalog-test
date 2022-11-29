package com.elcom.catalog.dataservice.root.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SICCodeDTO {

	private Long id;
	private String sicCode;
	private String description;
	private String section;
	private String sectionDescription;
	
	private String activeFlag;
	@JsonIgnore
	private Date dateRowAdded;
	@JsonIgnore
	private Date dateRowUpdated;
	
}
