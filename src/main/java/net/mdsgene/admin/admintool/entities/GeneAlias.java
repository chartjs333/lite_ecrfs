package net.mdsgene.admin.admintool.entities;

import net.mdsgene.admin.admintool.dal.GeneAliasDAO;
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

/**
 * GeneAlias
 */
@DAO(daoClass = GeneAliasDAO.class)
@Caption("{%synonym}")
@Entity
@Table(name = "gene_aliases", schema = "public")
@Cacheable(false)
public class GeneAlias implements java.io.Serializable {

	private int id;
	private Gene gene;
	private String synonym;
	private Date createdAt;
	private Date updatedAt;

	public GeneAlias() {
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

	@Caption("Gene")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "gene_id", nullable = false, columnDefinition = "int4")
	public Gene getGene() {
		return this.gene;
	}

	public void setGene(Gene gene) {
		this.gene = gene;
	}

	@Caption("Synonym")
	@Column(name = "synonym", nullable = false, columnDefinition = "varchar", length = 32)
	public String getSynonym() {
		return this.synonym;
	}

	public void setSynonym(String synonym) {
		this.synonym = synonym;
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
