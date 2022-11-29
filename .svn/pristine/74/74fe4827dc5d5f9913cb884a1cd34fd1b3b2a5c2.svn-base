package com.elcom.catalog.dataservice.root.dto;

import java.util.Date;
import java.util.Set;

import javax.validation.constraints.NotBlank;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public abstract class ItemBarcodeBaseDTO {
	
	protected Long id;
	@NotBlank(message="Item barcode \"code\" is a required field")
	protected String code;
	@NotBlank(message="Item barcode \"type\" is a required field")
	protected String type;
	protected String codeString;
	protected long codeInt;
	protected String activeFlag="Y";
	
	@JsonIgnore
	protected Date dateRowAdded;
	@JsonIgnore
	protected Date dateRowUpdated;
	
	@JsonBackReference
	protected ItemBarcodeBaseDTO parentItemBarcode;
	
	@JsonIgnore
	protected Set<ItemBarcodeBaseDTO> childItemBarcodes;

}
