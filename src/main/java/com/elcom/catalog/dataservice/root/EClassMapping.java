package com.elcom.catalog.dataservice.root;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Facet;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Indexed
@Table(name="ECLASS_MAPPING")
public class EClassMapping {
	
	@Id
	@SequenceGenerator(name="ECLASS_MAP_LKUP_ID_GENERATOR", sequenceName="ECLASS_MAP_LKUP_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ECLASS_MAP_LKUP_ID_GENERATOR")
	@Column(name="ID", unique=true, nullable=false, length=10)
    private Long id;
	
	@Column(name="ECLASS_CODE", length=3)
	@Field
	@Field(name="combined")
	@Field(name = "eclass_code_for_facet", analyze = Analyze.NO)
	@Facet(name = "eclass_code_facet", forField = "eclass_code_for_facet")
	private String eclassCode;
	
	@Column(name="ECLASS_DESCRIPTION", length=512)
	@Field
	@Field(name="combined")
	@Field(name = "eclass_desc_for_facet", analyze = Analyze.NO)
	@Facet(name = "eclass_desc_facet", forField = "eclass_desc_for_facet")
	private String eclassDescription;
	
	@Column(name="COMMENTS", length=64)
	@Field
	private String fullTitle;
	
	@Column(name="UNSPSC_CODE", length=8)
	@Field
	private String unspscCode;
	
	@Column(name="UNSPCS_DESCRIPTION", length=128)
	@Field
	private String unspscDescription;
	
	@Column(name="TFR_CODE", length=3)
	@Field
	private String tfrCode;
	
	@Column(name="TFR_DESCRIPTION", length=64)
	@Field
	private String tfrDescription;
	
	@Column(name="NCA_CODE", length=4)
	@Field
	private String ncaCode;
	
	@Column(name="NCA_DESCRIPTION", length=64)
	@Field
	private String ncaDescription;
		
}
