package net.mdsgene.admin.generatedproject;
import java.util.Date;
import javax.persistence.*;
@Entity
@Table(name = "PINK1PRKN128", schema = "public")
@Cacheable(false)
public class PINK1PRKN128 implements java.io.Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PINK1PRKN128_id_seq")
    @SequenceGenerator(name="PINK1PRKN128_id_seq", sequenceName="PINK1PRKN128_id_seq", allocationSize=1)
	@Column(name = "id", unique = true, nullable = false, columnDefinition = "serial")
	private int id;

	public PINK1PRKN128() {
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

	private String stais1;

	@Column(name = "stais1", nullable = true, columnDefinition = "varchar", length = 128)
	public String getStais1() {
		return this.stais1;
	}

	public void setStais1(String stais1) {
		this.stais1 = stais1;
	}
	private String stais10;

	@Column(name = "stais10", nullable = true, columnDefinition = "varchar", length = 128)
	public String getStais10() {
		return this.stais10;
	}

	public void setStais10(String stais10) {
		this.stais10 = stais10;
	}
	private String stais11;

	@Column(name = "stais11", nullable = true, columnDefinition = "varchar", length = 128)
	public String getStais11() {
		return this.stais11;
	}

	public void setStais11(String stais11) {
		this.stais11 = stais11;
	}
	private String stais12;

	@Column(name = "stais12", nullable = true, columnDefinition = "varchar", length = 128)
	public String getStais12() {
		return this.stais12;
	}

	public void setStais12(String stais12) {
		this.stais12 = stais12;
	}
	private String stais13;

	@Column(name = "stais13", nullable = true, columnDefinition = "varchar", length = 128)
	public String getStais13() {
		return this.stais13;
	}

	public void setStais13(String stais13) {
		this.stais13 = stais13;
	}
	private String stais14;

	@Column(name = "stais14", nullable = true, columnDefinition = "varchar", length = 128)
	public String getStais14() {
		return this.stais14;
	}

	public void setStais14(String stais14) {
		this.stais14 = stais14;
	}
	private String stais15;

	@Column(name = "stais15", nullable = true, columnDefinition = "varchar", length = 128)
	public String getStais15() {
		return this.stais15;
	}

	public void setStais15(String stais15) {
		this.stais15 = stais15;
	}
	private String stais16;

	@Column(name = "stais16", nullable = true, columnDefinition = "varchar", length = 128)
	public String getStais16() {
		return this.stais16;
	}

	public void setStais16(String stais16) {
		this.stais16 = stais16;
	}
	private String stais17;

	@Column(name = "stais17", nullable = true, columnDefinition = "varchar", length = 128)
	public String getStais17() {
		return this.stais17;
	}

	public void setStais17(String stais17) {
		this.stais17 = stais17;
	}
	private String stais18;

	@Column(name = "stais18", nullable = true, columnDefinition = "varchar", length = 128)
	public String getStais18() {
		return this.stais18;
	}

	public void setStais18(String stais18) {
		this.stais18 = stais18;
	}
	private String stais19;

	@Column(name = "stais19", nullable = true, columnDefinition = "varchar", length = 128)
	public String getStais19() {
		return this.stais19;
	}

	public void setStais19(String stais19) {
		this.stais19 = stais19;
	}
	private String stais2;

	@Column(name = "stais2", nullable = true, columnDefinition = "varchar", length = 128)
	public String getStais2() {
		return this.stais2;
	}

	public void setStais2(String stais2) {
		this.stais2 = stais2;
	}
	private String stais20;

	@Column(name = "stais20", nullable = true, columnDefinition = "varchar", length = 128)
	public String getStais20() {
		return this.stais20;
	}

	public void setStais20(String stais20) {
		this.stais20 = stais20;
	}
	private String stais3;

	@Column(name = "stais3", nullable = true, columnDefinition = "varchar", length = 128)
	public String getStais3() {
		return this.stais3;
	}

	public void setStais3(String stais3) {
		this.stais3 = stais3;
	}
	private String stais4;

	@Column(name = "stais4", nullable = true, columnDefinition = "varchar", length = 128)
	public String getStais4() {
		return this.stais4;
	}

	public void setStais4(String stais4) {
		this.stais4 = stais4;
	}
	private String stais5;

	@Column(name = "stais5", nullable = true, columnDefinition = "varchar", length = 128)
	public String getStais5() {
		return this.stais5;
	}

	public void setStais5(String stais5) {
		this.stais5 = stais5;
	}
	private String stais6;

	@Column(name = "stais6", nullable = true, columnDefinition = "varchar", length = 128)
	public String getStais6() {
		return this.stais6;
	}

	public void setStais6(String stais6) {
		this.stais6 = stais6;
	}
	private String stais7;

	@Column(name = "stais7", nullable = true, columnDefinition = "varchar", length = 128)
	public String getStais7() {
		return this.stais7;
	}

	public void setStais7(String stais7) {
		this.stais7 = stais7;
	}
	private String stais8;

	@Column(name = "stais8", nullable = true, columnDefinition = "varchar", length = 128)
	public String getStais8() {
		return this.stais8;
	}

	public void setStais8(String stais8) {
		this.stais8 = stais8;
	}
	private String stais9;

	@Column(name = "stais9", nullable = true, columnDefinition = "varchar", length = 128)
	public String getStais9() {
		return this.stais9;
	}

	public void setStais9(String stais9) {
		this.stais9 = stais9;
	}
	private String stais_ex;

	@Column(name = "stais_ex", nullable = true, columnDefinition = "varchar", length = 128)
	public String getStais_ex() {
		return this.stais_ex;
	}

	public void setStais_ex(String stais_ex) {
		this.stais_ex = stais_ex;
	}


	public String getStatusColor() {
		// Если все рабочие поля (без учета stais_instruction) пусты, считаем, что форма не начата → "blue"
		if (areAllFieldsEmpty()) {
			System.out.println("Все рабочие поля пусты");
			return "blue";
		}

		// Если stais_ex равно "2" (тест не проводился) → "red"
		if ("2".equalsIgnoreCase(this.stais_ex)) {
			System.out.println("stais_ex == '2' → тест не проводился");
			return "red";
		}

		// Если stais_ex равно "1" (тест проведён), проверяем, заполнены ли все обязательные рабочие поля
		if ("1".equalsIgnoreCase(this.stais_ex)) {
			if (areAllFieldsCompleted()) {
				System.out.println("Все обязательные поля заполнены → green");
				return "green";
			} else if (isAtLeastOneFieldCompleted()) {
				System.out.println("Некоторые рабочие поля заполнены → orange");
				return "orange";
			}
		}

		// Если значение stais_ex имеет иное значение, но данные введены частично, возвращаем "orange"
		System.out.println("Рабочие поля заполнены частично → orange");
		return "orange";
	}

	/**
	 * Проверяет, что все рабочие поля (без учета поля-заголовка stais_instruction) пусты.
	 */
	private boolean areAllFieldsEmpty() {
		return isEmpty(surveyTwoId)
				&& isEmpty(fillingStatus)
				&& isEmpty(stais_ex)
				&& isEmpty(stais1)
				&& isEmpty(stais2)
				&& isEmpty(stais3)
				&& isEmpty(stais4)
				&& isEmpty(stais5)
				&& isEmpty(stais6)
				&& isEmpty(stais7)
				&& isEmpty(stais8)
				&& isEmpty(stais9)
				&& isEmpty(stais10)
				&& isEmpty(stais11)
				&& isEmpty(stais12)
				&& isEmpty(stais13)
				&& isEmpty(stais14)
				&& isEmpty(stais15)
				&& isEmpty(stais16)
				&& isEmpty(stais17)
				&& isEmpty(stais18)
				&& isEmpty(stais19)
				&& isEmpty(stais20);
		// Поле stais_instruction исключено, т.к. оно типа headline.
	}

	/**
	 * Проверяет, что все обязательные рабочие поля заполнены (без поля stais_instruction).
	 */
	private boolean areAllFieldsCompleted() {
		boolean complete = true;

		if (isEmpty(surveyTwoId)) {
			System.out.println("Поле surveyTwoId не заполнено");
			complete = false;
		}
		if (isEmpty(fillingStatus)) {
			System.out.println("Поле fillingStatus не заполнено");
			complete = false;
		}
		if (isEmpty(stais_ex)) {
			System.out.println("Поле stais_ex не заполнено");
			complete = false;
		}
		if (isEmpty(stais1)) {
			System.out.println("Поле stais1 не заполнено");
			complete = false;
		}
		if (isEmpty(stais2)) {
			System.out.println("Поле stais2 не заполнено");
			complete = false;
		}
		if (isEmpty(stais3)) {
			System.out.println("Поле stais3 не заполнено");
			complete = false;
		}
		if (isEmpty(stais4)) {
			System.out.println("Поле stais4 не заполнено");
			complete = false;
		}
		if (isEmpty(stais5)) {
			System.out.println("Поле stais5 не заполнено");
			complete = false;
		}
		if (isEmpty(stais6)) {
			System.out.println("Поле stais6 не заполнено");
			complete = false;
		}
		if (isEmpty(stais7)) {
			System.out.println("Поле stais7 не заполнено");
			complete = false;
		}
		if (isEmpty(stais8)) {
			System.out.println("Поле stais8 не заполнено");
			complete = false;
		}
		if (isEmpty(stais9)) {
			System.out.println("Поле stais9 не заполнено");
			complete = false;
		}
		if (isEmpty(stais10)) {
			System.out.println("Поле stais10 не заполнено");
			complete = false;
		}
		if (isEmpty(stais11)) {
			System.out.println("Поле stais11 не заполнено");
			complete = false;
		}
		if (isEmpty(stais12)) {
			System.out.println("Поле stais12 не заполнено");
			complete = false;
		}
		if (isEmpty(stais13)) {
			System.out.println("Поле stais13 не заполнено");
			complete = false;
		}
		if (isEmpty(stais14)) {
			System.out.println("Поле stais14 не заполнено");
			complete = false;
		}
		if (isEmpty(stais15)) {
			System.out.println("Поле stais15 не заполнено");
			complete = false;
		}
		if (isEmpty(stais16)) {
			System.out.println("Поле stais16 не заполнено");
			complete = false;
		}
		if (isEmpty(stais17)) {
			System.out.println("Поле stais17 не заполнено");
			complete = false;
		}
		if (isEmpty(stais18)) {
			System.out.println("Поле stais18 не заполнено");
			complete = false;
		}
		if (isEmpty(stais19)) {
			System.out.println("Поле stais19 не заполнено");
			complete = false;
		}
		if (isEmpty(stais20)) {
			System.out.println("Поле stais20 не заполнено");
			complete = false;
		}

		return complete;
	}

	/**
	 * Проверяет, что хотя бы одно рабочее поле заполнено (без учета stais_instruction).
	 */
	private boolean isAtLeastOneFieldCompleted() {
		return !isEmpty(surveyTwoId)
				|| !isEmpty(fillingStatus)
				|| !isEmpty(stais_ex)
				|| !isEmpty(stais1)
				|| !isEmpty(stais2)
				|| !isEmpty(stais3)
				|| !isEmpty(stais4)
				|| !isEmpty(stais5)
				|| !isEmpty(stais6)
				|| !isEmpty(stais7)
				|| !isEmpty(stais8)
				|| !isEmpty(stais9)
				|| !isEmpty(stais10)
				|| !isEmpty(stais11)
				|| !isEmpty(stais12)
				|| !isEmpty(stais13)
				|| !isEmpty(stais14)
				|| !isEmpty(stais15)
				|| !isEmpty(stais16)
				|| !isEmpty(stais17)
				|| !isEmpty(stais18)
				|| !isEmpty(stais19)
				|| !isEmpty(stais20);
	}

	/** Возвращает true, если строка равна null или состоит только из пробелов */
	private boolean isEmpty(String value) {
		return value == null || value.trim().isEmpty();
	}
}


//green if all items completed, red if STAIS_ex=no, orange if some but not all, blue if none are completed