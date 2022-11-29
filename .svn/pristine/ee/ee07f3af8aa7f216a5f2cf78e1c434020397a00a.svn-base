package com.elcom.catalog.dataservice.root;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the AUDIT_TRAIL database table.
 * 
 */
@Data
@NoArgsConstructor
@Entity
@Table(name="AUDIT_TRAIL")
public class AuditTrail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="AUDITTRAIL_ID_GENERATOR", sequenceName="AUDIT_TRAIL_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AUDITTRAIL_ID_GENERATOR")
	@Column(name="ID", unique=true, nullable=false, length=10)
	private Long id;

	@Column(name="COMMENTS", length=255)
	private String comments;

	@Column(name="DISPLAY_TEXT", length=4000)
	private String displayText;

	@Column(name="STATUS_ADDTL_INFO", length=100)
	private String statusAddtlInfo;

	@Column(name="DOCUMENT_NO", nullable=false, length = 255)
	private String documentNo;
	
	@Column(name="STATUS_ID", nullable=false, length=10)
	private long statusId;

	@CreationTimestamp
	@Column(name="DATE_ROW_ADDED", nullable=false, updatable = false)
	private java.util.Date dateRowAdded;
	
	//bi-directional many-to-one association to FailCode
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey(name = "FK_AUDIT_TRAIL_FAIL_CODE_ID"), name="FAIL_CODE_ID")
	@JsonManagedReference
	private FailCode failCode;
}