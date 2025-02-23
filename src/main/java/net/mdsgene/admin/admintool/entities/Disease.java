package net.mdsgene.admin.admintool.entities;

import net.mdsgene.admin.admintool.dal.DiseaseDAO;
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
 * Disease
 */
@DAO(daoClass = DiseaseDAO.class)
@Caption("{%name}")
@Entity
@Table(name = "diseases", schema = "public", uniqueConstraints = @UniqueConstraint(columnNames = "abbreviation"))
@Cacheable(false)
public class Disease implements java.io.Serializable {

	private int id;
	private String name;
	private String abbreviation;
	private boolean launched;
	private Date createdAt;
	private Date updatedAt;
	private Set<SystematicReview> systematicReviews = new HashSet<SystematicReview>(0);
	private Set<Patient> patients = new HashSet<Patient>(0);
	private Integer parentId;

	public Disease() {
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
	@Column(name = "name", columnDefinition = "varchar", length = 128)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Caption("Abbreviation")
	@Column(name = "abbreviation", unique = true, nullable = false, columnDefinition = "varchar", length = 16)
	public String getAbbreviation() {
		return this.abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	@Caption("Launched")
	@Column(name = "launched", nullable = false, columnDefinition = "bool")
	public boolean isLaunched() {
		return this.launched;
	}

	public void setLaunched(boolean launched) {
		this.launched = launched;
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

	@Caption("SystematicReviews")
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "disease")
	public Set<SystematicReview> getSystematicReviews() {
		return this.systematicReviews;
	}

	public void setSystematicReviews(Set<SystematicReview> systematicReviews) {
		this.systematicReviews = systematicReviews;
	}

	@Caption("Patients")
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "disease")
	public Set<Patient> getPatients() {
		return this.patients;
	}

	public void setPatients(Set<Patient> patients) {
		this.patients = patients;
	}
	
	@Column(name = "parent_id", columnDefinition = "int4")
	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}	

}
