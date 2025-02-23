package net.mdsgene.admin.generatedproject;
import java.util.Date;
import javax.persistence.*;
@Entity
@Table(name = "PINK1PRKN113", schema = "public")
@Cacheable(false)
public class PINK1PRKN113 implements java.io.Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PINK1PRKN113_id_seq")
    @SequenceGenerator(name="PINK1PRKN113_id_seq", sequenceName="PINK1PRKN113_id_seq", allocationSize=1)
	@Column(name = "id", unique = true, nullable = false, columnDefinition = "serial")
	private int id;

	public PINK1PRKN113() {
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

	private String exam_abd;

	@Column(name = "exam_abd", nullable = true, columnDefinition = "varchar", length = 128)
	public String getExam_abd() {
		return this.exam_abd;
	}

	public void setExam_abd(String exam_abd) {
		this.exam_abd = exam_abd;
	}
	private String exam_abd_abn;

	@Column(name = "exam_abd_abn", nullable = true, columnDefinition = "varchar", length = 128)
	public String getExam_abd_abn() {
		return this.exam_abd_abn;
	}

	public void setExam_abd_abn(String exam_abd_abn) {
		this.exam_abd_abn = exam_abd_abn;
	}
	private String exam_cardio;

	@Column(name = "exam_cardio", nullable = true, columnDefinition = "varchar", length = 128)
	public String getExam_cardio() {
		return this.exam_cardio;
	}

	public void setExam_cardio(String exam_cardio) {
		this.exam_cardio = exam_cardio;
	}
	private String exam_cardio_abn;

	@Column(name = "exam_cardio_abn", nullable = true, columnDefinition = "varchar", length = 128)
	public String getExam_cardio_abn() {
		return this.exam_cardio_abn;
	}

	public void setExam_cardio_abn(String exam_cardio_abn) {
		this.exam_cardio_abn = exam_cardio_abn;
	}
	private String exam_ears;

	@Column(name = "exam_ears", nullable = true, columnDefinition = "varchar", length = 128)
	public String getExam_ears() {
		return this.exam_ears;
	}

	public void setExam_ears(String exam_ears) {
		this.exam_ears = exam_ears;
	}
	private String exam_ears_abn;

	@Column(name = "exam_ears_abn", nullable = true, columnDefinition = "varchar", length = 128)
	public String getExam_ears_abn() {
		return this.exam_ears_abn;
	}

	public void setExam_ears_abn(String exam_ears_abn) {
		this.exam_ears_abn = exam_ears_abn;
	}
	private String exam_eyes;

	@Column(name = "exam_eyes", nullable = true, columnDefinition = "varchar", length = 128)
	public String getExam_eyes() {
		return this.exam_eyes;
	}

	public void setExam_eyes(String exam_eyes) {
		this.exam_eyes = exam_eyes;
	}
	private String exam_eyes_abn;

	@Column(name = "exam_eyes_abn", nullable = true, columnDefinition = "varchar", length = 128)
	public String getExam_eyes_abn() {
		return this.exam_eyes_abn;
	}

	public void setExam_eyes_abn(String exam_eyes_abn) {
		this.exam_eyes_abn = exam_eyes_abn;
	}
	private String exam_head;

	@Column(name = "exam_head", nullable = true, columnDefinition = "varchar", length = 128)
	public String getExam_head() {
		return this.exam_head;
	}

	public void setExam_head(String exam_head) {
		this.exam_head = exam_head;
	}
	private String exam_head_abn;

	@Column(name = "exam_head_abn", nullable = true, columnDefinition = "varchar", length = 128)
	public String getExam_head_abn() {
		return this.exam_head_abn;
	}

	public void setExam_head_abn(String exam_head_abn) {
		this.exam_head_abn = exam_head_abn;
	}
	private String exam_lungs;

	@Column(name = "exam_lungs", nullable = true, columnDefinition = "varchar", length = 128)
	public String getExam_lungs() {
		return this.exam_lungs;
	}

	public void setExam_lungs(String exam_lungs) {
		this.exam_lungs = exam_lungs;
	}
	private String exam_lungs_abn;

	@Column(name = "exam_lungs_abn", nullable = true, columnDefinition = "varchar", length = 128)
	public String getExam_lungs_abn() {
		return this.exam_lungs_abn;
	}

	public void setExam_lungs_abn(String exam_lungs_abn) {
		this.exam_lungs_abn = exam_lungs_abn;
	}
	private String exam_musc;

	@Column(name = "exam_musc", nullable = true, columnDefinition = "varchar", length = 128)
	public String getExam_musc() {
		return this.exam_musc;
	}

	public void setExam_musc(String exam_musc) {
		this.exam_musc = exam_musc;
	}
	private String exam_musc_abn;

	@Column(name = "exam_musc_abn", nullable = true, columnDefinition = "varchar", length = 128)
	public String getExam_musc_abn() {
		return this.exam_musc_abn;
	}

	public void setExam_musc_abn(String exam_musc_abn) {
		this.exam_musc_abn = exam_musc_abn;
	}
	private String exam_neuro;

	@Column(name = "exam_neuro", nullable = true, columnDefinition = "varchar", length = 128)
	public String getExam_neuro() {
		return this.exam_neuro;
	}

	public void setExam_neuro(String exam_neuro) {
		this.exam_neuro = exam_neuro;
	}
	private String exam_neuro_abn;

	@Column(name = "exam_neuro_abn", nullable = true, columnDefinition = "varchar", length = 128)
	public String getExam_neuro_abn() {
		return this.exam_neuro_abn;
	}

	public void setExam_neuro_abn(String exam_neuro_abn) {
		this.exam_neuro_abn = exam_neuro_abn;
	}
	private String exam_other_desc;

	@Column(name = "exam_other_desc", nullable = true, columnDefinition = "varchar", length = 128)
	public String getExam_other_desc() {
		return this.exam_other_desc;
	}

	public void setExam_other_desc(String exam_other_desc) {
		this.exam_other_desc = exam_other_desc;
	}
	private String exam_psych;

	@Column(name = "exam_psych", nullable = true, columnDefinition = "varchar", length = 128)
	public String getExam_psych() {
		return this.exam_psych;
	}

	public void setExam_psych(String exam_psych) {
		this.exam_psych = exam_psych;
	}
	private String exam_psych_abn;

	@Column(name = "exam_psych_abn", nullable = true, columnDefinition = "varchar", length = 128)
	public String getExam_psych_abn() {
		return this.exam_psych_abn;
	}

	public void setExam_psych_abn(String exam_psych_abn) {
		this.exam_psych_abn = exam_psych_abn;
	}
	private String exam_skin;

	@Column(name = "exam_skin", nullable = true, columnDefinition = "varchar", length = 128)
	public String getExam_skin() {
		return this.exam_skin;
	}

	public void setExam_skin(String exam_skin) {
		this.exam_skin = exam_skin;
	}
	private String exam_skin_abn;

	@Column(name = "exam_skin_abn", nullable = true, columnDefinition = "varchar", length = 128)
	public String getExam_skin_abn() {
		return this.exam_skin_abn;
	}

	public void setExam_skin_abn(String exam_skin_abn) {
		this.exam_skin_abn = exam_skin_abn;
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
				!isEmpty(this.exam_abd) &&
				!isEmpty(this.exam_cardio) &&
				!isEmpty(this.exam_ears) &&
				!isEmpty(this.exam_eyes) &&
				!isEmpty(this.exam_head) &&
				!isEmpty(this.exam_lungs) &&
				!isEmpty(this.exam_musc) &&
				!isEmpty(this.exam_neuro) &&
				!isEmpty(this.exam_psych) &&
				!isEmpty(this.exam_skin);

		// Проверяем дополнительные поля, если соответствующие основные поля равны "abnormal"
		boolean conditionalFieldsCompleted = true;

		if ("abnormal".equalsIgnoreCase(this.exam_abd)) {
			conditionalFieldsCompleted &= !isEmpty(this.exam_abd_abn);
		}
		if ("abnormal".equalsIgnoreCase(this.exam_cardio)) {
			conditionalFieldsCompleted &= !isEmpty(this.exam_cardio_abn);
		}
		if ("abnormal".equalsIgnoreCase(this.exam_ears)) {
			conditionalFieldsCompleted &= !isEmpty(this.exam_ears_abn);
		}
		if ("abnormal".equalsIgnoreCase(this.exam_eyes)) {
			conditionalFieldsCompleted &= !isEmpty(this.exam_eyes_abn);
		}
		if ("abnormal".equalsIgnoreCase(this.exam_head)) {
			conditionalFieldsCompleted &= !isEmpty(this.exam_head_abn);
		}
		if ("abnormal".equalsIgnoreCase(this.exam_lungs)) {
			conditionalFieldsCompleted &= !isEmpty(this.exam_lungs_abn);
		}
		if ("abnormal".equalsIgnoreCase(this.exam_musc)) {
			conditionalFieldsCompleted &= !isEmpty(this.exam_musc_abn);
		}
		if ("abnormal".equalsIgnoreCase(this.exam_neuro)) {
			conditionalFieldsCompleted &= !isEmpty(this.exam_neuro_abn);
		}
		if ("abnormal".equalsIgnoreCase(this.exam_psych)) {
			conditionalFieldsCompleted &= !isEmpty(this.exam_psych_abn);
		}
		if ("abnormal".equalsIgnoreCase(this.exam_skin)) {
			conditionalFieldsCompleted &= !isEmpty(this.exam_skin_abn);
		}

		return mainFieldsCompleted && conditionalFieldsCompleted;
}

	private boolean isAtLeastOneFieldCompleted() {
		// Проверяем, заполнено ли хотя бы одно из основных полей
		boolean mainFieldsCompleted = !isEmpty(this.surveyTwoId) ||
				!isEmpty(this.fillingStatus) ||
				!isEmpty(this.exam_abd) ||
				!isEmpty(this.exam_cardio) ||
				!isEmpty(this.exam_ears) ||
				!isEmpty(this.exam_eyes) ||
				!isEmpty(this.exam_head) ||
				!isEmpty(this.exam_lungs) ||
				!isEmpty(this.exam_musc) ||
				!isEmpty(this.exam_neuro) ||
				!isEmpty(this.exam_psych) ||
				!isEmpty(this.exam_skin);

		// Проверяем, заполнено ли хотя бы одно из дополнительных полей, если соответствующие основные поля равны "abnormal"
		boolean conditionalFieldsCompleted = false;

		if ("abnormal".equalsIgnoreCase(this.exam_abd)) {
			conditionalFieldsCompleted |= !isEmpty(this.exam_abd_abn);
		}
		if ("abnormal".equalsIgnoreCase(this.exam_cardio)) {
			conditionalFieldsCompleted |= !isEmpty(this.exam_cardio_abn);
		}
		if ("abnormal".equalsIgnoreCase(this.exam_ears)) {
			conditionalFieldsCompleted |= !isEmpty(this.exam_ears_abn);
		}
		if ("abnormal".equalsIgnoreCase(this.exam_eyes)) {
			conditionalFieldsCompleted |= !isEmpty(this.exam_eyes_abn);
		}
		if ("abnormal".equalsIgnoreCase(this.exam_head)) {
			conditionalFieldsCompleted |= !isEmpty(this.exam_head_abn);
		}
		if ("abnormal".equalsIgnoreCase(this.exam_lungs)) {
			conditionalFieldsCompleted |= !isEmpty(this.exam_lungs_abn);
		}
		if ("abnormal".equalsIgnoreCase(this.exam_musc)) {
			conditionalFieldsCompleted |= !isEmpty(this.exam_musc_abn);
		}
		if ("abnormal".equalsIgnoreCase(this.exam_neuro)) {
			conditionalFieldsCompleted |= !isEmpty(this.exam_neuro_abn);
		}
		if ("abnormal".equalsIgnoreCase(this.exam_psych)) {
			conditionalFieldsCompleted |= !isEmpty(this.exam_psych_abn);
		}
		if ("abnormal".equalsIgnoreCase(this.exam_skin)) {
			conditionalFieldsCompleted |= !isEmpty(this.exam_skin_abn);
		}

		return mainFieldsCompleted || conditionalFieldsCompleted;
	}

	private boolean isEmpty(String value) {
		// Проверяем, является ли строка пустой или null
		return value == null || value.trim().isEmpty();
	}
}

//green if all single select items are completed, orange if some but not all, blue if none selected
