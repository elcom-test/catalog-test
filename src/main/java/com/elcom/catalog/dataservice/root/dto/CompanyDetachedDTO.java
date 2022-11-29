package com.elcom.catalog.dataservice.root.dto;

import org.springframework.validation.annotation.Validated;

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
@Validated
public class CompanyDetachedDTO extends CompanyBaseDTO {

	private Long companyAddressId; 
		
}
