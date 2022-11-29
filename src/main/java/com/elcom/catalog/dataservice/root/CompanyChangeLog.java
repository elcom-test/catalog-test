package com.elcom.catalog.dataservice.root;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the COMPANY_CHANGE_LOG database table.
 * 
 */
@Data
@NoArgsConstructor
@Entity
@Table(name="COMPANY_CHANGE_LOG")
public class CompanyChangeLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COMPANY_CHANGE_LOG_ID_GENERATOR", sequenceName="COMPANY_CHANGE_LOG_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COMPANY_CHANGE_LOG_ID_GENERATOR")
	@Column(name="ID", unique=true, nullable=false, length=10)
	private Long id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(foreignKey = @ForeignKey(name = "FK_COMPANY_CHANGE_LOG_COMPANY_ID"), name = "COMPANY_ID", referencedColumnName = "id")
	@JsonManagedReference
	private Company company;

	@Column(name="TYPE", length=10)
	private String type;

	@Column(name="INFORMATION", length=500)
	private String information;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(foreignKey = @ForeignKey(name = "FK_COMPANY_CHANGE_LOG_IMPORT_ID"), name = "IMPORT_ID", referencedColumnName = "id")
	@JsonManagedReference
	private ImportTransactions importTransaction;

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