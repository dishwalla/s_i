package com.pukhova.domain;

// Generated 08.12.2013 23:24:28 by Hibernate Tools 3.6.0

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Users generated by hbm2java
 */
@Entity
@Table(name = "users", catalog = "share_it", uniqueConstraints = {
		@UniqueConstraint(columnNames = "email"),
		@UniqueConstraint(columnNames = "passHash") })
public class Users implements java.io.Serializable {

	private Integer userId;
	private String name;
	private String surname;
	private String email;
	private String phone;
	private String passHash;
	private String avatarRelativePath;
	private Set<Items> itemses = new HashSet<Items>(0);

	public Users() {
	}

	public Users(String email, String phone) {
		this.email = email;
		this.phone = phone;
	}

	public Users(String name, String surname, String email, String phone,
			String passHash, String avatarRelativePath, Set<Items> itemses) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.phone = phone;
		this.passHash = passHash;
		this.avatarRelativePath = avatarRelativePath;
		this.itemses = itemses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "userId", unique = true, nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "name", length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "surname", length = 45)
	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Column(name = "email", unique = true, nullable = false, length = 45)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "phone", nullable = false, length = 20)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "passHash", unique = true, length = 45)
	public String getPassHash() {
		return this.passHash;
	}

	public void setPassHash(String passHash) {
		this.passHash = passHash;
	}

	@Column(name = "avatarRelativePath", length = 130)
	public String getAvatarRelativePath() {
		return this.avatarRelativePath;
	}

	public void setAvatarRelativePath(String avatarRelativePath) {
		this.avatarRelativePath = avatarRelativePath;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
	public Set<Items> getItemses() {
		return this.itemses;
	}

	public void setItemses(Set<Items> itemses) {
		this.itemses = itemses;
	}

}