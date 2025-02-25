package net.mdsgene.admin.generatedproject;
import java.util.Date;
import javax.persistence.*;
@Entity
@Table(name = "PINK1PRKN116", schema = "public")
@Cacheable(false)
public class PINK1PRKN116 implements java.io.Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PINK1PRKN116_id_seq")
    @SequenceGenerator(name="PINK1PRKN116_id_seq", sequenceName="PINK1PRKN116_id_seq", allocationSize=1)
	@Column(name = "id", unique = true, nullable = false, columnDefinition = "serial")
	private int id;

	public PINK1PRKN116() {
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

	private String pd_brady_onset;

	@Column(name = "pd_brady_onset", nullable = true, columnDefinition = "varchar", length = 128)
	public String getPd_brady_onset() {
		return this.pd_brady_onset;
	}

	public void setPd_brady_onset(String pd_brady_onset) {
		this.pd_brady_onset = pd_brady_onset;
	}
	private String pd_date_diag;

	@Column(name = "pd_date_diag", nullable = true, columnDefinition = "varchar", length = 128)
	public String getPd_date_diag() {
		return this.pd_date_diag;
	}

	public void setPd_date_diag(String pd_date_diag) {
		this.pd_date_diag = pd_date_diag;
	}
	private String pd_date_diag_day;

	@Column(name = "pd_date_diag_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getPd_date_diag_day() {
		return this.pd_date_diag_day;
	}

	public void setPd_date_diag_day(String pd_date_diag_day) {
		this.pd_date_diag_day = pd_date_diag_day;
	}
	private String pd_date_diag_month;

	@Column(name = "pd_date_diag_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getPd_date_diag_month() {
		return this.pd_date_diag_month;
	}

	public void setPd_date_diag_month(String pd_date_diag_month) {
		this.pd_date_diag_month = pd_date_diag_month;
	}
	private String pd_date_diag_year;

	@Column(name = "pd_date_diag_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getPd_date_diag_year() {
		return this.pd_date_diag_year;
	}

	public void setPd_date_diag_year(String pd_date_diag_year) {
		this.pd_date_diag_year = pd_date_diag_year;
	}
	private String pd_date_symp_day;

	@Column(name = "pd_date_symp_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getPd_date_symp_day() {
		return this.pd_date_symp_day;
	}

	public void setPd_date_symp_day(String pd_date_symp_day) {
		this.pd_date_symp_day = pd_date_symp_day;
	}
	private String pd_date_symp_month;

	@Column(name = "pd_date_symp_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getPd_date_symp_month() {
		return this.pd_date_symp_month;
	}

	public void setPd_date_symp_month(String pd_date_symp_month) {
		this.pd_date_symp_month = pd_date_symp_month;
	}
	private String pd_date_symp_year;

	@Column(name = "pd_date_symp_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getPd_date_symp_year() {
		return this.pd_date_symp_year;
	}

	public void setPd_date_symp_year(String pd_date_symp_year) {
		this.pd_date_symp_year = pd_date_symp_year;
	}
	private String pd_other_onset;

	@Column(name = "pd_other_onset", nullable = true, columnDefinition = "varchar", length = 128)
	public String getPd_other_onset() {
		return this.pd_other_onset;
	}

	public void setPd_other_onset(String pd_other_onset) {
		this.pd_other_onset = pd_other_onset;
	}
	private String pd_other_onset_yes;

	@Column(name = "pd_other_onset_yes", nullable = true, columnDefinition = "varchar", length = 128)
	public String getPd_other_onset_yes() {
		return this.pd_other_onset_yes;
	}

	public void setPd_other_onset_yes(String pd_other_onset_yes) {
		this.pd_other_onset_yes = pd_other_onset_yes;
	}
	private String pd_postinstab_onset;

	@Column(name = "pd_postinstab_onset", nullable = true, columnDefinition = "varchar", length = 128)
	public String getPd_postinstab_onset() {
		return this.pd_postinstab_onset;
	}

	public void setPd_postinstab_onset(String pd_postinstab_onset) {
		this.pd_postinstab_onset = pd_postinstab_onset;
	}
	private String pd_resttremor_onset;

	@Column(name = "pd_resttremor_onset", nullable = true, columnDefinition = "varchar", length = 128)
	public String getPd_resttremor_onset() {
		return this.pd_resttremor_onset;
	}

	public void setPd_resttremor_onset(String pd_resttremor_onset) {
		this.pd_resttremor_onset = pd_resttremor_onset;
	}
	private String pd_rigid_onset;

	@Column(name = "pd_rigid_onset", nullable = true, columnDefinition = "varchar", length = 128)
	public String getPd_rigid_onset() {
		return this.pd_rigid_onset;
	}

	public void setPd_rigid_onset(String pd_rigid_onset) {
		this.pd_rigid_onset = pd_rigid_onset;
	}
	private String pd_side_onset;

	@Column(name = "pd_side_onset", nullable = true, columnDefinition = "varchar", length = 128)
	public String getPd_side_onset() {
		return this.pd_side_onset;
	}

	public void setPd_side_onset(String pd_side_onset) {
		this.pd_side_onset = pd_side_onset;
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
		// Проверяем, что все обязательные поля заполнены
		return isFieldCompleted(this.pd_brady_onset) &&
				isFieldCompleted(this.pd_date_diag) &&
				isFieldCompleted(this.pd_date_diag_day) &&
				isFieldCompleted(this.pd_date_diag_month) &&
				isFieldCompleted(this.pd_date_diag_year) &&
				isFieldCompleted(this.pd_date_symp_day) &&
				isFieldCompleted(this.pd_date_symp_month) &&
				isFieldCompleted(this.pd_date_symp_year) &&
				isFieldCompleted(this.pd_other_onset) &&
				(shouldDisplayField("pd_other_onset_yes") ? isFieldCompleted(this.pd_other_onset_yes) : true) &&
				isFieldCompleted(this.pd_postinstab_onset) &&
				isFieldCompleted(this.pd_resttremor_onset) &&
				isFieldCompleted(this.pd_rigid_onset) &&
				isFieldCompleted(this.pd_side_onset);
	}

	private boolean isAtLeastOneFieldCompleted() {
		// Проверяем, заполнено ли хотя бы одно поле
		return isFieldCompleted(this.pd_brady_onset) ||
				isFieldCompleted(this.pd_date_diag) ||
				isFieldCompleted(this.pd_date_diag_day) ||
				isFieldCompleted(this.pd_date_diag_month) ||
				isFieldCompleted(this.pd_date_diag_year) ||
				isFieldCompleted(this.pd_date_symp_day) ||
				isFieldCompleted(this.pd_date_symp_month) ||
				isFieldCompleted(this.pd_date_symp_year) ||
				isFieldCompleted(this.pd_other_onset) ||
				isFieldCompleted(this.pd_other_onset_yes) ||
				isFieldCompleted(this.pd_postinstab_onset) ||
				isFieldCompleted(this.pd_resttremor_onset) ||
				isFieldCompleted(this.pd_rigid_onset) ||
				isFieldCompleted(this.pd_side_onset);
	}

	private boolean isFieldCompleted(String field) {
		// Проверяем, что поле не равно null и не пустое
		return field != null && !field.trim().isEmpty() && !field.trim().equals("-");
	}

	private boolean shouldDisplayField(String fieldName) {
		// Определяем, нужно ли отображать поле
		switch (fieldName) {
			case "pd_other_onset_yes":
				return "yes".equalsIgnoreCase(this.pd_other_onset);
			default:
				return true;
		}
	}


}

