package com.elcom.catalog.dataservice.root.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemChangeLogDTO {

	private Long id;
	@JsonBackReference(value="itemChangeLog")
	private ItemDTO item;
	private String type;
	private String information;
	@Default
	private String activeFlag = "Y";
	@JsonIgnore
	private Date dateRowAdded;
	@JsonIgnore
	private Date dateRowUpdated;
	
}
