package net.mdsgene.admin.generatedproject;
import java.util.Date;
import javax.persistence.*;
@Entity
@Table(name = "PINK1PRKN111", schema = "public")
@Cacheable(false)
public class PINK1PRKN111 implements java.io.Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PINK1PRKN111_id_seq")
    @SequenceGenerator(name="PINK1PRKN111_id_seq", sequenceName="PINK1PRKN111_id_seq", allocationSize=1)
	@Column(name = "id", unique = true, nullable = false, columnDefinition = "serial")
	private int id;

	public PINK1PRKN111() {
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

	private String ledd_10_dose;

	@Column(name = "ledd_10_dose", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_10_dose() {
		return this.ledd_10_dose;
	}

	public void setLedd_10_dose(String ledd_10_dose) {
		this.ledd_10_dose = ledd_10_dose;
	}
	private String ledd_10_freq;

	@Column(name = "ledd_10_freq", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_10_freq() {
		return this.ledd_10_freq;
	}

	public void setLedd_10_freq(String ledd_10_freq) {
		this.ledd_10_freq = ledd_10_freq;
	}
	private String ledd_10_name;

	@Column(name = "ledd_10_name", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_10_name() {
		return this.ledd_10_name;
	}

	public void setLedd_10_name(String ledd_10_name) {
		this.ledd_10_name = ledd_10_name;
	}
	private String ledd_10_ongoing;

	@Column(name = "ledd_10_ongoing", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_10_ongoing() {
		return this.ledd_10_ongoing;
	}

	public void setLedd_10_ongoing(String ledd_10_ongoing) {
		this.ledd_10_ongoing = ledd_10_ongoing;
	}
	private String ledd_10_start_day;

	@Column(name = "ledd_10_start_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_10_start_day() {
		return this.ledd_10_start_day;
	}

	public void setLedd_10_start_day(String ledd_10_start_day) {
		this.ledd_10_start_day = ledd_10_start_day;
	}
	private String ledd_10_start_month;

	@Column(name = "ledd_10_start_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_10_start_month() {
		return this.ledd_10_start_month;
	}

	public void setLedd_10_start_month(String ledd_10_start_month) {
		this.ledd_10_start_month = ledd_10_start_month;
	}
	private String ledd_10_start_year;

	@Column(name = "ledd_10_start_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_10_start_year() {
		return this.ledd_10_start_year;
	}

	public void setLedd_10_start_year(String ledd_10_start_year) {
		this.ledd_10_start_year = ledd_10_start_year;
	}
	private String ledd_10_stop_day;

	@Column(name = "ledd_10_stop_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_10_stop_day() {
		return this.ledd_10_stop_day;
	}

	public void setLedd_10_stop_day(String ledd_10_stop_day) {
		this.ledd_10_stop_day = ledd_10_stop_day;
	}
	private String ledd_10_stop_month;

	@Column(name = "ledd_10_stop_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_10_stop_month() {
		return this.ledd_10_stop_month;
	}

	public void setLedd_10_stop_month(String ledd_10_stop_month) {
		this.ledd_10_stop_month = ledd_10_stop_month;
	}
	private String ledd_10_stop_year;

	@Column(name = "ledd_10_stop_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_10_stop_year() {
		return this.ledd_10_stop_year;
	}

	public void setLedd_10_stop_year(String ledd_10_stop_year) {
		this.ledd_10_stop_year = ledd_10_stop_year;
	}
	private String ledd_10_tab;

	@Column(name = "ledd_10_tab", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_10_tab() {
		return this.ledd_10_tab;
	}

	public void setLedd_10_tab(String ledd_10_tab) {
		this.ledd_10_tab = ledd_10_tab;
	}
	private String ledd_10_units;

	@Column(name = "ledd_10_units", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_10_units() {
		return this.ledd_10_units;
	}

	public void setLedd_10_units(String ledd_10_units) {
		this.ledd_10_units = ledd_10_units;
	}
	private String ledd_1_dose;

	@Column(name = "ledd_1_dose", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_1_dose() {
		return this.ledd_1_dose;
	}

	public void setLedd_1_dose(String ledd_1_dose) {
		this.ledd_1_dose = ledd_1_dose;
	}
	private String ledd_1_freq;

	@Column(name = "ledd_1_freq", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_1_freq() {
		return this.ledd_1_freq;
	}

	public void setLedd_1_freq(String ledd_1_freq) {
		this.ledd_1_freq = ledd_1_freq;
	}
	private String ledd_1_name;

	@Column(name = "ledd_1_name", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_1_name() {
		return this.ledd_1_name;
	}

	public void setLedd_1_name(String ledd_1_name) {
		this.ledd_1_name = ledd_1_name;
	}
	private String ledd_1_ongoing;

	@Column(name = "ledd_1_ongoing", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_1_ongoing() {
		return this.ledd_1_ongoing;
	}

	public void setLedd_1_ongoing(String ledd_1_ongoing) {
		this.ledd_1_ongoing = ledd_1_ongoing;
	}
	private String ledd_1_start_day;

	@Column(name = "ledd_1_start_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_1_start_day() {
		return this.ledd_1_start_day;
	}

	public void setLedd_1_start_day(String ledd_1_start_day) {
		this.ledd_1_start_day = ledd_1_start_day;
	}
	private String ledd_1_start_month;

	@Column(name = "ledd_1_start_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_1_start_month() {
		return this.ledd_1_start_month;
	}

	public void setLedd_1_start_month(String ledd_1_start_month) {
		this.ledd_1_start_month = ledd_1_start_month;
	}
	private String ledd_1_start_year;

	@Column(name = "ledd_1_start_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_1_start_year() {
		return this.ledd_1_start_year;
	}

	public void setLedd_1_start_year(String ledd_1_start_year) {
		this.ledd_1_start_year = ledd_1_start_year;
	}
	private String ledd_1_stop_day;

	@Column(name = "ledd_1_stop_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_1_stop_day() {
		return this.ledd_1_stop_day;
	}

	public void setLedd_1_stop_day(String ledd_1_stop_day) {
		this.ledd_1_stop_day = ledd_1_stop_day;
	}
	private String ledd_1_stop_month;

	@Column(name = "ledd_1_stop_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_1_stop_month() {
		return this.ledd_1_stop_month;
	}

	public void setLedd_1_stop_month(String ledd_1_stop_month) {
		this.ledd_1_stop_month = ledd_1_stop_month;
	}
	private String ledd_1_stop_year;

	@Column(name = "ledd_1_stop_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_1_stop_year() {
		return this.ledd_1_stop_year;
	}

	public void setLedd_1_stop_year(String ledd_1_stop_year) {
		this.ledd_1_stop_year = ledd_1_stop_year;
	}
	private String ledd_1_tab;

	@Column(name = "ledd_1_tab", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_1_tab() {
		return this.ledd_1_tab;
	}

	public void setLedd_1_tab(String ledd_1_tab) {
		this.ledd_1_tab = ledd_1_tab;
	}
	private String ledd_1_units;

	@Column(name = "ledd_1_units", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_1_units() {
		return this.ledd_1_units;
	}

	public void setLedd_1_units(String ledd_1_units) {
		this.ledd_1_units = ledd_1_units;
	}
	private String ledd_2_dose;

	@Column(name = "ledd_2_dose", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_2_dose() {
		return this.ledd_2_dose;
	}

	public void setLedd_2_dose(String ledd_2_dose) {
		this.ledd_2_dose = ledd_2_dose;
	}
	private String ledd_2_freq;

	@Column(name = "ledd_2_freq", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_2_freq() {
		return this.ledd_2_freq;
	}

	public void setLedd_2_freq(String ledd_2_freq) {
		this.ledd_2_freq = ledd_2_freq;
	}
	private String ledd_2_name;

	@Column(name = "ledd_2_name", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_2_name() {
		return this.ledd_2_name;
	}

	public void setLedd_2_name(String ledd_2_name) {
		this.ledd_2_name = ledd_2_name;
	}
	private String ledd_2_ongoing;

	@Column(name = "ledd_2_ongoing", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_2_ongoing() {
		return this.ledd_2_ongoing;
	}

	public void setLedd_2_ongoing(String ledd_2_ongoing) {
		this.ledd_2_ongoing = ledd_2_ongoing;
	}
	private String ledd_2_start_day;

	@Column(name = "ledd_2_start_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_2_start_day() {
		return this.ledd_2_start_day;
	}

	public void setLedd_2_start_day(String ledd_2_start_day) {
		this.ledd_2_start_day = ledd_2_start_day;
	}
	private String ledd_2_start_month;

	@Column(name = "ledd_2_start_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_2_start_month() {
		return this.ledd_2_start_month;
	}

	public void setLedd_2_start_month(String ledd_2_start_month) {
		this.ledd_2_start_month = ledd_2_start_month;
	}
	private String ledd_2_start_year;

	@Column(name = "ledd_2_start_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_2_start_year() {
		return this.ledd_2_start_year;
	}

	public void setLedd_2_start_year(String ledd_2_start_year) {
		this.ledd_2_start_year = ledd_2_start_year;
	}
	private String ledd_2_stop_day;

	@Column(name = "ledd_2_stop_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_2_stop_day() {
		return this.ledd_2_stop_day;
	}

	public void setLedd_2_stop_day(String ledd_2_stop_day) {
		this.ledd_2_stop_day = ledd_2_stop_day;
	}
	private String ledd_2_stop_month;

	@Column(name = "ledd_2_stop_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_2_stop_month() {
		return this.ledd_2_stop_month;
	}

	public void setLedd_2_stop_month(String ledd_2_stop_month) {
		this.ledd_2_stop_month = ledd_2_stop_month;
	}
	private String ledd_2_stop_year;

	@Column(name = "ledd_2_stop_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_2_stop_year() {
		return this.ledd_2_stop_year;
	}

	public void setLedd_2_stop_year(String ledd_2_stop_year) {
		this.ledd_2_stop_year = ledd_2_stop_year;
	}
	private String ledd_2_tab;

	@Column(name = "ledd_2_tab", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_2_tab() {
		return this.ledd_2_tab;
	}

	public void setLedd_2_tab(String ledd_2_tab) {
		this.ledd_2_tab = ledd_2_tab;
	}
	private String ledd_2_units;

	@Column(name = "ledd_2_units", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_2_units() {
		return this.ledd_2_units;
	}

	public void setLedd_2_units(String ledd_2_units) {
		this.ledd_2_units = ledd_2_units;
	}
	private String ledd_3_dose;

	@Column(name = "ledd_3_dose", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_3_dose() {
		return this.ledd_3_dose;
	}

	public void setLedd_3_dose(String ledd_3_dose) {
		this.ledd_3_dose = ledd_3_dose;
	}
	private String ledd_3_freq;

	@Column(name = "ledd_3_freq", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_3_freq() {
		return this.ledd_3_freq;
	}

	public void setLedd_3_freq(String ledd_3_freq) {
		this.ledd_3_freq = ledd_3_freq;
	}
	private String ledd_3_name;

	@Column(name = "ledd_3_name", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_3_name() {
		return this.ledd_3_name;
	}

	public void setLedd_3_name(String ledd_3_name) {
		this.ledd_3_name = ledd_3_name;
	}
	private String ledd_3_ongoing;

	@Column(name = "ledd_3_ongoing", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_3_ongoing() {
		return this.ledd_3_ongoing;
	}

	public void setLedd_3_ongoing(String ledd_3_ongoing) {
		this.ledd_3_ongoing = ledd_3_ongoing;
	}
	private String ledd_3_start_day;

	@Column(name = "ledd_3_start_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_3_start_day() {
		return this.ledd_3_start_day;
	}

	public void setLedd_3_start_day(String ledd_3_start_day) {
		this.ledd_3_start_day = ledd_3_start_day;
	}
	private String ledd_3_start_month;

	@Column(name = "ledd_3_start_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_3_start_month() {
		return this.ledd_3_start_month;
	}

	public void setLedd_3_start_month(String ledd_3_start_month) {
		this.ledd_3_start_month = ledd_3_start_month;
	}
	private String ledd_3_start_year;

	@Column(name = "ledd_3_start_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_3_start_year() {
		return this.ledd_3_start_year;
	}

	public void setLedd_3_start_year(String ledd_3_start_year) {
		this.ledd_3_start_year = ledd_3_start_year;
	}
	private String ledd_3_stop_day;

	@Column(name = "ledd_3_stop_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_3_stop_day() {
		return this.ledd_3_stop_day;
	}

	public void setLedd_3_stop_day(String ledd_3_stop_day) {
		this.ledd_3_stop_day = ledd_3_stop_day;
	}
	private String ledd_3_stop_month;

	@Column(name = "ledd_3_stop_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_3_stop_month() {
		return this.ledd_3_stop_month;
	}

	public void setLedd_3_stop_month(String ledd_3_stop_month) {
		this.ledd_3_stop_month = ledd_3_stop_month;
	}
	private String ledd_3_stop_year;

	@Column(name = "ledd_3_stop_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_3_stop_year() {
		return this.ledd_3_stop_year;
	}

	public void setLedd_3_stop_year(String ledd_3_stop_year) {
		this.ledd_3_stop_year = ledd_3_stop_year;
	}
	private String ledd_3_tab;

	@Column(name = "ledd_3_tab", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_3_tab() {
		return this.ledd_3_tab;
	}

	public void setLedd_3_tab(String ledd_3_tab) {
		this.ledd_3_tab = ledd_3_tab;
	}
	private String ledd_3_units;

	@Column(name = "ledd_3_units", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_3_units() {
		return this.ledd_3_units;
	}

	public void setLedd_3_units(String ledd_3_units) {
		this.ledd_3_units = ledd_3_units;
	}
	private String ledd_4_dose;

	@Column(name = "ledd_4_dose", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_4_dose() {
		return this.ledd_4_dose;
	}

	public void setLedd_4_dose(String ledd_4_dose) {
		this.ledd_4_dose = ledd_4_dose;
	}
	private String ledd_4_freq;

	@Column(name = "ledd_4_freq", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_4_freq() {
		return this.ledd_4_freq;
	}

	public void setLedd_4_freq(String ledd_4_freq) {
		this.ledd_4_freq = ledd_4_freq;
	}
	private String ledd_4_name;

	@Column(name = "ledd_4_name", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_4_name() {
		return this.ledd_4_name;
	}

	public void setLedd_4_name(String ledd_4_name) {
		this.ledd_4_name = ledd_4_name;
	}
	private String ledd_4_ongoing;

	@Column(name = "ledd_4_ongoing", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_4_ongoing() {
		return this.ledd_4_ongoing;
	}

	public void setLedd_4_ongoing(String ledd_4_ongoing) {
		this.ledd_4_ongoing = ledd_4_ongoing;
	}
	private String ledd_4_start_day;

	@Column(name = "ledd_4_start_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_4_start_day() {
		return this.ledd_4_start_day;
	}

	public void setLedd_4_start_day(String ledd_4_start_day) {
		this.ledd_4_start_day = ledd_4_start_day;
	}
	private String ledd_4_start_month;

	@Column(name = "ledd_4_start_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_4_start_month() {
		return this.ledd_4_start_month;
	}

	public void setLedd_4_start_month(String ledd_4_start_month) {
		this.ledd_4_start_month = ledd_4_start_month;
	}
	private String ledd_4_start_year;

	@Column(name = "ledd_4_start_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_4_start_year() {
		return this.ledd_4_start_year;
	}

	public void setLedd_4_start_year(String ledd_4_start_year) {
		this.ledd_4_start_year = ledd_4_start_year;
	}
	private String ledd_4_stop_day;

	@Column(name = "ledd_4_stop_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_4_stop_day() {
		return this.ledd_4_stop_day;
	}

	public void setLedd_4_stop_day(String ledd_4_stop_day) {
		this.ledd_4_stop_day = ledd_4_stop_day;
	}
	private String ledd_4_stop_month;

	@Column(name = "ledd_4_stop_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_4_stop_month() {
		return this.ledd_4_stop_month;
	}

	public void setLedd_4_stop_month(String ledd_4_stop_month) {
		this.ledd_4_stop_month = ledd_4_stop_month;
	}
	private String ledd_4_stop_year;

	@Column(name = "ledd_4_stop_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_4_stop_year() {
		return this.ledd_4_stop_year;
	}

	public void setLedd_4_stop_year(String ledd_4_stop_year) {
		this.ledd_4_stop_year = ledd_4_stop_year;
	}
	private String ledd_4_tab;

	@Column(name = "ledd_4_tab", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_4_tab() {
		return this.ledd_4_tab;
	}

	public void setLedd_4_tab(String ledd_4_tab) {
		this.ledd_4_tab = ledd_4_tab;
	}
	private String ledd_4_units;

	@Column(name = "ledd_4_units", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_4_units() {
		return this.ledd_4_units;
	}

	public void setLedd_4_units(String ledd_4_units) {
		this.ledd_4_units = ledd_4_units;
	}
	private String ledd_5_dose;

	@Column(name = "ledd_5_dose", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_5_dose() {
		return this.ledd_5_dose;
	}

	public void setLedd_5_dose(String ledd_5_dose) {
		this.ledd_5_dose = ledd_5_dose;
	}
	private String ledd_5_freq;

	@Column(name = "ledd_5_freq", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_5_freq() {
		return this.ledd_5_freq;
	}

	public void setLedd_5_freq(String ledd_5_freq) {
		this.ledd_5_freq = ledd_5_freq;
	}
	private String ledd_5_name;

	@Column(name = "ledd_5_name", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_5_name() {
		return this.ledd_5_name;
	}

	public void setLedd_5_name(String ledd_5_name) {
		this.ledd_5_name = ledd_5_name;
	}
	private String ledd_5_ongoing;

	@Column(name = "ledd_5_ongoing", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_5_ongoing() {
		return this.ledd_5_ongoing;
	}

	public void setLedd_5_ongoing(String ledd_5_ongoing) {
		this.ledd_5_ongoing = ledd_5_ongoing;
	}
	private String ledd_5_start_day;

	@Column(name = "ledd_5_start_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_5_start_day() {
		return this.ledd_5_start_day;
	}

	public void setLedd_5_start_day(String ledd_5_start_day) {
		this.ledd_5_start_day = ledd_5_start_day;
	}
	private String ledd_5_start_month;

	@Column(name = "ledd_5_start_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_5_start_month() {
		return this.ledd_5_start_month;
	}

	public void setLedd_5_start_month(String ledd_5_start_month) {
		this.ledd_5_start_month = ledd_5_start_month;
	}
	private String ledd_5_start_year;

	@Column(name = "ledd_5_start_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_5_start_year() {
		return this.ledd_5_start_year;
	}

	public void setLedd_5_start_year(String ledd_5_start_year) {
		this.ledd_5_start_year = ledd_5_start_year;
	}
	private String ledd_5_stop_day;

	@Column(name = "ledd_5_stop_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_5_stop_day() {
		return this.ledd_5_stop_day;
	}

	public void setLedd_5_stop_day(String ledd_5_stop_day) {
		this.ledd_5_stop_day = ledd_5_stop_day;
	}
	private String ledd_5_stop_month;

	@Column(name = "ledd_5_stop_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_5_stop_month() {
		return this.ledd_5_stop_month;
	}

	public void setLedd_5_stop_month(String ledd_5_stop_month) {
		this.ledd_5_stop_month = ledd_5_stop_month;
	}
	private String ledd_5_stop_year;

	@Column(name = "ledd_5_stop_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_5_stop_year() {
		return this.ledd_5_stop_year;
	}

	public void setLedd_5_stop_year(String ledd_5_stop_year) {
		this.ledd_5_stop_year = ledd_5_stop_year;
	}
	private String ledd_5_tab;

	@Column(name = "ledd_5_tab", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_5_tab() {
		return this.ledd_5_tab;
	}

	public void setLedd_5_tab(String ledd_5_tab) {
		this.ledd_5_tab = ledd_5_tab;
	}
	private String ledd_5_units;

	@Column(name = "ledd_5_units", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_5_units() {
		return this.ledd_5_units;
	}

	public void setLedd_5_units(String ledd_5_units) {
		this.ledd_5_units = ledd_5_units;
	}
	private String ledd_6_dose;

	@Column(name = "ledd_6_dose", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_6_dose() {
		return this.ledd_6_dose;
	}

	public void setLedd_6_dose(String ledd_6_dose) {
		this.ledd_6_dose = ledd_6_dose;
	}
	private String ledd_6_freq;

	@Column(name = "ledd_6_freq", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_6_freq() {
		return this.ledd_6_freq;
	}

	public void setLedd_6_freq(String ledd_6_freq) {
		this.ledd_6_freq = ledd_6_freq;
	}
	private String ledd_6_name;

	@Column(name = "ledd_6_name", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_6_name() {
		return this.ledd_6_name;
	}

	public void setLedd_6_name(String ledd_6_name) {
		this.ledd_6_name = ledd_6_name;
	}
	private String ledd_6_ongoing;

	@Column(name = "ledd_6_ongoing", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_6_ongoing() {
		return this.ledd_6_ongoing;
	}

	public void setLedd_6_ongoing(String ledd_6_ongoing) {
		this.ledd_6_ongoing = ledd_6_ongoing;
	}
	private String ledd_6_start_day;

	@Column(name = "ledd_6_start_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_6_start_day() {
		return this.ledd_6_start_day;
	}

	public void setLedd_6_start_day(String ledd_6_start_day) {
		this.ledd_6_start_day = ledd_6_start_day;
	}
	private String ledd_6_start_month;

	@Column(name = "ledd_6_start_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_6_start_month() {
		return this.ledd_6_start_month;
	}

	public void setLedd_6_start_month(String ledd_6_start_month) {
		this.ledd_6_start_month = ledd_6_start_month;
	}
	private String ledd_6_start_year;

	@Column(name = "ledd_6_start_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_6_start_year() {
		return this.ledd_6_start_year;
	}

	public void setLedd_6_start_year(String ledd_6_start_year) {
		this.ledd_6_start_year = ledd_6_start_year;
	}
	private String ledd_6_stop_day;

	@Column(name = "ledd_6_stop_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_6_stop_day() {
		return this.ledd_6_stop_day;
	}

	public void setLedd_6_stop_day(String ledd_6_stop_day) {
		this.ledd_6_stop_day = ledd_6_stop_day;
	}
	private String ledd_6_stop_month;

	@Column(name = "ledd_6_stop_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_6_stop_month() {
		return this.ledd_6_stop_month;
	}

	public void setLedd_6_stop_month(String ledd_6_stop_month) {
		this.ledd_6_stop_month = ledd_6_stop_month;
	}
	private String ledd_6_stop_year;

	@Column(name = "ledd_6_stop_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_6_stop_year() {
		return this.ledd_6_stop_year;
	}

	public void setLedd_6_stop_year(String ledd_6_stop_year) {
		this.ledd_6_stop_year = ledd_6_stop_year;
	}
	private String ledd_6_tab;

	@Column(name = "ledd_6_tab", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_6_tab() {
		return this.ledd_6_tab;
	}

	public void setLedd_6_tab(String ledd_6_tab) {
		this.ledd_6_tab = ledd_6_tab;
	}
	private String ledd_6_units;

	@Column(name = "ledd_6_units", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_6_units() {
		return this.ledd_6_units;
	}

	public void setLedd_6_units(String ledd_6_units) {
		this.ledd_6_units = ledd_6_units;
	}
	private String ledd_7_dose;

	@Column(name = "ledd_7_dose", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_7_dose() {
		return this.ledd_7_dose;
	}

	public void setLedd_7_dose(String ledd_7_dose) {
		this.ledd_7_dose = ledd_7_dose;
	}
	private String ledd_7_freq;

	@Column(name = "ledd_7_freq", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_7_freq() {
		return this.ledd_7_freq;
	}

	public void setLedd_7_freq(String ledd_7_freq) {
		this.ledd_7_freq = ledd_7_freq;
	}
	private String ledd_7_name;

	@Column(name = "ledd_7_name", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_7_name() {
		return this.ledd_7_name;
	}

	public void setLedd_7_name(String ledd_7_name) {
		this.ledd_7_name = ledd_7_name;
	}
	private String ledd_7_ongoing;

	@Column(name = "ledd_7_ongoing", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_7_ongoing() {
		return this.ledd_7_ongoing;
	}

	public void setLedd_7_ongoing(String ledd_7_ongoing) {
		this.ledd_7_ongoing = ledd_7_ongoing;
	}
	private String ledd_7_start_day;

	@Column(name = "ledd_7_start_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_7_start_day() {
		return this.ledd_7_start_day;
	}

	public void setLedd_7_start_day(String ledd_7_start_day) {
		this.ledd_7_start_day = ledd_7_start_day;
	}
	private String ledd_7_start_month;

	@Column(name = "ledd_7_start_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_7_start_month() {
		return this.ledd_7_start_month;
	}

	public void setLedd_7_start_month(String ledd_7_start_month) {
		this.ledd_7_start_month = ledd_7_start_month;
	}
	private String ledd_7_start_year;

	@Column(name = "ledd_7_start_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_7_start_year() {
		return this.ledd_7_start_year;
	}

	public void setLedd_7_start_year(String ledd_7_start_year) {
		this.ledd_7_start_year = ledd_7_start_year;
	}
	private String ledd_7_stop_day;

	@Column(name = "ledd_7_stop_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_7_stop_day() {
		return this.ledd_7_stop_day;
	}

	public void setLedd_7_stop_day(String ledd_7_stop_day) {
		this.ledd_7_stop_day = ledd_7_stop_day;
	}
	private String ledd_7_stop_month;

	@Column(name = "ledd_7_stop_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_7_stop_month() {
		return this.ledd_7_stop_month;
	}

	public void setLedd_7_stop_month(String ledd_7_stop_month) {
		this.ledd_7_stop_month = ledd_7_stop_month;
	}
	private String ledd_7_stop_year;

	@Column(name = "ledd_7_stop_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_7_stop_year() {
		return this.ledd_7_stop_year;
	}

	public void setLedd_7_stop_year(String ledd_7_stop_year) {
		this.ledd_7_stop_year = ledd_7_stop_year;
	}
	private String ledd_7_tab;

	@Column(name = "ledd_7_tab", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_7_tab() {
		return this.ledd_7_tab;
	}

	public void setLedd_7_tab(String ledd_7_tab) {
		this.ledd_7_tab = ledd_7_tab;
	}
	private String ledd_7_units;

	@Column(name = "ledd_7_units", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_7_units() {
		return this.ledd_7_units;
	}

	public void setLedd_7_units(String ledd_7_units) {
		this.ledd_7_units = ledd_7_units;
	}
	private String ledd_8_dose;

	@Column(name = "ledd_8_dose", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_8_dose() {
		return this.ledd_8_dose;
	}

	public void setLedd_8_dose(String ledd_8_dose) {
		this.ledd_8_dose = ledd_8_dose;
	}
	private String ledd_8_freq;

	@Column(name = "ledd_8_freq", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_8_freq() {
		return this.ledd_8_freq;
	}

	public void setLedd_8_freq(String ledd_8_freq) {
		this.ledd_8_freq = ledd_8_freq;
	}
	private String ledd_8_name;

	@Column(name = "ledd_8_name", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_8_name() {
		return this.ledd_8_name;
	}

	public void setLedd_8_name(String ledd_8_name) {
		this.ledd_8_name = ledd_8_name;
	}
	private String ledd_8_ongoing;

	@Column(name = "ledd_8_ongoing", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_8_ongoing() {
		return this.ledd_8_ongoing;
	}

	public void setLedd_8_ongoing(String ledd_8_ongoing) {
		this.ledd_8_ongoing = ledd_8_ongoing;
	}
	private String ledd_8_start_day;

	@Column(name = "ledd_8_start_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_8_start_day() {
		return this.ledd_8_start_day;
	}

	public void setLedd_8_start_day(String ledd_8_start_day) {
		this.ledd_8_start_day = ledd_8_start_day;
	}
	private String ledd_8_start_month;

	@Column(name = "ledd_8_start_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_8_start_month() {
		return this.ledd_8_start_month;
	}

	public void setLedd_8_start_month(String ledd_8_start_month) {
		this.ledd_8_start_month = ledd_8_start_month;
	}
	private String ledd_8_start_year;

	@Column(name = "ledd_8_start_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_8_start_year() {
		return this.ledd_8_start_year;
	}

	public void setLedd_8_start_year(String ledd_8_start_year) {
		this.ledd_8_start_year = ledd_8_start_year;
	}
	private String ledd_8_stop_day;

	@Column(name = "ledd_8_stop_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_8_stop_day() {
		return this.ledd_8_stop_day;
	}

	public void setLedd_8_stop_day(String ledd_8_stop_day) {
		this.ledd_8_stop_day = ledd_8_stop_day;
	}
	private String ledd_8_stop_month;

	@Column(name = "ledd_8_stop_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_8_stop_month() {
		return this.ledd_8_stop_month;
	}

	public void setLedd_8_stop_month(String ledd_8_stop_month) {
		this.ledd_8_stop_month = ledd_8_stop_month;
	}
	private String ledd_8_stop_year;

	@Column(name = "ledd_8_stop_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_8_stop_year() {
		return this.ledd_8_stop_year;
	}

	public void setLedd_8_stop_year(String ledd_8_stop_year) {
		this.ledd_8_stop_year = ledd_8_stop_year;
	}
	private String ledd_8_tab;

	@Column(name = "ledd_8_tab", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_8_tab() {
		return this.ledd_8_tab;
	}

	public void setLedd_8_tab(String ledd_8_tab) {
		this.ledd_8_tab = ledd_8_tab;
	}
	private String ledd_8_units;

	@Column(name = "ledd_8_units", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_8_units() {
		return this.ledd_8_units;
	}

	public void setLedd_8_units(String ledd_8_units) {
		this.ledd_8_units = ledd_8_units;
	}
	private String ledd_9_dose;

	@Column(name = "ledd_9_dose", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_9_dose() {
		return this.ledd_9_dose;
	}

	public void setLedd_9_dose(String ledd_9_dose) {
		this.ledd_9_dose = ledd_9_dose;
	}
	private String ledd_9_freq;

	@Column(name = "ledd_9_freq", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_9_freq() {
		return this.ledd_9_freq;
	}

	public void setLedd_9_freq(String ledd_9_freq) {
		this.ledd_9_freq = ledd_9_freq;
	}
	private String ledd_9_name;

	@Column(name = "ledd_9_name", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_9_name() {
		return this.ledd_9_name;
	}

	public void setLedd_9_name(String ledd_9_name) {
		this.ledd_9_name = ledd_9_name;
	}
	private String ledd_9_ongoing;

	@Column(name = "ledd_9_ongoing", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_9_ongoing() {
		return this.ledd_9_ongoing;
	}

	public void setLedd_9_ongoing(String ledd_9_ongoing) {
		this.ledd_9_ongoing = ledd_9_ongoing;
	}
	private String ledd_9_start_day;

	@Column(name = "ledd_9_start_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_9_start_day() {
		return this.ledd_9_start_day;
	}

	public void setLedd_9_start_day(String ledd_9_start_day) {
		this.ledd_9_start_day = ledd_9_start_day;
	}
	private String ledd_9_start_month;

	@Column(name = "ledd_9_start_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_9_start_month() {
		return this.ledd_9_start_month;
	}

	public void setLedd_9_start_month(String ledd_9_start_month) {
		this.ledd_9_start_month = ledd_9_start_month;
	}
	private String ledd_9_start_year;

	@Column(name = "ledd_9_start_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_9_start_year() {
		return this.ledd_9_start_year;
	}

	public void setLedd_9_start_year(String ledd_9_start_year) {
		this.ledd_9_start_year = ledd_9_start_year;
	}
	private String ledd_9_stop_day;

	@Column(name = "ledd_9_stop_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_9_stop_day() {
		return this.ledd_9_stop_day;
	}

	public void setLedd_9_stop_day(String ledd_9_stop_day) {
		this.ledd_9_stop_day = ledd_9_stop_day;
	}
	private String ledd_9_stop_month;

	@Column(name = "ledd_9_stop_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_9_stop_month() {
		return this.ledd_9_stop_month;
	}

	public void setLedd_9_stop_month(String ledd_9_stop_month) {
		this.ledd_9_stop_month = ledd_9_stop_month;
	}
	private String ledd_9_stop_year;

	@Column(name = "ledd_9_stop_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_9_stop_year() {
		return this.ledd_9_stop_year;
	}

	public void setLedd_9_stop_year(String ledd_9_stop_year) {
		this.ledd_9_stop_year = ledd_9_stop_year;
	}
	private String ledd_9_tab;

	@Column(name = "ledd_9_tab", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_9_tab() {
		return this.ledd_9_tab;
	}

	public void setLedd_9_tab(String ledd_9_tab) {
		this.ledd_9_tab = ledd_9_tab;
	}
	private String ledd_9_units;

	@Column(name = "ledd_9_units", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLedd_9_units() {
		return this.ledd_9_units;
	}

	public void setLedd_9_units(String ledd_9_units) {
		this.ledd_9_units = ledd_9_units;
	}
	private String surg_comm;

	@Column(name = "surg_comm", nullable = true, columnDefinition = "varchar", length = 128)
	public String getSurg_comm() {
		return this.surg_comm;
	}

	public void setSurg_comm(String surg_comm) {
		this.surg_comm = surg_comm;
	}
	private String surg_date_stop_day;

	@Column(name = "surg_date_stop_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getSurg_date_stop_day() {
		return this.surg_date_stop_day;
	}

	public void setSurg_date_stop_day(String surg_date_stop_day) {
		this.surg_date_stop_day = surg_date_stop_day;
	}
	private String surg_date_stop_month;

	@Column(name = "surg_date_stop_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getSurg_date_stop_month() {
		return this.surg_date_stop_month;
	}

	public void setSurg_date_stop_month(String surg_date_stop_month) {
		this.surg_date_stop_month = surg_date_stop_month;
	}
	private String surg_date_stop_year;

	@Column(name = "surg_date_stop_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getSurg_date_stop_year() {
		return this.surg_date_stop_year;
	}

	public void setSurg_date_stop_year(String surg_date_stop_year) {
		this.surg_date_stop_year = surg_date_stop_year;
	}
	private String surg_loc;

	@Column(name = "surg_loc", nullable = true, columnDefinition = "varchar", length = 128)
	public String getSurg_loc() {
		return this.surg_loc;
	}

	public void setSurg_loc(String surg_loc) {
		this.surg_loc = surg_loc;
	}
	private String surg_loc_oth;

	@Column(name = "surg_loc_oth", nullable = true, columnDefinition = "varchar", length = 128)
	public String getSurg_loc_oth() {
		return this.surg_loc_oth;
	}

	public void setSurg_loc_oth(String surg_loc_oth) {
		this.surg_loc_oth = surg_loc_oth;
	}
	private String surg_other;

	@Column(name = "surg_other", nullable = true, columnDefinition = "varchar", length = 128)
	public String getSurg_other() {
		return this.surg_other;
	}

	public void setSurg_other(String surg_other) {
		this.surg_other = surg_other;
	}
	private String surg_side;

	@Column(name = "surg_side", nullable = true, columnDefinition = "varchar", length = 128)
	public String getSurg_side() {
		return this.surg_side;
	}

	public void setSurg_side(String surg_side) {
		this.surg_side = surg_side;
	}
	private String surg_type;

	@Column(name = "surg_type", nullable = true, columnDefinition = "varchar", length = 128)
	public String getSurg_type() {
		return this.surg_type;
	}

	public void setSurg_type(String surg_type) {
		this.surg_type = surg_type;
	}

	public String getStatusColor() {
		// Проверяем, заполнены ли все элементы хотя бы в одной секции
		boolean allSectionsCompleted = areAllSectionsCompleted();

		if (allSectionsCompleted) {
			return "green"; // Все секции заполнены
		} else if (isAtLeastOneSectionPartiallyCompleted()) {
			return "orange"; // Некоторые секции заполнены частично
		} else {
			return "blue"; // Ни одна секция не заполнена
		}
}

	private boolean areAllSectionsCompleted() {
		boolean atLeastOneSectionExists = false;
		
		// Проверяем каждую секцию
		for (int i = 1; i <= 10; i++) {
			// Если секция не пустая (имеет хотя бы одно заполненное поле)
			if (isSectionPartiallyCompleted(i)) {
				atLeastOneSectionExists = true;
				// Если секция не полностью заполнена, возвращаем false
				if (!isSectionCompleted(i)) {
					return false;
				}
			}
		}
		
		// Возвращаем true только если есть хотя бы одна непустая секция
		// и все непустые секции полностью заполнены
		return atLeastOneSectionExists;
	}

	private boolean isAtLeastOneSectionPartiallyCompleted() {
		// Проверяем, заполнена ли хотя бы одна секция частично
		for (int i = 1; i <= 10; i++) {
			if (isSectionPartiallyCompleted(i)) {
				return true;
			}
		}
		return false;
	}

	private boolean isSectionCompleted(int sectionNumber) {
		// Проверяем, заполнены ли все элементы в секции
		switch (sectionNumber) {
			case 1:
				return !isEmpty(this.ledd_1_dose) &&
						!isEmpty(this.ledd_1_freq) &&
						!isEmpty(this.ledd_1_name) &&
						!isEmpty(this.ledd_1_ongoing) &&
						!isEmpty(this.ledd_1_start_day) &&
						!isEmpty(this.ledd_1_start_month) &&
						!isEmpty(this.ledd_1_start_year) &&
						!isEmpty(this.ledd_1_stop_day) &&
						!isEmpty(this.ledd_1_stop_month) &&
						!isEmpty(this.ledd_1_stop_year) &&
						!isEmpty(this.ledd_1_tab) &&
						!isEmpty(this.ledd_1_units);
			case 2:
				return !isEmpty(this.ledd_2_dose) &&
						!isEmpty(this.ledd_2_freq) &&
						!isEmpty(this.ledd_2_name) &&
						!isEmpty(this.ledd_2_ongoing) &&
						!isEmpty(this.ledd_2_start_day) &&
						!isEmpty(this.ledd_2_start_month) &&
						!isEmpty(this.ledd_2_start_year) &&
						!isEmpty(this.ledd_2_stop_day) &&
						!isEmpty(this.ledd_2_stop_month) &&
						!isEmpty(this.ledd_2_stop_year) &&
						!isEmpty(this.ledd_2_tab) &&
						!isEmpty(this.ledd_2_units);

			case 3:
				return !isEmpty(this.ledd_3_dose) &&
						!isEmpty(this.ledd_3_freq) &&
						!isEmpty(this.ledd_3_name) &&
						!isEmpty(this.ledd_3_ongoing) &&
						!isEmpty(this.ledd_3_start_day) &&
						!isEmpty(this.ledd_3_start_month) &&
						!isEmpty(this.ledd_3_start_year) &&
						!isEmpty(this.ledd_3_stop_day) &&
						!isEmpty(this.ledd_3_stop_month) &&
						!isEmpty(this.ledd_3_stop_year) &&
						!isEmpty(this.ledd_3_tab) &&
						!isEmpty(this.ledd_3_units);

			case 4:
				return !isEmpty(this.ledd_4_dose) &&
						!isEmpty(this.ledd_4_freq) &&
						!isEmpty(this.ledd_4_name) &&
						!isEmpty(this.ledd_4_ongoing) &&
						!isEmpty(this.ledd_4_start_day) &&
						!isEmpty(this.ledd_4_start_month) &&
						!isEmpty(this.ledd_4_start_year) &&
						!isEmpty(this.ledd_4_stop_day) &&
						!isEmpty(this.ledd_4_stop_month) &&
						!isEmpty(this.ledd_4_stop_year) &&
						!isEmpty(this.ledd_4_tab) &&
						!isEmpty(this.ledd_4_units);

			case 5:
				return !isEmpty(this.ledd_5_dose) &&
						!isEmpty(this.ledd_5_freq) &&
						!isEmpty(this.ledd_5_name) &&
						!isEmpty(this.ledd_5_ongoing) &&
						!isEmpty(this.ledd_5_start_day) &&
						!isEmpty(this.ledd_5_start_month) &&
						!isEmpty(this.ledd_5_start_year) &&
						!isEmpty(this.ledd_5_stop_day) &&
						!isEmpty(this.ledd_5_stop_month) &&
						!isEmpty(this.ledd_5_stop_year) &&
						!isEmpty(this.ledd_5_tab) &&
						!isEmpty(this.ledd_5_units);

			case 6:
				return !isEmpty(this.ledd_6_dose) &&
						!isEmpty(this.ledd_6_freq) &&
						!isEmpty(this.ledd_6_name) &&
						!isEmpty(this.ledd_6_ongoing) &&
						!isEmpty(this.ledd_6_start_day) &&
						!isEmpty(this.ledd_6_start_month) &&
						!isEmpty(this.ledd_6_start_year) &&
						!isEmpty(this.ledd_6_stop_day) &&
						!isEmpty(this.ledd_6_stop_month) &&
						!isEmpty(this.ledd_6_stop_year) &&
						!isEmpty(this.ledd_6_tab) &&
						!isEmpty(this.ledd_6_units);

			case 7:
				return !isEmpty(this.ledd_7_dose) &&
						!isEmpty(this.ledd_7_freq) &&
						!isEmpty(this.ledd_7_name) &&
						!isEmpty(this.ledd_7_ongoing) &&
						!isEmpty(this.ledd_7_start_day) &&
						!isEmpty(this.ledd_7_start_month) &&
						!isEmpty(this.ledd_7_start_year) &&
						!isEmpty(this.ledd_7_stop_day) &&
						!isEmpty(this.ledd_7_stop_month) &&
						!isEmpty(this.ledd_7_stop_year) &&
						!isEmpty(this.ledd_7_tab) &&
						!isEmpty(this.ledd_7_units);

			case 8:
				return !isEmpty(this.ledd_8_dose) &&
						!isEmpty(this.ledd_8_freq) &&
						!isEmpty(this.ledd_8_name) &&
						!isEmpty(this.ledd_8_ongoing) &&
						!isEmpty(this.ledd_8_start_day) &&
						!isEmpty(this.ledd_8_start_month) &&
						!isEmpty(this.ledd_8_start_year) &&
						!isEmpty(this.ledd_8_stop_day) &&
						!isEmpty(this.ledd_8_stop_month) &&
						!isEmpty(this.ledd_8_stop_year) &&
						!isEmpty(this.ledd_8_tab) &&
						!isEmpty(this.ledd_8_units);

			case 9:
				return !isEmpty(this.ledd_9_dose) &&
						!isEmpty(this.ledd_9_freq) &&
						!isEmpty(this.ledd_9_name) &&
						!isEmpty(this.ledd_9_ongoing) &&
						!isEmpty(this.ledd_9_start_day) &&
						!isEmpty(this.ledd_9_start_month) &&
						!isEmpty(this.ledd_9_start_year) &&
						!isEmpty(this.ledd_9_stop_day) &&
						!isEmpty(this.ledd_9_stop_month) &&
						!isEmpty(this.ledd_9_stop_year) &&
						!isEmpty(this.ledd_9_tab) &&
						!isEmpty(this.ledd_9_units);

			case 10:
				return !isEmpty(this.ledd_10_dose) &&
						!isEmpty(this.ledd_10_freq) &&
						!isEmpty(this.ledd_10_name) &&
						!isEmpty(this.ledd_10_ongoing) &&
						!isEmpty(this.ledd_10_start_day) &&
						!isEmpty(this.ledd_10_start_month) &&
						!isEmpty(this.ledd_10_start_year) &&
						!isEmpty(this.ledd_10_stop_day) &&
						!isEmpty(this.ledd_10_stop_month) &&
						!isEmpty(this.ledd_10_stop_year) &&
						!isEmpty(this.ledd_10_tab) &&
						!isEmpty(this.ledd_10_units);
			default:
				return false;
		}
	}

	private boolean isSectionPartiallyCompleted(int sectionNumber) {
		// Проверяем, заполнена ли хотя бы одна часть секции
		switch (sectionNumber) {
			case 1:
				return !isEmpty(this.ledd_1_dose) ||
						!isEmpty(this.ledd_1_freq) ||
						!isEmpty(this.ledd_1_name) ||
						!isEmpty(this.ledd_1_ongoing) ||
						!isEmpty(this.ledd_1_start_day) ||
						!isEmpty(this.ledd_1_start_month) ||
						!isEmpty(this.ledd_1_start_year) ||
						!isEmpty(this.ledd_1_stop_day) ||
						!isEmpty(this.ledd_1_stop_month) ||
						!isEmpty(this.ledd_1_stop_year) ||
						!isEmpty(this.ledd_1_tab) ||
						!isEmpty(this.ledd_1_units);

			case 2:
				return !isEmpty(this.ledd_2_dose) ||
						!isEmpty(this.ledd_2_freq) ||
						!isEmpty(this.ledd_2_name) ||
						!isEmpty(this.ledd_2_ongoing) ||
						!isEmpty(this.ledd_2_start_day) ||
						!isEmpty(this.ledd_2_start_month) ||
						!isEmpty(this.ledd_2_start_year) ||
						!isEmpty(this.ledd_2_stop_day) ||
						!isEmpty(this.ledd_2_stop_month) ||
						!isEmpty(this.ledd_2_stop_year) ||
						!isEmpty(this.ledd_2_tab) ||
						!isEmpty(this.ledd_2_units);

			case 3:
				return !isEmpty(this.ledd_3_dose) ||
						!isEmpty(this.ledd_3_freq) ||
						!isEmpty(this.ledd_3_name) ||
						!isEmpty(this.ledd_3_ongoing) ||
						!isEmpty(this.ledd_3_start_day) ||
						!isEmpty(this.ledd_3_start_month) ||
						!isEmpty(this.ledd_3_start_year) ||
						!isEmpty(this.ledd_3_stop_day) ||
						!isEmpty(this.ledd_3_stop_month) ||
						!isEmpty(this.ledd_3_stop_year) ||
						!isEmpty(this.ledd_3_tab) ||
						!isEmpty(this.ledd_3_units);

			case 4:
				return !isEmpty(this.ledd_4_dose) ||
						!isEmpty(this.ledd_4_freq) ||
						!isEmpty(this.ledd_4_name) ||
						!isEmpty(this.ledd_4_ongoing) ||
						!isEmpty(this.ledd_4_start_day) ||
						!isEmpty(this.ledd_4_start_month) ||
						!isEmpty(this.ledd_4_start_year) ||
						!isEmpty(this.ledd_4_stop_day) ||
						!isEmpty(this.ledd_4_stop_month) ||
						!isEmpty(this.ledd_4_stop_year) ||
						!isEmpty(this.ledd_4_tab) ||
						!isEmpty(this.ledd_4_units);

			case 5:
				return !isEmpty(this.ledd_5_dose) ||
						!isEmpty(this.ledd_5_freq) ||
						!isEmpty(this.ledd_5_name) ||
						!isEmpty(this.ledd_5_ongoing) ||
						!isEmpty(this.ledd_5_start_day) ||
						!isEmpty(this.ledd_5_start_month) ||
						!isEmpty(this.ledd_5_start_year) ||
						!isEmpty(this.ledd_5_stop_day) ||
						!isEmpty(this.ledd_5_stop_month) ||
						!isEmpty(this.ledd_5_stop_year) ||
						!isEmpty(this.ledd_5_tab) ||
						!isEmpty(this.ledd_5_units);

			case 6:
				return !isEmpty(this.ledd_6_dose) ||
						!isEmpty(this.ledd_6_freq) ||
						!isEmpty(this.ledd_6_name) ||
						!isEmpty(this.ledd_6_ongoing) ||
						!isEmpty(this.ledd_6_start_day) ||
						!isEmpty(this.ledd_6_start_month) ||
						!isEmpty(this.ledd_6_start_year) ||
						!isEmpty(this.ledd_6_stop_day) ||
						!isEmpty(this.ledd_6_stop_month) ||
						!isEmpty(this.ledd_6_stop_year) ||
						!isEmpty(this.ledd_6_tab) ||
						!isEmpty(this.ledd_6_units);

			case 7:
				return !isEmpty(this.ledd_7_dose) ||
						!isEmpty(this.ledd_7_freq) ||
						!isEmpty(this.ledd_7_name) ||
						!isEmpty(this.ledd_7_ongoing) ||
						!isEmpty(this.ledd_7_start_day) ||
						!isEmpty(this.ledd_7_start_month) ||
						!isEmpty(this.ledd_7_start_year) ||
						!isEmpty(this.ledd_7_stop_day) ||
						!isEmpty(this.ledd_7_stop_month) ||
						!isEmpty(this.ledd_7_stop_year) ||
						!isEmpty(this.ledd_7_tab) ||
						!isEmpty(this.ledd_7_units);

			case 8:
				return !isEmpty(this.ledd_8_dose) ||
						!isEmpty(this.ledd_8_freq) ||
						!isEmpty(this.ledd_8_name) ||
						!isEmpty(this.ledd_8_ongoing) ||
						!isEmpty(this.ledd_8_start_day) ||
						!isEmpty(this.ledd_8_start_month) ||
						!isEmpty(this.ledd_8_start_year) ||
						!isEmpty(this.ledd_8_stop_day) ||
						!isEmpty(this.ledd_8_stop_month) ||
						!isEmpty(this.ledd_8_stop_year) ||
						!isEmpty(this.ledd_8_tab) ||
						!isEmpty(this.ledd_8_units);

			case 9:
				return !isEmpty(this.ledd_9_dose) ||
						!isEmpty(this.ledd_9_freq) ||
						!isEmpty(this.ledd_9_name) ||
						!isEmpty(this.ledd_9_ongoing) ||
						!isEmpty(this.ledd_9_start_day) ||
						!isEmpty(this.ledd_9_start_month) ||
						!isEmpty(this.ledd_9_start_year) ||
						!isEmpty(this.ledd_9_stop_day) ||
						!isEmpty(this.ledd_9_stop_month) ||
						!isEmpty(this.ledd_9_stop_year) ||
						!isEmpty(this.ledd_9_tab) ||
						!isEmpty(this.ledd_9_units);

			case 10:
				return !isEmpty(this.ledd_10_dose) ||
						!isEmpty(this.ledd_10_freq) ||
						!isEmpty(this.ledd_10_name) ||
						!isEmpty(this.ledd_10_ongoing) ||
						!isEmpty(this.ledd_10_start_day) ||
						!isEmpty(this.ledd_10_start_month) ||
						!isEmpty(this.ledd_10_start_year) ||
						!isEmpty(this.ledd_10_stop_day) ||
						!isEmpty(this.ledd_10_stop_month) ||
						!isEmpty(this.ledd_10_stop_year) ||
						!isEmpty(this.ledd_10_tab) ||
						!isEmpty(this.ledd_10_units);

			default:
				return false;
		}
	}

	private boolean isEmpty(String value) {
		// Проверяем, является ли строка пустой или null
		return value == null || value.trim().isEmpty() || value.trim().equals("-");
	}
}

//orange if not all items in one section (1,2, 3,...) are completed, blue if none completed
