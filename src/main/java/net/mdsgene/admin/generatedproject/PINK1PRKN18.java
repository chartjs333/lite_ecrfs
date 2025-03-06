package net.mdsgene.admin.generatedproject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;


@Entity
@Table(name = "PINK1PRKN18", schema = "public")
@Cacheable(false)
public class PINK1PRKN18 implements java.io.Serializable {

	private static final Logger log = LoggerFactory.getLogger(PINK1PRKN18.class);

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PINK1PRKN18_id_seq")
    @SequenceGenerator(name="PINK1PRKN18_id_seq", sequenceName="PINK1PRKN18_id_seq", allocationSize=1)
	@Column(name = "id", unique = true, nullable = false, columnDefinition = "serial")
	private int id;

	public PINK1PRKN18() {
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

	private String cond_cat_1;

	@Column(name = "cond_cat_1", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_cat_1() {
		return this.cond_cat_1;
	}

	public void setCond_cat_1(String cond_cat_1) {
		this.cond_cat_1 = cond_cat_1;
	}
	private String cond_cat_10;

	@Column(name = "cond_cat_10", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_cat_10() {
		return this.cond_cat_10;
	}

	public void setCond_cat_10(String cond_cat_10) {
		this.cond_cat_10 = cond_cat_10;
	}
	private String cond_cat_10_dr_all;

	@Column(name = "cond_cat_10_dr_all", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_cat_10_dr_all() {
		return this.cond_cat_10_dr_all;
	}

	public void setCond_cat_10_dr_all(String cond_cat_10_dr_all) {
		this.cond_cat_10_dr_all = cond_cat_10_dr_all;
	}
	private String cond_cat_10_oth;

	@Column(name = "cond_cat_10_oth", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_cat_10_oth() {
		return this.cond_cat_10_oth;
	}

	public void setCond_cat_10_oth(String cond_cat_10_oth) {
		this.cond_cat_10_oth = cond_cat_10_oth;
	}
	private String cond_cat_1_dr_all;

	@Column(name = "cond_cat_1_dr_all", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_cat_1_dr_all() {
		return this.cond_cat_1_dr_all;
	}

	public void setCond_cat_1_dr_all(String cond_cat_1_dr_all) {
		this.cond_cat_1_dr_all = cond_cat_1_dr_all;
	}
	private String cond_cat_1_oth;

	@Column(name = "cond_cat_1_oth", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_cat_1_oth() {
		return this.cond_cat_1_oth;
	}

	public void setCond_cat_1_oth(String cond_cat_1_oth) {
		this.cond_cat_1_oth = cond_cat_1_oth;
	}
	private String cond_cat_2;

	@Column(name = "cond_cat_2", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_cat_2() {
		return this.cond_cat_2;
	}

	public void setCond_cat_2(String cond_cat_2) {
		this.cond_cat_2 = cond_cat_2;
	}
	private String cond_cat_2_dr_all;

	@Column(name = "cond_cat_2_dr_all", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_cat_2_dr_all() {
		return this.cond_cat_2_dr_all;
	}

	public void setCond_cat_2_dr_all(String cond_cat_2_dr_all) {
		this.cond_cat_2_dr_all = cond_cat_2_dr_all;
	}
	private String cond_cat_2_oth;

	@Column(name = "cond_cat_2_oth", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_cat_2_oth() {
		return this.cond_cat_2_oth;
	}

	public void setCond_cat_2_oth(String cond_cat_2_oth) {
		this.cond_cat_2_oth = cond_cat_2_oth;
	}
	private String cond_cat_3;

	@Column(name = "cond_cat_3", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_cat_3() {
		return this.cond_cat_3;
	}

	public void setCond_cat_3(String cond_cat_3) {
		this.cond_cat_3 = cond_cat_3;
	}
	private String cond_cat_3_dr_all;

	@Column(name = "cond_cat_3_dr_all", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_cat_3_dr_all() {
		return this.cond_cat_3_dr_all;
	}

	public void setCond_cat_3_dr_all(String cond_cat_3_dr_all) {
		this.cond_cat_3_dr_all = cond_cat_3_dr_all;
	}
	private String cond_cat_3_oth;

	@Column(name = "cond_cat_3_oth", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_cat_3_oth() {
		return this.cond_cat_3_oth;
	}

	public void setCond_cat_3_oth(String cond_cat_3_oth) {
		this.cond_cat_3_oth = cond_cat_3_oth;
	}
	private String cond_cat_4;

	@Column(name = "cond_cat_4", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_cat_4() {
		return this.cond_cat_4;
	}

	public void setCond_cat_4(String cond_cat_4) {
		this.cond_cat_4 = cond_cat_4;
	}
	private String cond_cat_4_dr_all;

	@Column(name = "cond_cat_4_dr_all", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_cat_4_dr_all() {
		return this.cond_cat_4_dr_all;
	}

	public void setCond_cat_4_dr_all(String cond_cat_4_dr_all) {
		this.cond_cat_4_dr_all = cond_cat_4_dr_all;
	}
	private String cond_cat_4_oth;

	@Column(name = "cond_cat_4_oth", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_cat_4_oth() {
		return this.cond_cat_4_oth;
	}

	public void setCond_cat_4_oth(String cond_cat_4_oth) {
		this.cond_cat_4_oth = cond_cat_4_oth;
	}
	private String cond_cat_5;

	@Column(name = "cond_cat_5", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_cat_5() {
		return this.cond_cat_5;
	}

	public void setCond_cat_5(String cond_cat_5) {
		this.cond_cat_5 = cond_cat_5;
	}
	private String cond_cat_5_dr_all;

	@Column(name = "cond_cat_5_dr_all", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_cat_5_dr_all() {
		return this.cond_cat_5_dr_all;
	}

	public void setCond_cat_5_dr_all(String cond_cat_5_dr_all) {
		this.cond_cat_5_dr_all = cond_cat_5_dr_all;
	}
	private String cond_cat_5_oth;

	@Column(name = "cond_cat_5_oth", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_cat_5_oth() {
		return this.cond_cat_5_oth;
	}

	public void setCond_cat_5_oth(String cond_cat_5_oth) {
		this.cond_cat_5_oth = cond_cat_5_oth;
	}
	private String cond_cat_6;

	@Column(name = "cond_cat_6", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_cat_6() {
		return this.cond_cat_6;
	}

	public void setCond_cat_6(String cond_cat_6) {
		this.cond_cat_6 = cond_cat_6;
	}
	private String cond_cat_6_dr_all;

	@Column(name = "cond_cat_6_dr_all", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_cat_6_dr_all() {
		return this.cond_cat_6_dr_all;
	}

	public void setCond_cat_6_dr_all(String cond_cat_6_dr_all) {
		this.cond_cat_6_dr_all = cond_cat_6_dr_all;
	}
	private String cond_cat_6_oth;

	@Column(name = "cond_cat_6_oth", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_cat_6_oth() {
		return this.cond_cat_6_oth;
	}

	public void setCond_cat_6_oth(String cond_cat_6_oth) {
		this.cond_cat_6_oth = cond_cat_6_oth;
	}
	private String cond_cat_7;

	@Column(name = "cond_cat_7", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_cat_7() {
		return this.cond_cat_7;
	}

	public void setCond_cat_7(String cond_cat_7) {
		this.cond_cat_7 = cond_cat_7;
	}
	private String cond_cat_7_dr_all;

	@Column(name = "cond_cat_7_dr_all", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_cat_7_dr_all() {
		return this.cond_cat_7_dr_all;
	}

	public void setCond_cat_7_dr_all(String cond_cat_7_dr_all) {
		this.cond_cat_7_dr_all = cond_cat_7_dr_all;
	}
	private String cond_cat_7_oth;

	@Column(name = "cond_cat_7_oth", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_cat_7_oth() {
		return this.cond_cat_7_oth;
	}

	public void setCond_cat_7_oth(String cond_cat_7_oth) {
		this.cond_cat_7_oth = cond_cat_7_oth;
	}
	private String cond_cat_8;

	@Column(name = "cond_cat_8", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_cat_8() {
		return this.cond_cat_8;
	}

	public void setCond_cat_8(String cond_cat_8) {
		this.cond_cat_8 = cond_cat_8;
	}
	private String cond_cat_8_dr_all;

	@Column(name = "cond_cat_8_dr_all", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_cat_8_dr_all() {
		return this.cond_cat_8_dr_all;
	}

	public void setCond_cat_8_dr_all(String cond_cat_8_dr_all) {
		this.cond_cat_8_dr_all = cond_cat_8_dr_all;
	}
	private String cond_cat_8_oth;

	@Column(name = "cond_cat_8_oth", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_cat_8_oth() {
		return this.cond_cat_8_oth;
	}

	public void setCond_cat_8_oth(String cond_cat_8_oth) {
		this.cond_cat_8_oth = cond_cat_8_oth;
	}
	private String cond_cat_9;

	@Column(name = "cond_cat_9", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_cat_9() {
		return this.cond_cat_9;
	}

	public void setCond_cat_9(String cond_cat_9) {
		this.cond_cat_9 = cond_cat_9;
	}
	private String cond_cat_9_dr_all;

	@Column(name = "cond_cat_9_dr_all", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_cat_9_dr_all() {
		return this.cond_cat_9_dr_all;
	}

	public void setCond_cat_9_dr_all(String cond_cat_9_dr_all) {
		this.cond_cat_9_dr_all = cond_cat_9_dr_all;
	}
	private String cond_cat_9_oth;

	@Column(name = "cond_cat_9_oth", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_cat_9_oth() {
		return this.cond_cat_9_oth;
	}

	public void setCond_cat_9_oth(String cond_cat_9_oth) {
		this.cond_cat_9_oth = cond_cat_9_oth;
	}
	private String cond_dat_10_day;

	@Column(name = "cond_dat_10_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_dat_10_day() {
		return this.cond_dat_10_day;
	}

	public void setCond_dat_10_day(String cond_dat_10_day) {
		this.cond_dat_10_day = cond_dat_10_day;
	}
	private String cond_dat_10_month;

	@Column(name = "cond_dat_10_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_dat_10_month() {
		return this.cond_dat_10_month;
	}

	public void setCond_dat_10_month(String cond_dat_10_month) {
		this.cond_dat_10_month = cond_dat_10_month;
	}
	private String cond_dat_10_year;

	@Column(name = "cond_dat_10_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_dat_10_year() {
		return this.cond_dat_10_year;
	}

	public void setCond_dat_10_year(String cond_dat_10_year) {
		this.cond_dat_10_year = cond_dat_10_year;
	}
	private String cond_dat_1_day;

	@Column(name = "cond_dat_1_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_dat_1_day() {
		return this.cond_dat_1_day;
	}

	public void setCond_dat_1_day(String cond_dat_1_day) {
		this.cond_dat_1_day = cond_dat_1_day;
	}
	private String cond_dat_1_month;

	@Column(name = "cond_dat_1_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_dat_1_month() {
		return this.cond_dat_1_month;
	}

	public void setCond_dat_1_month(String cond_dat_1_month) {
		this.cond_dat_1_month = cond_dat_1_month;
	}
	private String cond_dat_1_year;

	@Column(name = "cond_dat_1_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_dat_1_year() {
		return this.cond_dat_1_year;
	}

	public void setCond_dat_1_year(String cond_dat_1_year) {
		this.cond_dat_1_year = cond_dat_1_year;
	}
	private String cond_dat_2_day;

	@Column(name = "cond_dat_2_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_dat_2_day() {
		return this.cond_dat_2_day;
	}

	public void setCond_dat_2_day(String cond_dat_2_day) {
		this.cond_dat_2_day = cond_dat_2_day;
	}
	private String cond_dat_2_month;

	@Column(name = "cond_dat_2_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_dat_2_month() {
		return this.cond_dat_2_month;
	}

	public void setCond_dat_2_month(String cond_dat_2_month) {
		this.cond_dat_2_month = cond_dat_2_month;
	}
	private String cond_dat_2_year;

	@Column(name = "cond_dat_2_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_dat_2_year() {
		return this.cond_dat_2_year;
	}

	public void setCond_dat_2_year(String cond_dat_2_year) {
		this.cond_dat_2_year = cond_dat_2_year;
	}
	private String cond_dat_3_day;

	@Column(name = "cond_dat_3_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_dat_3_day() {
		return this.cond_dat_3_day;
	}

	public void setCond_dat_3_day(String cond_dat_3_day) {
		this.cond_dat_3_day = cond_dat_3_day;
	}
	private String cond_dat_3_month;

	@Column(name = "cond_dat_3_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_dat_3_month() {
		return this.cond_dat_3_month;
	}

	public void setCond_dat_3_month(String cond_dat_3_month) {
		this.cond_dat_3_month = cond_dat_3_month;
	}
	private String cond_dat_3_year;

	@Column(name = "cond_dat_3_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_dat_3_year() {
		return this.cond_dat_3_year;
	}

	public void setCond_dat_3_year(String cond_dat_3_year) {
		this.cond_dat_3_year = cond_dat_3_year;
	}
	private String cond_dat_4_day;

	@Column(name = "cond_dat_4_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_dat_4_day() {
		return this.cond_dat_4_day;
	}

	public void setCond_dat_4_day(String cond_dat_4_day) {
		this.cond_dat_4_day = cond_dat_4_day;
	}
	private String cond_dat_4_month;

	@Column(name = "cond_dat_4_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_dat_4_month() {
		return this.cond_dat_4_month;
	}

	public void setCond_dat_4_month(String cond_dat_4_month) {
		this.cond_dat_4_month = cond_dat_4_month;
	}
	private String cond_dat_4_year;

	@Column(name = "cond_dat_4_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_dat_4_year() {
		return this.cond_dat_4_year;
	}

	public void setCond_dat_4_year(String cond_dat_4_year) {
		this.cond_dat_4_year = cond_dat_4_year;
	}
	private String cond_dat_5_day;

	@Column(name = "cond_dat_5_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_dat_5_day() {
		return this.cond_dat_5_day;
	}

	public void setCond_dat_5_day(String cond_dat_5_day) {
		this.cond_dat_5_day = cond_dat_5_day;
	}
	private String cond_dat_5_month;

	@Column(name = "cond_dat_5_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_dat_5_month() {
		return this.cond_dat_5_month;
	}

	public void setCond_dat_5_month(String cond_dat_5_month) {
		this.cond_dat_5_month = cond_dat_5_month;
	}
	private String cond_dat_5_year;

	@Column(name = "cond_dat_5_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_dat_5_year() {
		return this.cond_dat_5_year;
	}

	public void setCond_dat_5_year(String cond_dat_5_year) {
		this.cond_dat_5_year = cond_dat_5_year;
	}
	private String cond_dat_6_day;

	@Column(name = "cond_dat_6_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_dat_6_day() {
		return this.cond_dat_6_day;
	}

	public void setCond_dat_6_day(String cond_dat_6_day) {
		this.cond_dat_6_day = cond_dat_6_day;
	}
	private String cond_dat_6_month;

	@Column(name = "cond_dat_6_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_dat_6_month() {
		return this.cond_dat_6_month;
	}

	public void setCond_dat_6_month(String cond_dat_6_month) {
		this.cond_dat_6_month = cond_dat_6_month;
	}
	private String cond_dat_6_year;

	@Column(name = "cond_dat_6_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_dat_6_year() {
		return this.cond_dat_6_year;
	}

	public void setCond_dat_6_year(String cond_dat_6_year) {
		this.cond_dat_6_year = cond_dat_6_year;
	}
	private String cond_dat_7_day;

	@Column(name = "cond_dat_7_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_dat_7_day() {
		return this.cond_dat_7_day;
	}

	public void setCond_dat_7_day(String cond_dat_7_day) {
		this.cond_dat_7_day = cond_dat_7_day;
	}
	private String cond_dat_7_month;

	@Column(name = "cond_dat_7_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_dat_7_month() {
		return this.cond_dat_7_month;
	}

	public void setCond_dat_7_month(String cond_dat_7_month) {
		this.cond_dat_7_month = cond_dat_7_month;
	}
	private String cond_dat_7_year;

	@Column(name = "cond_dat_7_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_dat_7_year() {
		return this.cond_dat_7_year;
	}

	public void setCond_dat_7_year(String cond_dat_7_year) {
		this.cond_dat_7_year = cond_dat_7_year;
	}
	private String cond_dat_8_day;

	@Column(name = "cond_dat_8_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_dat_8_day() {
		return this.cond_dat_8_day;
	}

	public void setCond_dat_8_day(String cond_dat_8_day) {
		this.cond_dat_8_day = cond_dat_8_day;
	}
	private String cond_dat_8_month;

	@Column(name = "cond_dat_8_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_dat_8_month() {
		return this.cond_dat_8_month;
	}

	public void setCond_dat_8_month(String cond_dat_8_month) {
		this.cond_dat_8_month = cond_dat_8_month;
	}
	private String cond_dat_8_year;

	@Column(name = "cond_dat_8_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_dat_8_year() {
		return this.cond_dat_8_year;
	}

	public void setCond_dat_8_year(String cond_dat_8_year) {
		this.cond_dat_8_year = cond_dat_8_year;
	}
	private String cond_dat_9_day;

	@Column(name = "cond_dat_9_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_dat_9_day() {
		return this.cond_dat_9_day;
	}

	public void setCond_dat_9_day(String cond_dat_9_day) {
		this.cond_dat_9_day = cond_dat_9_day;
	}
	private String cond_dat_9_month;

	@Column(name = "cond_dat_9_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_dat_9_month() {
		return this.cond_dat_9_month;
	}

	public void setCond_dat_9_month(String cond_dat_9_month) {
		this.cond_dat_9_month = cond_dat_9_month;
	}
	private String cond_dat_9_year;

	@Column(name = "cond_dat_9_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_dat_9_year() {
		return this.cond_dat_9_year;
	}

	public void setCond_dat_9_year(String cond_dat_9_year) {
		this.cond_dat_9_year = cond_dat_9_year;
	}
	private String cond_dx_1;

	@Column(name = "cond_dx_1", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_dx_1() {
		return this.cond_dx_1;
	}

	public void setCond_dx_1(String cond_dx_1) {
		this.cond_dx_1 = cond_dx_1;
	}
	private String cond_dx_10;

	@Column(name = "cond_dx_10", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_dx_10() {
		return this.cond_dx_10;
	}

	public void setCond_dx_10(String cond_dx_10) {
		this.cond_dx_10 = cond_dx_10;
	}
	private String cond_dx_2;

	@Column(name = "cond_dx_2", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_dx_2() {
		return this.cond_dx_2;
	}

	public void setCond_dx_2(String cond_dx_2) {
		this.cond_dx_2 = cond_dx_2;
	}
	private String cond_dx_3;

	@Column(name = "cond_dx_3", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_dx_3() {
		return this.cond_dx_3;
	}

	public void setCond_dx_3(String cond_dx_3) {
		this.cond_dx_3 = cond_dx_3;
	}
	private String cond_dx_4;

	@Column(name = "cond_dx_4", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_dx_4() {
		return this.cond_dx_4;
	}

	public void setCond_dx_4(String cond_dx_4) {
		this.cond_dx_4 = cond_dx_4;
	}
	private String cond_dx_5;

	@Column(name = "cond_dx_5", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_dx_5() {
		return this.cond_dx_5;
	}

	public void setCond_dx_5(String cond_dx_5) {
		this.cond_dx_5 = cond_dx_5;
	}
	private String cond_dx_6;

	@Column(name = "cond_dx_6", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_dx_6() {
		return this.cond_dx_6;
	}

	public void setCond_dx_6(String cond_dx_6) {
		this.cond_dx_6 = cond_dx_6;
	}
	private String cond_dx_7;

	@Column(name = "cond_dx_7", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_dx_7() {
		return this.cond_dx_7;
	}

	public void setCond_dx_7(String cond_dx_7) {
		this.cond_dx_7 = cond_dx_7;
	}
	private String cond_dx_8;

	@Column(name = "cond_dx_8", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_dx_8() {
		return this.cond_dx_8;
	}

	public void setCond_dx_8(String cond_dx_8) {
		this.cond_dx_8 = cond_dx_8;
	}
	private String cond_dx_9;

	@Column(name = "cond_dx_9", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_dx_9() {
		return this.cond_dx_9;
	}

	public void setCond_dx_9(String cond_dx_9) {
		this.cond_dx_9 = cond_dx_9;
	}
	private String cond_res_1;

	@Column(name = "cond_res_1", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_res_1() {
		return this.cond_res_1;
	}

	public void setCond_res_1(String cond_res_1) {
		this.cond_res_1 = cond_res_1;
	}
	private String cond_res_10;

	@Column(name = "cond_res_10", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_res_10() {
		return this.cond_res_10;
	}

	public void setCond_res_10(String cond_res_10) {
		this.cond_res_10 = cond_res_10;
	}
	private String cond_res_2;

	@Column(name = "cond_res_2", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_res_2() {
		return this.cond_res_2;
	}

	public void setCond_res_2(String cond_res_2) {
		this.cond_res_2 = cond_res_2;
	}
	private String cond_res_3;

	@Column(name = "cond_res_3", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_res_3() {
		return this.cond_res_3;
	}

	public void setCond_res_3(String cond_res_3) {
		this.cond_res_3 = cond_res_3;
	}
	private String cond_res_4;

	@Column(name = "cond_res_4", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_res_4() {
		return this.cond_res_4;
	}

	public void setCond_res_4(String cond_res_4) {
		this.cond_res_4 = cond_res_4;
	}
	private String cond_res_5;

	@Column(name = "cond_res_5", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_res_5() {
		return this.cond_res_5;
	}

	public void setCond_res_5(String cond_res_5) {
		this.cond_res_5 = cond_res_5;
	}
	private String cond_res_6;

	@Column(name = "cond_res_6", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_res_6() {
		return this.cond_res_6;
	}

	public void setCond_res_6(String cond_res_6) {
		this.cond_res_6 = cond_res_6;
	}
	private String cond_res_7;

	@Column(name = "cond_res_7", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_res_7() {
		return this.cond_res_7;
	}

	public void setCond_res_7(String cond_res_7) {
		this.cond_res_7 = cond_res_7;
	}
	private String cond_res_8;

	@Column(name = "cond_res_8", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_res_8() {
		return this.cond_res_8;
	}

	public void setCond_res_8(String cond_res_8) {
		this.cond_res_8 = cond_res_8;
	}
	private String cond_res_9;

	@Column(name = "cond_res_9", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_res_9() {
		return this.cond_res_9;
	}

	public void setCond_res_9(String cond_res_9) {
		this.cond_res_9 = cond_res_9;
	}
	private String cond_res_dat_10_day;

	@Column(name = "cond_res_dat_10_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_res_dat_10_day() {
		return this.cond_res_dat_10_day;
	}

	public void setCond_res_dat_10_day(String cond_res_dat_10_day) {
		this.cond_res_dat_10_day = cond_res_dat_10_day;
	}
	private String cond_res_dat_10_month;

	@Column(name = "cond_res_dat_10_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_res_dat_10_month() {
		return this.cond_res_dat_10_month;
	}

	public void setCond_res_dat_10_month(String cond_res_dat_10_month) {
		this.cond_res_dat_10_month = cond_res_dat_10_month;
	}
	private String cond_res_dat_10_year;

	@Column(name = "cond_res_dat_10_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_res_dat_10_year() {
		return this.cond_res_dat_10_year;
	}

	public void setCond_res_dat_10_year(String cond_res_dat_10_year) {
		this.cond_res_dat_10_year = cond_res_dat_10_year;
	}
	private String cond_res_dat_1_day;

	@Column(name = "cond_res_dat_1_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_res_dat_1_day() {
		return this.cond_res_dat_1_day;
	}

	public void setCond_res_dat_1_day(String cond_res_dat_1_day) {
		this.cond_res_dat_1_day = cond_res_dat_1_day;
	}
	private String cond_res_dat_1_month;

	@Column(name = "cond_res_dat_1_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_res_dat_1_month() {
		return this.cond_res_dat_1_month;
	}

	public void setCond_res_dat_1_month(String cond_res_dat_1_month) {
		this.cond_res_dat_1_month = cond_res_dat_1_month;
	}
	private String cond_res_dat_1_year;

	@Column(name = "cond_res_dat_1_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_res_dat_1_year() {
		return this.cond_res_dat_1_year;
	}

	public void setCond_res_dat_1_year(String cond_res_dat_1_year) {
		this.cond_res_dat_1_year = cond_res_dat_1_year;
	}
	private String cond_res_dat_2_day;

	@Column(name = "cond_res_dat_2_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_res_dat_2_day() {
		return this.cond_res_dat_2_day;
	}

	public void setCond_res_dat_2_day(String cond_res_dat_2_day) {
		this.cond_res_dat_2_day = cond_res_dat_2_day;
	}
	private String cond_res_dat_2_month;

	@Column(name = "cond_res_dat_2_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_res_dat_2_month() {
		return this.cond_res_dat_2_month;
	}

	public void setCond_res_dat_2_month(String cond_res_dat_2_month) {
		this.cond_res_dat_2_month = cond_res_dat_2_month;
	}
	private String cond_res_dat_2_year;

	@Column(name = "cond_res_dat_2_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_res_dat_2_year() {
		return this.cond_res_dat_2_year;
	}

	public void setCond_res_dat_2_year(String cond_res_dat_2_year) {
		this.cond_res_dat_2_year = cond_res_dat_2_year;
	}
	private String cond_res_dat_3_day;

	@Column(name = "cond_res_dat_3_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_res_dat_3_day() {
		return this.cond_res_dat_3_day;
	}

	public void setCond_res_dat_3_day(String cond_res_dat_3_day) {
		this.cond_res_dat_3_day = cond_res_dat_3_day;
	}
	private String cond_res_dat_3_month;

	@Column(name = "cond_res_dat_3_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_res_dat_3_month() {
		return this.cond_res_dat_3_month;
	}

	public void setCond_res_dat_3_month(String cond_res_dat_3_month) {
		this.cond_res_dat_3_month = cond_res_dat_3_month;
	}
	private String cond_res_dat_3_year;

	@Column(name = "cond_res_dat_3_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_res_dat_3_year() {
		return this.cond_res_dat_3_year;
	}

	public void setCond_res_dat_3_year(String cond_res_dat_3_year) {
		this.cond_res_dat_3_year = cond_res_dat_3_year;
	}
	private String cond_res_dat_4_day;

	@Column(name = "cond_res_dat_4_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_res_dat_4_day() {
		return this.cond_res_dat_4_day;
	}

	public void setCond_res_dat_4_day(String cond_res_dat_4_day) {
		this.cond_res_dat_4_day = cond_res_dat_4_day;
	}
	private String cond_res_dat_4_month;

	@Column(name = "cond_res_dat_4_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_res_dat_4_month() {
		return this.cond_res_dat_4_month;
	}

	public void setCond_res_dat_4_month(String cond_res_dat_4_month) {
		this.cond_res_dat_4_month = cond_res_dat_4_month;
	}
	private String cond_res_dat_4_year;

	@Column(name = "cond_res_dat_4_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_res_dat_4_year() {
		return this.cond_res_dat_4_year;
	}

	public void setCond_res_dat_4_year(String cond_res_dat_4_year) {
		this.cond_res_dat_4_year = cond_res_dat_4_year;
	}
	private String cond_res_dat_5_day;

	@Column(name = "cond_res_dat_5_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_res_dat_5_day() {
		return this.cond_res_dat_5_day;
	}

	public void setCond_res_dat_5_day(String cond_res_dat_5_day) {
		this.cond_res_dat_5_day = cond_res_dat_5_day;
	}
	private String cond_res_dat_5_month;

	@Column(name = "cond_res_dat_5_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_res_dat_5_month() {
		return this.cond_res_dat_5_month;
	}

	public void setCond_res_dat_5_month(String cond_res_dat_5_month) {
		this.cond_res_dat_5_month = cond_res_dat_5_month;
	}
	private String cond_res_dat_5_year;

	@Column(name = "cond_res_dat_5_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_res_dat_5_year() {
		return this.cond_res_dat_5_year;
	}

	public void setCond_res_dat_5_year(String cond_res_dat_5_year) {
		this.cond_res_dat_5_year = cond_res_dat_5_year;
	}
	private String cond_res_dat_6_day;

	@Column(name = "cond_res_dat_6_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_res_dat_6_day() {
		return this.cond_res_dat_6_day;
	}

	public void setCond_res_dat_6_day(String cond_res_dat_6_day) {
		this.cond_res_dat_6_day = cond_res_dat_6_day;
	}
	private String cond_res_dat_6_month;

	@Column(name = "cond_res_dat_6_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_res_dat_6_month() {
		return this.cond_res_dat_6_month;
	}

	public void setCond_res_dat_6_month(String cond_res_dat_6_month) {
		this.cond_res_dat_6_month = cond_res_dat_6_month;
	}
	private String cond_res_dat_6_year;

	@Column(name = "cond_res_dat_6_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_res_dat_6_year() {
		return this.cond_res_dat_6_year;
	}

	public void setCond_res_dat_6_year(String cond_res_dat_6_year) {
		this.cond_res_dat_6_year = cond_res_dat_6_year;
	}
	private String cond_res_dat_7_day;

	@Column(name = "cond_res_dat_7_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_res_dat_7_day() {
		return this.cond_res_dat_7_day;
	}

	public void setCond_res_dat_7_day(String cond_res_dat_7_day) {
		this.cond_res_dat_7_day = cond_res_dat_7_day;
	}
	private String cond_res_dat_7_month;

	@Column(name = "cond_res_dat_7_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_res_dat_7_month() {
		return this.cond_res_dat_7_month;
	}

	public void setCond_res_dat_7_month(String cond_res_dat_7_month) {
		this.cond_res_dat_7_month = cond_res_dat_7_month;
	}
	private String cond_res_dat_7_year;

	@Column(name = "cond_res_dat_7_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_res_dat_7_year() {
		return this.cond_res_dat_7_year;
	}

	public void setCond_res_dat_7_year(String cond_res_dat_7_year) {
		this.cond_res_dat_7_year = cond_res_dat_7_year;
	}
	private String cond_res_dat_8_day;

	@Column(name = "cond_res_dat_8_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_res_dat_8_day() {
		return this.cond_res_dat_8_day;
	}

	public void setCond_res_dat_8_day(String cond_res_dat_8_day) {
		this.cond_res_dat_8_day = cond_res_dat_8_day;
	}
	private String cond_res_dat_8_month;

	@Column(name = "cond_res_dat_8_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_res_dat_8_month() {
		return this.cond_res_dat_8_month;
	}

	public void setCond_res_dat_8_month(String cond_res_dat_8_month) {
		this.cond_res_dat_8_month = cond_res_dat_8_month;
	}
	private String cond_res_dat_8_year;

	@Column(name = "cond_res_dat_8_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_res_dat_8_year() {
		return this.cond_res_dat_8_year;
	}

	public void setCond_res_dat_8_year(String cond_res_dat_8_year) {
		this.cond_res_dat_8_year = cond_res_dat_8_year;
	}
	private String cond_res_dat_9_day;

	@Column(name = "cond_res_dat_9_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_res_dat_9_day() {
		return this.cond_res_dat_9_day;
	}

	public void setCond_res_dat_9_day(String cond_res_dat_9_day) {
		this.cond_res_dat_9_day = cond_res_dat_9_day;
	}
	private String cond_res_dat_9_month;

	@Column(name = "cond_res_dat_9_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_res_dat_9_month() {
		return this.cond_res_dat_9_month;
	}

	public void setCond_res_dat_9_month(String cond_res_dat_9_month) {
		this.cond_res_dat_9_month = cond_res_dat_9_month;
	}
	private String cond_res_dat_9_year;

	@Column(name = "cond_res_dat_9_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCond_res_dat_9_year() {
		return this.cond_res_dat_9_year;
	}

	public void setCond_res_dat_9_year(String cond_res_dat_9_year) {
		this.cond_res_dat_9_year = cond_res_dat_9_year;
	}


	public String getStatusColor() {
		// Проверяем, заполнены ли все обязательные поля
		boolean allCompleted = areAllFieldsCompleted();

		// Если все обязательные поля заполнены -> green
		if (allCompleted) {
			return "green";
		}
		// Если заполнено хотя бы одно поле -> orange
		else if (isAtLeastOneFieldCompleted()) {
			return "orange";
		}
		// Если ни одно поле не заполнено -> blue
		else {
			return "blue";
		}
	}

	/**
	 * Проверяет, заполнены ли все обязательные поля.
	 * Если все обязательные поля заполнены -> true, иначе -> false.
	 */
	private boolean areAllFieldsCompleted() {
		boolean mainFieldsCompleted = true;
		int count = 0;

		for (int i = 1; i <= 10; i++) {
			if (!isAtLeastOneFieldCompleted(i)) {
				continue;
			}
			count++;
			// Основные поля, которые всегда должны быть заполнены
			if (isEmpty(getFieldValue("cond_cat_" + i)) ||
					isEmpty(getFieldValue("cond_dx_" + i)) ||
					isEmpty(getFieldValue("cond_res_" + i))) {
				log.info("Обязательное поле cond_cat_" + i + " или cond_dx_" + i + " или cond_res_" + i + " не заполнено");
				mainFieldsCompleted = false;
			}

			// Проверка зависимых полей для категорий (Allergy/Other)
			if ("Allergy/Immunologic – Please note drug allergies=116".equals(getFieldValue("cond_cat_" + i))) { // Allergy/Immunologic
				if (isEmpty(getFieldValue("cond_cat_" + i + "_dr_all"))) {
					log.info("Поле cond_cat_" + i + "_dr_all не заполнено, хотя выбрана категория Allergy/Immunologic");
					mainFieldsCompleted = false;
				}
			}
			if ("Other".equals(getFieldValue("cond_cat_" + i))) { // Other
				if (isEmpty(getFieldValue("cond_cat_" + i + "_oth"))) {
					log.info("Поле cond_cat_" + i + "_oth не заполнено, хотя выбрана категория Other");
					mainFieldsCompleted = false;
				}
			}

			// Проверка зависимых полей для даты разрешения (если resolved == yes)
			if ("1".equals(getFieldValue("cond_res_" + i))) {
				if (isEmpty(getFieldValue("cond_res_dat_" + i + "_year")) ||
						isEmpty(getFieldValue("cond_res_dat_" + i + "_month")) ||
						isEmpty(getFieldValue("cond_res_dat_" + i + "_day"))) {
					log.info("Поле cond_res_dat_" + i + "_year или month или day не заполнено, хотя cond_res_" + i + " == yes");
					mainFieldsCompleted = false;
				}
			}
		}

		return mainFieldsCompleted && count > 0;
	}

	/**
	 * Проверяет, заполнено ли хотя бы одно из полей.
	 */
	private boolean isAtLeastOneFieldCompleted() {
		for (int i = 1; i <= 10; i++) {
			if (!isEmpty(getFieldValue("cond_cat_" + i)) ||
					!isEmpty(getFieldValue("cond_dx_" + i)) ||
					!isEmpty(getFieldValue("cond_res_" + i)) ||
					!isEmpty(getFieldValue("cond_res_dat_" + i + "_year")) ||
					!isEmpty(getFieldValue("cond_res_dat_" + i + "_month")) ||
					!isEmpty(getFieldValue("cond_res_dat_" + i + "_day")) ||
					!isEmpty(getFieldValue("cond_cat_" + i + "_dr_all")) ||
					!isEmpty(getFieldValue("cond_cat_" + i + "_oth"))) {
				return true;
			}
		}
		return false;
	}

	private boolean isAtLeastOneFieldCompleted(int i) {
		if (!isEmpty(getFieldValue("cond_cat_" + i)) ||
				!isEmpty(getFieldValue("cond_dx_" + i)) ||
				!isEmpty(getFieldValue("cond_res_" + i)) ||
				!isEmpty(getFieldValue("cond_res_dat_" + i + "_year")) ||
				!isEmpty(getFieldValue("cond_res_dat_" + i + "_month")) ||
				!isEmpty(getFieldValue("cond_res_dat_" + i + "_day")) ||
				!isEmpty(getFieldValue("cond_cat_" + i + "_dr_all")) ||
				!isEmpty(getFieldValue("cond_cat_" + i + "_oth"))) {
			return true;
		}
		return false;
	}

	/**
	 * Получает значение поля по имени.
	 */
	private String getFieldValue(String fieldName) {
		try {
			Field field = this.getClass().getDeclaredField(fieldName);
			field.setAccessible(true);
			return (String) field.get(this);
		} catch (NoSuchFieldException | IllegalAccessException e) {
			log.warn("Ошибка при доступе к полю: " + fieldName);
			return null;
		}
	}

	/**
	 * Проверяет, является ли поле пустым.
	 */
	private boolean isEmpty(String value) {
		return value == null || value.trim().isEmpty() || value.trim().equals("-");
	}
}


