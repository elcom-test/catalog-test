package com.elcom.catalog.dataservice.root.dto;

import javax.validation.constraints.NotBlank;

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
public class CompanyDTO extends CompanyBaseDTO {

	@NotBlank(message="Company address is required")
	private CompanyAddressDTO address;
		
}
