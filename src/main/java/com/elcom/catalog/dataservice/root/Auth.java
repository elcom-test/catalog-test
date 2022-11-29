package com.elcom.catalog.dataservice.root;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.UpdateTimestamp;

import com.elcom.catalog.dataservice.root.Auth.AuthName;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the AUTH database table.
 * 
 */
@Data
@NoArgsConstructor
@Entity
@Table(name="AUTH")
@IdClass(AuthName.class)
public class Auth implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="AUTH_NAME", unique=true, nullable=false, length=50)
	private String authName;

	@Column(name="ACTIVE_FLAG", nullable=false, length=1)
	private String activeFlag;

	@CreationTimestamp
	@Column(name="DATE_ROW_ADDED", nullable=false, updatable = false)
	private Date dateRowAdded;

	@UpdateTimestamp
	@Column(name="DATE_ROW_UPDATED", nullable=false)
	private Date dateRowUpdated;

	//bi-directional many-to-one association to UserAuth
	@OneToMany(cascade = CascadeType.ALL, mappedBy="auth")
	@Fetch(value = FetchMode.SUBSELECT)
	@JsonManagedReference
	private List<UserAuth> userAuths;

	public UserAuth addUserAuth(UserAuth userAuth) {
		getUserAuths().add(userAuth);
		userAuth.setAuth(this);

		return userAuth;
	}

	public UserAuth removeUserAuth(UserAuth userAuth) {
		getUserAuths().remove(userAuth);
		userAuth.setAuth(null);

		return userAuth;
	}

	@Data
	@NoArgsConstructor
	public static class AuthName implements Serializable {

		private static final long serialVersionUID = 1L;
		private String authName;

	}

}