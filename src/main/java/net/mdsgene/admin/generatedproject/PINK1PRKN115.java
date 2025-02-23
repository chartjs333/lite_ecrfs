package net.mdsgene.admin.generatedproject;
import java.util.Date;
import javax.persistence.*;
@Entity
@Table(name = "PINK1PRKN115", schema = "public")
@Cacheable(false)
public class PINK1PRKN115 implements java.io.Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PINK1PRKN115_id_seq")
    @SequenceGenerator(name="PINK1PRKN115_id_seq", sequenceName="PINK1PRKN115_id_seq", allocationSize=1)
	@Column(name = "id", unique = true, nullable = false, columnDefinition = "serial")
	private int id;

	public PINK1PRKN115() {
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

	private String n_exam_coor;

	@Column(name = "n_exam_coor", nullable = true, columnDefinition = "varchar", length = 128)
	public String getN_exam_coor() {
		return this.n_exam_coor;
	}

	public void setN_exam_coor(String n_exam_coor) {
		this.n_exam_coor = n_exam_coor;
	}
	private String n_exam_coor_abn;

	@Column(name = "n_exam_coor_abn", nullable = true, columnDefinition = "varchar", length = 128)
	public String getN_exam_coor_abn() {
		return this.n_exam_coor_abn;
	}

	public void setN_exam_coor_abn(String n_exam_coor_abn) {
		this.n_exam_coor_abn = n_exam_coor_abn;
	}
	private String n_exam_cranial;

	@Column(name = "n_exam_cranial", nullable = true, columnDefinition = "varchar", length = 128)
	public String getN_exam_cranial() {
		return this.n_exam_cranial;
	}

	public void setN_exam_cranial(String n_exam_cranial) {
		this.n_exam_cranial = n_exam_cranial;
	}
	private String n_exam_cranial_abn;

	@Column(name = "n_exam_cranial_abn", nullable = true, columnDefinition = "varchar", length = 128)
	public String getN_exam_cranial_abn() {
		return this.n_exam_cranial_abn;
	}

	public void setN_exam_cranial_abn(String n_exam_cranial_abn) {
		this.n_exam_cranial_abn = n_exam_cranial_abn;
	}
	private String n_exam_gait;

	@Column(name = "n_exam_gait", nullable = true, columnDefinition = "varchar", length = 128)
	public String getN_exam_gait() {
		return this.n_exam_gait;
	}

	public void setN_exam_gait(String n_exam_gait) {
		this.n_exam_gait = n_exam_gait;
	}
	private String n_exam_gait_abn;

	@Column(name = "n_exam_gait_abn", nullable = true, columnDefinition = "varchar", length = 128)
	public String getN_exam_gait_abn() {
		return this.n_exam_gait_abn;
	}

	public void setN_exam_gait_abn(String n_exam_gait_abn) {
		this.n_exam_gait_abn = n_exam_gait_abn;
	}
	private String n_exam_mental;

	@Column(name = "n_exam_mental", nullable = true, columnDefinition = "varchar", length = 128)
	public String getN_exam_mental() {
		return this.n_exam_mental;
	}

	public void setN_exam_mental(String n_exam_mental) {
		this.n_exam_mental = n_exam_mental;
	}
	private String n_exam_mental_abn;

	@Column(name = "n_exam_mental_abn", nullable = true, columnDefinition = "varchar", length = 128)
	public String getN_exam_mental_abn() {
		return this.n_exam_mental_abn;
	}

	public void setN_exam_mental_abn(String n_exam_mental_abn) {
		this.n_exam_mental_abn = n_exam_mental_abn;
	}
	private String n_exam_motor;

	@Column(name = "n_exam_motor", nullable = true, columnDefinition = "varchar", length = 128)
	public String getN_exam_motor() {
		return this.n_exam_motor;
	}

	public void setN_exam_motor(String n_exam_motor) {
		this.n_exam_motor = n_exam_motor;
	}
	private String n_exam_motor_abn;

	@Column(name = "n_exam_motor_abn", nullable = true, columnDefinition = "varchar", length = 128)
	public String getN_exam_motor_abn() {
		return this.n_exam_motor_abn;
	}

	public void setN_exam_motor_abn(String n_exam_motor_abn) {
		this.n_exam_motor_abn = n_exam_motor_abn;
	}
	private String n_exam_reflex;

	@Column(name = "n_exam_reflex", nullable = true, columnDefinition = "varchar", length = 128)
	public String getN_exam_reflex() {
		return this.n_exam_reflex;
	}

	public void setN_exam_reflex(String n_exam_reflex) {
		this.n_exam_reflex = n_exam_reflex;
	}
	private String n_exam_reflex_abn;

	@Column(name = "n_exam_reflex_abn", nullable = true, columnDefinition = "varchar", length = 128)
	public String getN_exam_reflex_abn() {
		return this.n_exam_reflex_abn;
	}

	public void setN_exam_reflex_abn(String n_exam_reflex_abn) {
		this.n_exam_reflex_abn = n_exam_reflex_abn;
	}
	private String n_exam_sens;

	@Column(name = "n_exam_sens", nullable = true, columnDefinition = "varchar", length = 128)
	public String getN_exam_sens() {
		return this.n_exam_sens;
	}

	public void setN_exam_sens(String n_exam_sens) {
		this.n_exam_sens = n_exam_sens;
	}
	private String n_exam_sens_abn;

	@Column(name = "n_exam_sens_abn", nullable = true, columnDefinition = "varchar", length = 128)
	public String getN_exam_sens_abn() {
		return this.n_exam_sens_abn;
	}

	public void setN_exam_sens_abn(String n_exam_sens_abn) {
		this.n_exam_sens_abn = n_exam_sens_abn;
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
				!isEmpty(this.n_exam_coor) &&
				!isEmpty(this.n_exam_cranial) &&
				!isEmpty(this.n_exam_gait) &&
				!isEmpty(this.n_exam_mental) &&
				!isEmpty(this.n_exam_motor) &&
				!isEmpty(this.n_exam_reflex) &&
				!isEmpty(this.n_exam_sens);

		// Проверяем дополнительные поля, если соответствующие основные поля равны "abnormal"
		boolean conditionalFieldsCompleted = true;

		if ("abnormal".equalsIgnoreCase(this.n_exam_coor)) {
			conditionalFieldsCompleted &= !isEmpty(this.n_exam_coor_abn);
		}
		if ("abnormal".equalsIgnoreCase(this.n_exam_cranial)) {
			conditionalFieldsCompleted &= !isEmpty(this.n_exam_cranial_abn);
		}
		if ("abnormal".equalsIgnoreCase(this.n_exam_gait)) {
			conditionalFieldsCompleted &= !isEmpty(this.n_exam_gait_abn);
		}
		if ("abnormal".equalsIgnoreCase(this.n_exam_mental)) {
			conditionalFieldsCompleted &= !isEmpty(this.n_exam_mental_abn);
		}
		if ("abnormal".equalsIgnoreCase(this.n_exam_motor)) {
			conditionalFieldsCompleted &= !isEmpty(this.n_exam_motor_abn);
}
		if ("abnormal".equalsIgnoreCase(this.n_exam_reflex)) {
			conditionalFieldsCompleted &= !isEmpty(this.n_exam_reflex_abn);
		}
		if ("abnormal".equalsIgnoreCase(this.n_exam_sens)) {
			conditionalFieldsCompleted &= !isEmpty(this.n_exam_sens_abn);
		}

		return mainFieldsCompleted && conditionalFieldsCompleted;
	}

	private boolean isAtLeastOneFieldCompleted() {
		// Проверяем, заполнено ли хотя бы одно из основных полей
		boolean mainFieldsCompleted = !isEmpty(this.surveyTwoId) ||
				!isEmpty(this.fillingStatus) ||
				!isEmpty(this.n_exam_coor) ||
				!isEmpty(this.n_exam_cranial) ||
				!isEmpty(this.n_exam_gait) ||
				!isEmpty(this.n_exam_mental) ||
				!isEmpty(this.n_exam_motor) ||
				!isEmpty(this.n_exam_reflex) ||
				!isEmpty(this.n_exam_sens);

		// Проверяем, заполнено ли хотя бы одно из дополнительных полей, если соответствующие основные поля равны "abnormal"
		boolean conditionalFieldsCompleted = false;

		if ("abnormal".equalsIgnoreCase(this.n_exam_coor)) {
			conditionalFieldsCompleted |= !isEmpty(this.n_exam_coor_abn);
		}
		if ("abnormal".equalsIgnoreCase(this.n_exam_cranial)) {
			conditionalFieldsCompleted |= !isEmpty(this.n_exam_cranial_abn);
		}
		if ("abnormal".equalsIgnoreCase(this.n_exam_gait)) {
			conditionalFieldsCompleted |= !isEmpty(this.n_exam_gait_abn);
		}
		if ("abnormal".equalsIgnoreCase(this.n_exam_mental)) {
			conditionalFieldsCompleted |= !isEmpty(this.n_exam_mental_abn);
		}
		if ("abnormal".equalsIgnoreCase(this.n_exam_motor)) {
			conditionalFieldsCompleted |= !isEmpty(this.n_exam_motor_abn);
		}
		if ("abnormal".equalsIgnoreCase(this.n_exam_reflex)) {
			conditionalFieldsCompleted |= !isEmpty(this.n_exam_reflex_abn);
		}
		if ("abnormal".equalsIgnoreCase(this.n_exam_sens)) {
			conditionalFieldsCompleted |= !isEmpty(this.n_exam_sens_abn);
		}

		return mainFieldsCompleted || conditionalFieldsCompleted;
	}

	private boolean isEmpty(String value) {
		// Проверяем, является ли строка пустой или null
		return value == null || value.trim().isEmpty();
	}
}

//green if all items completed, orange if some but not all, blue if none are completed


