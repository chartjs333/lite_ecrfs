package net.mdsgene.admin.admintool.entities;

import net.mdsgene.admin.admintool.dal.SymptomDAO;
import com.xdev.dal.DAO;
import com.xdev.util.Caption;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Cache;

/**
 * Symptom
 */
@DAO(daoClass = SymptomDAO.class)
@Caption("{%name}")
@Entity
@Table(name = "symptoms", schema = "public", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
@Cacheable(false)
public class Symptom implements java.io.Serializable {

	private int id;
	private String name;
	private String signName;
	private String importHeader;
	private String definition;
	private Date createdAt;
	private Date updatedAt;
	private short category;
	private Set<PatientsSymptom> patientsSymptoms = new HashSet<PatientsSymptom>(0);
	
	public Symptom() {
	}

	@Caption("Id")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="symptoms_id_seq")
	@SequenceGenerator(name="symptoms_id_seq", sequenceName="symptoms_id_seq", allocationSize=1)
	@Column(name = "id", unique = true, nullable = false, columnDefinition = "serial")
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Caption("Name")
	@Column(name = "name", unique = true, nullable = false, columnDefinition = "varchar", length = 128)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "sign_name", nullable = true, columnDefinition = "varchar", length = 128)
	public String getSignName() {
		return signName;
	}

	public void setSignName(String signName) {
		this.signName = signName;
	}

	@Caption("ImportHeader")
	@Column(name = "import_header", nullable = false, columnDefinition = "varchar", length = 64)
	public String getImportHeader() {
		return this.importHeader;
	}

	public void setImportHeader(String importHeader) {
		this.importHeader = importHeader;
	}

	@Caption("Definition")
	@Column(name = "definition", columnDefinition = "text")
	public String getDefinition() {
		return this.definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
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

	@Caption("Category")
	@Column(name = "category", nullable = false, columnDefinition = "int2")
	public short getCategory() {
		return this.category;
	}

	public void setCategory(short category) {
		this.category = category;
	}

	@Caption("PatientsSymptoms")
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "symptom")
	public Set<PatientsSymptom> getPatientsSymptoms() {
		return this.patientsSymptoms;
	}

	public void setPatientsSymptoms(Set<PatientsSymptom> patientsSymptoms) {
		this.patientsSymptoms = patientsSymptoms;
	}

}
