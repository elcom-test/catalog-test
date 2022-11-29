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

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="TAX_TYPES")
public class TaxTypes implements Serializable {
	/**
	 *
 	*/
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TAX_TYPES_ID_GENERATOR", sequenceName="TAX_TYPES_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TAX_TYPES_ID_GENERATOR")
	@Column(name="ID", unique=true, nullable=false, length=10)
	private Long id;

	@Column(name="KEY", nullable=false, length=30)
	private String key;

	@Column(name="PERCENTAGE", nullable=false, precision=10, scale = 4)
	private double percentage;

	@Column(name="DESCRIPTION", nullable=false, length=255)
	private String description;

	@CreationTimestamp
	@Column(name="DATE_ROW_ADDED", nullable=false, updatable = false)
	private java.util.Date dateRowAdded;

	@UpdateTimestamp
	@Column(name="DATE_ROW_UPDATED", nullable=false)
	private Date dateRowUpdated;

	@Column(name="ACTIVE_FLAG", nullable=false, length=1)
	private String activeFlag;
}