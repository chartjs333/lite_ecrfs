package net.mdsgene.admin.generatedproject;
import java.util.Date;
import javax.persistence.*;
@Entity
@Table(name = "PINK1PRKN125", schema = "public")
@Cacheable(false)
public class PINK1PRKN125 implements java.io.Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PINK1PRKN125_id_seq")
    @SequenceGenerator(name="PINK1PRKN125_id_seq", sequenceName="PINK1PRKN125_id_seq", allocationSize=1)
	@Column(name = "id", unique = true, nullable = false, columnDefinition = "serial")
	private int id;

	public PINK1PRKN125() {
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

	private String quip_buy1;

	@Column(name = "quip_buy1", nullable = true, columnDefinition = "varchar", length = 128)
	public String getQuip_buy1() {
		return this.quip_buy1;
	}

	public void setQuip_buy1(String quip_buy1) {
		this.quip_buy1 = quip_buy1;
	}
	private String quip_buy2;

	@Column(name = "quip_buy2", nullable = true, columnDefinition = "varchar", length = 128)
	public String getQuip_buy2() {
		return this.quip_buy2;
	}

	public void setQuip_buy2(String quip_buy2) {
		this.quip_buy2 = quip_buy2;
	}
	private String quip_eat1;

	@Column(name = "quip_eat1", nullable = true, columnDefinition = "varchar", length = 128)
	public String getQuip_eat1() {
		return this.quip_eat1;
	}

	public void setQuip_eat1(String quip_eat1) {
		this.quip_eat1 = quip_eat1;
	}
	private String quip_eat2;

	@Column(name = "quip_eat2", nullable = true, columnDefinition = "varchar", length = 128)
	public String getQuip_eat2() {
		return this.quip_eat2;
	}

	public void setQuip_eat2(String quip_eat2) {
		this.quip_eat2 = quip_eat2;
	}
	private String quip_ex;

	@Column(name = "quip_ex", nullable = true, columnDefinition = "varchar", length = 128)
	public String getQuip_ex() {
		return this.quip_ex;
	}

	public void setQuip_ex(String quip_ex) {
		this.quip_ex = quip_ex;
	}
	private String quip_gamb1;

	@Column(name = "quip_gamb1", nullable = true, columnDefinition = "varchar", length = 128)
	public String getQuip_gamb1() {
		return this.quip_gamb1;
	}

	public void setQuip_gamb1(String quip_gamb1) {
		this.quip_gamb1 = quip_gamb1;
	}
	private String quip_gamb2;

	@Column(name = "quip_gamb2", nullable = true, columnDefinition = "varchar", length = 128)
	public String getQuip_gamb2() {
		return this.quip_gamb2;
	}

	public void setQuip_gamb2(String quip_gamb2) {
		this.quip_gamb2 = quip_gamb2;
	}
	private String quip_med1;

	@Column(name = "quip_med1", nullable = true, columnDefinition = "varchar", length = 128)
	public String getQuip_med1() {
		return this.quip_med1;
	}

	public void setQuip_med1(String quip_med1) {
		this.quip_med1 = quip_med1;
	}
	private String quip_med2;

	@Column(name = "quip_med2", nullable = true, columnDefinition = "varchar", length = 128)
	public String getQuip_med2() {
		return this.quip_med2;
	}

	public void setQuip_med2(String quip_med2) {
		this.quip_med2 = quip_med2;
	}
	private String quip_oth1;

	@Column(name = "quip_oth1", nullable = true, columnDefinition = "varchar", length = 128)
	public String getQuip_oth1() {
		return this.quip_oth1;
	}

	public void setQuip_oth1(String quip_oth1) {
		this.quip_oth1 = quip_oth1;
	}
	private String quip_oth2;

	@Column(name = "quip_oth2", nullable = true, columnDefinition = "varchar", length = 128)
	public String getQuip_oth2() {
		return this.quip_oth2;
	}

	public void setQuip_oth2(String quip_oth2) {
		this.quip_oth2 = quip_oth2;
	}
	private String quip_oth3;

	@Column(name = "quip_oth3", nullable = true, columnDefinition = "varchar", length = 128)
	public String getQuip_oth3() {
		return this.quip_oth3;
	}

	public void setQuip_oth3(String quip_oth3) {
		this.quip_oth3 = quip_oth3;
	}
	private String quip_sex1;

	@Column(name = "quip_sex1", nullable = true, columnDefinition = "varchar", length = 128)
	public String getQuip_sex1() {
		return this.quip_sex1;
	}

	public void setQuip_sex1(String quip_sex1) {
		this.quip_sex1 = quip_sex1;
	}
	private String quip_sex2;

	@Column(name = "quip_sex2", nullable = true, columnDefinition = "varchar", length = 128)
	public String getQuip_sex2() {
		return this.quip_sex2;
	}

	public void setQuip_sex2(String quip_sex2) {
		this.quip_sex2 = quip_sex2;
	}
	private String quip_who;

	@Column(name = "quip_who", nullable = true, columnDefinition = "varchar", length = 128)
	public String getQuip_who() {
		return this.quip_who;
	}

	public void setQuip_who(String quip_who) {
		this.quip_who = quip_who;
	}

	public String getStatusColor() {
		// Проверяем, заполнены ли все обязательные поля (без учета headline-полей)
		boolean allCompleted = areAllFieldsCompleted();
		// Проверяем, заполнено ли хотя бы одно поле
		boolean atLeastOneCompleted = isAtLeastOneFieldCompleted();

		// Если quip_ex равно "2" (тест не проводился), возвращаем "red"
		if ("2".equalsIgnoreCase(this.quip_ex)) {
			System.out.println("quip_ex == '2' → тест не проводился");
			return "red";
		} else if (allCompleted) {
			System.out.println("Все обязательные поля заполнены → green");
			return "green";
		} else if (atLeastOneCompleted) {
			System.out.println("Некоторые поля заполнены → orange");
			return "orange";
		} else {
			System.out.println("Ни одно поле не заполнено → blue");
			return "blue";
		}
	}

	/**
	 * Проверяет, что все обязательные поля заполнены.
	 * При этом не учитываются поля‑заголовки:
	 * quip_headline2, quip_gamb_headline, quip_sex_headline,
	 * quip_buy_headline, quip_eat_headline, quip_oth_headline2,
	 * quip_oth_headline1, quip_med_headline, quip_copyright.
	 */
	private boolean areAllFieldsCompleted() {
		boolean complete = true;
		if (isEmpty(this.surveyTwoId)) {
			System.out.println("Поле surveyTwoId не заполнено");
			complete = false;
		}
		if (isEmpty(this.fillingStatus)) {
			System.out.println("Поле fillingStatus не заполнено");
			complete = false;
		}
		if (isEmpty(this.quip_ex)) {
			System.out.println("Поле quip_ex не заполнено");
			complete = false;
		}
		if (isEmpty(this.quip_gamb1)) {
			System.out.println("Поле quip_gamb1 не заполнено");
			complete = false;
		}
		if (isEmpty(this.quip_gamb2)) {
			System.out.println("Поле quip_gamb2 не заполнено");
			complete = false;
		}
		if (isEmpty(this.quip_buy1)) {
			System.out.println("Поле quip_buy1 не заполнено");
			complete = false;
		}
		if (isEmpty(this.quip_buy2)) {
			System.out.println("Поле quip_buy2 не заполнено");
			complete = false;
		}
		if (isEmpty(this.quip_eat1)) {
			System.out.println("Поле quip_eat1 не заполнено");
			complete = false;
		}
		if (isEmpty(this.quip_eat2)) {
			System.out.println("Поле quip_eat2 не заполнено");
			complete = false;
		}
		if (isEmpty(this.quip_med1)) {
			System.out.println("Поле quip_med1 не заполнено");
			complete = false;
		}
		if (isEmpty(this.quip_med2)) {
			System.out.println("Поле quip_med2 не заполнено");
			complete = false;
		}
		if (isEmpty(this.quip_oth1)) {
			System.out.println("Поле quip_oth1 не заполнено");
			complete = false;
		}
		if (isEmpty(this.quip_oth2)) {
			System.out.println("Поле quip_oth2 не заполнено");
			complete = false;
		}
		if (isEmpty(this.quip_oth3)) {
			System.out.println("Поле quip_oth3 не заполнено");
			complete = false;
		}
		if (isEmpty(this.quip_sex1)) {
			System.out.println("Поле quip_sex1 не заполнено");
			complete = false;
		}
		if (isEmpty(this.quip_sex2)) {
			System.out.println("Поле quip_sex2 не заполнено");
			complete = false;
		}
		if (isEmpty(this.quip_who)) {
			System.out.println("Поле quip_who не заполнено");
			complete = false;
		}
		return complete;
	}

	/**
	 * Проверяет, что хотя бы одно обязательное поле заполнено (без учета headline-полей).
	 */
	private boolean isAtLeastOneFieldCompleted() {
		return !isEmpty(this.surveyTwoId)
				|| !isEmpty(this.fillingStatus)
				|| !isEmpty(this.quip_ex)
				|| !isEmpty(this.quip_gamb1)
				|| !isEmpty(this.quip_gamb2)
				|| !isEmpty(this.quip_buy1)
				|| !isEmpty(this.quip_buy2)
				|| !isEmpty(this.quip_eat1)
				|| !isEmpty(this.quip_eat2)
				|| !isEmpty(this.quip_med1)
				|| !isEmpty(this.quip_med2)
				|| !isEmpty(this.quip_oth1)
				|| !isEmpty(this.quip_oth2)
				|| !isEmpty(this.quip_oth3)
				|| !isEmpty(this.quip_sex1)
				|| !isEmpty(this.quip_sex2)
				|| !isEmpty(this.quip_who);
	}

	/** Возвращает true, если значение null или состоит только из пробелов. */
	private boolean isEmpty(String value) {
		return value == null || value.trim().isEmpty();
	}

}


//green if all items completed, red if QUIP_ex=no, orange if some but not all, blue if none are completed

