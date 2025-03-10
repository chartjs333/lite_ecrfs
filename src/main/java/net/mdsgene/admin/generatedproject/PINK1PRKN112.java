package net.mdsgene.admin.generatedproject;
import java.util.Date;
import javax.persistence.*;
@Entity
@Table(name = "PINK1PRKN112", schema = "public")
@Cacheable(false)
public class PINK1PRKN112 implements java.io.Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PINK1PRKN112_id_seq")
    @SequenceGenerator(name="PINK1PRKN112_id_seq", sequenceName="PINK1PRKN112_id_seq", allocationSize=1)
	@Column(name = "id", unique = true, nullable = false, columnDefinition = "serial")
	private int id;

	public PINK1PRKN112() {
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

	private String lmed_8_ongoing;

	@Column(name = "lmed_8_ongoing", nullable = true, columnDefinition = "varchar", length = 128)
	public String getLmed_8_ongoing() {
		return this.lmed_8_ongoing;
	}

	public void setLmed_8_ongoing(String lmed_8_ongoing) {
		this.lmed_8_ongoing = lmed_8_ongoing;
	}
	private String med_1_ind;

	@Column(name = "med_1_ind", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_1_ind() {
		return this.med_1_ind;
	}

	public void setMed_1_ind(String med_1_ind) {
		this.med_1_ind = med_1_ind;
	}
	private String med_1_name;

	@Column(name = "med_1_name", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_1_name() {
		return this.med_1_name;
	}

	public void setMed_1_name(String med_1_name) {
		this.med_1_name = med_1_name;
	}
	private String med_1_ongoing;

	@Column(name = "med_1_ongoing", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_1_ongoing() {
		return this.med_1_ongoing;
	}

	public void setMed_1_ongoing(String med_1_ongoing) {
		this.med_1_ongoing = med_1_ongoing;
	}
	private String med_1_start_day;

	@Column(name = "med_1_start_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_1_start_day() {
		return this.med_1_start_day;
	}

	public void setMed_1_start_day(String med_1_start_day) {
		this.med_1_start_day = med_1_start_day;
	}
	private String med_1_start_month;

	@Column(name = "med_1_start_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_1_start_month() {
		return this.med_1_start_month;
	}

	public void setMed_1_start_month(String med_1_start_month) {
		this.med_1_start_month = med_1_start_month;
	}
	private String med_1_start_year;

	@Column(name = "med_1_start_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_1_start_year() {
		return this.med_1_start_year;
	}

	public void setMed_1_start_year(String med_1_start_year) {
		this.med_1_start_year = med_1_start_year;
	}
	private String med_1_stop_day;

	@Column(name = "med_1_stop_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_1_stop_day() {
		return this.med_1_stop_day;
	}

	public void setMed_1_stop_day(String med_1_stop_day) {
		this.med_1_stop_day = med_1_stop_day;
	}
	private String med_1_stop_month;

	@Column(name = "med_1_stop_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_1_stop_month() {
		return this.med_1_stop_month;
	}

	public void setMed_1_stop_month(String med_1_stop_month) {
		this.med_1_stop_month = med_1_stop_month;
	}
	private String med_1_stop_year;

	@Column(name = "med_1_stop_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_1_stop_year() {
		return this.med_1_stop_year;
	}

	public void setMed_1_stop_year(String med_1_stop_year) {
		this.med_1_stop_year = med_1_stop_year;
	}
	private String med_2_ind;

	@Column(name = "med_2_ind", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_2_ind() {
		return this.med_2_ind;
	}

	public void setMed_2_ind(String med_2_ind) {
		this.med_2_ind = med_2_ind;
	}
	private String med_2_name;

	@Column(name = "med_2_name", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_2_name() {
		return this.med_2_name;
	}

	public void setMed_2_name(String med_2_name) {
		this.med_2_name = med_2_name;
	}
	private String med_2_ongoing;

	@Column(name = "med_2_ongoing", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_2_ongoing() {
		return this.med_2_ongoing;
	}

	public void setMed_2_ongoing(String med_2_ongoing) {
		this.med_2_ongoing = med_2_ongoing;
	}
	private String med_2_start_day;

	@Column(name = "med_2_start_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_2_start_day() {
		return this.med_2_start_day;
	}

	public void setMed_2_start_day(String med_2_start_day) {
		this.med_2_start_day = med_2_start_day;
	}
	private String med_2_start_month;

	@Column(name = "med_2_start_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_2_start_month() {
		return this.med_2_start_month;
	}

	public void setMed_2_start_month(String med_2_start_month) {
		this.med_2_start_month = med_2_start_month;
	}
	private String med_2_start_year;

	@Column(name = "med_2_start_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_2_start_year() {
		return this.med_2_start_year;
	}

	public void setMed_2_start_year(String med_2_start_year) {
		this.med_2_start_year = med_2_start_year;
	}
	private String med_2_stop_day;

	@Column(name = "med_2_stop_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_2_stop_day() {
		return this.med_2_stop_day;
	}

	public void setMed_2_stop_day(String med_2_stop_day) {
		this.med_2_stop_day = med_2_stop_day;
	}
	private String med_2_stop_month;

	@Column(name = "med_2_stop_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_2_stop_month() {
		return this.med_2_stop_month;
	}

	public void setMed_2_stop_month(String med_2_stop_month) {
		this.med_2_stop_month = med_2_stop_month;
	}
	private String med_2_stop_year;

	@Column(name = "med_2_stop_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_2_stop_year() {
		return this.med_2_stop_year;
	}

	public void setMed_2_stop_year(String med_2_stop_year) {
		this.med_2_stop_year = med_2_stop_year;
	}
	private String med_3_ind;

	@Column(name = "med_3_ind", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_3_ind() {
		return this.med_3_ind;
	}

	public void setMed_3_ind(String med_3_ind) {
		this.med_3_ind = med_3_ind;
	}
	private String med_3_name;

	@Column(name = "med_3_name", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_3_name() {
		return this.med_3_name;
	}

	public void setMed_3_name(String med_3_name) {
		this.med_3_name = med_3_name;
	}
	private String med_3_ongoing;

	@Column(name = "med_3_ongoing", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_3_ongoing() {
		return this.med_3_ongoing;
	}

	public void setMed_3_ongoing(String med_3_ongoing) {
		this.med_3_ongoing = med_3_ongoing;
	}
	private String med_3_start_day;

	@Column(name = "med_3_start_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_3_start_day() {
		return this.med_3_start_day;
	}

	public void setMed_3_start_day(String med_3_start_day) {
		this.med_3_start_day = med_3_start_day;
	}
	private String med_3_start_month;

	@Column(name = "med_3_start_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_3_start_month() {
		return this.med_3_start_month;
	}

	public void setMed_3_start_month(String med_3_start_month) {
		this.med_3_start_month = med_3_start_month;
	}
	private String med_3_start_year;

	@Column(name = "med_3_start_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_3_start_year() {
		return this.med_3_start_year;
	}

	public void setMed_3_start_year(String med_3_start_year) {
		this.med_3_start_year = med_3_start_year;
	}
	private String med_3_stop_day;

	@Column(name = "med_3_stop_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_3_stop_day() {
		return this.med_3_stop_day;
	}

	public void setMed_3_stop_day(String med_3_stop_day) {
		this.med_3_stop_day = med_3_stop_day;
	}
	private String med_3_stop_month;

	@Column(name = "med_3_stop_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_3_stop_month() {
		return this.med_3_stop_month;
	}

	public void setMed_3_stop_month(String med_3_stop_month) {
		this.med_3_stop_month = med_3_stop_month;
	}
	private String med_3_stop_year;

	@Column(name = "med_3_stop_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_3_stop_year() {
		return this.med_3_stop_year;
	}

	public void setMed_3_stop_year(String med_3_stop_year) {
		this.med_3_stop_year = med_3_stop_year;
	}
	private String med_4_ind;

	@Column(name = "med_4_ind", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_4_ind() {
		return this.med_4_ind;
	}

	public void setMed_4_ind(String med_4_ind) {
		this.med_4_ind = med_4_ind;
	}
	private String med_4_name;

	@Column(name = "med_4_name", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_4_name() {
		return this.med_4_name;
	}

	public void setMed_4_name(String med_4_name) {
		this.med_4_name = med_4_name;
	}
	private String med_4_ongoing;

	@Column(name = "med_4_ongoing", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_4_ongoing() {
		return this.med_4_ongoing;
	}

	public void setMed_4_ongoing(String med_4_ongoing) {
		this.med_4_ongoing = med_4_ongoing;
	}
	private String med_4_start_day;

	@Column(name = "med_4_start_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_4_start_day() {
		return this.med_4_start_day;
	}

	public void setMed_4_start_day(String med_4_start_day) {
		this.med_4_start_day = med_4_start_day;
	}
	private String med_4_start_month;

	@Column(name = "med_4_start_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_4_start_month() {
		return this.med_4_start_month;
	}

	public void setMed_4_start_month(String med_4_start_month) {
		this.med_4_start_month = med_4_start_month;
	}
	private String med_4_start_year;

	@Column(name = "med_4_start_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_4_start_year() {
		return this.med_4_start_year;
	}

	public void setMed_4_start_year(String med_4_start_year) {
		this.med_4_start_year = med_4_start_year;
	}
	private String med_4_stop_day;

	@Column(name = "med_4_stop_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_4_stop_day() {
		return this.med_4_stop_day;
	}

	public void setMed_4_stop_day(String med_4_stop_day) {
		this.med_4_stop_day = med_4_stop_day;
	}
	private String med_4_stop_month;

	@Column(name = "med_4_stop_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_4_stop_month() {
		return this.med_4_stop_month;
	}

	public void setMed_4_stop_month(String med_4_stop_month) {
		this.med_4_stop_month = med_4_stop_month;
	}
	private String med_4_stop_year;

	@Column(name = "med_4_stop_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_4_stop_year() {
		return this.med_4_stop_year;
	}

	public void setMed_4_stop_year(String med_4_stop_year) {
		this.med_4_stop_year = med_4_stop_year;
	}
	private String med_5_ind;

	@Column(name = "med_5_ind", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_5_ind() {
		return this.med_5_ind;
	}

	public void setMed_5_ind(String med_5_ind) {
		this.med_5_ind = med_5_ind;
	}
	private String med_5_name;

	@Column(name = "med_5_name", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_5_name() {
		return this.med_5_name;
	}

	public void setMed_5_name(String med_5_name) {
		this.med_5_name = med_5_name;
	}
	private String med_5_ongoing;

	@Column(name = "med_5_ongoing", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_5_ongoing() {
		return this.med_5_ongoing;
	}

	public void setMed_5_ongoing(String med_5_ongoing) {
		this.med_5_ongoing = med_5_ongoing;
	}
	private String med_5_start_day;

	@Column(name = "med_5_start_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_5_start_day() {
		return this.med_5_start_day;
	}

	public void setMed_5_start_day(String med_5_start_day) {
		this.med_5_start_day = med_5_start_day;
	}
	private String med_5_start_month;

	@Column(name = "med_5_start_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_5_start_month() {
		return this.med_5_start_month;
	}

	public void setMed_5_start_month(String med_5_start_month) {
		this.med_5_start_month = med_5_start_month;
	}
	private String med_5_start_year;

	@Column(name = "med_5_start_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_5_start_year() {
		return this.med_5_start_year;
	}

	public void setMed_5_start_year(String med_5_start_year) {
		this.med_5_start_year = med_5_start_year;
	}
	private String med_5_stop_day;

	@Column(name = "med_5_stop_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_5_stop_day() {
		return this.med_5_stop_day;
	}

	public void setMed_5_stop_day(String med_5_stop_day) {
		this.med_5_stop_day = med_5_stop_day;
	}
	private String med_5_stop_month;

	@Column(name = "med_5_stop_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_5_stop_month() {
		return this.med_5_stop_month;
	}

	public void setMed_5_stop_month(String med_5_stop_month) {
		this.med_5_stop_month = med_5_stop_month;
	}
	private String med_5_stop_year;

	@Column(name = "med_5_stop_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_5_stop_year() {
		return this.med_5_stop_year;
	}

	public void setMed_5_stop_year(String med_5_stop_year) {
		this.med_5_stop_year = med_5_stop_year;
	}
	private String med_6_ind;

	@Column(name = "med_6_ind", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_6_ind() {
		return this.med_6_ind;
	}

	public void setMed_6_ind(String med_6_ind) {
		this.med_6_ind = med_6_ind;
	}
	private String med_6_name;

	@Column(name = "med_6_name", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_6_name() {
		return this.med_6_name;
	}

	public void setMed_6_name(String med_6_name) {
		this.med_6_name = med_6_name;
	}
	private String med_6_ongoing;

	@Column(name = "med_6_ongoing", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_6_ongoing() {
		return this.med_6_ongoing;
	}

	public void setMed_6_ongoing(String med_6_ongoing) {
		this.med_6_ongoing = med_6_ongoing;
	}
	private String med_6_start_day;

	@Column(name = "med_6_start_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_6_start_day() {
		return this.med_6_start_day;
	}

	public void setMed_6_start_day(String med_6_start_day) {
		this.med_6_start_day = med_6_start_day;
	}
	private String med_6_start_month;

	@Column(name = "med_6_start_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_6_start_month() {
		return this.med_6_start_month;
	}

	public void setMed_6_start_month(String med_6_start_month) {
		this.med_6_start_month = med_6_start_month;
	}
	private String med_6_start_year;

	@Column(name = "med_6_start_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_6_start_year() {
		return this.med_6_start_year;
	}

	public void setMed_6_start_year(String med_6_start_year) {
		this.med_6_start_year = med_6_start_year;
	}
	private String med_6_stop_day;

	@Column(name = "med_6_stop_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_6_stop_day() {
		return this.med_6_stop_day;
	}

	public void setMed_6_stop_day(String med_6_stop_day) {
		this.med_6_stop_day = med_6_stop_day;
	}
	private String med_6_stop_month;

	@Column(name = "med_6_stop_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_6_stop_month() {
		return this.med_6_stop_month;
	}

	public void setMed_6_stop_month(String med_6_stop_month) {
		this.med_6_stop_month = med_6_stop_month;
	}
	private String med_6_stop_year;

	@Column(name = "med_6_stop_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_6_stop_year() {
		return this.med_6_stop_year;
	}

	public void setMed_6_stop_year(String med_6_stop_year) {
		this.med_6_stop_year = med_6_stop_year;
	}
	private String med_7_ind;

	@Column(name = "med_7_ind", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_7_ind() {
		return this.med_7_ind;
	}

	public void setMed_7_ind(String med_7_ind) {
		this.med_7_ind = med_7_ind;
	}
	private String med_7_name;

	@Column(name = "med_7_name", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_7_name() {
		return this.med_7_name;
	}

	public void setMed_7_name(String med_7_name) {
		this.med_7_name = med_7_name;
	}
	private String med_7_ongoing;

	@Column(name = "med_7_ongoing", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_7_ongoing() {
		return this.med_7_ongoing;
	}

	public void setMed_7_ongoing(String med_7_ongoing) {
		this.med_7_ongoing = med_7_ongoing;
	}
	private String med_7_start_day;

	@Column(name = "med_7_start_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_7_start_day() {
		return this.med_7_start_day;
	}

	public void setMed_7_start_day(String med_7_start_day) {
		this.med_7_start_day = med_7_start_day;
	}
	private String med_7_start_month;

	@Column(name = "med_7_start_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_7_start_month() {
		return this.med_7_start_month;
	}

	public void setMed_7_start_month(String med_7_start_month) {
		this.med_7_start_month = med_7_start_month;
	}
	private String med_7_start_year;

	@Column(name = "med_7_start_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_7_start_year() {
		return this.med_7_start_year;
	}

	public void setMed_7_start_year(String med_7_start_year) {
		this.med_7_start_year = med_7_start_year;
	}
	private String med_7_stop_day;

	@Column(name = "med_7_stop_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_7_stop_day() {
		return this.med_7_stop_day;
	}

	public void setMed_7_stop_day(String med_7_stop_day) {
		this.med_7_stop_day = med_7_stop_day;
	}
	private String med_7_stop_month;

	@Column(name = "med_7_stop_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_7_stop_month() {
		return this.med_7_stop_month;
	}

	public void setMed_7_stop_month(String med_7_stop_month) {
		this.med_7_stop_month = med_7_stop_month;
	}
	private String med_7_stop_year;

	@Column(name = "med_7_stop_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_7_stop_year() {
		return this.med_7_stop_year;
	}

	public void setMed_7_stop_year(String med_7_stop_year) {
		this.med_7_stop_year = med_7_stop_year;
	}
	private String med_8_ind;

	@Column(name = "med_8_ind", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_8_ind() {
		return this.med_8_ind;
	}

	public void setMed_8_ind(String med_8_ind) {
		this.med_8_ind = med_8_ind;
	}
	private String med_8_name;

	@Column(name = "med_8_name", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_8_name() {
		return this.med_8_name;
	}

	public void setMed_8_name(String med_8_name) {
		this.med_8_name = med_8_name;
	}
	private String med_8_start_day;

	@Column(name = "med_8_start_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_8_start_day() {
		return this.med_8_start_day;
	}

	public void setMed_8_start_day(String med_8_start_day) {
		this.med_8_start_day = med_8_start_day;
	}
	private String med_8_start_month;

	@Column(name = "med_8_start_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_8_start_month() {
		return this.med_8_start_month;
	}

	public void setMed_8_start_month(String med_8_start_month) {
		this.med_8_start_month = med_8_start_month;
	}
	private String med_8_start_year;

	@Column(name = "med_8_start_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_8_start_year() {
		return this.med_8_start_year;
	}

	public void setMed_8_start_year(String med_8_start_year) {
		this.med_8_start_year = med_8_start_year;
	}
	private String med_8_stop_day;

	@Column(name = "med_8_stop_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_8_stop_day() {
		return this.med_8_stop_day;
	}

	public void setMed_8_stop_day(String med_8_stop_day) {
		this.med_8_stop_day = med_8_stop_day;
	}
	private String med_8_stop_month;

	@Column(name = "med_8_stop_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_8_stop_month() {
		return this.med_8_stop_month;
	}

	public void setMed_8_stop_month(String med_8_stop_month) {
		this.med_8_stop_month = med_8_stop_month;
	}
	private String med_8_stop_year;

	@Column(name = "med_8_stop_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMed_8_stop_year() {
		return this.med_8_stop_year;
	}

	public void setMed_8_stop_year(String med_8_stop_year) {
		this.med_8_stop_year = med_8_stop_year;
	}

	public String getStatusColor() {
		// Проверяем, заполнены ли все непустые секции
		boolean allSectionsCompleted = areAllSectionsCompleted();

		if (allSectionsCompleted) {
			return "green"; // Все непустые секции полностью заполнены
		} else if (isAtLeastOneSectionPartiallyCompleted()) {
			return "orange"; // Некоторые секции заполнены частично
		} else {
			return "blue"; // Все секции пустые
		}
	}

	private boolean areAllSectionsCompleted() {
		boolean atLeastOneSectionExists = false;
		
		// Проверяем каждую секцию (med_1 до med_8)
		for (int i = 1; i <= 8; i++) {
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
		return  isSectionPartiallyCompleted(1) ||
				isSectionPartiallyCompleted(2) ||
				isSectionPartiallyCompleted(3) ||
				isSectionPartiallyCompleted(4) ||
				isSectionPartiallyCompleted(5) ||
				isSectionPartiallyCompleted(6) ||
				isSectionPartiallyCompleted(7) ||
				isSectionPartiallyCompleted(8);
	}

	private boolean isSectionCompleted(int sectionNumber) {
		String prefix = "med_" + sectionNumber + "_";
		
		// Если секция начата (есть хотя бы одно заполненное поле),
		// проверяем все обязательные поля этой секции
		if (isSectionPartiallyCompleted(sectionNumber)) {
			return isFieldCompleted(getFieldValue(prefix + "ind")) &&
				   isFieldCompleted(getFieldValue(prefix + "name")) &&
				   isFieldCompleted(getFieldValue(prefix + "ongoing")) &&
				   isFieldCompleted(getFieldValue(prefix + "start_day")) &&
				   isFieldCompleted(getFieldValue(prefix + "start_month")) &&
				   isFieldCompleted(getFieldValue(prefix + "start_year"));
		}
		return true; // Пустая секция считается заполненной
	}

	private boolean isSectionPartiallyCompleted(int sectionNumber) {
		String prefix = "med_" + sectionNumber + "_";
		
		// Проверяем наличие хотя бы одного заполненного поля в секции
		return isFieldCompleted(getFieldValue(prefix + "ind")) ||
			   isFieldCompleted(getFieldValue(prefix + "name")) ||
			   isFieldCompleted(getFieldValue(prefix + "ongoing")) ||
			   isFieldCompleted(getFieldValue(prefix + "start_day")) ||
			   isFieldCompleted(getFieldValue(prefix + "start_month")) ||
			   isFieldCompleted(getFieldValue(prefix + "start_year")) ||
			   isFieldCompleted(getFieldValue(prefix + "stop_day")) ||
			   isFieldCompleted(getFieldValue(prefix + "stop_month")) ||
			   isFieldCompleted(getFieldValue(prefix + "stop_year"));
	}

	private String getFieldValue(String fieldName) {
		try {
			String getterName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
			return (String) getClass().getMethod(getterName).invoke(this);
		} catch (Exception e) {
			return null;
		}
	}

	private boolean isFieldCompleted(String value) {
		return value != null && !value.trim().isEmpty() && !value.trim().equals("-");
	}
}

//orange if not all items in one section (1,2, 3,4,5,6,7,8) are completed, blue if none completed


