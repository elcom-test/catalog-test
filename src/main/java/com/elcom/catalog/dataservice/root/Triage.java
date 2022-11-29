package com.elcom.catalog.dataservice.root;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The persistent class for the TRIAGE database table.
 * 
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="TRIAGE")
public class Triage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TRIAGE_ID_GENERATOR", sequenceName="TRIAGE_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TRIAGE_ID_GENERATOR")
	@Column(name="ID", unique=true, nullable=false, length=10)
	private Long id;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "FK_TRIAGE_TRIAGE_ACTION_ID"), name="TRIAGE_ACTION_ID")
	@JsonManagedReference
	private TriageAction action;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "FK_TRIAGE_USER_ID"), name="USER_ID")
	@JsonManagedReference
	private User user;
	
	@Column(name="TRIAGE_NOTES", length=500)
	private String notes;
	
	@Column(name="EMAIL_TO", length=200)
	private String emailTo;
	
	@Column(name="EMAIL_SUBJECT", length=500)
	private String emailSubject;
	
	@Column(name="EMAIL_BODY", length=2000)
	private String emailBody;
	
	@Column(name="INCLUDE_ATTACHMENT", nullable=false, length=1)
	private String includeAttachment;
	
	@CreationTimestamp
	@Column(name="DATE_ROW_ADDED", nullable=false, updatable = false)
	private Date dateRowAdded;

	@UpdateTimestamp
	@Column(name="DATE_PROCESSED", nullable=false)
	private Date dateProcessed;

	@Column(name="ACTIVE_FLAG", nullable=false, length=1)
	private String activeFlag;
	
	@Transient
	private boolean autoTriage = false;

}