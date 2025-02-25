package net.mdsgene.admin.generatedproject;
import java.util.Date;
import javax.persistence.*;
@Entity
@Table(name = "PINK1PRKN127", schema = "public")
@Cacheable(false)
public class PINK1PRKN127 implements java.io.Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PINK1PRKN127_id_seq")
    @SequenceGenerator(name="PINK1PRKN127_id_seq", sequenceName="PINK1PRKN127_id_seq", allocationSize=1)
	@Column(name = "id", unique = true, nullable = false, columnDefinition = "serial")
	private int id;

	public PINK1PRKN127() {
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

	private String gds1;

	@Column(name = "gds1", nullable = true, columnDefinition = "varchar", length = 128)
	public String getGds1() {
		return this.gds1;
	}

	public void setGds1(String gds1) {
		this.gds1 = gds1;
	}
	private String gds10;

	@Column(name = "gds10", nullable = true, columnDefinition = "varchar", length = 128)
	public String getGds10() {
		return this.gds10;
	}

	public void setGds10(String gds10) {
		this.gds10 = gds10;
	}
	private String gds11;

	@Column(name = "gds11", nullable = true, columnDefinition = "varchar", length = 128)
	public String getGds11() {
		return this.gds11;
	}

	public void setGds11(String gds11) {
		this.gds11 = gds11;
	}
	private String gds12;

	@Column(name = "gds12", nullable = true, columnDefinition = "varchar", length = 128)
	public String getGds12() {
		return this.gds12;
	}

	public void setGds12(String gds12) {
		this.gds12 = gds12;
	}
	private String gds13;

	@Column(name = "gds13", nullable = true, columnDefinition = "varchar", length = 128)
	public String getGds13() {
		return this.gds13;
	}

	public void setGds13(String gds13) {
		this.gds13 = gds13;
	}
	private String gds14;

	@Column(name = "gds14", nullable = true, columnDefinition = "varchar", length = 128)
	public String getGds14() {
		return this.gds14;
	}

	public void setGds14(String gds14) {
		this.gds14 = gds14;
	}
	private String gds15;

	@Column(name = "gds15", nullable = true, columnDefinition = "varchar", length = 128)
	public String getGds15() {
		return this.gds15;
	}

	public void setGds15(String gds15) {
		this.gds15 = gds15;
	}
	private String gds2;

	@Column(name = "gds2", nullable = true, columnDefinition = "varchar", length = 128)
	public String getGds2() {
		return this.gds2;
	}

	public void setGds2(String gds2) {
		this.gds2 = gds2;
	}
	private String gds3;

	@Column(name = "gds3", nullable = true, columnDefinition = "varchar", length = 128)
	public String getGds3() {
		return this.gds3;
	}

	public void setGds3(String gds3) {
		this.gds3 = gds3;
	}
	private String gds4;

	@Column(name = "gds4", nullable = true, columnDefinition = "varchar", length = 128)
	public String getGds4() {
		return this.gds4;
	}

	public void setGds4(String gds4) {
		this.gds4 = gds4;
	}
	private String gds5;

	@Column(name = "gds5", nullable = true, columnDefinition = "varchar", length = 128)
	public String getGds5() {
		return this.gds5;
	}

	public void setGds5(String gds5) {
		this.gds5 = gds5;
	}
	private String gds6;

	@Column(name = "gds6", nullable = true, columnDefinition = "varchar", length = 128)
	public String getGds6() {
		return this.gds6;
	}

	public void setGds6(String gds6) {
		this.gds6 = gds6;
	}
	private String gds7;

	@Column(name = "gds7", nullable = true, columnDefinition = "varchar", length = 128)
	public String getGds7() {
		return this.gds7;
	}

	public void setGds7(String gds7) {
		this.gds7 = gds7;
	}
	private String gds8;

	@Column(name = "gds8", nullable = true, columnDefinition = "varchar", length = 128)
	public String getGds8() {
		return this.gds8;
	}

	public void setGds8(String gds8) {
		this.gds8 = gds8;
	}
	private String gds9;

	@Column(name = "gds9", nullable = true, columnDefinition = "varchar", length = 128)
	public String getGds9() {
		return this.gds9;
	}

	public void setGds9(String gds9) {
		this.gds9 = gds9;
	}
	private String gds_ex;

	@Column(name = "gds_ex", nullable = true, columnDefinition = "varchar", length = 128)
	public String getGds_ex() {
		return this.gds_ex;
	}

	public void setGds_ex(String gds_ex) {
		this.gds_ex = gds_ex;
	}

	public String getStatusColor() {
		// Если все рабочие поля (без учета заголовка gds_headline2) пусты, считаем, что форма не начата – "blue"
		if (areAllFieldsEmpty()) {
			System.out.println("Все рабочие поля пусты");
			return "blue";
		}

		// Если gds_ex равно "1" (тест не проводился) – возвращаем "red"
		if ("1".equalsIgnoreCase(this.gds_ex)) {
			System.out.println("gds_ex == '1' → тест не проводился");
			return "red";
		}

		// Если gds_ex равно "0" (тест проведён) – проверяем обязательные рабочие поля
		if ("0".equalsIgnoreCase(this.gds_ex)) {
			if (areAllFieldsCompleted()) {
				System.out.println("Все обязательные поля заполнены → green");
				return "green";
			} else if (isAtLeastOneFieldCompleted()) {
				System.out.println("Некоторые рабочие поля заполнены → orange");
				return "orange";
			}
		}

		// Если значение gds_ex имеет иное значение, но рабочие поля заполнены частично – "orange"
		System.out.println("Некоторые рабочие поля заполнены, статус неопределён → orange");
		return "orange";
	}

	/**
	 * Проверяет, что все рабочие поля (исключая заголовок gds_headline2) пусты.
	 */
	private boolean areAllFieldsEmpty() {
		return isEmpty(gds_ex)
				&& isEmpty(gds1)
				&& isEmpty(gds2)
				&& isEmpty(gds3)
				&& isEmpty(gds4)
				&& isEmpty(gds5)
				&& isEmpty(gds6)
				&& isEmpty(gds7)
				&& isEmpty(gds8)
				&& isEmpty(gds9)
				&& isEmpty(gds10)
				&& isEmpty(gds11)
				&& isEmpty(gds12)
				&& isEmpty(gds13)
				&& isEmpty(gds14)
				&& isEmpty(gds15);
	}

	/**
	 * Проверяет, что все обязательные рабочие поля заполнены.
	 * Поле gds_headline2 не участвует в проверке.
	 */
	private boolean areAllFieldsCompleted() {
		boolean complete = true;
		if (isEmpty(gds_ex)) {
			System.out.println("Поле gds_ex не заполнено");
			complete = false;
		}
		if (isEmpty(gds1)) {
			System.out.println("Поле gds1 не заполнено");
			complete = false;
		}
		if (isEmpty(gds2)) {
			System.out.println("Поле gds2 не заполнено");
			complete = false;
		}
		if (isEmpty(gds3)) {
			System.out.println("Поле gds3 не заполнено");
			complete = false;
		}
		if (isEmpty(gds4)) {
			System.out.println("Поле gds4 не заполнено");
			complete = false;
		}
		if (isEmpty(gds5)) {
			System.out.println("Поле gds5 не заполнено");
			complete = false;
		}
		if (isEmpty(gds6)) {
			System.out.println("Поле gds6 не заполнено");
			complete = false;
		}
		if (isEmpty(gds7)) {
			System.out.println("Поле gds7 не заполнено");
			complete = false;
		}
		if (isEmpty(gds8)) {
			System.out.println("Поле gds8 не заполнено");
			complete = false;
		}
		if (isEmpty(gds9)) {
			System.out.println("Поле gds9 не заполнено");
			complete = false;
		}
		if (isEmpty(gds10)) {
			System.out.println("Поле gds10 не заполнено");
			complete = false;
		}
		if (isEmpty(gds11)) {
			System.out.println("Поле gds11 не заполнено");
			complete = false;
		}
		if (isEmpty(gds12)) {
			System.out.println("Поле gds12 не заполнено");
			complete = false;
		}
		if (isEmpty(gds13)) {
			System.out.println("Поле gds13 не заполнено");
			complete = false;
		}
		if (isEmpty(gds14)) {
			System.out.println("Поле gds14 не заполнено");
			complete = false;
		}
		if (isEmpty(gds15)) {
			System.out.println("Поле gds15 не заполнено");
			complete = false;
		}
		return complete;
	}

	/**
	 * Проверяет, что хотя бы одно рабочее поле заполнено.
	 */
	private boolean isAtLeastOneFieldCompleted() {
		return !isEmpty(gds_ex)
				|| !isEmpty(gds1)
				|| !isEmpty(gds2)
				|| !isEmpty(gds3)
				|| !isEmpty(gds4)
				|| !isEmpty(gds5)
				|| !isEmpty(gds6)
				|| !isEmpty(gds7)
				|| !isEmpty(gds8)
				|| !isEmpty(gds9)
				|| !isEmpty(gds10)
				|| !isEmpty(gds11)
				|| !isEmpty(gds12)
				|| !isEmpty(gds13)
				|| !isEmpty(gds14)
				|| !isEmpty(gds15);
	}

	/** Возвращает true, если строка равна null или состоит только из пробелов. */
	private boolean isEmpty(String value) {
		return value == null || value.trim().isEmpty() || value.trim().equals("-");
	}

}


//green if all items completed, red if GDS_ex=no, orange if some but not all, blue if none are completed