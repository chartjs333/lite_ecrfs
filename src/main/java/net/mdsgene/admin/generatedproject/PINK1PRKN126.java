package net.mdsgene.admin.generatedproject;
import java.util.Date;
import javax.persistence.*;
@Entity
@Table(name = "PINK1PRKN126", schema = "public")
@Cacheable(false)
public class PINK1PRKN126 implements java.io.Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PINK1PRKN126_id_seq")
    @SequenceGenerator(name="PINK1PRKN126_id_seq", sequenceName="PINK1PRKN126_id_seq", allocationSize=1)
	@Column(name = "id", unique = true, nullable = false, columnDefinition = "serial")
	private int id;

	public PINK1PRKN126() {
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

	private String ess1;

	@Column(name = "ess1", nullable = true, columnDefinition = "varchar", length = 128)
	public String getEss1() {
		return this.ess1;
	}

	public void setEss1(String ess1) {
		this.ess1 = ess1;
	}
	private String ess2;

	@Column(name = "ess2", nullable = true, columnDefinition = "varchar", length = 128)
	public String getEss2() {
		return this.ess2;
	}

	public void setEss2(String ess2) {
		this.ess2 = ess2;
	}
	private String ess3;

	@Column(name = "ess3", nullable = true, columnDefinition = "varchar", length = 128)
	public String getEss3() {
		return this.ess3;
	}

	public void setEss3(String ess3) {
		this.ess3 = ess3;
	}
	private String ess4;

	@Column(name = "ess4", nullable = true, columnDefinition = "varchar", length = 128)
	public String getEss4() {
		return this.ess4;
	}

	public void setEss4(String ess4) {
		this.ess4 = ess4;
	}
	private String ess5;

	@Column(name = "ess5", nullable = true, columnDefinition = "varchar", length = 128)
	public String getEss5() {
		return this.ess5;
	}

	public void setEss5(String ess5) {
		this.ess5 = ess5;
	}
	private String ess6;

	@Column(name = "ess6", nullable = true, columnDefinition = "varchar", length = 128)
	public String getEss6() {
		return this.ess6;
	}

	public void setEss6(String ess6) {
		this.ess6 = ess6;
	}
	private String ess7;

	@Column(name = "ess7", nullable = true, columnDefinition = "varchar", length = 128)
	public String getEss7() {
		return this.ess7;
	}

	public void setEss7(String ess7) {
		this.ess7 = ess7;
	}
	private String ess8;

	@Column(name = "ess8", nullable = true, columnDefinition = "varchar", length = 128)
	public String getEss8() {
		return this.ess8;
	}

	public void setEss8(String ess8) {
		this.ess8 = ess8;
	}
	private String ess_ex;

	@Column(name = "ess_ex", nullable = true, columnDefinition = "varchar", length = 128)
	public String getEss_ex() {
		return this.ess_ex;
	}

	public void setEss_ex(String ess_ex) {
		this.ess_ex = ess_ex;
	}
	private String essa;

	@Column(name = "essa", nullable = true, columnDefinition = "varchar", length = 128)
	public String getEssa() {
		return this.essa;
	}

	public void setEssa(String essa) {
		this.essa = essa;
	}

	public String getStatusColor() {
		// 1. Если все рабочие поля (без headline) пусты → "blue"
		if (areAllFieldsEmpty()) {
			System.out.println("Все рабочие поля пусты");
			return "blue";
		}

		// 2. Если ess_ex = "2" (тест не проводился) → "red"
		if ("2".equals(ess_ex)) {
			System.out.println("ess_ex == '2' → тест не проводился");
			return "red";
		}

		// 3. Если ess_ex = "1" (тест проведён), проверяем обязательные поля
		if ("1".equals(ess_ex)) {
			if (areAllFieldsCompleted()) {
				System.out.println("Все обязательные поля заполнены");
				return "green";
			} else {
				System.out.println("Некоторые обязательные поля не заполнены");
				return "orange";
			}
		}

		// 4. Если ess_ex имеет иное значение, но какие-то рабочие поля заполнены → "orange"
		System.out.println("ess_ex имеет неизвестное значение, но форма заполнена частично");
		return "orange";
	}

	/**
	 * Проверяет, что все рабочие поля (без учета заголовков ess_instuction и ess_copyright)
	 * пусты. Если все пусты – форма не начата → "blue".
	 */
	private boolean areAllFieldsEmpty() {
		return isEmpty(ess_ex)
				&& isEmpty(essa)
				&& isEmpty(ess1)
				&& isEmpty(ess2)
				&& isEmpty(ess3)
				&& isEmpty(ess4)
				&& isEmpty(ess5)
				&& isEmpty(ess6)
				&& isEmpty(ess7)
				&& isEmpty(ess8);
	}

	/**
	 * Проверяет, что все обязательные рабочие поля заполнены (без учета заголовков).
	 */
	private boolean areAllFieldsCompleted() {
		boolean complete = true;
		if (isEmpty(ess_ex)) {
			System.out.println("Поле ess_ex не заполнено");
			complete = false;
		}
		if (isEmpty(essa)) {
			System.out.println("Поле essa не заполнено");
			complete = false;
		}
		if (isEmpty(ess1)) {
			System.out.println("Поле ess1 не заполнено");
			complete = false;
		}
		if (isEmpty(ess2)) {
			System.out.println("Поле ess2 не заполнено");
			complete = false;
		}
		if (isEmpty(ess3)) {
			System.out.println("Поле ess3 не заполнено");
			complete = false;
		}
		if (isEmpty(ess4)) {
			System.out.println("Поле ess4 не заполнено");
			complete = false;
		}
		if (isEmpty(ess5)) {
			System.out.println("Поле ess5 не заполнено");
			complete = false;
		}
		if (isEmpty(ess6)) {
			System.out.println("Поле ess6 не заполнено");
			complete = false;
		}
		if (isEmpty(ess7)) {
			System.out.println("Поле ess7 не заполнено");
			complete = false;
		}
		if (isEmpty(ess8)) {
			System.out.println("Поле ess8 не заполнено");
			complete = false;
		}
		return complete;
	}

	/**
	 * Проверяет, что хотя бы одно рабочее поле заполнено (без учета заголовков).
	 */
	private boolean isAtLeastOneFieldCompleted() {
		return !isEmpty(ess_ex)
				|| !isEmpty(essa)
				|| !isEmpty(ess1)
				|| !isEmpty(ess2)
				|| !isEmpty(ess3)
				|| !isEmpty(ess4)
				|| !isEmpty(ess5)
				|| !isEmpty(ess6)
				|| !isEmpty(ess7)
				|| !isEmpty(ess8);
	}

	/** Возвращает true, если строка пуста (null или только пробелы) */
	private boolean isEmpty(String value) {
		return value == null || value.trim().isEmpty() || value.trim().equals("-");
	}

}


//green if all items completed, red if ESS_ex=no, orange if some but not all, blue if none are completed