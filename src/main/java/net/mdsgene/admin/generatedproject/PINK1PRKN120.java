package net.mdsgene.admin.generatedproject;
import java.util.Date;
import javax.persistence.*;
@Entity
@Table(name = "PINK1PRKN120", schema = "public")
@Cacheable(false)
public class PINK1PRKN120 implements java.io.Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PINK1PRKN120_id_seq")
    @SequenceGenerator(name="PINK1PRKN120_id_seq", sequenceName="PINK1PRKN120_id_seq", allocationSize=1)
	@Column(name = "id", unique = true, nullable = false, columnDefinition = "serial")
	private int id;

	public PINK1PRKN120() {
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

	private String hoehnyahr;

	@Column(name = "hoehnyahr", nullable = true, columnDefinition = "varchar", length = 128)
	public String getHoehnyahr() {
		return this.hoehnyahr;
	}

	public void setHoehnyahr(String hoehnyahr) {
		this.hoehnyahr = hoehnyahr;
	}
	private String mdsupdrs_4_c_mf;

	@Column(name = "mdsupdrs_4_c_mf", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrs_4_c_mf() {
		return this.mdsupdrs_4_c_mf;
	}

	public void setMdsupdrs_4_c_mf(String mdsupdrs_4_c_mf) {
		this.mdsupdrs_4_c_mf = mdsupdrs_4_c_mf;
	}
	private String mdsupdrs_4_fi_d;

	@Column(name = "mdsupdrs_4_fi_d", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrs_4_fi_d() {
		return this.mdsupdrs_4_fi_d;
	}

	public void setMdsupdrs_4_fi_d(String mdsupdrs_4_fi_d) {
		this.mdsupdrs_4_fi_d = mdsupdrs_4_fi_d;
	}
	private String mdsupdrs_4_fi_f;

	@Column(name = "mdsupdrs_4_fi_f", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrs_4_fi_f() {
		return this.mdsupdrs_4_fi_f;
	}

	public void setMdsupdrs_4_fi_f(String mdsupdrs_4_fi_f) {
		this.mdsupdrs_4_fi_f = mdsupdrs_4_fi_f;
	}
	private String mdsupdrs_4_posd;

	@Column(name = "mdsupdrs_4_posd", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrs_4_posd() {
		return this.mdsupdrs_4_posd;
	}

	public void setMdsupdrs_4_posd(String mdsupdrs_4_posd) {
		this.mdsupdrs_4_posd = mdsupdrs_4_posd;
	}
	private String mdsupdrs_4_ts_d;

	@Column(name = "mdsupdrs_4_ts_d", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrs_4_ts_d() {
		return this.mdsupdrs_4_ts_d;
	}

	public void setMdsupdrs_4_ts_d(String mdsupdrs_4_ts_d) {
		this.mdsupdrs_4_ts_d = mdsupdrs_4_ts_d;
	}
	private String mdsupdrs_4_ts_os;

	@Column(name = "mdsupdrs_4_ts_os", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrs_4_ts_os() {
		return this.mdsupdrs_4_ts_os;
	}

	public void setMdsupdrs_4_ts_os(String mdsupdrs_4_ts_os) {
		this.mdsupdrs_4_ts_os = mdsupdrs_4_ts_os;
	}
	private String schwab_engl_adl;

	@Column(name = "schwab_engl_adl", nullable = true, columnDefinition = "varchar", length = 128)
	public String getSchwab_engl_adl() {
		return this.schwab_engl_adl;
	}

	public void setSchwab_engl_adl(String schwab_engl_adl) {
		this.schwab_engl_adl = schwab_engl_adl;
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
		// Проверяем заполненность всех полей
		return !isEmpty(this.surveyTwoId) &&
				!isEmpty(this.fillingStatus) &&
				!isEmpty(this.hoehnyahr) &&
				!isEmpty(this.mdsupdrs_4_c_mf) &&
				!isEmpty(this.mdsupdrs_4_fi_d) &&
				!isEmpty(this.mdsupdrs_4_fi_f) &&
				!isEmpty(this.mdsupdrs_4_posd) &&
				!isEmpty(this.mdsupdrs_4_ts_d) &&
				!isEmpty(this.mdsupdrs_4_ts_os) &&
				!isEmpty(this.schwab_engl_adl);
	}

	private boolean isAtLeastOneFieldCompleted() {
		// Проверяем, заполнено ли хотя бы одно поле
		return !isEmpty(this.surveyTwoId) ||
				!isEmpty(this.fillingStatus) ||
				!isEmpty(this.hoehnyahr) ||
				!isEmpty(this.mdsupdrs_4_c_mf) ||
				!isEmpty(this.mdsupdrs_4_fi_d) ||
				!isEmpty(this.mdsupdrs_4_fi_f) ||
				!isEmpty(this.mdsupdrs_4_posd) ||
				!isEmpty(this.mdsupdrs_4_ts_d) ||
				!isEmpty(this.mdsupdrs_4_ts_os) ||
				!isEmpty(this.schwab_engl_adl);
}

	private boolean isEmpty(String value) {
		// Проверяем, является ли строка пустой или null
		return value == null || value.trim().isEmpty();
	}
}

//green if all items completed, orange if some but not all, blue if none are completed

