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
 * The persistent class for the UNSPSC_CODE_LKUP database table.
 * 
 */
@Data
@NoArgsConstructor
@Entity
@Table(name="UNSPSC_CODE")
public class UNSPSCCode implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="UNSPSC_CODE_ID_GENERATOR", sequenceName="UNSPSC_CODE_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UNSPSC_CODE_ID_GENERATOR")
	@Column(name="ID", unique=true, nullable=false, length=10)
	private Long id;

	@Column(name="KEY", length=50)
	private String key;
	
	@Column(name="PARENT_KEY", length=50)
	private String parentKey;
	
	@Column(name="CODE", length=50)
	private String code;

	@Column(name="TITLE", length=255)
	private String title;

	@Column(name="TITLE_MSG_KEY", length=255)
	private String titleMsgKey;
	
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