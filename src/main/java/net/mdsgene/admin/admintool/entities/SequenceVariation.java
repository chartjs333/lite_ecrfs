package net.mdsgene.admin.admintool.entities;

import java.math.BigDecimal;
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
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import com.xdev.dal.DAO;
import com.xdev.util.Caption;

import net.mdsgene.admin.admintool.dal.SequenceVariationDAO;

/**
 * SequenceVariation
 */
@DAO(daoClass = SequenceVariationDAO.class)
@Caption("{%gdnaRelated}")
@Entity
@Table(name = "sequence_variations", schema = "public", uniqueConstraints = @UniqueConstraint(columnNames = {
		"patient_id", "gene_id", "reference", "observed", "gdna_related", "cdna_related", "protein_related",
		"genotype" }))
@Cacheable(false)
public class SequenceVariation implements java.io.Serializable {

	private int id;
	private Gene gene;
	private Patient patient;
	private Boolean sporadic;
	private String gdnaRelated;
	private String cdnaRelated;
	private String proteinRelated;
	private Short genotype;
	private short impact;
	private Short chromosome;
	private Short hgrb;
	private Date createdAt;
	private Date updatedAt;
	private Short numWithinSpg;
	private String observed;
	private String reference;
	private Integer position;
	private String alias;
	private String genomeBuild;
	private short pathogenicity;
	private BigDecimal caddScore;
	private String positiveEvidence;
	private String negativeEvidence;
	private boolean exacLink;
	//this part is added for supporting benign variables, and not included into the database
	private Short num_fam_with_segregation;
	private Short num_index_pat_het_mut;
	private Short num_index_pat_two_mut;
	private Short final_score;
	private Integer randomIndex;
	
	private String transcriptIdEnst; 
	private String transcriptIdNcbi; 
	private Short  patientGenotype; 
	private Short  mutDeNovo; 
	private String gnomAd; 
	
	public SequenceVariation() {
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

	@Caption("Patient")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "patient_id", nullable = false, columnDefinition = "int4")
	public Patient getPatient() {
		return this.patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@Caption("Sporadic")
	@Column(name = "sporadic", columnDefinition = "bool")
	public Boolean getSporadic() {
		return this.sporadic;
	}

	public void setSporadic(Boolean sporadic) {
		this.sporadic = sporadic;
	}

	@Caption("GdnaRelated")
	@Column(name = "gdna_related", columnDefinition = "varchar")
	public String getGdnaRelated() {
		return this.gdnaRelated;
	}

	public void setGdnaRelated(String gdnaRelated) {
		this.gdnaRelated = gdnaRelated;
	}

	@Caption("CdnaRelated")
	@Column(name = "cdna_related", columnDefinition = "varchar")
	public String getCdnaRelated() {
		return this.cdnaRelated;
	}

	public void setCdnaRelated(String cdnaRelated) {
		this.cdnaRelated = cdnaRelated;
	}

	@Caption("ProteinRelated")
	@Column(name = "protein_related", columnDefinition = "varchar")
	public String getProteinRelated() {
		return this.proteinRelated;
	}

	public void setProteinRelated(String proteinRelated) {
		this.proteinRelated = proteinRelated;
	}

	@Caption("Genotype")
	@Column(name = "genotype", columnDefinition = "int2")
	public Short getGenotype() {
		return this.genotype;
	}

	public void setGenotype(Short genotype) {
		this.genotype = genotype;
	}

	@Caption("Impact")
	@Column(name = "impact", nullable = false, columnDefinition = "int2")
	public short getImpact() {
		return this.impact;
	}

	public void setImpact(short impact) {
		this.impact = impact;
	}

	@Caption("Chromosome")
	@Column(name = "chromosome", columnDefinition = "int2")
	public Short getChromosome() {
		return this.chromosome;
	}

	public void setChromosome(Short chromosome) {
		this.chromosome = chromosome;
	}

	@Caption("Hgrb")
	@Column(name = "hgrb", columnDefinition = "int2")
	public Short getHgrb() {
		return this.hgrb;
	}

	public void setHgrb(Short hgrb) {
		this.hgrb = hgrb;
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

	@Caption("NumWithinSpg")
	@Column(name = "num_within_spg", nullable = false, columnDefinition = "int2")
	public Short getNumWithinSpg() {
		return this.numWithinSpg;
	}

	public void setNumWithinSpg(Short numWithinSpg) {
		this.numWithinSpg = numWithinSpg;
	}

	@Caption("Observed")
	@Column(name = "observed", columnDefinition = "text")
	public String getObserved() {
		return this.observed;
	}

	public void setObserved(String observed) {
		this.observed = observed;
	}

	@Caption("Reference")
	@Column(name = "reference", columnDefinition = "text")
	public String getReference() {
		return this.reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	@Caption("Position")
	@Column(name = "position", columnDefinition = "int4")
	public Integer getPosition() {
		return this.position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	@Caption("Alias")
	@Column(name = "alias", columnDefinition = "varchar", length = 64)
	public String getAlias() {
		return this.alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	@Caption("GenomeBuild")
	@Column(name = "genome_build", columnDefinition = "text")
	public String getGenomeBuild() {
		return this.genomeBuild;
	}

	public void setGenomeBuild(String genomeBuild) {
		this.genomeBuild = genomeBuild;
	}

	@Caption("Pathogenicity")
	@Column(name = "pathogenicity", nullable = false, columnDefinition = "int2")
	public short getPathogenicity() {
		return this.pathogenicity;
	}

	public void setPathogenicity(short pathogenicity) {
		this.pathogenicity = pathogenicity;
	}

	@Caption("CaddScore")
	@Column(name = "cadd_score", columnDefinition = "numeric", precision = 4)
	public BigDecimal getCaddScore() {
		return this.caddScore;
	}

	public void setCaddScore(BigDecimal caddScore) {
		this.caddScore = caddScore;
	}

	@Caption("PositiveEvidence")
	@Column(name = "positive_evidence", columnDefinition = "text")
	public String getPositiveEvidence() {
		return this.positiveEvidence;
	}

	public void setPositiveEvidence(String positiveEvidence) {
		this.positiveEvidence = positiveEvidence;
	}

	@Caption("NegativeEvidence")
	@Column(name = "negative_evidence", columnDefinition = "text")
	public String getNegativeEvidence() {
		return this.negativeEvidence;
	}

	public void setNegativeEvidence(String negativeEvidence) {
		this.negativeEvidence = negativeEvidence;
	}

	@Caption("ExacLink")
	@Column(name = "exac_link", nullable = false, columnDefinition = "bool")
	public boolean isExacLink() {
		return this.exacLink;
	}

	public void setExacLink(boolean exacLink) {
		this.exacLink = exacLink;
	}

	@Transient
	public Short getNum_fam_with_segregation() {
		return num_fam_with_segregation;
	}

	public void setNum_fam_with_segregation(Short num_fam_with_segregation) {
		this.num_fam_with_segregation = num_fam_with_segregation;
	}

	@Transient
	public Short getNum_index_pat_het_mut() {
		return num_index_pat_het_mut;
	}

	public void setNum_index_pat_het_mut(Short num_index_pat_het_mut) {
		this.num_index_pat_het_mut = num_index_pat_het_mut;
	}

	@Transient
	public Short getNum_index_pat_two_mut() {
		return num_index_pat_two_mut;
	}

	public void setNum_index_pat_two_mut(Short num_index_pat_two_mut) {
		this.num_index_pat_two_mut = num_index_pat_two_mut;
	}

	@Transient
	public Short getFinal_score() {
		return final_score;
	}

	public void setFinal_score(Short final_score) {
		this.final_score = final_score;
	}
	
	@Caption("Random_Index")
	@Column(name = "random_index", columnDefinition = "int4")
	public Integer getRandomIndex() {
		return this.randomIndex;
	}

	public void setRandomIndex(Integer randomIndex) {
		this.randomIndex = randomIndex;
	}

	
	@Caption("transcriptIdEnst")
	@Column(name = "transcript_id_enst", columnDefinition = "text")
	public String getTranscriptIdEnst() {
		return transcriptIdEnst;
	}

	public void setTranscriptIdEnst(String transcriptIdEnst) {
		this.transcriptIdEnst = transcriptIdEnst;
	}

	@Caption("transcriptIdNcbi")
	@Column(name = "transcript_id_ncbi", columnDefinition = "text")
	public String getTranscriptIdNcbi() {
		return transcriptIdNcbi;
	}

	public void setTranscriptIdNcbi(String transcriptIdNcbi) {
		this.transcriptIdNcbi = transcriptIdNcbi;
	}

	@Caption("gnomAd")
	@Column(name = "gnom_ad", columnDefinition = "text")
	public String getGnomAd() {
		return gnomAd;
	}

	public void setGnomAd(String gnomAd) {
		this.gnomAd = gnomAd;
	}
	
	@Caption("PatientGenotype")
	@Column(name = "genotype", columnDefinition = "int2", insertable=false, updatable=false)
	public Short getPatientGenotype() {
		return patientGenotype;
	}

	public void setPatientGenotype(Short patientGenotype) {
		this.patientGenotype = patientGenotype;
	}

	@Caption("MutDeNovo")
	@Column(name = "mut_de_novo", columnDefinition = "int2")
	public Short getMutDeNovo() {
		return mutDeNovo;
	}

	public void setMutDeNovo(Short mutDeNovo) {
		this.mutDeNovo = mutDeNovo;
	}
	
}
