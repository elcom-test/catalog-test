/*******************************************************************************
 * Copyright (c) 2016-2017 Elcom International Inc.
 * 50 Braintree Hill Office Park, Suite 309, Braintree, MA 02184, U.S.A.
 * All rights reserved.
 * 
 * This software is the confidential and proprietary information of
 * Elcom International Inc. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Elcom.
 * 
 ******************************************************************************/
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

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.search.annotations.ContainedIn;
import org.hibernate.search.annotations.Field;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="COMPANY_ADDRESS")
public class CompanyAddress implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COMPANY_ADDRESS_ID_GENERATOR", sequenceName="COMPANY_ADDRESS_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COMPANY_ADDRESS_ID_GENERATOR")
	@Column(name="ID", unique=true, nullable=false, length=10)
	private Long id;
	
	@Field
	@Column(name="GLN", length=15, nullable=false)
	private String gln;

	@Field
	@Column(name="ADDRESS_NAME", length=50, nullable=false)
	private String addressName;

	@Field
	@Column(name="LINE1", length=255)
	private String line1;
	
	@Column(name="LINE2", length=255)
	private String line2;
	
	@Column(name="LINE3", length=255)
	private String line3;

	@Field
	@Column(name="CITY", length=255)
	private String city;
	
	@Field
	@Column(name="POSTAL_CODE", length=10)
	private String postalCode;
	
	@Field
	@Column(name="NUTS_CODE", length=10)
	private String nutsCode;
	
	@Column(name="COUNTRY_CODE", length=10)
	private String countryCode;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "FK_COMPANY_ADDRESS_COMPANY_ID"), name = "COMPANY_ID", referencedColumnName = "id")
	@JsonBackReference
	@ContainedIn
	private Company company;
	
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
