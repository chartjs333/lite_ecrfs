package net.mdsgene.admin.generatedproject;
import java.util.Date;
import javax.persistence.*;
@Entity
@Table(name = "PINK1PRKN15", schema = "public")
@Cacheable(false)
public class PINK1PRKN15 implements java.io.Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PINK1PRKN15_id_seq")
    @SequenceGenerator(name="PINK1PRKN15_id_seq", sequenceName="PINK1PRKN15_id_seq", allocationSize=1)
	@Column(name = "id", unique = true, nullable = false, columnDefinition = "serial")
	private int id;

	public PINK1PRKN15() {
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

	private String biom_csf;

	@Column(name = "biom_csf", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_csf() {
		return this.biom_csf;
	}

	public void setBiom_csf(String biom_csf) {
		this.biom_csf = biom_csf;
	}
	private String biom_csf_ae;

	@Column(name = "biom_csf_ae", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_csf_ae() {
		return this.biom_csf_ae;
	}

	public void setBiom_csf_ae(String biom_csf_ae) {
		this.biom_csf_ae = biom_csf_ae;
	}
	private String biom_csf_aliq_time;

	@Column(name = "biom_csf_aliq_time", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_csf_aliq_time() {
		return this.biom_csf_aliq_time;
	}

	public void setBiom_csf_aliq_time(String biom_csf_aliq_time) {
		this.biom_csf_aliq_time = biom_csf_aliq_time;
	}
	private String biom_csf_aliq_tubes;

	@Column(name = "biom_csf_aliq_tubes", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_csf_aliq_tubes() {
		return this.biom_csf_aliq_tubes;
	}

	public void setBiom_csf_aliq_tubes(String biom_csf_aliq_tubes) {
		this.biom_csf_aliq_tubes = biom_csf_aliq_tubes;
	}
	private String biom_csf_blood;

	@Column(name = "biom_csf_blood", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_csf_blood() {
		return this.biom_csf_blood;
	}

	public void setBiom_csf_blood(String biom_csf_blood) {
		this.biom_csf_blood = biom_csf_blood;
	}
	private String biom_csf_centr_dur;

	@Column(name = "biom_csf_centr_dur", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_csf_centr_dur() {
		return this.biom_csf_centr_dur;
	}

	public void setBiom_csf_centr_dur(String biom_csf_centr_dur) {
		this.biom_csf_centr_dur = biom_csf_centr_dur;
	}
	private String biom_csf_centr_rate;

	@Column(name = "biom_csf_centr_rate", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_csf_centr_rate() {
		return this.biom_csf_centr_rate;
	}

	public void setBiom_csf_centr_rate(String biom_csf_centr_rate) {
		this.biom_csf_centr_rate = biom_csf_centr_rate;
	}
	private String biom_csf_centr_temp;

	@Column(name = "biom_csf_centr_temp", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_csf_centr_temp() {
		return this.biom_csf_centr_temp;
	}

	public void setBiom_csf_centr_temp(String biom_csf_centr_temp) {
		this.biom_csf_centr_temp = biom_csf_centr_temp;
	}
	private String biom_csf_centr_time;

	@Column(name = "biom_csf_centr_time", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_csf_centr_time() {
		return this.biom_csf_centr_time;
	}

	public void setBiom_csf_centr_time(String biom_csf_centr_time) {
		this.biom_csf_centr_time = biom_csf_centr_time;
	}
	private String biom_csf_comm;

	@Column(name = "biom_csf_comm", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_csf_comm() {
		return this.biom_csf_comm;
	}

	public void setBiom_csf_comm(String biom_csf_comm) {
		this.biom_csf_comm = biom_csf_comm;
	}
	private String biom_csf_date_day;

	@Column(name = "biom_csf_date_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_csf_date_day() {
		return this.biom_csf_date_day;
	}

	public void setBiom_csf_date_day(String biom_csf_date_day) {
		this.biom_csf_date_day = biom_csf_date_day;
	}
	private String biom_csf_date_month;

	@Column(name = "biom_csf_date_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_csf_date_month() {
		return this.biom_csf_date_month;
	}

	public void setBiom_csf_date_month(String biom_csf_date_month) {
		this.biom_csf_date_month = biom_csf_date_month;
	}
	private String biom_csf_date_year;

	@Column(name = "biom_csf_date_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_csf_date_year() {
		return this.biom_csf_date_year;
	}

	public void setBiom_csf_date_year(String biom_csf_date_year) {
		this.biom_csf_date_year = biom_csf_date_year;
	}
	private String biom_csf_fast;

	@Column(name = "biom_csf_fast", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_csf_fast() {
		return this.biom_csf_fast;
	}

	public void setBiom_csf_fast(String biom_csf_fast) {
		this.biom_csf_fast = biom_csf_fast;
	}
	private String biom_csf_fluor;

	@Column(name = "biom_csf_fluor", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_csf_fluor() {
		return this.biom_csf_fluor;
	}

	public void setBiom_csf_fluor(String biom_csf_fluor) {
		this.biom_csf_fluor = biom_csf_fluor;
	}
	private String biom_csf_fluor_date_day;

	@Column(name = "biom_csf_fluor_date_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_csf_fluor_date_day() {
		return this.biom_csf_fluor_date_day;
	}

	public void setBiom_csf_fluor_date_day(String biom_csf_fluor_date_day) {
		this.biom_csf_fluor_date_day = biom_csf_fluor_date_day;
	}
	private String biom_csf_fluor_date_month;

	@Column(name = "biom_csf_fluor_date_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_csf_fluor_date_month() {
		return this.biom_csf_fluor_date_month;
	}

	public void setBiom_csf_fluor_date_month(String biom_csf_fluor_date_month) {
		this.biom_csf_fluor_date_month = biom_csf_fluor_date_month;
	}
	private String biom_csf_fluor_date_year;

	@Column(name = "biom_csf_fluor_date_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_csf_fluor_date_year() {
		return this.biom_csf_fluor_date_year;
	}

	public void setBiom_csf_fluor_date_year(String biom_csf_fluor_date_year) {
		this.biom_csf_fluor_date_year = biom_csf_fluor_date_year;
	}
	private String biom_csf_food_date_day;

	@Column(name = "biom_csf_food_date_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_csf_food_date_day() {
		return this.biom_csf_food_date_day;
	}

	public void setBiom_csf_food_date_day(String biom_csf_food_date_day) {
		this.biom_csf_food_date_day = biom_csf_food_date_day;
	}
	private String biom_csf_food_date_month;

	@Column(name = "biom_csf_food_date_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_csf_food_date_month() {
		return this.biom_csf_food_date_month;
	}

	public void setBiom_csf_food_date_month(String biom_csf_food_date_month) {
		this.biom_csf_food_date_month = biom_csf_food_date_month;
	}
	private String biom_csf_food_date_year;

	@Column(name = "biom_csf_food_date_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_csf_food_date_year() {
		return this.biom_csf_food_date_year;
	}

	public void setBiom_csf_food_date_year(String biom_csf_food_date_year) {
		this.biom_csf_food_date_year = biom_csf_food_date_year;
	}
	private String biom_csf_food_time;

	@Column(name = "biom_csf_food_time", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_csf_food_time() {
		return this.biom_csf_food_time;
	}

	public void setBiom_csf_food_time(String biom_csf_food_time) {
		this.biom_csf_food_time = biom_csf_food_time;
	}
	private String biom_csf_freeze_time;

	@Column(name = "biom_csf_freeze_time", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_csf_freeze_time() {
		return this.biom_csf_freeze_time;
	}

	public void setBiom_csf_freeze_time(String biom_csf_freeze_time) {
		this.biom_csf_freeze_time = biom_csf_freeze_time;
	}
	private String biom_csf_gluc;

	@Column(name = "biom_csf_gluc", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_csf_gluc() {
		return this.biom_csf_gluc;
	}

	public void setBiom_csf_gluc(String biom_csf_gluc) {
		this.biom_csf_gluc = biom_csf_gluc;
	}
	private String biom_csf_iss;

	@Column(name = "biom_csf_iss", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_csf_iss() {
		return this.biom_csf_iss;
	}

	public void setBiom_csf_iss(String biom_csf_iss) {
		this.biom_csf_iss = biom_csf_iss;
	}
	private String biom_csf_lab;

	@Column(name = "biom_csf_lab", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_csf_lab() {
		return this.biom_csf_lab;
	}

	public void setBiom_csf_lab(String biom_csf_lab) {
		this.biom_csf_lab = biom_csf_lab;
	}
	private String biom_csf_lab_rs;

	@Column(name = "biom_csf_lab_rs", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_csf_lab_rs() {
		return this.biom_csf_lab_rs;
	}

	public void setBiom_csf_lab_rs(String biom_csf_lab_rs) {
		this.biom_csf_lab_rs = biom_csf_lab_rs;
	}
	private String biom_csf_loc;

	@Column(name = "biom_csf_loc", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_csf_loc() {
		return this.biom_csf_loc;
	}

	public void setBiom_csf_loc(String biom_csf_loc) {
		this.biom_csf_loc = biom_csf_loc;
	}
	private String biom_csf_method;

	@Column(name = "biom_csf_method", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_csf_method() {
		return this.biom_csf_method;
	}

	public void setBiom_csf_method(String biom_csf_method) {
		this.biom_csf_method = biom_csf_method;
	}
	private String biom_csf_needle;

	@Column(name = "biom_csf_needle", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_csf_needle() {
		return this.biom_csf_needle;
	}

	public void setBiom_csf_needle(String biom_csf_needle) {
		this.biom_csf_needle = biom_csf_needle;
	}
	private String biom_csf_pdmed;

	@Column(name = "biom_csf_pdmed", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_csf_pdmed() {
		return this.biom_csf_pdmed;
	}

	public void setBiom_csf_pdmed(String biom_csf_pdmed) {
		this.biom_csf_pdmed = biom_csf_pdmed;
	}
	private String biom_csf_pdmed_date_day;

	@Column(name = "biom_csf_pdmed_date_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_csf_pdmed_date_day() {
		return this.biom_csf_pdmed_date_day;
	}

	public void setBiom_csf_pdmed_date_day(String biom_csf_pdmed_date_day) {
		this.biom_csf_pdmed_date_day = biom_csf_pdmed_date_day;
	}
	private String biom_csf_pdmed_date_month;

	@Column(name = "biom_csf_pdmed_date_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_csf_pdmed_date_month() {
		return this.biom_csf_pdmed_date_month;
	}

	public void setBiom_csf_pdmed_date_month(String biom_csf_pdmed_date_month) {
		this.biom_csf_pdmed_date_month = biom_csf_pdmed_date_month;
	}
	private String biom_csf_pdmed_date_year;

	@Column(name = "biom_csf_pdmed_date_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_csf_pdmed_date_year() {
		return this.biom_csf_pdmed_date_year;
	}

	public void setBiom_csf_pdmed_date_year(String biom_csf_pdmed_date_year) {
		this.biom_csf_pdmed_date_year = biom_csf_pdmed_date_year;
	}
	private String biom_csf_pdmed_time;

	@Column(name = "biom_csf_pdmed_time", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_csf_pdmed_time() {
		return this.biom_csf_pdmed_time;
	}

	public void setBiom_csf_pdmed_time(String biom_csf_pdmed_time) {
		this.biom_csf_pdmed_time = biom_csf_pdmed_time;
	}
	private String biom_csf_pos;

	@Column(name = "biom_csf_pos", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_csf_pos() {
		return this.biom_csf_pos;
	}

	public void setBiom_csf_pos(String biom_csf_pos) {
		this.biom_csf_pos = biom_csf_pos;
	}
	private String biom_csf_prot;

	@Column(name = "biom_csf_prot", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_csf_prot() {
		return this.biom_csf_prot;
	}

	public void setBiom_csf_prot(String biom_csf_prot) {
		this.biom_csf_prot = biom_csf_prot;
	}
	private String biom_csf_ptt;

	@Column(name = "biom_csf_ptt", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_csf_ptt() {
		return this.biom_csf_ptt;
	}

	public void setBiom_csf_ptt(String biom_csf_ptt) {
		this.biom_csf_ptt = biom_csf_ptt;
	}
	private String biom_csf_q;

	@Column(name = "biom_csf_q", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_csf_q() {
		return this.biom_csf_q;
	}

	public void setBiom_csf_q(String biom_csf_q) {
		this.biom_csf_q = biom_csf_q;
	}
	private String biom_csf_reas;

	@Column(name = "biom_csf_reas", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_csf_reas() {
		return this.biom_csf_reas;
	}

	public void setBiom_csf_reas(String biom_csf_reas) {
		this.biom_csf_reas = biom_csf_reas;
	}
	private String biom_csf_redbc;

	@Column(name = "biom_csf_redbc", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_csf_redbc() {
		return this.biom_csf_redbc;
	}

	public void setBiom_csf_redbc(String biom_csf_redbc) {
		this.biom_csf_redbc = biom_csf_redbc;
	}
	private String biom_csf_spinefilm;

	@Column(name = "biom_csf_spinefilm", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_csf_spinefilm() {
		return this.biom_csf_spinefilm;
	}

	public void setBiom_csf_spinefilm(String biom_csf_spinefilm) {
		this.biom_csf_spinefilm = biom_csf_spinefilm;
	}
	private String biom_csf_spinefilm_date_day;

	@Column(name = "biom_csf_spinefilm_date_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_csf_spinefilm_date_day() {
		return this.biom_csf_spinefilm_date_day;
	}

	public void setBiom_csf_spinefilm_date_day(String biom_csf_spinefilm_date_day) {
		this.biom_csf_spinefilm_date_day = biom_csf_spinefilm_date_day;
	}
	private String biom_csf_spinefilm_date_month;

	@Column(name = "biom_csf_spinefilm_date_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_csf_spinefilm_date_month() {
		return this.biom_csf_spinefilm_date_month;
	}

	public void setBiom_csf_spinefilm_date_month(String biom_csf_spinefilm_date_month) {
		this.biom_csf_spinefilm_date_month = biom_csf_spinefilm_date_month;
	}
	private String biom_csf_spinefilm_date_year;

	@Column(name = "biom_csf_spinefilm_date_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_csf_spinefilm_date_year() {
		return this.biom_csf_spinefilm_date_year;
	}

	public void setBiom_csf_spinefilm_date_year(String biom_csf_spinefilm_date_year) {
		this.biom_csf_spinefilm_date_year = biom_csf_spinefilm_date_year;
	}
	private String biom_csf_stor;

	@Column(name = "biom_csf_stor", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_csf_stor() {
		return this.biom_csf_stor;
	}

	public void setBiom_csf_stor(String biom_csf_stor) {
		this.biom_csf_stor = biom_csf_stor;
	}
	private String biom_csf_stor_temp;

	@Column(name = "biom_csf_stor_temp", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_csf_stor_temp() {
		return this.biom_csf_stor_temp;
	}

	public void setBiom_csf_stor_temp(String biom_csf_stor_temp) {
		this.biom_csf_stor_temp = biom_csf_stor_temp;
	}
	private String biom_csf_time;

	@Column(name = "biom_csf_time", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_csf_time() {
		return this.biom_csf_time;
	}

	public void setBiom_csf_time(String biom_csf_time) {
		this.biom_csf_time = biom_csf_time;
	}
	private String biom_csf_vol_postspin;

	@Column(name = "biom_csf_vol_postspin", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_csf_vol_postspin() {
		return this.biom_csf_vol_postspin;
	}

	public void setBiom_csf_vol_postspin(String biom_csf_vol_postspin) {
		this.biom_csf_vol_postspin = biom_csf_vol_postspin;
	}
	private String biom_csf_vol_prespin;

	@Column(name = "biom_csf_vol_prespin", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_csf_vol_prespin() {
		return this.biom_csf_vol_prespin;
	}

	public void setBiom_csf_vol_prespin(String biom_csf_vol_prespin) {
		this.biom_csf_vol_prespin = biom_csf_vol_prespin;
	}
	private String biom_csf_whitebc;

	@Column(name = "biom_csf_whitebc", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_csf_whitebc() {
		return this.biom_csf_whitebc;
	}

	public void setBiom_csf_whitebc(String biom_csf_whitebc) {
		this.biom_csf_whitebc = biom_csf_whitebc;
	}

	public String getStatusColor() {
		// Проверяем, заполнены ли все обязательные поля
		boolean allCompleted = areAllFieldsCompleted();
		boolean biomCsfLabCollected = "collected".equals(this.biom_csf_lab);
		boolean biomCsfCollected = "collected".equals(this.biom_csf);
		boolean biomCsfAeCollected = "collected".equals(this.biom_csf_ae);
		boolean biomCsfAeNotCollected = "not collected".equals(this.biom_csf_ae);

		// Проверяем условия для green
		if (allCompleted && biomCsfLabCollected && biomCsfCollected) {
			if (biomCsfAeCollected) {
				// Если biom_csf_ae = "collected", все связанные поля должны быть заполнены
				if (areAllConditionalFieldsCompleted()) {
					return "green";
				}
			} else if (biomCsfAeNotCollected) {
				// Если biom_csf_ae = "not collected", все связанные поля могут быть пустыми
				return "green";
			}
		}

		// Проверяем, заполнено ли хотя бы одно поле
		if (isAtLeastOneFieldCompleted()) {
			return "orange";
		} else {
			return "blue";
		}
}

	private boolean areAllFieldsCompleted() {
		// Проверяем, что все обязательные поля заполнены
		return isFieldCompleted(this.biom_csf) &&
				isFieldCompleted(this.biom_csf_lab) &&
				isFieldCompleted(this.biom_csf_ae);
	}

	private boolean areAllConditionalFieldsCompleted() {
		// Проверяем, что все связанные поля (с аннотацией @Condition) заполнены
		return isFieldCompleted(this.biom_csf_aliq_time) &&
				isFieldCompleted(this.biom_csf_aliq_tubes) &&
				isFieldCompleted(this.biom_csf_blood) &&
				isFieldCompleted(this.biom_csf_centr_dur) &&
				isFieldCompleted(this.biom_csf_centr_rate) &&
				isFieldCompleted(this.biom_csf_centr_temp) &&
				isFieldCompleted(this.biom_csf_centr_time) &&
				isFieldCompleted(this.biom_csf_comm) &&
				isFieldCompleted(this.biom_csf_date_day) &&
				isFieldCompleted(this.biom_csf_date_month) &&
				isFieldCompleted(this.biom_csf_date_year) &&
				isFieldCompleted(this.biom_csf_fast) &&
				isFieldCompleted(this.biom_csf_fluor) &&
				(shouldDisplayField("biom_csf_fluor_date_day") ? isFieldCompleted(this.biom_csf_fluor_date_day) : true) &&
				(shouldDisplayField("biom_csf_fluor_date_month") ? isFieldCompleted(this.biom_csf_fluor_date_month) : true) &&
				(shouldDisplayField("biom_csf_fluor_date_year") ? isFieldCompleted(this.biom_csf_fluor_date_year) : true) &&
				isFieldCompleted(this.biom_csf_food_date_day) &&
				isFieldCompleted(this.biom_csf_food_date_month) &&
				isFieldCompleted(this.biom_csf_food_date_year) &&
				isFieldCompleted(this.biom_csf_food_time) &&
				isFieldCompleted(this.biom_csf_freeze_time) &&
				isFieldCompleted(this.biom_csf_iss) &&
				isFieldCompleted(this.biom_csf_loc) &&
				isFieldCompleted(this.biom_csf_method) &&
				isFieldCompleted(this.biom_csf_needle) &&
				isFieldCompleted(this.biom_csf_pdmed) &&
				isFieldCompleted(this.biom_csf_pdmed_date_day) &&
				isFieldCompleted(this.biom_csf_pdmed_date_month) &&
				isFieldCompleted(this.biom_csf_pdmed_date_year) &&
				isFieldCompleted(this.biom_csf_pdmed_time) &&
				isFieldCompleted(this.biom_csf_pos) &&
				isFieldCompleted(this.biom_csf_stor) &&
				(shouldDisplayField("biom_csf_stor_temp") ? isFieldCompleted(this.biom_csf_stor_temp) : true) &&
				isFieldCompleted(this.biom_csf_time) &&
				isFieldCompleted(this.biom_csf_vol_postspin) &&
				isFieldCompleted(this.biom_csf_vol_prespin);
	}

	private boolean isAtLeastOneFieldCompleted() {
		// Проверяем, заполнено ли хотя бы одно поле
		return isFieldCompleted(this.biom_csf) ||
				isFieldCompleted(this.biom_csf_lab) ||
				isFieldCompleted(this.biom_csf_ae) ||
				isFieldCompleted(this.biom_csf_aliq_time) ||
				isFieldCompleted(this.biom_csf_aliq_tubes) ||
				isFieldCompleted(this.biom_csf_blood) ||
				isFieldCompleted(this.biom_csf_centr_dur) ||
				isFieldCompleted(this.biom_csf_centr_rate) ||
				isFieldCompleted(this.biom_csf_centr_temp) ||
				isFieldCompleted(this.biom_csf_centr_time) ||
				isFieldCompleted(this.biom_csf_comm) ||
				isFieldCompleted(this.biom_csf_date_day) ||
				isFieldCompleted(this.biom_csf_date_month) ||
				isFieldCompleted(this.biom_csf_date_year) ||
				isFieldCompleted(this.biom_csf_fast) ||
				isFieldCompleted(this.biom_csf_fluor) ||
				isFieldCompleted(this.biom_csf_fluor_date_day) ||
				isFieldCompleted(this.biom_csf_fluor_date_month) ||
				isFieldCompleted(this.biom_csf_fluor_date_year) ||
				isFieldCompleted(this.biom_csf_food_date_day) ||
				isFieldCompleted(this.biom_csf_food_date_month) ||
				isFieldCompleted(this.biom_csf_food_date_year) ||
				isFieldCompleted(this.biom_csf_food_time) ||
				isFieldCompleted(this.biom_csf_freeze_time) ||
				isFieldCompleted(this.biom_csf_iss) ||
				isFieldCompleted(this.biom_csf_loc) ||
				isFieldCompleted(this.biom_csf_method) ||
				isFieldCompleted(this.biom_csf_needle) ||
				isFieldCompleted(this.biom_csf_pdmed) ||
				isFieldCompleted(this.biom_csf_pdmed_date_day) ||
				isFieldCompleted(this.biom_csf_pdmed_date_month) ||
				isFieldCompleted(this.biom_csf_pdmed_date_year) ||
				isFieldCompleted(this.biom_csf_pdmed_time) ||
				isFieldCompleted(this.biom_csf_pos) ||
				isFieldCompleted(this.biom_csf_stor) ||
				isFieldCompleted(this.biom_csf_stor_temp) ||
				isFieldCompleted(this.biom_csf_time) ||
				isFieldCompleted(this.biom_csf_vol_postspin) ||
				isFieldCompleted(this.biom_csf_vol_prespin);
	}

	private boolean isFieldCompleted(String field) {
		// Проверяем, что поле не равно null и не пустое
		return field != null && !field.trim().isEmpty() && !field.trim().equals("-");
	}

	private boolean shouldDisplayField(String fieldName) {
		// Логика проверки, должно ли поле отображаться на основе @Condition
		switch (fieldName) {
			case "biom_csf_fluor_date_day":
			case "biom_csf_fluor_date_month":
			case "biom_csf_fluor_date_year":
				return "Yes".equals(this.biom_csf_fluor);
			case "biom_csf_stor_temp":
				return "freezer".equals(this.biom_csf_stor);
			default:
				return true; // По умолчанию поле отображается
		}
	}
}

//green if all items completed AND biom_csf_lab=collected AND biom_csf=collected AND (if biom_csf_ae=collected, all subsequent items are completed OR if biom_csf_ae=not collected, all subsequent items can be left blank); orange if not all of the described items are completed; blue if none are completed


