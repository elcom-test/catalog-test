package com.elcom.catalog.dataservice.root;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the FAIL_CODE database table.
 * 
 */
@Data
@NoArgsConstructor
@Entity
@Table(name="FAIL_CODE")
public class FailCode implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="FAIL_CODE_ID_GENERATOR", sequenceName="FAIL_CODE_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FAIL_CODE_ID_GENERATOR")
	@Column(name="ID", unique=true, nullable=false, length=10)
	private Long id;

	@Column(name="ACTIVE_FLAG", nullable=false, length=1)
	private String activeFlag;

	@CreationTimestamp
	@Column(name="DATE_ROW_ADDED", nullable=false, updatable = false)
	private Date dateRowAdded;

	@UpdateTimestamp
	@Column(name="DATE_ROW_UPDATED", nullable=false)
	private Date dateRowUpdated;

	@Column(name="DESCRIPTION", length=50)
	private String description;

	@Column(name="NAME", length=50)
	private String name;

	@Column(name="TEXT", length=100)
	private String text;
	
	//bi-directional many-to-one association to AuditTrail
	@OneToMany(cascade = CascadeType.ALL, mappedBy="failCode")
	@Fetch(value = FetchMode.SUBSELECT)
	@JsonBackReference
	private List<AuditTrail> auditTrails;
}