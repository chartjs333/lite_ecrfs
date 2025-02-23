package net.mdsgene.admin.generatedproject;
import java.util.Date;
import javax.persistence.*;
@Entity
@Table(name = "PINK1PRKN114", schema = "public")
@Cacheable(false)
public class PINK1PRKN114 implements java.io.Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PINK1PRKN114_id_seq")
    @SequenceGenerator(name="PINK1PRKN114_id_seq", sequenceName="PINK1PRKN114_id_seq", allocationSize=1)
	@Column(name = "id", unique = true, nullable = false, columnDefinition = "serial")
	private int id;

	public PINK1PRKN114() {
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

	private String vital_arm;

	@Column(name = "vital_arm", nullable = true, columnDefinition = "varchar", length = 128)
	public String getVital_arm() {
		return this.vital_arm;
	}

	public void setVital_arm(String vital_arm) {
		this.vital_arm = vital_arm;
	}
	private String vital_bp_sta_lower;

	@Column(name = "vital_bp_sta_lower", nullable = true, columnDefinition = "varchar", length = 128)
	public String getVital_bp_sta_lower() {
		return this.vital_bp_sta_lower;
	}

	public void setVital_bp_sta_lower(String vital_bp_sta_lower) {
		this.vital_bp_sta_lower = vital_bp_sta_lower;
	}
	private String vital_bp_sta_upper;

	@Column(name = "vital_bp_sta_upper", nullable = true, columnDefinition = "varchar", length = 128)
	public String getVital_bp_sta_upper() {
		return this.vital_bp_sta_upper;
	}

	public void setVital_bp_sta_upper(String vital_bp_sta_upper) {
		this.vital_bp_sta_upper = vital_bp_sta_upper;
	}
	private String vital_bp_sup_lower;

	@Column(name = "vital_bp_sup_lower", nullable = true, columnDefinition = "varchar", length = 128)
	public String getVital_bp_sup_lower() {
		return this.vital_bp_sup_lower;
	}

	public void setVital_bp_sup_lower(String vital_bp_sup_lower) {
		this.vital_bp_sup_lower = vital_bp_sup_lower;
	}
	private String vital_bp_sup_upper;

	@Column(name = "vital_bp_sup_upper", nullable = true, columnDefinition = "varchar", length = 128)
	public String getVital_bp_sup_upper() {
		return this.vital_bp_sup_upper;
	}

	public void setVital_bp_sup_upper(String vital_bp_sup_upper) {
		this.vital_bp_sup_upper = vital_bp_sup_upper;
	}
	private String vital_height;

	@Column(name = "vital_height", nullable = true, columnDefinition = "varchar", length = 128)
	public String getVital_height() {
		return this.vital_height;
	}

	public void setVital_height(String vital_height) {
		this.vital_height = vital_height;
	}
	private String vital_hr_sta;

	@Column(name = "vital_hr_sta", nullable = true, columnDefinition = "varchar", length = 128)
	public String getVital_hr_sta() {
		return this.vital_hr_sta;
	}

	public void setVital_hr_sta(String vital_hr_sta) {
		this.vital_hr_sta = vital_hr_sta;
	}
	private String vital_hr_sup;

	@Column(name = "vital_hr_sup", nullable = true, columnDefinition = "varchar", length = 128)
	public String getVital_hr_sup() {
		return this.vital_hr_sup;
	}

	public void setVital_hr_sup(String vital_hr_sup) {
		this.vital_hr_sup = vital_hr_sup;
	}
	private String vital_temp;

	@Column(name = "vital_temp", nullable = true, columnDefinition = "varchar", length = 128)
	public String getVital_temp() {
		return this.vital_temp;
	}

	public void setVital_temp(String vital_temp) {
		this.vital_temp = vital_temp;
	}
	private String vital_weight;

	@Column(name = "vital_weight", nullable = true, columnDefinition = "varchar", length = 128)
	public String getVital_weight() {
		return this.vital_weight;
	}

	public void setVital_weight(String vital_weight) {
		this.vital_weight = vital_weight;
	}

	public String getStatusColor() {
		// Проверяем, заполнены ли все поля
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
		// Проверяем, заполнены ли все поля
		return !isEmpty(this.surveyTwoId) &&
				!isEmpty(this.fillingStatus) &&
				!isEmpty(this.vital_arm) &&
				!isEmpty(this.vital_bp_sta_lower) &&
				!isEmpty(this.vital_bp_sta_upper) &&
				!isEmpty(this.vital_bp_sup_lower) &&
				!isEmpty(this.vital_bp_sup_upper) &&
				!isEmpty(this.vital_height) &&
				!isEmpty(this.vital_hr_sta) &&
				!isEmpty(this.vital_hr_sup) &&
				!isEmpty(this.vital_temp) &&
				!isEmpty(this.vital_weight);
	}

	private boolean isAtLeastOneFieldCompleted() {
		// Проверяем, заполнено ли хотя бы одно поле
		return !isEmpty(this.surveyTwoId) ||
				!isEmpty(this.fillingStatus) ||
				!isEmpty(this.vital_arm) ||
				!isEmpty(this.vital_bp_sta_lower) ||
				!isEmpty(this.vital_bp_sta_upper) ||
				!isEmpty(this.vital_bp_sup_lower) ||
				!isEmpty(this.vital_bp_sup_upper) ||
				!isEmpty(this.vital_height) ||
				!isEmpty(this.vital_hr_sta) ||
				!isEmpty(this.vital_hr_sup) ||
				!isEmpty(this.vital_temp) ||
				!isEmpty(this.vital_weight);
	}

	private boolean isEmpty(String value) {
		// Проверяем, является ли строка пустой или null
		return value == null || value.trim().isEmpty();
	}
}

//green if all items completed, orange if some but not all, blue if none are completed


