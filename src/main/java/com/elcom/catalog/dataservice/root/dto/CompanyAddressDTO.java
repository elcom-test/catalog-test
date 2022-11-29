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
public class CompanyAddressDTO {

	private Long id;

	private String gln;
	private String addressName;
	private String line1;
	private String line2;
	private String line3;
	private String postalCode;
	private String nutsCode;
	private String activeFlag;

	@JsonIgnore
	private Date dateRowAdded;
	@JsonIgnore
	private Date dateRowUpdated;	
	
}
