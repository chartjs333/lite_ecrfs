package net.mdsgene.admin.generatedproject;
import java.util.Date;
import javax.persistence.*;
@Entity
@Table(name = "PINK1PRKN123", schema = "public")
@Cacheable(false)
public class PINK1PRKN123 implements java.io.Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PINK1PRKN123_id_seq")
    @SequenceGenerator(name="PINK1PRKN123_id_seq", sequenceName="PINK1PRKN123_id_seq", allocationSize=1)
	@Column(name = "id", unique = true, nullable = false, columnDefinition = "serial")
	private int id;

	public PINK1PRKN123() {
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

	private String ositj_cat;

	@Column(name = "ositj_cat", nullable = true, columnDefinition = "varchar", length = 128)
	public String getOsitj_cat() {
		return this.ositj_cat;
	}

	public void setOsitj_cat(String ositj_cat) {
		this.ositj_cat = ositj_cat;
	}
	private String ositj_sc;

	@Column(name = "ositj_sc", nullable = true, columnDefinition = "varchar", length = 128)
	public String getOsitj_sc() {
		return this.ositj_sc;
	}

	public void setOsitj_sc(String ositj_sc) {
		this.ositj_sc = ositj_sc;
	}
	private String smell;

	@Column(name = "smell", nullable = true, columnDefinition = "varchar", length = 128)
	public String getSmell() {
		return this.smell;
	}

	public void setSmell(String smell) {
		this.smell = smell;
	}
	private String tibsit_cat;

	@Column(name = "tibsit_cat", nullable = true, columnDefinition = "varchar", length = 128)
	public String getTibsit_cat() {
		return this.tibsit_cat;
	}

	public void setTibsit_cat(String tibsit_cat) {
		this.tibsit_cat = tibsit_cat;
	}
	private String tibsit_sc;

	@Column(name = "tibsit_sc", nullable = true, columnDefinition = "varchar", length = 128)
	public String getTibsit_sc() {
		return this.tibsit_sc;
	}

	public void setTibsit_sc(String tibsit_sc) {
		this.tibsit_sc = tibsit_sc;
	}
	private String upsit_1;

	@Column(name = "upsit_1", nullable = true, columnDefinition = "varchar", length = 128)
	public String getUpsit_1() {
		return this.upsit_1;
	}

	public void setUpsit_1(String upsit_1) {
		this.upsit_1 = upsit_1;
	}
	private String upsit_10;

	@Column(name = "upsit_10", nullable = true, columnDefinition = "varchar", length = 128)
	public String getUpsit_10() {
		return this.upsit_10;
	}

	public void setUpsit_10(String upsit_10) {
		this.upsit_10 = upsit_10;
	}
	private String upsit_11;

	@Column(name = "upsit_11", nullable = true, columnDefinition = "varchar", length = 128)
	public String getUpsit_11() {
		return this.upsit_11;
	}

	public void setUpsit_11(String upsit_11) {
		this.upsit_11 = upsit_11;
	}
	private String upsit_12;

	@Column(name = "upsit_12", nullable = true, columnDefinition = "varchar", length = 128)
	public String getUpsit_12() {
		return this.upsit_12;
	}

	public void setUpsit_12(String upsit_12) {
		this.upsit_12 = upsit_12;
	}
	private String upsit_13;

	@Column(name = "upsit_13", nullable = true, columnDefinition = "varchar", length = 128)
	public String getUpsit_13() {
		return this.upsit_13;
	}

	public void setUpsit_13(String upsit_13) {
		this.upsit_13 = upsit_13;
	}
	private String upsit_14;

	@Column(name = "upsit_14", nullable = true, columnDefinition = "varchar", length = 128)
	public String getUpsit_14() {
		return this.upsit_14;
	}

	public void setUpsit_14(String upsit_14) {
		this.upsit_14 = upsit_14;
	}
	private String upsit_15;

	@Column(name = "upsit_15", nullable = true, columnDefinition = "varchar", length = 128)
	public String getUpsit_15() {
		return this.upsit_15;
	}

	public void setUpsit_15(String upsit_15) {
		this.upsit_15 = upsit_15;
	}
	private String upsit_16;

	@Column(name = "upsit_16", nullable = true, columnDefinition = "varchar", length = 128)
	public String getUpsit_16() {
		return this.upsit_16;
	}

	public void setUpsit_16(String upsit_16) {
		this.upsit_16 = upsit_16;
	}
	private String upsit_17;

	@Column(name = "upsit_17", nullable = true, columnDefinition = "varchar", length = 128)
	public String getUpsit_17() {
		return this.upsit_17;
	}

	public void setUpsit_17(String upsit_17) {
		this.upsit_17 = upsit_17;
	}
	private String upsit_18;

	@Column(name = "upsit_18", nullable = true, columnDefinition = "varchar", length = 128)
	public String getUpsit_18() {
		return this.upsit_18;
	}

	public void setUpsit_18(String upsit_18) {
		this.upsit_18 = upsit_18;
	}
	private String upsit_19;

	@Column(name = "upsit_19", nullable = true, columnDefinition = "varchar", length = 128)
	public String getUpsit_19() {
		return this.upsit_19;
	}

	public void setUpsit_19(String upsit_19) {
		this.upsit_19 = upsit_19;
	}
	private String upsit_2;

	@Column(name = "upsit_2", nullable = true, columnDefinition = "varchar", length = 128)
	public String getUpsit_2() {
		return this.upsit_2;
	}

	public void setUpsit_2(String upsit_2) {
		this.upsit_2 = upsit_2;
	}
	private String upsit_20;

	@Column(name = "upsit_20", nullable = true, columnDefinition = "varchar", length = 128)
	public String getUpsit_20() {
		return this.upsit_20;
	}

	public void setUpsit_20(String upsit_20) {
		this.upsit_20 = upsit_20;
	}
	private String upsit_21;

	@Column(name = "upsit_21", nullable = true, columnDefinition = "varchar", length = 128)
	public String getUpsit_21() {
		return this.upsit_21;
	}

	public void setUpsit_21(String upsit_21) {
		this.upsit_21 = upsit_21;
	}
	private String upsit_22;

	@Column(name = "upsit_22", nullable = true, columnDefinition = "varchar", length = 128)
	public String getUpsit_22() {
		return this.upsit_22;
	}

	public void setUpsit_22(String upsit_22) {
		this.upsit_22 = upsit_22;
	}
	private String upsit_23;

	@Column(name = "upsit_23", nullable = true, columnDefinition = "varchar", length = 128)
	public String getUpsit_23() {
		return this.upsit_23;
	}

	public void setUpsit_23(String upsit_23) {
		this.upsit_23 = upsit_23;
	}
	private String upsit_24;

	@Column(name = "upsit_24", nullable = true, columnDefinition = "varchar", length = 128)
	public String getUpsit_24() {
		return this.upsit_24;
	}

	public void setUpsit_24(String upsit_24) {
		this.upsit_24 = upsit_24;
	}
	private String upsit_25;

	@Column(name = "upsit_25", nullable = true, columnDefinition = "varchar", length = 128)
	public String getUpsit_25() {
		return this.upsit_25;
	}

	public void setUpsit_25(String upsit_25) {
		this.upsit_25 = upsit_25;
	}
	private String upsit_26;

	@Column(name = "upsit_26", nullable = true, columnDefinition = "varchar", length = 128)
	public String getUpsit_26() {
		return this.upsit_26;
	}

	public void setUpsit_26(String upsit_26) {
		this.upsit_26 = upsit_26;
	}
	private String upsit_27;

	@Column(name = "upsit_27", nullable = true, columnDefinition = "varchar", length = 128)
	public String getUpsit_27() {
		return this.upsit_27;
	}

	public void setUpsit_27(String upsit_27) {
		this.upsit_27 = upsit_27;
	}
	private String upsit_28;

	@Column(name = "upsit_28", nullable = true, columnDefinition = "varchar", length = 128)
	public String getUpsit_28() {
		return this.upsit_28;
	}

	public void setUpsit_28(String upsit_28) {
		this.upsit_28 = upsit_28;
	}
	private String upsit_29;

	@Column(name = "upsit_29", nullable = true, columnDefinition = "varchar", length = 128)
	public String getUpsit_29() {
		return this.upsit_29;
	}

	public void setUpsit_29(String upsit_29) {
		this.upsit_29 = upsit_29;
	}
	private String upsit_3;

	@Column(name = "upsit_3", nullable = true, columnDefinition = "varchar", length = 128)
	public String getUpsit_3() {
		return this.upsit_3;
	}

	public void setUpsit_3(String upsit_3) {
		this.upsit_3 = upsit_3;
	}
	private String upsit_30;

	@Column(name = "upsit_30", nullable = true, columnDefinition = "varchar", length = 128)
	public String getUpsit_30() {
		return this.upsit_30;
	}

	public void setUpsit_30(String upsit_30) {
		this.upsit_30 = upsit_30;
	}
	private String upsit_31;

	@Column(name = "upsit_31", nullable = true, columnDefinition = "varchar", length = 128)
	public String getUpsit_31() {
		return this.upsit_31;
	}

	public void setUpsit_31(String upsit_31) {
		this.upsit_31 = upsit_31;
	}
	private String upsit_32;

	@Column(name = "upsit_32", nullable = true, columnDefinition = "varchar", length = 128)
	public String getUpsit_32() {
		return this.upsit_32;
	}

	public void setUpsit_32(String upsit_32) {
		this.upsit_32 = upsit_32;
	}
	private String upsit_33;

	@Column(name = "upsit_33", nullable = true, columnDefinition = "varchar", length = 128)
	public String getUpsit_33() {
		return this.upsit_33;
	}

	public void setUpsit_33(String upsit_33) {
		this.upsit_33 = upsit_33;
	}
	private String upsit_34;

	@Column(name = "upsit_34", nullable = true, columnDefinition = "varchar", length = 128)
	public String getUpsit_34() {
		return this.upsit_34;
	}

	public void setUpsit_34(String upsit_34) {
		this.upsit_34 = upsit_34;
	}
	private String upsit_35;

	@Column(name = "upsit_35", nullable = true, columnDefinition = "varchar", length = 128)
	public String getUpsit_35() {
		return this.upsit_35;
	}

	public void setUpsit_35(String upsit_35) {
		this.upsit_35 = upsit_35;
	}
	private String upsit_36;

	@Column(name = "upsit_36", nullable = true, columnDefinition = "varchar", length = 128)
	public String getUpsit_36() {
		return this.upsit_36;
	}

	public void setUpsit_36(String upsit_36) {
		this.upsit_36 = upsit_36;
	}
	private String upsit_37;

	@Column(name = "upsit_37", nullable = true, columnDefinition = "varchar", length = 128)
	public String getUpsit_37() {
		return this.upsit_37;
	}

	public void setUpsit_37(String upsit_37) {
		this.upsit_37 = upsit_37;
	}
	private String upsit_38;

	@Column(name = "upsit_38", nullable = true, columnDefinition = "varchar", length = 128)
	public String getUpsit_38() {
		return this.upsit_38;
	}

	public void setUpsit_38(String upsit_38) {
		this.upsit_38 = upsit_38;
	}
	private String upsit_39;

	@Column(name = "upsit_39", nullable = true, columnDefinition = "varchar", length = 128)
	public String getUpsit_39() {
		return this.upsit_39;
	}

	public void setUpsit_39(String upsit_39) {
		this.upsit_39 = upsit_39;
	}
	private String upsit_4;

	@Column(name = "upsit_4", nullable = true, columnDefinition = "varchar", length = 128)
	public String getUpsit_4() {
		return this.upsit_4;
	}

	public void setUpsit_4(String upsit_4) {
		this.upsit_4 = upsit_4;
	}
	private String upsit_40;

	@Column(name = "upsit_40", nullable = true, columnDefinition = "varchar", length = 128)
	public String getUpsit_40() {
		return this.upsit_40;
	}

	public void setUpsit_40(String upsit_40) {
		this.upsit_40 = upsit_40;
	}
	private String upsit_5;

	@Column(name = "upsit_5", nullable = true, columnDefinition = "varchar", length = 128)
	public String getUpsit_5() {
		return this.upsit_5;
	}

	public void setUpsit_5(String upsit_5) {
		this.upsit_5 = upsit_5;
	}
	private String upsit_6;

	@Column(name = "upsit_6", nullable = true, columnDefinition = "varchar", length = 128)
	public String getUpsit_6() {
		return this.upsit_6;
	}

	public void setUpsit_6(String upsit_6) {
		this.upsit_6 = upsit_6;
	}
	private String upsit_7;

	@Column(name = "upsit_7", nullable = true, columnDefinition = "varchar", length = 128)
	public String getUpsit_7() {
		return this.upsit_7;
	}

	public void setUpsit_7(String upsit_7) {
		this.upsit_7 = upsit_7;
	}
	private String upsit_8;

	@Column(name = "upsit_8", nullable = true, columnDefinition = "varchar", length = 128)
	public String getUpsit_8() {
		return this.upsit_8;
	}

	public void setUpsit_8(String upsit_8) {
		this.upsit_8 = upsit_8;
	}
	private String upsit_9;

	@Column(name = "upsit_9", nullable = true, columnDefinition = "varchar", length = 128)
	public String getUpsit_9() {
		return this.upsit_9;
	}

	public void setUpsit_9(String upsit_9) {
		this.upsit_9 = upsit_9;
	}
	private String upsit_ex;

	@Column(name = "upsit_ex", nullable = true, columnDefinition = "varchar", length = 128)
	public String getUpsit_ex() {
		return this.upsit_ex;
	}

	public void setUpsit_ex(String upsit_ex) {
		this.upsit_ex = upsit_ex;
	}
	private String upsit_lang;

	@Column(name = "upsit_lang", nullable = true, columnDefinition = "varchar", length = 128)
	public String getUpsit_lang() {
		return this.upsit_lang;
	}

	public void setUpsit_lang(String upsit_lang) {
		this.upsit_lang = upsit_lang;
	}

	public String getStatusColor() {
		// Если ни одно рабочее поле (без заголовков) не заполнено, считаем форму не начатой – "blue"
		if (areAllFieldsEmpty()) {
			System.out.println("Все рабочие поля (без headline) пусты");
			return "blue";
		}

		// Если тест не проводился – upsit_ex = "no" (без учета регистра) – возвращаем "red"
		if ("no".equalsIgnoreCase(this.upsit_ex)) {
			System.out.println("upsit_ex == 'no' → тест не проводился");
			return "red";
		}

		// Если все обязательные поля заполнены – возвращаем "green"
		if (areAllFieldsCompleted()) {
			System.out.println("Все обязательные поля заполнены → green");
			return "green";
		}

		// Если заполнено хотя бы одно рабочее поле – возвращаем "orange"
		if (isAtLeastOneFieldCompleted()) {
			System.out.println("Некоторые рабочие поля заполнены → orange");
			return "orange";
		}

		// В противном случае – "blue"
		System.out.println("Нет заполненных рабочих полей → blue");
		return "blue";
	}

	/**
	 * Проверяет, что все рабочие поля (исключая headline_1, headline_2, headline_3) пусты.
	 */
	private boolean areAllFieldsEmpty() {
		return isEmpty(smell)
				&& isEmpty(upsit_ex)
				&& isEmpty(upsit_lang)
				&& isEmpty(upsit_1)
				&& isEmpty(upsit_2)
				&& isEmpty(upsit_3)
				&& isEmpty(upsit_4)
				&& isEmpty(upsit_5)
				&& isEmpty(upsit_6)
				&& isEmpty(upsit_7)
				&& isEmpty(upsit_8)
				&& isEmpty(upsit_9)
				&& isEmpty(upsit_10)
				&& isEmpty(upsit_11)
				&& isEmpty(upsit_12)
				&& isEmpty(upsit_13)
				&& isEmpty(upsit_14)
				&& isEmpty(upsit_15)
				&& isEmpty(upsit_16)
				&& isEmpty(upsit_17)
				&& isEmpty(upsit_18)
				&& isEmpty(upsit_19)
				&& isEmpty(upsit_20)
				&& isEmpty(upsit_21)
				&& isEmpty(upsit_22)
				&& isEmpty(upsit_23)
				&& isEmpty(upsit_24)
				&& isEmpty(upsit_25)
				&& isEmpty(upsit_26)
				&& isEmpty(upsit_27)
				&& isEmpty(upsit_28)
				&& isEmpty(upsit_29)
				&& isEmpty(upsit_30)
				&& isEmpty(upsit_31)
				&& isEmpty(upsit_32)
				&& isEmpty(upsit_33)
				&& isEmpty(upsit_34)
				&& isEmpty(upsit_35)
				&& isEmpty(upsit_36)
				&& isEmpty(upsit_37)
				&& isEmpty(upsit_38)
				&& isEmpty(upsit_39)
				&& isEmpty(upsit_40)
				// Не учитываем headline_1, headline_2, headline_3
				&& isEmpty(tibsit_sc)
				&& isEmpty(tibsit_cat)
				&& isEmpty(ositj_sc)
				&& isEmpty(ositj_cat);
	}

	/**
	 * Проверяет, что все обязательные рабочие поля заполнены (исключая заголовки).
	 */
	private boolean areAllFieldsCompleted() {
		boolean complete = true;
		if (isEmpty(smell)) {
			System.out.println("Поле smell не заполнено");
			complete = false;
		}
		if (isEmpty(upsit_ex)) {
			System.out.println("Поле upsit_ex не заполнено");
			complete = false;
		}
		if (isEmpty(upsit_lang)) {
			System.out.println("Поле upsit_lang не заполнено");
			complete = false;
		}
		if (isEmpty(upsit_1)) {
			System.out.println("Поле upsit_1 не заполнено");
			complete = false;
		}
		if (isEmpty(upsit_2)) {
			System.out.println("Поле upsit_2 не заполнено");
			complete = false;
		}
		if (isEmpty(upsit_3)) {
			System.out.println("Поле upsit_3 не заполнено");
			complete = false;
		}
		if (isEmpty(upsit_4)) {
			System.out.println("Поле upsit_4 не заполнено");
			complete = false;
		}
		if (isEmpty(upsit_5)) {
			System.out.println("Поле upsit_5 не заполнено");
			complete = false;
		}
		if (isEmpty(upsit_6)) {
			System.out.println("Поле upsit_6 не заполнено");
			complete = false;
		}
		if (isEmpty(upsit_7)) {
			System.out.println("Поле upsit_7 не заполнено");
			complete = false;
		}
		if (isEmpty(upsit_8)) {
			System.out.println("Поле upsit_8 не заполнено");
			complete = false;
		}
		if (isEmpty(upsit_9)) {
			System.out.println("Поле upsit_9 не заполнено");
			complete = false;
		}
		if (isEmpty(upsit_10)) {
			System.out.println("Поле upsit_10 не заполнено");
			complete = false;
		}
		if (isEmpty(upsit_11)) {
			System.out.println("Поле upsit_11 не заполнено");
			complete = false;
		}
		if (isEmpty(upsit_12)) {
			System.out.println("Поле upsit_12 не заполнено");
			complete = false;
		}
		if (isEmpty(upsit_13)) {
			System.out.println("Поле upsit_13 не заполнено");
			complete = false;
		}
		if (isEmpty(upsit_14)) {
			System.out.println("Поле upsit_14 не заполнено");
			complete = false;
		}
		if (isEmpty(upsit_15)) {
			System.out.println("Поле upsit_15 не заполнено");
			complete = false;
		}
		if (isEmpty(upsit_16)) {
			System.out.println("Поле upsit_16 не заполнено");
			complete = false;
		}
		if (isEmpty(upsit_17)) {
			System.out.println("Поле upsit_17 не заполнено");
			complete = false;
		}
		if (isEmpty(upsit_18)) {
			System.out.println("Поле upsit_18 не заполнено");
			complete = false;
		}
		if (isEmpty(upsit_19)) {
			System.out.println("Поле upsit_19 не заполнено");
			complete = false;
		}
		if (isEmpty(upsit_20)) {
			System.out.println("Поле upsit_20 не заполнено");
			complete = false;
		}
		if (isEmpty(upsit_21)) {
			System.out.println("Поле upsit_21 не заполнено");
			complete = false;
		}
		if (isEmpty(upsit_22)) {
			System.out.println("Поле upsit_22 не заполнено");
			complete = false;
		}
		if (isEmpty(upsit_23)) {
			System.out.println("Поле upsit_23 не заполнено");
			complete = false;
		}
		if (isEmpty(upsit_24)) {
			System.out.println("Поле upsit_24 не заполнено");
			complete = false;
		}
		if (isEmpty(upsit_25)) {
			System.out.println("Поле upsit_25 не заполнено");
			complete = false;
		}
		if (isEmpty(upsit_26)) {
			System.out.println("Поле upsit_26 не заполнено");
			complete = false;
		}
		if (isEmpty(upsit_27)) {
			System.out.println("Поле upsit_27 не заполнено");
			complete = false;
		}
		if (isEmpty(upsit_28)) {
			System.out.println("Поле upsit_28 не заполнено");
			complete = false;
		}
		if (isEmpty(upsit_29)) {
			System.out.println("Поле upsit_29 не заполнено");
			complete = false;
		}
		if (isEmpty(upsit_30)) {
			System.out.println("Поле upsit_30 не заполнено");
			complete = false;
		}
		if (isEmpty(upsit_31)) {
			System.out.println("Поле upsit_31 не заполнено");
			complete = false;
		}
		if (isEmpty(upsit_32)) {
			System.out.println("Поле upsit_32 не заполнено");
			complete = false;
		}
		if (isEmpty(upsit_33)) {
			System.out.println("Поле upsit_33 не заполнено");
			complete = false;
		}
		if (isEmpty(upsit_34)) {
			System.out.println("Поле upsit_34 не заполнено");
			complete = false;
		}
		if (isEmpty(upsit_35)) {
			System.out.println("Поле upsit_35 не заполнено");
			complete = false;
		}
		if (isEmpty(upsit_36)) {
			System.out.println("Поле upsit_36 не заполнено");
			complete = false;
		}
		if (isEmpty(upsit_37)) {
			System.out.println("Поле upsit_37 не заполнено");
			complete = false;
		}
		if (isEmpty(upsit_38)) {
			System.out.println("Поле upsit_38 не заполнено");
			complete = false;
		}
		if (isEmpty(upsit_39)) {
			System.out.println("Поле upsit_39 не заполнено");
			complete = false;
		}
		if (isEmpty(upsit_40)) {
			System.out.println("Поле upsit_40 не заполнено");
			complete = false;
		}
		if (isEmpty(tibsit_sc)) {
			System.out.println("Поле tibsit_sc не заполнено");
			complete = false;
		}
		if (isEmpty(tibsit_cat)) {
			System.out.println("Поле tibsit_cat не заполнено");
			complete = false;
		}
		if (isEmpty(ositj_sc)) {
			System.out.println("Поле ositj_sc не заполнено");
			complete = false;
		}
		if (isEmpty(ositj_cat)) {
			System.out.println("Поле ositj_cat не заполнено");
			complete = false;
		}
		return complete;
	}

	/**
	 * Проверяет, что хотя бы одно рабочее поле заполнено (исключая headline_1, headline_2, headline_3).
	 */
	private boolean isAtLeastOneFieldCompleted() {
		return !isEmpty(smell)
				|| !isEmpty(upsit_ex)
				|| !isEmpty(upsit_lang)
				|| !isEmpty(upsit_1)
				|| !isEmpty(upsit_2)
				|| !isEmpty(upsit_3)
				|| !isEmpty(upsit_4)
				|| !isEmpty(upsit_5)
				|| !isEmpty(upsit_6)
				|| !isEmpty(upsit_7)
				|| !isEmpty(upsit_8)
				|| !isEmpty(upsit_9)
				|| !isEmpty(upsit_10)
				|| !isEmpty(upsit_11)
				|| !isEmpty(upsit_12)
				|| !isEmpty(upsit_13)
				|| !isEmpty(upsit_14)
				|| !isEmpty(upsit_15)
				|| !isEmpty(upsit_16)
				|| !isEmpty(upsit_17)
				|| !isEmpty(upsit_18)
				|| !isEmpty(upsit_19)
				|| !isEmpty(upsit_20)
				|| !isEmpty(upsit_21)
				|| !isEmpty(upsit_22)
				|| !isEmpty(upsit_23)
				|| !isEmpty(upsit_24)
				|| !isEmpty(upsit_25)
				|| !isEmpty(upsit_26)
				|| !isEmpty(upsit_27)
				|| !isEmpty(upsit_28)
				|| !isEmpty(upsit_29)
				|| !isEmpty(upsit_30)
				|| !isEmpty(upsit_31)
				|| !isEmpty(upsit_32)
				|| !isEmpty(upsit_33)
				|| !isEmpty(upsit_34)
				|| !isEmpty(upsit_35)
				|| !isEmpty(upsit_36)
				|| !isEmpty(upsit_37)
				|| !isEmpty(upsit_38)
				|| !isEmpty(upsit_39)
				|| !isEmpty(upsit_40)
				|| !isEmpty(tibsit_sc)
				|| !isEmpty(tibsit_cat)
				|| !isEmpty(ositj_sc)
				|| !isEmpty(ositj_cat);
	}

	/**
	 * Проверяет, что строка val пустая (null или только пробелы).
	 */
	private boolean isEmpty(String val) {
		return (val == null || val.trim().isEmpty()) || "-".equals(val.trim());
	}

}


