package net.mdsgene.admin.admintool.entities;

import net.mdsgene.admin.admintool.dal.FamilyDAO;
import com.xdev.dal.DAO;
import com.xdev.util.Caption;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * Family
 */
@DAO(daoClass = FamilyDAO.class)
@Caption("{%name}")
@Entity
@Table(name = "families", schema = "public", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
@Cacheable(false)
public class Family implements java.io.Serializable {

	private int id;
	private String name;
	private Boolean history;
	private Integer numHetMutAffected;
	private Integer numHomMutAffected;
	private Integer numHetMutUnaffected;
	private Integer numHomMutUnaffected;
	private Integer numWildtypeAffected;
	private Integer numWildtypeUnaffected;
	private Date createdAt;
	private Date updatedAt;
	private Set<Patient> patients = new HashSet<Patient>(0);

	public Family() {
	}

	@Caption("Id")
	@Id

	@Column(name = "id", unique = true, nullable = false, columnDefinition = "serial")
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Caption("Name")
	@Column(name = "name", unique = true, nullable = false, columnDefinition = "varchar", length = 64)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Caption("History")
	@Column(name = "history", columnDefinition = "bool")
	public Boolean getHistory() {
		return this.history;
	}

	public void setHistory(Boolean history) {
		this.history = history;
	}

	@Caption("NumHetMutAffected")
	@Column(name = "num_het_mut_affected", columnDefinition = "int4")
	public Integer getNumHetMutAffected() {
		return this.numHetMutAffected;
	}

	public void setNumHetMutAffected(Integer numHetMutAffected) {
		this.numHetMutAffected = numHetMutAffected;
	}

	@Caption("NumHomMutAffected")
	@Column(name = "num_hom_mut_affected", columnDefinition = "int4")
	public Integer getNumHomMutAffected() {
		return this.numHomMutAffected;
	}

	public void setNumHomMutAffected(Integer numHomMutAffected) {
		this.numHomMutAffected = numHomMutAffected;
	}

	@Caption("NumHetMutUnaffected")
	@Column(name = "num_het_mut_unaffected", columnDefinition = "int4")
	public Integer getNumHetMutUnaffected() {
		return this.numHetMutUnaffected;
	}

	public void setNumHetMutUnaffected(Integer numHetMutUnaffected) {
		this.numHetMutUnaffected = numHetMutUnaffected;
	}

	@Caption("NumHomMutUnaffected")
	@Column(name = "num_hom_mut_unaffected", columnDefinition = "int4")
	public Integer getNumHomMutUnaffected() {
		return this.numHomMutUnaffected;
	}

	public void setNumHomMutUnaffected(Integer numHomMutUnaffected) {
		this.numHomMutUnaffected = numHomMutUnaffected;
	}

	@Caption("NumWildtypeAffected")
	@Column(name = "num_wildtype_affected", columnDefinition = "int4")
	public Integer getNumWildtypeAffected() {
		return this.numWildtypeAffected;
	}

	public void setNumWildtypeAffected(Integer numWildtypeAffected) {
		this.numWildtypeAffected = numWildtypeAffected;
	}

	@Caption("NumWildtypeUnaffected")
	@Column(name = "num_wildtype_unaffected", columnDefinition = "int4")
	public Integer getNumWildtypeUnaffected() {
		return this.numWildtypeUnaffected;
	}

	public void setNumWildtypeUnaffected(Integer numWildtypeUnaffected) {
		this.numWildtypeUnaffected = numWildtypeUnaffected;
	}

	@Caption("CreatedAt")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", nullable = false, columnDefinition = "timestamp", length = 29)
	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Caption("UpdatedAt")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at", nullable = false, columnDefinition = "timestamp", length = 29)
	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Caption("Patients")
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "family")
	public Set<Patient> getPatients() {
		return this.patients;
	}

	public void setPatients(Set<Patient> patients) {
		this.patients = patients;
	}

}
