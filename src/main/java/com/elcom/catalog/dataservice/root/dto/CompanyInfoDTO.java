package com.elcom.catalog.dataservice.root.dto;

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
public class CompanyInfoDTO {

	private Long companyId;
	private String companyName;
	private String dunsNumber;
	private String companiesHouseNo;
	private String postCode;
	
}
