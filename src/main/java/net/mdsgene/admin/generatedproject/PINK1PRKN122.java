package net.mdsgene.admin.generatedproject;
import java.util.Date;
import javax.persistence.*;
@Entity
@Table(name = "PINK1PRKN122", schema = "public")
@Cacheable(false)
public class PINK1PRKN122 implements java.io.Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PINK1PRKN122_id_seq")
    @SequenceGenerator(name="PINK1PRKN122_id_seq", sequenceName="PINK1PRKN122_id_seq", allocationSize=1)
	@Column(name = "id", unique = true, nullable = false, columnDefinition = "serial")
	private int id;

	public PINK1PRKN122() {
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

	private String cogn_conf;

	@Column(name = "cogn_conf", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCogn_conf() {
		return this.cogn_conf;
	}

	public void setCogn_conf(String cogn_conf) {
		this.cogn_conf = cogn_conf;
	}
	private String cogn_decline;

	@Column(name = "cogn_decline", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCogn_decline() {
		return this.cogn_decline;
	}

	public void setCogn_decline(String cogn_decline) {
		this.cogn_decline = cogn_decline;
	}
	private String cogn_dx;

	@Column(name = "cogn_dx", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCogn_dx() {
		return this.cogn_dx;
	}

	public void setCogn_dx(String cogn_dx) {
		this.cogn_dx = cogn_dx;
	}
	private String cogn_ex;

	@Column(name = "cogn_ex", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCogn_ex() {
		return this.cogn_ex;
	}

	public void setCogn_ex(String cogn_ex) {
		this.cogn_ex = cogn_ex;
	}
	private String cogn_functional;

	@Column(name = "cogn_functional", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCogn_functional() {
		return this.cogn_functional;
	}

	public void setCogn_functional(String cogn_functional) {
		this.cogn_functional = cogn_functional;
	}
	private String cogn_source;

	@Column(name = "cogn_source", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCogn_source() {
		return this.cogn_source;
	}

	public void setCogn_source(String cogn_source) {
		this.cogn_source = cogn_source;
	}

	public String getStatusColor() {
		// 1) Если все основные поля (кроме заголовков и инструкций) пусты -> "blue"
		if (areAllFieldsEmpty()) {
			return "blue";
		}

		// 2) Если cogn_ex = "1", значит тест не проводился -> "red"
		if ("1".equals(cogn_ex)) {
			return "red";
		}

		// 3) Если cogn_ex = "0", значит тест проводился -> проверяем обязательные поля
		if ("0".equals(cogn_ex)) {
			if (areAllRequiredWhenYesFilled()) {
				return "green";
			} else {
				return "orange";
			}
		}

		// 4) Иначе (cogn_ex не "0" и не "1", но есть какие-то данные) -> "orange"
		return "orange";
	}

	/**
	 * Проверяем, что все «рабочие» поля (кроме заголовков и инструкций) пусты.
	 * Если да -> форма не начата (blue).
	 */
	private boolean areAllFieldsEmpty() {
		// Не включаем поля:
		//   cogn_decline_headline,
		//   cogn_decline_instruction,
		//   cogn_functional_headline,
		//   cogn_functional_instruction,
		//   det_cog_headline,
		//   cogn_dx_instruction
		// так как они являются заголовками или инструкциями.

		// Проверяем только поля, где действительно есть пользовательский ввод:
		return isEmpty(cogn_ex)
				&& isEmpty(cogn_conf)
				&& isEmpty(cogn_decline)
				&& isEmpty(cogn_dx)
				&& isEmpty(cogn_functional)
				&& isEmpty(cogn_source);
	}

	/**
	 * Проверяем, что все обязательные поля (Dataset=Minimal), которые
	 * нужны при cogn_ex="0", действительно заполнены (не headline/instruction).
	 */
	private boolean areAllRequiredWhenYesFilled() {
		// Ключевое поле cogn_ex тоже должно быть заполнено (оно же указывает «тест проводился»).
		if (!isFilled(cogn_ex)) {
			return false;
		}
		if (!isFilled(cogn_conf)) {
			return false;
		}
		if (!isFilled(cogn_decline)) {
			return false;
		}
		if (!isFilled(cogn_dx)) {
			return false;
		}
		if (!isFilled(cogn_functional)) {
			return false;
		}
		if (!isFilled(cogn_source)) {
			return false;
		}

		// Если дошли сюда, значит все перечисленные поля заполнены
		return true;
	}

	/**
	 * Проверяет, что строка val пустая (null или только пробелы).
	 */
	private boolean isEmpty(String val) {
		return (val == null || val.trim().isEmpty()) || "-".equals(val.trim());
	}

	/**
	 * Проверяет, что строка val не пустая.
	 */
	private boolean isFilled(String val) {
		return !isEmpty(val);
	}

}

//green if all items completed, orange if some but not all, blue if none are completed

