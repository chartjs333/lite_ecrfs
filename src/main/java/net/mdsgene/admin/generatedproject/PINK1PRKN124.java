package net.mdsgene.admin.generatedproject;
import java.util.Date;
import javax.persistence.*;
@Entity
@Table(name = "PINK1PRKN124", schema = "public")
@Cacheable(false)
public class PINK1PRKN124 implements java.io.Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PINK1PRKN124_id_seq")
    @SequenceGenerator(name="PINK1PRKN124_id_seq", sequenceName="PINK1PRKN124_id_seq", allocationSize=1)
	@Column(name = "id", unique = true, nullable = false, columnDefinition = "serial")
	private int id;

	public PINK1PRKN124() {
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

	private String Rbdq_6_1;

	@Column(name = "Rbdq_6_1", nullable = true, columnDefinition = "varchar", length = 128)
	public String getRbdq_6_1() {
		return this.Rbdq_6_1;
	}

	public void setRbdq_6_1(String Rbdq_6_1) {
		this.Rbdq_6_1 = Rbdq_6_1;
	}
	private String Rbdq_6_2;

	@Column(name = "Rbdq_6_2", nullable = true, columnDefinition = "varchar", length = 128)
	public String getRbdq_6_2() {
		return this.Rbdq_6_2;
	}

	public void setRbdq_6_2(String Rbdq_6_2) {
		this.Rbdq_6_2 = Rbdq_6_2;
	}
	private String Rbdq_6_3;

	@Column(name = "Rbdq_6_3", nullable = true, columnDefinition = "varchar", length = 128)
	public String getRbdq_6_3() {
		return this.Rbdq_6_3;
	}

	public void setRbdq_6_3(String Rbdq_6_3) {
		this.Rbdq_6_3 = Rbdq_6_3;
	}
	private String Rbdq_6_4;

	@Column(name = "Rbdq_6_4", nullable = true, columnDefinition = "varchar", length = 128)
	public String getRbdq_6_4() {
		return this.Rbdq_6_4;
	}

	public void setRbdq_6_4(String Rbdq_6_4) {
		this.Rbdq_6_4 = Rbdq_6_4;
	}
	private String rbdq_1;

	@Column(name = "rbdq_1", nullable = true, columnDefinition = "varchar", length = 128)
	public String getRbdq_1() {
		return this.rbdq_1;
	}

	public void setRbdq_1(String rbdq_1) {
		this.rbdq_1 = rbdq_1;
	}
	private String rbdq_10a;

	@Column(name = "rbdq_10a", nullable = true, columnDefinition = "varchar", length = 128)
	public String getRbdq_10a() {
		return this.rbdq_10a;
	}

	public void setRbdq_10a(String rbdq_10a) {
		this.rbdq_10a = rbdq_10a;
	}
	private String rbdq_10b;

	@Column(name = "rbdq_10b", nullable = true, columnDefinition = "varchar", length = 128)
	public String getRbdq_10b() {
		return this.rbdq_10b;
	}

	public void setRbdq_10b(String rbdq_10b) {
		this.rbdq_10b = rbdq_10b;
	}
	private String rbdq_10c;

	@Column(name = "rbdq_10c", nullable = true, columnDefinition = "varchar", length = 128)
	public String getRbdq_10c() {
		return this.rbdq_10c;
	}

	public void setRbdq_10c(String rbdq_10c) {
		this.rbdq_10c = rbdq_10c;
	}
	private String rbdq_10d;

	@Column(name = "rbdq_10d", nullable = true, columnDefinition = "varchar", length = 128)
	public String getRbdq_10d() {
		return this.rbdq_10d;
	}

	public void setRbdq_10d(String rbdq_10d) {
		this.rbdq_10d = rbdq_10d;
	}
	private String rbdq_10e;

	@Column(name = "rbdq_10e", nullable = true, columnDefinition = "varchar", length = 128)
	public String getRbdq_10e() {
		return this.rbdq_10e;
	}

	public void setRbdq_10e(String rbdq_10e) {
		this.rbdq_10e = rbdq_10e;
	}
	private String rbdq_10f;

	@Column(name = "rbdq_10f", nullable = true, columnDefinition = "varchar", length = 128)
	public String getRbdq_10f() {
		return this.rbdq_10f;
	}

	public void setRbdq_10f(String rbdq_10f) {
		this.rbdq_10f = rbdq_10f;
	}
	private String rbdq_10g;

	@Column(name = "rbdq_10g", nullable = true, columnDefinition = "varchar", length = 128)
	public String getRbdq_10g() {
		return this.rbdq_10g;
	}

	public void setRbdq_10g(String rbdq_10g) {
		this.rbdq_10g = rbdq_10g;
	}
	private String rbdq_10h;

	@Column(name = "rbdq_10h", nullable = true, columnDefinition = "varchar", length = 128)
	public String getRbdq_10h() {
		return this.rbdq_10h;
	}

	public void setRbdq_10h(String rbdq_10h) {
		this.rbdq_10h = rbdq_10h;
	}
	private String rbdq_10i;

	@Column(name = "rbdq_10i", nullable = true, columnDefinition = "varchar", length = 128)
	public String getRbdq_10i() {
		return this.rbdq_10i;
	}

	public void setRbdq_10i(String rbdq_10i) {
		this.rbdq_10i = rbdq_10i;
	}
	private String rbdq_2;

	@Column(name = "rbdq_2", nullable = true, columnDefinition = "varchar", length = 128)
	public String getRbdq_2() {
		return this.rbdq_2;
	}

	public void setRbdq_2(String rbdq_2) {
		this.rbdq_2 = rbdq_2;
	}
	private String rbdq_3;

	@Column(name = "rbdq_3", nullable = true, columnDefinition = "varchar", length = 128)
	public String getRbdq_3() {
		return this.rbdq_3;
	}

	public void setRbdq_3(String rbdq_3) {
		this.rbdq_3 = rbdq_3;
	}
	private String rbdq_4;

	@Column(name = "rbdq_4", nullable = true, columnDefinition = "varchar", length = 128)
	public String getRbdq_4() {
		return this.rbdq_4;
	}

	public void setRbdq_4(String rbdq_4) {
		this.rbdq_4 = rbdq_4;
	}
	private String rbdq_5;

	@Column(name = "rbdq_5", nullable = true, columnDefinition = "varchar", length = 128)
	public String getRbdq_5() {
		return this.rbdq_5;
	}

	public void setRbdq_5(String rbdq_5) {
		this.rbdq_5 = rbdq_5;
	}
	private String rbdq_7;

	@Column(name = "rbdq_7", nullable = true, columnDefinition = "varchar", length = 128)
	public String getRbdq_7() {
		return this.rbdq_7;
	}

	public void setRbdq_7(String rbdq_7) {
		this.rbdq_7 = rbdq_7;
	}
	private String rbdq_8;

	@Column(name = "rbdq_8", nullable = true, columnDefinition = "varchar", length = 128)
	public String getRbdq_8() {
		return this.rbdq_8;
	}

	public void setRbdq_8(String rbdq_8) {
		this.rbdq_8 = rbdq_8;
	}
	private String rbdq_9;

	@Column(name = "rbdq_9", nullable = true, columnDefinition = "varchar", length = 128)
	public String getRbdq_9() {
		return this.rbdq_9;
	}

	public void setRbdq_9(String rbdq_9) {
		this.rbdq_9 = rbdq_9;
	}
	private String rbdq_ex;

	@Column(name = "rbdq_ex", nullable = true, columnDefinition = "varchar", length = 128)
	public String getRbdq_ex() {
		return this.rbdq_ex;
	}

	public void setRbdq_ex(String rbdq_ex) {
		this.rbdq_ex = rbdq_ex;
	}
	private String rbdq_who;

	@Column(name = "rbdq_who", nullable = true, columnDefinition = "varchar", length = 128)
	public String getRbdq_who() {
		return this.rbdq_who;
	}

	public void setRbdq_who(String rbdq_who) {
		this.rbdq_who = rbdq_who;
	}


	public String getStatusColor() {
		// Проверяем, заполнены ли все обязательные поля (без заголовков)
		boolean allCompleted = areAllFieldsCompleted();
		// Проверяем, заполнено ли хотя бы одно поле
		boolean atLeastOneCompleted = isAtLeastOneFieldCompleted();

		// Если значение rbdq_ex равно "2" (согласно логике "no") – возвращаем красный
		if ("2".equalsIgnoreCase(this.rbdq_ex)) {
			System.out.println("rbdq_ex == '2' → тест не проведён (red)");
			return "red";
		} else if (allCompleted) {
			System.out.println("Все обязательные поля заполнены → green");
			return "green";
		} else if (atLeastOneCompleted) {
			System.out.println("Заполнены некоторые поля → orange");
			return "orange";
		} else {
			System.out.println("Ни одно поле не заполнено → blue");
			return "blue";
		}
	}

	/**
	 * Проверяет, что все обязательные поля заполнены.
	 * Из проверки исключены поля‑заголовки: rbdq_6_headline, rbdq_10_headline, rbdq_copyright.
	 */
	private boolean areAllFieldsCompleted() {
		boolean complete = true;
		if (isEmpty(this.Rbdq_6_1)) {
			System.out.println("Поле Rbdq_6_1 не заполнено");
			complete = false;
		}
		if (isEmpty(this.Rbdq_6_2)) {
			System.out.println("Поле Rbdq_6_2 не заполнено");
			complete = false;
		}
		if (isEmpty(this.Rbdq_6_3)) {
			System.out.println("Поле Rbdq_6_3 не заполнено");
			complete = false;
		}
		if (isEmpty(this.Rbdq_6_4)) {
			System.out.println("Поле Rbdq_6_4 не заполнено");
			complete = false;
		}
		if (isEmpty(this.rbdq_1)) {
			System.out.println("Поле rbdq_1 не заполнено");
			complete = false;
		}
		if (isEmpty(this.rbdq_10a)) {
			System.out.println("Поле rbdq_10a не заполнено");
			complete = false;
		}
		if (isEmpty(this.rbdq_10b)) {
			System.out.println("Поле rbdq_10b не заполнено");
			complete = false;
		}
		if (isEmpty(this.rbdq_10c)) {
			System.out.println("Поле rbdq_10c не заполнено");
			complete = false;
		}
		if (isEmpty(this.rbdq_10d)) {
			System.out.println("Поле rbdq_10d не заполнено");
			complete = false;
		}
		if (isEmpty(this.rbdq_10e)) {
			System.out.println("Поле rbdq_10e не заполнено");
			complete = false;
		}
		if (isEmpty(this.rbdq_10f)) {
			System.out.println("Поле rbdq_10f не заполнено");
			complete = false;
		}
		if (isEmpty(this.rbdq_10g)) {
			System.out.println("Поле rbdq_10g не заполнено");
			complete = false;
		}
		if (isEmpty(this.rbdq_10h)) {
			System.out.println("Поле rbdq_10h не заполнено");
			complete = false;
		}
		if (isEmpty(this.rbdq_10i)) {
			System.out.println("Поле rbdq_10i не заполнено");
			complete = false;
		}
		if (isEmpty(this.rbdq_2)) {
			System.out.println("Поле rbdq_2 не заполнено");
			complete = false;
		}
		if (isEmpty(this.rbdq_3)) {
			System.out.println("Поле rbdq_3 не заполнено");
			complete = false;
		}
		if (isEmpty(this.rbdq_4)) {
			System.out.println("Поле rbdq_4 не заполнено");
			complete = false;
		}
		if (isEmpty(this.rbdq_5)) {
			System.out.println("Поле rbdq_5 не заполнено");
			complete = false;
		}
		if (isEmpty(this.rbdq_7)) {
			System.out.println("Поле rbdq_7 не заполнено");
			complete = false;
		}
		if (isEmpty(this.rbdq_8)) {
			System.out.println("Поле rbdq_8 не заполнено");
			complete = false;
		}
		if (isEmpty(this.rbdq_9)) {
			System.out.println("Поле rbdq_9 не заполнено");
			complete = false;
		}
		if (isEmpty(this.rbdq_ex)) {
			System.out.println("Поле rbdq_ex не заполнено");
			complete = false;
		}
		if (isEmpty(this.rbdq_who)) {
			System.out.println("Поле rbdq_who не заполнено");
			complete = false;
		}
		return complete;
	}

	/**
	 * Проверяет, заполнено ли хотя бы одно из обязательных полей (без заголовков).
	 */
	private boolean isAtLeastOneFieldCompleted() {
		return !isEmpty(this.Rbdq_6_1)
				|| !isEmpty(this.Rbdq_6_2)
				|| !isEmpty(this.Rbdq_6_3)
				|| !isEmpty(this.Rbdq_6_4)
				|| !isEmpty(this.rbdq_1)
				|| !isEmpty(this.rbdq_10a)
				|| !isEmpty(this.rbdq_10b)
				|| !isEmpty(this.rbdq_10c)
				|| !isEmpty(this.rbdq_10d)
				|| !isEmpty(this.rbdq_10e)
				|| !isEmpty(this.rbdq_10f)
				|| !isEmpty(this.rbdq_10g)
				|| !isEmpty(this.rbdq_10h)
				|| !isEmpty(this.rbdq_10i)
				|| !isEmpty(this.rbdq_2)
				|| !isEmpty(this.rbdq_3)
				|| !isEmpty(this.rbdq_4)
				|| !isEmpty(this.rbdq_5)
				|| !isEmpty(this.rbdq_7)
				|| !isEmpty(this.rbdq_8)
				|| !isEmpty(this.rbdq_9)
				|| !isEmpty(this.rbdq_ex)
				|| !isEmpty(this.rbdq_who);
	}

	/** Возвращает true, если значение null или состоит только из пробелов */
	private boolean isEmpty(String value) {
		return value == null || value.trim().isEmpty() || value.trim().equals("-");
	}

}

//green if all items completed, red if RBDQ_ex=no, orange if some but not all, blue if none are completed


