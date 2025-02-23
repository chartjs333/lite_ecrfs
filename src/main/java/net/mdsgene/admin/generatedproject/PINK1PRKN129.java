package net.mdsgene.admin.generatedproject;
import java.util.Date;
import javax.persistence.*;
@Entity
@Table(name = "PINK1PRKN129", schema = "public")
@Cacheable(false)
public class PINK1PRKN129 implements java.io.Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PINK1PRKN129_id_seq")
    @SequenceGenerator(name="PINK1PRKN129_id_seq", sequenceName="PINK1PRKN129_id_seq", allocationSize=1)
	@Column(name = "id", unique = true, nullable = false, columnDefinition = "serial")
	private int id;

	public PINK1PRKN129() {
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

	private String stait1;

	@Column(name = "stait1", nullable = true, columnDefinition = "varchar", length = 128)
	public String getStait1() {
		return this.stait1;
	}

	public void setStait1(String stait1) {
		this.stait1 = stait1;
	}
	private String stait10;

	@Column(name = "stait10", nullable = true, columnDefinition = "varchar", length = 128)
	public String getStait10() {
		return this.stait10;
	}

	public void setStait10(String stait10) {
		this.stait10 = stait10;
	}
	private String stait11;

	@Column(name = "stait11", nullable = true, columnDefinition = "varchar", length = 128)
	public String getStait11() {
		return this.stait11;
	}

	public void setStait11(String stait11) {
		this.stait11 = stait11;
	}
	private String stait12;

	@Column(name = "stait12", nullable = true, columnDefinition = "varchar", length = 128)
	public String getStait12() {
		return this.stait12;
	}

	public void setStait12(String stait12) {
		this.stait12 = stait12;
	}
	private String stait13;

	@Column(name = "stait13", nullable = true, columnDefinition = "varchar", length = 128)
	public String getStait13() {
		return this.stait13;
	}

	public void setStait13(String stait13) {
		this.stait13 = stait13;
	}
	private String stait14;

	@Column(name = "stait14", nullable = true, columnDefinition = "varchar", length = 128)
	public String getStait14() {
		return this.stait14;
	}

	public void setStait14(String stait14) {
		this.stait14 = stait14;
	}
	private String stait15;

	@Column(name = "stait15", nullable = true, columnDefinition = "varchar", length = 128)
	public String getStait15() {
		return this.stait15;
	}

	public void setStait15(String stait15) {
		this.stait15 = stait15;
	}
	private String stait16;

	@Column(name = "stait16", nullable = true, columnDefinition = "varchar", length = 128)
	public String getStait16() {
		return this.stait16;
	}

	public void setStait16(String stait16) {
		this.stait16 = stait16;
	}
	private String stait17;

	@Column(name = "stait17", nullable = true, columnDefinition = "varchar", length = 128)
	public String getStait17() {
		return this.stait17;
	}

	public void setStait17(String stait17) {
		this.stait17 = stait17;
	}
	private String stait18;

	@Column(name = "stait18", nullable = true, columnDefinition = "varchar", length = 128)
	public String getStait18() {
		return this.stait18;
	}

	public void setStait18(String stait18) {
		this.stait18 = stait18;
	}
	private String stait19;

	@Column(name = "stait19", nullable = true, columnDefinition = "varchar", length = 128)
	public String getStait19() {
		return this.stait19;
	}

	public void setStait19(String stait19) {
		this.stait19 = stait19;
	}
	private String stait2;

	@Column(name = "stait2", nullable = true, columnDefinition = "varchar", length = 128)
	public String getStait2() {
		return this.stait2;
	}

	public void setStait2(String stait2) {
		this.stait2 = stait2;
	}
	private String stait20;

	@Column(name = "stait20", nullable = true, columnDefinition = "varchar", length = 128)
	public String getStait20() {
		return this.stait20;
	}

	public void setStait20(String stait20) {
		this.stait20 = stait20;
	}
	private String stait3;

	@Column(name = "stait3", nullable = true, columnDefinition = "varchar", length = 128)
	public String getStait3() {
		return this.stait3;
	}

	public void setStait3(String stait3) {
		this.stait3 = stait3;
	}
	private String stait4;

	@Column(name = "stait4", nullable = true, columnDefinition = "varchar", length = 128)
	public String getStait4() {
		return this.stait4;
	}

	public void setStait4(String stait4) {
		this.stait4 = stait4;
	}
	private String stait5;

	@Column(name = "stait5", nullable = true, columnDefinition = "varchar", length = 128)
	public String getStait5() {
		return this.stait5;
	}

	public void setStait5(String stait5) {
		this.stait5 = stait5;
	}
	private String stait6;

	@Column(name = "stait6", nullable = true, columnDefinition = "varchar", length = 128)
	public String getStait6() {
		return this.stait6;
	}

	public void setStait6(String stait6) {
		this.stait6 = stait6;
	}
	private String stait7;

	@Column(name = "stait7", nullable = true, columnDefinition = "varchar", length = 128)
	public String getStait7() {
		return this.stait7;
	}

	public void setStait7(String stait7) {
		this.stait7 = stait7;
	}
	private String stait8;

	@Column(name = "stait8", nullable = true, columnDefinition = "varchar", length = 128)
	public String getStait8() {
		return this.stait8;
	}

	public void setStait8(String stait8) {
		this.stait8 = stait8;
	}
	private String stait9;

	@Column(name = "stait9", nullable = true, columnDefinition = "varchar", length = 128)
	public String getStait9() {
		return this.stait9;
	}

	public void setStait9(String stait9) {
		this.stait9 = stait9;
	}
	private String stait_ex;

	@Column(name = "stait_ex", nullable = true, columnDefinition = "varchar", length = 128)
	public String getStait_ex() {
		return this.stait_ex;
	}

	public void setStait_ex(String stait_ex) {
		this.stait_ex = stait_ex;
	}

	public String getStatusColor() {
		// 1. Если все рабочие поля (без stait1_instruction) пусты, считаем, что форма не начата – "blue"
		if (areAllFieldsEmpty()) {
			System.out.println("Все рабочие поля пусты");
			return "blue";
		}

		// 2. Если stait_ex равно "2" (тест не проведён), возвращаем "red"
		if ("2".equalsIgnoreCase(this.stait_ex)) {
			System.out.println("stait_ex == '2' → тест не проводился");
			return "red";
		}

		// 3. Если stait_ex равно "1" (тест проведён), проверяем заполненность рабочих полей
		if ("1".equalsIgnoreCase(this.stait_ex)) {
			if (areAllFieldsCompleted()) {
				System.out.println("Все рабочие поля заполнены → green");
				return "green";
			} else if (isAtLeastOneFieldCompleted()) {
				System.out.println("Некоторые рабочие поля заполнены → orange");
				return "orange";
			}
		}

		// 4. Если stait_ex имеет другое значение, но какие-то рабочие поля заполнены – "orange"
		System.out.println("Рабочие поля заполнены частично → orange");
		return "orange";
	}

	/**
	 * Проверяет, что все рабочие поля (исключая поле-заголовок stait1_instruction) пусты.
	 */
	private boolean areAllFieldsEmpty() {
		return isEmpty(surveyTwoId)
				&& isEmpty(fillingStatus)
				&& isEmpty(stait_ex)
				&& isEmpty(stait1)
				&& isEmpty(stait2)
				&& isEmpty(stait3)
				&& isEmpty(stait4)
				&& isEmpty(stait5)
				&& isEmpty(stait6)
				&& isEmpty(stait7)
				&& isEmpty(stait8)
				&& isEmpty(stait9)
				&& isEmpty(stait10)
				&& isEmpty(stait11)
				&& isEmpty(stait12)
				&& isEmpty(stait13)
				&& isEmpty(stait14)
				&& isEmpty(stait15)
				&& isEmpty(stait16)
				&& isEmpty(stait17)
				&& isEmpty(stait18)
				&& isEmpty(stait19)
				&& isEmpty(stait20);
		// Поле stait1_instruction не учитывается, так как оно типа headline.
	}

	/**
	 * Проверяет, что все обязательные рабочие поля заполнены (без поля-заголовка stait1_instruction).
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
		if (isEmpty(stait_ex)) {
			System.out.println("Поле stait_ex не заполнено");
			complete = false;
		}
		if (isEmpty(stait1)) {
			System.out.println("Поле stait1 не заполнено");
			complete = false;
		}
		if (isEmpty(stait2)) {
			System.out.println("Поле stait2 не заполнено");
			complete = false;
		}
		if (isEmpty(stait3)) {
			System.out.println("Поле stait3 не заполнено");
			complete = false;
		}
		if (isEmpty(stait4)) {
			System.out.println("Поле stait4 не заполнено");
			complete = false;
		}
		if (isEmpty(stait5)) {
			System.out.println("Поле stait5 не заполнено");
			complete = false;
		}
		if (isEmpty(stait6)) {
			System.out.println("Поле stait6 не заполнено");
			complete = false;
		}
		if (isEmpty(stait7)) {
			System.out.println("Поле stait7 не заполнено");
			complete = false;
		}
		if (isEmpty(stait8)) {
			System.out.println("Поле stait8 не заполнено");
			complete = false;
		}
		if (isEmpty(stait9)) {
			System.out.println("Поле stait9 не заполнено");
			complete = false;
		}
		if (isEmpty(stait10)) {
			System.out.println("Поле stait10 не заполнено");
			complete = false;
		}
		if (isEmpty(stait11)) {
			System.out.println("Поле stait11 не заполнено");
			complete = false;
		}
		if (isEmpty(stait12)) {
			System.out.println("Поле stait12 не заполнено");
			complete = false;
		}
		if (isEmpty(stait13)) {
			System.out.println("Поле stait13 не заполнено");
			complete = false;
		}
		if (isEmpty(stait14)) {
			System.out.println("Поле stait14 не заполнено");
			complete = false;
		}
		if (isEmpty(stait15)) {
			System.out.println("Поле stait15 не заполнено");
			complete = false;
		}
		if (isEmpty(stait16)) {
			System.out.println("Поле stait16 не заполнено");
			complete = false;
		}
		if (isEmpty(stait17)) {
			System.out.println("Поле stait17 не заполнено");
			complete = false;
		}
		if (isEmpty(stait18)) {
			System.out.println("Поле stait18 не заполнено");
			complete = false;
		}
		if (isEmpty(stait19)) {
			System.out.println("Поле stait19 не заполнено");
			complete = false;
		}
		if (isEmpty(stait20)) {
			System.out.println("Поле stait20 не заполнено");
			complete = false;
		}
		return complete;
	}

	/**
	 * Проверяет, что хотя бы одно рабочее поле заполнено (без учета stait1_instruction).
	 */
	private boolean isAtLeastOneFieldCompleted() {
		return !isEmpty(surveyTwoId)
				|| !isEmpty(fillingStatus)
				|| !isEmpty(stait_ex)
				|| !isEmpty(stait1)
				|| !isEmpty(stait2)
				|| !isEmpty(stait3)
				|| !isEmpty(stait4)
				|| !isEmpty(stait5)
				|| !isEmpty(stait6)
				|| !isEmpty(stait7)
				|| !isEmpty(stait8)
				|| !isEmpty(stait9)
				|| !isEmpty(stait10)
				|| !isEmpty(stait11)
				|| !isEmpty(stait12)
				|| !isEmpty(stait13)
				|| !isEmpty(stait14)
				|| !isEmpty(stait15)
				|| !isEmpty(stait16)
				|| !isEmpty(stait17)
				|| !isEmpty(stait18)
				|| !isEmpty(stait19)
				|| !isEmpty(stait20);
	}

	/** Возвращает true, если строка null или состоит только из пробелов */
	private boolean isEmpty(String value) {
		return value == null || value.trim().isEmpty();
	}
}


//green if all items completed, red if STAIS_ex=no, orange if some but not all, blue if none are completed