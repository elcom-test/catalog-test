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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the ECLASS_CODES_LKUP database table.
 * 
 */
@Data
@NoArgsConstructor
@Entity
@Table(name="ECLASS_CODES_LKUP")
public class EClassCodesLookup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ECLASS_CODE_LKUP_ID_GENERATOR", sequenceName="ECLASS_CODE_LKUP_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ECLASS_CODE_LKUP_ID_GENERATOR")
	@Column(name="ECLASS_CODE_LKUP_ID", unique=true, nullable=false, length=10)
	private Long id;

	@Column(name="CODE", length=10)
	private String code;

	@Column(name="DESCRIPTION", length=255)
	private String description;
	
	@Column(name="DESCRIPTION_MSG_KEY", length=255)
	private String descriptionMsgKey;

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