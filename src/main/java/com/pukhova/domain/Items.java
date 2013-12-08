package com.pukhova.domain;

// Generated 08.12.2013 23:24:28 by Hibernate Tools 3.6.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Items generated by hbm2java
 */
@Entity
@Table(name = "items", catalog = "share_it")
public class Items implements java.io.Serializable {

	private Integer itemId;
	private Categories categories;
	private Users users;
	private String description;
	private String itemName;
	private String conditions;
	private Integer maxParticipants;
	private Integer daysAvaiable;
	private Date dateAdded;
	private Set<Photos> photoses = new HashSet<Photos>(0);

	public Items() {
	}

	public Items(Categories categories) {
		this.categories = categories;
	}

	public Items(Categories categories, Users users, String description,
			String itemName, String conditions, Integer maxParticipants,
			Integer daysAvaiable, Date dateAdded, Set<Photos> photoses) {
		this.categories = categories;
		this.users = users;
		this.description = description;
		this.itemName = itemName;
		this.conditions = conditions;
		this.maxParticipants = maxParticipants;
		this.daysAvaiable = daysAvaiable;
		this.dateAdded = dateAdded;
		this.photoses = photoses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "itemId", unique = true, nullable = false)
	public Integer getItemId() {
		return this.itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "categoryId", nullable = false)
	public Categories getCategories() {
		return this.categories;
	}

	public void setCategories(Categories categories) {
		this.categories = categories;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "holderId")
	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@Column(name = "description", length = 65535)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "itemName", length = 60)
	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	@Column(name = "conditions", length = 65535)
	public String getConditions() {
		return this.conditions;
	}

	public void setConditions(String conditions) {
		this.conditions = conditions;
	}

	@Column(name = "maxParticipants")
	public Integer getMaxParticipants() {
		return this.maxParticipants;
	}

	public void setMaxParticipants(Integer maxParticipants) {
		this.maxParticipants = maxParticipants;
	}

	@Column(name = "daysAvaiable")
	public Integer getDaysAvaiable() {
		return this.daysAvaiable;
	}

	public void setDaysAvaiable(Integer daysAvaiable) {
		this.daysAvaiable = daysAvaiable;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dateAdded", length = 19)
	public Date getDateAdded() {
		return this.dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "items")
	public Set<Photos> getPhotoses() {
		return this.photoses;
	}

	public void setPhotoses(Set<Photos> photoses) {
		this.photoses = photoses;
	}

}