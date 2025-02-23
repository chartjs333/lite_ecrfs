package net.mdsgene.admin.admintool.entities;

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

import net.mdsgene.admin.admintool.dal.FileUploadDAO;
import com.xdev.dal.DAO;
import com.xdev.util.Caption;

/**
 * FileUpload
 */
@DAO(daoClass = FileUploadDAO.class)
@Caption("{%tsvFileFileName}")
@Entity
@Table(name = "file_uploads", schema = "public")
@Cacheable(false)
public class FileUpload implements java.io.Serializable {

	private int id;
	private String tsvFileFileName;
	private String tsvFileContentType;
	private Integer tsvFileFileSize;
	private Date tsvFileUpdatedAt;
	private Date createdAt;
	private Date updatedAt;
	private Set<Patient> patients = new HashSet<>(0);

	public FileUpload() {
	}

	@Caption("Id")
	@Id

	@Column(name = "id", unique = true, nullable = false, columnDefinition = "serial")
	public int getId() {
		return this.id;
	}

	public void setId(final int id) {
		this.id = id;
	}

	@Caption("TsvFileFileName")
	@Column(name = "tsv_file_file_name", columnDefinition = "varchar")
	public String getTsvFileFileName() {
		return this.tsvFileFileName;
	}

	public void setTsvFileFileName(final String tsvFileFileName) {
		this.tsvFileFileName = tsvFileFileName;
	}

	@Caption("TsvFileContentType")
	@Column(name = "tsv_file_content_type", columnDefinition = "varchar")
	public String getTsvFileContentType() {
		return this.tsvFileContentType;
	}

	public void setTsvFileContentType(final String tsvFileContentType) {
		this.tsvFileContentType = tsvFileContentType;
	}

	@Caption("TsvFileFileSize")
	@Column(name = "tsv_file_file_size", columnDefinition = "int4")
	public Integer getTsvFileFileSize() {
		return this.tsvFileFileSize;
	}

	public void setTsvFileFileSize(final Integer tsvFileFileSize) {
		this.tsvFileFileSize = tsvFileFileSize;
	}

	@Caption("TsvFileUpdatedAt")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "tsv_file_updated_at", columnDefinition = "timestamp", length = 29)
	public Date getTsvFileUpdatedAt() {
		return this.tsvFileUpdatedAt;
	}

	public void setTsvFileUpdatedAt(final Date tsvFileUpdatedAt) {
		this.tsvFileUpdatedAt = tsvFileUpdatedAt;
	}

	@Caption("CreatedAt")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", columnDefinition = "timestamp", length = 29)
	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(final Date createdAt) {
		this.createdAt = createdAt;
	}

	@Caption("UpdatedAt")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at", columnDefinition = "timestamp", length = 29)
	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(final Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Caption("Patients")
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fileUpload")
	public Set<Patient> getPatients() {
		return this.patients;
	}

	public void setPatients(final Set<Patient> patients) {
		this.patients = patients;
	}

}
