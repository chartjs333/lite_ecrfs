package net.mdsgene.admin.admintool.entities;

import net.mdsgene.admin.admintool.dal.PatientDAO;
import com.xdev.dal.DAO;
import com.xdev.util.Caption;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


/**
 * Patient
 */
@DAO(daoClass = PatientDAO.class)
@Caption("{%comment}")
@Entity
@Table(name = "patients", schema = "public")
@Cacheable(false)
public class Patient implements java.io.Serializable {

	private int id;
	private Disease disease;
	private Family family;
	private FileUpload fileUpload;
	private Study study;
	private Short levodopaResponse;
	private short sex;
	private Short ethnicity;
	private BigDecimal ageAtOnset;
	private BigDecimal ageAtExam;
	private boolean clinicalInfo;
	private String comment;
	private Date createdAt;
	private Date updatedAt;
	private String individualIdentity;
	private Short country;
	private boolean indexPatient;
	private short statusClinical;
	private short statusParaclinical;
	private BigDecimal aaoClinical;
	private BigDecimal aaoParaclinical;
	private BigDecimal diseaseDuration;
	private BigDecimal ageAtRem;
	private BigDecimal ageAtDiagnosis;
	private BigDecimal ageAtDeath;
	private Short otherPxmd;
	private int lineOfFile;
	private Set<PatientsSymptom> patientsSymptoms = new HashSet<PatientsSymptom>(0);
	private Set<SequenceVariation> sequenceVariations = new HashSet<SequenceVariation>(0);
	//this part is added for supporting benign variables, and not included into the database
	private String gnomAD;
	private Integer randomIndex;

	public Patient() {
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

	@Caption("Disease")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "disease_id", nullable = false, columnDefinition = "int4")
	public Disease getDisease() {
		return this.disease;
	}

	public void setDisease(Disease disease) {
		this.disease = disease;
	}

	@Caption("Family")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "family_id", nullable = false, columnDefinition = "int4")
	public Family getFamily() {
		return this.family;
	}

	public void setFamily(Family family) {
		this.family = family;
	}

	@Caption("FileUpload")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "file_upload_id", nullable = false, columnDefinition = "int4")
	public FileUpload getFileUpload() {
		return this.fileUpload;
	}

	public void setFileUpload(FileUpload fileUpload) {
		this.fileUpload = fileUpload;
	}

	@Caption("Study")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "study_id", nullable = false, columnDefinition = "int4")
	public Study getStudy() {
		return this.study;
	}

	public void setStudy(Study study) {
		this.study = study;
	}

	@Caption("LevodopaResponse")
	@Column(name = "levodopa_response", columnDefinition = "int2")
	public Short getLevodopaResponse() {
		return this.levodopaResponse;
	}

	public void setLevodopaResponse(Short levodopaResponse) {
		this.levodopaResponse = levodopaResponse;
	}

	@Caption("Sex")
	@Column(name = "sex", nullable = false, columnDefinition = "int2")
	public short getSex() {
		return this.sex;
	}

	public void setSex(short sex) {
		this.sex = sex;
	}

	@Caption("Ethnicity")
	@Column(name = "ethnicity", columnDefinition = "int2")
	public Short getEthnicity() {
		return this.ethnicity;
	}

	public void setEthnicity(Short ethnicity) {
		this.ethnicity = ethnicity;
	}

	@Caption("AgeAtOnset")
	@Column(name = "age_at_onset", columnDefinition = "numeric", precision = 6, scale = 3)
	public BigDecimal getAgeAtOnset() {
		return this.ageAtOnset;
	}

	public void setAgeAtOnset(BigDecimal ageAtOnset) {
		this.ageAtOnset = ageAtOnset;
	}

	@Caption("AgeAtExam")
	@Column(name = "age_at_exam", columnDefinition = "numeric", precision = 6, scale = 3)
	public BigDecimal getAgeAtExam() {
		return this.ageAtExam;
	}

	public void setAgeAtExam(BigDecimal ageAtExam) {
		this.ageAtExam = ageAtExam;
	}

	@Caption("ClinicalInfo")
	@Column(name = "clinical_info", nullable = false, columnDefinition = "bool")
	public boolean isClinicalInfo() {
		return this.clinicalInfo;
	}

	public void setClinicalInfo(boolean clinicalInfo) {
		this.clinicalInfo = clinicalInfo;
	}

	@Caption("Comment")
	@Column(name = "comment", columnDefinition = "text")
	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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

	@Caption("IndividualIdentity")
	@Column(name = "individual_identity", nullable = false, columnDefinition = "varchar", length = 32)
	public String getIndividualIdentity() {
		return this.individualIdentity;
	}

	public void setIndividualIdentity(String individualIdentity) {
		this.individualIdentity = individualIdentity;
	}

	@Caption("Country")
	@Column(name = "country", columnDefinition = "int2")
	public Short getCountry() {
		return this.country;
	}

	public void setCountry(Short country) {
		this.country = country;
	}

	@Caption("IndexPatient")
	@Column(name = "index_patient", nullable = false, columnDefinition = "bool")
	public boolean isIndexPatient() {
		return this.indexPatient;
	}

	public void setIndexPatient(boolean indexPatient) {
		this.indexPatient = indexPatient;
	}

	@Caption("StatusClinical")
	@Column(name = "status_clinical", nullable = false, columnDefinition = "int2")
	public short getStatusClinical() {
		return this.statusClinical;
	}

	public void setStatusClinical(short statusClinical) {
		this.statusClinical = statusClinical;
	}

	@Caption("StatusParaclinical")
	@Column(name = "status_paraclinical", nullable = false, columnDefinition = "int2")
	public short getStatusParaclinical() {
		return this.statusParaclinical;
	}

	public void setStatusParaclinical(short statusParaclinical) {
		this.statusParaclinical = statusParaclinical;
	}

	@Caption("AaoClinical")
	@Column(name = "aao_clinical", columnDefinition = "numeric", precision = 6, scale = 3)
	public BigDecimal getAaoClinical() {
		return this.aaoClinical;
	}

	public void setAaoClinical(BigDecimal aaoClinical) {
		this.aaoClinical = aaoClinical;
	}

	@Caption("AaoParaclinical")
	@Column(name = "aao_paraclinical", columnDefinition = "numeric", precision = 6, scale = 3)
	public BigDecimal getAaoParaclinical() {
		return this.aaoParaclinical;
	}

	public void setAaoParaclinical(BigDecimal aaoParaclinical) {
		this.aaoParaclinical = aaoParaclinical;
	}

	@Caption("DiseaseDuration")
	@Column(name = "disease_duration", columnDefinition = "numeric", precision = 6, scale = 3)
	public BigDecimal getDiseaseDuration() {
		return this.diseaseDuration;
	}

	public void setDiseaseDuration(BigDecimal diseaseDuration) {
		this.diseaseDuration = diseaseDuration;
	}

	@Caption("AgeAtRem")
	@Column(name = "age_at_rem", columnDefinition = "numeric", precision = 6, scale = 3)
	public BigDecimal getAgeAtRem() {
		return this.ageAtRem;
	}

	public void setAgeAtRem(BigDecimal ageAtRem) {
		this.ageAtRem = ageAtRem;
	}

	@Caption("AgeAtDiagnosis")
	@Column(name = "age_at_diagnosis", columnDefinition = "numeric", precision = 6, scale = 3)
	public BigDecimal getAgeAtDiagnosis() {
		return this.ageAtDiagnosis;
	}

	public void setAgeAtDiagnosis(BigDecimal ageAtDiagnosis) {
		this.ageAtDiagnosis = ageAtDiagnosis;
	}

	@Caption("AgeAtDeath")
	@Column(name = "age_at_death", columnDefinition = "numeric", precision = 6, scale = 3)
	public BigDecimal getAgeAtDeath() {
		return this.ageAtDeath;
	}

	public void setAgeAtDeath(BigDecimal ageAtDeath) {
		this.ageAtDeath = ageAtDeath;
	}

	@Caption("OtherPxmd")
	@Column(name = "other_pxmd", columnDefinition = "int2")
	public Short getOtherPxmd() {
		return this.otherPxmd;
	}

	public void setOtherPxmd(Short otherPxmd) {
		this.otherPxmd = otherPxmd;
	}

	@Caption("LineOfFile")
	@Column(name = "line_of_file", nullable = false, columnDefinition = "int4")
	public int getLineOfFile() {
		return this.lineOfFile;
	}

	public void setLineOfFile(int lineOfFile) {
		this.lineOfFile = lineOfFile;
	}

	@Caption("PatientsSymptoms")
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
	public Set<PatientsSymptom> getPatientsSymptoms() {
		return this.patientsSymptoms;
	}

	public void setPatientsSymptoms(Set<PatientsSymptom> patientsSymptoms) {
		this.patientsSymptoms = patientsSymptoms;
	}

	@Caption("SequenceVariations")
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
	public Set<SequenceVariation> getSequenceVariations() {
		return this.sequenceVariations;
	}

	public void setSequenceVariations(Set<SequenceVariation> sequenceVariations) {
		this.sequenceVariations = sequenceVariations;
	}

	@Transient
	public String getGnomAD() {
		return gnomAD;
	}

	public void setGnomAD(String gnomAD) {
		this.gnomAD = gnomAD;
	}
	
	@Caption("Random_Index")
	@Column(name = "random_index", columnDefinition = "int4")
	public Integer getRandomIndex() {
		return this.randomIndex;
	}

	public void setRandomIndex(Integer randomIndex) {
		this.randomIndex = randomIndex;
	}

}
