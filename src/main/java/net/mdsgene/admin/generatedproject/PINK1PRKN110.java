package net.mdsgene.admin.generatedproject;
import java.util.Date;
import javax.persistence.*;
@Entity
@Table(name = "PINK1PRKN110", schema = "public")
@Cacheable(false)
public class PINK1PRKN110 implements java.io.Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PINK1PRKN110_id_seq")
    @SequenceGenerator(name="PINK1PRKN110_id_seq", sequenceName="PINK1PRKN110_id_seq", allocationSize=1)
	@Column(name = "id", unique = true, nullable = false, columnDefinition = "serial")
	private int id;

	public PINK1PRKN110() {
	}
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

	private String fhd_1;

	@Column(name = "fhd_1", nullable = true, columnDefinition = "varchar", length = 128)
	public String getFhd_1() {
		return this.fhd_1;
	}

	public void setFhd_1(String fhd_1) {
		this.fhd_1 = fhd_1;
	}
	private String fhd_broth_fm;

	@Column(name = "fhd_broth_fm", nullable = true, columnDefinition = "varchar", length = 128)
	public String getFhd_broth_fm() {
		return this.fhd_broth_fm;
	}

	public void setFhd_broth_fm(String fhd_broth_fm) {
		this.fhd_broth_fm = fhd_broth_fm;
	}
	private String fhd_broth_pd;

	@Column(name = "fhd_broth_pd", nullable = true, columnDefinition = "varchar", length = 128)
	public String getFhd_broth_pd() {
		return this.fhd_broth_pd;
	}

	public void setFhd_broth_pd(String fhd_broth_pd) {
		this.fhd_broth_pd = fhd_broth_pd;
	}
	private String fhd_fath_headline;

	@Column(name = "fhd_fath_headline", nullable = true, columnDefinition = "varchar", length = 128)
	public String getFhd_fath_headline() {
		return this.fhd_fath_headline;
	}

	public void setFhd_fath_headline(String fhd_fath_headline) {
		this.fhd_fath_headline = fhd_fath_headline;
	}
	private String fhd_kids_fm;

	@Column(name = "fhd_kids_fm", nullable = true, columnDefinition = "varchar", length = 128)
	public String getFhd_kids_fm() {
		return this.fhd_kids_fm;
	}

	public void setFhd_kids_fm(String fhd_kids_fm) {
		this.fhd_kids_fm = fhd_kids_fm;
	}
	private String fhd_kids_fm_pd;

	@Column(name = "fhd_kids_fm_pd", nullable = true, columnDefinition = "varchar", length = 128)
	public String getFhd_kids_fm_pd() {
		return this.fhd_kids_fm_pd;
	}

	public void setFhd_kids_fm_pd(String fhd_kids_fm_pd) {
		this.fhd_kids_fm_pd = fhd_kids_fm_pd;
	}
	private String fhd_mau_fm;

	@Column(name = "fhd_mau_fm", nullable = true, columnDefinition = "varchar", length = 128)
	public String getFhd_mau_fm() {
		return this.fhd_mau_fm;
	}

	public void setFhd_mau_fm(String fhd_mau_fm) {
		this.fhd_mau_fm = fhd_mau_fm;
	}
	private String fhd_mau_fm_pd;

	@Column(name = "fhd_mau_fm_pd", nullable = true, columnDefinition = "varchar", length = 128)
	public String getFhd_mau_fm_pd() {
		return this.fhd_mau_fm_pd;
	}

	public void setFhd_mau_fm_pd(String fhd_mau_fm_pd) {
		this.fhd_mau_fm_pd = fhd_mau_fm_pd;
	}
	private String fhd_mcou_fm;

	@Column(name = "fhd_mcou_fm", nullable = true, columnDefinition = "varchar", length = 128)
	public String getFhd_mcou_fm() {
		return this.fhd_mcou_fm;
	}

	public void setFhd_mcou_fm(String fhd_mcou_fm) {
		this.fhd_mcou_fm = fhd_mcou_fm;
	}
	private String fhd_mcou_fm_pd;

	@Column(name = "fhd_mcou_fm_pd", nullable = true, columnDefinition = "varchar", length = 128)
	public String getFhd_mcou_fm_pd() {
		return this.fhd_mcou_fm_pd;
	}

	public void setFhd_mcou_fm_pd(String fhd_mcou_fm_pd) {
		this.fhd_mcou_fm_pd = fhd_mcou_fm_pd;
	}
	private String fhd_mgrf_headline;

	@Column(name = "fhd_mgrf_headline", nullable = true, columnDefinition = "varchar", length = 128)
	public String getFhd_mgrf_headline() {
		return this.fhd_mgrf_headline;
	}

	public void setFhd_mgrf_headline(String fhd_mgrf_headline) {
		this.fhd_mgrf_headline = fhd_mgrf_headline;
	}
	private String fhd_mgrm_headlie;

	@Column(name = "fhd_mgrm_headlie", nullable = true, columnDefinition = "varchar", length = 128)
	public String getFhd_mgrm_headlie() {
		return this.fhd_mgrm_headlie;
	}

	public void setFhd_mgrm_headlie(String fhd_mgrm_headlie) {
		this.fhd_mgrm_headlie = fhd_mgrm_headlie;
	}
	private String fhd_mhsib_fm;

	@Column(name = "fhd_mhsib_fm", nullable = true, columnDefinition = "varchar", length = 128)
	public String getFhd_mhsib_fm() {
		return this.fhd_mhsib_fm;
	}

	public void setFhd_mhsib_fm(String fhd_mhsib_fm) {
		this.fhd_mhsib_fm = fhd_mhsib_fm;
	}
	private String fhd_mhsib_fm_pd;

	@Column(name = "fhd_mhsib_fm_pd", nullable = true, columnDefinition = "varchar", length = 128)
	public String getFhd_mhsib_fm_pd() {
		return this.fhd_mhsib_fm_pd;
	}

	public void setFhd_mhsib_fm_pd(String fhd_mhsib_fm_pd) {
		this.fhd_mhsib_fm_pd = fhd_mhsib_fm_pd;
	}
	private String fhd_moth_headline;

	@Column(name = "fhd_moth_headline", nullable = true, columnDefinition = "varchar", length = 128)
	public String getFhd_moth_headline() {
		return this.fhd_moth_headline;
	}

	public void setFhd_moth_headline(String fhd_moth_headline) {
		this.fhd_moth_headline = fhd_moth_headline;
	}
	private String fhd_other;

	@Column(name = "fhd_other", nullable = true, columnDefinition = "varchar", length = 128)
	public String getFhd_other() {
		return this.fhd_other;
	}

	public void setFhd_other(String fhd_other) {
		this.fhd_other = fhd_other;
	}
	private String fhd_other_who;

	@Column(name = "fhd_other_who", nullable = true, columnDefinition = "varchar", length = 128)
	public String getFhd_other_who() {
		return this.fhd_other_who;
	}

	public void setFhd_other_who(String fhd_other_who) {
		this.fhd_other_who = fhd_other_who;
	}
	private String fhd_pau_fm;

	@Column(name = "fhd_pau_fm", nullable = true, columnDefinition = "varchar", length = 128)
	public String getFhd_pau_fm() {
		return this.fhd_pau_fm;
	}

	public void setFhd_pau_fm(String fhd_pau_fm) {
		this.fhd_pau_fm = fhd_pau_fm;
	}
	private String fhd_pau_fm_pd;

	@Column(name = "fhd_pau_fm_pd", nullable = true, columnDefinition = "varchar", length = 128)
	public String getFhd_pau_fm_pd() {
		return this.fhd_pau_fm_pd;
	}

	public void setFhd_pau_fm_pd(String fhd_pau_fm_pd) {
		this.fhd_pau_fm_pd = fhd_pau_fm_pd;
	}
	private String fhd_pcou_fm;

	@Column(name = "fhd_pcou_fm", nullable = true, columnDefinition = "varchar", length = 128)
	public String getFhd_pcou_fm() {
		return this.fhd_pcou_fm;
	}

	public void setFhd_pcou_fm(String fhd_pcou_fm) {
		this.fhd_pcou_fm = fhd_pcou_fm;
	}
	private String fhd_pcou_fm_pd;

	@Column(name = "fhd_pcou_fm_pd", nullable = true, columnDefinition = "varchar", length = 128)
	public String getFhd_pcou_fm_pd() {
		return this.fhd_pcou_fm_pd;
	}

	public void setFhd_pcou_fm_pd(String fhd_pcou_fm_pd) {
		this.fhd_pcou_fm_pd = fhd_pcou_fm_pd;
	}
	private String fhd_pgrf_headline;

	@Column(name = "fhd_pgrf_headline", nullable = true, columnDefinition = "varchar", length = 128)
	public String getFhd_pgrf_headline() {
		return this.fhd_pgrf_headline;
	}

	public void setFhd_pgrf_headline(String fhd_pgrf_headline) {
		this.fhd_pgrf_headline = fhd_pgrf_headline;
	}
	private String fhd_pgrm_headline;

	@Column(name = "fhd_pgrm_headline", nullable = true, columnDefinition = "varchar", length = 128)
	public String getFhd_pgrm_headline() {
		return this.fhd_pgrm_headline;
	}

	public void setFhd_pgrm_headline(String fhd_pgrm_headline) {
		this.fhd_pgrm_headline = fhd_pgrm_headline;
	}
	private String fhd_phsib_fm;

	@Column(name = "fhd_phsib_fm", nullable = true, columnDefinition = "varchar", length = 128)
	public String getFhd_phsib_fm() {
		return this.fhd_phsib_fm;
	}

	public void setFhd_phsib_fm(String fhd_phsib_fm) {
		this.fhd_phsib_fm = fhd_phsib_fm;
	}
	private String fhd_phsib_fm_pd;

	@Column(name = "fhd_phsib_fm_pd", nullable = true, columnDefinition = "varchar", length = 128)
	public String getFhd_phsib_fm_pd() {
		return this.fhd_phsib_fm_pd;
	}

	public void setFhd_phsib_fm_pd(String fhd_phsib_fm_pd) {
		this.fhd_phsib_fm_pd = fhd_phsib_fm_pd;
	}
	private String fhd_sis_fm;

	@Column(name = "fhd_sis_fm", nullable = true, columnDefinition = "varchar", length = 128)
	public String getFhd_sis_fm() {
		return this.fhd_sis_fm;
	}

	public void setFhd_sis_fm(String fhd_sis_fm) {
		this.fhd_sis_fm = fhd_sis_fm;
	}
	private String fhd_sis_fm_pd;

	@Column(name = "fhd_sis_fm_pd", nullable = true, columnDefinition = "varchar", length = 128)
	public String getFhd_sis_fm_pd() {
		return this.fhd_sis_fm_pd;
	}

	public void setFhd_sis_fm_pd(String fhd_sis_fm_pd) {
		this.fhd_sis_fm_pd = fhd_sis_fm_pd;
	}

	public String getStatusColor() {
		boolean allCompleted = areAllFieldsCompleted();

		if (allCompleted) {
			return "green"; // Все поля заполнены
		} else if (isAtLeastOneFieldCompleted()) {
			return "orange"; // Некоторые поля заполнены
		} else {
			return "blue"; // Ни одно поле не заполнено
		}
	}

	private boolean areAllFieldsCompleted() {
		// Проверяем только основное поле
		boolean mainFieldsCompleted = !isEmpty(this.fhd_1);

		// Если fhd_1 равно "yes", проверяем дополнительные поля
		if ("1".equalsIgnoreCase(this.fhd_1)) {
			return mainFieldsCompleted && areConditionalFieldsCompleted();
		}

		return mainFieldsCompleted;
	}

	private boolean areConditionalFieldsCompleted() {
		// Проверяем, что все зависимые поля заполнены
		return !isEmpty(this.fhd_broth_fm) &&
				!isEmpty(this.fhd_broth_pd) &&
				!isEmpty(this.fhd_fath_headline) &&
				!isEmpty(this.fhd_kids_fm) &&
				!isEmpty(this.fhd_kids_fm_pd) &&
				!isEmpty(this.fhd_mau_fm) &&
				!isEmpty(this.fhd_mau_fm_pd) &&
				!isEmpty(this.fhd_mcou_fm) &&
				!isEmpty(this.fhd_mcou_fm_pd) &&
				!isEmpty(this.fhd_mgrf_headline) &&
				!isEmpty(this.fhd_mgrm_headlie) &&
				!isEmpty(this.fhd_mhsib_fm) &&
				!isEmpty(this.fhd_mhsib_fm_pd) &&
				!isEmpty(this.fhd_moth_headline) &&
				!isEmpty(this.fhd_other) &&
				!isEmpty(this.fhd_other_who) &&
				!isEmpty(this.fhd_pau_fm) &&
				!isEmpty(this.fhd_pau_fm_pd) &&
				!isEmpty(this.fhd_pcou_fm) &&
				!isEmpty(this.fhd_pcou_fm_pd) &&
				!isEmpty(this.fhd_pgrf_headline) &&
				!isEmpty(this.fhd_pgrm_headline) &&
				!isEmpty(this.fhd_phsib_fm) &&
				!isEmpty(this.fhd_phsib_fm_pd) &&
				!isEmpty(this.fhd_sis_fm) &&
				!isEmpty(this.fhd_sis_fm_pd);
	}

	private boolean isAtLeastOneFieldCompleted() {
		// Проверяем только основное поле
		boolean mainFieldsCompleted = !isEmpty(this.fhd_1);

		// Проверяем зависимые поля, если fhd_1 равно "yes"
		boolean conditionalFieldsCompleted = "1".equalsIgnoreCase(this.fhd_1) && isAnyConditionalFieldCompleted();

		return mainFieldsCompleted || conditionalFieldsCompleted;
	}

	private boolean isAnyConditionalFieldCompleted() {
		// Проверяем, заполнено ли хотя бы одно из зависимых полей
		return !isEmpty(this.fhd_broth_fm) ||
				!isEmpty(this.fhd_broth_pd) ||
				!isEmpty(this.fhd_fath_headline) ||
				!isEmpty(this.fhd_kids_fm) ||
				!isEmpty(this.fhd_kids_fm_pd) ||
				!isEmpty(this.fhd_mau_fm) ||
				!isEmpty(this.fhd_mau_fm_pd) ||
				!isEmpty(this.fhd_mcou_fm) ||
				!isEmpty(this.fhd_mcou_fm_pd) ||
				!isEmpty(this.fhd_mgrf_headline) ||
				!isEmpty(this.fhd_mgrm_headlie) ||
				!isEmpty(this.fhd_mhsib_fm) ||
				!isEmpty(this.fhd_mhsib_fm_pd) ||
				!isEmpty(this.fhd_moth_headline) ||
				!isEmpty(this.fhd_other) ||
				!isEmpty(this.fhd_other_who) ||
				!isEmpty(this.fhd_pau_fm) ||
				!isEmpty(this.fhd_pau_fm_pd) ||
				!isEmpty(this.fhd_pcou_fm) ||
				!isEmpty(this.fhd_pcou_fm_pd) ||
				!isEmpty(this.fhd_pgrf_headline) ||
				!isEmpty(this.fhd_pgrm_headline) ||
				!isEmpty(this.fhd_phsib_fm) ||
				!isEmpty(this.fhd_phsib_fm_pd) ||
				!isEmpty(this.fhd_sis_fm) ||
				!isEmpty(this.fhd_sis_fm_pd);
	}

	private boolean isEmpty(String value) {
		return value == null || value.trim().isEmpty() || value.trim().equals("-");
	}

}


