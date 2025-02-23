package net.mdsgene.admin.generatedproject;
import java.util.Date;
import javax.persistence.*;
@Entity
@Table(name = "PINK1PRKN19", schema = "public")
@Cacheable(false)
public class PINK1PRKN19 implements java.io.Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PINK1PRKN19_id_seq")
    @SequenceGenerator(name="PINK1PRKN19_id_seq", sequenceName="PINK1PRKN19_id_seq", allocationSize=1)
	@Column(name = "id", unique = true, nullable = false, columnDefinition = "serial")
	private int id;

	public PINK1PRKN19() {
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

	private String fam_hist;

	@Column(name = "fam_hist", nullable = true, columnDefinition = "varchar", length = 128)
	public String getFam_hist() {
		return this.fam_hist;
	}

	public void setFam_hist(String fam_hist) {
		this.fam_hist = fam_hist;
	}
	private String fh_broth_fm;

	@Column(name = "fh_broth_fm", nullable = true, columnDefinition = "varchar", length = 128)
	public String getFh_broth_fm() {
		return this.fh_broth_fm;
	}

	public void setFh_broth_fm(String fh_broth_fm) {
		this.fh_broth_fm = fh_broth_fm;
	}
	private String fh_broth_pd;

	@Column(name = "fh_broth_pd", nullable = true, columnDefinition = "varchar", length = 128)
	public String getFh_broth_pd() {
		return this.fh_broth_pd;
	}

	public void setFh_broth_pd(String fh_broth_pd) {
		this.fh_broth_pd = fh_broth_pd;
	}
	private String fh_fath;

	@Column(name = "fh_fath", nullable = true, columnDefinition = "varchar", length = 128)
	public String getFh_fath() {
		return this.fh_fath;
	}

	public void setFh_fath(String fh_fath) {
		this.fh_fath = fh_fath;
	}
	private String fh_kids_fm;

	@Column(name = "fh_kids_fm", nullable = true, columnDefinition = "varchar", length = 128)
	public String getFh_kids_fm() {
		return this.fh_kids_fm;
	}

	public void setFh_kids_fm(String fh_kids_fm) {
		this.fh_kids_fm = fh_kids_fm;
	}
	private String fh_kids_pd;

	@Column(name = "fh_kids_pd", nullable = true, columnDefinition = "varchar", length = 128)
	public String getFh_kids_pd() {
		return this.fh_kids_pd;
	}

	public void setFh_kids_pd(String fh_kids_pd) {
		this.fh_kids_pd = fh_kids_pd;
	}
	private String fh_mau_fm;

	@Column(name = "fh_mau_fm", nullable = true, columnDefinition = "varchar", length = 128)
	public String getFh_mau_fm() {
		return this.fh_mau_fm;
	}

	public void setFh_mau_fm(String fh_mau_fm) {
		this.fh_mau_fm = fh_mau_fm;
	}
	private String fh_mau_pd;

	@Column(name = "fh_mau_pd", nullable = true, columnDefinition = "varchar", length = 128)
	public String getFh_mau_pd() {
		return this.fh_mau_pd;
	}

	public void setFh_mau_pd(String fh_mau_pd) {
		this.fh_mau_pd = fh_mau_pd;
	}
	private String fh_mcou_fm;

	@Column(name = "fh_mcou_fm", nullable = true, columnDefinition = "varchar", length = 128)
	public String getFh_mcou_fm() {
		return this.fh_mcou_fm;
	}

	public void setFh_mcou_fm(String fh_mcou_fm) {
		this.fh_mcou_fm = fh_mcou_fm;
	}
	private String fh_mcou_pd;

	@Column(name = "fh_mcou_pd", nullable = true, columnDefinition = "varchar", length = 128)
	public String getFh_mcou_pd() {
		return this.fh_mcou_pd;
	}

	public void setFh_mcou_pd(String fh_mcou_pd) {
		this.fh_mcou_pd = fh_mcou_pd;
	}
	private String fh_mgrf;

	@Column(name = "fh_mgrf", nullable = true, columnDefinition = "varchar", length = 128)
	public String getFh_mgrf() {
		return this.fh_mgrf;
	}

	public void setFh_mgrf(String fh_mgrf) {
		this.fh_mgrf = fh_mgrf;
	}
	private String fh_mgrm;

	@Column(name = "fh_mgrm", nullable = true, columnDefinition = "varchar", length = 128)
	public String getFh_mgrm() {
		return this.fh_mgrm;
	}

	public void setFh_mgrm(String fh_mgrm) {
		this.fh_mgrm = fh_mgrm;
	}
	private String fh_mhsib_fm;

	@Column(name = "fh_mhsib_fm", nullable = true, columnDefinition = "varchar", length = 128)
	public String getFh_mhsib_fm() {
		return this.fh_mhsib_fm;
	}

	public void setFh_mhsib_fm(String fh_mhsib_fm) {
		this.fh_mhsib_fm = fh_mhsib_fm;
	}
	private String fh_mhsib_pd;

	@Column(name = "fh_mhsib_pd", nullable = true, columnDefinition = "varchar", length = 128)
	public String getFh_mhsib_pd() {
		return this.fh_mhsib_pd;
	}

	public void setFh_mhsib_pd(String fh_mhsib_pd) {
		this.fh_mhsib_pd = fh_mhsib_pd;
	}
	private String fh_moth;

	@Column(name = "fh_moth", nullable = true, columnDefinition = "varchar", length = 128)
	public String getFh_moth() {
		return this.fh_moth;
	}

	public void setFh_moth(String fh_moth) {
		this.fh_moth = fh_moth;
	}
	private String fh_other;

	@Column(name = "fh_other", nullable = true, columnDefinition = "varchar", length = 128)
	public String getFh_other() {
		return this.fh_other;
	}

	public void setFh_other(String fh_other) {
		this.fh_other = fh_other;
	}
	private String fh_other_who;

	@Column(name = "fh_other_who", nullable = true, columnDefinition = "varchar", length = 128)
	public String getFh_other_who() {
		return this.fh_other_who;
	}

	public void setFh_other_who(String fh_other_who) {
		this.fh_other_who = fh_other_who;
	}
	private String fh_pau_fm;

	@Column(name = "fh_pau_fm", nullable = true, columnDefinition = "varchar", length = 128)
	public String getFh_pau_fm() {
		return this.fh_pau_fm;
	}

	public void setFh_pau_fm(String fh_pau_fm) {
		this.fh_pau_fm = fh_pau_fm;
	}
	private String fh_pau_pd;

	@Column(name = "fh_pau_pd", nullable = true, columnDefinition = "varchar", length = 128)
	public String getFh_pau_pd() {
		return this.fh_pau_pd;
	}

	public void setFh_pau_pd(String fh_pau_pd) {
		this.fh_pau_pd = fh_pau_pd;
	}
	private String fh_pcou_fm;

	@Column(name = "fh_pcou_fm", nullable = true, columnDefinition = "varchar", length = 128)
	public String getFh_pcou_fm() {
		return this.fh_pcou_fm;
	}

	public void setFh_pcou_fm(String fh_pcou_fm) {
		this.fh_pcou_fm = fh_pcou_fm;
	}
	private String fh_pcou_pd;

	@Column(name = "fh_pcou_pd", nullable = true, columnDefinition = "varchar", length = 128)
	public String getFh_pcou_pd() {
		return this.fh_pcou_pd;
	}

	public void setFh_pcou_pd(String fh_pcou_pd) {
		this.fh_pcou_pd = fh_pcou_pd;
	}
	private String fh_pgrf;

	@Column(name = "fh_pgrf", nullable = true, columnDefinition = "varchar", length = 128)
	public String getFh_pgrf() {
		return this.fh_pgrf;
	}

	public void setFh_pgrf(String fh_pgrf) {
		this.fh_pgrf = fh_pgrf;
	}
	private String fh_pgrm;

	@Column(name = "fh_pgrm", nullable = true, columnDefinition = "varchar", length = 128)
	public String getFh_pgrm() {
		return this.fh_pgrm;
	}

	public void setFh_pgrm(String fh_pgrm) {
		this.fh_pgrm = fh_pgrm;
	}
	private String fh_phsib_fm;

	@Column(name = "fh_phsib_fm", nullable = true, columnDefinition = "varchar", length = 128)
	public String getFh_phsib_fm() {
		return this.fh_phsib_fm;
	}

	public void setFh_phsib_fm(String fh_phsib_fm) {
		this.fh_phsib_fm = fh_phsib_fm;
	}
	private String fh_phsib_pd;

	@Column(name = "fh_phsib_pd", nullable = true, columnDefinition = "varchar", length = 128)
	public String getFh_phsib_pd() {
		return this.fh_phsib_pd;
	}

	public void setFh_phsib_pd(String fh_phsib_pd) {
		this.fh_phsib_pd = fh_phsib_pd;
	}
	private String fh_sis_fm;

	@Column(name = "fh_sis_fm", nullable = true, columnDefinition = "varchar", length = 128)
	public String getFh_sis_fm() {
		return this.fh_sis_fm;
	}

	public void setFh_sis_fm(String fh_sis_fm) {
		this.fh_sis_fm = fh_sis_fm;
	}
	private String fh_sis_pd;

	@Column(name = "fh_sis_pd", nullable = true, columnDefinition = "varchar", length = 128)
	public String getFh_sis_pd() {
		return this.fh_sis_pd;
	}

	public void setFh_sis_pd(String fh_sis_pd) {
		this.fh_sis_pd = fh_sis_pd;
	}

	public String getStatusColor() {
		// Проверяем, заполнены ли все обязательные поля
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
		// Основные поля, которые всегда проверяются
		boolean mainFieldsCompleted = !isEmpty(this.surveyTwoId) &&
				!isEmpty(this.fillingStatus) &&
				!isEmpty(this.fam_hist);

		// Если fam_hist равно "yes", проверяем дополнительные поля
		if ("yes".equalsIgnoreCase(this.fam_hist)) {
			boolean conditionalFieldsCompleted = !isEmpty(this.fh_broth_fm) &&
					!isEmpty(this.fh_broth_pd) &&
					!isEmpty(this.fh_fath) &&
					!isEmpty(this.fh_kids_fm) &&
					!isEmpty(this.fh_kids_pd) &&
					!isEmpty(this.fh_mau_fm) &&
					!isEmpty(this.fh_mau_pd) &&
					!isEmpty(this.fh_mcou_fm) &&
					!isEmpty(this.fh_mcou_pd) &&
					!isEmpty(this.fh_mgrf) &&
					!isEmpty(this.fh_mgrm) &&
					!isEmpty(this.fh_mhsib_fm) &&
					!isEmpty(this.fh_mhsib_pd) &&
					!isEmpty(this.fh_moth) &&
					!isEmpty(this.fh_other) &&
					!isEmpty(this.fh_other_who) &&
					!isEmpty(this.fh_pau_fm) &&
					!isEmpty(this.fh_pau_pd) &&
					!isEmpty(this.fh_pcou_fm) &&
					!isEmpty(this.fh_pcou_pd) &&
					!isEmpty(this.fh_pgrf) &&
					!isEmpty(this.fh_pgrm) &&
					!isEmpty(this.fh_phsib_fm) &&
					!isEmpty(this.fh_phsib_pd) &&
					!isEmpty(this.fh_sis_fm) &&
					!isEmpty(this.fh_sis_pd);

			return mainFieldsCompleted && conditionalFieldsCompleted;
		}

		// Если fam_hist не равно "yes", проверяем только основные поля
		return mainFieldsCompleted;
	}

	private boolean isAtLeastOneFieldCompleted() {
		// Проверяем, заполнено ли хотя бы одно из основных полей
		boolean mainFieldsCompleted = !isEmpty(this.surveyTwoId) ||
				!isEmpty(this.fillingStatus) ||
				!isEmpty(this.fam_hist);

		// Если fam_hist равно "yes", проверяем также дополнительные поля
		if ("yes".equalsIgnoreCase(this.fam_hist)) {
			boolean conditionalFieldsCompleted = !isEmpty(this.fh_broth_fm) ||
					!isEmpty(this.fh_broth_pd) ||
					!isEmpty(this.fh_fath) ||
					!isEmpty(this.fh_kids_fm) ||
					!isEmpty(this.fh_kids_pd) ||
					!isEmpty(this.fh_mau_fm) ||
					!isEmpty(this.fh_mau_pd) ||
					!isEmpty(this.fh_mcou_fm) ||
					!isEmpty(this.fh_mcou_pd) ||
					!isEmpty(this.fh_mgrf) ||
					!isEmpty(this.fh_mgrm) ||
					!isEmpty(this.fh_mhsib_fm) ||
					!isEmpty(this.fh_mhsib_pd) ||
					!isEmpty(this.fh_moth) ||
					!isEmpty(this.fh_other) ||
					!isEmpty(this.fh_other_who) ||
					!isEmpty(this.fh_pau_fm) ||
					!isEmpty(this.fh_pau_pd) ||
					!isEmpty(this.fh_pcou_fm) ||
					!isEmpty(this.fh_pcou_pd) ||
					!isEmpty(this.fh_pgrf) ||
					!isEmpty(this.fh_pgrm) ||
					!isEmpty(this.fh_phsib_fm) ||
					!isEmpty(this.fh_phsib_pd) ||
					!isEmpty(this.fh_sis_fm) ||
					!isEmpty(this.fh_sis_pd);

			return mainFieldsCompleted || conditionalFieldsCompleted;
		}

		// Если fam_hist не равно "yes", проверяем только основные поля
		return mainFieldsCompleted;
	}

	private boolean isEmpty(String value) {
		// Проверяем, является ли строка пустой или null
		return value == null || value.trim().isEmpty();
	}
}


