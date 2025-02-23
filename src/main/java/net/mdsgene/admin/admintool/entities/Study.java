package net.mdsgene.admin.admintool.entities;

import net.mdsgene.admin.admintool.dal.StudyDAO;
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
 * Study
 */
@DAO(daoClass = StudyDAO.class)
@Caption("{%title}")
@Entity
@Table(name = "studies", schema = "public", uniqueConstraints = @UniqueConstraint(columnNames = "pubmed_id"))
@Cacheable(false)
public class Study implements java.io.Serializable {

	private int id;
	private int pubmedId;
	private short design;
	private Short lowerAgeLimit;
	private Short upperAgeLimit;
	private String title;
	private String abstract_;
	private String journalTitle;
	private String journalAbbreviation;
	private short issueYear;
	private Short issueMonth;
	private Short journalVolume;
	private Short journalIssue;
	private String pagination;
	private String comment;
	private Date createdAt;
	private Date updatedAt;
	private String geneticMethods;
	private Set<Patient> patients = new HashSet<Patient>(0);
	private Integer randomIndex;

	public Study() {
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

	@Caption("PubmedId")
	@Column(name = "pubmed_id", unique = true, nullable = false, columnDefinition = "int4")
	public int getPubmedId() {
		return this.pubmedId;
	}

	public void setPubmedId(int pubmedId) {
		this.pubmedId = pubmedId;
	}

	@Caption("Design")
	@Column(name = "design", nullable = false, columnDefinition = "int2")
	public short getDesign() {
		return this.design;
	}

	public void setDesign(short design) {
		this.design = design;
	}

	@Caption("LowerAgeLimit")
	@Column(name = "lower_age_limit", columnDefinition = "int2")
	public Short getLowerAgeLimit() {
		return this.lowerAgeLimit;
	}

	public void setLowerAgeLimit(Short lowerAgeLimit) {
		this.lowerAgeLimit = lowerAgeLimit;
	}

	@Caption("UpperAgeLimit")
	@Column(name = "upper_age_limit", columnDefinition = "int2")
	public Short getUpperAgeLimit() {
		return this.upperAgeLimit;
	}

	public void setUpperAgeLimit(Short upperAgeLimit) {
		this.upperAgeLimit = upperAgeLimit;
	}

	@Caption("Title")
	@Column(name = "title", nullable = false, columnDefinition = "varchar", length = 256)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Caption("Abstract ")
	@Column(name = "abstract", columnDefinition = "text")
	public String getAbstract_() {
		return this.abstract_;
	}

	public void setAbstract_(String abstract_) {
		this.abstract_ = abstract_;
	}

	@Caption("JournalTitle")
	@Column(name = "journal_title", nullable = false, columnDefinition = "varchar", length = 192)
	public String getJournalTitle() {
		return this.journalTitle;
	}

	public void setJournalTitle(String journalTitle) {
		this.journalTitle = journalTitle;
	}

	@Caption("JournalAbbreviation")
	@Column(name = "journal_abbreviation", nullable = false, columnDefinition = "varchar", length = 64)
	public String getJournalAbbreviation() {
		return this.journalAbbreviation;
	}

	public void setJournalAbbreviation(String journalAbbreviation) {
		this.journalAbbreviation = journalAbbreviation;
	}

	@Caption("IssueYear")
	@Column(name = "issue_year", nullable = false, columnDefinition = "int2")
	public short getIssueYear() {
		return this.issueYear;
	}

	public void setIssueYear(short issueYear) {
		this.issueYear = issueYear;
	}

	@Caption("IssueMonth")
	@Column(name = "issue_month", columnDefinition = "int2")
	public Short getIssueMonth() {
		return this.issueMonth;
	}

	public void setIssueMonth(Short issueMonth) {
		this.issueMonth = issueMonth;
	}

	@Caption("JournalVolume")
	@Column(name = "journal_volume", columnDefinition = "int2")
	public Short getJournalVolume() {
		return this.journalVolume;
	}

	public void setJournalVolume(Short journalVolume) {
		this.journalVolume = journalVolume;
	}

	@Caption("JournalIssue")
	@Column(name = "journal_issue", columnDefinition = "int2")
	public Short getJournalIssue() {
		return this.journalIssue;
	}

	public void setJournalIssue(Short journalIssue) {
		this.journalIssue = journalIssue;
	}

	@Caption("Pagination")
	@Column(name = "pagination", columnDefinition = "varchar", length = 64)
	public String getPagination() {
		return this.pagination;
	}

	public void setPagination(String pagination) {
		this.pagination = pagination;
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

	@Caption("GeneticMethods")
	@Column(name = "genetic_methods", columnDefinition = "text")
	public String getGeneticMethods() {
		return this.geneticMethods;
	}

	public void setGeneticMethods(String geneticMethods) {
		this.geneticMethods = geneticMethods;
	}

	@Caption("Patients")
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "study")
	public Set<Patient> getPatients() {
		return this.patients;
	}

	public void setPatients(Set<Patient> patients) {
		this.patients = patients;
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
