package com.elcom.catalog.dataservice.root;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the SIC_CODES_LKUP database table.
 * 
 */
@Data
@NoArgsConstructor
@Entity
@Indexed
@Table(name="SIC_CODE")
public class SICCode implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SIC_CODE_ID_GENERATOR", sequenceName="SIC_CODE_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SIC_CODE_ID_GENERATOR")
	@Column(name="ID", unique=true, nullable=false, length=10)
	private Long id;

	@Field
	@Field(name="sic_code.combined")
	@Column(name="SIC_CODE", length=50)
	private String sicCode;

	@Field
	@Field(name="sic_code.combined")
	@Column(name="DESCRIPTION", length=255)
	private String description;

	@Column(name="SECTION", length=1)
	private String section;
	
	@Column(name="SECTION_DESCRIPTION", length=128)
	private String sectionDescription;
	
	@Column(name="ACTIVE_FLAG", nullable=false, length=1)
	private String activeFlag;

	@CreationTimestamp
	@JsonIgnore
	@Column(name="DATE_ROW_ADDED", nullable=false, updatable = false)
	private Date dateRowAdded;

	@UpdateTimestamp
	@JsonIgnore
	@Column(name="DATE_ROW_UPDATED", nullable=false)
	private Date dateRowUpdated;
}