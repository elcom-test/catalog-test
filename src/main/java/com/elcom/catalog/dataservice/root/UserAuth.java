package com.elcom.catalog.dataservice.root;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the USER_AUTH database table.
 * 
 */
@Data
@NoArgsConstructor
@Entity
@Table(name="USER_AUTH")
public class UserAuth implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	@Column(name="ACTIVE_FLAG", nullable=false, length=1)
	private String activeFlag;

	@Column(name="CAN_DELETE", length=1)
	private String canDelete;

	@Column(name="CAN_READ", length=1)
	private String canRead;

	@Column(name="CAN_WRITE", length=1)
	private String canWrite;

	@CreationTimestamp
	@Column(name="DATE_ROW_ADDED", nullable=false, updatable = false)
	private Date dateRowAdded;

	@UpdateTimestamp
	@Column(name="DATE_ROW_UPDATED", nullable=false)
	private Date dateRowUpdated;

	//bi-directional many-to-one association to Auth
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey(name = "FK_USER_AUTH_AUTH_NAME"), name="AUTH_NAME", nullable=false, insertable=false, updatable=false)
	@JsonBackReference
	private Auth auth;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey(name = "FK_USER_AUTH_USER_ID"), name="USER_ID", nullable=false, insertable=false, updatable=false)
	@JsonBackReference
	private User user;

}