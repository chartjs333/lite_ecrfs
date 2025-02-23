package net.mdsgene.admin.admintool.entities;

import net.mdsgene.admin.admintool.dal.GeneDAO;
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
 * Gene
 */
@DAO(daoClass = GeneDAO.class)
@Caption("{%name}")
@Entity
@Table(name = "genes", schema = "public", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
@Cacheable(false)
public class Gene implements java.io.Serializable {

	private int id;
	private String name;
	private Date createdAt;
	private Date updatedAt;
	private Set<GeneAlias> geneAliases = new HashSet<GeneAlias>(0);
	private Set<SequenceVariation> sequenceVariations = new HashSet<SequenceVariation>(0);
	private Set<SystematicReview> systematicReviews = new HashSet<SystematicReview>(0);

	public Gene() {
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
	@Column(name = "name", unique = true, nullable = false, columnDefinition = "varchar", length = 32)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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

	@Caption("GeneAliases")
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "gene")
	public Set<GeneAlias> getGeneAliases() {
		return this.geneAliases;
	}

	public void setGeneAliases(Set<GeneAlias> geneAliases) {
		this.geneAliases = geneAliases;
	}

	@Caption("SequenceVariations")
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "gene")
	public Set<SequenceVariation> getSequenceVariations() {
		return this.sequenceVariations;
	}

	public void setSequenceVariations(Set<SequenceVariation> sequenceVariations) {
		this.sequenceVariations = sequenceVariations;
	}

	@Caption("SystematicReviews")
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "gene")
	public Set<SystematicReview> getSystematicReviews() {
		return this.systematicReviews;
	}

	public void setSystematicReviews(Set<SystematicReview> systematicReviews) {
		this.systematicReviews = systematicReviews;
	}

}
