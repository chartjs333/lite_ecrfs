package net.mdsgene.admin.generatedproject;
import java.util.Date;
import javax.persistence.*;
@Entity
@Table(name = "PINK1PRKN14", schema = "public")
@Cacheable(false)
public class PINK1PRKN14 implements java.io.Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PINK1PRKN14_id_seq")
    @SequenceGenerator(name="PINK1PRKN14_id_seq", sequenceName="PINK1PRKN14_id_seq", allocationSize=1)
	@Column(name = "id", unique = true, nullable = false, columnDefinition = "serial")
	private int id;

	public PINK1PRKN14() {
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

	private String biom_edta;

	@Column(name = "biom_edta", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_edta() {
		return this.biom_edta;
	}

	public void setBiom_edta(String biom_edta) {
		this.biom_edta = biom_edta;
	}
	private String biom_edta_date_day;

	@Column(name = "biom_edta_date_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_edta_date_day() {
		return this.biom_edta_date_day;
	}

	public void setBiom_edta_date_day(String biom_edta_date_day) {
		this.biom_edta_date_day = biom_edta_date_day;
	}
	private String biom_edta_date_month;

	@Column(name = "biom_edta_date_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_edta_date_month() {
		return this.biom_edta_date_month;
	}

	public void setBiom_edta_date_month(String biom_edta_date_month) {
		this.biom_edta_date_month = biom_edta_date_month;
	}
	private String biom_edta_date_year;

	@Column(name = "biom_edta_date_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_edta_date_year() {
		return this.biom_edta_date_year;
	}

	public void setBiom_edta_date_year(String biom_edta_date_year) {
		this.biom_edta_date_year = biom_edta_date_year;
	}
	private String biom_edta_freeze_date_day;

	@Column(name = "biom_edta_freeze_date_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_edta_freeze_date_day() {
		return this.biom_edta_freeze_date_day;
	}

	public void setBiom_edta_freeze_date_day(String biom_edta_freeze_date_day) {
		this.biom_edta_freeze_date_day = biom_edta_freeze_date_day;
	}
	private String biom_edta_freeze_date_month;

	@Column(name = "biom_edta_freeze_date_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_edta_freeze_date_month() {
		return this.biom_edta_freeze_date_month;
	}

	public void setBiom_edta_freeze_date_month(String biom_edta_freeze_date_month) {
		this.biom_edta_freeze_date_month = biom_edta_freeze_date_month;
	}
	private String biom_edta_freeze_date_year;

	@Column(name = "biom_edta_freeze_date_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_edta_freeze_date_year() {
		return this.biom_edta_freeze_date_year;
	}

	public void setBiom_edta_freeze_date_year(String biom_edta_freeze_date_year) {
		this.biom_edta_freeze_date_year = biom_edta_freeze_date_year;
	}
	private String biom_edta_freeze_time;

	@Column(name = "biom_edta_freeze_time", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_edta_freeze_time() {
		return this.biom_edta_freeze_time;
	}

	public void setBiom_edta_freeze_time(String biom_edta_freeze_time) {
		this.biom_edta_freeze_time = biom_edta_freeze_time;
	}
	private String biom_edta_q;

	@Column(name = "biom_edta_q", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_edta_q() {
		return this.biom_edta_q;
	}

	public void setBiom_edta_q(String biom_edta_q) {
		this.biom_edta_q = biom_edta_q;
	}
	private String biom_edta_temp;

	@Column(name = "biom_edta_temp", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_edta_temp() {
		return this.biom_edta_temp;
	}

	public void setBiom_edta_temp(String biom_edta_temp) {
		this.biom_edta_temp = biom_edta_temp;
	}
	private String biom_edta_time;

	@Column(name = "biom_edta_time", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_edta_time() {
		return this.biom_edta_time;
	}

	public void setBiom_edta_time(String biom_edta_time) {
		this.biom_edta_time = biom_edta_time;
	}
	private String biom_fasting;

	@Column(name = "biom_fasting", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_fasting() {
		return this.biom_fasting;
	}

	public void setBiom_fasting(String biom_fasting) {
		this.biom_fasting = biom_fasting;
	}
	private String biom_food_date_day;

	@Column(name = "biom_food_date_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_food_date_day() {
		return this.biom_food_date_day;
	}

	public void setBiom_food_date_day(String biom_food_date_day) {
		this.biom_food_date_day = biom_food_date_day;
	}
	private String biom_food_date_month;

	@Column(name = "biom_food_date_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_food_date_month() {
		return this.biom_food_date_month;
	}

	public void setBiom_food_date_month(String biom_food_date_month) {
		this.biom_food_date_month = biom_food_date_month;
	}
	private String biom_food_date_year;

	@Column(name = "biom_food_date_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_food_date_year() {
		return this.biom_food_date_year;
	}

	public void setBiom_food_date_year(String biom_food_date_year) {
		this.biom_food_date_year = biom_food_date_year;
	}
	private String biom_food_time;

	@Column(name = "biom_food_time", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_food_time() {
		return this.biom_food_time;
	}

	public void setBiom_food_time(String biom_food_time) {
		this.biom_food_time = biom_food_time;
	}
	private String biom_pax;

	@Column(name = "biom_pax", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_pax() {
		return this.biom_pax;
	}

	public void setBiom_pax(String biom_pax) {
		this.biom_pax = biom_pax;
	}
	private String biom_pax_date_day;

	@Column(name = "biom_pax_date_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_pax_date_day() {
		return this.biom_pax_date_day;
	}

	public void setBiom_pax_date_day(String biom_pax_date_day) {
		this.biom_pax_date_day = biom_pax_date_day;
	}
	private String biom_pax_date_month;

	@Column(name = "biom_pax_date_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_pax_date_month() {
		return this.biom_pax_date_month;
	}

	public void setBiom_pax_date_month(String biom_pax_date_month) {
		this.biom_pax_date_month = biom_pax_date_month;
	}
	private String biom_pax_date_year;

	@Column(name = "biom_pax_date_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_pax_date_year() {
		return this.biom_pax_date_year;
	}

	public void setBiom_pax_date_year(String biom_pax_date_year) {
		this.biom_pax_date_year = biom_pax_date_year;
	}
	private String biom_pax_freeze_time;

	@Column(name = "biom_pax_freeze_time", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_pax_freeze_time() {
		return this.biom_pax_freeze_time;
	}

	public void setBiom_pax_freeze_time(String biom_pax_freeze_time) {
		this.biom_pax_freeze_time = biom_pax_freeze_time;
	}
	private String biom_pax_q;

	@Column(name = "biom_pax_q", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_pax_q() {
		return this.biom_pax_q;
	}

	public void setBiom_pax_q(String biom_pax_q) {
		this.biom_pax_q = biom_pax_q;
	}
	private String biom_pax_temp;

	@Column(name = "biom_pax_temp", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_pax_temp() {
		return this.biom_pax_temp;
	}

	public void setBiom_pax_temp(String biom_pax_temp) {
		this.biom_pax_temp = biom_pax_temp;
	}
	private String biom_pax_time;

	@Column(name = "biom_pax_time", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_pax_time() {
		return this.biom_pax_time;
	}

	public void setBiom_pax_time(String biom_pax_time) {
		this.biom_pax_time = biom_pax_time;
	}
	private String biom_pax_time_date_day;

	@Column(name = "biom_pax_time_date_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_pax_time_date_day() {
		return this.biom_pax_time_date_day;
	}

	public void setBiom_pax_time_date_day(String biom_pax_time_date_day) {
		this.biom_pax_time_date_day = biom_pax_time_date_day;
	}
	private String biom_pax_time_date_month;

	@Column(name = "biom_pax_time_date_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_pax_time_date_month() {
		return this.biom_pax_time_date_month;
	}

	public void setBiom_pax_time_date_month(String biom_pax_time_date_month) {
		this.biom_pax_time_date_month = biom_pax_time_date_month;
	}
	private String biom_pax_time_date_year;

	@Column(name = "biom_pax_time_date_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_pax_time_date_year() {
		return this.biom_pax_time_date_year;
	}

	public void setBiom_pax_time_date_year(String biom_pax_time_date_year) {
		this.biom_pax_time_date_year = biom_pax_time_date_year;
	}
	private String biom_pbmcs;

	@Column(name = "biom_pbmcs", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_pbmcs() {
		return this.biom_pbmcs;
	}

	public void setBiom_pbmcs(String biom_pbmcs) {
		this.biom_pbmcs = biom_pbmcs;
	}
	private String biom_pbmcs_date_day;

	@Column(name = "biom_pbmcs_date_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_pbmcs_date_day() {
		return this.biom_pbmcs_date_day;
	}

	public void setBiom_pbmcs_date_day(String biom_pbmcs_date_day) {
		this.biom_pbmcs_date_day = biom_pbmcs_date_day;
	}
	private String biom_pbmcs_date_month;

	@Column(name = "biom_pbmcs_date_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_pbmcs_date_month() {
		return this.biom_pbmcs_date_month;
	}

	public void setBiom_pbmcs_date_month(String biom_pbmcs_date_month) {
		this.biom_pbmcs_date_month = biom_pbmcs_date_month;
	}
	private String biom_pbmcs_date_year;

	@Column(name = "biom_pbmcs_date_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_pbmcs_date_year() {
		return this.biom_pbmcs_date_year;
	}

	public void setBiom_pbmcs_date_year(String biom_pbmcs_date_year) {
		this.biom_pbmcs_date_year = biom_pbmcs_date_year;
	}
	private String biom_pbmcs_freeze_date_day;

	@Column(name = "biom_pbmcs_freeze_date_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_pbmcs_freeze_date_day() {
		return this.biom_pbmcs_freeze_date_day;
	}

	public void setBiom_pbmcs_freeze_date_day(String biom_pbmcs_freeze_date_day) {
		this.biom_pbmcs_freeze_date_day = biom_pbmcs_freeze_date_day;
	}
	private String biom_pbmcs_freeze_date_month;

	@Column(name = "biom_pbmcs_freeze_date_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_pbmcs_freeze_date_month() {
		return this.biom_pbmcs_freeze_date_month;
	}

	public void setBiom_pbmcs_freeze_date_month(String biom_pbmcs_freeze_date_month) {
		this.biom_pbmcs_freeze_date_month = biom_pbmcs_freeze_date_month;
	}
	private String biom_pbmcs_freeze_date_year;

	@Column(name = "biom_pbmcs_freeze_date_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_pbmcs_freeze_date_year() {
		return this.biom_pbmcs_freeze_date_year;
	}

	public void setBiom_pbmcs_freeze_date_year(String biom_pbmcs_freeze_date_year) {
		this.biom_pbmcs_freeze_date_year = biom_pbmcs_freeze_date_year;
	}
	private String biom_pbmcs_freeze_time;

	@Column(name = "biom_pbmcs_freeze_time", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_pbmcs_freeze_time() {
		return this.biom_pbmcs_freeze_time;
	}

	public void setBiom_pbmcs_freeze_time(String biom_pbmcs_freeze_time) {
		this.biom_pbmcs_freeze_time = biom_pbmcs_freeze_time;
	}
	private String biom_pbmcs_q;

	@Column(name = "biom_pbmcs_q", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_pbmcs_q() {
		return this.biom_pbmcs_q;
	}

	public void setBiom_pbmcs_q(String biom_pbmcs_q) {
		this.biom_pbmcs_q = biom_pbmcs_q;
	}
	private String biom_pbmcs_temp;

	@Column(name = "biom_pbmcs_temp", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_pbmcs_temp() {
		return this.biom_pbmcs_temp;
	}

	public void setBiom_pbmcs_temp(String biom_pbmcs_temp) {
		this.biom_pbmcs_temp = biom_pbmcs_temp;
	}
	private String biom_pbmcs_time;

	@Column(name = "biom_pbmcs_time", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_pbmcs_time() {
		return this.biom_pbmcs_time;
	}

	public void setBiom_pbmcs_time(String biom_pbmcs_time) {
		this.biom_pbmcs_time = biom_pbmcs_time;
	}
	private String biom_pdmed;

	@Column(name = "biom_pdmed", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_pdmed() {
		return this.biom_pdmed;
	}

	public void setBiom_pdmed(String biom_pdmed) {
		this.biom_pdmed = biom_pdmed;
	}
	private String biom_pdmed_date_day;

	@Column(name = "biom_pdmed_date_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_pdmed_date_day() {
		return this.biom_pdmed_date_day;
	}

	public void setBiom_pdmed_date_day(String biom_pdmed_date_day) {
		this.biom_pdmed_date_day = biom_pdmed_date_day;
	}
	private String biom_pdmed_date_month;

	@Column(name = "biom_pdmed_date_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_pdmed_date_month() {
		return this.biom_pdmed_date_month;
	}

	public void setBiom_pdmed_date_month(String biom_pdmed_date_month) {
		this.biom_pdmed_date_month = biom_pdmed_date_month;
	}
	private String biom_pdmed_date_year;

	@Column(name = "biom_pdmed_date_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_pdmed_date_year() {
		return this.biom_pdmed_date_year;
	}

	public void setBiom_pdmed_date_year(String biom_pdmed_date_year) {
		this.biom_pdmed_date_year = biom_pdmed_date_year;
	}
	private String biom_pdmed_time;

	@Column(name = "biom_pdmed_time", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_pdmed_time() {
		return this.biom_pdmed_time;
	}

	public void setBiom_pdmed_time(String biom_pdmed_time) {
		this.biom_pdmed_time = biom_pdmed_time;
	}
	private String biom_plasma;

	@Column(name = "biom_plasma", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_plasma() {
		return this.biom_plasma;
	}

	public void setBiom_plasma(String biom_plasma) {
		this.biom_plasma = biom_plasma;
	}
	private String biom_plasma_date_day;

	@Column(name = "biom_plasma_date_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_plasma_date_day() {
		return this.biom_plasma_date_day;
	}

	public void setBiom_plasma_date_day(String biom_plasma_date_day) {
		this.biom_plasma_date_day = biom_plasma_date_day;
	}
	private String biom_plasma_date_month;

	@Column(name = "biom_plasma_date_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_plasma_date_month() {
		return this.biom_plasma_date_month;
	}

	public void setBiom_plasma_date_month(String biom_plasma_date_month) {
		this.biom_plasma_date_month = biom_plasma_date_month;
	}
	private String biom_plasma_date_year;

	@Column(name = "biom_plasma_date_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_plasma_date_year() {
		return this.biom_plasma_date_year;
	}

	public void setBiom_plasma_date_year(String biom_plasma_date_year) {
		this.biom_plasma_date_year = biom_plasma_date_year;
	}
	private String biom_plasma_freeze_date_day;

	@Column(name = "biom_plasma_freeze_date_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_plasma_freeze_date_day() {
		return this.biom_plasma_freeze_date_day;
	}

	public void setBiom_plasma_freeze_date_day(String biom_plasma_freeze_date_day) {
		this.biom_plasma_freeze_date_day = biom_plasma_freeze_date_day;
	}
	private String biom_plasma_freeze_date_month;

	@Column(name = "biom_plasma_freeze_date_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_plasma_freeze_date_month() {
		return this.biom_plasma_freeze_date_month;
	}

	public void setBiom_plasma_freeze_date_month(String biom_plasma_freeze_date_month) {
		this.biom_plasma_freeze_date_month = biom_plasma_freeze_date_month;
	}
	private String biom_plasma_freeze_date_year;

	@Column(name = "biom_plasma_freeze_date_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_plasma_freeze_date_year() {
		return this.biom_plasma_freeze_date_year;
	}

	public void setBiom_plasma_freeze_date_year(String biom_plasma_freeze_date_year) {
		this.biom_plasma_freeze_date_year = biom_plasma_freeze_date_year;
	}
	private String biom_plasma_freeze_time;

	@Column(name = "biom_plasma_freeze_time", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_plasma_freeze_time() {
		return this.biom_plasma_freeze_time;
	}

	public void setBiom_plasma_freeze_time(String biom_plasma_freeze_time) {
		this.biom_plasma_freeze_time = biom_plasma_freeze_time;
	}
	private String biom_plasma_q;

	@Column(name = "biom_plasma_q", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_plasma_q() {
		return this.biom_plasma_q;
	}

	public void setBiom_plasma_q(String biom_plasma_q) {
		this.biom_plasma_q = biom_plasma_q;
	}
	private String biom_plasma_temp;

	@Column(name = "biom_plasma_temp", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_plasma_temp() {
		return this.biom_plasma_temp;
	}

	public void setBiom_plasma_temp(String biom_plasma_temp) {
		this.biom_plasma_temp = biom_plasma_temp;
	}
	private String biom_plasma_time;

	@Column(name = "biom_plasma_time", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_plasma_time() {
		return this.biom_plasma_time;
	}

	public void setBiom_plasma_time(String biom_plasma_time) {
		this.biom_plasma_time = biom_plasma_time;
	}
	private String biom_serum;

	@Column(name = "biom_serum", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_serum() {
		return this.biom_serum;
	}

	public void setBiom_serum(String biom_serum) {
		this.biom_serum = biom_serum;
	}
	private String biom_serum_date_day;

	@Column(name = "biom_serum_date_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_serum_date_day() {
		return this.biom_serum_date_day;
	}

	public void setBiom_serum_date_day(String biom_serum_date_day) {
		this.biom_serum_date_day = biom_serum_date_day;
	}
	private String biom_serum_date_month;

	@Column(name = "biom_serum_date_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_serum_date_month() {
		return this.biom_serum_date_month;
	}

	public void setBiom_serum_date_month(String biom_serum_date_month) {
		this.biom_serum_date_month = biom_serum_date_month;
	}
	private String biom_serum_date_year;

	@Column(name = "biom_serum_date_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_serum_date_year() {
		return this.biom_serum_date_year;
	}

	public void setBiom_serum_date_year(String biom_serum_date_year) {
		this.biom_serum_date_year = biom_serum_date_year;
	}
	private String biom_serum_freeze_date_day;

	@Column(name = "biom_serum_freeze_date_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_serum_freeze_date_day() {
		return this.biom_serum_freeze_date_day;
	}

	public void setBiom_serum_freeze_date_day(String biom_serum_freeze_date_day) {
		this.biom_serum_freeze_date_day = biom_serum_freeze_date_day;
	}
	private String biom_serum_freeze_date_month;

	@Column(name = "biom_serum_freeze_date_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_serum_freeze_date_month() {
		return this.biom_serum_freeze_date_month;
	}

	public void setBiom_serum_freeze_date_month(String biom_serum_freeze_date_month) {
		this.biom_serum_freeze_date_month = biom_serum_freeze_date_month;
	}
	private String biom_serum_freeze_date_year;

	@Column(name = "biom_serum_freeze_date_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_serum_freeze_date_year() {
		return this.biom_serum_freeze_date_year;
	}

	public void setBiom_serum_freeze_date_year(String biom_serum_freeze_date_year) {
		this.biom_serum_freeze_date_year = biom_serum_freeze_date_year;
	}
	private String biom_serum_freeze_time;

	@Column(name = "biom_serum_freeze_time", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_serum_freeze_time() {
		return this.biom_serum_freeze_time;
	}

	public void setBiom_serum_freeze_time(String biom_serum_freeze_time) {
		this.biom_serum_freeze_time = biom_serum_freeze_time;
	}
	private String biom_serum_q;

	@Column(name = "biom_serum_q", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_serum_q() {
		return this.biom_serum_q;
	}

	public void setBiom_serum_q(String biom_serum_q) {
		this.biom_serum_q = biom_serum_q;
	}
	private String biom_serum_temp;

	@Column(name = "biom_serum_temp", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_serum_temp() {
		return this.biom_serum_temp;
	}

	public void setBiom_serum_temp(String biom_serum_temp) {
		this.biom_serum_temp = biom_serum_temp;
	}
	private String biom_serum_time;

	@Column(name = "biom_serum_time", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_serum_time() {
		return this.biom_serum_time;
	}

	public void setBiom_serum_time(String biom_serum_time) {
		this.biom_serum_time = biom_serum_time;
	}
	private String biom_urine;

	@Column(name = "biom_urine", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_urine() {
		return this.biom_urine;
	}

	public void setBiom_urine(String biom_urine) {
		this.biom_urine = biom_urine;
	}
	private String biom_urine_date_day;

	@Column(name = "biom_urine_date_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_urine_date_day() {
		return this.biom_urine_date_day;
	}

	public void setBiom_urine_date_day(String biom_urine_date_day) {
		this.biom_urine_date_day = biom_urine_date_day;
	}
	private String biom_urine_date_month;

	@Column(name = "biom_urine_date_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_urine_date_month() {
		return this.biom_urine_date_month;
	}

	public void setBiom_urine_date_month(String biom_urine_date_month) {
		this.biom_urine_date_month = biom_urine_date_month;
	}
	private String biom_urine_date_year;

	@Column(name = "biom_urine_date_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_urine_date_year() {
		return this.biom_urine_date_year;
	}

	public void setBiom_urine_date_year(String biom_urine_date_year) {
		this.biom_urine_date_year = biom_urine_date_year;
	}
	private String biom_urine_q;

	@Column(name = "biom_urine_q", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_urine_q() {
		return this.biom_urine_q;
	}

	public void setBiom_urine_q(String biom_urine_q) {
		this.biom_urine_q = biom_urine_q;
	}
	private String biom_urine_time;

	@Column(name = "biom_urine_time", nullable = true, columnDefinition = "varchar", length = 128)
	public String getBiom_urine_time() {
		return this.biom_urine_time;
	}

	public void setBiom_urine_time(String biom_urine_time) {
		this.biom_urine_time = biom_urine_time;
	}

	public String getStatusColor() {
		// Проверяем, заполнены ли все поля и нет ли "not collected" в биоматериалах
		boolean allCompleted = areAllFieldsCompleted();
		boolean anyNotCollected = isAnyBiomaterialNotCollected();

		if (allCompleted && !anyNotCollected) {
			return "green"; // Все поля заполнены, и нет "not collected"
		} else if (anyNotCollected || isSomeFieldsCompleted()) {
			return "orange"; // Есть "not collected" или некоторые поля заполнены
		} else {
			return "blue"; // Ни одно поле не заполнено
		}
	}

	private boolean areAllFieldsCompleted() {
		// Проверяем, что все поля, которые должны отображаться, заполнены
		return isFieldCompleted(this.biom_edta) &&
				isFieldCompleted(this.biom_edta_date_day) &&
				isFieldCompleted(this.biom_edta_date_month) &&
				isFieldCompleted(this.biom_edta_date_year) &&
				isFieldCompleted(this.biom_edta_freeze_date_day) &&
				isFieldCompleted(this.biom_edta_freeze_date_month) &&
				isFieldCompleted(this.biom_edta_freeze_date_year) &&
				isFieldCompleted(this.biom_edta_freeze_time) &&
				(shouldDisplayField("biom_edta_q") ? isFieldCompleted(this.biom_edta_q) : true) &&
				isFieldCompleted(this.biom_edta_temp) &&
				isFieldCompleted(this.biom_edta_time) &&
				isFieldCompleted(this.biom_fasting) &&
				isFieldCompleted(this.biom_food_date_day) &&
				isFieldCompleted(this.biom_food_date_month) &&
				isFieldCompleted(this.biom_food_date_year) &&
				isFieldCompleted(this.biom_food_time) &&
				isFieldCompleted(this.biom_pax) &&
				isFieldCompleted(this.biom_pax_date_day) &&
				isFieldCompleted(this.biom_pax_date_month) &&
				isFieldCompleted(this.biom_pax_date_year) &&
				isFieldCompleted(this.biom_pax_freeze_time) &&
				(shouldDisplayField("biom_pax_q") ? isFieldCompleted(this.biom_pax_q) : true) &&
				isFieldCompleted(this.biom_pax_temp) &&
				isFieldCompleted(this.biom_pax_time) &&
				isFieldCompleted(this.biom_pax_time_date_day) &&
				isFieldCompleted(this.biom_pax_time_date_month) &&
				isFieldCompleted(this.biom_pax_time_date_year) &&
				isFieldCompleted(this.biom_pbmcs) &&
				isFieldCompleted(this.biom_pbmcs_date_day) &&
				isFieldCompleted(this.biom_pbmcs_date_month) &&
				isFieldCompleted(this.biom_pbmcs_date_year) &&
				isFieldCompleted(this.biom_pbmcs_freeze_date_day) &&
				isFieldCompleted(this.biom_pbmcs_freeze_date_month) &&
				isFieldCompleted(this.biom_pbmcs_freeze_date_year) &&
				isFieldCompleted(this.biom_pbmcs_freeze_time) &&
				(shouldDisplayField("biom_pbmcs_q") ? isFieldCompleted(this.biom_pbmcs_q) : true) &&
				isFieldCompleted(this.biom_pbmcs_temp) &&
				isFieldCompleted(this.biom_pbmcs_time) &&
				isFieldCompleted(this.biom_pdmed) &&
				isFieldCompleted(this.biom_pdmed_date_day) &&
				isFieldCompleted(this.biom_pdmed_date_month) &&
				isFieldCompleted(this.biom_pdmed_date_year) &&
				isFieldCompleted(this.biom_pdmed_time) &&
				isFieldCompleted(this.biom_plasma) &&
				isFieldCompleted(this.biom_plasma_date_day) &&
				isFieldCompleted(this.biom_plasma_date_month) &&
				isFieldCompleted(this.biom_plasma_date_year) &&
				isFieldCompleted(this.biom_plasma_freeze_date_day) &&
				isFieldCompleted(this.biom_plasma_freeze_date_month) &&
				isFieldCompleted(this.biom_plasma_freeze_date_year) &&
				isFieldCompleted(this.biom_plasma_freeze_time) &&
				(shouldDisplayField("biom_plasma_q") ? isFieldCompleted(this.biom_plasma_q) : true) &&
				isFieldCompleted(this.biom_plasma_temp) &&
				isFieldCompleted(this.biom_plasma_time) &&
				isFieldCompleted(this.biom_serum) &&
				isFieldCompleted(this.biom_serum_date_day) &&
				isFieldCompleted(this.biom_serum_date_month) &&
				isFieldCompleted(this.biom_serum_date_year) &&
				isFieldCompleted(this.biom_serum_freeze_date_day) &&
				isFieldCompleted(this.biom_serum_freeze_date_month) &&
				isFieldCompleted(this.biom_serum_freeze_date_year) &&
				isFieldCompleted(this.biom_serum_freeze_time) &&
				(shouldDisplayField("biom_serum_q") ? isFieldCompleted(this.biom_serum_q) : true) &&
				isFieldCompleted(this.biom_serum_temp) &&
				isFieldCompleted(this.biom_serum_time) &&
				isFieldCompleted(this.biom_urine) &&
				isFieldCompleted(this.biom_urine_date_day) &&
				isFieldCompleted(this.biom_urine_date_month) &&
				isFieldCompleted(this.biom_urine_date_year) &&
				(shouldDisplayField("biom_urine_q") ? isFieldCompleted(this.biom_urine_q) : true) &&
				isFieldCompleted(this.biom_urine_time);
	}

	private boolean isAnyBiomaterialNotCollected() {
		// Проверяем, есть ли хотя бы один биоматериал со значением "not collected"
		return "not collected".equals(this.biom_edta) ||
				"not collected".equals(this.biom_pax) ||
				"not collected".equals(this.biom_pbmcs) ||
				"not collected".equals(this.biom_plasma) ||
				"not collected".equals(this.biom_serum) ||
				"not collected".equals(this.biom_urine);
	}

	private boolean isSomeFieldsCompleted() {
		// Проверяем, заполнено ли хотя бы одно поле
		return isFieldCompleted(this.biom_edta) ||
				isFieldCompleted(this.biom_edta_date_day) ||
				isFieldCompleted(this.biom_edta_date_month) ||
				isFieldCompleted(this.biom_edta_date_year) ||
				isFieldCompleted(this.biom_edta_freeze_date_day) ||
				isFieldCompleted(this.biom_edta_freeze_date_month) ||
				isFieldCompleted(this.biom_edta_freeze_date_year) ||
				isFieldCompleted(this.biom_edta_freeze_time) ||
				isFieldCompleted(this.biom_edta_q) ||
				isFieldCompleted(this.biom_edta_temp) ||
				isFieldCompleted(this.biom_edta_time) ||
				isFieldCompleted(this.biom_fasting) ||
				isFieldCompleted(this.biom_food_date_day) ||
				isFieldCompleted(this.biom_food_date_month) ||
				isFieldCompleted(this.biom_food_date_year) ||
				isFieldCompleted(this.biom_food_time) ||
				isFieldCompleted(this.biom_pax) ||
				isFieldCompleted(this.biom_pax_date_day) ||
				isFieldCompleted(this.biom_pax_date_month) ||
				isFieldCompleted(this.biom_pax_date_year) ||
				isFieldCompleted(this.biom_pax_freeze_time) ||
				isFieldCompleted(this.biom_pax_q) ||
				isFieldCompleted(this.biom_pax_temp) ||
				isFieldCompleted(this.biom_pax_time) ||
				isFieldCompleted(this.biom_pax_time_date_day) ||
				isFieldCompleted(this.biom_pax_time_date_month) ||
				isFieldCompleted(this.biom_pax_time_date_year) ||
				isFieldCompleted(this.biom_pbmcs) ||
				isFieldCompleted(this.biom_pbmcs_date_day) ||
				isFieldCompleted(this.biom_pbmcs_date_month) ||
				isFieldCompleted(this.biom_pbmcs_date_year) ||
				isFieldCompleted(this.biom_pbmcs_freeze_date_day) ||
				isFieldCompleted(this.biom_pbmcs_freeze_date_month) ||
				isFieldCompleted(this.biom_pbmcs_freeze_date_year) ||
				isFieldCompleted(this.biom_pbmcs_freeze_time) ||
				isFieldCompleted(this.biom_pbmcs_q) ||
				isFieldCompleted(this.biom_pbmcs_temp) ||
				isFieldCompleted(this.biom_pbmcs_time) ||
				isFieldCompleted(this.biom_pdmed) ||
				isFieldCompleted(this.biom_pdmed_date_day) ||
				isFieldCompleted(this.biom_pdmed_date_month) ||
				isFieldCompleted(this.biom_pdmed_date_year) ||
				isFieldCompleted(this.biom_pdmed_time) ||
				isFieldCompleted(this.biom_plasma) ||
				isFieldCompleted(this.biom_plasma_date_day) ||
				isFieldCompleted(this.biom_plasma_date_month) ||
				isFieldCompleted(this.biom_plasma_date_year) ||
				isFieldCompleted(this.biom_plasma_freeze_date_day) ||
				isFieldCompleted(this.biom_plasma_freeze_date_month) ||
				isFieldCompleted(this.biom_plasma_freeze_date_year) ||
				isFieldCompleted(this.biom_plasma_freeze_time) ||
				isFieldCompleted(this.biom_plasma_q) ||
				isFieldCompleted(this.biom_plasma_temp) ||
				isFieldCompleted(this.biom_plasma_time) ||
				isFieldCompleted(this.biom_serum) ||
				isFieldCompleted(this.biom_serum_date_day) ||
				isFieldCompleted(this.biom_serum_date_month) ||
				isFieldCompleted(this.biom_serum_date_year) ||
				isFieldCompleted(this.biom_serum_freeze_date_day) ||
				isFieldCompleted(this.biom_serum_freeze_date_month) ||
				isFieldCompleted(this.biom_serum_freeze_date_year) ||
				isFieldCompleted(this.biom_serum_freeze_time) ||
				isFieldCompleted(this.biom_serum_q) ||
				isFieldCompleted(this.biom_serum_temp) ||
				isFieldCompleted(this.biom_serum_time) ||
				isFieldCompleted(this.biom_urine) ||
				isFieldCompleted(this.biom_urine_date_day) ||
				isFieldCompleted(this.biom_urine_date_month) ||
				isFieldCompleted(this.biom_urine_date_year) ||
				isFieldCompleted(this.biom_urine_q) ||
				isFieldCompleted(this.biom_urine_time);
}

	private boolean isFieldCompleted(String field) {
		// Проверяем, что поле не равно null и не пустое
		return field != null && !field.isEmpty();
	}

	private boolean shouldDisplayField(String fieldName) {
		// Логика проверки, должно ли поле отображаться на основе @Condition
		switch (fieldName) {
			case "biom_edta_q":
				return "smaller amount collected".equals(this.biom_edta);
			case "biom_pax_q":
				return "smaller amount collected".equals(this.biom_pax);
			case "biom_pbmcs_q":
				return "smaller amount collected".equals(this.biom_pbmcs);
			case "biom_plasma_q":
				return "smaller amount collected".equals(this.biom_plasma);
			case "biom_serum_q":
				return "smaller amount collected".equals(this.biom_serum);
			case "biom_urine_q":
				return "smaller amount collected".equals(this.biom_urine);
			default:
				return true; // По умолчанию поле отображается
		}
	}
}

//green if all items completed, orange if any of the biomaterials "not collected" OR if some but not all items complete, blue if no item completed
