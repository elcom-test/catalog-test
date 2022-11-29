package com.elcom.catalog.dataservice.root.dto;

import java.math.BigDecimal;
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
public abstract class CatalogItemPriceBaseDTO {
	
	protected Long id;
	protected BigDecimal listPrice;
	protected String currency;
	protected String priceType;
	protected Integer priceBreakMinQty;
	protected Integer priceBreakMaxQty;
	protected Integer priceBreakStyle;
	protected Date validFrom;
	protected Date validTo;
	protected String leadTime;
	protected Integer minOrderQty;
	protected Integer maxOrderQty;
	protected String tax;
	protected String activeFlag;
	
	
	@JsonIgnore
	protected Date dateRowAdded;
	@JsonIgnore
	protected Date dateRowUpdated;

}
