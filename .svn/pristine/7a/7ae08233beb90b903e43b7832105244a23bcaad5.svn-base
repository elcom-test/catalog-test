package com.elcom.catalog.dataservice.root.dto;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Validated
public class CatalogItemPriceDTO extends CatalogItemPriceBaseDTO{
	

	@JsonBackReference(value="catalogItemPrice")
	private CatalogItemDTO catalogItem;

}
