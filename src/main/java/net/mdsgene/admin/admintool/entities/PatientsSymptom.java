package net.mdsgene.admin.admintool.entities;

import net.mdsgene.admin.admintool.dal.PatientsSymptomDAO;
import com.xdev.dal.DAO;
import com.xdev.util.Caption;
import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;

/**
 * PatientsSymptom
 */
@DAO(daoClass = PatientsSymptomDAO.class)
@Caption("{%id}")
@Entity
@Table(name = "patients_symptoms", schema = "public")
@Cacheable(false)
public class PatientsSymptom implements java.io.Serializable {

	private int id;
	private Patient patient;
	private Symptom symptom;
	private boolean present;
	private Boolean initial;
	private Date createdAt;
	private Date updatedAt;

	public PatientsSymptom() {
	}

	@Caption("Id")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="patients_symptoms_id_seq")
    @SequenceGenerator(name="patients_symptoms_id_seq", sequenceName="patients_symptoms_id_seq", allocationSize=1)
	@Column(name = "id", unique = true, nullable = false, columnDefinition = "serial")
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Caption("Patient")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "patient_id", nullable = false, columnDefinition = "int4")
	public Patient getPatient() {
		return this.patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@Caption("Symptom")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "symptom_id", nullable = false, columnDefinition = "int4")
	public Symptom getSymptom() {
		return this.symptom;
	}

	public void setSymptom(Symptom symptom) {
		this.symptom = symptom;
	}

	@Caption("Present")
	@Column(name = "present", nullable = false, columnDefinition = "bool")
	public boolean isPresent() {
		return this.present;
	}

	public void setPresent(boolean present) {
		this.present = present;
	}

	@Caption("Initial")
	@Column(name = "initial", columnDefinition = "bool")
	public Boolean getInitial() {
		return this.initial;
	}

	public void setInitial(Boolean initial) {
		this.initial = initial;
	}

	@Caption("CreatedAt")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", columnDefinition = "timestamp", length = 29)
	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Caption("UpdatedAt")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at", columnDefinition = "timestamp", length = 29)
	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}
