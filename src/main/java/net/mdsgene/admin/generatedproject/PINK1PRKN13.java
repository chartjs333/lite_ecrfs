package net.mdsgene.admin.generatedproject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
@Entity
@Table(name = "PINK1PRKN13", schema = "public")
@Cacheable(false)
public class PINK1PRKN13 implements java.io.Serializable {
	private static final Logger logger = LoggerFactory.getLogger(PINK1PRKN12.class);


	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PINK1PRKN13_id_seq")
	@SequenceGenerator(name = "PINK1PRKN13_id_seq", sequenceName = "PINK1PRKN13_id_seq", allocationSize = 1)
	@Column(name = "id", unique = true, nullable = false, columnDefinition = "serial")
	private int id;

	public PINK1PRKN13() {
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

	private String ae;

	@Column(name = "ae", nullable = true, columnDefinition = "varchar", length = 128)
	public String getAe() {
		return this.ae;
	}

	public void setAe(String ae) {
		this.ae = ae;
	}

	private String ae_primout;

	@Column(name = "ae_primout", nullable = true, columnDefinition = "varchar", length = 128)
	public String getAe_primout() {
		return this.ae_primout;
	}

	public void setAe_primout(String ae_primout) {
		this.ae_primout = ae_primout;
	}

	private String ae_serious;

	@Column(name = "ae_serious", nullable = true, columnDefinition = "varchar", length = 128)
	public String getAe_serious() {
		return this.ae_serious;
	}

	public void setAe_serious(String ae_serious) {
		this.ae_serious = ae_serious;
	}

	private String ae_sev;

	@Column(name = "ae_sev", nullable = true, columnDefinition = "varchar", length = 128)
	public String getAe_sev() {
		return this.ae_sev;
	}

	public void setAe_sev(String ae_sev) {
		this.ae_sev = ae_sev;
	}

	private String ae_start1_day;

	@Column(name = "ae_start1_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getAe_start1_day() {
		return this.ae_start1_day;
	}

	public void setAe_start1_day(String ae_start1_day) {
		this.ae_start1_day = ae_start1_day;
	}

	private String ae_start1_month;

	@Column(name = "ae_start1_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getAe_start1_month() {
		return this.ae_start1_month;
	}

	public void setAe_start1_month(String ae_start1_month) {
		this.ae_start1_month = ae_start1_month;
	}

	private String ae_start1_year;

	@Column(name = "ae_start1_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getAe_start1_year() {
		return this.ae_start1_year;
	}

	public void setAe_start1_year(String ae_start1_year) {
		this.ae_start1_year = ae_start1_year;
	}

	private String ae_stop1_day;

	@Column(name = "ae_stop1_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getAe_stop1_day() {
		return this.ae_stop1_day;
	}

	public void setAe_stop1_day(String ae_stop1_day) {
		this.ae_stop1_day = ae_stop1_day;
	}

	private String ae_stop1_month;

	@Column(name = "ae_stop1_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getAe_stop1_month() {
		return this.ae_stop1_month;
	}

	public void setAe_stop1_month(String ae_stop1_month) {
		this.ae_stop1_month = ae_stop1_month;
	}

	private String ae_stop1_year;

	@Column(name = "ae_stop1_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getAe_stop1_year() {
		return this.ae_stop1_year;
	}

	public void setAe_stop1_year(String ae_stop1_year) {
		this.ae_stop1_year = ae_stop1_year;
	}

	private String ae_studrel;

	@Column(name = "ae_studrel", nullable = true, columnDefinition = "varchar", length = 128)
	public String getAe_studrel() {
		return this.ae_studrel;
	}

	public void setAe_studrel(String ae_studrel) {
		this.ae_studrel = ae_studrel;
	}

	private String ae_term1;

	@Column(name = "ae_term1", nullable = true, columnDefinition = "varchar", length = 128)
	public String getAe_term1() {
		return this.ae_term1;
	}

	public void setAe_term1(String ae_term1) {
		this.ae_term1 = ae_term1;
	}


	public String getStatusColor() {
		// Add null check within the field evaluation logic
		if (!isAnyFieldCompleted()) {
			return "blue"; // Default if no fields are populated
		}

		String trimmedAe = (this.ae != null) ? this.ae.trim() : "";

		if ("2".equals(trimmedAe)) {
			return "green";
		} else if ("1".equals(trimmedAe)) {
			if (areAllRequiredFieldsCompleted()) {
				return "green";
			} else {
				return "orange";
			}
		} else {
			return "blue"; // Default fallback color
		}
	}

	// Required field completion check with null safety improvements
	private boolean areAllRequiredFieldsCompleted() {
		return isFilled(this.ae_primout)
				&& isFilled(this.ae_serious)
				&& isFilled(this.ae_sev)
				&& isFilled(this.ae_start1_day)
				&& isFilled(this.ae_start1_month)
				&& isFilled(this.ae_start1_year)
				&& isFilled(this.ae_stop1_day)
				&& isFilled(this.ae_stop1_month)
				&& isFilled(this.ae_stop1_year)
				&& isFilled(this.ae_studrel)
				&& isFilled(this.ae_term1);
	}

	// Evaluates if any field is at least completed
	private boolean isAnyFieldCompleted() {
		return isFilled(this.ae)
				|| isFilled(this.ae_primout)
				|| isFilled(this.ae_serious)
				|| isFilled(this.ae_sev)
				|| isFilled(this.ae_start1_day)
				|| isFilled(this.ae_start1_month)
				|| isFilled(this.ae_start1_year)
				|| isFilled(this.ae_stop1_day)
				|| isFilled(this.ae_stop1_month)
				|| isFilled(this.ae_stop1_year)
				|| isFilled(this.ae_studrel)
				|| isFilled(this.ae_term1);
	}

	// Utility method to check if a string is non-null and not empty.
	private boolean isFilled(String value) {
		return value != null && !value.trim().isEmpty() && !value.trim().equals("-");
	}
}