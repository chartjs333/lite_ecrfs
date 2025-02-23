package net.mdsgene.admin.admintool.entities;

import net.mdsgene.admin.admintool.dal.SystematicReviewDAO;
import com.xdev.dal.DAO;
import com.xdev.util.Caption;
import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * SystematicReview
 */
@DAO(daoClass = SystematicReviewDAO.class)
@Caption("{%title}")
@Entity
@Table(name = "systematic_reviews", schema = "public", uniqueConstraints = @UniqueConstraint(columnNames = "pubmed_id"))
@Cacheable(false)
public class SystematicReview implements java.io.Serializable {

	private int id;
	private Disease disease;
	private Gene gene;
	private int pubmedId;
	private String title;
	private String abstract_;
	private String journalTitle;
	private String journalAbbreviation;
	private short issueYear;
	private Short issueMonth;
	private short journalVolume;
	private Short journalIssue;
	private String pagination;
	private Date createdAt;
	private Date updatedAt;

	public SystematicReview() {
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

	@Caption("Gene")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "gene_id", nullable = false, columnDefinition = "int4")
	public Gene getGene() {
		return this.gene;
	}

	public void setGene(Gene gene) {
		this.gene = gene;
	}

	@Caption("PubmedId")
	@Column(name = "pubmed_id", unique = true, nullable = false, columnDefinition = "int4")
	public int getPubmedId() {
		return this.pubmedId;
	}

	public void setPubmedId(int pubmedId) {
		this.pubmedId = pubmedId;
	}

	@Caption("Title")
	@Column(name = "title", nullable = false, columnDefinition = "varchar", length = 180)
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
	@Column(name = "journal_title", nullable = false, columnDefinition = "varchar", length = 128)
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
	@Column(name = "journal_volume", nullable = false, columnDefinition = "int2")
	public short getJournalVolume() {
		return this.journalVolume;
	}

	public void setJournalVolume(short journalVolume) {
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

}
