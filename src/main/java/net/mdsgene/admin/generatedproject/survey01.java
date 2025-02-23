package net.mdsgene.admin.generatedproject;
import java.util.Date;
import javax.persistence.*;
@Entity
@Table(name = "survey01", schema = "public")
@Cacheable(false)
public class survey01 implements java.io.Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="survey01_id_seq")
    @SequenceGenerator(name="survey01_id_seq", sequenceName="survey01_id_seq", allocationSize=1)
	@Column(name = "id", unique = true, nullable = false, columnDefinition = "serial")
	private int id;

	public survey01() {
	}
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	


	private String ecrfStatus;

	@Column(name = "ecrf_status", nullable = true, columnDefinition = "varchar", length = 128)
	public String getEcrfStatus() {
		return ecrfStatus;
	}

	public void setEcrfStatus(String ecrfStatus) {
		this.ecrfStatus = ecrfStatus;
	}

	private Date createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", nullable = false, columnDefinition = "timestamp", length = 29)
	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

   private String surveyTwoId;

   @Column(name = "survey_two_id", nullable = true, columnDefinition = "varchar", length = 128)
   public String getSurveyTwoId() {
       return this.surveyTwoId;
   }

   public void setSurveyTwoId(String surveyTwoId) {
       this.surveyTwoId = surveyTwoId;
   }

   private String fillingStatus;

   @Column(name = "filling_status", nullable = true, columnDefinition = "varchar", length = 128)
   public String getFillingStatus() {
       return this.fillingStatus;
   }

   public void setFillingStatus(String fillingStatus) {
       this.fillingStatus = fillingStatus;
   }

   private String ind_10_aff_unaff;

   @Column(name = "ind_10_aff_unaff", nullable = true, columnDefinition = "varchar", length = 128)
   public String getInd10AffUnaff() {
	   return this.ind_10_aff_unaff;
   }

   public void setInd10AffUnaff(String ind_10_aff_unaff) {
	   this.ind_10_aff_unaff = ind_10_aff_unaff;
   }
	private String ind_10_id;

	@Column(name = "ind_10_id", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd10Id() {
		return this.ind_10_id;
	}

	public void setInd10Id(String ind_10_id) {
		this.ind_10_id = ind_10_id;
	}
	private String ind_10_var_1_cdna;

	@Column(name = "ind_10_var_1_cdna", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd10Var1Cdna() {
		return this.ind_10_var_1_cdna;
	}

	public void setInd10Var1Cdna(String ind_10_var_1_cdna) {
		this.ind_10_var_1_cdna = ind_10_var_1_cdna;
	}
	private String ind_10_var_1_gene;

	@Column(name = "ind_10_var_1_gene", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd10Var1Gene() {
		return this.ind_10_var_1_gene;
	}

	public void setInd10Var1Gene(String ind_10_var_1_gene) {
		this.ind_10_var_1_gene = ind_10_var_1_gene;
	}
	private String ind_10_var_1_prot;

	@Column(name = "ind_10_var_1_prot", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd10Var1Prot() {
		return this.ind_10_var_1_prot;
	}

	public void setInd10Var1Prot(String ind_10_var_1_prot) {
		this.ind_10_var_1_prot = ind_10_var_1_prot;
	}
	private String ind_10_var_1_zyg;

	@Column(name = "ind_10_var_1_zyg", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd10Var1Zyg() {
		return this.ind_10_var_1_zyg;
	}

	public void setInd10Var1Zyg(String ind_10_var_1_zyg) {
		this.ind_10_var_1_zyg = ind_10_var_1_zyg;
	}
	private String ind_10_var_2_cdna;

	@Column(name = "ind_10_var_2_cdna", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd10Var2Cdna() {
		return this.ind_10_var_2_cdna;
	}

	public void setInd10Var2Cdna(String ind_10_var_2_cdna) {
		this.ind_10_var_2_cdna = ind_10_var_2_cdna;
	}
	private String ind_10_var_2_gene;

	@Column(name = "ind_10_var_2_gene", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd10Var2Gene() {
		return this.ind_10_var_2_gene;
	}

	public void setInd10Var2Gene(String ind_10_var_2_gene) {
		this.ind_10_var_2_gene = ind_10_var_2_gene;
	}
	private String ind_10_var_2_prot;

	@Column(name = "ind_10_var_2_prot", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd10Var2Prot() {
		return this.ind_10_var_2_prot;
	}

	public void setInd10Var2Prot(String ind_10_var_2_prot) {
		this.ind_10_var_2_prot = ind_10_var_2_prot;
	}
	private String ind_10_var_2_zyg;

	@Column(name = "ind_10_var_2_zyg", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd10Var2Zyg() {
		return this.ind_10_var_2_zyg;
	}

	public void setInd10Var2Zyg(String ind_10_var_2_zyg) {
		this.ind_10_var_2_zyg = ind_10_var_2_zyg;
	}
	private String ind_10_var_3_cdna;

	@Column(name = "ind_10_var_3_cdna", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd10Var3Cdna() {
		return this.ind_10_var_3_cdna;
	}

	public void setInd10Var3Cdna(String ind_10_var_3_cdna) {
		this.ind_10_var_3_cdna = ind_10_var_3_cdna;
	}
	private String ind_10_var_3_gene;

	@Column(name = "ind_10_var_3_gene", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd10Var3Gene() {
		return this.ind_10_var_3_gene;
	}

	public void setInd10Var3Gene(String ind_10_var_3_gene) {
		this.ind_10_var_3_gene = ind_10_var_3_gene;
	}
	private String ind_10_var_3_prot;

	@Column(name = "ind_10_var_3_prot", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd10Var3Prot() {
		return this.ind_10_var_3_prot;
	}

	public void setInd10Var3Prot(String ind_10_var_3_prot) {
		this.ind_10_var_3_prot = ind_10_var_3_prot;
	}
	private String ind_10_var_3_zyg;

	@Column(name = "ind_10_var_3_zyg", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd10Var3Zyg() {
		return this.ind_10_var_3_zyg;
	}

	public void setInd10Var3Zyg(String ind_10_var_3_zyg) {
		this.ind_10_var_3_zyg = ind_10_var_3_zyg;
	}
	private String ind_11_aff_unaff;

	@Column(name = "ind_11_aff_unaff", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd11AffUnaff() {
		return this.ind_11_aff_unaff;
	}

	public void setInd11AffUnaff(String ind_11_aff_unaff) {
		this.ind_11_aff_unaff = ind_11_aff_unaff;
	}
	private String ind_11_id;

	@Column(name = "ind_11_id", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd11Id() {
		return this.ind_11_id;
	}

	public void setInd11Id(String ind_11_id) {
		this.ind_11_id = ind_11_id;
	}
	private String ind_11_var_1_cdna;

	@Column(name = "ind_11_var_1_cdna", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd11Var1Cdna() {
		return this.ind_11_var_1_cdna;
	}

	public void setInd11Var1Cdna(String ind_11_var_1_cdna) {
		this.ind_11_var_1_cdna = ind_11_var_1_cdna;
	}
	private String ind_11_var_1_gene;

	@Column(name = "ind_11_var_1_gene", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd11Var1Gene() {
		return this.ind_11_var_1_gene;
	}

	public void setInd11Var1Gene(String ind_11_var_1_gene) {
		this.ind_11_var_1_gene = ind_11_var_1_gene;
	}
	private String ind_11_var_1_prot;

	@Column(name = "ind_11_var_1_prot", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd11Var1Prot() {
		return this.ind_11_var_1_prot;
	}

	public void setInd11Var1Prot(String ind_11_var_1_prot) {
		this.ind_11_var_1_prot = ind_11_var_1_prot;
	}
	private String ind_11_var_1_zyg;

	@Column(name = "ind_11_var_1_zyg", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd11Var1Zyg() {
		return this.ind_11_var_1_zyg;
	}

	public void setInd11Var1Zyg(String ind_11_var_1_zyg) {
		this.ind_11_var_1_zyg = ind_11_var_1_zyg;
	}
	private String ind_11_var_2_cdna;

	@Column(name = "ind_11_var_2_cdna", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd11Var2Cdna() {
		return this.ind_11_var_2_cdna;
	}

	public void setInd11Var2Cdna(String ind_11_var_2_cdna) {
		this.ind_11_var_2_cdna = ind_11_var_2_cdna;
	}
	private String ind_11_var_2_gene;

	@Column(name = "ind_11_var_2_gene", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd11Var2Gene() {
		return this.ind_11_var_2_gene;
	}

	public void setInd11Var2Gene(String ind_11_var_2_gene) {
		this.ind_11_var_2_gene = ind_11_var_2_gene;
	}
	private String ind_11_var_2_prot;

	@Column(name = "ind_11_var_2_prot", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd11Var2Prot() {
		return this.ind_11_var_2_prot;
	}

	public void setInd11Var2Prot(String ind_11_var_2_prot) {
		this.ind_11_var_2_prot = ind_11_var_2_prot;
	}
	private String ind_11_var_2_zyg;

	@Column(name = "ind_11_var_2_zyg", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd11Var2Zyg() {
		return this.ind_11_var_2_zyg;
	}

	public void setInd11Var2Zyg(String ind_11_var_2_zyg) {
		this.ind_11_var_2_zyg = ind_11_var_2_zyg;
	}
	private String ind_11_var_3_cdna;

	@Column(name = "ind_11_var_3_cdna", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd11Var3Cdna() {
		return this.ind_11_var_3_cdna;
	}

	public void setInd11Var3Cdna(String ind_11_var_3_cdna) {
		this.ind_11_var_3_cdna = ind_11_var_3_cdna;
	}
	private String ind_11_var_3_gene;

	@Column(name = "ind_11_var_3_gene", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd11Var3Gene() {
		return this.ind_11_var_3_gene;
	}

	public void setInd11Var3Gene(String ind_11_var_3_gene) {
		this.ind_11_var_3_gene = ind_11_var_3_gene;
	}
	private String ind_11_var_3_prot;

	@Column(name = "ind_11_var_3_prot", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd11Var3Prot() {
		return this.ind_11_var_3_prot;
	}

	public void setInd11Var3Prot(String ind_11_var_3_prot) {
		this.ind_11_var_3_prot = ind_11_var_3_prot;
	}
	private String ind_11_var_3_zyg;

	@Column(name = "ind_11_var_3_zyg", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd11Var3Zyg() {
		return this.ind_11_var_3_zyg;
	}

	public void setInd11Var3Zyg(String ind_11_var_3_zyg) {
		this.ind_11_var_3_zyg = ind_11_var_3_zyg;
	}
	private String ind_12_aff_unaff;

	@Column(name = "ind_12_aff_unaff", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd12AffUnaff() {
		return this.ind_12_aff_unaff;
	}

	public void setInd12AffUnaff(String ind_12_aff_unaff) {
		this.ind_12_aff_unaff = ind_12_aff_unaff;
	}
	private String ind_12_id;

	@Column(name = "ind_12_id", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd12Id() {
		return this.ind_12_id;
	}

	public void setInd12Id(String ind_12_id) {
		this.ind_12_id = ind_12_id;
	}
	private String ind_12_var_1_cdna;

	@Column(name = "ind_12_var_1_cdna", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd12Var1Cdna() {
		return this.ind_12_var_1_cdna;
	}

	public void setInd12Var1Cdna(String ind_12_var_1_cdna) {
		this.ind_12_var_1_cdna = ind_12_var_1_cdna;
	}
	private String ind_12_var_1_gene;

	@Column(name = "ind_12_var_1_gene", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd12Var1Gene() {
		return this.ind_12_var_1_gene;
	}

	public void setInd12Var1Gene(String ind_12_var_1_gene) {
		this.ind_12_var_1_gene = ind_12_var_1_gene;
	}
	private String ind_12_var_1_prot;

	@Column(name = "ind_12_var_1_prot", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd12Var1Prot() {
		return this.ind_12_var_1_prot;
	}

	public void setInd12Var1Prot(String ind_12_var_1_prot) {
		this.ind_12_var_1_prot = ind_12_var_1_prot;
	}
	private String ind_12_var_1_zyg;

	@Column(name = "ind_12_var_1_zyg", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd12Var1Zyg() {
		return this.ind_12_var_1_zyg;
	}

	public void setInd12Var1Zyg(String ind_12_var_1_zyg) {
		this.ind_12_var_1_zyg = ind_12_var_1_zyg;
	}
	private String ind_12_var_2_cdna;

	@Column(name = "ind_12_var_2_cdna", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd12Var2Cdna() {
		return this.ind_12_var_2_cdna;
	}

	public void setInd12Var2Cdna(String ind_12_var_2_cdna) {
		this.ind_12_var_2_cdna = ind_12_var_2_cdna;
	}
	private String ind_12_var_2_gene;

	@Column(name = "ind_12_var_2_gene", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd12Var2Gene() {
		return this.ind_12_var_2_gene;
	}

	public void setInd12Var2Gene(String ind_12_var_2_gene) {
		this.ind_12_var_2_gene = ind_12_var_2_gene;
	}
	private String ind_12_var_2_prot;

	@Column(name = "ind_12_var_2_prot", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd12Var2Prot() {
		return this.ind_12_var_2_prot;
	}

	public void setInd12Var2Prot(String ind_12_var_2_prot) {
		this.ind_12_var_2_prot = ind_12_var_2_prot;
	}
	private String ind_12_var_2_zyg;

	@Column(name = "ind_12_var_2_zyg", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd12Var2Zyg() {
		return this.ind_12_var_2_zyg;
	}

	public void setInd12Var2Zyg(String ind_12_var_2_zyg) {
		this.ind_12_var_2_zyg = ind_12_var_2_zyg;
	}
	private String ind_12_var_3_cdna;

	@Column(name = "ind_12_var_3_cdna", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd12Var3Cdna() {
		return this.ind_12_var_3_cdna;
	}

	public void setInd12Var3Cdna(String ind_12_var_3_cdna) {
		this.ind_12_var_3_cdna = ind_12_var_3_cdna;
	}
	private String ind_12_var_3_gene;

	@Column(name = "ind_12_var_3_gene", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd12Var3Gene() {
		return this.ind_12_var_3_gene;
	}

	public void setInd12Var3Gene(String ind_12_var_3_gene) {
		this.ind_12_var_3_gene = ind_12_var_3_gene;
	}
	private String ind_12_var_3_prot;

	@Column(name = "ind_12_var_3_prot", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd12Var3Prot() {
		return this.ind_12_var_3_prot;
	}

	public void setInd12Var3Prot(String ind_12_var_3_prot) {
		this.ind_12_var_3_prot = ind_12_var_3_prot;
	}
	private String ind_12_var_3_zyg;

	@Column(name = "ind_12_var_3_zyg", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd12Var3Zyg() {
		return this.ind_12_var_3_zyg;
	}

	public void setInd12Var3Zyg(String ind_12_var_3_zyg) {
		this.ind_12_var_3_zyg = ind_12_var_3_zyg;
	}
	private String ind_13_aff_unaff;

	@Column(name = "ind_13_aff_unaff", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd13AffUnaff() {
		return this.ind_13_aff_unaff;
	}

	public void setInd13AffUnaff(String ind_13_aff_unaff) {
		this.ind_13_aff_unaff = ind_13_aff_unaff;
	}
	private String ind_13_id;

	@Column(name = "ind_13_id", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd13Id() {
		return this.ind_13_id;
	}

	public void setInd13Id(String ind_13_id) {
		this.ind_13_id = ind_13_id;
	}
	private String ind_13_var_1_cdna;

	@Column(name = "ind_13_var_1_cdna", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd13Var1Cdna() {
		return this.ind_13_var_1_cdna;
	}

	public void setInd13Var1Cdna(String ind_13_var_1_cdna) {
		this.ind_13_var_1_cdna = ind_13_var_1_cdna;
	}
	private String ind_13_var_1_gene;

	@Column(name = "ind_13_var_1_gene", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd13Var1Gene() {
		return this.ind_13_var_1_gene;
	}

	public void setInd13Var1Gene(String ind_13_var_1_gene) {
		this.ind_13_var_1_gene = ind_13_var_1_gene;
	}
	private String ind_13_var_1_prot;

	@Column(name = "ind_13_var_1_prot", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd13Var1Prot() {
		return this.ind_13_var_1_prot;
	}

	public void setInd13Var1Prot(String ind_13_var_1_prot) {
		this.ind_13_var_1_prot = ind_13_var_1_prot;
	}
	private String ind_13_var_1_zyg;

	@Column(name = "ind_13_var_1_zyg", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd13Var1Zyg() {
		return this.ind_13_var_1_zyg;
	}

	public void setInd13Var1Zyg(String ind_13_var_1_zyg) {
		this.ind_13_var_1_zyg = ind_13_var_1_zyg;
	}
	private String ind_13_var_2_cdna;

	@Column(name = "ind_13_var_2_cdna", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd13Var2Cdna() {
		return this.ind_13_var_2_cdna;
	}

	public void setInd13Var2Cdna(String ind_13_var_2_cdna) {
		this.ind_13_var_2_cdna = ind_13_var_2_cdna;
	}
	private String ind_13_var_2_gene;

	@Column(name = "ind_13_var_2_gene", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd13Var2Gene() {
		return this.ind_13_var_2_gene;
	}

	public void setInd13Var2Gene(String ind_13_var_2_gene) {
		this.ind_13_var_2_gene = ind_13_var_2_gene;
	}
	private String ind_13_var_2_prot;

	@Column(name = "ind_13_var_2_prot", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd13Var2Prot() {
		return this.ind_13_var_2_prot;
	}

	public void setInd13Var2Prot(String ind_13_var_2_prot) {
		this.ind_13_var_2_prot = ind_13_var_2_prot;
	}
	private String ind_13_var_2_zyg;

	@Column(name = "ind_13_var_2_zyg", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd13Var2Zyg() {
		return this.ind_13_var_2_zyg;
	}

	public void setInd13Var2Zyg(String ind_13_var_2_zyg) {
		this.ind_13_var_2_zyg = ind_13_var_2_zyg;
	}
	private String ind_13_var_3_cdna;

	@Column(name = "ind_13_var_3_cdna", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd13Var3Cdna() {
		return this.ind_13_var_3_cdna;
	}

	public void setInd13Var3Cdna(String ind_13_var_3_cdna) {
		this.ind_13_var_3_cdna = ind_13_var_3_cdna;
	}
	private String ind_13_var_3_gene;

	@Column(name = "ind_13_var_3_gene", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd13Var3Gene() {
		return this.ind_13_var_3_gene;
	}

	public void setInd13Var3Gene(String ind_13_var_3_gene) {
		this.ind_13_var_3_gene = ind_13_var_3_gene;
	}
	private String ind_13_var_3_prot;

	@Column(name = "ind_13_var_3_prot", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd13Var3Prot() {
		return this.ind_13_var_3_prot;
	}

	public void setInd13Var3Prot(String ind_13_var_3_prot) {
		this.ind_13_var_3_prot = ind_13_var_3_prot;
	}
	private String ind_13_var_3_zyg;

	@Column(name = "ind_13_var_3_zyg", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd13Var3Zyg() {
		return this.ind_13_var_3_zyg;
	}

	public void setInd13Var3Zyg(String ind_13_var_3_zyg) {
		this.ind_13_var_3_zyg = ind_13_var_3_zyg;
	}
	private String ind_14_aff_unaff;

	@Column(name = "ind_14_aff_unaff", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd14AffUnaff() {
		return this.ind_14_aff_unaff;
	}

	public void setInd14AffUnaff(String ind_14_aff_unaff) {
		this.ind_14_aff_unaff = ind_14_aff_unaff;
	}
	private String ind_14_id;

	@Column(name = "ind_14_id", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd14Id() {
		return this.ind_14_id;
	}

	public void setInd14Id(String ind_14_id) {
		this.ind_14_id = ind_14_id;
	}
	private String ind_14_var_1_cdna;

	@Column(name = "ind_14_var_1_cdna", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd14Var1Cdna() {
		return this.ind_14_var_1_cdna;
	}

	public void setInd14Var1Cdna(String ind_14_var_1_cdna) {
		this.ind_14_var_1_cdna = ind_14_var_1_cdna;
	}
	private String ind_14_var_1_gene;

	@Column(name = "ind_14_var_1_gene", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd14Var1Gene() {
		return this.ind_14_var_1_gene;
	}

	public void setInd14Var1Gene(String ind_14_var_1_gene) {
		this.ind_14_var_1_gene = ind_14_var_1_gene;
	}
	private String ind_14_var_1_prot;

	@Column(name = "ind_14_var_1_prot", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd14Var1Prot() {
		return this.ind_14_var_1_prot;
	}

	public void setInd14Var1Prot(String ind_14_var_1_prot) {
		this.ind_14_var_1_prot = ind_14_var_1_prot;
	}
	private String ind_14_var_1_zyg;

	@Column(name = "ind_14_var_1_zyg", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd14Var1Zyg() {
		return this.ind_14_var_1_zyg;
	}

	public void setInd14Var1Zyg(String ind_14_var_1_zyg) {
		this.ind_14_var_1_zyg = ind_14_var_1_zyg;
	}
	private String ind_14_var_2_cdna;

	@Column(name = "ind_14_var_2_cdna", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd14Var2Cdna() {
		return this.ind_14_var_2_cdna;
	}

	public void setInd14Var2Cdna(String ind_14_var_2_cdna) {
		this.ind_14_var_2_cdna = ind_14_var_2_cdna;
	}
	private String ind_14_var_2_gene;

	@Column(name = "ind_14_var_2_gene", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd14Var2Gene() {
		return this.ind_14_var_2_gene;
	}

	public void setInd14Var2Gene(String ind_14_var_2_gene) {
		this.ind_14_var_2_gene = ind_14_var_2_gene;
	}
	private String ind_14_var_2_prot;

	@Column(name = "ind_14_var_2_prot", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd14Var2Prot() {
		return this.ind_14_var_2_prot;
	}

	public void setInd14Var2Prot(String ind_14_var_2_prot) {
		this.ind_14_var_2_prot = ind_14_var_2_prot;
	}
	private String ind_14_var_2_zyg;

	@Column(name = "ind_14_var_2_zyg", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd14Var2Zyg() {
		return this.ind_14_var_2_zyg;
	}

	public void setInd14Var2Zyg(String ind_14_var_2_zyg) {
		this.ind_14_var_2_zyg = ind_14_var_2_zyg;
	}
	private String ind_14_var_3_cdna;

	@Column(name = "ind_14_var_3_cdna", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd14Var3Cdna() {
		return this.ind_14_var_3_cdna;
	}

	public void setInd14Var3Cdna(String ind_14_var_3_cdna) {
		this.ind_14_var_3_cdna = ind_14_var_3_cdna;
	}
	private String ind_14_var_3_gene;

	@Column(name = "ind_14_var_3_gene", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd14Var3Gene() {
		return this.ind_14_var_3_gene;
	}

	public void setInd14Var3Gene(String ind_14_var_3_gene) {
		this.ind_14_var_3_gene = ind_14_var_3_gene;
	}
	private String ind_14_var_3_prot;

	@Column(name = "ind_14_var_3_prot", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd14Var3Prot() {
		return this.ind_14_var_3_prot;
	}

	public void setInd14Var3Prot(String ind_14_var_3_prot) {
		this.ind_14_var_3_prot = ind_14_var_3_prot;
	}
	private String ind_14_var_3_zyg;

	@Column(name = "ind_14_var_3_zyg", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd14Var3Zyg() {
		return this.ind_14_var_3_zyg;
	}

	public void setInd14Var3Zyg(String ind_14_var_3_zyg) {
		this.ind_14_var_3_zyg = ind_14_var_3_zyg;
	}
	private String ind_15_aff_unaff;

	@Column(name = "ind_15_aff_unaff", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd15AffUnaff() {
		return this.ind_15_aff_unaff;
	}

	public void setInd15AffUnaff(String ind_15_aff_unaff) {
		this.ind_15_aff_unaff = ind_15_aff_unaff;
	}
	private String ind_15_id;

	@Column(name = "ind_15_id", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd15Id() {
		return this.ind_15_id;
	}

	public void setInd15Id(String ind_15_id) {
		this.ind_15_id = ind_15_id;
	}
	private String ind_15_var_1_cdna;

	@Column(name = "ind_15_var_1_cdna", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd15Var1Cdna() {
		return this.ind_15_var_1_cdna;
	}

	public void setInd15Var1Cdna(String ind_15_var_1_cdna) {
		this.ind_15_var_1_cdna = ind_15_var_1_cdna;
	}
	private String ind_15_var_1_gene;

	@Column(name = "ind_15_var_1_gene", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd15Var1Gene() {
		return this.ind_15_var_1_gene;
	}

	public void setInd15Var1Gene(String ind_15_var_1_gene) {
		this.ind_15_var_1_gene = ind_15_var_1_gene;
	}
	private String ind_15_var_1_prot;

	@Column(name = "ind_15_var_1_prot", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd15Var1Prot() {
		return this.ind_15_var_1_prot;
	}

	public void setInd15Var1Prot(String ind_15_var_1_prot) {
		this.ind_15_var_1_prot = ind_15_var_1_prot;
	}
	private String ind_15_var_1_zyg;

	@Column(name = "ind_15_var_1_zyg", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd15Var1Zyg() {
		return this.ind_15_var_1_zyg;
	}

	public void setInd15Var1Zyg(String ind_15_var_1_zyg) {
		this.ind_15_var_1_zyg = ind_15_var_1_zyg;
	}
	private String ind_15_var_2_cdna;

	@Column(name = "ind_15_var_2_cdna", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd15Var2Cdna() {
		return this.ind_15_var_2_cdna;
	}

	public void setInd15Var2Cdna(String ind_15_var_2_cdna) {
		this.ind_15_var_2_cdna = ind_15_var_2_cdna;
	}
	private String ind_15_var_2_gene;

	@Column(name = "ind_15_var_2_gene", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd15Var2Gene() {
		return this.ind_15_var_2_gene;
	}

	public void setInd15Var2Gene(String ind_15_var_2_gene) {
		this.ind_15_var_2_gene = ind_15_var_2_gene;
	}
	private String ind_15_var_2_prot;

	@Column(name = "ind_15_var_2_prot", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd15Var2Prot() {
		return this.ind_15_var_2_prot;
	}

	public void setInd15Var2Prot(String ind_15_var_2_prot) {
		this.ind_15_var_2_prot = ind_15_var_2_prot;
	}
	private String ind_15_var_2_zyg;

	@Column(name = "ind_15_var_2_zyg", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd15Var2Zyg() {
		return this.ind_15_var_2_zyg;
	}

	public void setInd15Var2Zyg(String ind_15_var_2_zyg) {
		this.ind_15_var_2_zyg = ind_15_var_2_zyg;
	}
	private String ind_15_var_3_cdna;

	@Column(name = "ind_15_var_3_cdna", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd15Var3Cdna() {
		return this.ind_15_var_3_cdna;
	}

	public void setInd15Var3Cdna(String ind_15_var_3_cdna) {
		this.ind_15_var_3_cdna = ind_15_var_3_cdna;
	}
	private String ind_15_var_3_gene;

	@Column(name = "ind_15_var_3_gene", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd15Var3Gene() {
		return this.ind_15_var_3_gene;
	}

	public void setInd15Var3Gene(String ind_15_var_3_gene) {
		this.ind_15_var_3_gene = ind_15_var_3_gene;
	}
	private String ind_15_var_3_prot;

	@Column(name = "ind_15_var_3_prot", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd15Var3Prot() {
		return this.ind_15_var_3_prot;
	}

	public void setInd15Var3Prot(String ind_15_var_3_prot) {
		this.ind_15_var_3_prot = ind_15_var_3_prot;
	}
	private String ind_15_var_3_zyg;

	@Column(name = "ind_15_var_3_zyg", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd15Var3Zyg() {
		return this.ind_15_var_3_zyg;
	}

	public void setInd15Var3Zyg(String ind_15_var_3_zyg) {
		this.ind_15_var_3_zyg = ind_15_var_3_zyg;
	}
	private String ind_16_aff_unaff;

	@Column(name = "ind_16_aff_unaff", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd16AffUnaff() {
		return this.ind_16_aff_unaff;
	}

	public void setInd16AffUnaff(String ind_16_aff_unaff) {
		this.ind_16_aff_unaff = ind_16_aff_unaff;
	}
	private String ind_16_id;

	@Column(name = "ind_16_id", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd16Id() {
		return this.ind_16_id;
	}

	public void setInd16Id(String ind_16_id) {
		this.ind_16_id = ind_16_id;
	}
	private String ind_16_var_1_cdna;

	@Column(name = "ind_16_var_1_cdna", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd16Var1Cdna() {
		return this.ind_16_var_1_cdna;
	}

	public void setInd16Var1Cdna(String ind_16_var_1_cdna) {
		this.ind_16_var_1_cdna = ind_16_var_1_cdna;
	}
	private String ind_16_var_1_gene;

	@Column(name = "ind_16_var_1_gene", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd16Var1Gene() {
		return this.ind_16_var_1_gene;
	}

	public void setInd16Var1Gene(String ind_16_var_1_gene) {
		this.ind_16_var_1_gene = ind_16_var_1_gene;
	}
	private String ind_16_var_1_prot;

	@Column(name = "ind_16_var_1_prot", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd16Var1Prot() {
		return this.ind_16_var_1_prot;
	}

	public void setInd16Var1Prot(String ind_16_var_1_prot) {
		this.ind_16_var_1_prot = ind_16_var_1_prot;
	}
	private String ind_16_var_1_zyg;

	@Column(name = "ind_16_var_1_zyg", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd16Var1Zyg() {
		return this.ind_16_var_1_zyg;
	}

	public void setInd16Var1Zyg(String ind_16_var_1_zyg) {
		this.ind_16_var_1_zyg = ind_16_var_1_zyg;
	}
	private String ind_16_var_2_cdna;

	@Column(name = "ind_16_var_2_cdna", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd16Var2Cdna() {
		return this.ind_16_var_2_cdna;
	}

	public void setInd16Var2Cdna(String ind_16_var_2_cdna) {
		this.ind_16_var_2_cdna = ind_16_var_2_cdna;
	}
	private String ind_16_var_2_gene;

	@Column(name = "ind_16_var_2_gene", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd16Var2Gene() {
		return this.ind_16_var_2_gene;
	}

	public void setInd16Var2Gene(String ind_16_var_2_gene) {
		this.ind_16_var_2_gene = ind_16_var_2_gene;
	}
	private String ind_16_var_2_prot;

	@Column(name = "ind_16_var_2_prot", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd16Var2Prot() {
		return this.ind_16_var_2_prot;
	}

	public void setInd16Var2Prot(String ind_16_var_2_prot) {
		this.ind_16_var_2_prot = ind_16_var_2_prot;
	}
	private String ind_16_var_2_zyg;

	@Column(name = "ind_16_var_2_zyg", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd16Var2Zyg() {
		return this.ind_16_var_2_zyg;
	}

	public void setInd16Var2Zyg(String ind_16_var_2_zyg) {
		this.ind_16_var_2_zyg = ind_16_var_2_zyg;
	}
	private String ind_16_var_3_cdna;

	@Column(name = "ind_16_var_3_cdna", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd16Var3Cdna() {
		return this.ind_16_var_3_cdna;
	}

	public void setInd16Var3Cdna(String ind_16_var_3_cdna) {
		this.ind_16_var_3_cdna = ind_16_var_3_cdna;
	}
	private String ind_16_var_3_gene;

	@Column(name = "ind_16_var_3_gene", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd16Var3Gene() {
		return this.ind_16_var_3_gene;
	}

	public void setInd16Var3Gene(String ind_16_var_3_gene) {
		this.ind_16_var_3_gene = ind_16_var_3_gene;
	}
	private String ind_16_var_3_prot;

	@Column(name = "ind_16_var_3_prot", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd16Var3Prot() {
		return this.ind_16_var_3_prot;
	}

	public void setInd16Var3Prot(String ind_16_var_3_prot) {
		this.ind_16_var_3_prot = ind_16_var_3_prot;
	}
	private String ind_16_var_3_zyg;

	@Column(name = "ind_16_var_3_zyg", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd16Var3Zyg() {
		return this.ind_16_var_3_zyg;
	}

	public void setInd16Var3Zyg(String ind_16_var_3_zyg) {
		this.ind_16_var_3_zyg = ind_16_var_3_zyg;
	}
	private String ind_17_aff_unaff;

	@Column(name = "ind_17_aff_unaff", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd17AffUnaff() {
		return this.ind_17_aff_unaff;
	}

	public void setInd17AffUnaff(String ind_17_aff_unaff) {
		this.ind_17_aff_unaff = ind_17_aff_unaff;
	}
	private String ind_17_id;

	@Column(name = "ind_17_id", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd17Id() {
		return this.ind_17_id;
	}

	public void setInd17Id(String ind_17_id) {
		this.ind_17_id = ind_17_id;
	}
	private String ind_17_var_1_cdna;

	@Column(name = "ind_17_var_1_cdna", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd17Var1Cdna() {
		return this.ind_17_var_1_cdna;
	}

	public void setInd17Var1Cdna(String ind_17_var_1_cdna) {
		this.ind_17_var_1_cdna = ind_17_var_1_cdna;
	}
	private String ind_17_var_1_gene;

	@Column(name = "ind_17_var_1_gene", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd17Var1Gene() {
		return this.ind_17_var_1_gene;
	}

	public void setInd17Var1Gene(String ind_17_var_1_gene) {
		this.ind_17_var_1_gene = ind_17_var_1_gene;
	}
	private String ind_17_var_1_prot;

	@Column(name = "ind_17_var_1_prot", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd17Var1Prot() {
		return this.ind_17_var_1_prot;
	}

	public void setInd17Var1Prot(String ind_17_var_1_prot) {
		this.ind_17_var_1_prot = ind_17_var_1_prot;
	}
	private String ind_17_var_1_zyg;

	@Column(name = "ind_17_var_1_zyg", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd17Var1Zyg() {
		return this.ind_17_var_1_zyg;
	}

	public void setInd17Var1Zyg(String ind_17_var_1_zyg) {
		this.ind_17_var_1_zyg = ind_17_var_1_zyg;
	}
	private String ind_17_var_2_cdna;

	@Column(name = "ind_17_var_2_cdna", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd17Var2Cdna() {
		return this.ind_17_var_2_cdna;
	}

	public void setInd17Var2Cdna(String ind_17_var_2_cdna) {
		this.ind_17_var_2_cdna = ind_17_var_2_cdna;
	}
	private String ind_17_var_2_gene;

	@Column(name = "ind_17_var_2_gene", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd17Var2Gene() {
		return this.ind_17_var_2_gene;
	}

	public void setInd17Var2Gene(String ind_17_var_2_gene) {
		this.ind_17_var_2_gene = ind_17_var_2_gene;
	}
	private String ind_17_var_2_prot;

	@Column(name = "ind_17_var_2_prot", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd17Var2Prot() {
		return this.ind_17_var_2_prot;
	}

	public void setInd17Var2Prot(String ind_17_var_2_prot) {
		this.ind_17_var_2_prot = ind_17_var_2_prot;
	}
	private String ind_17_var_2_zyg;

	@Column(name = "ind_17_var_2_zyg", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd17Var2Zyg() {
		return this.ind_17_var_2_zyg;
	}

	public void setInd17Var2Zyg(String ind_17_var_2_zyg) {
		this.ind_17_var_2_zyg = ind_17_var_2_zyg;
	}
	private String ind_17_var_3_cdna;

	@Column(name = "ind_17_var_3_cdna", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd17Var3Cdna() {
		return this.ind_17_var_3_cdna;
	}

	public void setInd17Var3Cdna(String ind_17_var_3_cdna) {
		this.ind_17_var_3_cdna = ind_17_var_3_cdna;
	}
	private String ind_17_var_3_gene;

	@Column(name = "ind_17_var_3_gene", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd17Var3Gene() {
		return this.ind_17_var_3_gene;
	}

	public void setInd17Var3Gene(String ind_17_var_3_gene) {
		this.ind_17_var_3_gene = ind_17_var_3_gene;
	}
	private String ind_17_var_3_prot;

	@Column(name = "ind_17_var_3_prot", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd17Var3Prot() {
		return this.ind_17_var_3_prot;
	}

	public void setInd17Var3Prot(String ind_17_var_3_prot) {
		this.ind_17_var_3_prot = ind_17_var_3_prot;
	}
	private String ind_17_var_3_zyg;

	@Column(name = "ind_17_var_3_zyg", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd17Var3Zyg() {
		return this.ind_17_var_3_zyg;
	}

	public void setInd17Var3Zyg(String ind_17_var_3_zyg) {
		this.ind_17_var_3_zyg = ind_17_var_3_zyg;
	}
	private String ind_18_aff_unaff;

	@Column(name = "ind_18_aff_unaff", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd18AffUnaff() {
		return this.ind_18_aff_unaff;
	}

	public void setInd18AffUnaff(String ind_18_aff_unaff) {
		this.ind_18_aff_unaff = ind_18_aff_unaff;
	}
	private String ind_18_id;

	@Column(name = "ind_18_id", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd18Id() {
		return this.ind_18_id;
	}

	public void setInd18Id(String ind_18_id) {
		this.ind_18_id = ind_18_id;
	}
	private String ind_18_var_1_cdna;

	@Column(name = "ind_18_var_1_cdna", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd18Var1Cdna() {
		return this.ind_18_var_1_cdna;
	}

	public void setInd18Var1Cdna(String ind_18_var_1_cdna) {
		this.ind_18_var_1_cdna = ind_18_var_1_cdna;
	}
	private String ind_18_var_1_gene;

	@Column(name = "ind_18_var_1_gene", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd18Var1Gene() {
		return this.ind_18_var_1_gene;
	}

	public void setInd18Var1Gene(String ind_18_var_1_gene) {
		this.ind_18_var_1_gene = ind_18_var_1_gene;
	}
	private String ind_18_var_1_prot;

	@Column(name = "ind_18_var_1_prot", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd18Var1Prot() {
		return this.ind_18_var_1_prot;
	}

	public void setInd18Var1Prot(String ind_18_var_1_prot) {
		this.ind_18_var_1_prot = ind_18_var_1_prot;
	}
	private String ind_18_var_1_zyg;

	@Column(name = "ind_18_var_1_zyg", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd18Var1Zyg() {
		return this.ind_18_var_1_zyg;
	}

	public void setInd18Var1Zyg(String ind_18_var_1_zyg) {
		this.ind_18_var_1_zyg = ind_18_var_1_zyg;
	}
	private String ind_18_var_2_cdna;

	@Column(name = "ind_18_var_2_cdna", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd18Var2Cdna() {
		return this.ind_18_var_2_cdna;
	}

	public void setInd18Var2Cdna(String ind_18_var_2_cdna) {
		this.ind_18_var_2_cdna = ind_18_var_2_cdna;
	}
	private String ind_18_var_2_gene;

	@Column(name = "ind_18_var_2_gene", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd18Var2Gene() {
		return this.ind_18_var_2_gene;
	}

	public void setInd18Var2Gene(String ind_18_var_2_gene) {
		this.ind_18_var_2_gene = ind_18_var_2_gene;
	}
	private String ind_18_var_2_prot;

	@Column(name = "ind_18_var_2_prot", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd18Var2Prot() {
		return this.ind_18_var_2_prot;
	}

	public void setInd18Var2Prot(String ind_18_var_2_prot) {
		this.ind_18_var_2_prot = ind_18_var_2_prot;
	}
	private String ind_18_var_2_zyg;

	@Column(name = "ind_18_var_2_zyg", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd18Var2Zyg() {
		return this.ind_18_var_2_zyg;
	}

	public void setInd18Var2Zyg(String ind_18_var_2_zyg) {
		this.ind_18_var_2_zyg = ind_18_var_2_zyg;
	}
	private String ind_18_var_3_cdna;

	@Column(name = "ind_18_var_3_cdna", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd18Var3Cdna() {
		return this.ind_18_var_3_cdna;
	}

	public void setInd18Var3Cdna(String ind_18_var_3_cdna) {
		this.ind_18_var_3_cdna = ind_18_var_3_cdna;
	}
	private String ind_18_var_3_gene;

	@Column(name = "ind_18_var_3_gene", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd18Var3Gene() {
		return this.ind_18_var_3_gene;
	}

	public void setInd18Var3Gene(String ind_18_var_3_gene) {
		this.ind_18_var_3_gene = ind_18_var_3_gene;
	}
	private String ind_18_var_3_prot;

	@Column(name = "ind_18_var_3_prot", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd18Var3Prot() {
		return this.ind_18_var_3_prot;
	}

	public void setInd18Var3Prot(String ind_18_var_3_prot) {
		this.ind_18_var_3_prot = ind_18_var_3_prot;
	}
	private String ind_18_var_3_zyg;

	@Column(name = "ind_18_var_3_zyg", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd18Var3Zyg() {
		return this.ind_18_var_3_zyg;
	}

	public void setInd18Var3Zyg(String ind_18_var_3_zyg) {
		this.ind_18_var_3_zyg = ind_18_var_3_zyg;
	}
	private String ind_19_aff_unaff;

	@Column(name = "ind_19_aff_unaff", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd19AffUnaff() {
		return this.ind_19_aff_unaff;
	}

	public void setInd19AffUnaff(String ind_19_aff_unaff) {
		this.ind_19_aff_unaff = ind_19_aff_unaff;
	}
	private String ind_19_id;

	@Column(name = "ind_19_id", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd19Id() {
		return this.ind_19_id;
	}

	public void setInd19Id(String ind_19_id) {
		this.ind_19_id = ind_19_id;
	}
	private String ind_19_var_1_cdna;

	@Column(name = "ind_19_var_1_cdna", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd19Var1Cdna() {
		return this.ind_19_var_1_cdna;
	}

	public void setInd19Var1Cdna(String ind_19_var_1_cdna) {
		this.ind_19_var_1_cdna = ind_19_var_1_cdna;
	}
	private String ind_19_var_1_gene;

	@Column(name = "ind_19_var_1_gene", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd19Var1Gene() {
		return this.ind_19_var_1_gene;
	}

	public void setInd19Var1Gene(String ind_19_var_1_gene) {
		this.ind_19_var_1_gene = ind_19_var_1_gene;
	}
	private String ind_19_var_1_prot;

	@Column(name = "ind_19_var_1_prot", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd19Var1Prot() {
		return this.ind_19_var_1_prot;
	}

	public void setInd19Var1Prot(String ind_19_var_1_prot) {
		this.ind_19_var_1_prot = ind_19_var_1_prot;
	}
	private String ind_19_var_1_zyg;

	@Column(name = "ind_19_var_1_zyg", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd19Var1Zyg() {
		return this.ind_19_var_1_zyg;
	}

	public void setInd19Var1Zyg(String ind_19_var_1_zyg) {
		this.ind_19_var_1_zyg = ind_19_var_1_zyg;
	}
	private String ind_19_var_2_cdna;

	@Column(name = "ind_19_var_2_cdna", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd19Var2Cdna() {
		return this.ind_19_var_2_cdna;
	}

	public void setInd19Var2Cdna(String ind_19_var_2_cdna) {
		this.ind_19_var_2_cdna = ind_19_var_2_cdna;
	}
	private String ind_19_var_2_gene;

	@Column(name = "ind_19_var_2_gene", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd19Var2Gene() {
		return this.ind_19_var_2_gene;
	}

	public void setInd19Var2Gene(String ind_19_var_2_gene) {
		this.ind_19_var_2_gene = ind_19_var_2_gene;
	}
	private String ind_19_var_2_prot;

	@Column(name = "ind_19_var_2_prot", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd19Var2Prot() {
		return this.ind_19_var_2_prot;
	}

	public void setInd19Var2Prot(String ind_19_var_2_prot) {
		this.ind_19_var_2_prot = ind_19_var_2_prot;
	}
	private String ind_19_var_2_zyg;

	@Column(name = "ind_19_var_2_zyg", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd19Var2Zyg() {
		return this.ind_19_var_2_zyg;
	}

	public void setInd19Var2Zyg(String ind_19_var_2_zyg) {
		this.ind_19_var_2_zyg = ind_19_var_2_zyg;
	}
	private String ind_19_var_3_cdna;

	@Column(name = "ind_19_var_3_cdna", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd19Var3Cdna() {
		return this.ind_19_var_3_cdna;
	}

	public void setInd19Var3Cdna(String ind_19_var_3_cdna) {
		this.ind_19_var_3_cdna = ind_19_var_3_cdna;
	}
	private String ind_19_var_3_gene;

	@Column(name = "ind_19_var_3_gene", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd19Var3Gene() {
		return this.ind_19_var_3_gene;
	}

	public void setInd19Var3Gene(String ind_19_var_3_gene) {
		this.ind_19_var_3_gene = ind_19_var_3_gene;
	}
	private String ind_19_var_3_prot;

	@Column(name = "ind_19_var_3_prot", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd19Var3Prot() {
		return this.ind_19_var_3_prot;
	}

	public void setInd19Var3Prot(String ind_19_var_3_prot) {
		this.ind_19_var_3_prot = ind_19_var_3_prot;
	}
	private String ind_19_var_3_zyg;

	@Column(name = "ind_19_var_3_zyg", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd19Var3Zyg() {
		return this.ind_19_var_3_zyg;
	}

	public void setInd19Var3Zyg(String ind_19_var_3_zyg) {
		this.ind_19_var_3_zyg = ind_19_var_3_zyg;
	}
	private String ind_1_aff_unaff;

	@Column(name = "ind_1_aff_unaff", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd1AffUnaff() {
		return this.ind_1_aff_unaff;
	}

	public void setInd1AffUnaff(String ind_1_aff_unaff) {
		this.ind_1_aff_unaff = ind_1_aff_unaff;
	}
	private String ind_1_id;

	@Column(name = "ind_1_id", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd1Id() {
		return this.ind_1_id;
	}

	public void setInd1Id(String ind_1_id) {
		this.ind_1_id = ind_1_id;
	}
	private String ind_1_var_1_cdna;

	@Column(name = "ind_1_var_1_cdna", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd1Var1Cdna() {
		return this.ind_1_var_1_cdna;
	}

	public void setInd1Var1Cdna(String ind_1_var_1_cdna) {
		this.ind_1_var_1_cdna = ind_1_var_1_cdna;
	}
	private String ind_1_var_1_gene;

	@Column(name = "ind_1_var_1_gene", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd1Var1Gene() {
		return this.ind_1_var_1_gene;
	}

	public void setInd1Var1Gene(String ind_1_var_1_gene) {
		this.ind_1_var_1_gene = ind_1_var_1_gene;
	}
	private String ind_1_var_1_prot;

	@Column(name = "ind_1_var_1_prot", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd1Var1Prot() {
		return this.ind_1_var_1_prot;
	}

	public void setInd1Var1Prot(String ind_1_var_1_prot) {
		this.ind_1_var_1_prot = ind_1_var_1_prot;
	}
	private String ind_1_var_1_zyg;

	@Column(name = "ind_1_var_1_zyg", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd1Var1Zyg() {
		return this.ind_1_var_1_zyg;
	}

	public void setInd1Var1Zyg(String ind_1_var_1_zyg) {
		this.ind_1_var_1_zyg = ind_1_var_1_zyg;
	}
	private String ind_1_var_2_cdna;

	@Column(name = "ind_1_var_2_cdna", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd1Var2Cdna() {
		return this.ind_1_var_2_cdna;
	}

	public void setInd1Var2Cdna(String ind_1_var_2_cdna) {
		this.ind_1_var_2_cdna = ind_1_var_2_cdna;
	}
	private String ind_1_var_2_gene;

	@Column(name = "ind_1_var_2_gene", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd1Var2Gene() {
		return this.ind_1_var_2_gene;
	}

	public void setInd1Var2Gene(String ind_1_var_2_gene) {
		this.ind_1_var_2_gene = ind_1_var_2_gene;
	}
	private String ind_1_var_2_prot;

	@Column(name = "ind_1_var_2_prot", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd1Var2Prot() {
		return this.ind_1_var_2_prot;
	}

	public void setInd1Var2Prot(String ind_1_var_2_prot) {
		this.ind_1_var_2_prot = ind_1_var_2_prot;
	}
	private String ind_1_var_2_zyg;

	@Column(name = "ind_1_var_2_zyg", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd1Var2Zyg() {
		return this.ind_1_var_2_zyg;
	}

	public void setInd1Var2Zyg(String ind_1_var_2_zyg) {
		this.ind_1_var_2_zyg = ind_1_var_2_zyg;
	}
	private String ind_1_var_3_cdna;

	@Column(name = "ind_1_var_3_cdna", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd1Var3Cdna() {
		return this.ind_1_var_3_cdna;
	}

	public void setInd1Var3Cdna(String ind_1_var_3_cdna) {
		this.ind_1_var_3_cdna = ind_1_var_3_cdna;
	}
	private String ind_1_var_3_gene;

	@Column(name = "ind_1_var_3_gene", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd1Var3Gene() {
		return this.ind_1_var_3_gene;
	}

	public void setInd1Var3Gene(String ind_1_var_3_gene) {
		this.ind_1_var_3_gene = ind_1_var_3_gene;
	}
	private String ind_1_var_3_prot;

	@Column(name = "ind_1_var_3_prot", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd1Var3Prot() {
		return this.ind_1_var_3_prot;
	}

	public void setInd1Var3Prot(String ind_1_var_3_prot) {
		this.ind_1_var_3_prot = ind_1_var_3_prot;
	}
	private String ind_1_var_3_zyg;

	@Column(name = "ind_1_var_3_zyg", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd1Var3Zyg() {
		return this.ind_1_var_3_zyg;
	}

	public void setInd1Var3Zyg(String ind_1_var_3_zyg) {
		this.ind_1_var_3_zyg = ind_1_var_3_zyg;
	}
	private String ind_20_aff_unaff;

	@Column(name = "ind_20_aff_unaff", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd20AffUnaff() {
		return this.ind_20_aff_unaff;
	}

	public void setInd20AffUnaff(String ind_20_aff_unaff) {
		this.ind_20_aff_unaff = ind_20_aff_unaff;
	}
	private String ind_20_id;

	@Column(name = "ind_20_id", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd20Id() {
		return this.ind_20_id;
	}

	public void setInd20Id(String ind_20_id) {
		this.ind_20_id = ind_20_id;
	}
	private String ind_20_var_1_cdna;

	@Column(name = "ind_20_var_1_cdna", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd20Var1Cdna() {
		return this.ind_20_var_1_cdna;
	}

	public void setInd20Var1Cdna(String ind_20_var_1_cdna) {
		this.ind_20_var_1_cdna = ind_20_var_1_cdna;
	}
	private String ind_20_var_1_gene;

	@Column(name = "ind_20_var_1_gene", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd20Var1Gene() {
		return this.ind_20_var_1_gene;
	}

	public void setInd20Var1Gene(String ind_20_var_1_gene) {
		this.ind_20_var_1_gene = ind_20_var_1_gene;
	}
	private String ind_20_var_1_prot;

	@Column(name = "ind_20_var_1_prot", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd20Var1Prot() {
		return this.ind_20_var_1_prot;
	}

	public void setInd20Var1Prot(String ind_20_var_1_prot) {
		this.ind_20_var_1_prot = ind_20_var_1_prot;
	}
	private String ind_20_var_1_zyg;

	@Column(name = "ind_20_var_1_zyg", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd20Var1Zyg() {
		return this.ind_20_var_1_zyg;
	}

	public void setInd20Var1Zyg(String ind_20_var_1_zyg) {
		this.ind_20_var_1_zyg = ind_20_var_1_zyg;
	}
	private String ind_20_var_2_cdna;

	@Column(name = "ind_20_var_2_cdna", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd20Var2Cdna() {
		return this.ind_20_var_2_cdna;
	}

	public void setInd20Var2Cdna(String ind_20_var_2_cdna) {
		this.ind_20_var_2_cdna = ind_20_var_2_cdna;
	}
	private String ind_20_var_2_gene;

	@Column(name = "ind_20_var_2_gene", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd20Var2Gene() {
		return this.ind_20_var_2_gene;
	}

	public void setInd20Var2Gene(String ind_20_var_2_gene) {
		this.ind_20_var_2_gene = ind_20_var_2_gene;
	}
	private String ind_20_var_2_prot;

	@Column(name = "ind_20_var_2_prot", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd20Var2Prot() {
		return this.ind_20_var_2_prot;
	}

	public void setInd20Var2Prot(String ind_20_var_2_prot) {
		this.ind_20_var_2_prot = ind_20_var_2_prot;
	}
	private String ind_20_var_2_zyg;

	@Column(name = "ind_20_var_2_zyg", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd20Var2Zyg() {
		return this.ind_20_var_2_zyg;
	}

	public void setInd20Var2Zyg(String ind_20_var_2_zyg) {
		this.ind_20_var_2_zyg = ind_20_var_2_zyg;
	}
	private String ind_20_var_3_cdna;

	@Column(name = "ind_20_var_3_cdna", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd20Var3Cdna() {
		return this.ind_20_var_3_cdna;
	}

	public void setInd20Var3Cdna(String ind_20_var_3_cdna) {
		this.ind_20_var_3_cdna = ind_20_var_3_cdna;
	}
	private String ind_20_var_3_gene;

	@Column(name = "ind_20_var_3_gene", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd20Var3Gene() {
		return this.ind_20_var_3_gene;
	}

	public void setInd20Var3Gene(String ind_20_var_3_gene) {
		this.ind_20_var_3_gene = ind_20_var_3_gene;
	}
	private String ind_20_var_3_prot;

	@Column(name = "ind_20_var_3_prot", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd20Var3Prot() {
		return this.ind_20_var_3_prot;
	}

	public void setInd20Var3Prot(String ind_20_var_3_prot) {
		this.ind_20_var_3_prot = ind_20_var_3_prot;
	}
	private String ind_20_var_3_zyg;

	@Column(name = "ind_20_var_3_zyg", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd20Var3Zyg() {
		return this.ind_20_var_3_zyg;
	}

	public void setInd20Var3Zyg(String ind_20_var_3_zyg) {
		this.ind_20_var_3_zyg = ind_20_var_3_zyg;
	}
	private String ind_2_aff_unaff;

	@Column(name = "ind_2_aff_unaff", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd2AffUnaff() {
		return this.ind_2_aff_unaff;
	}

	public void setInd2AffUnaff(String ind_2_aff_unaff) {
		this.ind_2_aff_unaff = ind_2_aff_unaff;
	}
	private String ind_2_id;

	@Column(name = "ind_2_id", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd2Id() {
		return this.ind_2_id;
	}

	public void setInd2Id(String ind_2_id) {
		this.ind_2_id = ind_2_id;
	}
	private String ind_2_var_1_cdna;

	@Column(name = "ind_2_var_1_cdna", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd2Var1Cdna() {
		return this.ind_2_var_1_cdna;
	}

	public void setInd2Var1Cdna(String ind_2_var_1_cdna) {
		this.ind_2_var_1_cdna = ind_2_var_1_cdna;
	}
	private String ind_2_var_1_gene;

	@Column(name = "ind_2_var_1_gene", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd2Var1Gene() {
		return this.ind_2_var_1_gene;
	}

	public void setInd2Var1Gene(String ind_2_var_1_gene) {
		this.ind_2_var_1_gene = ind_2_var_1_gene;
	}
	private String ind_2_var_1_prot;

	@Column(name = "ind_2_var_1_prot", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd2Var1Prot() {
		return this.ind_2_var_1_prot;
	}

	public void setInd2Var1Prot(String ind_2_var_1_prot) {
		this.ind_2_var_1_prot = ind_2_var_1_prot;
	}
	private String ind_2_var_1_zyg;

	@Column(name = "ind_2_var_1_zyg", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd2Var1Zyg() {
		return this.ind_2_var_1_zyg;
	}

	public void setInd2Var1Zyg(String ind_2_var_1_zyg) {
		this.ind_2_var_1_zyg = ind_2_var_1_zyg;
	}
	private String ind_2_var_2_cdna;

	@Column(name = "ind_2_var_2_cdna", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd2Var2Cdna() {
		return this.ind_2_var_2_cdna;
	}

	public void setInd2Var2Cdna(String ind_2_var_2_cdna) {
		this.ind_2_var_2_cdna = ind_2_var_2_cdna;
	}
	private String ind_2_var_2_gene;

	@Column(name = "ind_2_var_2_gene", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd2Var2Gene() {
		return this.ind_2_var_2_gene;
	}

	public void setInd2Var2Gene(String ind_2_var_2_gene) {
		this.ind_2_var_2_gene = ind_2_var_2_gene;
	}
	private String ind_2_var_2_prot;

	@Column(name = "ind_2_var_2_prot", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd2Var2Prot() {
		return this.ind_2_var_2_prot;
	}

	public void setInd2Var2Prot(String ind_2_var_2_prot) {
		this.ind_2_var_2_prot = ind_2_var_2_prot;
	}
	private String ind_2_var_2_zyg;

	@Column(name = "ind_2_var_2_zyg", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd2Var2Zyg() {
		return this.ind_2_var_2_zyg;
	}

	public void setInd2Var2Zyg(String ind_2_var_2_zyg) {
		this.ind_2_var_2_zyg = ind_2_var_2_zyg;
	}
	private String ind_2_var_3_cdna;

	@Column(name = "ind_2_var_3_cdna", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd2Var3Cdna() {
		return this.ind_2_var_3_cdna;
	}

	public void setInd2Var3Cdna(String ind_2_var_3_cdna) {
		this.ind_2_var_3_cdna = ind_2_var_3_cdna;
	}
	private String ind_2_var_3_gene;

	@Column(name = "ind_2_var_3_gene", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd2Var3Gene() {
		return this.ind_2_var_3_gene;
	}

	public void setInd2Var3Gene(String ind_2_var_3_gene) {
		this.ind_2_var_3_gene = ind_2_var_3_gene;
	}
	private String ind_2_var_3_prot;

	@Column(name = "ind_2_var_3_prot", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd2Var3Prot() {
		return this.ind_2_var_3_prot;
	}

	public void setInd2Var3Prot(String ind_2_var_3_prot) {
		this.ind_2_var_3_prot = ind_2_var_3_prot;
	}
	private String ind_2_var_3_zyg;

	@Column(name = "ind_2_var_3_zyg", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd2Var3Zyg() {
		return this.ind_2_var_3_zyg;
	}

	public void setInd2Var3Zyg(String ind_2_var_3_zyg) {
		this.ind_2_var_3_zyg = ind_2_var_3_zyg;
	}
	private String ind_3_aff_unaff;

	@Column(name = "ind_3_aff_unaff", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd3AffUnaff() {
		return this.ind_3_aff_unaff;
	}

	public void setInd3AffUnaff(String ind_3_aff_unaff) {
		this.ind_3_aff_unaff = ind_3_aff_unaff;
	}
	private String ind_3_id;

	@Column(name = "ind_3_id", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd3Id() {
		return this.ind_3_id;
	}

	public void setInd3Id(String ind_3_id) {
		this.ind_3_id = ind_3_id;
	}
	private String ind_3_var_1_cdna;

	@Column(name = "ind_3_var_1_cdna", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd3Var1Cdna() {
		return this.ind_3_var_1_cdna;
	}

	public void setInd3Var1Cdna(String ind_3_var_1_cdna) {
		this.ind_3_var_1_cdna = ind_3_var_1_cdna;
	}
	private String ind_3_var_1_gene;

	@Column(name = "ind_3_var_1_gene", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd3Var1Gene() {
		return this.ind_3_var_1_gene;
	}

	public void setInd3Var1Gene(String ind_3_var_1_gene) {
		this.ind_3_var_1_gene = ind_3_var_1_gene;
	}
	private String ind_3_var_1_prot;

	@Column(name = "ind_3_var_1_prot", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd3Var1Prot() {
		return this.ind_3_var_1_prot;
	}

	public void setInd3Var1Prot(String ind_3_var_1_prot) {
		this.ind_3_var_1_prot = ind_3_var_1_prot;
	}
	private String ind_3_var_1_zyg;

	@Column(name = "ind_3_var_1_zyg", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd3Var1Zyg() {
		return this.ind_3_var_1_zyg;
	}

	public void setInd3Var1Zyg(String ind_3_var_1_zyg) {
		this.ind_3_var_1_zyg = ind_3_var_1_zyg;
	}
	private String ind_3_var_2_cdna;

	@Column(name = "ind_3_var_2_cdna", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd3Var2Cdna() {
		return this.ind_3_var_2_cdna;
	}

	public void setInd3Var2Cdna(String ind_3_var_2_cdna) {
		this.ind_3_var_2_cdna = ind_3_var_2_cdna;
	}
	private String ind_3_var_2_gene;

	@Column(name = "ind_3_var_2_gene", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd3Var2Gene() {
		return this.ind_3_var_2_gene;
	}

	public void setInd3Var2Gene(String ind_3_var_2_gene) {
		this.ind_3_var_2_gene = ind_3_var_2_gene;
	}
	private String ind_3_var_2_prot;

	@Column(name = "ind_3_var_2_prot", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd3Var2Prot() {
		return this.ind_3_var_2_prot;
	}

	public void setInd3Var2Prot(String ind_3_var_2_prot) {
		this.ind_3_var_2_prot = ind_3_var_2_prot;
	}
	private String ind_3_var_2_zyg;

	@Column(name = "ind_3_var_2_zyg", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd3Var2Zyg() {
		return this.ind_3_var_2_zyg;
	}

	public void setInd3Var2Zyg(String ind_3_var_2_zyg) {
		this.ind_3_var_2_zyg = ind_3_var_2_zyg;
	}
	private String ind_3_var_3_cdna;

	@Column(name = "ind_3_var_3_cdna", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd3Var3Cdna() {
		return this.ind_3_var_3_cdna;
	}

	public void setInd3Var3Cdna(String ind_3_var_3_cdna) {
		this.ind_3_var_3_cdna = ind_3_var_3_cdna;
	}
	private String ind_3_var_3_gene;

	@Column(name = "ind_3_var_3_gene", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd3Var3Gene() {
		return this.ind_3_var_3_gene;
	}

	public void setInd3Var3Gene(String ind_3_var_3_gene) {
		this.ind_3_var_3_gene = ind_3_var_3_gene;
	}
	private String ind_3_var_3_prot;

	@Column(name = "ind_3_var_3_prot", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd3Var3Prot() {
		return this.ind_3_var_3_prot;
	}

	public void setInd3Var3Prot(String ind_3_var_3_prot) {
		this.ind_3_var_3_prot = ind_3_var_3_prot;
	}
	private String ind_3_var_3_zyg;

	@Column(name = "ind_3_var_3_zyg", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd3Var3Zyg() {
		return this.ind_3_var_3_zyg;
	}

	public void setInd3Var3Zyg(String ind_3_var_3_zyg) {
		this.ind_3_var_3_zyg = ind_3_var_3_zyg;
	}
	private String ind_4_aff_unaff;

	@Column(name = "ind_4_aff_unaff", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd4AffUnaff() {
		return this.ind_4_aff_unaff;
	}

	public void setInd4AffUnaff(String ind_4_aff_unaff) {
		this.ind_4_aff_unaff = ind_4_aff_unaff;
	}
	private String ind_4_id;

	@Column(name = "ind_4_id", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd4Id() {
		return this.ind_4_id;
	}

	public void setInd4Id(String ind_4_id) {
		this.ind_4_id = ind_4_id;
	}
	private String ind_4_var_1_cdna;

	@Column(name = "ind_4_var_1_cdna", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd4Var1Cdna() {
		return this.ind_4_var_1_cdna;
	}

	public void setInd4Var1Cdna(String ind_4_var_1_cdna) {
		this.ind_4_var_1_cdna = ind_4_var_1_cdna;
	}
	private String ind_4_var_1_gene;

	@Column(name = "ind_4_var_1_gene", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd4Var1Gene() {
		return this.ind_4_var_1_gene;
	}

	public void setInd4Var1Gene(String ind_4_var_1_gene) {
		this.ind_4_var_1_gene = ind_4_var_1_gene;
	}
	private String ind_4_var_1_prot;

	@Column(name = "ind_4_var_1_prot", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd4Var1Prot() {
		return this.ind_4_var_1_prot;
	}

	public void setInd4Var1Prot(String ind_4_var_1_prot) {
		this.ind_4_var_1_prot = ind_4_var_1_prot;
	}
	private String ind_4_var_1_zyg;

	@Column(name = "ind_4_var_1_zyg", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd4Var1Zyg() {
		return this.ind_4_var_1_zyg;
	}

	public void setInd4Var1Zyg(String ind_4_var_1_zyg) {
		this.ind_4_var_1_zyg = ind_4_var_1_zyg;
	}
	private String ind_4_var_2_cdna;

	@Column(name = "ind_4_var_2_cdna", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd4Var2Cdna() {
		return this.ind_4_var_2_cdna;
	}

	public void setInd4Var2Cdna(String ind_4_var_2_cdna) {
		this.ind_4_var_2_cdna = ind_4_var_2_cdna;
	}
	private String ind_4_var_2_gene;

	@Column(name = "ind_4_var_2_gene", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd4Var2Gene() {
		return this.ind_4_var_2_gene;
	}

	public void setInd4Var2Gene(String ind_4_var_2_gene) {
		this.ind_4_var_2_gene = ind_4_var_2_gene;
	}
	private String ind_4_var_2_prot;

	@Column(name = "ind_4_var_2_prot", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd4Var2Prot() {
		return this.ind_4_var_2_prot;
	}

	public void setInd4Var2Prot(String ind_4_var_2_prot) {
		this.ind_4_var_2_prot = ind_4_var_2_prot;
	}
	private String ind_4_var_2_zyg;

	@Column(name = "ind_4_var_2_zyg", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd4Var2Zyg() {
		return this.ind_4_var_2_zyg;
	}

	public void setInd4Var2Zyg(String ind_4_var_2_zyg) {
		this.ind_4_var_2_zyg = ind_4_var_2_zyg;
	}
	private String ind_4_var_3_cdna;

	@Column(name = "ind_4_var_3_cdna", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd4Var3Cdna() {
		return this.ind_4_var_3_cdna;
	}

	public void setInd4Var3Cdna(String ind_4_var_3_cdna) {
		this.ind_4_var_3_cdna = ind_4_var_3_cdna;
	}
	private String ind_4_var_3_gene;

	@Column(name = "ind_4_var_3_gene", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd4Var3Gene() {
		return this.ind_4_var_3_gene;
	}

	public void setInd4Var3Gene(String ind_4_var_3_gene) {
		this.ind_4_var_3_gene = ind_4_var_3_gene;
	}
	private String ind_4_var_3_prot;

	@Column(name = "ind_4_var_3_prot", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd4Var3Prot() {
		return this.ind_4_var_3_prot;
	}

	public void setInd4Var3Prot(String ind_4_var_3_prot) {
		this.ind_4_var_3_prot = ind_4_var_3_prot;
	}
	private String ind_4_var_3_zyg;

	@Column(name = "ind_4_var_3_zyg", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd4Var3Zyg() {
		return this.ind_4_var_3_zyg;
	}

	public void setInd4Var3Zyg(String ind_4_var_3_zyg) {
		this.ind_4_var_3_zyg = ind_4_var_3_zyg;
	}
	private String ind_5_aff_unaff;

	@Column(name = "ind_5_aff_unaff", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd5AffUnaff() {
		return this.ind_5_aff_unaff;
	}

	public void setInd5AffUnaff(String ind_5_aff_unaff) {
		this.ind_5_aff_unaff = ind_5_aff_unaff;
	}
	private String ind_5_id;

	@Column(name = "ind_5_id", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd5Id() {
		return this.ind_5_id;
	}

	public void setInd5Id(String ind_5_id) {
		this.ind_5_id = ind_5_id;
	}
	private String ind_5_var_1_cdna;

	@Column(name = "ind_5_var_1_cdna", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd5Var1Cdna() {
		return this.ind_5_var_1_cdna;
	}

	public void setInd5Var1Cdna(String ind_5_var_1_cdna) {
		this.ind_5_var_1_cdna = ind_5_var_1_cdna;
	}
	private String ind_5_var_1_gene;

	@Column(name = "ind_5_var_1_gene", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd5Var1Gene() {
		return this.ind_5_var_1_gene;
	}

	public void setInd5Var1Gene(String ind_5_var_1_gene) {
		this.ind_5_var_1_gene = ind_5_var_1_gene;
	}
	private String ind_5_var_1_prot;

	@Column(name = "ind_5_var_1_prot", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd5Var1Prot() {
		return this.ind_5_var_1_prot;
	}

	public void setInd5Var1Prot(String ind_5_var_1_prot) {
		this.ind_5_var_1_prot = ind_5_var_1_prot;
	}
	private String ind_5_var_1_zyg;

	@Column(name = "ind_5_var_1_zyg", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd5Var1Zyg() {
		return this.ind_5_var_1_zyg;
	}

	public void setInd5Var1Zyg(String ind_5_var_1_zyg) {
		this.ind_5_var_1_zyg = ind_5_var_1_zyg;
	}
	private String ind_5_var_2_cdna;

	@Column(name = "ind_5_var_2_cdna", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd5Var2Cdna() {
		return this.ind_5_var_2_cdna;
	}

	public void setInd5Var2Cdna(String ind_5_var_2_cdna) {
		this.ind_5_var_2_cdna = ind_5_var_2_cdna;
	}
	private String ind_5_var_2_gene;

	@Column(name = "ind_5_var_2_gene", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd5Var2Gene() {
		return this.ind_5_var_2_gene;
	}

	public void setInd5Var2Gene(String ind_5_var_2_gene) {
		this.ind_5_var_2_gene = ind_5_var_2_gene;
	}
	private String ind_5_var_2_prot;

	@Column(name = "ind_5_var_2_prot", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd5Var2Prot() {
		return this.ind_5_var_2_prot;
	}

	public void setInd5Var2Prot(String ind_5_var_2_prot) {
		this.ind_5_var_2_prot = ind_5_var_2_prot;
	}
	private String ind_5_var_2_zyg;

	@Column(name = "ind_5_var_2_zyg", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd5Var2Zyg() {
		return this.ind_5_var_2_zyg;
	}

	public void setInd5Var2Zyg(String ind_5_var_2_zyg) {
		this.ind_5_var_2_zyg = ind_5_var_2_zyg;
	}
	private String ind_5_var_3_cdna;

	@Column(name = "ind_5_var_3_cdna", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd5Var3Cdna() {
		return this.ind_5_var_3_cdna;
	}

	public void setInd5Var3Cdna(String ind_5_var_3_cdna) {
		this.ind_5_var_3_cdna = ind_5_var_3_cdna;
	}
	private String ind_5_var_3_gene;

	@Column(name = "ind_5_var_3_gene", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd5Var3Gene() {
		return this.ind_5_var_3_gene;
	}

	public void setInd5Var3Gene(String ind_5_var_3_gene) {
		this.ind_5_var_3_gene = ind_5_var_3_gene;
	}
	private String ind_5_var_3_prot;

	@Column(name = "ind_5_var_3_prot", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd5Var3Prot() {
		return this.ind_5_var_3_prot;
	}

	public void setInd5Var3Prot(String ind_5_var_3_prot) {
		this.ind_5_var_3_prot = ind_5_var_3_prot;
	}
	private String ind_5_var_3_zyg;

	@Column(name = "ind_5_var_3_zyg", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd5Var3Zyg() {
		return this.ind_5_var_3_zyg;
	}

	public void setInd5Var3Zyg(String ind_5_var_3_zyg) {
		this.ind_5_var_3_zyg = ind_5_var_3_zyg;
	}
	private String ind_6_aff_unaff;

	@Column(name = "ind_6_aff_unaff", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd6AffUnaff() {
		return this.ind_6_aff_unaff;
	}

	public void setInd6AffUnaff(String ind_6_aff_unaff) {
		this.ind_6_aff_unaff = ind_6_aff_unaff;
	}
	private String ind_6_id;

	@Column(name = "ind_6_id", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd6Id() {
		return this.ind_6_id;
	}

	public void setInd6Id(String ind_6_id) {
		this.ind_6_id = ind_6_id;
	}
	private String ind_6_var_1_cdna;

	@Column(name = "ind_6_var_1_cdna", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd6Var1Cdna() {
		return this.ind_6_var_1_cdna;
	}

	public void setInd6Var1Cdna(String ind_6_var_1_cdna) {
		this.ind_6_var_1_cdna = ind_6_var_1_cdna;
	}
	private String ind_6_var_1_gene;

	@Column(name = "ind_6_var_1_gene", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd6Var1Gene() {
		return this.ind_6_var_1_gene;
	}

	public void setInd6Var1Gene(String ind_6_var_1_gene) {
		this.ind_6_var_1_gene = ind_6_var_1_gene;
	}
	private String ind_6_var_1_prot;

	@Column(name = "ind_6_var_1_prot", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd6Var1Prot() {
		return this.ind_6_var_1_prot;
	}

	public void setInd6Var1Prot(String ind_6_var_1_prot) {
		this.ind_6_var_1_prot = ind_6_var_1_prot;
	}
	private String ind_6_var_1_zyg;

	@Column(name = "ind_6_var_1_zyg", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd6Var1Zyg() {
		return this.ind_6_var_1_zyg;
	}

	public void setInd6Var1Zyg(String ind_6_var_1_zyg) {
		this.ind_6_var_1_zyg = ind_6_var_1_zyg;
	}
	private String ind_6_var_2_cdna;

	@Column(name = "ind_6_var_2_cdna", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd6Var2Cdna() {
		return this.ind_6_var_2_cdna;
	}

	public void setInd6Var2Cdna(String ind_6_var_2_cdna) {
		this.ind_6_var_2_cdna = ind_6_var_2_cdna;
	}
	private String ind_6_var_2_gene;

	@Column(name = "ind_6_var_2_gene", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd6Var2Gene() {
		return this.ind_6_var_2_gene;
	}

	public void setInd6Var2Gene(String ind_6_var_2_gene) {
		this.ind_6_var_2_gene = ind_6_var_2_gene;
	}
	private String ind_6_var_2_prot;

	@Column(name = "ind_6_var_2_prot", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd6Var2Prot() {
		return this.ind_6_var_2_prot;
	}

	public void setInd6Var2Prot(String ind_6_var_2_prot) {
		this.ind_6_var_2_prot = ind_6_var_2_prot;
	}
	private String ind_6_var_2_zyg;

	@Column(name = "ind_6_var_2_zyg", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd6Var2Zyg() {
		return this.ind_6_var_2_zyg;
	}

	public void setInd6Var2Zyg(String ind_6_var_2_zyg) {
		this.ind_6_var_2_zyg = ind_6_var_2_zyg;
	}
	private String ind_6_var_3_cdna;

	@Column(name = "ind_6_var_3_cdna", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd6Var3Cdna() {
		return this.ind_6_var_3_cdna;
	}

	public void setInd6Var3Cdna(String ind_6_var_3_cdna) {
		this.ind_6_var_3_cdna = ind_6_var_3_cdna;
	}
	private String ind_6_var_3_gene;

	@Column(name = "ind_6_var_3_gene", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd6Var3Gene() {
		return this.ind_6_var_3_gene;
	}

	public void setInd6Var3Gene(String ind_6_var_3_gene) {
		this.ind_6_var_3_gene = ind_6_var_3_gene;
	}
	private String ind_6_var_3_prot;

	@Column(name = "ind_6_var_3_prot", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd6Var3Prot() {
		return this.ind_6_var_3_prot;
	}

	public void setInd6Var3Prot(String ind_6_var_3_prot) {
		this.ind_6_var_3_prot = ind_6_var_3_prot;
	}
	private String ind_6_var_3_zyg;

	@Column(name = "ind_6_var_3_zyg", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd6Var3Zyg() {
		return this.ind_6_var_3_zyg;
	}

	public void setInd6Var3Zyg(String ind_6_var_3_zyg) {
		this.ind_6_var_3_zyg = ind_6_var_3_zyg;
	}
	private String ind_7_aff_unaff;

	@Column(name = "ind_7_aff_unaff", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd7AffUnaff() {
		return this.ind_7_aff_unaff;
	}

	public void setInd7AffUnaff(String ind_7_aff_unaff) {
		this.ind_7_aff_unaff = ind_7_aff_unaff;
	}
	private String ind_7_id;

	@Column(name = "ind_7_id", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd7Id() {
		return this.ind_7_id;
	}

	public void setInd7Id(String ind_7_id) {
		this.ind_7_id = ind_7_id;
	}
	private String ind_7_var_1_cdna;

	@Column(name = "ind_7_var_1_cdna", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd7Var1Cdna() {
		return this.ind_7_var_1_cdna;
	}

	public void setInd7Var1Cdna(String ind_7_var_1_cdna) {
		this.ind_7_var_1_cdna = ind_7_var_1_cdna;
	}
	private String ind_7_var_1_gene;

	@Column(name = "ind_7_var_1_gene", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd7Var1Gene() {
		return this.ind_7_var_1_gene;
	}

	public void setInd7Var1Gene(String ind_7_var_1_gene) {
		this.ind_7_var_1_gene = ind_7_var_1_gene;
	}
	private String ind_7_var_1_prot;

	@Column(name = "ind_7_var_1_prot", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd7Var1Prot() {
		return this.ind_7_var_1_prot;
	}

	public void setInd7Var1Prot(String ind_7_var_1_prot) {
		this.ind_7_var_1_prot = ind_7_var_1_prot;
	}
	private String ind_7_var_1_zyg;

	@Column(name = "ind_7_var_1_zyg", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd7Var1Zyg() {
		return this.ind_7_var_1_zyg;
	}

	public void setInd7Var1Zyg(String ind_7_var_1_zyg) {
		this.ind_7_var_1_zyg = ind_7_var_1_zyg;
	}
	private String ind_7_var_2_cdna;

	@Column(name = "ind_7_var_2_cdna", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd7Var2Cdna() {
		return this.ind_7_var_2_cdna;
	}

	public void setInd7Var2Cdna(String ind_7_var_2_cdna) {
		this.ind_7_var_2_cdna = ind_7_var_2_cdna;
	}
	private String ind_7_var_2_gene;

	@Column(name = "ind_7_var_2_gene", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd7Var2Gene() {
		return this.ind_7_var_2_gene;
	}

	public void setInd7Var2Gene(String ind_7_var_2_gene) {
		this.ind_7_var_2_gene = ind_7_var_2_gene;
	}
	private String ind_7_var_2_prot;

	@Column(name = "ind_7_var_2_prot", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd7Var2Prot() {
		return this.ind_7_var_2_prot;
	}

	public void setInd7Var2Prot(String ind_7_var_2_prot) {
		this.ind_7_var_2_prot = ind_7_var_2_prot;
	}
	private String ind_7_var_2_zyg;

	@Column(name = "ind_7_var_2_zyg", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd7Var2Zyg() {
		return this.ind_7_var_2_zyg;
	}

	public void setInd7Var2Zyg(String ind_7_var_2_zyg) {
		this.ind_7_var_2_zyg = ind_7_var_2_zyg;
	}
	private String ind_7_var_3_cdna;

	@Column(name = "ind_7_var_3_cdna", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd7Var3Cdna() {
		return this.ind_7_var_3_cdna;
	}

	public void setInd7Var3Cdna(String ind_7_var_3_cdna) {
		this.ind_7_var_3_cdna = ind_7_var_3_cdna;
	}
	private String ind_7_var_3_gene;

	@Column(name = "ind_7_var_3_gene", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd7Var3Gene() {
		return this.ind_7_var_3_gene;
	}

	public void setInd7Var3Gene(String ind_7_var_3_gene) {
		this.ind_7_var_3_gene = ind_7_var_3_gene;
	}
	private String ind_7_var_3_prot;

	@Column(name = "ind_7_var_3_prot", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd7Var3Prot() {
		return this.ind_7_var_3_prot;
	}

	public void setInd7Var3Prot(String ind_7_var_3_prot) {
		this.ind_7_var_3_prot = ind_7_var_3_prot;
	}
	private String ind_7_var_3_zyg;

	@Column(name = "ind_7_var_3_zyg", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd7Var3Zyg() {
		return this.ind_7_var_3_zyg;
	}

	public void setInd7Var3Zyg(String ind_7_var_3_zyg) {
		this.ind_7_var_3_zyg = ind_7_var_3_zyg;
	}
	private String ind_8_aff_unaff;

	@Column(name = "ind_8_aff_unaff", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd8AffUnaff() {
		return this.ind_8_aff_unaff;
	}

	public void setInd8AffUnaff(String ind_8_aff_unaff) {
		this.ind_8_aff_unaff = ind_8_aff_unaff;
	}
	private String ind_8_id;

	@Column(name = "ind_8_id", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd8Id() {
		return this.ind_8_id;
	}

	public void setInd8Id(String ind_8_id) {
		this.ind_8_id = ind_8_id;
	}
	private String ind_8_var_1_cdna;

	@Column(name = "ind_8_var_1_cdna", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd8Var1Cdna() {
		return this.ind_8_var_1_cdna;
	}

	public void setInd8Var1Cdna(String ind_8_var_1_cdna) {
		this.ind_8_var_1_cdna = ind_8_var_1_cdna;
	}
	private String ind_8_var_1_gene;

	@Column(name = "ind_8_var_1_gene", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd8Var1Gene() {
		return this.ind_8_var_1_gene;
	}

	public void setInd8Var1Gene(String ind_8_var_1_gene) {
		this.ind_8_var_1_gene = ind_8_var_1_gene;
	}
	private String ind_8_var_1_prot;

	@Column(name = "ind_8_var_1_prot", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd8Var1Prot() {
		return this.ind_8_var_1_prot;
	}

	public void setInd8Var1Prot(String ind_8_var_1_prot) {
		this.ind_8_var_1_prot = ind_8_var_1_prot;
	}
	private String ind_8_var_1_zyg;

	@Column(name = "ind_8_var_1_zyg", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd8Var1Zyg() {
		return this.ind_8_var_1_zyg;
	}

	public void setInd8Var1Zyg(String ind_8_var_1_zyg) {
		this.ind_8_var_1_zyg = ind_8_var_1_zyg;
	}
	private String ind_8_var_2_cdna;

	@Column(name = "ind_8_var_2_cdna", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd8Var2Cdna() {
		return this.ind_8_var_2_cdna;
	}

	public void setInd8Var2Cdna(String ind_8_var_2_cdna) {
		this.ind_8_var_2_cdna = ind_8_var_2_cdna;
	}
	private String ind_8_var_2_gene;

	@Column(name = "ind_8_var_2_gene", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd8Var2Gene() {
		return this.ind_8_var_2_gene;
	}

	public void setInd8Var2Gene(String ind_8_var_2_gene) {
		this.ind_8_var_2_gene = ind_8_var_2_gene;
	}
	private String ind_8_var_2_prot;

	@Column(name = "ind_8_var_2_prot", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd8Var2Prot() {
		return this.ind_8_var_2_prot;
	}

	public void setInd8Var2Prot(String ind_8_var_2_prot) {
		this.ind_8_var_2_prot = ind_8_var_2_prot;
	}
	private String ind_8_var_2_zyg;

	@Column(name = "ind_8_var_2_zyg", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd8Var2Zyg() {
		return this.ind_8_var_2_zyg;
	}

	public void setInd8Var2Zyg(String ind_8_var_2_zyg) {
		this.ind_8_var_2_zyg = ind_8_var_2_zyg;
	}
	private String ind_8_var_3_cdna;

	@Column(name = "ind_8_var_3_cdna", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd8Var3Cdna() {
		return this.ind_8_var_3_cdna;
	}

	public void setInd8Var3Cdna(String ind_8_var_3_cdna) {
		this.ind_8_var_3_cdna = ind_8_var_3_cdna;
	}
	private String ind_8_var_3_gene;

	@Column(name = "ind_8_var_3_gene", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd8Var3Gene() {
		return this.ind_8_var_3_gene;
	}

	public void setInd8Var3Gene(String ind_8_var_3_gene) {
		this.ind_8_var_3_gene = ind_8_var_3_gene;
	}
	private String ind_8_var_3_prot;

	@Column(name = "ind_8_var_3_prot", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd8Var3Prot() {
		return this.ind_8_var_3_prot;
	}

	public void setInd8Var3Prot(String ind_8_var_3_prot) {
		this.ind_8_var_3_prot = ind_8_var_3_prot;
	}
	private String ind_8_var_3_zyg;

	@Column(name = "ind_8_var_3_zyg", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd8Var3Zyg() {
		return this.ind_8_var_3_zyg;
	}

	public void setInd8Var3Zyg(String ind_8_var_3_zyg) {
		this.ind_8_var_3_zyg = ind_8_var_3_zyg;
	}
	private String ind_9_aff_unaff;

	@Column(name = "ind_9_aff_unaff", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd9AffUnaff() {
		return this.ind_9_aff_unaff;
	}

	public void setInd9AffUnaff(String ind_9_aff_unaff) {
		this.ind_9_aff_unaff = ind_9_aff_unaff;
	}
	private String ind_9_id;

	@Column(name = "ind_9_id", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd9Id() {
		return this.ind_9_id;
	}

	public void setInd9Id(String ind_9_id) {
		this.ind_9_id = ind_9_id;
	}
	private String ind_9_var_1_cdna;

	@Column(name = "ind_9_var_1_cdna", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd9Var1Cdna() {
		return this.ind_9_var_1_cdna;
	}

	public void setInd9Var1Cdna(String ind_9_var_1_cdna) {
		this.ind_9_var_1_cdna = ind_9_var_1_cdna;
	}
	private String ind_9_var_1_gene;

	@Column(name = "ind_9_var_1_gene", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd9Var1Gene() {
		return this.ind_9_var_1_gene;
	}

	public void setInd9Var1Gene(String ind_9_var_1_gene) {
		this.ind_9_var_1_gene = ind_9_var_1_gene;
	}
	private String ind_9_var_1_prot;

	@Column(name = "ind_9_var_1_prot", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd9Var1Prot() {
		return this.ind_9_var_1_prot;
	}

	public void setInd9Var1Prot(String ind_9_var_1_prot) {
		this.ind_9_var_1_prot = ind_9_var_1_prot;
	}
	private String ind_9_var_1_zyg;

	@Column(name = "ind_9_var_1_zyg", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd9Var1Zyg() {
		return this.ind_9_var_1_zyg;
	}

	public void setInd9Var1Zyg(String ind_9_var_1_zyg) {
		this.ind_9_var_1_zyg = ind_9_var_1_zyg;
	}
	private String ind_9_var_2_cdna;

	@Column(name = "ind_9_var_2_cdna", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd9Var2Cdna() {
		return this.ind_9_var_2_cdna;
	}

	public void setInd9Var2Cdna(String ind_9_var_2_cdna) {
		this.ind_9_var_2_cdna = ind_9_var_2_cdna;
	}
	private String ind_9_var_2_gene;

	@Column(name = "ind_9_var_2_gene", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd9Var2Gene() {
		return this.ind_9_var_2_gene;
	}

	public void setInd9Var2Gene(String ind_9_var_2_gene) {
		this.ind_9_var_2_gene = ind_9_var_2_gene;
	}
	private String ind_9_var_2_prot;

	@Column(name = "ind_9_var_2_prot", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd9Var2Prot() {
		return this.ind_9_var_2_prot;
	}

	public void setInd9Var2Prot(String ind_9_var_2_prot) {
		this.ind_9_var_2_prot = ind_9_var_2_prot;
	}
	private String ind_9_var_2_zyg;

	@Column(name = "ind_9_var_2_zyg", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd9Var2Zyg() {
		return this.ind_9_var_2_zyg;
	}

	public void setInd9Var2Zyg(String ind_9_var_2_zyg) {
		this.ind_9_var_2_zyg = ind_9_var_2_zyg;
	}
	private String ind_9_var_3_cdna;

	@Column(name = "ind_9_var_3_cdna", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd9Var3Cdna() {
		return this.ind_9_var_3_cdna;
	}

	public void setInd9Var3Cdna(String ind_9_var_3_cdna) {
		this.ind_9_var_3_cdna = ind_9_var_3_cdna;
	}
	private String ind_9_var_3_gene;

	@Column(name = "ind_9_var_3_gene", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd9Var3Gene() {
		return this.ind_9_var_3_gene;
	}

	public void setInd9Var3Gene(String ind_9_var_3_gene) {
		this.ind_9_var_3_gene = ind_9_var_3_gene;
	}
	private String ind_9_var_3_prot;

	@Column(name = "ind_9_var_3_prot", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd9Var3Prot() {
		return this.ind_9_var_3_prot;
	}

	public void setInd9Var3Prot(String ind_9_var_3_prot) {
		this.ind_9_var_3_prot = ind_9_var_3_prot;
	}
	private String ind_9_var_3_zyg;

	@Column(name = "ind_9_var_3_zyg", nullable = true, columnDefinition = "varchar", length = 128)
	public String getInd9Var3Zyg() {
		return this.ind_9_var_3_zyg;
	}

	public void setInd9Var3Zyg(String ind_9_var_3_zyg) {
		this.ind_9_var_3_zyg = ind_9_var_3_zyg;
	}
}
