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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the USERS database table.
 * 
 */
@Data
@NoArgsConstructor
@Entity
@Table(name="USERS")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USERS_ID_GENERATOR", sequenceName="USER_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USERS_ID_GENERATOR")
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

	@Column(name="FIRST_NAME", nullable=false, length=50)
	private String firstName;

	@Column(name="USER_NAME", nullable=false, length=50)
	private String userName;

	@Column(name="LAST_NAME", nullable=false, length=50)
	private String lastName;

	@JsonIgnoreProperties
	@Column(name="PASSWORD", nullable=false, length=50)
	private String password;

	//bi-directional many-to-one association to UserAuth
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	@Fetch(value = FetchMode.SUBSELECT)
	@JsonManagedReference
	private List<UserAuth> userAuths;

	public UserAuth addUserAuth(UserAuth userAuth) {
		getUserAuths().add(userAuth);
		userAuth.setUser(this);

		return userAuth;
	}

	public UserAuth removeUserAuth(UserAuth userAuth) {
		getUserAuths().remove(userAuth);
		userAuth.setUser(null);

		return userAuth;
	}

}