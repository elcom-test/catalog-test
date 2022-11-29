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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the ITEM_CHANGE_LOG database table.
 * 
 */
@Data
@NoArgsConstructor
@Entity
@Table(name="ITEM_CHANGE_LOG")
public class ItemChangeLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ITEM_CHANGE_LOG_ID_GENERATOR", sequenceName="ITEM_CHANGE_LOG_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ITEM_CHANGE_LOG_ID_GENERATOR")
	@Column(name="ID", unique=true, nullable=false, length=10)
	private Long id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(foreignKey = @ForeignKey(name = "FK_ITEM_CHANGE_LOG_ITEM_ID"), name = "ITEM_ID", referencedColumnName = "id")
	@JsonBackReference
	private Item item;

	@Column(name="TYPE", length=10)
	private String type;

	@Column(name="INFORMATION", length=500)
	private String information;

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