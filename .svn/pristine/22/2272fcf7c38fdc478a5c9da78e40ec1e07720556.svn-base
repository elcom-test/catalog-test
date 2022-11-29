package com.elcom.catalog.dataservice.root.dto;
import java.util.Date;
import java.util.Set;

import org.hibernate.search.annotations.Indexed;

import com.elcom.catalog.dataservice.root.SubstituteItem;
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
@Indexed
@Builder
public class CatalogItemAttributeDTO extends CatalogItemAttributeBaseDTO{

	

	@JsonBackReference(value="catalogItemAttributes")
	private CatalogItemDTO catalogItem;
	
	

}
