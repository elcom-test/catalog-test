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
public abstract class CompanyBaseDTO {

	private Long id;
	@NotBlank(message="Company name is required")
	private String companyName;
	private String companiesHouseNo;
	private String dunsNo;
	
	private SICCodeDTO sicCode;
	@NotBlank(message="Company address is required")
	private CompanyAddressDTO address;
	private String nutsCode;
	private String status;
	private String refresh;
	private String activeFlag;

	@JsonIgnore
	private Date dateRowAdded;
	@JsonIgnore
	private Date dateRowUpdated;
	
}
